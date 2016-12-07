/**
 * DISCLAIMER
 * <p>
 * This java code consisting in a java enumeration, hereafter <b>The Code</b>, has been prepared by <b>St&eacute;phane Coutant</b>, 
 * hereafter <b>The Author</b>, who is the owner of <b>The Code</b> therein.
 * <p>
 * Permission is hereby granted to use <b>The Code</b> for both private and commercial usage, subject to the following conditions: 
 * <ul>
 * 	<li>(i) that <b>The Author</b> shall not have any responsibility or liability whatsoever to any other party from the use or 
 * publication of <b>The Code</b>;
 * 	<li>(ii) that one cannot rely on the accuracy or finality of <b>The Code</b>; 
 * 	<li>(iii) that the willingness of <b>The Author</b> to provide the <b>The Code</b> does not in any way convey or imply any 
 * responsibility for any product or service using <b>The Code</b> and <b>The Author</b> specifically disclaims any such responsibility 
 * to any party;
 *  <li>and (iv) that <b>The Code</b> package domain name <code>org.iso4j</code> refers to a fake domain created for the need of publication 
 *  of <b>The Code>/b> on public repository and should not be used as is (the user of <b>The Code</b> should rather copy the content in 
 *  own project with own package naming policy). In any case, <b>The Author</b> disclaims any responsibility in case this domain name 
 *  enters or may enter in collision with any registered domain, past or future.
 * </ul> 
 * <p>
 * Implementation of <b>The Code</b> may require licenses under third party intellectual property rights, including without limitation, 
 * patent rights. <b>The Author</b> is not, and shall not be held responsible in any manner for identifying or failing to identify any 
 * or all such third party intellectual property rights.
 * <p>
 * <b>The Code</b> is provided "AS IS", "WHERE IS" and "WITH ALL FAULTS", and <b>The Author</b> makes any warranty of any kind, 
 * express or implied, including any implied warranties of merchantability, non-infringement of third party intellectual property rights 
 * (whether or not <b>The Author</b> has been advised, has reason to know, or is otherwise in fact aware of any information), 
 * and fitness for a particular purpose (including any errors and omissions in <b>The Code</b>).
 * <p>
 * To the extent permitted by applicable law, <b>The Author</b> shall not be liable to any user of <b>The Code</b> for any damages 
 * (other than direct actual out-of-pocket damages) under any theory of law, including, without limitation, any special, consequential, 
 * incidental, or punitive damages, nor any damages for loss of business profits, business interruption, loss of business information, or
 * other monetary loss, nor any damages arising out of third party claims (including claims of intellectual property infringement) 
 * arising out of the use of or inability to use <b>The Code</b>, even if advised of the possibility of such damages.
 * <p>
 * <b>The Code</b> may be subject to export or import regulations in different countries.
 * Any user of <b>The Code</b> agrees to comply strictly with all such regulations and acknowledges that it has the
 * responsibility to obtain licenses to export, re-export, or import <b>The Code</b>.
 * <p>
 */

package org.iso4j;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * <code>ICurrencies</code> is an interface wrapping the ISO 4217 currency codes as a java enumeration with access methods to various
 * information pertaining to a currency, such as local currency name, symbol and utility methods to get an amount expressed with symbol.
 * <p>
 * Input source (R) [fr|es|en].wikipedia.org/wiki/ISO_4217 and unicode from https://www.branah.com/unicode-converter.  
 * <p>
 * @author St&eacute;phane Coutant (fra)
 */

public interface ICurrencies {

	/** The standard ISO 4217 Currency norm. */
    public enum Iso4217CurrencyCode {                    
    	
    	// SYNTAX
    	// ISO (code, name, symbol, alternate symbol, Latin symbol, unicode, sign position before amount)
    	//
    	// NOTE
		// Alternate symbol and Latin form may be null if currency symbol is in Latin CharSet.

    	
        /* AALAND ISLAND, ANDORRA, AUSTRIA, BELGIUM, CYPRUS, ESTONIA, FINLAND, FRANCE, FRENCH GUIANA, FRENCH SOUTHERN TERRITORIES (THE), GERMANY, GREECE */
        /* GUADELOUPE, HOLY SEE (THE), IRELAND, ITALY, LATVIA, LITHUANIA, LUXEMBOURG, MALTA, MARTINIQUE, MAYOTTE, MONACO, MONTENEGRO,  NETHERLANDS (THE) */
        /* PORTUGAL, RÉUNION, SAINT BARTHÉLEMY, SAINT MARTIN (FRENCH PART), SAINT PIERRE AND MIQUELON, SAN MARINO, SLOVAKIA, SLOVENIA, SPAIN */
                                                            EUR (978, "Euro", "€", null, null, "\u20AC", false, true),
        /* AFGHANISTAN */                                   AFN (971, "Afghani", "؋", null, "Afs", "\u060B", false, false),
        /* ALBANIA */	                                    ALL (8, "Lek", "L", null, null, "\u004C", false, true),
        /* ALGERIA */	                                    DZD (12, "Algerian Dinar", "د.ج", null, "DA", "\u062F\u002E\\u062C", false, true), // unicode is for Arabic dal.djim
        /* UNITED STATES OF AMERICA (THE), AMERICAN SAMOA, BRITISH INDIAN OCEAN TERRITORY (THE), ECUADOR, GUAM, HAITI, MARSHALL ISLANDS (THE), PALAU, PANAMA */
        /* PUERTO RICO, EL SALVADOR, TIMOR-LESTE, VIRGIN ISLANDS (BRITISH), VIRGIN ISLANDS (U.S.), MICRONESIA (FEDERATED STATES OF) */
        /* NORTHERN MARIANA ISLANDS (THE), BONAIRE, SINT EUSTATIUS AND SABA, TURKS AND CAICOS ISLANDS (THE), UNITED STATES MINOR OUTLYING ISLANDS (THE) */
                                                            USD (840, "US Dollar", "$", null, null, "\u0024", true, false),
        /* ANGOLA */	                                    AOA (973, "Kwanza", "Kz", null, null, "\u004B\u007A", false, true),
        /* ANGUILLA, ANTIGUA AND BARBUDA, DOMINICA, GRENADA, MONTSERRAT, SAINT KITTS AND NEVIS, SAINT LUCIA, SAINT VINCENT AND THE GRENADINES */
                                                            XCD (951, "East Caribbean Dollar", "$", "EC$", null, "\u0024", true, false),
        /* ANTARCTICA                                       No universal currency */
        /* ARGENTINA */                                     ARS (32, "Argentine Peso", "$", null, null, "\u0024", true, true),
        /* ARMENIA */                                       AMD (51, "Armenian Dram", "�?", null, null, "\u058F", false, true), 
        /* ARUBA */	                                        AWG (533, "Aruban Florin", "Afl.", null, null, "\u0041\u0066\u006C", false, false),
        /* AUSTRALIA, CHRISTMAS ISLAND, COCOS (KEELING) ISLANDS (THE), HEARD ISLAND AND McDONALD ISLANDS, KIRIBATI, NAURU, NORFOLK ISLAND, TUVALU  */
                                                            AUD (36, "Australian Dollar", "$", "A$", null, "\u0024", true, false),
        /* AZERBAIJAN */	                                AZN (31, "Azerbaijanian Manat", null, null, null, "\u20BC", false, true),
        /* BAHAMAS (THE) */	                                BSD (44, "Bahamian Dollar", "$02E", "B$", null, "\u0024", true, false),
        /* BAHRAIN */	                                    BHD (48, "Bahraini Dinar", ".د.ب", null, "BD", "\u002E\u062F\u002E\u0628", false, false), // unicode is for Arabic ba.dal.
        /* BANGLADESH */	                                BDT (50, "Taka","৳", null, "Tk", "\u09F3", true, false),
        /* BARBADOS */	                                    BBD (52, "Barbados Dollar", "$", "Bds$", null, "\u0024", true, false),
        /* BELARUS */	                                    BYN (974, "Belarussian Ruble", "Br", null, null, "\u0042\u0072", true, true),
        /* BELIZE */	                                    BZD (84, "Belize Dollar", "$", "BZ$", null, "\u0024", true, false),
        /* BENIN, BURKINA FASO, CÔTE D'IVOIRE, GUINEA-BISSAU, MALI, NIGER (THE), SENEGAL, TOGO */
                                                            XOF (952, "CFA Franc BCEAO", "CFA", null, null, "\u0043\u0046\u0041", false, false),
        /* BERMUDA */                                       BMD (60, "Bermudian Dollar", "$", "BD$", null, "\u0024", true, false),
        /* BHUTAN */	                                    BTN (64, "Ngultrum", "Nu.", null, null, "\u004C\u0075", true, false),
        /* BOLIVIA (PLURINATIONAL STATE OF) */              BOB (68, "Boliviano", "Bs.", null, null, "\0042\0073\u002E", true, true),
        /* BOSNIA AND HERZEGOVINA */                        BAM (977, "Convertible Mark", "KM", null, null, "\u004B\u004D", false, true),
        /* BOTSWANA */	                                    BWP (72, "Pula", "P", null, null, "\u0050", true, false),
        /* NORWAY, BOUVET ISLAND, SVALBARD AND JAN MAYEN */ NOK (578, "Norwegian Krone", "kr", null, null, "\u006B\u0072", false, true),
        /* BRAZIL */	                                    BRL (986, "Brazilian Real", "R$", null, null, "\u0052\u0024", true, true),
        /* BRUNEI DARUSSALAM */	                            BND (96, "Brunei Dollar", "$", "B$", null, "\u0024", true, false),
        /* BULGARIA	*/                                      BGN (975, "Bulgarian Lev", "лв", null, null, "\u041B\u0412", false, true), // unicode is for Cyrillic Elle Vé, upper case
        /* BURUNDI */	                                    BIF (108, "Burundi Franc", "FBu", null, null, "\u0046\u0042\u0075", false, false),
        /* CAPE VERDE */                                    CVE (132, "Cabo Verde Escudo", "$", "Esc", null, "\u0024", true, false),
        /* CAMBODIA */	                                    KHR (116, "Riel", "៛", null, null, "\u17DB", true, false),
        /* CAMEROON, CENTRAL AFRICAN REPUBLIC (THE), CHAD, CONGO, EQUATORIAL GUINEA, GABON */
                                                            XAF (950, "CFA Franc BEAC", "FCFA", null, null, "\u0046\u0043\u0046\u0041", false, true),
        /* CANADA */	                                    CAD (124, "Canadian Dollar", "$", "Can$", null, "\u0024", true, false),
        /* CAYMAN ISLANDS (THE) */	                        KYD (136, "Cayman Islands Dollar", "$", "CI$", null, "\u0024", true, false),
        /* CHILE */                                         CLP (152, "Chilean Peso", "$", "CLP$", null, "\u0024", true, true),
        /* CHINA */	                                        CNY (156, "Yuan Renminbi", "¥", null, null, "\u00A5", true, false),
        /* COLOMBIA	*/                                      COP (170, "Colombian Peso", "$", "COL$", null, "\u0024", true, true),
        /* COMOROS (THE) */	                                KMF (174, "Comoro Franc", "CF", "F", null, "\u0043\u0046", false, false),
        /* CONGO (THE DEMOCRATIC REPUBLIC OF THE) */        CDF (976, "Congolese Franc", "CF", "FC", null, "\u0043\u0046", false, false),
        /* NEW ZEALAND, COOK ISLANDS (THE), NIUE, PITCAIRN, TOKELAU */
                                                            NZD (554, "New Zealand Dollar", "$", "NZ$", null, "\u0024", true, false),
        /* COSTA RICA */	                                CRC (188, "Costa Rican Colon", "₡", null, null, "\u20A1", true, true),
        /* CROATIA */	                                    HRK (191, "Kuna", "Kn", null, null, "\u004B\u006E", false, true),
        /* CUBA */	                                        CUP (192, "Cuban Peso", "$", "$MN", null, "\u0024", true, true),
                                                            CUC (931, "Peso Convertible", "$", "$CUC", null, "\u0024", true, true),
        /* CURAÇAO, SINT MAARTEN (DUTCH PART) */	        ANG (532, "Netherlands Antillean Guilder", "ƒ", "NAf", null, "\u0192", false, false),
        /* CZECH REPUBLIC (THE) */	                        CZK (203, "Czech Koruna", "K�?", null, null, "\u004b\u010d", false, true),
        /* DENMARK, FAROE ISLANDS (THE), GREENLAND */       DKK (208, "Danish Krone", "kr", "Dkr", null, "\u006B\u0072", false, true),
        /* DJIBOUTI */	                                    DJF (262, "Djibouti Franc", "Fdj", "DF", null, "\u0046\u0064\u006A", false, false),
        /* DOMINICAN REPUBLIC (THE) */	                    DOP (214, "Dominican Peso", "$",	"RD$", null, "\u0024", true, false),
        /* EGYPT */                                         EGP (818, "Egyptian Pound", "ج.م.", null, "E£", "\u062c\u002e\u0645\u002e", true, false),  // unicode for djim . mîm .
        /* ERITREA */	                                    ERN (232, "Nakfa", null, null, "Nfk", "\u1293\u1245\u134B", false, false), // unicode for Ethiopian syllab na qe fa (sign does not render))
        /* ETHIOPIA	 */                                     ETB (230, "Ethiopian Birr", null, null, "Br", "\u1265\u122D", false, false), // unicode Ethiopian syllab be re (sign does not render)
        /* FALKLAND ISLANDS (THE) [MALVINAS] */             FKP (238, "Falkland Islands Pound", "£", "FK£", null, "\u00A3", true, false),
        /* FIJI */	                                        FJD (242, "Fiji Dollar", "$", "FJ$", null, "\u0024", true, false),
        /* FRENCH POLYNESIA, NEW CALEDONIA, WALLIS AND FUTUNA */
                                                            XPF (953, "CFP Franc", "CFP", null, null, "\u0043\u0046\u0050", false, false),
        /* GAMBIA (THE) */                                  GMD (270, "Dalasi", "D", null, null, "\u0044", false, false),
        /* GEORGIA */	                                    GEL (981, "Lari", "₾", null, null, "\u20BE", false, true), 
        /* GHANA */	                                        GHS (288, "Ghana Cedi", "₵", "GH₵", null, "\u20B5", true, false),
        /* GIBRALTAR */	                                    GIP (292, "Gibraltar Pound", "£", null, null, "\u00A3", true, false),
        /* GUATEMALA */	                                    GTQ (320, "Quetzal", "Q", null, null, "\u0051", true, false),
        /* UNITED KINGDOM OF GREAT BRITAIN AND NORTHERN IRELAND (THE), GUERNSEY, ISLE OF MAN, JERSEY, BRITISH INDIAN OCEAN TERRITORY, SOUTH GEORGIA AND THE SOUTH SANDWICH ISLANDS */
                                                            GBP (826, "Pound Sterling", "£", null, null, "\u00A3", true, false),
        /* GUINEA */	                                    GNF (324, "Guinea Franc", "FG", "GFr", null, "\u0047\u0048", false, false),
        /* GUYANA */	                                    GYD (328, "Guyana Dollar", "$", "G$", null, "\u0024", true, false),
        /* HAITI */	                                        HTG (332, "Gourde", "G", null, null, "\u0048", false, false),
        /* HONDURAS */	                                    HNL (340, "Lempira","L", null, null, "\u004C", true, false),
        /* HONG KONG */	                                    HKD (344, "Hong Kong Dollar", "$", "HK$", null, "\u0024", true, false),
        /* HUNGARY */	                                    HUF (348, "Forint", "Ft", null, null, "\u0046\u0074", false, true),
        /* ICELAND */	                                    ISK (352, "Iceland Krona", "kr", "�?kr", null, "\u006B\u0072", false, true),
        /* INDIA, BHUTAN */                                 INR (356, "Indian Rupee", "₹", null, "Rs", "\u20B9", true, false), // various other symbols ರೂ, രൂ, ৳, ૱, రూ, ௹, र�?(\u0cb0\u0cc2\u002c \u0d30\u0d42\u002c \u09f3\u002c \u0af1\u002c \u0c30\u0c42\u002c \u0bf9\u002c \u0930\u0941)
        /* INDONESIA */	                                    IDR (360, "Rupiah", "Rp", null, null, "\u0052\u0070", true, true),
        /* IRAN (ISLAMIC REPUBLIC OF) */                    IRR (364, "Iranian Rial", "﷼", null, null, "\uFDFC", false, false),
        /* IRAQ */	                                        IQD (368, "Iraqi Dinar", "ع.د", null, null, "\u0639\u002e\u062f", false, false), // unicode is for Arabic dal.'aîn
        /* ISRAEL */	                                    ILS (376, "New Israeli Sheqel", "₪", "NIS", null, "\u20AA", true, false),
        /* JAMAICA */	                                    JMD (388, "Jamaican Dollar", "$", "J$", null, "\u0024", true, false),
        /* JAPAN */	                                        JPY (392, "Yen", "¥", null, null, "\u00A5", true, false),
        /* JORDAN */	                                    JOD (400, "Jordanian Dinar", "د.ك", null, "JD", "\u004A\u0044", false, false),
        /* KAZAKHSTAN */                                    KZT (398, "Tenge", "₸", null, null, "\u20B8", false, true),
        /* KENYA */	                                        KES (404, "Kenyan Shilling", "Ksh", "KSh", null, "\u0054\u0073\u0068", false, false),
        /* KOREA (THE DEMOCRATIC PEOPLE’S REPUBLIC OF) */   KPW (408, "North Korean Won", "₩", null, null, "\u20A9", true, false),
        /* KOREA (THE REPUBLIC OF) */                       KRW (410, "Won", "₩", null, null, "\u20A9", true, false),
        /* KUWAIT */	                                    KWD (414, "Kuwaiti Dinar", "د.ك", "K.D.", null, "\u004B\u002E\u0044\u002E", false, false),
        /* KYRGYZSTAN */	                                KGS (417, "Som", "�?ом", null, null, "\u0431\u043E\u043C", false, true), // "�?ом", no symbol, unicode is for Cyrillic Esse 0 Emme lower case
        /* LAO PEOPLE’S DEMOCRATIC REPUBLIC (THE) */	    LAK (418, "Kip", "₭", "₭N", null, "\u20AD", false, false),
        /* LEBANON */	                                    LBP (422, "Lebanese Pound", "ل.ل", null, "LL", "\u0644\u002E\u0644", false, true), // unicode is for Arabic lam.lam
        /* LESOTHO */	                                    LSL (426, "Loti", "M", null, null, "\u004D", true, false), // M is for maloti, plural of loti
        /* SOUTH AFRICA, LESOTHO, NAMIBIA */                ZAR (710, "Rand", "R", null, null, "\u0052", true, true),
        /* LIBERIA */	                                    LRD (430, "Liberian Dollar", "$", "L$", null, "\u0024", true, false),
        /* LIBYA */	                                        LYD (434, "Libyan Dinar", "ل.د", null, "LD", "\u0644\u002E\u062F", false, false), // unicode is for Arabic lam.dal
        /* SWITZERLAND, LIECHTENSTEIN */                    CHF (756, "Swiss Franc", "Fr", "SFr", null, "\u0046\u0072", false, true),
        /* MACAU */	                                        MOP (446, "Pataca", "MOP$", null, null, "\u004D\u004F\u0050\u0024", true, true),
        /* MACEDONIA (THE FORMER YUGOSLAV REPUBLIC OF) */	MKD (807, "Denar", "ден", null, "den", "\u0434\u0435\u043D", false, true), // "ден", no symbol, unicode is for Cyrillic Dé Lé Enne lower case
        /* MADAGASCAR */                                    MGA (450, "Malagasy Ariary", "Ar", null, null, "\u0041\u0072", true, false),
        /* MALAWI */	                                    MWK (454, "Malawi Kwacha", "MK", null, null, "\u004D\u004B", true, false),
        /* MALAYSIA */	                                    MYR (458, "Malaysian Ringgit", "RM", null, null, "\u0052\u004D", true, false),
        /* MALDIVES */	                                    MVR (462, "Rufiyaa", "Rf.", "ރ", null, "\u0052\u0066\u002E", true, false),
        /* MAURITANIA */	                                MRO (478, "Ouguiya", "UM", null, null, "\u0055\u004D", false, false),
        /* MAURITIUS */	                                    MUR (480, "Mauritius Rupee", "₨", null, null, "\u20A8", true, false),
        /* MEXICO */	                                    MXN (484, "Mexican Peso", "$", "Mex$", null, "\u0024", true, false),
        /* MOLDOVA THE REPUBLIC OF) */                      MDL	(498, "Moldovan Leu", "lei", null, null, "\u006C\u0065\u0069", false, true), // lei is the plural of leu
        /* MONGOLIA */	                                    MNT (496, "Tugrik", "₮", null, null, "\u20AE", false, true),
        /* MOROCCO, WESTERN SAHARA */	                    MAD (504, "Moroccan Dirham", "د.م", null, "DH", "\u062F\u002e\u0645", false, true), // unicode is for Arabic dal.mïm
        /* MOZAMBIQUE */	                                MZN (508, "Mozambique Metical", "MT", "MTn", null, "\u004D\u0054", false, true),
        /* MYANMAR */	                                    MMK (104, "Kyat", "K", null, null, "\u004B", true, false),
        /* NAMIBIA */	                                    NAD (516, "Namibia Dollar", "$", "N$", null, "\u0024", true, true),
        /* NEPAL */	                                        NPR (524, "Nepalese Rupee", "₨", "NRs", "Rs", "\u20A8", true, false),
        /* NICARAGUA */	                                    NIO (558, "Cordoba Oro", "C$", null, null, "\u0040\u0024", true, false),
        /* NIGERIA */	                                    NGN (566, "Naira", "₦", null, null, "\u20A6", true, false),
        /* OMAN */	                                        OMR (512, "Rial Omani", "ر.ع.", null, null, "\u0631\u002E\u0639\u002E", false, false), // unicode is for Arabic ra.'aïn.
        /* PAKISTAN */	                                    PKR (586, "Pakistan Rupee", "₨", null, null, "\u20A8", true, false),
        /* PALESTINE, STATE OF                              No universal currency */
        /* PANAMA */	                                    PAB (590, "Balboa", "B/.", null, null, "\u0041\u002F\u002E", true, false),
        /* PAPUA NEW GUINEA */	                            PGK (598, "Kina", "K", null, null, "\u004B", false, false),
        /* PARAGUAY */	                                    PYG (600, "Guarani", "₲", null, null, "\u20B2", false, true),
        /* PERU */	                                        PEN (604, "Sol", "S/", null, null, "\u0053\u002F", false, true),
        /* PHILIPPINES (THE) */	                            PHP (608, "Philippine Peso", "₱", "P", null, "\u20B1", true, false),
        /* POLAND */	                                    PLN (985, "Zloty", "zł", null, null, "\u007A\u0142", false, true),
        /* QATAR */	                                        QAR (634, "Qatari Rial", "ر.ق", null, "QR", "\u0631\u002E\u0642", false, false), // unicode for Arabic ra.qaf
        /* ROMANIA */	                                    RON (642, "Romanian Leu", "lei", null, null, "\u006C\u0065\u0069", false, true), // lei is the plural of leu
        /* RUSSIAN FEDERATION (THE) */	                    RUB (643, "Russian Ruble", null, "R", null, "\u20BD", false, true),
        /* RWANDA */	                                    RWF (646, "Rwanda Franc", "FRw", "RF", null, "\u0046\u0052\u0077", false, false),
        /* SAINT HELENA, ASCENSION AND TRISTAN DA CUNHA */	SHP (654, "Saint Helena Pound", "£", null, null, "\u00A3", true, false),
        /* SAMOA */	                                        WST (882, "Samoan t�?l�?", "WS$", "T", null, "\u0057\u0053\u0024", true, false),
        /* SAO TOME AND PRINCIPE */	                        STD (678, "Dobra", "Db", null, null, "\u0044\u0062", false, false),
        /* SAUDI ARABIA	*/                                  SAR (682, "Saudi Riyal", "﷼", null, "SR", "\uFDFC", false, false), // alternate unicode for Arabic ra.sïn \u0631\u002E\u0633
        /* SERBIA */	                                    RSD (891, "Serbian Dinar", null, null, "din.", "\u0434\u0438\u043D", false, true), // "дин", no symbol, unicode is for Cyrillic Dé I Enne, lower case
        /* SEYCHELLES */	                                SCR (690, "Seychellois Rupee", "SRe", "SR", null, "\u0053\u0052\u0065", false, false),
        /* SIERRA LEONE */	                                SLL (694, "Leone", "Le", null, null, "\u004C\u0065", false, false),
        /* SINGAPORE */	                                    SGD (702, "Singapore Dollar", "$", "S$", null, "\u0024", true, false),
        /* SOLOMON ISLANDS */	                            SBD (90, "Solomon Islands Dollar", "SI$", "$", null, "\u0053\u0049\u0024", true, false),
        /* SOMALIA */	                                    SOS (706, "Somali Shilling", "Sh.So.", null, null, "\u0053\u0068\u002E\u0053\u006F\u002E", false, false),
        /* SOUTH GEORGIA AND THE SOUTH SANDWICH ISLANDS     No universal currency */
        /* SOUTH SUDAN */	                                SSP (728, "South Sudanese Pound", "ج.س.", "Pounds", null, "\u002E\u062C\u002E\u0633", false, false), // Supposing Pound is acceptable as for Sudan
        /* SRI LANKA */	                                    LKR (144, "Sri Lanka Rupee", "රු,", "SLRs", null, "\u2048", true, false), // Unicode = Rs
        /* SUDAN (THE) */	                                SDG (938, "Sudanese Pound", "ج.س.", "Pounds", null, "\u002E\u062C\u002E\u0633", false, false), // "Pound" appears on bank notes, unicode = arab djim.sîn
        /* SURINAME */	                                    SRD (740, "Surinam Dollar", "$", "SRD", null, "\u0024", true, false),
        /* SWAZILAND */                                     SZL (748, "Lilangeni", "E", null, null, "\u0045", true, false), // E = plural form of lilangeni = emalangeni
        /* SWEDEN, AALAND ISLANDS */                        SEK (752, "Swedish Krona", "kr",	null, null, "\u006B\u0072", false, true),
        /* SYRIAN ARAB REPUBLIC */	                        SYP (760, "Syrian Pound", "£S", "LS", null, "\u00A3\u004C", false, false),
        /* TAIWAN (PROVINCE OF CHINA) */                    TWD (901, "New Taiwan Dollar", "$", "NT$", null, "\u0024", true, false),
        /* TAJIKISTAN */	                                TJS (972, "Somoni", "cомонӣ", null, null, "\u0441\u043E\u043C\u043D\u0438", false, false), // "cомонӣ", no symbol, unicode is for Cyrillic Esse o Emme o Enne i, lower case
        /* TANZANIA, UNITED REPUBLIC OF */	                TZS (834, "Tanzanian Shilling", "TSh", null, null, "\u0054\u0053\u0068", false, false),
        /* THAILAND	*/                                      THB (764, "Baht", "฿", null, null, "\u0E3F", true, false),
        /* TONGA */ 	                                    TOP (776, "Pa’anga", "T$", null, null, "\u0054\u0024", true, false),
        /* TRINIDAD AND TOBAGO */                           TTD (780, "Trinidad and Tobago Dollar", "$", "TT$", null, "\u0024", true, false),
        /* TUNISIA */ 	                                    TND (788, "Tunisian Dinar", "د.ت", null, "DT", "\u062F\u002E\u062A", false, true), // unicode for Arabic té.dal
        /* TURKEY */ 	                                    TRY (949, "Turkish Lira", null, "TL", null, "\u20BA", true, true),
        /* TURKMENISTAN	*/ 	                                TMT (795, "Turkmenistan New Manat", "T", null, null, "\u0054", false, false),
        /* UGANDA */ 	                                    UGX (800, "Uganda Shilling", "USh", null, null, "\u0055\u0053\u0068", false, false),
        /* UKRAINE */ 	                                    UAH (980, "Hryvnia", "₴", null, "hrn", "\u20B4", true, true),
        /* UNITED ARAB EMIRATES (THE) */ 	                AED (784, "UAE Dirham", "د.إ", "DH", null, "\u062f\u002e\u0625", false, false),
        /* URUGUAY	*/ 	                                    UYU (858, "Peso Uruguayo", "$", "$U", null, "\u0024", true, true),
        /* UZBEKISTAN */ 	                                UZS (860, "Uzbekistan Sum", "�?ўм", null, "so'm", "\u0441\u045E\u043C", false, true), // "�?ўм", no symbol, unicode is for Cyrillic Esse o Emme, lower case
        /* VANUATU	*/ 	                                    VUV (548, "Vatu", "VT", null, null, "\u0046\u0074", false, false),
        /* VENEZUELA (BOLIVARIAN REPUBLIC OF) */            VEF (937, "Bolívar", "Bs.", "Bs.F.", null, "\u0042\u0073\u002E", true, true),
        /* VIET NAM	*/ 	                                    VND (704, "Dong", "₫", null, null, "\u20AB", false, true),
        /* YEMEN */ 	                                    YER (886, "Yemeni Rial", "﷼", null, "YR", "\ufdfc", false, false), // unicode for rial, alternative \u064A\u002E\u0631 for arabic ra.ya' "﷼"
        /* ZAMBIA */                                        ZMW (894, "Zambian Kwacha", "ZK", null, null, "\u005A\u004B", false, false),
        /* ZIMBABWE	*/                                      ZWL (716, "Zimbabwean Dollar", "$", "Z$", null, "\u0024", true, false);


    	/** The ISO 4217 generic symbol used when there is no symbol for a currency */
        public static final String GENERIC_SYMBOL = "\u00A4"; // '¤'

        /** The ISO 4217 numeric code for this currency. */
        private int code;
        /** The English name for this currency. */
        private String name;
        /** The main local symbol to use for this currency. */
        private String symbol;
        /** The alternate local symbol to use for this currency, if exists. */
        private String alternateSymbol;
        /** The Latin CharSet equivalent version of the currency symbol. */
        private String latinSymbol;
        /** The UTF-16BE representation of the currency symbol. */
        private String unicode;
        /** True if the currency symbol appears before the amount. */
        private boolean signBefore;
        /** True if the fractional digits separator is a comma (dot otherwise) */
        private boolean comma;

        /**
         * Builds a new ISO 4217 Currency Code enumeration value.
         * <p>
         * @param code the numeric code for this currency
         * @param name the English name for this currency
         * @param symbol the local symbol for this currency
         * @param alternateSymbol the alternate symbol in use for this currency
         * @param latinSymbol the Latin form of the symbol if not in Latin Charset
         * @param unicode the UTF16-BE representation of the symbol
         * @param signBefore true if the symbol is before the amount
         */
        private Iso4217CurrencyCode(int code, String name, String symbol, String alternateSymbol, String latinSymbol, String unicode, boolean signBefore, boolean comma) {
        	this.code = code;
        	this.name = name;
            this.symbol = symbol;
            this.alternateSymbol = alternateSymbol;
            this.latinSymbol = latinSymbol;
            this.unicode = unicode;
            this.signBefore = signBefore;
            this.comma = comma;
        }

        /** Gets the ISO 4217 numeric code for this currency. */
        public int getCode() { return code; }

        /** Gets the ISO 4217 numeric code for this currency as String of 3 numeric characters. */
        public String getCodeAsString() { return String.format("%03d", code); }

        /** Gets the ISO 4217 alpha-3 code for this currency. Simply returns the enumeration value name. */
        public String getIsoCodeAlpha3() { return this.name(); }
        
        /** Gets the English name for this currency. */
        public String getName() { return name; }

        /** Gets the symbol used for this currency. */
        public String getSymbol() { return symbol; }

        /** Gets the alternate symbol in use for this currency. */
        public String getAlternateSymbol() { return alternateSymbol; }

        /** Gets the Latin representation of the symbol if not in Latin CharSet. */
        public String getLatinSymbol() { return latinSymbol; }

        /** Gets the UTF16-BE representation of the symbol. */
        public String getUnicode() { return unicode; }
        
        /** Returns true if the symbol appears before the amount. */
        public boolean isSignBefore() { return signBefore; }

        /** Returns true if the fractional digits are separated with a comma (dot otherwise). */
        public boolean isCommaSeparator() { return comma; }

        /** Returns <code>amountInCents</code> / 10^<code>currencyExponent</code> as String with this currency symbol placed accordingly. */
        public static String getAmountWithSymbol (Iso4217CurrencyCode currency, int amountInCents, int currencyExponent) {
            return getAmountWithSymbol(currency, new BigDecimal (BigInteger.valueOf(amountInCents), currencyExponent));
        }

        /** Returns <code>amount</code> (with scale set appropriately to currency exponent) as String with this currency symbol placed accordingly. */
        public static String getAmountWithSymbol (Iso4217CurrencyCode currency, BigDecimal amount) {
        	
            StringBuilder formattedAmount = new StringBuilder();
            String unicode = currency.getUnicode();
            boolean signBefore = currency.isSignBefore();
            String sign;
            if (unicode == null) {
                String symbol = currency.getSymbol();
                if (symbol == null) sign = Iso4217CurrencyCode.GENERIC_SYMBOL; else sign = symbol;
            } else sign = unicode;
            if (signBefore) formattedAmount.append(sign);
            String amountStr = amount.toPlainString();
            if (currency.isCommaSeparator()) amountStr = amountStr.replace('.', ',');
            formattedAmount.append (amountStr);
            if (!signBefore) formattedAmount.append (sign);
            
            return formattedAmount.toString();
            
        }
        
		/** Return a Human readable representation of this Currency Code. */
		@Override public String toString() {
			
			StringBuffer buf = new StringBuffer();
			buf.append(name);
			buf.append(" (" + getIsoCodeAlpha3() + ", " + getCodeAsString() + ")");
			buf.append(", sign " + (isSignBefore()? "before" : "after") + " amount");
			buf.append(", symbol: " + symbol);
			if (latinSymbol != null) buf.append(", Latin symbol: " + latinSymbol);
			if (alternateSymbol != null) buf.append(", alternate symbol: " + alternateSymbol);
			
			return buf.toString();
			
		}

    }

}
