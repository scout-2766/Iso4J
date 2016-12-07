/**
 * DISCLAIMER
 * <p>
 * This java code consisting in java enumerations, hereafter <b>The Code</b>, has been prepared by <b>St&eacute;phane Coutant</b>, 
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

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;

import org.iso4j.ICountries.Iso3166Alpha3CountryCode.CountryName;
import org.iso4j.ICurrencies.Iso4217CurrencyCode;
import org.iso4j.ILanguages.Iso639LanguageCode;

/**
 * <code>ICountries</code> is an interface wrapping the ISO 3166 country codes as a java enumeration with access methods to various
 * information pertaining to a country, such as local country names in various languages and currency(ies) in use.
 * <p>
 * Input source (R) [fr|es|en].wikipedia.org/wiki/ISO_3166-1 and unicode from https://www.branah.com/unicode-converter.  
 * <p>
 * @author St&eacute;phane Coutant (fra)
 * @see {@link Iso639LanguageCode}
 * @see {@link Iso4217CurrencyCode}
 */

public interface ICountries {

	/** The list of ISO 3166 country codes by Alpha-3 code */
	public enum Iso3166Alpha3CountryCode {
		
		// Note: since an enumeration is static, to cater for several name representations of the same country, the way the enumeration is constructed 
		// follows a specific syntax handled by the constructor.
		// GENERAL PATTERN:
		// Alpha-3(Alpha-2, English country name, 1..N local country names)
		// CONVENTION:
		// The first local country name is the default language (most used).
		// The first currency code is the default currency.
		// SYNTAX:
		// local country name and alternate country names consist in a name expressed in the language designated by the ISO 639 Alpha-3 language code 
		// in parenthesis (mandatory), possibly followed by its Latin form and its UTF-16BE representation separated by ";;".
		// The Latin form and UTF-16BE representation may be null if local name is in Latin CharSet.
		// Optional 0..N [Alternate country names] have the same shape. 
		// Within country name, one keyword may be used:
		// ##LONG## if the name represents the long name form (e.g. "Republic of ...").
		// NOTE
		// Some characters may not render (e.g. Chinese and Japanese) without IDE support.
		
		ABW ("AW", "Aruba", "AWG",
				"Aruba(nld)"),
		AFG ("AF", "Afghanistan", "AFN", 
				"ا�?غانستان(pus);;Afgh�?nist�?n;;\u0641\u063a\u0627\u0646\u0633\u062a\u0627\u0646", 
				"ا�?غانستان(per);;Afgh�?̄nest�?̄n;;\u0627\u0641\u063a\u0627\u0646\u0633\u062a\u0627\u0646", 
				"##LONG##جمهوری اسلامی ا�?غانستان(pus;;Da Afghanestan Islami Jomhouriyet;;\u062c\u0645\u0647\u0648\u0631\u06cc \u0627\u0633\u0644\u0627\u0645\u06cc \u0627\u0641\u063a\u0627\u0646\u0633\u062a\u0627\u0646", 
				"##LONG##د ا�?غانستان اسلامي دولتدولت اسلامی ا�?غانستان(per);;Jomhūrī-ye Esl�?mī-ye Afġ�?nest�?n;;\u062f \u0627\u0641\u063a\u0627\u0646\u0633\u062a\u0627\u0646 \u0627\u0633\u0644\u0627\u0645\u064a \u062f\u0648\u0644\u062a\u062f\u0648\u0644\u062a \u0627\u0633\u0644\u0627\u0645\u06cc \u0627\u0641\u063a\u0627\u0646\u0633\u062a\u0627\u0646"), 
		AGO ("AO", "Angola", "AOA",
				"Angola(por)",
				"Ngola(kon)",
				"##LONG##República de Angola(por)",
				"##LONG##Repubilika ya Ngola(kon)"),
		AIA ("AI", "Anguilla", "XCD",
				"Anguilla(eng)"),
		ALA ("AX", "Aaland islands", "EUR;;SEK",
				"Landskapet Åland(swe)", 
				"Ahvenanmaan maakunta(fin)"),
		ALB ("AL", "Albania", "ALL",
				"Shqipëri(alb)", 
				"##LONG##Republika e Shqipërisë(alb)"),
		AND ("AD", "Andorra", "EUR",
				"Andorra(spa)",
				"##LONG##Principat d’Andorra(spa)"),
		ANT ("AN", "Netherlands Antilles", "ANG",
				"Nederlandse Antillen(nld)"),
		ARE ("AE", "United Arab Emirates", "AED",
				"دولة الإمارات العربيّة المتّحدة(ara);;al-ʾIm�?r�?t al-ʿArabiyyat al-Muttaḥida;;\u062f\u0648\u0644\u0629 \u0627\u0644\u0625\u0645\u0627\u0631\u0627\u062a \u0627\u0644\u0639\u0631\u0628\u064a\u0651\u0629 \u0627\u0644\u0645\u062a\u0651\u062d\u062f\u0629"),
		ARG ("AR", "Argentina", "ARS",
				"Argentina(spa)"),
		ARM ("AM", "Armenia", "AMD",
				"Հայաստան(arm);;Hayastan;;\u0540\u0561\u0575\u0561\u057d\u057f\u0561\u0576",
				"##LONG##Հայաստանի Հանրապետություն(arm);;Hayastani Hanrapetut'yun;;\u0540\u0561\u0575\u0561\u057d\u057f\u0561\u0576\u056b \u0540\u0561\u0576\u0580\u0561\u057a\u0565\u057f\u0578\u0582\u0569\u0575\u0578\u0582\u0576"),
		ASM ("AS", "Samoa (American)", "USD",
				"Amerika Samoa(smo)",
				"American Samoa(eng)",
				"##LONG##Malo Sa'oloto Tuto'atasi o Samoa(smo)",
				"##LONG##Independant States of Samoa(eng)"),
		ATA ("AQ", "Antartica", null,
				"Antartica(eng)",
				"Antartique(fra)",
				"Antártida(spa)",
				"�?нтарктида(rus);;Antarktida;;\u0410\u043d\u0442\u0430\u0440\u043a\u0442\u0438\u0434\u0430",
				"Antarktika(deu)",
				"Antarktika(nob)"),
		ATF ("TF", "French Southern Territories", "EUR",
				"Terres australes et antartiques françaises(fra)"),
		ATG ("AG", "Antigua and Barbuda", "XCD",
				"Antigua and Barbuda(eng)"),
		AUS ("AU", "Australia", "AUD",
				"Australia(eng)",
				"##LONG##Commonwealth of Australia(eng)"),
		AUT ("AT", "Austria", "EUR",
				"Österreich(deu)"),
		AZE ("AZ", "Azerbaijan", "AZN",
				"Azərbaycan(aze);;Azerbaycan;;\u0041\u007a\u0259\u0072\u0062\u0061\u0079\u0063\u0061\u006e",
				"##LONG##Azərbaycan Respublikası(aze);;\u0041\u007a\u0259\u0072\u0062\u0061\u0079\u0063\u0061\u006e \u0052\u0065\u0073\u0070\u0075\u0062\u006c\u0069\u006b\u0061\u0073\u0131"),
		BDI ("BI", "Burundi", "BIF",
				"##LONG##République du Burundi(fra)",
				"##LONG##Republika y’Uburundi(run)"),
		BEL ("BE", "Belgium", "EUR",
				"Belgique(fra)",
				"België(nld)",
				"Belgien(deu)",
				"##LONG##Royaume de Belgique(fra)", 
				"##LONG##Koninkrijk België(nld)", 
				"##LONG##Königreich Belgien(deu)"),
		BEN ("BJ", "Benin", "XOF",
				"Bénin(fra)",
				"Benin(yor)",
				"##LONG##République du Bénin(fra)",
				"##LONG##Orílɛ̀-èdè Olómìnira ilɛ̀ Benin(yor);;\u004f\u0072\u00ed\u006c\u025b\u0300\u002d\u00e8\u0064\u00e8 \u004f\u006c\u00f3\u006d\u00ec\u006e\u0069\u0072\u0061 \u0069\u006c\u025b\u0300 \u0042\u0065\u006e\u0069\u006e"),
		BES ("BQ", "Bonaire, Sint Eustatius and Saba", "USD", 
				"Caribisch Nederland(nld)",
				"Bonaire, Sint-Eustatius, en Saba(nld)"),
		BFA ("BF", "Burkina Faso", "XOF",
				"Burkina Faso(fra)",
				"Burkina(fra)"),
		BGD ("BD", "Bangladesh", "BDT",
				"বাংলাদেশ(ben);;Bangladesh;;\u09ac\u09be\u0982\u09b2\u09be\u09a6\u09c7\u09b6",
				"##LONG##গণপ�?রজাতন�?ত�?রী বাংলাদেশ(ben);;Gônoprojatontri Bangladesh;;\u0997\u09a3\u09aa\u09cd\u09b0\u099c\u09be\u09a4\u09a8\u09cd\u09a4\u09cd\u09b0\u09c0 \u09ac\u09be\u0982\u09b2\u09be\u09a6\u09c7\u09b6"),
		BGR ("BG", "Bulgaria", "BGN",
				"Българи�?(bul);;Bălgaria;;\u0411\u044a\u043b\u0433\u0430\u0440\u0438\u044f",
				"##LONG##Република Българи�?(bul);;Republika Bălgaria;;\u0420\u0435\u043f\u0443\u0431\u043b\u0438\u043a\u0430 \u0411\u044a\u043b\u0433\u0430\u0440\u0438\u044f"),
		BHR ("BH", "Bahrain", "BHD",
				"مملكة البحرين(ara);;Mamlakat al-Bahrayn;;\u0645\u0645\u0644\u0643\u0629 \u0627\u0644\u0628\u062d\u0631\u064a\u0646"),
		BHS ("BS", "Bahamas", "BSD",
				"Bahamas(eng)",
				"##LONG##Commonwealth of the Bahamas(eng)"),
		BIH ("BA", "Bosnia and Herzegovina", "BAM",
				"Bosna i Hercegovina(bos)",
				"Бо�?на и Херцеговина(scc);;Bosna i Hercegovina;;\u0411\u043e\u0441\u043d\u0430 \u0438 \u0425\u0435\u0440\u0446\u0435\u0433\u043e\u0432\u0438\u043d\u0430"),
		BLM ("BL", "Saint Barthelemy", "EUR",
				"Saint-Barthélémy(fra)"),
		BLR ("BY", "Belarus", "BYN",
				"Белару�?ь(bel);;Bielarous';;\u0411\u0435\u043b\u0430\u0440\u0443\u0441\u044c",
				"Белору�?�?и�?(rus);;Béloroussia;;\u0411\u0435\u043b\u043e\u0440\u0443\u0441\u0441\u0438\u044f",
				"##LONG##Р�?�?публіка Белару�?ь(bel);;Respublika Bielarous;;\u0420\u044d\u0441\u043f\u0443\u0431\u043b\u0456\u043a\u0430 \u0411\u0435\u043b\u0430\u0440\u0443\u0441\u044c",
				"##LONG##Ре�?публика Белору�?�?и�?(rus);;Respublika Béloroussia;;\u0420\u0435\u0441\u043f\u0443\u0431\u043b\u0438\u043a\u0430 \u0411\u0435\u043b\u043e\u0440\u0443\u0441\u0441\u0438\u044f"),
		BLZ ("BZ", "Belize", "BZD",
				"Belize(eng)",
				"Belice(spa"),
		BMU ("BM", "Bermuda", "BMD;;USD",
				"Bermuda(eng)"),
		BOL ("BO", "Bolivia", "BOB",
				"Bolivia(spa)",
				"Bulibiya Mama llaqta(que)",
				"Wuliwya Suyu(aym)",
				"Tetã Volívia(grn)", 
				"##LONG##Estado Plurinacional de Bolivia(spa)", 
				"##LONG##República de Bolivia(spa)"),
		BRA ("BR", "Brazil", "BRL",
				"Brasil(por)", 
				"##LONG##República Federativa do Brasil(por)"),
		BRB ("BB", "Barbados", "BBD;;USD",
				"Barbados(eng)"),		
		BRN ("BN", "Brunei Darussalam", "BND;;SGD",
				"بروني دارالسلام(ara);;Negara Brunei Darussalam;;\u0628\u0631\u0648\u0646\u064a \u062f\u0627\u0631\u0627\u0644\u0633\u0644\u0627\u0645", 
				"Kesultanan Brunei(may)"),
		BTN ("BT", "Bhutan", "BTN;;INR",
				"འབྲུག་ཡུལ(dzo);;Druk Yul;;\u0f60\u0f56\u0fb2\u0f74\u0f42\u0f0b\u0f61\u0f74\u0f63"),	
		BVT ("BV", "Bouvet Island", "NOK",
				"Bouvetøya(nob)"),
		BWA ("BW", "Botswana", "BWP",
				"Republic of Botswana(eng)", 
				"Lefatshe la Botswana(tsn)"),
		CAF ("CF", "Central African Republic", "XAF",
				"République centrafricaine(fra)", 
				"Ködörösêse tî Bêafrîka(sag)"),
		CAN ("CA", "Canada", "CAD",
				"Canada(eng)"),
		CCK ("CC", "Cocos (Keeling) Islands", "AUD", 
				"Cocos Islands(eng)", 
				"##LONG##Territory of Cocos Island(eng)",
				"Keeling Islands(eng)"),
		CHE ("CH", "Switzerland", "CHF",
				"Schweizerische(deu)",
				"Suisse(fra)",
				"Svizzera(ita)",
				"Svizra(roh)",
				"##LONG##Confœderatio Helvetica(lat)",
				"##LONG##Schweizerische Eidgenossenschaft(deu)", 
				"##LONG##Confédération suisse(fra)",
				"##LONG##Confederazione Svizzera(ita)",
				"##LONG##Confederaziun svizra(roh)"),
		CHL ("CL", "Chile", "CLP",
				"Chile(spa)", 
				"##LONG##Republica de Chile(spa)"),
		CHN ("CN", "China", "CNY",
				"中国(zho);;Zh�?ngguó;;\u4e2d\u56fd", // Chinese chars do not render
				"##LONG##中�?�人民共和国(zho);;Zh�?nghuá Rénmín Gònghéguó;;\u4e2d\u534e\u4eba\u6c11\u5171\u548c\u56fd",
				"中�?�人民共和國(zho);;Zh�?nghuá Rénmín Gònghéguó;;\u4e2d\u83ef\u4eba\u6c11\u5171\u548c\u570b"), 
		CIV ("CI", "Ivory Coast", "XOF",
				"Côte d'Ivoire(fra)",
				"##LONG##République de Côte d'Ivoire(fra)"),
		CMR ("CM", "Cameroon", "XAF",
				"Cameroun(fra)",
				"Cameroon(eng)",
				"##LONG##République du Cameroun(fra)",
				"##LONG##Republic of Cameroon(eng)"),
		COD ("CD", "Congo (Democratic Republic of the)", "CDF",
				"République démocratique du Congo(fra)", 
				"Repubilika ya Kongo Demokratiki(kon)", 
				"Jamhuri ya Kidemokrasia ya Kongo(swa)", 
				"Republiki ya Kongó Demokratiki(lin)", 
				"Ditunga dia Kongu wa Mungalaata(lua)", 
				"Congo-Kinshasa(fra)",
				"Congo(fra)",
				"RDC(fra)"),
		COG ("CG", "Congo", "XAF",
				"République du Congo(fra)",
				"Repubilika ya Kongo(kon)",
				"Republiki ya Kongó(swa)",
				"Congo-Brazzaville(fra)"),
		COK ("CK", "Cook Islands", "NZD",
				"Cook Islands(eng)"),
		COL ("CO", "Colombia", "COP",
				"Colombia(spa)", 
				"##LONG##República de Colombia(spa)"),
		COM ("KM", "Commoros", "KMF",
				"Komori(swa)",
				"جزر الق�?م�?ر(ara);;Juzur al-Qumur;;\u062c\u0632\u0631 \u0627\u0644\u0642\u064f\u0645\u064f\u0631", 
				"Union des Comores(fra)",
				"##LONG##الاتّحاد الق�?م�?ريّ(ara);;al-Ittiḥ�?d al-Qumuriyy;;\u0627\u0644\u0627\u062a\u0651\u062d\u0627\u062f \u0627\u0644\u0642\u064f\u0645\u064f\u0631\u064a\u0651",
				"##LONG##Udzima wa Komori(swa)"),
		CPV ("CV", "Cape Verde", "CVE",
				"Cabo Verde(por)",
				"##LONG##República de Cabo Verde(por)"),
		CRI ("CR", "Costa Rica", "CRC",
				"Costa Rica(spa)",
				"##LONG##República de Costa Rica(spa)"),
		CUB ("CU", "Cuba", "CUP;;CUC",
				"Cuba(spa)",
				"##LONG##República de Cuba(spa)"),	
		CUW ("CW", "Curacao", "ANG", 
				"Kòrsou(pap)",
				"Curaçao(nld)"), 
		CXR ("CX", "Christmas Islands", "AUD", 
				"Christmas Islands(eng)"),
		CYM ("KY", "Cayman Islands", "KYD",
				"Cayman Islands(eng)"),
		CYP ("CY", "Cyprus", "EUR",
				"Κ�?π�?ος(gre);;Kýpros;;\u039a\u03cd\u03c0\u03c1\u03bf\u03c2", 
				"Kıbrıs(tur);;\u004b\u0131\u0062\u0072\u0131\u0073", 
				"##LONG##Κυπ�?ιακή Δημοκ�?ατία(gre);;Kypriakí Dhimokratía;;\u039a\u03c5\u03c0\u03c1\u03b9\u03b1\u03ba\u03ae \u0394\u03b7\u03bc\u03bf\u03ba\u03c1\u03b1\u03c4\u03af\u03b1",
				"##LONG##Kıbrıs Cumhuriyeti(tur);;\u004b\u0131\u0062\u0072\u0131\u0073 \u0043\u0075\u006d\u0068\u0075\u0072\u0069\u0079\u0065\u0074\u0069"),
		CZE ("CZ", "Czech Republic", "CZK",
				"Ceská Republika(pol);;\u0043\u0065\u0073\u006b\u00e1 \u0052\u0065\u0070\u0075\u0062\u006c\u0069\u006b\u0061"),
		DEU ("DE", "Germany", "EUR",
				"Deutschland(deu)"),
		DJI ("DJ", "Djibouti", "DJF",
				"République de Djibouti(fra)",
				"جمهورية جيبوتي(ara);;Jumhūriyyat Jībūtī;;\u062c\u0645\u0647\u0648\u0631\u064a\u0629 \u062c\u064a\u0628\u0648\u062a\u064a", 
				"Gabuutih Ummuuno(aar)",
				"Jamahuuriyada Jabuuti(som)"),
		DMA ("DM", "Dominica", "XCD",
				"Dominica(eng)",
				"##LONG##Commonwealth of Dominica(eng)"),
		DNK ("DK", "Denmark", "DKK",
				"Danmark(dan)",
				"##LONG##Kongeriget Danmark(dan)"),
		DOM ("DO", "Dominican Republic", "DOP", 
				"República Dominicana(spa)"),
		DZA ("DZ", "Algeria", "DZD",
				"الجزائر(ara);;al-Jaz�?'ir;;\u0627\u0644\u062c\u0632\u0627\u0626\u0631",
				"�?ⵣⵣⴰⵢⴻⵔ(ber);;Lezzayer;;\u2d4d\u2d63\u2d63\u2d30\u2d62\u2d3b\u2d54",
				"الدزاير(ara);;Dzayer;;\u0627\u0644\u062f\u0632\u0627\u064a\u0631",
				"الجازاير(ara);;Djazaïr;;\u0627\u0644\u062c\u0627\u0632\u0627\u064a\u0631",
				"Algérie(fra)",
				"##LONG##الجمهورية الجزائرية الديمقراطية الشعبية(ara);;al-Yumhuriyya al-Yaz�?'iriyya ad-Dīmuqr�?ţiyya ash-Shaʿbiyya;;\u0627\u0644\u062c\u0645\u0647\u0648\u0631\u064a\u0629 \u0627\u0644\u062c\u0632\u0627\u0626\u0631\u064a\u0629 \u0627\u0644\u062f\u064a\u0645\u0642\u0631\u0627\u0637\u064a\u0629 \u0627\u0644\u0634\u0639\u0628\u064a\u0629",
				"##LONG##ⵜⴰⴳⴷⵓⴷⴰ ⵜⴰⵎⴻⴳⴷⴰⵢⵜ ⵜⴰⵖⴻⵔⴼⴰ�?ⵜ ⵜⴰⵣⵣⴰⵢⵔⵉⵜ(ber);;Tagduda tamegdayt taɣerfant tazzayrit;;\u2d5c\u2d30\u2d33\u2d37\u2d53\u2d37\u2d30 \u2d5c\u2d30\u2d4e\u2d3b\u2d33\u2d37\u2d30\u2d62\u2d5c \u2d5c\u2d30\u2d56\u2d3b\u2d54\u2d3c\u2d30\u2d4f\u2d5c \u2d5c\u2d30\u2d63\u2d63\u2d30\u2d62\u2d54\u2d49\u2d5c",
				"##LONG##République Algérienne Démocratique et Populaire(fra)"),
		ECU ("EC", "Ecuador", "USD",
				"Ecuador(spa)",
				"##LONG##República del Ecuador(spa)"),
		EGY ("EG", "Egypt", "EGP",
				"مصر(ara);;Masr;;\u0645\u0635\u0631",
				"##LONG##جمهوريّة مصر العربيّة(ara);;Gumhuriyyat Miṣr al-ʿArabiyyah;;\u062c\u0645\u0647\u0648\u0631\u064a\u0651\u0629 \u0645\u0635\u0631 \u0627\u0644\u0639\u0631\u0628\u064a\u0651\u0629"),
		ERI ("ER", "Eritrea", "ERN",
				"ሃገረ ኤርትራ(tir);;Hagere Ertra;;\u1203\u1308\u1228 \u12a4\u122d\u1275\u122b", 
				"دولة إرتريا(ara);;Dawlat Iritriyá;;\u062f\u0648\u0644\u0629 \u0625\u0631\u062a\u0631\u064a\u0627"), 
		ESH ("EH", "Western Sahara", "MAD",
				"الصحراء الغربية(ara);;As-Ṣaḥr�?' al-Ġarbiyah;;\u0627\u0644\u0635\u062d\u0631\u0627\u0621 \u0627\u0644\u063a\u0631\u0628\u064a\u0629"), 
		ESP ("ES", "Spain", "EUR",
				"España(spa)"),
		EST ("EE", "Estonia", "EUR",
				"Eesti(est)",
				"##LONG##Eesti Vabariik(est)"),
		ETH ("ET", "Ethiopia", "ETB", 
				"ኢትዮጵያ(amh);;Īty�?ṗṗy�?;;\u12a2\u1275\u12ee\u1335\u12eb",
				"##LONG##የኢትዮጵያ �?�ዴራላዊ ዲሞክራሲያዊ ሪ�??ብሊክ(amh);;ye-Īty�?ṗṗy�? Fēdēral�?wī Dīm�?kr�?sīy�?wī Rīpeblīk;;\u12e8\u12a2\u1275\u12ee\u1335\u12eb \u134c\u12f4\u122b\u120b\u12ca \u12f2\u121e\u12ad\u122b\u1232\u12eb\u12ca \u122a\u1350\u1265\u120a\u12ad"),
		FIN ("FI", "Finland", "EUR",
				"Suomi(fin)",
				"Finland(swe)",
				"##LONG##Suomen Tasavalta(fin)",
				"##LONG##Republiken Finland(swe)"),
		FJI ("FJ", "Fidji", "FJD",
				"Fidji(eng)",
				"Viti(fij)",
				"फ़िजी(hin);;Fiji;;\u092b\u093c\u093f\u091c\u0940",
				"##LONG##Republic of Fiji(eng)", 
				"##LONG##Matanitu ko Viti(fij)", 
				"##LONG##फ़िजी द�?वीप समूह गणराज�?य(hin);;Fiji Dvip Qamooh Ganarajya;;\u092b\u093c\u093f\u091c\u0940 \u0926\u094d\u0935\u0940\u092a \u0938\u092e\u0942\u0939 \u0917\u0923\u0930\u093e\u091c\u094d\u092f"),
		FLK ("FK", "Falkland Islands (Malvinas)", "FKP", 
				"Falkland Islands(eng)",
				"Islas Malvinas(spa)",
				"Ilhas Malvinas(por)"),
		FRA ("FR", "France", "EUR",
				"France(fra)",
				"##LONG##République française(fra)"),
		FRO ("FO", "Faroe Islands", "DKK", 
				"Føroyar(fao)",
				"Færøerne(dan)"),
		FSM ("FM", "Micronesia (Federated States of)", "USD", 
				"Micronesia(eng)",
				"##LONG##Federated States of Micronesia(eng)"),
		GAB ("GA", "Gabon", "XAF",
				"Gabon(fra)", 
				"##LONG##République gabonaise(fra)"),
		GBR ("GB", "United Kingdom", "GBP", 
				"United Kingdom(eng)"),
		GEO ("GE", "Georgia", "GEL",
				"ს�?ქ�?რთველ�? (geo);;Sakartvelo;;\u10e1\u10d0\u10e5\u10d0\u10e0\u10d7\u10d5\u10d4\u10da\u10dd"), 
		GGY ("GG", "Guernsey", "GBP",
				"Guernsey(eng)", 
				"Guernesey(fra)",
				"##LONG##Bailiwick of Guernsey(eng)",
				"##LONG##Bailliage de Guernesey(fra)"),
		GHA ("GH", "Ghana", "GHS",
				"Ghana(eng)",
				"##LONG##Republic of Ghana(eng)"),
		GIB ("GI", "Gibraltar", "GIP", 
				"Gibraltar(eng)",
				"جبل طارق(ara);;Djebel Tariq;;\u062c\u0628\u0644 \u0637\u0627\u0631\u0642"),
		GIN ("GN", "Guinea", "GNF",
				"Guinée(fra)", 
				"##LONG##LONGRepublique de Guinée(fra)", 
				"Guinée-Conakry(fra)"),
		GLP ("GP", "Guadeloupe", "EUR",
				"Guadeloupe(fra)"),
		GMB ("GM", "Gambia", "GMD",
				"Gambia(eng)", 
				"##LONG##Republic of The Gambia(eng)"),
		GNB ("GW", "Guinea-Bissau", "XOF",
				"Guiné-Bissau(por)",
				"##LONG##República da Guiné-Bissau(por)"),
		GNQ ("GQ", "Equatorial Guinea", "XAF",
				"Guiena ecuatorial(spa)",
				"Guinée Equatoriale(fra)",
				"Guiné Equatorial(por)",
				"##LONG##República de Guiena ecuatorial(spa)", 
				"##LONG##République de Guinée équatoriale(fra)",  
				"##LONG##República da Guiné Equatorial(por)"),
		GRC ("GR", "Greece", "EUR",
				"Ελλάδα(gre);;Ellinikí Dimokratía;;\u0395\u03bb\u03bb\u03ac\u03b4\u03b1"), 
		GRD ("GD", "Grenada", "XCD",
				"Grenada(eng)",
				"##LONG##Commonwealth of Grenada(eng)"),
		GRL ("GL", "Greenland", "DKK",
				"Kalaallit Nunaat(kal)",
				"Grønland(dan)"),
		GTM ("GT", "Guatemala", "GTQ",
				"Guatemala(spa)", 
				"##LONG##República de Guatemala(spa)"),
		GUF ("GF", "French Guiana", "EUR",
				"Guyane(fra)", 
				"##LONG##Guyane française(fra)"),
		GUM ("GU", "Guam", "USD",
				"Guam(eng)", 
				"Guåhån(cha)"), 
		GUY ("GY", "Guyana", "GYD",
				"Guyana(eng)",
				"##LONG##Co-Operative Republic of Guyana(eng)"),
		HKG ("HK", "Hong Kong", "HKD",
				"香港(zho);;Jyutping;;\u9999\u6e2f", // Chinese chars do not render
				"香港(zho);;Hēunggóng;;\u9999\u6e2f", 
				"香港(zho);;Hiông-Kóng;;\u9999\u6e2f", 
				"香港(zho);;Xi�?nggǎng;;\u9999\u6e2f",
				"香港(zho);;Hoeng Gong;;\u9999\u6e2f", 
				"##LONG##中�?�人民共和國香港特別行政�?�(zho);;Zh�?nghuá rénmín gònghéguó xi�?nggǎng tèbié xíngzhèngqū;;\u9999\u6e2f\u7279\u5225\u884c\u653f\u5340",
				"##LONG##Hong Kong Special Administrative Region of the People's Republic of China(eng)"),
		HMD ("HM", "Heard Island and McDonald Islands", "AUD", 
				"Heard Island and McDonald Islands(eng)"),
		HND ("HN", "Honduras", "HNL",
				"Honduras(spa)", 
				"##LONG##República de Honduras(spa)"),
		HRV ("HR", "Croatia", "HRK",
				"Hrvatska(hrv)", 
				"##LONG##Republika Hrvatska(hrv)"),
		HTI ("HT", "Haiti", "HTG;;USD",
				"Ayiti(hat)",
				"HaIti(fra)", 
				"##LONG##Repiblik d'Ayiti(hat)",
				"##LONG##République d'Haïti(fra)"),  
		HUN ("HU", "Hungary", "HUF",
				"Magyarország(hun)"),
		IDN ("ID", "Indonesia", "IDR",
				"Indonesia(ind)",
				"##LONG##Republik Indonesia(ind)"),
		IMN ("IM", "Isle of Man", "GBP",
				"Isle of Man(eng)"),
		IND ("IN", "India", "INR",
				"भारत(hin);;Bh�?rat;;\u092d\u093e\u0930\u0924",
				"India(eng)",
				"##LONG##भारत गणराज�?य(hin);;Bh�?rat Gaṇar�?jya;;\u092d\u093e\u0930\u0924 \u0917\u0923\u0930\u093e\u091c\u094d\u092f", 
				"##LONG##Republic of India(eng)"), 
		IOT ("IO", "British Indian Ocean Territory", "GBP;;USD", 
				"British Indian Ocean Territory(eng)"),
		IRL ("IE", "Ireland", "EUR",
				"Ireland(eng)", 
				"Éire(gle)"),
		IRN ("IR", "Iran (Islamic Republic of)", "IRR", 
				"جمهوری اسلامی ايران(ara);;Jomhūrī-ye Esl�?mī-ye Īr�?n;;\u062c\u0645\u0647\u0648\u0631\u06cc \u0627\u0633\u0644\u0627\u0645\u06cc \u0627\u064a\u0631\u0627\u0646"),
		IRQ ("IQ", "Iraq", "IQD",
				"العراق(ara);;Al `Ir�?q;;\u0627\u0644\u0639\u0631\u0627\u0642"),
		ISL ("IS", "Iceland", "ISK",
				"�?sland(isl)"),
		ISR ("IL", "Israel", "ILS",
				"מְדִינַת יִשְׂרָ�?ֵל(heb);;Medinat Yisra'el;;\u05de\u05b0\u05d3\u05b4\u05d9\u05e0\u05b7\u05ea \u05d9\u05b4\u05e9\u05b0\u05c2\u05e8\u05b8\u05d0\u05b5\u05dc", 
				"دولة إسرائيل(ara);;Dawlat Isr�?'īl;;\u062f\u0648\u0644\u0629 \u0625\u0633\u0631\u0627\u0626\u064a\u0644"),
		ITA ("IT", "Italia", "EUR", 
				"Italia(ita)"),
		JAM ("JM", "Jamaica", "JMD",
				"Jamaïca(eng)"),
		JEY ("JE", "Jersey", "GBP",
				"Jersey(eng)",
				"Jersey(fra)",
				"##LONG##Bailiwick of Jersey(eng)", 
				"##LONG##Bailliage de Jersey(fra)"),
		JOR ("JO", "Jordan", "JOD",
				"الأردنّ(ara);;Al-ʾUrdunn;;\u0627\u0644\u0623\u0631\u062f\u0646\u0651",
				"##LONG##المملكة الأردنّيّة الهاشميّة(ara);;Al Mamlakah al Urduniyah al Hashimiyah;;\u0627\u0644\u0645\u0645\u0644\u0643\u0629 \u0627\u0644\u0623\u0631\u062f\u0646\u0651\u064a\u0651\u0629 \u0627\u0644\u0647\u0627\u0634\u0645\u064a\u0651\u0629"),
		JPN ("JP", "Japan", "JPY",
				"日本(jpn);;Nikon Koku;;\u65e5\u672c\u56fd"), // Japonese chars do not render
		KAZ ("KZ", "Kazakhstan", "KZT",
				"Қазақ�?тан(kaz);;Qazaqstan;;\u049a\u0430\u0437\u0430\u049b\u0441\u0442\u0430\u043d",
				"##LONG##Қазақ�?тан Ре�?публика�?ы(kaz);;Qazaqstan Respublïkası\u049a\u0430\u0437\u0430\u049b\u0441\u0442\u0430\u043d \u0420\u0435\u0441\u043f\u0443\u0431\u043b\u0438\u043a\u0430\u0441\u044b"),
		KEN ("KE", "Kenya", "KES",
				"Kenya(swa)",
				"Kenya(eng)", 
				"##LONG##Jamhuri ya Kenya(swa)",
				"##LONG##Republic of Kenya(eng)"),
		KGZ ("KG", "Kyrgyzstan", "KGS",
				"Кыргыз(kir);;Kırgız;;\u041a\u044b\u0440\u0433\u044b\u0437", 
				"Кыргыз�?ка�?(rus);;Kyrgyzskaya;;\u041a\u044b\u0440\u0433\u044b\u0437\u0441\u043a\u0430\u044f",
				"##LONG##Кыргыз Ре�?публика�?ы(kir);;Kırgız Respublikası;;\u041a\u044b\u0440\u0433\u044b\u0437 \u0420\u0435\u0441\u043f\u0443\u0431\u043b\u0438\u043a\u0430\u0441\u044b", 
				"##LONG##Кыргыз�?ка�? ре�?публика(rus);;Kyrgyzskaya Respublika;;\u041a\u044b\u0440\u0433\u044b\u0437\u0441\u043a\u0430\u044f \u0440\u0435\u0441\u043f\u0443\u0431\u043b\u0438\u043a\u0430"),
		KHM ("KH", "Cambodia", "KHR;;THB",
				"កម្ពុជា(khm);;Kâmpŭchéa;;\u1780\u1798\u17d2\u1796\u17bb\u1787\u17b6",
				"##LONG##ព្រះរាជាណាចក្រកម្ពុជា(khm);;Preăh Réachéanachâkr Kâmpŭchea;;\u1796\u17d2\u179a\u17c7\u179a\u17b6\u1787\u17b6\u178e\u17b6\u1785\u1780\u17d2\u179a\u1780\u1798\u17d2\u1796\u17bb\u1787\u17b6",
				"ស្រុក�?្មែរ(khm);;Srok Khmer;;\u179f\u17d2\u179a\u17bb\u1780\u1781\u17d2\u1798\u17c2\u179a"),
		KIR ("KI", "Kiribati", "AUD",
				"Kiribati(gil)",
				"Kiribati(eng)",
				"##LONG##Ribaberiki Kiribati(gil)",
				"##LONG##Republic of Kiribati(eng)"),
		KNA ("KN", "Saint-Kitts and Nevis", "XCD", 
				"Saint-Kitts and Nevis(eng)"),
		KOR ("KR", "Korea (Republic of)", "KRW",
				"대한민국(kor);;Daehan Min-guk;;\ub300\ud55c\ubbfc\uad6d", 
				"大韓民國(zho);;Daehan Min-guk;;\u5927\u97d3\u6c11\u570b"), // Chinese (precisely Hanja) chars do not render
		KWT ("KW", "Kuwait", "KWD",
				"دولة الكويت(ara);;Dawlat al Kuwayt;;\u062f\u0648\u0644\u0629 \u0627\u0644\u0643\u0648\u064a\u062a"),
		LAO ("LA", "Lao People's Democratic Republic", "LAK;;THB",
				"ປະຊາຊົນລາວ(lao);;Lao;;\u0e9b\u0eb0\u0e8a\u0eb2\u0e8a\u0ebb\u0e99\u0ea5\u0eb2\u0ea7",
				"##LONG##ສາທາລະນະລັດ ປະຊາທິປະໄຕ ປະຊາຊົນລາວ(lao);;Sathalanalat Passathipatai Passasson lao;;\u0eaa\u0eb2\u0e97\u0eb2\u0ea5\u0eb0\u0e99\u0eb0\u0ea5\u0eb1\u0e94 \u0e9b\u0eb0\u0e8a\u0eb2\u0e97\u0eb4\u0e9b\u0eb0\u0ec4\u0e95 \u0e9b\u0eb0\u0e8a\u0eb2\u0e8a\u0ebb\u0e99\u0ea5\u0eb2\u0ea7"),
		LBN ("LB", "Lebanon", "LBP",
				"لبنان(ara);;Lubn�?n;;\u0644\u0628\u0646\u0627\u0646",
				"##LONG##االجمهوريّة اللبنانيّة(ara);;Al-Ŷumhūriya Al-Lubn�?niya';;\u0627\u0644\u062c\u0645\u0647\u0648\u0631\u064a\u0651\u0629 \u0627\u0644\u0644\u0628\u0646\u0627\u0646\u064a\u0651\u0629"),
		LBR ("LR", "Liberia", "LRD",
				"Liberia(eng)", 
				"##LONG##Republic of Liberia(eng)"),
		LBY ("LY", "Libya", "LYD",
				"ليبيا(ara);;Lībiyya;;\u0644\u064a\u0628\u064a\u0627",
				"�?ⵉⴱⵢⴰ(ber);;Libya;;\u2d4d\u2d49\u2d31\u2d62\u2d30",
				"##LONG##دولة ليبيا(ara);;Dawlat Lībiyya;;\u062f\u0648\u0644\u0629 \u0644\u064a\u0628\u064a\u0627"),
		LCA ("LC", "Saint Lucia", "XCD",
				"Saint Lucia(eng)", 
				"##LONG##Commonwealth of Saint Lucia(eng)"),
		LIE ("LI", "Liechtenstein", "CHF",
				"Liechtenstein(deu)", 
				"##LONG##Fürstentum Liechtenstein(deu)"),
		LKA ("LK", "Sri Lanka", "LKR",
				"�?්�?රී ලංක�?(sin);;Sri Lank�?;;\u0dc1\u0dca\u200d\u0dbb\u0dd3 \u0dbd\u0d82\u0d9a\u0dcf",
				"இலங�?கை(tam);;Ilankai;;\u0b87\u0bb2\u0b99\u0bcd\u0b95\u0bc8",
				"Sri Lanka(eng)",
				"##LONG##රී ලංක�? ප්�?රජ�?ත�?න්ත්�?රික සම�?ජව�?දී ජනරජය(sin);;Sri Lank�? Prajathanthrika Samajavadi Janarajaya;;\u0dbb\u0dd3 \u0dbd\u0d82\u0d9a\u0dcf \u0db4\u0dca\u200d\u0dbb\u0da2\u0dcf\u0dad\u0dcf\u0db1\u0dca\u0dad\u0dca\u200d\u0dbb\u0dd2\u0d9a \u0dc3\u0db8\u0dcf\u0da2\u0dc0\u0dcf\u0daf\u0dd3 \u0da2\u0db1\u0dbb\u0da2\u0dba", 
				"##LONG##இலங�?கை சனநாயக சோஷலிசக�? க�?டியரச�?(tam);;Ilankai Sananayaka Sosolisa Kudiyarasu;;\u0b87\u0bb2\u0b99\u0bcd\u0b95\u0bc8 \u0b9a\u0ba9\u0ba8\u0bbe\u0baf\u0b95 \u0b9a\u0bcb\u0bb7\u0bb2\u0bbf\u0b9a\u0b95\u0bcd \u0b95\u0bc1\u0b9f\u0bbf\u0baf\u0bb0\u0b9a\u0bc1",
				"##LONG##Democratic Socialist Republic of Sri Lanka(eng)"),
		LSO ("LS", "Lesotho", "LSL",
				"Lesotho(sot)",
				"Lesotho(eng)",
				"##LONG##Muso oa Lesotho(sot)",
				"##LONG##Kingdom of Lesotho(eng)"),
		LTU ("LT", "Lithuania", "EUR",
				"Lietuva(lit)", 
				"##LONG##Lietuvos Respublika(lit)"),
		LUX ("LU", "Luxembourg", "EUR",
				"Lëtzebuerg(ltz)",
				"Luxembourg(fra)", 
				"Luxemburg(deu)",
				"Luxemburgo(por)",
				"##LONG##Groussherzogtum Lëtzebuerg(ltz)", 
				"##LONG##Grand Duché de Luxembourg(fra)", 
				"##LONG##Großherzogtum Luxemburg(deu)",
				"##LONG##Grão-Ducado do Luxemburgo(por)"),
		LVA ("LV", "Latvia", "EUR",
				"Latvijas(lav)", 
				"##LONG##Latvijas Republika(lav)"),
		MAC ("MO", "Macau", "MOP;;HKD",
				"澳門(zho);;ou-mun;;\u6fb3\u95e8", // Chinese (precisely Cantonese) chars do not render 
				"澳門(zho);;àomén;;\u6fb3\u95e8", 
				"Macao(por)", 
				"##LONG##中�?�人民共和國澳門特別行政�?�(zho);;Zh�?nghuá Rénmín Gònghéguó Àomén Tèbié Xíngzhèngqū;;\u4e2d\u83ef\u4eba\u6c11\u5171\u548c\u570b\u6fb3\u9580\u7279\u5225\u884c\u653f\u5340",
				"##LONG##Região Administrativa Especial de Macau da República Popular da China(por)", 
				"RAEM(por)"),
		MAF ("MF", "Saint-Martin (French Part)", "EUR", 
				"Saint-Martin(fra)"),
		MAR ("MA", "Morocco", "MAD",
				"المغرب(ara);;al-Maġrib;;\u0627\u0644\u0645\u063a\u0631\u0628",
				"�?ⵎⵖⵔⵉⴱ(ber);;l-Meġrib;;\u2d4d\u2d4e\u2d56\u2d54\u2d49\u2d31",
				"##LONG##االمملكة المغربية(ara);;al-Mamlaka al-Maġribiyya;;\u0627\u0644\u0645\u0645\u0644\u0643\u0629 \u0627\u0644\u0645\u063a\u0631\u0628\u064a\u0629", 
				"##LONG##ⵜⴰⴳ�?ⴷⵉⵜ �? �?ⵎⵖⵔⵉⴱ(ber);;Tageldit-n-Muraku�?;;\u2d5c\u2d30\u2d33\u2d4d\u2d37\u2d49\u2d5c \u2d4f \u2d4d\u2d4e\u2d56\u2d54\u2d49\u2d31"),
		MCO ("MC", "Monaco", "EUR",
				"Monaco(fra)",
				"##LONG##Principauté de Monaco(fra)"),
		MDA ("MD", "Moldova (Republic of)", "MDL", 
				"Moldova(ron)"),
		MDG ("MG", "Madagascar", "MGA",
				"Madagasikara(mlg)", 
				"Madagascar(fra)", 
				"##LONG##Repoblikan'i Madagasikara(mlg)",
				"##LONG##République de Madagascar(fra)"),
		MDV ("MV", "Maldives", "MVR",
				"ދިވެހިރާއްޖޭގެ(div);;Dhivehi Raa'je;;\u078b\u07a8\u0788\u07ac\u0780\u07a8\u0783\u07a7\u0787\u07b0\u0796\u07ad\u078e\u07ac",
				"##LONG##ދިވެހިރާއްޖޭގެ ޖުމްހޫރިއްޔާ(div);;Divehi R�?jjey ge Jumhuriyy�?;;\u078b\u07a8\u0788\u07ac\u0780\u07a8\u0783\u07a7\u0787\u07b0\u0796\u07ad\u078e\u07ac \u0796\u07aa\u0789\u07b0\u0780\u07ab\u0783\u07a8\u0787\u07b0\u0794\u07a7"),
		MEX ("MX", "Mexico", "MXN",
				"Mexico(spa)",
				"##LONG##Estados Unidos Mexicanos(spa)"),
		MHL ("MH", "Marshall Islands", "USD", 
				"M̧ajeļ(mah)",
				"Marshall Islands(eng)", 
				"##LONG##Aolep�?n Aor�?kin M̧ajeļ(mah)", 
				"##LONG##Republic of the Marshall Islands(eng)"),
		MKD ("MK", "Macedonia (the former Yugoslav Republic of)", "MKD",
				"Македонија(mkd);;Macedonia;;\u041c\u0430\u043a\u0435\u0434\u043e\u043d\u0438\u0458\u0430",
				"##LONG##Република Македонија(mkd);;Republika Macedonia;;\u0420\u0435\u043f\u0443\u0431\u043b\u0438\u043a\u0430 \u041c\u0430\u043a\u0435\u0434\u043e\u043d\u0438\u0458\u0430",
				"##LONG##Поранешна Југо�?ловен�?ка Република Македонија(mkd);;Poranešna Jugoslovenska Republika Makedonija;;\u041f\u043e\u0440\u0430\u043d\u0435\u0448\u043d\u0430 \u0408\u0443\u0433\u043e\u0441\u043b\u043e\u0432\u0435\u043d\u0441\u043a\u0430 \u0420\u0435\u043f\u0443\u0431\u043b\u0438\u043a\u0430 \u041c\u0430\u043a\u0435\u0434\u043e\u043d\u0438\u0458\u0430",
				"ПЈРМ(mkd)"),
		MLI ("ML", "Mali", "XOF",
				"Mali(fra)",
				"##LONG##République du Mali(fra)"),
		MLT ("MT", "Malta", "EUR",
				"Malta(mlt)",
				"Malta(eng)",
				"##LONG##Repubblika ta' Malta(mlt)",
				"##LONG##Republic of Malta(eng)"),
		MMR ("MM", "Myanmar", "MMK;;THB",
				"မြန်မာ(mya);;Myanmâ\u1019\u103c\u1014\u103a\u1019\u102c", 
				"##LONG##ပြည်ထောင်စု သမ္မ�? မြန်မာနိုင်ငံ�?ော်‌(mya);;Pyidaungzu Thammada Myanma Naingngandaw;;\u1015\u103c\u100a\u103a\u1011\u1031\u102c\u1004\u103a\u1005\u102f \u101e\u1019\u1039\u1019\u1010 \u1019\u103c\u1014\u103a\u1019\u102c\u1014\u102d\u102f\u1004\u103a\u1004\u1036\u1010\u1031\u102c\u103a\u200c"),
		MNE ("ME", "Montenegro", "EUR",
				"Црна Гора(srp);;Crna Gora;;\u0426\u0440\u043d\u0430 \u0413\u043e\u0440\u0430"),
		MNG ("MN", "Mongolia", "MNT",
				"ᠮᠣᠩᠭᠣᠯ ᠤᠯᠤᠰ(mon);;Mongol Uls;;\u182e\u1823\u1829\u182d\u1823\u182f \u1824\u182f\u1824\u1830", 
				"Монгол Ул�?(mon);;Mongol Uls;;\u041c\u043e\u043d\u0433\u043e\u043b \u0423\u043b\u0441"),
		MNP ("MP", "Northern Mariana Islands", "USD", 
				"Northern Mariana Islands(eng)",
				"##LONG##Commonwealth of the Northern Mariana Islands(eng)"),
		MOZ ("MZ", "Mozambique", "MZN",
				"Moçambique(por)", 
				"##LONG##República de Moçambique(por)"),
		MRT ("MR", "Mauritania", "MRO",
				"موريتانيا(ara);;Mūrīt�?ny�?;;\u0645\u0648\u0631\u064a\u062a\u0627\u0646\u064a\u0627",
				"Mauritanie(fra)",
				"Gànnaar(wol)",
				"Murutaane(snk)",
				"Moritani(ful)",
				"##LONG##لجمهورية الإسلامية الموريتانية(ara);;Al-Yumhūriyya al-Isl�?miyya al-Mawrīt�?niyya;;\u0627\u0644\u062c\u0645\u0647\u0648\u0631\u064a\u0629 \u0627\u0644\u0625\u0633\u0644\u0627\u0645\u064a\u0629 \u0627\u0644\u0645\u0648\u0631\u064a\u062a\u0627\u0646\u064a\u0629"),
		MSR ("MS", "Montserrat", "XCD",
				"Montserrat(eng)"),
		MTQ ("MQ", "Martinique", "EUR",
				"Martinique(fra)"),
		MUS ("MU", "Mauritius", "MUR",
				"Mauritius(eng)",
				"Île Maurice(fra)", 
				"Moris(cpf)"),
		MWI ("MW", "Malawi", "MWK",
				"Malaŵi(nya);;\u004d\u0061\u006c\u0061\u0175\u0069",
				"Malawi(eng)",
				"##LONG##Dziko la Malaŵi(nya);;\u0044\u007a\u0069\u006b\u006f \u006c\u0061 \u004d\u0061\u006c\u0061\u0175\u0069",
				"##LONG##Republic of Malawi(eng)"),
		MYS ("MY", "Malaysia", "MYR",
				"Malaysia(may)", 
				"##LONG##Kerajaan Malaysia(may)"),
		MYT ("YT", "Mayotte", "EUR",
				"Mayotte(fra)", 
				"Maoré(swa)"),
		NAM ("NA", "Namibia", "NAD",
				"Namibia(eng)",
				"Namibië(afr)",
				"##LONG##Republic of Namibia(eng)", 
				"##LONG##Republiek van Namibië(afr)"),
		NCL ("NC", "New Caledonia", "XPF",
				"Nouvelle-Calédonie(fra)"),
		NER ("NE", "Niger", "NGN",
				"Niger(fra)", 
				"##LONG##République du Niger(fra)"),
		NFK ("NF", "Norfolk Islands", "AUD", 
				"Norfolk Islands(eng)"),
		NGA ("NG", "Nigeria", "NGN",
				"Nigeria(eng)",
				"Nijeriya(hau)",
				"Naìjíríyà(ibo)",
				"Nàìjíríà(yor)",
				"##LONG##Federal Republic of Nigeria(eng)",
				"##LONG##Jamhuriyar Taraiyar Nijeriya(hau)",
				"##LONG##Ọ̀hàńjík�?̀ Ọ̀hànézè Naìjíríyà(ibo)",
				"##LONG##Àpap�?̀ Olómìnira ilẹ̀ Nàìjíríà(yor)"),
		NIC ("NI", "Nicaragua", "NIO",
				"Nicaragua(spa)", 
				"##LONG##Republica de Nicaragua(spa"),
		NIU ("NU", "Niue", "NZD",
				"Niuē(niu);;\u004e\u0069\u0075\u0113",
				"Niue(eng)"),
		NLD ("NL", "Netherlands", "EUR",
				"Nederland(nld)"),
		NOR ("NO", "Norway", "NOK",
				"Norge(nob)", 
				"Noreg(nno)",
				"##LONG##Kongeriket Norge(nob)", 
				"##LONG##Kongeriket Noreg(nno)"),
		NPL ("NP", "Nepal", "NPR;;INR",
				"नेपाल(nep);;Nep�?l;;\u0928\u0947\u092a\u093e\u0932", 
				"##LONG##संघीय लोकतान�?त�?रिक गणतन�?त�?रात�?मक नेपाल(nep);;Sanghiya Loktantrik Ganatantratmak Nep�?l;;\u0938\u0902\u0918\u0940\u092f \u0932\u094b\u0915\u0924\u093e\u0928\u094d\u0924\u094d\u0930\u093f\u0915 \u0917\u0923\u0924\u0928\u094d\u0924\u094d\u0930\u093e\u0924\u094d\u092e\u0915 \u0928\u0947\u092a\u093e\u0932"),
		NRU ("NR", "Nauru", "AUD",
				"Naoero(nau)",
				"Nauru(eng)", 
				"##LONG##Ripublik Naoero(nau)",
				"##LONG##Republic of Nauru(eng)"),
		NZL ("NZ", "New Zealand", "NZD", 
				"New Zealand(eng)", 
				"Aotearoa(mao)"),
		OMN ("OM", "Oman", "OMR",
				"عمان(ara);;ʻUm�?n;;\u0639\u0645\u0627\u0646", 
				"##LONG##سلطنة ع�?مان(ara);;Salṭanat ʻUm�?n;;\u0633\u0644\u0637\u0646\u0629 \u0639\u064f\u0645\u0627\u0646"),
		PAK ("PK", "Pakistan (Republic Islamic of)", "PKR",
				"پاک�?ستان(urd);;P�?kist�?n;;\u067e\u0627\u06a9\u0650\u0633\u062a\u0627\u0646",
				"##LONG##سلامی جم�?وریۂ پاکستان(urd);;Islami Jamhuria Pakistan;;\u0633\u0644\u0627\u0645\u06cc \u062c\u0645\u06c1\u0648\u0631\u06cc\u062a \u067e\u0627\u06a9\u0633\u062a\u0627\u0646"),
		PAN ("PA", "Panama", "PAB",
				"Panama(spa)", 
				"##LONG##República de Panamá(spa)"),
		PCN ("PN", "Pitcairn", "NZD",
				"Pitcairn(eng)", 
				"##LONG##Pitcairn Islands(eng)"),
		PER ("PE", "Peru", "PEN",
				"Peru(spa)",
				"Piruw(que)",
				"##LONG##República del Perú(spa)", 
				"##LONG##Piruw Republika(que)"),
		PHL ("PH", "Philippines", "PHP", 
				"Pilipinas(fil)", 
				"Philippines(eng)", 
				"Filipinas(spa)", 
				"##LONG##Republika ng Pilipinas(fil)", 
				"##LONG##Republic of the Philippines(eng)", 
				"##LONG##República de Filipinas(spa)"),
		PLW ("PW", "Palau", "USD",
				"Belau(pau)",
				"Palau(eng)",
				"##LONG##Beluu er a Belau(pau)",
				"##LONG##Republic of Palau(eng)"), 
		PNG ("PG", "Papua New Guinea", "PGK",
				"Papua Niugini(tpi)",
				"Papua Niu Gini(hmo)",
				"##LONG##Independen Stet bilong Papua Niugini(tpi)"),
		POL ("PL", "Poland", "PLN",
				"Polska(pol)"),
		PRI ("PR", "Porto Rico", "USD",
				"Porto Rico(spa)",
				"Porto Rico(eng)",
				"##LONG##Estado Libre Asociado de Puerto Rico(spa)",
				"##LONG##Commonwealth of Puerto Rico(eng)"),
		PRK ("KP", "North Korea", "KPW",
				"�?조선(kor);;Puk Chos�?n;;\ubd81\uc870\uc120",
				"北�?鮮(kho);;Puk Chos�?n;;\u5317\u671d\u9bae", // Chinese (hanja) chars do not render
				"조선민주주�?��?�민공화국(kor);;Chos�?n Minjujuŭi Inmin Konghwaguk;;\uc870\uc120\ubbfc\uc8fc\uc8fc\uc758\uc778\ubbfc\uacf5\ud654\uad6d",
				"##LONG##�?鮮民主主義人民共和國(kho);;Chos�?n Minjujuŭi Inmin Konghwaguk;;\u671d\u9bae\u6c11\u4e3b\u4e3b\u7fa9\u4eba\u6c11\u5171\u548c\u570b"),
		PRT ("PT", "Portugal", "EUR",
				"Portugal(por)"),
		PRY ("PY", "Paraguay", "PYG",
				"Paraguay(spa),",
				"Paraguái(grn)",
				"##LONG##República del Paraguay(spa)",
				"##LONG##Tetä Paraguáype(grn)"),
		PSE ("PS", "Palestine (State of)", "ILS;;EGP;;JOD",
				"�?لسطين(ara);;Filastin;;\u0641\u0644\u0633\u0637\u064a\u0646",
				"##LONG##دولة �?لسطين(ara);;Dawlat Filastin;;\u062f\u0648\u0644\u0629 \u0641\u0644\u0633\u0637\u064a\u0646"),
		PYF ("PF", "French Polynesia", "XPF",
				"Polynésie française(fra)",
				"P�?rīnetia Far�?ni(tah)"),
		QAT ("QA", "Qatar", "QAR",
				"قطر(ara);;Qatar;;\u0642\u0637\u0631",
				"دولة قطر(ara);;Dawlat Qatar;;\u062f\u0648\u0644\u0629 \u0642\u0637\u0631"),
		REU ("RE", "Réunion", "EUR",
				"La Réunion(fra)",
				"La Rényon(cpf)"),
		ROU ("RO", "Romania", "RON",
				"România(ron)"),
		RUS ("RU", "Russia", "RUB",
				"Ро�?�?и�?(rus);;Rossíïa;;\u0420\u043e\u0441\u0441\u0438\u044f",
				"Ро�?�?ий�?ка�? Федераци�?(rus);;Rossiiskaïa Fédératsiya;;\u0420\u043e\u0441\u0441\u0438\u0439\u0441\u043a\u0430\u044f \u0424\u0435\u0434\u0435\u0440\u0430\u0446\u0438\u044f"),
		SAU ("SA", "Saudi Arabia", "SAR",
				"العربيّة السّعودية(ara);;Al-‘Arabiyyah as-Sa‘ūdiyyah;;\u0627\u0644\u0639\u0631\u0628\u064a\u0651\u0629 \u0627\u0644\u0633\u0651\u0639\u0648\u062f\u064a\u0629",
				"##LONG##االمملكة العربيّة السّعودية(ara);;Mamlakah al `Arabiyahas Su`udiyah;;\u0627\u0644\u0645\u0645\u0644\u0643\u0629 \u0627\u0644\u0639\u0631\u0628\u064a\u0651\u0629 \u0627\u0644\u0633\u0651\u0639\u0648\u062f\u064a\u0629"),
		RWA ("RW", "Rwanda", "RWF",
				"Rwanda(kin)",
				"Rwanda(fra)",
				"##LONG##Repubulika y'u Rwanda(kin)", 
				"##LONG##République Rwandaise(fra)"),
		SDN ("SD", "Sudan", "SDG",
				"السودان(ara);;as-Sūd�?n;;\u0627\u0644\u0633\u0648\u062f\u0627\u0646",
				"##LONG##جمهورية السودان(ara);;Jumhūrīyat as-Sūd�?n;;\u062c\u0645\u0647\u0648\u0631\u064a\u0629 \u0627\u0644\u0633\u0648\u062f\u0627\u0646", 
				"##LONG##Republic of Sudan(eng)"),
		SEN ("SN", "Senegal", "XOF",
				"Sénégal(fra)", 
				"##LONG##République du Sénégal(fra)"),
		SGP ("SG", "Singapore", "SGD;;BND",
				"Singapore(eng)",
				"Singapura(may)",
				"சிங�?கப�?பூர�?(tam);;Ciṅkappūr;;\u0b9a\u0bbf\u0b99\u0bcd\u0b95\u0baa\u0bcd\u0baa\u0bc2\u0bb0\u0bcd",
				"新加�?�(kho);;Xīnji�?p�?;;\u65b0\u52a0\u5761", // Chinese chars do not render 
				"##LONG##Republic of Singapore(eng)", 
				"##LONG##Republik Singapura(may)", 
				"##LONG##சிங�?கப�?பூர�? க�?டியரச�?(tam);;Cingkappūr�? Kudiyaracu;;\u0b9a\u0bbf\u0b99\u0bcd\u0b95\u0baa\u0bcd\u0baa\u0bc2\u0bb0\u0bcd \u0b95\u0bc1\u0b9f\u0bbf\u0baf\u0bb0\u0b9a\u0bc1", 
				"##LONG##新加�?�共和国(kho);;Xīnjīap�? Gònghégúo;;\u65b0\u52a0\u5761\u5171\u548c\u56fd"), 
		SGS ("GS", "South Georgia and the South Sandwich Islands", "GBP",
				"South Georgia and the South Sandwich Islands(eng)"),
		SHN ("SH", "Saint Helena, Ascension and Tristan da Cunha", "SHP",
				"Saint Helena(eng)",
				"##LONG##Saint Helena, Ascension and Tristan da Cunha(eng)"),
		SJM ("SJ", "Svalbard and Jan Mayen Island", "NOK", 
				"Svalbard og Jan Mayen(nob)"),
		SLB ("SB", "Solomon Islands", "SBD",
				"Solomon Islands(eng)"),
		SLE ("SL", "Sierra Leone", "SLL",
				"Sierra Leone(eng)",
				"Salone(cpe)"),
		SLV ("SV", "El Salvador", "USD",
				"El Salvador(spa)", 
				"##LONG##República de El Salvador(spa)"),
		SMR ("SM", "San Marino", "EUR",
				"San Marino(ita)",
				"##LONG##Serenissima Repubblica di San Marino et Repubblica di San Marino(ita)"),
		SOM ("SO", "Somalia", "SOS",
				"Soomaaliya(som)",
				"الصومال(ara);;aṣ-Ṣūm�?l;;\u0627\u0644\u0635\u0648\u0645\u0627\u0644",
				"##LONG##Jamhuuriyadda Federaalka Soomaaliya(som)",
				"##LONG##جمهورية الصومال ال�?درالية(ara);;Jumhūriyyat aṣ-Ṣūm�?l al-Fideraaliya;;\u062c\u0645\u0647\u0648\u0631\u064a\u0629 \u0627\u0644\u0635\u0648\u0645\u0627\u0644\u0629",
				"##LONG##The Federal Republic of Somalia(eng)"),
		SPM ("PM", "Saint Pierre and Miquelon", "EUR",
				"Saint-Pierre-et-Miquelon(fra)"),
		SRB ("RS", "Serbia", "RSD",
				"Србија(srp);;Srbija;;\u0421\u0440\u0431\u0438\u0458\u0430",
				"##LONG##Република Србија(srp);;Republika Srbija;;\u0420\u0435\u043f\u0443\u0431\u043b\u0438\u043a\u0430 \u0421\u0440\u0431\u0438\u0458\u0430"),
		SSD ("SS", "South Sudan", "SSP",
				"South Sudan(eng)", 
				"##LONG##Republic of South Sudan(eng)"),
		STP ("ST", "São Tomé and Príncipe", "STD",
				"São Tomé and Príncipe(por)",
				"##LONG##República Democrática de São Tomé e Príncipe(por)"),
		SUR ("SR", "Suriname", "SRD",
				"Suriname(nld)",
				"##LONG##Republiek Suriname(nld)"),
		SVK ("SK", "Slovakia", "EUR",
				"Slovenská(slk)", 
				"##LONG##Slovenská republika(slk)"),
		SVN ("SI", "Slovenia", "EUR",
				"Slovenija(slv)", 
				"##LONG##Republika Slovenija(slv)"),
		SWE ("SE", "Sweden", "SEK",
				"Sverige(swe)"),
		SWZ ("SZ", "Swaziland", "SZL",
				"Swatini(ssw)",
				"Swaziland(eng)",
				"##LONG##Umbuso we Swatini(ssw)",
				"##LONG##Kingdom of Swaziland(eng)"),
		SXM ("SX", "Sint Maarten (Dutch part)", "ANG",
				"Sint Maarten(nld)",
				"Sint Maarten(eng)",
				"##LONG##Land Sint Maarten(nld)",
				"##LONG##Country of Sint Maarten(eng)"),
		SYC ("SC", "Seychelles", "SCR",
				"Sesel(cpf)",
				"Seychelles(eng)",
				"Seychelles(fra)",
				"##LONG##Repiblik Sesel(cpf)",
				"##LONG##Republic of Seychelles(eng)", 
				"##LONG##République des Seychelles(fra)"),
		SYR ("SY", "Syria", "SYP",
				"سوريا(ara);;Sūriyyah;;\u0633\u0648\u0631\u064a\u0627",
				"##LONG##الجمهوريّة العربيّة السّوريّة(ara);;Al-Jumhūriyyah al-‘Arabīyyah as-Sūriyyah;;\u0627\u0644\u062c\u0645\u0647\u0648\u0631\u064a\u0651\u0629 \u0627\u0644\u0639\u0631\u0628\u064a\u0651\u0629 \u0627\u0644\u0633\u0651\u0648\u0631\u064a\u0651\u0629"),
		TCA ("TC", "Turks and Caicos Islands", "USD",
				"Turks and Caicos(eng)",
				"TCI(eng)"),
		TCD ("TD", "Chad", "XAF",
				"تشاد(ara);;Tsh�?d;;\u062a\u0634\u0627\u062f",
				"Tchad(fra)",
				"##LONG##جمهورية تشاد(ara);;Jumhūriyyat Tsh�?d;;\u062c\u0645\u0647\u0648\u0631\u064a\u0629 \u062a\u0634\u0627\u062f",
				"##LONG##République du Tchad(fra)"),
		TGO ("TG", "Togo", "XOF",
				"Togo(fra)", 
				"##LONG##République togolaise(fra)"),
		THA ("TH", "Thailand", "THB",
				"ประเทศไทย(tha);;Prathet Thaï;;\u0e1b\u0e23\u0e30\u0e40\u0e17\u0e28\u0e44\u0e17\u0e22",
				"##LONG##ราชอาณาจั�?รไทย(tha);;Ratcha Anachak Thai;;\u0e23\u0e32\u0e0a\u0e2d\u0e32\u0e13\u0e32\u0e08\u0e31\u0e01\u0e23\u0e44\u0e17\u0e22"),
		TJK ("TJ", "Tajikistan", "TJS",
				"Тоҷики�?тон(tgk);;Toçikiston;;\u0422\u043e\u04b7\u0438\u043a\u0438\u0441\u0442\u043e\u043d",
				"Таджики�?та�?н(rus);;Tadshikistán;;\u0422\u0430\u0434\u0436\u0438\u043a\u0438\u0441\u0442\u0430\u0301\u043d",
				"##LONG##Ҷумҳурии Тоҷики�?тон(tgk);;Çumhuriji Toçikiston;;\u04b6\u0443\u043c\u04b3\u0443\u0440\u0438\u0438 \u0422\u043e\u04b7\u0438\u043a\u0438\u0441\u0442\u043e\u043d",
				"##LONG##Ре�?пу�?блика Таджики�?та�?н(rus);;Respúblika Tadshikistán;;\u0420\u0435\u0441\u043f\u0443\u0301\u0431\u043b\u0438\u043a\u0430 \u0422\u0430\u0434\u0436\u0438\u043a\u0438\u0441\u0442\u0430\u0301\u043d"),
		TKL ("TK", "Tokelau", "NZD",
				"Tokelau(tkl)",
				"Tokelau(eng)"),
		TKM ("TM", "Turkmenistan", "TMT",
				"Türkmenistan(tuk)",
				"Туркмени�?тан(rus);;Turkmenistan;;\u0422\u0443\u0440\u043a\u043c\u0435\u043d\u0438\u0441\u0442\u0430\u043d",
				"##LONG##Republikasi Türkmenistan(tuk)",
				"##LONG##Ре�?публика Туркмени�?тан(rus);;Respublika Turkmenistan;;\u0420\u0435\u0441\u043f\u0443\u0431\u043b\u0438\u043a\u0430 \u0422\u0443\u0440\u043a\u043c\u0435\u043d\u0438\u0441\u0442\u0430\u043d"),
		TLS ("TL", "Timor Leste", "USD",
				"Timor Lorosa'e(tet)",
				"Timor Leste(por)",
				"##LONG##Repúblika Demokrátika Timor Lorosa'e(tet)", 
				"##LONG##República Democrática de Timor-Leste(por)"),
		TON ("TO", "Tonga", "TOP",
				"Tonga(ton)",
				"Tonga(eng)",
				"##LONG##Pule'anga Fakatu'i 'o Tonga(ton)",
				"##LONG##Kingdom of Tonga(eng)"),
		TTO ("TT", "Trinidad and Tobago", "TTD",
				"Trinidad and Tobago(eng)",
				"##LONG##Republic of Trinidad and Tobago(eng)"),
		TUN ("TN", "Tunisia", "TND",
				"تونس(ara);;Tūnis;;\u062a\u0648\u0646\u0633",
				"Tunisie(fra)",
				"##LONG##الجمهورية التونسية(ara);;al-Jumhūriyya at-Tūnisiyya;;\u0627\u0644\u062c\u0645\u0647\u0648\u0631\u064a\u0629 \u0627\u0644\u062a\u0648\u0646\u0633\u064a\u0629",
				"##LONG##République tunisienne(fra)"),
		TUR ("TR", "Turkey", "TRY",
				"Türkiye(tur)",
				"##LONG##Türkiye Cumhuriyeti(tur)"),
		TUV ("TV", "Tuvalu", "AUD",
				"Tuvalu(tvl)",
				"Tuvalu(eng)",
				"##LONG##State of Tuvalu(eng)"),
		TWN ("TW", "Taiwan", "TWD",
				"臺�?�(zho);;Táiw�?n;;\u81fa\u7063", // Chinese chars do not render
				"##LONG##中�?�民国(zho);;Zh�?nghuá Mínguó;;\u4e2d\u534e\u6c11\u56fd"),
		TZA ("TZ", "Tanzania", "TZS",
				"Tanzania(swa)",
				"Tanzania(eng)",
				"##LONG##Jamhuri ya Muungano wa Tanzania(swa)",
				"##LONG##United Republic of Tanzania(eng)"),
		UGA ("UG", "Uganda", "UGX",
				"Uganda(swa)",
				"Uganda(eng)",
				"##LONG##Jamhuri ya Uganda(swa)",
				"##LONG##Republic of Uganda(eng)"),
		UKR ("UA", "Ukraine", "UAH",
				"Украïна(ukr);;Ukraïna;;\u0423\u043a\u0440\u0430\u00ef\u043d\u0430"),
		UMI ("UM", "United States Minor Outlying Islands", "USD",
				"United States Minor Outlying Islands(eng)"),
		URY ("UY", "Uruguay", "UYU",
				"Uruguay(spa)",
				"Uruguai(por)",
				"##LONG##República Oriental del Uruguay(spa)",
				"##LONG##República Oriental do Uruguai(por)"),
		USA ("US", "United States of America (USA)", "USD",
			"United States of America(eng)",
			"USA(eng)"),
		UZB ("UZ", "Uzbekistan", "UZS",
				"O'zbekiston(uzb)",
				"Узбеки�?тан(rus);;O‘zbekiston;;\u0420\u0435\u0441\u043f\u0443\u0431\u043b\u0438\u043a\u0430",
				"##LONG##O'zbekiston Respublikasi(uzb)",
				"##LONG##Ре�?публика Узбеки�?тан(rus);;O‘zbekiston Respublikasi;;\u0420\u0435\u0441\u043f\u0443\u0431\u043b\u0438\u043a\u0430 \u0423\u0437\u0431\u0435\u043a\u0438\u0441\u0442\u0430\u043d"),
		VAT ("VA", "Holy See", "EUR",
				"Città del Vaticano(ita)",
				"##LONG##Stato della Città del Vaticano(ita)",
				"##LONG##Status Civitatis Vaticanæ(lat)"),
		VCT ("VC", "Saint Vincent and the Grenadines", "XCD",
				"Saint Vincent and the Grenadines(eng)"),
		VEN ("VE", "Venezuela", "VEF",
				"Venezuela(spa)",
				"República Bolivariana de Venezuela(spa)"),
		VGB ("VG", "Virgin Islands (British)", "USD",
				"British Virgin Islands(eng)"), 
		VIR ("VI", "Virgin Islands (US)", "USD",
				"US Virgin Islands(eng)"),
		VNM ("VN", "Vietnam", "VND",
				"Việt Nam(vie)",
				"##LONG##Cộng Hoà Xã Hội Chủ Nghĩa Việt Nam(vie)"),
		VUT ("VU", "Vanuatu", "VUV",
				"Vanuatu(bis)",
				"Vanuatu(eng)", 
				"Vanuatu(fra)",
				"##LONG##Ripablik blong Vanuatu(bis)", 
				"##LONG##Republic of Vanuatu(eng)", 
				"##LONG##République de Vanuatu(fra)"),
		WLF ("WF", "Wallis and Futuna", "XPF", 
				"Wallis-et-Futuna(fra)"), 
		WSM ("WS", "Samoa", "WST",
				"Samoa(smo)", 
				"Samoa(eng)", 
				"##LONG##Malo Sa'oloto Tuto'atasi o Samoa(smo)", 
				"##LONG##Independent State of Samoa(eng)"),
		/* Disputed state (by Serbia); not an official state, only used within European Union by some members */
		XKO ("XK", "Kosovo", "EUR",
				"Қо�?ово(srp);;Kosovo;;\u049a\u043e\u0441\u043e\u0432\u043e",
				"Kosova(alb)",
				"##LONG##Република Қо�?ово(srp);;Republika Kosovo;;\u0420\u0435\u043f\u0443\u0431\u043b\u0438\u043a\u0430 \u049a\u043e\u0441\u043e\u0432\u043e",
				"##LONG##Republika e Kosovës(alb)",
				"##LONG##Ко�?ово и Метохија(srp);;Kosovo i Metohija;;\u041a\u043e\u0441\u043e\u0432\u043e \u0438 \u041c\u0435\u0442\u043e\u0445\u0438\u0458\u0430"),
		YEM ("YE", "Yemen", "YER",
				"اليَمَن(ara);;al-Yaman;;\u0627\u0644\u064a\u064e\u0645\u064e\u0646",
				"##LONG##الجمهوريّة اليمنية(ara);;Al-Jumhūriyya al-Yamaniyya;;\u0627\u0644\u062c\u0645\u0647\u0648\u0631\u064a\u0651\u0629 \u0627\u0644\u064a\u0645\u0646\u064a\u0629"),
		ZAF ("ZA", "South Africa", "ZAR",
				"South Africa(eng)",
				"Suid-Afrika(afr)",
				"Sewula Afrika(nbl)",
				"Zantsi Afrika(xho)",
				"Ningizimu Afrika(zul)",
				"Ningizimu Afrika(ssw)",
				"Afrika-Borwa(nso)",
				"Afrika Borwa(sot)",
				"Aforika Borwa(tsn)",
				"Afrika Dzonga(tso)",
				"Afurika Tshipembe(ven)",
				"##LONG##Republic of South Africa(eng)",
				"##LONG##Republiek van Suid-Afrika(afr)",
				"##LONG##iRiphabliki yeSewula Afrika(nbl)",
				"##LONG##iRiphabliki yomZantsi Afrika(xho)",
				"##LONG##iRiphabhuliki yaseNingizimu Afrika(zul)",
				"##LONG##iRiphabhulikhi yeNingizimu Afrika(ssw)",
				"##LONG##Repabliki ya Afrika-Borwa(nso)",
				"##LONG##Rephaboliki ya Afrika Borwa(sot)",
				"##LONG##Rephaboliki ya Aforika Borwa(tsn)",
				"##LONG##Riphabliki ra Afrika Dzonga(tso)",
				"##LONG##Riphabuḽiki ya Afurika Tshipembe(ven)"),
		ZMB ("ZM", "Zambia", "ZMW",
				"Zambia(eng)",
				"##LONG##Republic of Zambia(eng)"),
		ZWE ("ZW", "Zimbawwe", "ZWL;;USD;;INR",
				"Zimbabwe(sna)",
				"Zimbabwe(nbl)",
				"Zimbabwe(nya)",
				"Zimbabwe(tso)",
				"Zimbabwe(sot)",
				"Zimbabwe(tsn)",
				"Zimbabwe(ven)",
				"Zimbabwe(xho)",
				"Zimbabwe(eng)", // many other languages but 639-3
		    "##LONG##Nyika yeZimbabwe(sna)",
		    "##LONG##Ilizwe leZimbabwe(nbl)",
		    "##LONG##Dziko la Zimbabwe(nya)",
			"##LONG##Tiko ra Zimbabwe(tso)",
			"##LONG##Naha ya Zimbabwe(sot)",
			"##LONG##Naga ya Zimbabwe(tsn)",
			"##LONG##Shango ḽa Zimbabwe(ven)",
			"##LONG##Ilizwe leZimbabwe(xho)",	
			"##LONG##Republic of Zimbabwe(eng)");
		
		/** The reserved SEPARATORarator for local country name between the name, the latin form and the unicode representation */
		private static final String SEPARATOR = ";;";
		/** The reserved key word in local country name to indicate this is a long country name form (e.g. "Republic of...) */
		private static final String LONG_KEYWORD = "##LONG##";
		/** The Unicode CharSet encoding format */
		private static final String UTF_16BE = StandardCharsets.UTF_16BE.toString();
		
		/** The ISO 3166 Alpha-2 country code */
		private String isoCodeAlpha2;
		/** The ISO 3166 numeric code */
		private int code;
		/** The country currency code */
		private List<Iso4217CurrencyCode> currencies;
		/** The English (eng) name of the country */
		private String englishCountryName;
		/** The list of local country names */
        private List<CountryName> countryNames;

        /** 
         * Constructs a new Country enumeration value.
         * <p>
         * @param isoCodeAlpha2 the ISO 3166 Alpha-2 code
         * @param countryName_eng the English name for this country (no need to precise "eng")
         * @param currencies the list of currency Alpha-3 codes accepted in this country, separated by {@link #SEPARATOR}
         * @param countryNames may corresponds to a single String or several Strings in the shape 
         * <pre>[##LONG##]Local Name(ISO 639 Alpha-3 language code)[;;Latin form[;;Unicode]]</pre>
         * Each String representing:
         * 	<ul>
         * 		<li>just the name with the ISO 639 Alpha-3 language code in parenthesis (if no Latin form or UTF-16BE String representation)
         * 		<li>three Strings (triplet) SEPARATORarated by {@link #SEPARATOR} specifying the local name (inwith possibly null Latin form or UTF-16BE String representation
         * 	</ul>
         * <br>A singleton or a triplet first String must specify the ISO 639 Alpha-3 language code
         * <br>One reserved key word is used and removed when parsed:
         * <ul>
         * 		<li>LONG if the name represented is the country name long form
         * </ul>
         * @throws NullPointerException if <code>isoCodeAlpha2</code> or <code>countryName_eng</code> is null or <code>countryNames</code> is null or empty
         * @throws IllegalArgumentException if 
         * <ul>
         *  <li><code>countryNames</code> cannot be parsed
         * 	<li><code>countryNames</code> item name (first argument, mandatory) is not in the form name(ISO639 Alpha-3 language code)
         * 	<li><code>countryNames</code> contains unicode representation but with invalid UTF-16 characters (e.g. not prefixed with UTF modifier \\u followed by 4 hex digits)
         * </ul>
         */
		private Iso3166Alpha3CountryCode (String isoCodeAlpha2, String countryName_eng, String currencies, String ... countryNames) 
			throws IllegalArgumentException, NullPointerException {
			boolean antartica = (currencies == null && isoCodeAlpha2.equals("AQ")); // Special case: no population, no (specific) currency
			if (countryName_eng == null) throw new NullPointerException("English country name is null for alpha-3 code " + this.name());
			if (isoCodeAlpha2 == null) throw new NullPointerException("ISO 3166 Alpha-2 country code is null for " + countryName_eng);
			if (currencies == null && !antartica) throw new NullPointerException("List of ISO 4217 currency Alpha-3 code(s) is null for " + countryName_eng);
			if (countryNames.length == 0) throw new NullPointerException("Local country name(s) is null or empty for " + countryName_eng);
			this.isoCodeAlpha2 = isoCodeAlpha2;
			this.currencies = (antartica? null : parseCurrencies (currencies));
			this.englishCountryName = countryName_eng;
			this.countryNames = parseCountryNames(countryNames); // throws IllegalArgumentException
		}

		/** By convention, the first in the list is the default local country name. */ 
		private CountryName getDefaultLocalName() { return countryNames.get(0); }
		
		/** Gets the ISO 3166 Alpha-3 code for this country. */
		public String getIsoCodeAlpha3() { return this.name(); }
		
		/** Gets the ISO 3166 Alpha-2 code for this country. */
		public String getIsoCodeAlpha2() { return isoCodeAlpha2; }
		
        /** Gets the ISO 4217 numeric code for this currency as String of 3 numeric characters. */
        public String getCodeAsString() { return String.format("%03d", code); }

        /** Gets the ISO 4217 numeric code for this currency as String of 3 numeric characters. */
        private void setCode(int code) { this.code = code; }

		/** Gets the ISO 4217 Currency Codes list for this country. */
		public List<Iso4217CurrencyCode> getCurrencyCodes() { return currencies; }

		/** Gets the default ISO 4217 Currency Code for this country, by convention the first in the list. */
		public Iso4217CurrencyCode getCurrencyCode() { return currencies.get(0); }

		/** Gets the English name for this country. */
		public String getCountryName() { return englishCountryName; }
		
		/** Gets the local default name for this country. */
		public String getLocalCountryName() { return getDefaultLocalName().getName(); }
		
		/** Gets the local default name language code for this country. */
		public Iso639LanguageCode getLocalCountryNameLanguageCode() { return getDefaultLocalName().getLanguageCode(); }
		
		/** Gets the local default name Latin form for this country. */
		public String getLocalCountryNameLatinForm() { return getDefaultLocalName().getLatinForm(); } 
		
		/** Gets the local name UTF-16 String representation for this country. */
		public String getLocalCountryNameUnicode() { return getDefaultLocalName().getUnicode(); }

		/** Gets the list of country (official) language codes */
		public List<Iso639LanguageCode> getSupportedLanguageCodes() {
			List<Iso639LanguageCode> list = new ArrayList<>();
			for (CountryName country : countryNames) { list.add(country.getLanguageCode()); }
			return list;
		}
		
		/** Gets the list of local names (including default), alternate local names or long representations for this country. */
		public List<CountryName> getCountryNames() { return countryNames; }

		/** Gets this country definition for the specified language code <code>languageCode</code>, or null if no definition exists for this language code */
		public CountryName getCountry(Iso639LanguageCode languageCode) {
			CountryName countryDef = null;
			for (CountryName country : countryNames) {
				if (country.getLanguageCode().equals(languageCode)) { countryDef = country; break; }
			}
			return countryDef;
		}

		/** Gets the long name form for this country for the default language code, or null if no long form exists */
		public String getCountryLongName() {
			String longName = null;
			for (CountryName country : countryNames) {
				if (country.isLongForm() && country.getLanguageCode().equals(getLocalCountryNameLanguageCode())) { longName = country.getName(); break; }
			}
			return longName;
		}

		/** Gets Long name form for this country for the specified language code <code>languageCode</code>, or null if no long form exists */
		public String getCountryLongName(Iso639LanguageCode languageCode) {
			String longName = null;
			for (CountryName country : countryNames) {
				if (country.isLongForm() && country.getLanguageCode().equals(languageCode)) { longName = country.getName(); break; }
			}
			return longName;
		}
		
		/** Gets alternate name for this country for the specified language <code>langageCode</code>, or null if no name exists for this language code */
		public String getCountryName(Iso639LanguageCode languageCode) {
			String name = null;
			for (CountryName country : countryNames) {
				if (country.getLanguageCode().equals(languageCode)) { name = country.getName(); break; }
			}
			return name;
		}
		
		/** Gets alternate name for this country for the specified language <code>langageCode</code>, or null if no Latin name exists for this language code */
		public String getCountryNameLatinForm(Iso639LanguageCode languageCode) {
			String name = null;
			for (CountryName country : countryNames) {
				if (country.getLanguageCode().equals(languageCode)) { name = country.getLatinForm(); break; }
			}
			return name;
		}
		
		/** Gets alternate name for this country for the specified language <code>langageCode</code>, or null if no Latin name exists for this language code */
		public String getCountryNameUnicode(Iso639LanguageCode languageCode) {
			String name = null;
			for (CountryName country : countryNames) {
				if (country.getLanguageCode().equals(languageCode)) { name = country.getUnicode(); break; }
			}
			return name;
		}

		/**
		 * Parses all <code>countryNames</code> defined.
		 * @param countryNames the list of country local names
		 * @return the list of qualified country names
		 * @throws IllegalArgumentException if the parsing fails
		 * @see CountryName#CountryName(String)
		 */
		private List<CountryName> parseCountryNames(String ... countryNames) throws IllegalArgumentException {
			List<CountryName> list = new ArrayList<>();
			// Each String is a dedicated local country name entry; let's CountryName constructor to parse and control entry
			for (int i=0; i<countryNames.length; i++) list.add(new CountryName(countryNames[i], (i==0)));
			return list;
		}
		
		/** 
		 * Parses the list of currency codes accepted in this country, or a single code if only one if the country is mono-currency.
		 * <p>
		 * @param currencies the list of ISO 4217 currency alpha-3 codes separated by {@link #SEPARATOR}, or only one currency code
		 * @throws IllegalArgumentException if the currency alpha-3 code is not recognised
		 */
		private List<Iso4217CurrencyCode> parseCurrencies (String currencies) throws IllegalArgumentException {
			List<Iso4217CurrencyCode> list = new ArrayList<>();
			// Case of country with no currency (as Antarctica)
			if (currencies != null) {
				String[] codes = currencies.split(SEPARATOR);
				for (String code : codes) {
					try {
						list.add(Iso4217CurrencyCode.valueOf(code));
					} catch (IllegalArgumentException e) {
						throw new IllegalArgumentException ("Invalid currency Alpha-3 code " + code + " for " + getCountryName());
					}
				}
			}
			return list;
		}
		
		/** Return a Human readable representation of this Country Code. */
		@Override public String toString() {
			StringBuffer buf = new StringBuffer();
			buf.append("English Name: " + englishCountryName);
			buf.append(" (" + getIsoCodeAlpha3() + ", " + isoCodeAlpha2 + ", " + getCodeAsString() + ")");
			buf.append(", currencies: ");
			if (currencies == null) buf.append("none");
			else {
				buf.append("[");
				int j = 1;
				for (ListIterator<Iso4217CurrencyCode> i = currencies.listIterator(); i.hasNext(); j++) { 
					buf.append(i.next().getIsoCodeAlpha3()); 
					if (j<currencies.size()) buf.append(", ");
				}
				buf.append("]");
			}
			buf.append(", Local country name(s):");
			for (ListIterator<CountryName> i = countryNames.listIterator(); i.hasNext();) { buf.append(i.next().toString()); }
			return buf.toString();
		}

		/** Convenient wrapper class to hold country name information (name, language code, Latin form and UTF-16, the last two can be null) */
		public class CountryName {
			
			private String name;
			private Iso639LanguageCode languageCode;
			private String latinForm;
			private String unicode;
			private boolean longForm;
			private boolean defaultLanguage;

			/**
			 * Constructs a new Country name representation
			 * <p>
	         * @param localName may corresponds to a single String or 2 or 3 Strings in the shape 
	         * <pre>[##LONG##]Local Name(ISO 639 Alpha-3 language code)[;;Latin form[;;Unicode]]</pre>
	         * <br>The first String is the name with the ISO 639 Alpha-3 language code in parenthesis(mandatory), 
	         * followed by either the Latin form or UTF-16 or both, separated by {@link #SEPARATOR} 
	         * <br>Two reserved key words are used and removed when parsed:
	         * <ul>
	         * 		<li>NULL if the name cannot be rendered (case of Japanese or Chinese chars for instance), in this case the name will take the explicit value of null
	         * 		<li>LONG if the name represented is the country name long form
	         * </ul>
			 * @throws IllegalArgumentException 
			 * <ul>
			 * 	<li>if <code>unicode</code> contains invalid UTF-16 characters (e.g. not prefixed with UTF modifier \\u followed by 4 hex digits)
			 * 	<li>if <code>localName</code> is not in the expected shape
			 * </ul>
			 */
			public CountryName(String localName, boolean defaultLanguage) throws IllegalArgumentException {
				this.defaultLanguage = defaultLanguage;
				parseLocalName(localName);
			}

			/** 
			 * Gets the country name expressed in <code>languageCode</code> if not null
			 * Otherwise, if <code>name</code> is null, returns <code>unicode</code> 
			 * Otherwise, if <code>unicode</code> is null, returns <code>latinForm</code>
			 * Otherwise, if <code>latinForm</code> is null, returns "\u003F" ('?')
			 */
			public String getName() {
				if (name != null) return name;
				else if (unicode != null) return unicode; // special case of chars that do not render (e.g. China, Japan) 
				else if (latinForm != null) return latinForm;
				else return "?";
			}
			
			/** Returns true if this name is a long representation. */
			public boolean isLongForm() { return longForm; }
			
			/** Returns true if this name is a the default language name. */
			public boolean isDefaultLanguage() { return defaultLanguage; }
			
			/** Returns the language code for this country name. */
			public Iso639LanguageCode getLanguageCode() { return languageCode; }
			
			/** Gets the Latin form or name if latinForm is null. */
			public String getLatinForm() { if (latinForm != null) return latinForm; else return name; }

			/** Returns true if this country has a UTF-16BE representation. */
			public boolean hasUnicode() { return (unicode != null); }

			/** 
			 * Gets the UTF-16BE String corresponding to <code>name</code>.
			 * <p>
			 * Usage <pre>String.format("%s", UTF_16BE, getUnicode())</pre>
			 * <p>
			 * If <code>unicode</code> is null, the <code>name</code> is used.
			 */
			public String getUnicode() { 
				String utf16;
				StringBuffer buf = new StringBuffer();
				if (unicode != null) utf16 = unicode;
				else if (name != null) {
					for (int i=0; i<name.length(); i++) { buf.append(String.format ("\\u%04x", (int)name.charAt(i))); }
					utf16 = buf.toString();
				} else utf16 = "\u003F"; // "?"
				return utf16; 
			}
			
			/** Parses the country name.
			 * <p>
	         * @param localName may corresponds to a single String or 2 or 3 Strings in the shape 
	         * <pre>[##LONG##]Local Name(ISO 639 Alpha-3 language code)[;;Latin form[;;Unicode]]</pre>
	         * <br>The first String is the name with the ISO 639 Alpha-3 language code in parenthesis(mandatory), 
	         * followed by either the Latin form or UTF-16 or both, separated by {@link #SEPARATOR} 
	         * <br>One reserved key word is used and removed when parsed:
	         * <ul>
	         * 		<li>LONG if the name represented is the country name long form
	         * </ul>
			 * @throws IllegalArgumentException 
			 * <ul>
			 * 	<li>if <code>unicode</code> contains invalid UTF-16 characters (e.g. not prefixed with UTF modifier \\u followed by 4 hex digits)
			 * 	<li>if <code>localName</code> is not in the expected shape
			 * </ul>
			 */
			private void parseLocalName (String localName) throws IllegalArgumentException {
				String[] splitStr = localName.split(SEPARATOR);
				int len = splitStr.length;
				if (len > 3) throw new IllegalArgumentException ("Local country name must be in the form \"name(ISO639 Alpha-3 language code)[;;latin form][;;unicode]\", found " + localName);
				// First String must be the local name
				this.name = extractLocalCountryName(splitStr[0]); 
				this.languageCode = extractLocaCountryNameLanguageCode(splitStr[0]);
				if (len > 1) {
					// Second String may be the Latin form or a UTF-16 String
					String latinOrUnicode = splitStr[1];
					if (latinOrUnicode != null) {
						if (latinOrUnicode.indexOf("\\u") >= 0) {
							checkUnicode(latinOrUnicode);
							this.unicode = latinOrUnicode;
						} else 
							this.latinForm = latinOrUnicode;
					}
					if (len > 2) {
						String unicodeOrLatin = splitStr[2];
						if (this.unicode != null) this.latinForm = unicodeOrLatin;
						else {
							checkUnicode(unicodeOrLatin);
							this.unicode = unicodeOrLatin;
						}
					}
				}
			}
			
			/** 
			 * Extracts the local country name from <code>localCountryName</code> by removing the anything after the opening parenthesis
			 * <p>
			 * If <code>localCountryName</code> contains the reserved word {@link #NULL_KEYWORD}, the value null is returned
			 * @param localCountryName the local country name in the form <pre>name(ISO 639 alpha-3 language code)</pre>
			 * @return the local country name or null if <code>localCountryName</code> contains the reserved word {@link #NULL_KEYWORD}
			 * @throws IllegalArgumentException if <code>localCountryName</code> is not in the expected shape
			 */
			private String extractLocalCountryName(String localCountryName) throws IllegalArgumentException {
				String name = null;
				if (localCountryName.indexOf('(') <=0) throw new IllegalArgumentException ("Local country name must be in the form \"name(ISO639 Alpha-3 language code)\" or NULL(ISO639 Alpha-3 language code), found " + localCountryName);
				name = localCountryName.substring(0, localCountryName.indexOf('('));
				if (name.toUpperCase().indexOf(LONG_KEYWORD) >= 0) {
					name = name.replace(LONG_KEYWORD, "");
					this.longForm = true;
				} else this.longForm = false;
				return name;
			}

			/** 
			 * Extracts the ISO 639 Alpha-3 language code form <code>localCountryName</code> by extracting the code between parenthesis.
			 * <br>The code is then converted in a duly qualified ISO639LanguageCode
			 * <p>
			 * @param localCountryName the local country name in the form <pre>name(ISO 639 alpha-3 language code)</pre>
			 * @return the ISO639LanguageCode enum value
			 * @throws IllegalArgumentException if <code>localCountryName</code> is not in the expected shape or if the language code is invalid
			 */
			private Iso639LanguageCode extractLocaCountryNameLanguageCode(String localCountryName) throws IllegalArgumentException {
				if (localCountryName.indexOf('(') <=0) throw new IllegalArgumentException ("Local country name must be in the form \"name(ISO639 Alpha-3 language code)\" or NULL(ISO639 Alpha-3 language code)");
				Iso639LanguageCode code = null;
				String languageCode = null;
				try {
					int idx = localCountryName.indexOf('(') + 1; // skip opening parenthesis
					languageCode = localCountryName.substring(idx, idx+3);
					code = Iso639LanguageCode.valueOf(languageCode);
				} catch (IndexOutOfBoundsException e) {
					throw new IllegalArgumentException ("Local country name must define ISO639 Alpha-3 language code in parenthesis for " + localCountryName);
				} catch (IllegalArgumentException e) {
					throw new IllegalArgumentException ("Invalid language code " + languageCode + " for " + localCountryName);
				}
				return code;
			}
			
			/** Checks that <code>unicode</code> is valid. */
			private void checkUnicode(String unicode) throws IllegalArgumentException {
				try {
					String.format("%s", UTF_16BE, unicode);
				} catch (IllegalFormatException e) {
					throw new IllegalArgumentException ("Invalid unicode String representation for " + getName(), e);
				}
			}

			/** Return a Human readable representation of this CountryName */
			@Override public String toString() {
				StringBuffer buf = new StringBuffer();
				buf.append("\n     ");
				buf.append(name); // Separated otherwise the font change for the prefix tabulation if name is not in Latin CharSet
				if (isLongForm()) buf.append(" (long form)");
				buf.append(" in " + languageCode.getLanguageName() + "(" + languageCode.getIsoCodeAlpha3() + (isDefaultLanguage()? ", default)" : ")"));
				if (latinForm != null) buf.append(", Latin form: " + latinForm); 
				return buf.toString();
			}
			
		}

	}
	
	/** 
	 * The list of ISO 3166 country codes by Alpha-2 code.
	 * <p>
	 * This list is less complete than Alpha-3 list, thus kept very simple; it should be considered as a shorthand to Iso3166Alpha3CountryCode.
	 */
	public enum Iso3166CountryCode {
		
		/* AALAND ISLANDS */                                 		AX("ALA", (int)248),
		/* AFGHANISTAN */                                    		AF("AFG", (int)4),
		/* ALBANIA */                                        		AL("ALB", (int)8),
		/* ALGERIA */                                        		DZ("DZA", (int)12),
		/* AMERICAN SAMOA */                                 		AS("ASM", (int)16),
		/* ANDORRA */                                        		AD("AND", (int)20),
		/* ANGOLA */                                         		AO("AGO", (int)24),
		/* ANGUILLA  */                                      		AI("AIA", (int)660),
		/* ANTARCTICA */                                     		AQ("ATA", (int)10),
		/* ANTIGUA AND BARBUDA */                            		AG("ATG", (int)28),
		/* ARGENTINA */                                      		AR("ARG", (int)32),
		/* ARMENIA */                                        		AM("ARM", (int)51),
		/* ARUBA */                                          		AW("ABW", (int)533),
		/* AUSTRALIA */                                      		AU("AUS", (int)36),
		/* AUSTRIA */                                        		AT("AUT", (int)40),
		/* AZERBAIJAN */                                     		AZ("AZE", (int)31),
		/* BAHAMAS */                                        		BS("BHS", (int)44),
		/* BAHRAIN */                                        		BH("BHR", (int)48),
		/* BANGLADESH */                                     		BD("BGD", (int)50),
		/* BARBADOS */                                       		BB("BRB", (int)52),
		/* BELARUS */                                        		BY("BLR", (int)112),
		/* BELGIUM */                                        		BE("BEL", (int)56),
		/* BELIZE */                                         		BZ("BLZ", (int)84),
		/* BENIN */                                          		BJ("BEN", (int)204),
		/* BERMUDA */                                        		BM("BMU", (int)60),
		/* BHUTAN */                                         		BT("BTN", (int)64),
		/* BOLIVIA */                                        		BO("BOL", (int)68),
		/* BONAIRE, SINT EUSTATIUS AND SABA (CARIBBEAN ISLANDS) */	BQ("BES", (int)44), 
		/* BOSNIA AND HERZEGOWINA */                         		BA("BIH", (int)70),
		/* BOTSWANA */                                       		BW("BWA", (int)72),
		/* BOUVET ISLAND */                                  		BV("BVT", (int)74),
		/* BRAZIL */                                         		BR("BRA", (int)76),
		/* BRITISH INDIAN OCEAN TERRITORY */                 		IO("IOT", (int)86),
		/* BRUNEI DARUSSALAM */                              		BN("BRN", (int)96),
		/* BULGARIA */                                       		BG("BGR", (int)100),
		/* BURKINA FASO */                                   		BF("BFA", (int)854),
		/* BURUNDI */                                        		BI("BDI", (int)108),
		/* CAMBODIA */                                       		KH("KHM", (int)116),
		/* CAMEROON */                                       		CM("CMR", (int)120),
		/* CANADA */                                         		CA("CAN", (int)124),
		/* CAPE VERDE */                                     		CV("CPV", (int)132),
		/* CAYMAN ISLANDS */                                 		KY("CYM", (int)136),
		/* CENTRAL AFRICAN REPUBLIC */                       		CF("CAF", (int)140),
		/* CHAD */                                           		TD("TCD", (int)148),
		/* CHILE */                                          		CL("CHL", (int)152),
		/* CHINA */                                          		CN("CHN", (int)156),
		/* CHRISTMAS ISLAND */                               		CX("CXR", (int)162),
		/* COCOS (KEELING) ISLANDS */                        		CC("CCK", (int)166),
		/* COLOMBIA */                                       		CO("COL", (int)170),
		/* COMOROS */                                        		KM("COM", (int)174),
		/* CONGO, DEMOCRATIC REPUBLIC OF (WAS ZAIRE) */      		CD("COD", (int)180),
		/* CONGO, Republic of */                             		CG("COG", (int)178),
		/* COOK ISLANDS */                                   		CK("COK", (int)184),
		/* COSTA RICA */                                     		CR("CRI", (int)188),
		/* COTE D'IVOIRE */                                  		CI("CIV", (int)384),
		/* CROATIA (HRVATSKA) */                             		HR("HRV", (int)191),    
		/* CUBA */                                           		CU("CUB", (int)192),
		/* CYPRUS */                                         		CY("CYP", (int)196),
		/* CZECH REPUBLIC */                                 		CZ("CZE", (int)203),
		/* CURACAO */                                        		CW("CUW", (int)531), 
		/* DENMARK */                                        		DK("DNK", (int)208),
		/* DJIBOUTI */                                       		DJ("DJI", (int)262),
		/* DOMINICA */                                       		DM("DMA", (int)212),
		/* DOMINICAN REPUBLIC */                             		DO("DOM", (int)214),
		/* ECUADOR */                                        		EC("ECU", (int)218),
		/* EGYPT */                                          		EG("EGY", (int)818),
		/* EL SALVADOR */                                    		SV("SLV", (int)222),
		/* EQUATORIAL GUINEA */                              		GQ("GNQ", (int)226),
		/* ERITREA */                                        		ER("ERI", (int)232),
		/* ESTONIA */                                        		EE("EST", (int)233),
		/* ETHIOPIA */                                       		ET("ETH", (int)231),
		/* FALKLAND ISLANDS (MALVINAS) */                    		FK("FLK", (int)238),
		/* FAROE ISLANDS */                                  		FO("FRO", (int)234),
		/* FIJI */                                           		FJ("FJI", (int)242),
		/* FINLAND */                                        		FI("FIN", (int)246),
		/* FRANCE */                                         		FR("FRA", (int)250),
		/* FRENCH GUIANA */                                  		GF("GUF", (int)254),
		/* FRENCH POLYNESIA */                               		PF("PYF", (int)258),
		/* FRENCH SOUTHERN TERRITORIES */                    		TF("ATF", (int)260),
		/* GABON */                                          		GA("GAB", (int)266),
		/* GAMBIA */                                         		GM("GMB", (int)270),
		/* GEORGIA */                                        		GE("GEO", (int)268),
		/* GERMANY */                                        		DE("DEU", (int)276),
		/* GHANA */                                          		GH("GHA", (int)288),
		/* GIBRALTAR */                                      		GI("GIB", (int)292),
		/* GREECE */                                         		GR("GRC", (int)300),
		/* GREENLAND */                                      		GL("GRL", (int)304),
		/* GRENADA */                                        		GD("GRD", (int)308),
		/* GUADELOUPE */                                     		GP("GLP", (int)312),
		/* GUAM */                                           		GU("GUM", (int)316),
		/* GUATEMALA */                                      		GT("GTM", (int)320),
		/* GUERNSEY */ 										 		GG("GGY", (int)831), 
		/* GUINEA */                                         		GN("GIN", (int)324),
		/* GUINEA-BISSAU */                                  		GW("GNB", (int)624),
		/* GUYANA */                                         		GY("GUY", (int)328),
		/* HAITI */                                          		HT("HTI", (int)332),
		/* HEARD AND MC DONALD ISLANDS */                    		HM("HMD", (int)334),
		/* HONDURAS */                                       		HN("HND", (int)340),
		/* HONG KONG */                                      		HK("HKG", (int)344),
		/* HUNGARY */                                        		HU("HUN", (int)348),
		/* ICELAND */                                        		IS("ISL", (int)352),
		/* INDIA */                                          		IN("IND", (int)356),
		/* INDONESIA */                                      		ID("IDN", (int)360),
		/* IRAN (ISLAMIC REPUBLIC OF) */                     		IR("IRN", (int)364),
		/* IRAQ */                                           		IQ("IRQ", (int)368),
		/* IRELAND */                                        		IE("IRL", (int)372),
		/* ISLE OF MAN */                                    		IM("IMN", (int)833), 
		/* ISRAEL */                                         		IL("ISR", (int)376),
		/* ITALY */                                          		IT("ITA", (int)380),
		/* JAMAICA */                                        		JM("JAM", (int)388),
		/* JAPAN */                                          		JP("JPN", (int)392),
		/* JERSEY */                                         		JE("JEY", (int)832), 
		/* JORDAN */                                         		JO("JOR", (int)400),
		/* KAZAKHSTAN */                                     		KZ("KAZ", (int)398),
		/* KENYA */                                          		KE("KEN", (int)404),
		/* KIRIBATI */                                       		KI("KIR", (int)296),
		/* KOREA, DEMOCRATIC PEOPLE'S REPUBLIC OF */         		KP("PRK", (int)408),
		/* KOREA, REPUBLIC OF */                             		KR("KOR", (int)410),
		/* KOSOVO */						 				 		XK("XKO", (int)999999), // Not official, disputed state (hence fake code)
		/* KUWAIT */                                         		KW("KWT", (int)414),
		/* KYRGYZSTAN */                                     		KG("KGZ", (int)417),
		/* LAO PEOPLE'S DEMOCRATIC REPUBLIC */               		LA("LAO", (int)418),
		/* LATVIA */                                         		LV("LVA", (int)428),
		/* LEBANON */                                        		LB("LBN", (int)422),
		/* LESOTHO */                                        		LS("LSO", (int)426),
		/* LIBERIA */                                        		LR("LBR", (int)430),
		/* LIBYAN ARAB JAMAHIRIYA */                         		LY("LBY", (int)434),
		/* LIECHTENSTEIN */                                  		LI("LIE", (int)438),
		/* LITHUANIA */                                      		LT("LTU", (int)440),
		/* LUXEMBOURG */                                     		LU("LUX", (int)442),
		/* MACAU */                                          		MO("MAC", (int)446),
		/* MACEDONIA, THE FORMER YUGOSLAV REPUBLIC OF */     		MK("MKD", (int)807),
		/* MADAGASCAR */                                     		MG("MDG", (int)450),
		/* MALAWI */                                         		MW("MWI", (int)454),
		/* MALAYSIA */                                       		MY("MYS", (int)458),
		/* MALDIVES */                                       		MV("MDV", (int)462),
		/* MALI */                                           		ML("MLI", (int)466),
		/* MALTA */                                          		MT("MLT", (int)470),
		/* MARSHALL ISLANDS */                               		MH("MHL", (int)584),
		/* MARTINIQUE */                                     		MQ("MTQ", (int)474),
		/* MAURITANIA */                                     		MR("MRT", (int)478),
		/* MAURITIUS */                                      		MU("MUS", (int)480),
		/* MAYOTTE */                                        		YT("MYT", (int)175),
		/* MEXICO */                                         		MX("MEX", (int)484),
		/* MICRONESIA, FEDERATED STATES OF */                		FM("FSM", (int)583),
		/* MOLDOVA, REPUBLIC OF */                           		MD("MDA", (int)498),
		/* MONACO */                                         		MC("MCO", (int)492),
		/* MONGOLIA */                                       		MN("MNG", (int)496),
		/* MONTENEGRO */                                     		ME("MNE", (int)499), 
		/* MONTSERRAT */                                     		MS("MSR", (int)500),
		/* MOROCCO */                                        		MA("MAR", (int)504),
		/* MOZAMBIQUE */                                     		MZ("MOZ", (int)508),
		/* MYANMAR */                                        		MM("MMR", (int)104),
		/* NAMIBIA */                                        		NA("NAM", (int)516),
		/* NAURU */                                          		NR("NRU", (int)520),
		/* NEPAL */                                          		NP("NPL", (int)524),
		/* NETHERLANDS */                                    		NL("NLD", (int)528),
		/* NETHERLANDS ANTILLES */                           		AN("ANT", (int)530),
		/* NEW CALEDONIA */                                  		NC("NCL", (int)540),
		/* NEW ZEALAND */                                    		NZ("NZL", (int)554),
		/* NICARAGUA */                                      		NI("NIC", (int)558), 
		/* NIGER */                                          		NE("NER", (int)562),
		/* NIGERIA */                                        		NG("NGA", (int)566),
		/* NIUE */                                           		NU("NIU", (int)570),
		/* NORFOLK ISLAND */                                 		NF("NFK", (int)574),
		/* NORTHERN MARIANA ISLANDS */                       		MP("MNP", (int)580),
		/* NORWAY */                                         		NO("NOR", (int)578),
		/* OMAN */                                           		OM("OMN", (int)512),
		/* PAKISTAN */                                       		PK("PAK", (int)586),
		/* PALAU */                                          		PW("PLW", (int)585),
		/* PALESTINIAN TERRITORY  */                         		PS("PSE", (int)275),
		/* PANAMA */                                         		PA("PAN", (int)591), 
		/* PAPUA NEW GUINEA */                               		PG("PNG", (int)598),
		/* PARAGUAY */                                       		PY("PRY", (int)600),
		/* PERU */                                           		PE("PER", (int)604),
		/* PHILIPPINES */                                    		PH("PHL", (int)608),
		/* PITCAIRN */                                       		PN("PCN", (int)612),
		/* POLAND */                                         		PL("POL", (int)616),
		/* PORTUGAL */                                       		PT("PRT", (int)620),
		/* PUERTO RICO */                                    		PR("PRI", (int)630),
		/* QATAR */                                          		QA("QAT", (int)634),
		/* REUNION */                                        		RE("REU", (int)638),
		/* ROMANIA */                                        		RO("ROU", (int)642),
		/* RUSSIAN FEDERATION */                             		RU("RUS", (int)643),
		/* RWANDA */                                         		RW("RWA", (int)646),
		/* SAINT BARTHELEMY */                               		BL("BLM", (int)652), 
		/* SAINT HELENA */                                   		SH("SHN", (int)654),
		/* SAINT KITTS AND NEVIS */                          		KN("KNA", (int)659),
		/* SAINT LUCIA */                                    		LC("LCA", (int)662),
		/* SAINT MARTIN (FRENCH PART) */                     		MF("MAF", (int)663), 
		/* SAINT PIERRE AND MIQUELON */                      		PM("SPM", (int)666),
		/* SAINT VINCENT AND THE GRENADINES */               		VC("VCT", (int)670),
		/* SAMOA */                                          		WS("WSM", (int)882),
		/* SAN MARINO */                                     		SM("SMR", (int)674),
		/* SAO TOME AND PRINCIPE */                          		ST("STP", (int)678),
		/* SAUDI ARABIA */                                   		SA("SAU", (int)682),
		/* SENEGAL */                                        		SN("SEN", (int)686),
		/* SERBIA */                                         		RS("SRB", (int)688),
		/* SEYCHELLES */                                     		SC("SYC", (int)690),
		/* SIERRA LEONE */                                   		SL("SLE", (int)694),
		/* SINGAPORE */                                      		SG("SGP", (int)702),
		/* SINT MAARTEN (DUTCH PART) */                      		SX("SXM", (int)534),
		/* SLOVAKIA */                                       		SK("SVK", (int)703),
		/* SLOVENIA */                                       		SI("SVN", (int)705),
		/* SOLOMON ISLANDS */                                		SB("SLB", (int)90),
		/* SOMALIA */                                        		SO("SOM", (int)706),
		/* SOUTH AFRICA */                                   		ZA("ZAF", (int)710),
		/* SOUTH GEORGIA AND THE SOUTH SANDWICH ISLANDS */   		GS("SGS", (int)239),
		/* SOUTH SUDAN */                                    		SS("SSD", (int)728), 
		/* SPAIN */                                          		ES("ESP", (int)724),
		/* SRI LANKA */                                      		LK("LKA", (int)144),
		/* SUDAN */                                          		SD("SDN", (int)736),
		/* SURINAME */                                       		SR("SUR", (int)740),
		/* SVALBARD AND JAN MAYEN ISLANDS */                 		SJ("SJM", (int)744),
		/* SWAZILAND */                                      		SZ("SWZ", (int)748),
		/* SWEDEN */                                         		SE("SWE", (int)752),
		/* SWITZERLAND */                                    		CH("CHE", (int)756),
		/* SYRIAN ARAB REPUBLIC */                           		SY("SYR", (int)760),
		/* TAIWAN */                                         		TW("TWN", (int)158),
		/* TAJIKISTAN */                                     		TJ("TJK", (int)762),
		/* TANZANIA, UNITED REPUBLIC OF */                   		TZ("TZA", (int)834),
		/* THAILAND */                                       		TH("THA", (int)764),
		/* TIMOR-LESTE */                                    		TL("TLS", (int)626),
		/* TOGO */                                           		TG("TGO", (int)768),
		/* TOKELAU */                                        		TK("TKL", (int)772),
		/* TONGA */                                          		TO("TON", (int)776),
		/* TRINIDAD AND TOBAGO */                            		TT("TTO", (int)780),
		/* TUNISIA */                                        		TN("TUN", (int)788),
		/* TURKEY */                                         		TR("TUR", (int)792),
		/* TURKMENISTAN */                                   		TM("TKM", (int)795),
		/* TURKS AND CAICOS ISLANDS */                       		TC("TCA", (int)796),
		/* TUVALU */                                         		TV("TUV", (int)798),
		/* UGANDA */                                         		UG("UGA", (int)800),
		/* UKRAINE */                                        		UA("UKR", (int)804),
		/* UNITED ARAB EMIRATES */                           		AE("ARE", (int)784),
		/* UNITED KINGDOM */                                 		GB("GBR", (int)826),
		/* UNITED STATES */                                  		US("USA", (int)840),
		/* UNITED STATES MINOR OUTLYING ISLANDS */           		UM("UMI", (int)581),
		/* URUGUAY */                                        		UY("URY", (int)858),
		/* UZBEKISTAN */                                     		UZ("UZB", (int)860),
		/* VANUATU */                                        		VU("VUT", (int)548),
		/* VATICAN CITY STATE (HOLY SEE) */                  		VA("VAT", (int)336),
		/* VENEZUELA */                                      		VE("VEN", (int)862),
		/* VIET NAM */                                       		VN("VNM", (int)704),
		/* VIRGIN ISLANDS (BRITISH) */                       		VG("VGB", (int)92),
		/* VIRGIN ISLANDS (U.S.) */                          		VI("VIR", (int)850),
		/* WALLIS AND FUTUNA ISLANDS */                      		WF("WLF", (int)876),
		/* WESTERN SAHARA */                                 		EH("ESH", (int)732),
		/* YEMEN */                                          		YE("YEM", (int)887),
		/* ZAMBIA */                                         		ZM("ZMB", (int)894),
		/* ZIMBABWE */                                       		ZW("ZWE", (int)716);
		
		private Iso3166Alpha3CountryCode country;
		private int code;
		
        /** 
         * Constructs a new Country enumeration value and gets the Iso3166Alpha3 instance 
         * <p>
         * @param isoCodeAlpha3 the ISO 3166 Alpha-3 code
         * @throws NullPointerException if <code>isoCodeAlpha3</code> or <code>countryName_eng</code> is null or <code>countryNames</code> is null or empty
         * @throws IllegalArgumentException if <code>isoCodeAlpha3</code> is invalid
         */
		private Iso3166CountryCode (String isoCodeAlpha3, int code) 
			throws IllegalArgumentException, NullPointerException {
			if (isoCodeAlpha3 == null) throw new NullPointerException("ISO 3166 Alpha-3 country code is null for " + this.name());
			try {
				country = Iso3166Alpha3CountryCode.valueOf(isoCodeAlpha3); // throws IllegalArgumentException
			} catch (IllegalArgumentException e) {
				throw new IllegalArgumentException ("Invalid or unknown Alpha-3 code " + isoCodeAlpha3 + " for "+ this.name());
			}
			country.setCode(code);
		}

		/** Gets the ISO 3166 Alpha-2 code for this country. */
		public String getIsoCodeAlpha2() { return this.name(); }
		
		/** Gets the ISO 3166 numeric code for this country. */
		public int getCode() { return code; }

		/** Gets the ISO 3166 numeric code for this country as a String of 3 numeric characters. */
		public String getCodeAsString() { return String.format("%03s", code); }

		/** Gets the ISO 3166 Alpha-3 code for this country. */
		public String getIsoCodeAlpha3() { return country.getIsoCodeAlpha3(); }
		
		/** Gets the ISO 4217 Currency Codes list for this country. */
		public List<Iso4217CurrencyCode> getCurrencyCodes() { return country.getCurrencyCodes(); }

		/** Gets the English name for this country. */
		public String getCountryName() { return country.getCountryName(); }
		
		/** Gets the local default name for this country. */
		public String getLocalCountryName() { return country.getLocalCountryName(); }
		
		/** Gets the local default name language code for this country. */
		public Iso639LanguageCode getLocalCountryNameLanguageCode() { return country.getLocalCountryNameLanguageCode(); }
		
		/** Gets the local default name Latin form for this country. */
		public String getLocalCountryNameLatinForm() { return country.getLocalCountryNameLatinForm(); } 
		
		/** Gets the local name UTF-16 String representation for this country. */
		public String getLocalCountryNameUnicode() { return country.getLocalCountryNameUnicode(); }
		
		/** Gets the list of country (official) language codes */
		public List<Iso639LanguageCode> getSupportedLanguageCodes() { return country.getSupportedLanguageCodes(); }
		
		/** Gets the list of country (official) language codes */
		public CountryName getCountry(Iso639LanguageCode languageCode) { return country.getCountry(languageCode); }
		
		/** Gets the list of local names (including default), alternate local names or long representations for this country. */
		public List<CountryName> getCountryNames() { return country.getCountryNames(); }

		/** Gets the long name form for this country for the default language code, or null if no long form exists */
		public String getCountryLongName() { return country.getCountryLongName(); }

		/** Gets Long name form for this country for the specified language code <code>languageCode</code>, or null if no long form exists */
		public String getCountryLongName(Iso639LanguageCode languageCode) { return country.getCountryLongName(languageCode); }
		
		/** Gets alternate name for this country for the specified language <code>langageCode</code>, or null if no name exists for this language code */
		public String getCountryName(Iso639LanguageCode languageCode) { return country.getCountryName(languageCode); }
		
		/** Gets alternate name for this country for the specified language <code>langageCode</code>, or null if no Latin name exists for this language code */
		public String getCountryNameLatinForm(Iso639LanguageCode languageCode) { return country.getCountryNameLatinForm(languageCode); }
		
		/** Gets alternate name for this country for the specified language <code>langageCode</code>, or null if no Latin name exists for this language code */
		public String getCountryNameUnicode(Iso639LanguageCode languageCode) { return country.getCountryNameUnicode(languageCode); }

		/**
		 * Returns a country display name for the specified country code in Locale default language.
		 * @throws IllegalArgumentException if no local name exists for the Locale default language 
		 */
		public static String getCountryNameDefaultLocale (Iso3166CountryCode country) throws IllegalArgumentException {
			Iso639LanguageCode languageCode = Iso639LanguageCode.valueOf(Locale.getDefault().getISO3Language());
			String name = country.getCountryName(languageCode);
			if (name == null) throw new IllegalArgumentException ("No display name for default Locale");
			return name;
		}

		/** 
		 * Returns a country display name for the specified language code for the default Locale country.
		 * @throws IllegalArgumentException
		 * <ul>
		 * 	<li>If invalid default Locale country code
		 * 	<li>If no local name exists for the Locale country in the specified language
		 * </ul> 
		 */
		public static String getCountryNameDefaultLocale (Iso639LanguageCode languageCode) throws IllegalArgumentException {
			Iso3166CountryCode country = Iso3166CountryCode.valueOf(Locale.getDefault().getCountry()); // throws IllegalArgumentException
			String name = country.getCountryName(languageCode);
			if (name == null) throw new IllegalArgumentException ("No display name for default Locale country and specified language");
			return name;
		}
		
		/** Returns the default Locale country in default language code. */
		public static String getCountryNameDefaultLocale() {
			Iso639LanguageCode languageCode = Iso639LanguageCode.valueOf(Locale.getDefault().getISO3Language());
			return getCountryNameDefaultLocale(languageCode);
		}
		
		/** Returns a Human readable representation for this enum */
		@Override public String toString() { return country.toString(); }
		
	}
	
}
