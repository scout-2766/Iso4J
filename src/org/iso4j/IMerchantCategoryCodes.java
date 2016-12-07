/**
 * DISCLAIMER
 * <p>
 * This java code consisting in java enumerations, interfaces and classes, hereafter <b>The Code</b>, has been prepared by <b>St&eacute;phane Coutant</b>, 
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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

/**
 * <code>IMerchantCategoryCodes</code> is an interface wrapping the ISO 18245 Merchant Category Codes (MCC) as a java enumeration with access methods 
 * to various information pertaining to MCC, such as Mastercard Transaction Category Code, Visa Merchant Category Group, and utility methods 
 * to get the enumeration values as a POJO list or in JSON (using GSON), classified according to scheme (Mastercard/Visa) classification or 
 * Thomson Reuters Business Classification standard. Also provides I18N support (fra & eng).
 * <p>
 * Input sources (C) 2005 MasterCard International Incorporated - The April 2005 Quick Reference Booklet, 
 *               (C) 2015 Visa - Merchant Data Standards Manual - October 2015  
 *               http://thomsonreuters.com/content/dam/openweb/documents/excel/tr-com-financial/trbc-industry-descriptions.xls
 * <p>
 * @author St&eacute;phane Coutant (fra)
 */


public interface IMerchantCategoryCodes {

	/** Common taxonomy getters */
	public interface ITaxonomy {
		public int 			getCode();
		public String		getDescription();
		public ITaxonomy	getParent();
	}
	
	/** Common taxonomy getters */
	public interface ITaxonomyList {
		public int 			getCode();
		public String		getLabel();
		public List<?>		getList();
	}
	
	/** Classification by MCC Range*/
	public enum MerchantCategoryRange implements ITaxonomy {
		
		// General
		AGRICULTURAL_SERVICES								(   1, 1499, Messages.getString("IMerchantCategoryCodes.MerchantCategoryRange.1")), //$NON-NLS-1$
		CONTRACTED_SERVICES									(1500, 2999, Messages.getString("IMerchantCategoryCodes.MerchantCategoryRange.2")), //$NON-NLS-1$
		TRANSPORTATION_SERVICES								(4000, 4799, Messages.getString("IMerchantCategoryCodes.MerchantCategoryRange.3")), //$NON-NLS-1$
		UTILITY_SERVICES 									(4800, 4999, Messages.getString("IMerchantCategoryCodes.MerchantCategoryRange.4")), //$NON-NLS-1$
		RETAIL_OUTLET_SERVICES								(5000, 5599, Messages.getString("IMerchantCategoryCodes.MerchantCategoryRange.5")), //$NON-NLS-1$
		CLOTHING_STORES										(5600, 5699, Messages.getString("IMerchantCategoryCodes.MerchantCategoryRange.6")), //$NON-NLS-1$
		MISCELLANEOUS_STORES								(5700, 7299, Messages.getString("IMerchantCategoryCodes.MerchantCategoryRange.7")), //$NON-NLS-1$
		BUSINESS_SERVICES 									(7300, 7999, Messages.getString("IMerchantCategoryCodes.MerchantCategoryRange.8")), //$NON-NLS-1$
		PROFESSIONAL_SERVICES_AND_MEMBERSHIP_ORGANISATIONS	(8000, 8999, Messages.getString("IMerchantCategoryCodes.MerchantCategoryRange.9")), //$NON-NLS-1$
		GOVERNMENT_SERVICES 								(9000, 9999, Messages.getString("IMerchantCategoryCodes.MerchantCategoryRange.10")), //$NON-NLS-1$
		
		// Travel & Entertainment
		TE_AIRLINES											(3000, 3299, Messages.getString("IMerchantCategoryCodes.MerchantCategoryRange.11")), //$NON-NLS-1$
		TE_CAR_RENTA										(3300, 3499, Messages.getString("IMerchantCategoryCodes.MerchantCategoryRange.12")), //$NON-NLS-1$
		TE_LODGING											(3500, 3999, Messages.getString("IMerchantCategoryCodes.MerchantCategoryRange.13")); //$NON-NLS-1$
		
		private String description;
		private int startRange;
		private int endRange;
		
		/** Builds a new Merchant Category range given start and range and description */
		private MerchantCategoryRange (int start, int end, String description) {
			this.description = description;
			this.startRange = start;
			this.endRange = end;
		}

		/** Gets the description for this Merchant Category range */
		@Override public String getDescription() { return description; }
		/** Gets the Merchant Category range code = sum of start and end range */
		@Override public int getCode() { return startRange + endRange; }
		/** Gets the Parent classification. Returns null as this is the root taxonomy */
		@Override public ITaxonomy getParent() { return null; }

		public int getStartRange() { return startRange; }
		public int getEndRange() { return endRange; }

		public static MerchantCategoryRange valueOf(int code) throws IllegalArgumentException {
			MerchantCategoryRange schemeCategory = null;
			for (MerchantCategoryRange category : values()) {
				if (code >= category.startRange && code <= category.endRange) { schemeCategory = category; break; }
			}
			if (schemeCategory == null) throw new IllegalArgumentException ("Invalid code (" + code + "): outside of allocated ranges"); //$NON-NLS-1$ //$NON-NLS-2$
			return schemeCategory;
		}
		
		/** Return a Human readable representation of this Country Code. */
		@Override public String toString() {
			return "["+String.format("%04d", startRange)+"-"+String.format("%04d", endRange)+ "] "+ description; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
		}

	}

	
	public enum MastercardMerchantCategory implements ITaxonomy {
		
		// As per Mastercard Merchant Categories
		AIRLINES							 		(Messages.getString("IMerchantCategoryCodes.MastercardMerchantCategory.1")), //$NON-NLS-1$
		AMUSEMENT_AND_ENTERTAINMENT			 		(Messages.getString("IMerchantCategoryCodes.MastercardMerchantCategory.2")), //$NON-NLS-1$
		AUTOMOBILE_VEHICLE_RENTAL			 		(Messages.getString("IMerchantCategoryCodes.MastercardMerchantCategory.3")), //$NON-NLS-1$
		AUTOMOBILES_AND_VEHICLES               		(Messages.getString("IMerchantCategoryCodes.MastercardMerchantCategory.4")), //$NON-NLS-1$
		BUSINESS_SERVICES					 		(Messages.getString("IMerchantCategoryCodes.MastercardMerchantCategory.5")), //$NON-NLS-1$
		CLOTHING_STORES						 		(Messages.getString("IMerchantCategoryCodes.MastercardMerchantCategory.6")), //$NON-NLS-1$
		CONTRACTED_SERVICES					 		(Messages.getString("IMerchantCategoryCodes.MastercardMerchantCategory.7")), //$NON-NLS-1$
		GOVERNMENT_SERVICES					 		(Messages.getString("IMerchantCategoryCodes.MastercardMerchantCategory.8")), //$NON-NLS-1$
		HOTELS_MOTELS						 		(Messages.getString("IMerchantCategoryCodes.MastercardMerchantCategory.9")), //$NON-NLS-1$
		MOTO								 		(Messages.getString("IMerchantCategoryCodes.MastercardMerchantCategory.10")), //$NON-NLS-1$
		MISCELLANEOUS_STORES				 		(Messages.getString("IMerchantCategoryCodes.MastercardMerchantCategory.11")), //$NON-NLS-1$
		PERSONAL_SERVICE_PROVIDERS			 		(Messages.getString("IMerchantCategoryCodes.MastercardMerchantCategory.12")), //$NON-NLS-1$
		PROFESSIONAL_SERVICES_AND_MEMBERSHIP 		(Messages.getString("IMerchantCategoryCodes.MastercardMerchantCategory.13")), //$NON-NLS-1$
		REPAIR_SERVICES								(Messages.getString("IMerchantCategoryCodes.MastercardMerchantCategory.14")), //$NON-NLS-1$
		RETAIL_STORES 								(Messages.getString("IMerchantCategoryCodes.MastercardMerchantCategory.15")), //$NON-NLS-1$
		SERVICE_PROVIDERS 							(Messages.getString("IMerchantCategoryCodes.MastercardMerchantCategory.16")), //$NON-NLS-1$
		TRANSPORTATION 								(Messages.getString("IMerchantCategoryCodes.MastercardMerchantCategory.17")), //$NON-NLS-1$
		MASTERCARD_UK								(Messages.getString("IMerchantCategoryCodes.MastercardMerchantCategory.18")), //$NON-NLS-1$
		UTILITIES 									(Messages.getString("IMerchantCategoryCodes.MastercardMerchantCategory.19")), //$NON-NLS-1$
		WHOLESALE 									(Messages.getString("IMerchantCategoryCodes.MastercardMerchantCategory.20")), //$NON-NLS-1$
		
		// Visa ONLY
		VISA_SERVICES								(Messages.getString("IMerchantCategoryCodes.MastercardMerchantCategory.21")); //$NON-NLS-1$
		
		/** The description for this Merchant Head Category*/
		private String description;
		
		/** Builds a new MastercardMerchantCategory given its description */
		private MastercardMerchantCategory(String description) {
			this.description = description;
		}
		
		/** Gets this MastercardMerchantCategory description */
		@Override public String getDescription() { return description; }
		/** Gets the code for this MastercardMerchantCategory = enum ordinal value */
		@Override public int getCode() { return this.ordinal(); }
		/** Gets the Parent classification. Return nulls as this is not related to a specific range, even if the top taxonomy is the MerchantCategoryRange */
		@Override public ITaxonomy getParent() { return null; }
		
		/** Return a Human readable representation of this Country Code. */
		@Override public String toString() {
			return "(" + getCode() + ") " + description; //$NON-NLS-1$ //$NON-NLS-2$
		}

	}
	
	// Shorthands
	final static MastercardMerchantCategory AIRLINES = MastercardMerchantCategory.AIRLINES;
	final static MastercardMerchantCategory AMUSEMENT_AND_ENTERTAINMENT = MastercardMerchantCategory.AMUSEMENT_AND_ENTERTAINMENT;
	final static MastercardMerchantCategory AUTOMOBILE_VEHICLE_RENTAL = MastercardMerchantCategory.AUTOMOBILE_VEHICLE_RENTAL;
	final static MastercardMerchantCategory AUTOMOBILES_AND_VEHICLES = MastercardMerchantCategory.AUTOMOBILES_AND_VEHICLES;
	final static MastercardMerchantCategory BUSINESS_SERVICES = MastercardMerchantCategory.BUSINESS_SERVICES;
	final static MastercardMerchantCategory CLOTHING_STORES = MastercardMerchantCategory.CLOTHING_STORES;
	final static MastercardMerchantCategory CONTRACTED_SERVICES = MastercardMerchantCategory.CONTRACTED_SERVICES;
	final static MastercardMerchantCategory GOVERNMENT_SERVICES = MastercardMerchantCategory.GOVERNMENT_SERVICES;
	final static MastercardMerchantCategory HOTELS_MOTELS = MastercardMerchantCategory.HOTELS_MOTELS;
	final static MastercardMerchantCategory MOTO = MastercardMerchantCategory.MOTO;
	final static MastercardMerchantCategory MISCELLANEOUS_STORES = MastercardMerchantCategory.MISCELLANEOUS_STORES;
	final static MastercardMerchantCategory PERSONAL_SERVICES_PROVIDERS = MastercardMerchantCategory.PERSONAL_SERVICE_PROVIDERS;
	final static MastercardMerchantCategory PROFESSIONAL_SERVICES = MastercardMerchantCategory.PROFESSIONAL_SERVICES_AND_MEMBERSHIP;
	final static MastercardMerchantCategory MEMBERSHIP_ORGANIZATIONS = MastercardMerchantCategory.PROFESSIONAL_SERVICES_AND_MEMBERSHIP;
	final static MastercardMerchantCategory REPAIR_SERVICES = MastercardMerchantCategory.REPAIR_SERVICES;
	final static MastercardMerchantCategory RETAIL_STORES = MastercardMerchantCategory.RETAIL_STORES;
	final static MastercardMerchantCategory SERVICE_PROVIDERS = MastercardMerchantCategory.SERVICE_PROVIDERS;
	final static MastercardMerchantCategory TRANSPORTATION = MastercardMerchantCategory.TRANSPORTATION;
	final static MastercardMerchantCategory MASTERCARD_UK = MastercardMerchantCategory.MASTERCARD_UK;
	final static MastercardMerchantCategory UTILITIES = MastercardMerchantCategory.UTILITIES;
	final static MastercardMerchantCategory WHOLESALE = MastercardMerchantCategory.WHOLESALE;
	final static MastercardMerchantCategory VISA_SERVICES = MastercardMerchantCategory.VISA_SERVICES;
	
	/** Visa Merchant Category Group codes (expense types) */
	public enum VisaMerchantCategoryGroup {
		
		MCG_1_COMMERCIAL_TRAVEL_AIRLINES	(1, Messages.getString("IMerchantCategoryCodes.VisaMerchantCategoryGroup.1")), //$NON-NLS-1$
		MCG_2_LODGING						(2, Messages.getString("IMerchantCategoryCodes.VisaMerchantCategoryGroup.2")), //$NON-NLS-1$
		MCG_3_AUTO_RENTAL					(3, Messages.getString("IMerchantCategoryCodes.VisaMerchantCategoryGroup.3")), //$NON-NLS-1$
		MCG_4_RESTAURANT					(4, Messages.getString("IMerchantCategoryCodes.VisaMerchantCategoryGroup.4")), //$NON-NLS-1$
		MCG_5_MOTO_EC						(5, Messages.getString("IMerchantCategoryCodes.VisaMerchantCategoryGroup.5")), //$NON-NLS-1$
		MCG_6_RISKY_PURCHASE				(6, Messages.getString("IMerchantCategoryCodes.VisaMerchantCategoryGroup.6")), //$NON-NLS-1$
		MCG_7_OTHER							(7, Messages.getString("IMerchantCategoryCodes.VisaMerchantCategoryGroup.7")), //$NON-NLS-1$
		MCG_8_OTHER_MANUAL_CASH				(8, Messages.getString("IMerchantCategoryCodes.VisaMerchantCategoryGroup.8")), //$NON-NLS-1$
		MCG_9_ATM							(9, Messages.getString("IMerchantCategoryCodes.VisaMerchantCategoryGroup.9")), //$NON-NLS-1$
		MCG_10_QUASI_CASH					(10, Messages.getString("IMerchantCategoryCodes.VisaMerchantCategoryGroup.10")), //$NON-NLS-1$
		MCG_11_MEDICAL						(11, Messages.getString("IMerchantCategoryCodes.VisaMerchantCategoryGroup.11")); //$NON-NLS-1$
		
		private int code;
		private String label;
		
		private VisaMerchantCategoryGroup(int code, String label) {
			this.code = code;
			this.label = label;
		}
		
		public String getLabel() { return label; } 
		public int getCode() { return code; }
		
		/** Return a Human readable representation of this Country Code. */
		@Override public String toString() {
			return "(" + getCode() + ") " + label; //$NON-NLS-1$ //$NON-NLS-2$
		}

	}
	
	// Shorthands
	final static VisaMerchantCategoryGroup MCG_1_TRA = VisaMerchantCategoryGroup.MCG_1_COMMERCIAL_TRAVEL_AIRLINES;
	final static VisaMerchantCategoryGroup MCG_2_HOT = VisaMerchantCategoryGroup.MCG_2_LODGING;
	final static VisaMerchantCategoryGroup MCG_3_AUT = VisaMerchantCategoryGroup.MCG_3_AUTO_RENTAL;
	final static VisaMerchantCategoryGroup MCG_4_RES = VisaMerchantCategoryGroup.MCG_4_RESTAURANT;
	final static VisaMerchantCategoryGroup MCG_5_MEC = VisaMerchantCategoryGroup.MCG_5_MOTO_EC;
	final static VisaMerchantCategoryGroup MCG_6_RSK = VisaMerchantCategoryGroup.MCG_6_RISKY_PURCHASE;
	final static VisaMerchantCategoryGroup MCG_7_OTH = VisaMerchantCategoryGroup.MCG_7_OTHER;
	final static VisaMerchantCategoryGroup MCG_8_CSH = VisaMerchantCategoryGroup.MCG_8_OTHER_MANUAL_CASH;
	final static VisaMerchantCategoryGroup MCG_9_ATM = VisaMerchantCategoryGroup.MCG_9_ATM;
	final static VisaMerchantCategoryGroup MCG_10_QUA = VisaMerchantCategoryGroup.MCG_10_QUASI_CASH;
	final static VisaMerchantCategoryGroup MCG_11_MED = VisaMerchantCategoryGroup.MCG_11_MEDICAL;
	
	/** Mastercard Transaction Category Codes */
	public enum MastercardTransactionCategoryCode {
		
		TCC_A_AUTOMOBILE_VEHICLE_RENTAL						('A', Messages.getString("IMerchantCategoryCodes.MastercardTransactionCategoryCode.A")), //$NON-NLS-1$
		TCC_C_CASH_DISBURSEMENT								('C', Messages.getString("IMerchantCategoryCodes.MastercardTransactionCategoryCode.C")), //$NON-NLS-1$
		TCC_Z_CASH_DISBURSEMENT_ATM							('Z', Messages.getString("IMerchantCategoryCodes.MastercardTransactionCategoryCode.Z")), //$NON-NLS-1$
		TCC_F_RESTAURANT									('F', Messages.getString("IMerchantCategoryCodes.MastercardTransactionCategoryCode.F")), //$NON-NLS-1$
		TCC_H_HOTEL_MOTEL									('H', Messages.getString("IMerchantCategoryCodes.MastercardTransactionCategoryCode.H")), //$NON-NLS-1$
		TCC_O_COLLEGE_SCHOOL_EXPENSE						('O', Messages.getString("IMerchantCategoryCodes.MastercardTransactionCategoryCode.OC")), //$NON-NLS-1$
		TCC_O_HOSPITAL										('O', Messages.getString("IMerchantCategoryCodes.MastercardTransactionCategoryCode.OH")), //$NON-NLS-1$
		TCC_P_PAYMENT_TRANSACTION							('P', Messages.getString("IMerchantCategoryCodes.MastercardTransactionCategoryCode.P")), //$NON-NLS-1$
		TCC_R_ALL_OTHER_MERCHANTS							('R', Messages.getString("IMerchantCategoryCodes.MastercardTransactionCategoryCode.R")), //$NON-NLS-1$
		TCC_T_ALL_OTHER_NON_F2F_TRANSACTION					('T', Messages.getString("IMerchantCategoryCodes.MastercardTransactionCategoryCode.T")), //$NON-NLS-1$
		TCC_U_UNIQUE_TRANSACTION_QUASI_CASH_DISBURSEMENT	('U', Messages.getString("IMerchantCategoryCodes.MastercardTransactionCategoryCode.UQ")), //$NON-NLS-1$
		TCC_U_CARDHOLDER_ACTIVATED_TERMINAL_IFC				('U', Messages.getString("IMerchantCategoryCodes.MastercardTransactionCategoryCode.UC")), //$NON-NLS-1$
		TCC_U_OTHER											('U', Messages.getString("IMerchantCategoryCodes.MastercardTransactionCategoryCode.UO")), //$NON-NLS-1$
		TCC_R_CARDHOLDER_ACTIVATED_TERMINAL_OTHER			('R', Messages.getString("IMerchantCategoryCodes.MastercardTransactionCategoryCode.RCAT")), //$NON-NLS-1$
		TCC_X_AIRLINES										('X', Messages.getString("IMerchantCategoryCodes.MastercardTransactionCategoryCode.XA")), //$NON-NLS-1$
		TCC_X_RAILROAD										('X', Messages.getString("IMerchantCategoryCodes.MastercardTransactionCategoryCode.XR")), //$NON-NLS-1$
		TCC_X_TRAVEL_AGENCY_TRANSPORTATION					('X', Messages.getString("IMerchantCategoryCodes.MastercardTransactionCategoryCode.XT")); //$NON-NLS-1$

		private char code;
		private String label;
		
		private MastercardTransactionCategoryCode(char code, String label) {
			this.code = code;
			this.label = label;
		}
		
		public String getLabel() { return label; }
		public char getCode() { return code; }
		
		/** Return a Human readable representation of this Country Code. */
		@Override public String toString() {
			return "(" + getCode() + ") " + label; //$NON-NLS-1$ //$NON-NLS-2$
		}

	}

	// Shorthands
	final static MastercardTransactionCategoryCode TCC_A_CAR = MastercardTransactionCategoryCode.TCC_A_AUTOMOBILE_VEHICLE_RENTAL;
	final static MastercardTransactionCategoryCode TCC_C_CSH = MastercardTransactionCategoryCode.TCC_C_CASH_DISBURSEMENT;								
	final static MastercardTransactionCategoryCode TCC_Z_ATM = MastercardTransactionCategoryCode.TCC_Z_CASH_DISBURSEMENT_ATM;						
	final static MastercardTransactionCategoryCode TCC_F_RES = MastercardTransactionCategoryCode.TCC_F_RESTAURANT;						
	final static MastercardTransactionCategoryCode TCC_H_HOT = MastercardTransactionCategoryCode.TCC_H_HOTEL_MOTEL;								
	final static MastercardTransactionCategoryCode TCC_O_SCH = MastercardTransactionCategoryCode.TCC_O_COLLEGE_SCHOOL_EXPENSE;					
	final static MastercardTransactionCategoryCode TCC_O_HOS = MastercardTransactionCategoryCode.TCC_O_HOSPITAL;					
	final static MastercardTransactionCategoryCode TCC_P_TRX = MastercardTransactionCategoryCode.TCC_P_PAYMENT_TRANSACTION;							
	final static MastercardTransactionCategoryCode TCC_R_OTH = MastercardTransactionCategoryCode.TCC_R_ALL_OTHER_MERCHANTS;						
	final static MastercardTransactionCategoryCode TCC_T_OTH = MastercardTransactionCategoryCode.TCC_T_ALL_OTHER_NON_F2F_TRANSACTION;					
	final static MastercardTransactionCategoryCode TCC_U_QEC = MastercardTransactionCategoryCode.TCC_U_UNIQUE_TRANSACTION_QUASI_CASH_DISBURSEMENT;	
	final static MastercardTransactionCategoryCode TCC_U_IFC = MastercardTransactionCategoryCode.TCC_U_CARDHOLDER_ACTIVATED_TERMINAL_IFC;	
	final static MastercardTransactionCategoryCode TCC_U_OTH = MastercardTransactionCategoryCode.TCC_U_OTHER;	
	final static MastercardTransactionCategoryCode TCC_R_CAT = MastercardTransactionCategoryCode.TCC_R_CARDHOLDER_ACTIVATED_TERMINAL_OTHER;			
	final static MastercardTransactionCategoryCode TCC_X_AIR = MastercardTransactionCategoryCode.TCC_X_AIRLINES;		
	final static MastercardTransactionCategoryCode TCC_X_RLW = MastercardTransactionCategoryCode.TCC_X_RAILROAD;									
	final static MastercardTransactionCategoryCode TCC_X_TRA = MastercardTransactionCategoryCode.TCC_X_TRAVEL_AGENCY_TRANSPORTATION;					
	
	
	// **************************************************
	
	// Another way to classify the Merchant Category Codes using a standard: the Thomson Reuters Business Classification in levels 
	// Economic sector - Business Sector - Industry Group and Industry 
	// (this has been preferred over Global Industry Classification Standard more focused on finance)
	// Indeed, the schemes have in view Corporate services and Risks when they categorise the MCCs, which is not a "natural" way to classify
	// a merchant activity. 
	
	/** The Thomson Reuters Rusiness Classification - Economic Sector categories, plus public sector (and other). */
	public enum TRBCEconomicSector implements ITaxonomy {
	
		// As per TRBC
		ENERGY										(50, Messages.getString("IMerchantCategoryCodes.TRBCEconomicSector.50")), //$NON-NLS-1$
		BASIC_MATERIALS								(51, Messages.getString("IMerchantCategoryCodes.TRBCEconomicSector.51")), //$NON-NLS-1$
		INDUSTRIALS									(52, Messages.getString("IMerchantCategoryCodes.TRBCEconomicSector.52")), //$NON-NLS-1$
		CONSUMER_CYCLICALS							(53, Messages.getString("IMerchantCategoryCodes.TRBCEconomicSector.53")), //$NON-NLS-1$
		CONSUMER_NON_CYCLICALS						(54, Messages.getString("IMerchantCategoryCodes.TRBCEconomicSector.54")), //$NON-NLS-1$
		FINANCIALS									(55, Messages.getString("IMerchantCategoryCodes.TRBCEconomicSector.55")), //$NON-NLS-1$
		HEALTH_CARE									(56, Messages.getString("IMerchantCategoryCodes.TRBCEconomicSector.56")), //$NON-NLS-1$
		TECHNOLOGY									(57, Messages.getString("IMerchantCategoryCodes.TRBCEconomicSector.57")), //$NON-NLS-1$
		TELECOMMUNICATION_SERVICES					(58, Messages.getString("IMerchantCategoryCodes.TRBCEconomicSector.58")), //$NON-NLS-1$
		UTILITIES									(59, Messages.getString("IMerchantCategoryCodes.TRBCEconomicSector.59")), //$NON-NLS-1$
		
		// Not in TRBC, but needed
		PUBLIC_SECTOR								(100, Messages.getString("IMerchantCategoryCodes.TRBCEconomicSector.100")), //$NON-NLS-1$
		MEMBERSHIP_ORGANIZATIONS					(101, Messages.getString("IMerchantCategoryCodes.TRBCEconomicSector.101")), //$NON-NLS-1$
		OTHER										(102, Messages.getString("IMerchantCategoryCodes.TRBCEconomicSector.102")); //$NON-NLS-1$
		
		/** The TRBC 2 digit code, or fake one if not in TRBC classification */
		private int code;
		/** The description for this economic sector */
		private String description;
		
		/** Builds a new TRBC Economic Sector enumeration value with given code and description. */
		private TRBCEconomicSector (int code, String description) {
			this.code = code;
			this.description = description;
		}
		
		// Fulfils IClassification contract
		// --------------------------------
		
		/** Gets the code allocated by TR */
		@Override public int getCode() { return code; }
		/** Gets the description for TR */
		@Override public String getDescription() {return description; }
		/** Gets the Parent classification = null: root. */
		@Override public ITaxonomy getParent() { return null; }
		
		/** Return a Human readable representation of this Country Code. */
		@Override public String toString() {
			return description + " (" + getCode() + "), root"; //$NON-NLS-1$ //$NON-NLS-2$
		}

	}
	
	/** The Thomson Reuters Business Classification - Business Sector categories. */
	public enum TRBCBusinessSector implements ITaxonomy {

		// As per TRBC
		ENERGY_FOSSIL_FUELS																(10, TRBCEconomicSector.ENERGY, Messages.getString("IMerchantCategoryCodes.TRBCBusinessSector.5010")), //$NON-NLS-1$
		RENEWABLE_ENERGY																(20, TRBCEconomicSector.ENERGY, Messages.getString("IMerchantCategoryCodes.TRBCBusinessSector.5020")), //$NON-NLS-1$
		URANIUM																			(30, TRBCEconomicSector.ENERGY, Messages.getString("IMerchantCategoryCodes.TRBCBusinessSector.5030")), //$NON-NLS-1$
		CHEMICALS																		(10, TRBCEconomicSector.BASIC_MATERIALS , Messages.getString("IMerchantCategoryCodes.TRBCBusinessSector.5110")), //$NON-NLS-1$
		MINERAL_RESOURCES																(20, TRBCEconomicSector.BASIC_MATERIALS , Messages.getString("IMerchantCategoryCodes.TRBCBusinessSector.5120")), //$NON-NLS-1$
		APPLIED_RESOURCES																(30, TRBCEconomicSector.BASIC_MATERIALS , Messages.getString("IMerchantCategoryCodes.TRBCBusinessSector.5130")), //$NON-NLS-1$
		INDUSTRIAL_GOODS																(10, TRBCEconomicSector.INDUSTRIALS , Messages.getString("IMerchantCategoryCodes.TRBCBusinessSector.5210")), 	 //$NON-NLS-1$
		INDUSTRIAL_AND_COMMERCIAL_SERVICES												(20, TRBCEconomicSector.INDUSTRIALS, Messages.getString("IMerchantCategoryCodes.TRBCBusinessSector.5220")), 	 //$NON-NLS-1$
		INDUSTRIAL_CONGLOMERATES														(30, TRBCEconomicSector.INDUSTRIALS, Messages.getString("IMerchantCategoryCodes.TRBCBusinessSector.5230")), 	 //$NON-NLS-1$
		TRANSPORTATION																	(30, TRBCEconomicSector.INDUSTRIALS, Messages.getString("IMerchantCategoryCodes.TRBCBusinessSector.5240")), 	 //$NON-NLS-1$
		AUTOMOBILES_AND_AUTO_PARTS														(10, TRBCEconomicSector.CONSUMER_CYCLICALS ,Messages.getString("IMerchantCategoryCodes.TRBCBusinessSector.5310")), 	 //$NON-NLS-1$
		CYCLICAL_CONSUMER_PRODUCTS														(20, TRBCEconomicSector.CONSUMER_CYCLICALS, Messages.getString("IMerchantCategoryCodes.TRBCBusinessSector.5320")), 	 //$NON-NLS-1$
		CYCLICAL_CONSUMER_SERVICES														(30, TRBCEconomicSector.CONSUMER_CYCLICALS , Messages.getString("IMerchantCategoryCodes.TRBCBusinessSector.5330")), 	 //$NON-NLS-1$
		RETAILERS																		(40, TRBCEconomicSector.CONSUMER_CYCLICALS , Messages.getString("IMerchantCategoryCodes.TRBCBusinessSector.5340")), 	 //$NON-NLS-1$
		FOOD_AND_BEVERAGES																(10, TRBCEconomicSector.CONSUMER_NON_CYCLICALS, Messages.getString("IMerchantCategoryCodes.TRBCBusinessSector.5410")), 	 //$NON-NLS-1$
		PERSONAL_AND_HOUSEHOLD_PRODUCTS_AND_SERVICES									(20, TRBCEconomicSector.CONSUMER_NON_CYCLICALS , Messages.getString("IMerchantCategoryCodes.TRBCBusinessSector.5420")), 	 //$NON-NLS-1$
		FOOD_AND_DRUG_RETAILING															(30, TRBCEconomicSector.CONSUMER_NON_CYCLICALS, Messages.getString("IMerchantCategoryCodes.TRBCBusinessSector.5430")), 	 //$NON-NLS-1$
		BANKING_AND_INVESTMENT_SERVICES													(10, TRBCEconomicSector.FINANCIALS, Messages.getString("IMerchantCategoryCodes.TRBCBusinessSector.5510")), 	 //$NON-NLS-1$
		INSURANCE																		(30, TRBCEconomicSector.FINANCIALS , Messages.getString("IMerchantCategoryCodes.TRBCBusinessSector.5530")), 	 //$NON-NLS-1$
		REAL_ESTATE																		(40, TRBCEconomicSector.FINANCIALS , Messages.getString("IMerchantCategoryCodes.TRBCBusinessSector.5540")),	 //$NON-NLS-1$
		COLLECTIVE_INVESTMENTS															(50, TRBCEconomicSector.FINANCIALS, Messages.getString("IMerchantCategoryCodes.TRBCBusinessSector.5550")), 	 //$NON-NLS-1$
		HOLDING_COMPANIES																(60, TRBCEconomicSector.FINANCIALS, Messages.getString("IMerchantCategoryCodes.TRBCBusinessSector.5560")), 	 //$NON-NLS-1$
		HEALTH_CARE_SERVICES															(10, TRBCEconomicSector.HEALTH_CARE, Messages.getString("IMerchantCategoryCodes.TRBCBusinessSector.5610")), 	 //$NON-NLS-1$
		PHARMACEUTICALS_AND_MEDICAL_RESEARCH											(20, TRBCEconomicSector.HEALTH_CARE, Messages.getString("IMerchantCategoryCodes.TRBCBusinessSector.5620")), 	 //$NON-NLS-1$
		TECHNOLOGY_EQUIPMENT															(10, TRBCEconomicSector.TECHNOLOGY,  Messages.getString("IMerchantCategoryCodes.TRBCBusinessSector.5710")), 	 //$NON-NLS-1$
		SOFTWARE_AND_IT_SERVICES														(20, TRBCEconomicSector.TECHNOLOGY,  Messages.getString("IMerchantCategoryCodes.TRBCBusinessSector.5720")), 	 //$NON-NLS-1$
		TELECOMMUNICATION_SERVICES														(10, TRBCEconomicSector.TELECOMMUNICATION_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCBusinessSector.5810")), 	 //$NON-NLS-1$
		UTILITIES																		(10, TRBCEconomicSector.UTILITIES, Messages.getString("IMerchantCategoryCodes.TRBCBusinessSector.5910")), 	 //$NON-NLS-1$

		// Not in TRBC, but needed
		GOVERNMENT_SERVICES																(10, TRBCEconomicSector.PUBLIC_SECTOR, Messages.getString("IMerchantCategoryCodes.TRBCBusinessSector.10010")),  //$NON-NLS-1$
		MEMBERSHIP_ORGANIZATIONS														(10, TRBCEconomicSector.MEMBERSHIP_ORGANIZATIONS, Messages.getString("IMerchantCategoryCodes.TRBCBusinessSector.10110")), //$NON-NLS-1$
		OTHER																			(10, TRBCEconomicSector.OTHER, Messages.getString("IMerchantCategoryCodes.TRBCBusinessSector.10210")); //$NON-NLS-1$
		
		
		/** The economic sector this business sector belongs to */
		private TRBCEconomicSector economicSector;
		/** The last 2 digits of the TRBC code, rebuilt when invoking {@link #getCode()} */
		private int code;
		/** This industry description */
		private String description;

		/** Builds a new TRBC Business Sector enumeration value, linking this value with parent <code>economicSector</code> classification */
		private TRBCBusinessSector (int code, TRBCEconomicSector economicSector, String description) {
			this.code = code;
			this.economicSector = economicSector;
			this.description = description;
		}
		
		// Fulfils IClassification contract
		// --------------------------------
		
		/** Gets the TRBC code (or fake for non-TRBC enum value); rebuilds the entire code by invoking parent one. */
		@Override public int getCode() { return Integer.valueOf(Integer.toString(getParent().getCode())+Integer.toString(code)); }
		/** Gets this sub-Industry description. */
		@Override public String getDescription() {return description; }
		/** Gets the Parent classification = economic sector. */
		@Override public ITaxonomy getParent() { return economicSector; }

		/** Return a Human readable representation of this Country Code. */
		@Override public String toString() {
			return description + " (" + getCode() + ") <- " + economicSector; //$NON-NLS-1$ //$NON-NLS-2$
		}

	}
	
	/** The Thomson Reuters Rusiness Classification - Industry Group categories, plus public sector (from NAICS). */
	public enum TRBCIndustryGroup implements ITaxonomy {

		// As per TRBC
		COAL																			(10, TRBCBusinessSector.ENERGY_FOSSIL_FUELS, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.501010")), //$NON-NLS-1$
		OIL_AND_GAS																		(20, TRBCBusinessSector.ENERGY_FOSSIL_FUELS, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.501020")),	 //$NON-NLS-1$
		OIL_AND_GAS_RELATED_EQUIPMENT_AND_SERVICES										(30, TRBCBusinessSector.ENERGY_FOSSIL_FUELS, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.501030")), //$NON-NLS-1$
		RENEWABLE_ENERGY																(10, TRBCBusinessSector.RENEWABLE_ENERGY, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.502010")), //$NON-NLS-1$
		URANIUM																			(10, TRBCBusinessSector.URANIUM, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.503010")), //$NON-NLS-1$
		CHEMICALS																		(10, TRBCBusinessSector.CHEMICALS, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.511010")), 	 //$NON-NLS-1$
		METALS_AND_MINING																(10, TRBCBusinessSector.MINERAL_RESOURCES, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.512010")), 	 //$NON-NLS-1$
		CONSTRUCTION_MATERIALS															(20, TRBCBusinessSector.MINERAL_RESOURCES, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.512020")), 	 //$NON-NLS-1$
		PAPER_AND_FOREST_PRODUCTS														(10, TRBCBusinessSector.APPLIED_RESOURCES, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.513010")), 	 //$NON-NLS-1$
		CONTAINERS_AND_PACKAGING														(20, TRBCBusinessSector.APPLIED_RESOURCES, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.513020")), 	 //$NON-NLS-1$
		AEROSPACE_AND_DEFENSE															(10, TRBCBusinessSector.INDUSTRIAL_GOODS, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.521010")), 	 //$NON-NLS-1$
		MACHINERY_EQUIPMENT_AND_COMPONENTS												(20, TRBCBusinessSector.INDUSTRIAL_GOODS, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.521020")), 	 //$NON-NLS-1$
		CONSTRUCTION_AND_ENGINEERING													(10, TRBCBusinessSector.INDUSTRIAL_AND_COMMERCIAL_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.522010")), 	 //$NON-NLS-1$
		DIVERSIFIED_TRADING_AND_DISTRIBUTING											(20, TRBCBusinessSector.INDUSTRIAL_AND_COMMERCIAL_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.522020")), 	 //$NON-NLS-1$
		PROFESSIONAL_AND_COMMERCIAL_SERVICES											(30, TRBCBusinessSector.INDUSTRIAL_AND_COMMERCIAL_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.522030")), 	 //$NON-NLS-1$
		INDUSTRIAL_CONGLOMERATES														(10, TRBCBusinessSector.INDUSTRIAL_CONGLOMERATES, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.523010")), 	 //$NON-NLS-1$
		FREIGHT_AND_LOGISTICS_SERVICES													(50, TRBCBusinessSector.TRANSPORTATION, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.524050")), 	 //$NON-NLS-1$
		PASSENGER_TRANSPORTATION_SERVICES												(60, TRBCBusinessSector.TRANSPORTATION, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.524060")),  //$NON-NLS-1$
		TRANSPORT_INFRASTRUCTURE														(70, TRBCBusinessSector.TRANSPORTATION, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.524070")), 	 //$NON-NLS-1$
		AUTOMOBILES_AND_AUTO_PARTS														(10, TRBCBusinessSector.AUTOMOBILES_AND_AUTO_PARTS, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.531010")), 	 //$NON-NLS-1$
		TEXTILES_AND_APPAREL															(20, TRBCBusinessSector.CYCLICAL_CONSUMER_PRODUCTS, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.531020")), 	 //$NON-NLS-1$
		HOMEBUILDING_AND_CONSTRUCTION_SUPPLIES											(30, TRBCBusinessSector.CYCLICAL_CONSUMER_PRODUCTS, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.531030")), 	 //$NON-NLS-1$
		HOUSEHOLD_GOODS																	(40, TRBCBusinessSector.CYCLICAL_CONSUMER_PRODUCTS, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.531040")), 	 //$NON-NLS-1$
		LEISURE_PRODUCTS																(50, TRBCBusinessSector.CYCLICAL_CONSUMER_PRODUCTS, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.531050")), 	 //$NON-NLS-1$
		HOTELS_AND_ENTERTAINMENT_SERVICES												(10, TRBCBusinessSector.CYCLICAL_CONSUMER_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.533010")), 	 //$NON-NLS-1$
		MEDIA_AND_PUBLISHING															(20, TRBCBusinessSector.CYCLICAL_CONSUMER_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.533030")), 	 //$NON-NLS-1$
		DIVERSIFIED_RETAIL																(20, TRBCBusinessSector.RETAILERS, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.534020")), 	 //$NON-NLS-1$
		OTHER_SPECIALTY_RETAILERS														(30, TRBCBusinessSector.RETAILERS, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.534030")), 	 //$NON-NLS-1$
		BEVERAGES																		(10, TRBCBusinessSector.FOOD_AND_BEVERAGES, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.541010")), 	 //$NON-NLS-1$
		FOOD_AND_TOBACCO																(20, TRBCBusinessSector.FOOD_AND_BEVERAGES, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.541020")), 	 //$NON-NLS-1$
		PERSONAL_AND_HOUSEHOLD_PRODUCTS_AND_SERVICES									(10, TRBCBusinessSector.PERSONAL_AND_HOUSEHOLD_PRODUCTS_AND_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.542010")), 	 //$NON-NLS-1$
		FOOD_AND_DRUG_RETAILING															(10, TRBCBusinessSector.FOOD_AND_DRUG_RETAILING, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.543010")), 	 //$NON-NLS-1$
		BANKING_SERVICES																(10, TRBCBusinessSector.BANKING_AND_INVESTMENT_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.551010")), 	 //$NON-NLS-1$
		INVESTMENT_BANKING_AND_INVESTMENT_SERVICES										(20, TRBCBusinessSector.BANKING_AND_INVESTMENT_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.551020")), 	 //$NON-NLS-1$
		INSURANCE																		(10, TRBCBusinessSector.INSURANCE, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.553010")), 	 //$NON-NLS-1$
		REAL_ESTATE_OPERATIONS															(20, TRBCBusinessSector.REAL_ESTATE, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.554020")), 	 //$NON-NLS-1$
		RESIDENTIAL_AND_COMMERCIAL_REITS												(30, TRBCBusinessSector.REAL_ESTATE, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.554030")), //$NON-NLS-1$
		COLLECTIVE_INVESTMENTS															(10, TRBCBusinessSector.COLLECTIVE_INVESTMENTS, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.555010")), 	 //$NON-NLS-1$
		HOLDING_COMPANIES																(10, TRBCBusinessSector.HOLDING_COMPANIES, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.556010")), 	 //$NON-NLS-1$
		HEALTH_CARE_EQUIPMENT_AND_SUPPLIES												(10, TRBCBusinessSector.HEALTH_CARE_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.561010")), 	 //$NON-NLS-1$
		HEALTH_CARE_PROVIDERS_AND_SERVICES												(20, TRBCBusinessSector.HEALTH_CARE_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.561020")), 	 //$NON-NLS-1$
		PHARMACEUTICALS																	(10, TRBCBusinessSector.PHARMACEUTICALS_AND_MEDICAL_RESEARCH, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.562010")), 	 //$NON-NLS-1$
		BIOTECHNOLOGY_AND_MEDICAL_RESEARCH												(20, TRBCBusinessSector.PHARMACEUTICALS_AND_MEDICAL_RESEARCH, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.562020")), 	 //$NON-NLS-1$
		SEMICONDUCTORS_AND_SEMICONDUCTOR_EQUIPMENT										(10, TRBCBusinessSector.TECHNOLOGY_EQUIPMENT, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.571010")), 	 //$NON-NLS-1$
		COMMUNICATIONS_AND_NETWORKING													(20, TRBCBusinessSector.TECHNOLOGY_EQUIPMENT, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.571020")), 	 //$NON-NLS-1$
		ELECTRONIC_EQUIPMENT_AND_PARTS													(40, TRBCBusinessSector.TECHNOLOGY_EQUIPMENT, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.571040")), 	 //$NON-NLS-1$
		OFFICE_EQUIPMENT																(50, TRBCBusinessSector.TECHNOLOGY_EQUIPMENT, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.571050")), 	 //$NON-NLS-1$
		COMPUTERS_PHONES_AND_HOUSEHOLD_ELECTRONICS										(60, TRBCBusinessSector.TECHNOLOGY_EQUIPMENT, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.571060")), 	 //$NON-NLS-1$
		SOFTWARE_AND_IT_SERVICES														(10, TRBCBusinessSector.SOFTWARE_AND_IT_SERVICES,  Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.572010")), 	 //$NON-NLS-1$
		TELECOMMUNICATION_SERVICES														(10, TRBCBusinessSector.TELECOMMUNICATION_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.581010")), 	 //$NON-NLS-1$
		ELECTRIC_UTILITIES_AND_IPPs														(10, TRBCBusinessSector.UTILITIES , Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.591010")), 	 //$NON-NLS-1$
		NATURAL_GAS_UTILITIES															(20, TRBCBusinessSector.UTILITIES , Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.591020")), 	 //$NON-NLS-1$
		WATER_AND_OTHER_UTILITIES														(30, TRBCBusinessSector.UTILITIES , Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.591030")), 	 //$NON-NLS-1$
		MULTILINE_UTILITIES																(40, TRBCBusinessSector.UTILITIES , Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.591040")), 	 //$NON-NLS-1$
		
		// Not in TRBC, but needed
		GOVERNMENT_SERVICES																(10, TRBCBusinessSector.GOVERNMENT_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.1001010")),  //$NON-NLS-1$
		MEMBERSHIP_ORGANIZATIONS														(10, TRBCBusinessSector.MEMBERSHIP_ORGANIZATIONS, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.1011010")), //$NON-NLS-1$
		OTHER																			(10, TRBCBusinessSector.OTHER, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.1021010")); //$NON-NLS-1$

		/** The business sector this industry group belongs to */
		private TRBCBusinessSector businessSector;
		/** The last 2 digits of the TRBC code, rebuilt when invoking {@link #getCode()} */
		private int code;
		/** This industry description */
		private String description;

		
		/** Builds a new TRBC Industry Group enumeration value, linking this value with parent <code>businessSector</code> classification */
		private TRBCIndustryGroup (int code, TRBCBusinessSector businessSector, String description) {
			this.code = code;
			this.businessSector = businessSector;
			this.description = description;
		}
		
		// Fulfils IClassification contract
		// --------------------------------
		
		/** Gets the TRBC code (or fake for non-TRBC enum value); rebuilds the entire code by invoking parent one. */
		@Override public int getCode() { return Integer.valueOf(Integer.toString(getParent().getCode())+Integer.toString(code)); }
		/** Gets this Industry group description. */
		@Override public String getDescription() {return description; }
		/** Gets the Parent classification = business sector. */
		@Override public ITaxonomy getParent() { return businessSector; }
		
		/** Return a Human readable representation of this Country Code. */
		@Override public String toString() {
			return description + " (" + getCode() + ") <- " + businessSector; //$NON-NLS-1$ //$NON-NLS-2$
		}

	}
	
	
	/** The The Thomson Reuters Rusiness Classification - Industry categories, plus public sector (from NAICS). */
	public enum TRBCIndustry implements ITaxonomy {
		
		// As per TRBC
		COAL																				(10, TRBCIndustryGroup.COAL, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.50101010")), //$NON-NLS-1$
		INTEGRATED_OIL_AND_GAS																(10, TRBCIndustryGroup.OIL_AND_GAS, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.50102010")), //$NON-NLS-1$
		OIL_AND_GAS_EXPLORATION_AND_PRODUCTION												(20, TRBCIndustryGroup.OIL_AND_GAS, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.50102020")), //$NON-NLS-1$
		OIL_AND_GAS_REFINING_AND_MARKETING													(30, TRBCIndustryGroup.OIL_AND_GAS, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.50102030")), //$NON-NLS-1$
		OIL_AND_GAS_DRILLING																(10, TRBCIndustryGroup.OIL_AND_GAS_RELATED_EQUIPMENT_AND_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.50103010")), //$NON-NLS-1$
		OIL_AND_GAS_RELATED_SERVICES_AND_EQUIPMENT											(20, TRBCIndustryGroup.OIL_AND_GAS_RELATED_EQUIPMENT_AND_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.50103020")), //$NON-NLS-1$
		OIL_AND_GAS_TRANSPORTATION_SERVICES													(30, TRBCIndustryGroup.OIL_AND_GAS, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.50103030")), //$NON-NLS-1$
		RENEWABLE_ENERGY_EQUIPMENT_AND_SERVICES 											(10, TRBCIndustryGroup.RENEWABLE_ENERGY , Messages.getString("IMerchantCategoryCodes.TRBCIndustry.50201010")), //$NON-NLS-1$
		RENEWABLE_FUELS																		(20, TRBCIndustryGroup.RENEWABLE_ENERGY , Messages.getString("IMerchantCategoryCodes.TRBCIndustry.50201020")), //$NON-NLS-1$
		URANIUM																				(10, TRBCIndustryGroup.URANIUM, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.50301010")),  //$NON-NLS-1$
		COMMODITY_CHEMICALS																	(10, TRBCIndustryGroup.CHEMICALS, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.51101010")), //$NON-NLS-1$
		AGRICULTURAL_CHEMICALS																(20, TRBCIndustryGroup.CHEMICALS, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.51101020")), //$NON-NLS-1$
		SPECIALTY_CHEMICALS																	(30, TRBCIndustryGroup.CHEMICALS, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.51101030")), //$NON-NLS-1$
		DIVERSIFIED_CHEMICALS																(90, TRBCIndustryGroup.CHEMICALS, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.51101090")), //$NON-NLS-1$
		PRECIOUS_METALS_AND_MINERALS														(10, TRBCIndustryGroup.METALS_AND_MINING, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.51201010")), //$NON-NLS-1$
		STEEL																				(20, TRBCIndustryGroup.METALS_AND_MINING, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.51201020")), //$NON-NLS-1$
		ALUMINUM																			(30, TRBCIndustryGroup.METALS_AND_MINING, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.51201030")), //$NON-NLS-1$
		SPECIALTY_MINING_AND_METALS															(50, TRBCIndustryGroup.METALS_AND_MINING, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.51201050")), //$NON-NLS-1$
		GOLD																				(60, TRBCIndustryGroup.METALS_AND_MINING, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.51201060")), //$NON-NLS-1$
		MINING_SUPPORT_SERVICES_AND_EQUIPMENT												(70, TRBCIndustryGroup.METALS_AND_MINING, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.51201070")), //$NON-NLS-1$
		INTEGRATED_MINING																	(80, TRBCIndustryGroup.METALS_AND_MINING, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.51201080")), //$NON-NLS-1$
		CONSTRUCTION_MATERIALS																(10, TRBCIndustryGroup.CONSTRUCTION_MATERIALS, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.51202010")), //$NON-NLS-1$
		FOREST_AND_WOOD_PRODUCTS															(10, TRBCIndustryGroup.PAPER_AND_FOREST_PRODUCTS, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.51301010")), //$NON-NLS-1$
		PAPER_PRODUCTS																		(20, TRBCIndustryGroup.PAPER_AND_FOREST_PRODUCTS, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.51301020")), //$NON-NLS-1$
		NON_PAPER_CONTAINERS_AND_PACKAGING													(10, TRBCIndustryGroup.CONTAINERS_AND_PACKAGING, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.51302010")), //$NON-NLS-1$
		PAPER_PACKAGING																		(20, TRBCIndustryGroup.CONTAINERS_AND_PACKAGING, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.51302020")), //$NON-NLS-1$
		AEROSPACE_AND_DEFENSE																(10, TRBCIndustryGroup.AEROSPACE_AND_DEFENSE, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.52101010")), //$NON-NLS-1$
		INDUSTRIAL_MACHINERY_AND_EQUIPMENT													(10, TRBCIndustryGroup.MACHINERY_EQUIPMENT_AND_COMPONENTS, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.52102010")), //$NON-NLS-1$
		HEAVY_MACHINERY_AND_VEHICLES														(20, TRBCIndustryGroup.MACHINERY_EQUIPMENT_AND_COMPONENTS, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.52102020")), //$NON-NLS-1$
		ELECTRICAL_COMPONENTS_AND_EQUIPMENT													(30, TRBCIndustryGroup.MACHINERY_EQUIPMENT_AND_COMPONENTS, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.52102030")), //$NON-NLS-1$
		HEAVY_ELECTRICAL_EQUIPMENT															(40, TRBCIndustryGroup.MACHINERY_EQUIPMENT_AND_COMPONENTS, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.52102040")), //$NON-NLS-1$
		SHIPBUILDING																		(50, TRBCIndustryGroup.MACHINERY_EQUIPMENT_AND_COMPONENTS, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.52102050")), //$NON-NLS-1$
		CONSTRUCTION_AND_ENGINEERING														(20, TRBCIndustryGroup.CONSTRUCTION_AND_ENGINEERING, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.52201020")), //$NON-NLS-1$
		DIVERSIFIED_TRADING_AND_DISTRIBUTING												(10, TRBCIndustryGroup.DIVERSIFIED_TRADING_AND_DISTRIBUTING, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.52202010")), //$NON-NLS-1$
		ENVIRONMENTAL_SERVICES_AND_EQUIPMENT												(10, TRBCIndustryGroup.PROFESSIONAL_AND_COMMERCIAL_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.52203010")), //$NON-NLS-1$
		COMMERCIAL_PRINTING_SERVICES														(20, TRBCIndustryGroup.PROFESSIONAL_AND_COMMERCIAL_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.52203020")), //$NON-NLS-1$
		EMPLOYMENT_SERVICES																	(30, TRBCIndustryGroup.PROFESSIONAL_AND_COMMERCIAL_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.52203030")), //$NON-NLS-1$
		BUSINESS_SUPPORT_SERVICES															(40, TRBCIndustryGroup.PROFESSIONAL_AND_COMMERCIAL_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.52203040")), //$NON-NLS-1$
		BUSINESS_SUPPORT_SUPPLIES															(60, TRBCIndustryGroup.PROFESSIONAL_AND_COMMERCIAL_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.52203060")), //$NON-NLS-1$
		PROFESSIONAL_INFORMATION_SERVICES													(70, TRBCIndustryGroup.PROFESSIONAL_AND_COMMERCIAL_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.52203070")), //$NON-NLS-1$
		INDUSTRIAL_CONGLOMERATES															(10, TRBCIndustryGroup.INDUSTRIAL_CONGLOMERATES, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.52301010")), 	 //$NON-NLS-1$
		AIR_FREIGHT_AND_lOGISTICS															(10, TRBCIndustryGroup.FREIGHT_AND_LOGISTICS_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.52405010")), //$NON-NLS-1$
		MARINE_FREIGHT_AND_LOGISTICS														(20, TRBCIndustryGroup.FREIGHT_AND_LOGISTICS_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.52405020")), //$NON-NLS-1$
		GROUND_FREIGHT_AND_LOGISTICS														(30, TRBCIndustryGroup.FREIGHT_AND_LOGISTICS_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.52405030")), //$NON-NLS-1$
		AIRLINES 																			(10, TRBCIndustryGroup.PASSENGER_TRANSPORTATION_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.52406010")), //$NON-NLS-1$
		PASSENGER_TRANSPORTATION_GROUND_AND_SEA												(20, TRBCIndustryGroup.PASSENGER_TRANSPORTATION_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.52406020")), //$NON-NLS-1$
		AIRPORT_SERVICES																	(10, TRBCIndustryGroup.TRANSPORT_INFRASTRUCTURE, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.52407010")), //$NON-NLS-1$
		MARINE_PORTS_SERVICES																(20, TRBCIndustryGroup.TRANSPORT_INFRASTRUCTURE, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.52407020")), //$NON-NLS-1$
		HIGHWAYS_AND_RAILTRACKS																(30, TRBCIndustryGroup.TRANSPORT_INFRASTRUCTURE, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.52407030")), //$NON-NLS-1$
		AUTO_AND_TRUCK_MANUFACTURERS														(10, TRBCIndustryGroup.AUTOMOBILES_AND_AUTO_PARTS, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.53101010")), //$NON-NLS-1$
		AUTO_TRUCK_AND_MOTORCYCLE_PARTS														(20, TRBCIndustryGroup.AUTOMOBILES_AND_AUTO_PARTS, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.53101020")), //$NON-NLS-1$
		TIRES_AND_RUBBER_PRODUCTS															(30, TRBCIndustryGroup.AUTOMOBILES_AND_AUTO_PARTS, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.53101030")), //$NON-NLS-1$
		TEXTILES_AND_LEATHER_GOODS															(10, TRBCIndustryGroup.TEXTILES_AND_APPAREL, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.53202010")), //$NON-NLS-1$
		APPAREL_AND_ACCESSORIES																(20, TRBCIndustryGroup.TEXTILES_AND_APPAREL, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.53202020")), //$NON-NLS-1$
		FOOTWEAR																			(30, TRBCIndustryGroup.TEXTILES_AND_APPAREL, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.53202030")), //$NON-NLS-1$
		HOMEBUILDING																		(10, TRBCIndustryGroup.HOMEBUILDING_AND_CONSTRUCTION_SUPPLIES, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.53203010")), //$NON-NLS-1$
		CONSTRUCTION_SUPPLIES_AND_FIXTURES													(20, TRBCIndustryGroup.HOMEBUILDING_AND_CONSTRUCTION_SUPPLIES, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.53203020")), //$NON-NLS-1$
		APPLIANCES_TOOLS_AND_HOUSEWARES														(30, TRBCIndustryGroup.HOUSEHOLD_GOODS, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.53204030")), //$NON-NLS-1$
		HOME_FURNISHINGS																	(40, TRBCIndustryGroup.HOUSEHOLD_GOODS, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.53204040")), //$NON-NLS-1$
		TOYS_AND_JUVENILE_PRODUCTS															(10, TRBCIndustryGroup.LEISURE_PRODUCTS, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.53205010")), //$NON-NLS-1$
		RECREATIONAL_PRODUCTS																(20, TRBCIndustryGroup.LEISURE_PRODUCTS, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.53205020")), //$NON-NLS-1$
		HOTELS_MOTELS_AND_CRUISE_LINES														(10, TRBCIndustryGroup.HOTELS_AND_ENTERTAINMENT_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.53201010")), //$NON-NLS-1$
		RESTAURANTS_AND_BARS																(20, TRBCIndustryGroup.HOTELS_AND_ENTERTAINMENT_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.53201020")), //$NON-NLS-1$
		CASINOS_AND_GAMING																	(30, TRBCIndustryGroup.HOTELS_AND_ENTERTAINMENT_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.53201030")), //$NON-NLS-1$
		LEISURE_AND_RECREATION																(40, TRBCIndustryGroup.HOTELS_AND_ENTERTAINMENT_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.53201040")), //$NON-NLS-1$
		ADVERTISING_AND_MARKETING															(10, TRBCIndustryGroup.MEDIA_AND_PUBLISHING, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.53302010")), //$NON-NLS-1$
		BROADCASTING																		(20, TRBCIndustryGroup.MEDIA_AND_PUBLISHING, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.53302020")), //$NON-NLS-1$
		ENTERTAINMENT_PRODUCTION															(30, TRBCIndustryGroup.MEDIA_AND_PUBLISHING, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.53302030")), //$NON-NLS-1$
		CONSUMER_PUBLISHING																	(40, TRBCIndustryGroup.MEDIA_AND_PUBLISHING, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.53302040")), //$NON-NLS-1$
		DEPARTMENT_STORES																	(10, TRBCIndustryGroup.DIVERSIFIED_RETAIL, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.53402010")), //$NON-NLS-1$
		DISCOUNT_STORES																		(20, TRBCIndustryGroup.DIVERSIFIED_RETAIL, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.53402020")), //$NON-NLS-1$
		AUTO_VEHICLES_PARTS_AND_SERVICES_RETAILERS											(10, TRBCIndustryGroup.OTHER_SPECIALTY_RETAILERS, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.53403010")), //$NON-NLS-1$
		HOME_IMPROVEMENT_PRODUCTS_AND_SERVICES_RETAILERS									(20, TRBCIndustryGroup.OTHER_SPECIALTY_RETAILERS, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.53403020")), //$NON-NLS-1$
		HOME_FURNISHINGS_RETAILERS															(30, TRBCIndustryGroup.OTHER_SPECIALTY_RETAILERS, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.53403030")), //$NON-NLS-1$
		APPAREL_AND_ACCESSORIES_RETAILERS													(40, TRBCIndustryGroup.OTHER_SPECIALTY_RETAILERS, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.53403040")), //$NON-NLS-1$
		COMPUTER_AND_ELECTRONIC_RETAILERS													(50, TRBCIndustryGroup.OTHER_SPECIALTY_RETAILERS, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.53403050")), //$NON-NLS-1$
		OTHER_SPECIALTY_RETAILERS															(90, TRBCIndustryGroup.OTHER_SPECIALTY_RETAILERS, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.53403090")), //$NON-NLS-1$
		BREWERS																				(10, TRBCIndustryGroup.BEVERAGES, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.54101010")), //$NON-NLS-1$
		DISTILLERS_AND_WINERIES																(20, TRBCIndustryGroup.BEVERAGES, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.54101020")), //$NON-NLS-1$
		NON_ALCOHOLIC_BEVERAGES																(30, TRBCIndustryGroup.BEVERAGES, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.54101030")), //$NON-NLS-1$
		FISHING_AND_FARMING																	(10, TRBCIndustryGroup.FOOD_AND_TOBACCO, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.54102010")), //$NON-NLS-1$
		FOOD_PROCESSING																		(20, TRBCIndustryGroup.FOOD_AND_TOBACCO, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.54102020")), //$NON-NLS-1$
		TOBACCO																				(30, TRBCIndustryGroup.FOOD_AND_TOBACCO, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.54102030")), //$NON-NLS-1$
		HOUSEHOLD_PRODUCTS 																	(10, TRBCIndustryGroup.PERSONAL_AND_HOUSEHOLD_PRODUCTS_AND_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.54201010")), //$NON-NLS-1$
		PERSONAL_PRODUCTS																	(20, TRBCIndustryGroup.PERSONAL_AND_HOUSEHOLD_PRODUCTS_AND_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.54201020")), //$NON-NLS-1$
		PERSONAL_SERVICES																	(30, TRBCIndustryGroup.PERSONAL_AND_HOUSEHOLD_PRODUCTS_AND_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.54201030")), //$NON-NLS-1$
		DRUG_RETAILERS																		(10, TRBCIndustryGroup.FOOD_AND_DRUG_RETAILING, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.54301010")), //$NON-NLS-1$
		FOOD_RETAIL_AND_DISTRIBUTION														(20, TRBCIndustryGroup.FOOD_AND_DRUG_RETAILING, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.54301020")), //$NON-NLS-1$
		BANKS																				(10, TRBCIndustryGroup.BANKING_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.55101010")), //$NON-NLS-1$
		CONSUMER_LENDING																	(20, TRBCIndustryGroup.BANKING_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.55101020")), 	 //$NON-NLS-1$
		CORPORATE_FINANCIAL_SERVICES														(30, TRBCIndustryGroup.BANKING_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.55101030")), 	 //$NON-NLS-1$
		INVESTMENT_BANKING_AND_BROKERAGE_SERVICES											(10, TRBCIndustryGroup.INVESTMENT_BANKING_AND_INVESTMENT_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.55102010")), //$NON-NLS-1$
		INVESTMENT_MANAGEMENT_AND_FUND_OPERATORS											(20, TRBCIndustryGroup.INVESTMENT_BANKING_AND_INVESTMENT_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.55102020")), //$NON-NLS-1$
		DIVERSIFIED_INVESTMENT_SERVICES														(30, TRBCIndustryGroup.INVESTMENT_BANKING_AND_INVESTMENT_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.55102030")), //$NON-NLS-1$
		FINANCIAL_AND_COMMODITY_MARKET_OPERATORS											(50, TRBCIndustryGroup.INVESTMENT_BANKING_AND_INVESTMENT_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.55102050")), //$NON-NLS-1$
		MULTILINE_INSURANCE_AND_BROKERS														(10, TRBCIndustryGroup.INSURANCE, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.55301010")), //$NON-NLS-1$
		PROPERTY_AND_CASUALTY_INSURANCE														(20, TRBCIndustryGroup.INSURANCE, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.55301020")), //$NON-NLS-1$
		LIFE_AND_HEALTH_INSURANCE															(30, TRBCIndustryGroup.INSURANCE, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.55301030")), //$NON-NLS-1$
		REINSURANCE																			(50, TRBCIndustryGroup.INSURANCE, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.55301050")), //$NON-NLS-1$
		REAL_ESTATE_DEVELOPMENT_AND_OPERATIONS												(10, TRBCIndustryGroup.REAL_ESTATE_OPERATIONS, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.55402010")), //$NON-NLS-1$
		REAL_ESTATE_SERVICES																(20, TRBCIndustryGroup.REAL_ESTATE_OPERATIONS, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.55402030")), //$NON-NLS-1$
		DIVERSIFIED_REITS																	(10, TRBCIndustryGroup.RESIDENTIAL_AND_COMMERCIAL_REITS, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.55403010")), //$NON-NLS-1$
		COMMERCIAL_REITS																	(20, TRBCIndustryGroup.RESIDENTIAL_AND_COMMERCIAL_REITS, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.55403020")), //$NON-NLS-1$
		SPECIALIZED_REITS																	(30, TRBCIndustryGroup.RESIDENTIAL_AND_COMMERCIAL_REITS, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.55403030")), //$NON-NLS-1$
		INVESTMENT_TRUSTS																	(10, TRBCIndustryGroup.COLLECTIVE_INVESTMENTS, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.55501010")), //$NON-NLS-1$
		MUTUAL_FUNDS																		(20, TRBCIndustryGroup.COLLECTIVE_INVESTMENTS, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.55501020")), //$NON-NLS-1$
		CLOSE_END_FUNDS																		(30, TRBCIndustryGroup.COLLECTIVE_INVESTMENTS, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.55501030")), //$NON-NLS-1$
		EXCHANGE_TRADED_FUNDS																(40, TRBCIndustryGroup.COLLECTIVE_INVESTMENTS, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.55501040")), //$NON-NLS-1$
		PENSION_FUNDS																		(50, TRBCIndustryGroup.COLLECTIVE_INVESTMENTS, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.55501050")), //$NON-NLS-1$
		INSURANCE_FUNDS																		(60, TRBCIndustryGroup.COLLECTIVE_INVESTMENTS, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.55501060")), //$NON-NLS-1$
		HOLDING_COMPANIES																	(10, TRBCIndustryGroup.HOLDING_COMPANIES, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.55601010")), //$NON-NLS-1$
		ADVANCED_MEDICAL_EQUIPMENT_AND_TECHNOLOGY											(10, TRBCIndustryGroup.HEALTH_CARE_EQUIPMENT_AND_SUPPLIES, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.56101010")), //$NON-NLS-1$
		MEDICAL_EQUIPMENT_SUPPLIES_AND_DISTRIBUTION											(20, TRBCIndustryGroup.HEALTH_CARE_EQUIPMENT_AND_SUPPLIES, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.56101020")), //$NON-NLS-1$
		HEALTH_CARE_FACILITIES_AND_SERVICES													(10, TRBCIndustryGroup.HEALTH_CARE_PROVIDERS_AND_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.56102010")), //$NON-NLS-1$
		MANAGED_HEALTH_CARE																	(20, TRBCIndustryGroup.HEALTH_CARE_PROVIDERS_AND_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.56102020")), //$NON-NLS-1$
		PHARMACEUTICALS																		(10, TRBCIndustryGroup.PHARMACEUTICALS, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.56201040")), //$NON-NLS-1$
		BIOTECHNOLOGY_AND_MEDICAL_RESEARCH													(10, TRBCIndustryGroup.BIOTECHNOLOGY_AND_MEDICAL_RESEARCH, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.56202010")), //$NON-NLS-1$
		SEMICONDUCTORS																		(10, TRBCIndustryGroup.SEMICONDUCTORS_AND_SEMICONDUCTOR_EQUIPMENT, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.57101010")), //$NON-NLS-1$
		SEMICONDUCTOR_EQUIPMENT_AND_TESTING													(20, TRBCIndustryGroup.SEMICONDUCTORS_AND_SEMICONDUCTOR_EQUIPMENT, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.57101020")), //$NON-NLS-1$
		COMMUNICATIONS_AND_NETWORKING														(10, TRBCIndustryGroup.COMMUNICATIONS_AND_NETWORKING,  Messages.getString("IMerchantCategoryCodes.TRBCIndustry.57102010")), //$NON-NLS-1$
		ELECTRONIC_EQUIPMENT_AND_PARTS														(10, TRBCIndustryGroup.ELECTRONIC_EQUIPMENT_AND_PARTS,  Messages.getString("IMerchantCategoryCodes.TRBCIndustry.57104010")), //$NON-NLS-1$
		OFFICE_EQUIPMENT																	(10, TRBCIndustryGroup.OFFICE_EQUIPMENT,  Messages.getString("IMerchantCategoryCodes.TRBCIndustry.57105010")), //$NON-NLS-1$
		COMPUTER_HARDWARE 																	(10, TRBCIndustryGroup.COMPUTERS_PHONES_AND_HOUSEHOLD_ELECTRONICS, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.57106010")), //$NON-NLS-1$
		PHONES_AND_HANDHELD_DEVICES 														(20, TRBCIndustryGroup.COMPUTERS_PHONES_AND_HOUSEHOLD_ELECTRONICS, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.57106020")), //$NON-NLS-1$
		HOUSEHOLD_ELECTRONICS																(30, TRBCIndustryGroup.COMPUTERS_PHONES_AND_HOUSEHOLD_ELECTRONICS, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.57106030")), //$NON-NLS-1$
		IT_SERVICES_AND_CONSULTING															(10, TRBCIndustryGroup.SOFTWARE_AND_IT_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.57201010")), //$NON-NLS-1$
		SOFTWARE																			(20, TRBCIndustryGroup.SOFTWARE_AND_IT_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.57201020")), //$NON-NLS-1$
		INTERNET_SERVICES																	(30, TRBCIndustryGroup.SOFTWARE_AND_IT_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.57201030")), //$NON-NLS-1$
		INTEGRATED_TELECOMMUNICATION_SERVICES												(10, TRBCIndustryGroup.TELECOMMUNICATION_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.58101010")), //$NON-NLS-1$
		WIRELESS_TELECOMMUNICATION_SERVICES													(20, TRBCIndustryGroup.TELECOMMUNICATION_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.58101020")), //$NON-NLS-1$
		ELECTRIC_UTILITIES																	(10, TRBCIndustryGroup.ELECTRIC_UTILITIES_AND_IPPs , Messages.getString("IMerchantCategoryCodes.TRBCIndustry.59101010")), //$NON-NLS-1$
		INDEPENDENT_POWER_PRODUCERS															(20, TRBCIndustryGroup.ELECTRIC_UTILITIES_AND_IPPs , Messages.getString("IMerchantCategoryCodes.TRBCIndustry.59101020")), 	 //$NON-NLS-1$
		NATURAL_GAS_UTILITIES																(10, TRBCIndustryGroup.NATURAL_GAS_UTILITIES , Messages.getString("IMerchantCategoryCodes.TRBCIndustry.59102010")), //$NON-NLS-1$
		WATER_UTILITIES																		(10, TRBCIndustryGroup.WATER_AND_OTHER_UTILITIES , Messages.getString("IMerchantCategoryCodes.TRBCIndustry.59103010")), //$NON-NLS-1$
		MULTILINE_UTILITIES																	(10, TRBCIndustryGroup.MULTILINE_UTILITIES , Messages.getString("IMerchantCategoryCodes.TRBCIndustry.59104010")), //$NON-NLS-1$

		// NOt in TRBC but needed
		EXECUTIVE_LEGISLATIVE_AND_OTHER_GENERAL_GOVERNMENT_SUPPORT							(10, TRBCIndustryGroup.GOVERNMENT_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.100101010")),  //$NON-NLS-1$
		JUSTICE_PUBLIC_ORDER_AND_SAFETY_ACTIVITIES											(20, TRBCIndustryGroup.GOVERNMENT_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.100101020")),  //$NON-NLS-1$
		ADMINISTRATION_OF_ECONOMIC_PROGRAMS													(30, TRBCIndustryGroup.GOVERNMENT_SERVICES, Messages.getString("IMerchantCategoryCodes.TRBCIndustryGroup.100101030")),  //$NON-NLS-1$
		MEMBERSHIP_ORGANIZATIONS															(10, TRBCIndustryGroup.MEMBERSHIP_ORGANIZATIONS, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.101101010")), //$NON-NLS-1$
		OTHER																				(10, TRBCIndustryGroup.OTHER, Messages.getString("IMerchantCategoryCodes.TRBCIndustry.102101010")); //$NON-NLS-1$
		
		/** The industry this sub-industry belongs to */
		private TRBCIndustryGroup industryGroup;
		/** The last 2 digits of the TRBC code, rebuilt when invoking {@link #getCode()} */
		private int code;
		/** This sub-industry description */
		private String description;
		
		/** Builds a new TRBC Sub-Industry enumeration value, linking this value with parent <code>industry</code> classification */
		private TRBCIndustry (int code, TRBCIndustryGroup industryGroup, String description) {
			this.code = code;
			this.industryGroup = industryGroup;
			this.description = description;
		}

		// Fulfils IClassification contract
		// --------------------------------
		
		/** Gets the TRBC code (or fake for non-TRBC enum value); rebuilds the entire code by invoking parent one. */
		@Override public int getCode() { return Integer.valueOf(Integer.toString(getParent().getCode())+Integer.toString(code)); }
		/** Gets this sub-Industry description. */
		@Override public String getDescription() {return description; }
		/** Gets the Parent classification. */
		@Override public ITaxonomy getParent() { return industryGroup; }
		
		/** Return a Human readable representation of this Country Code. */
		@Override public String toString() {
			return description + " (" + getCode() + ") <- " + industryGroup; //$NON-NLS-1$ //$NON-NLS-2$
		}

	}

	
	/** 
	 * The list of ISO 18245 Merchant Category Code + some scheme specifics, ordered by MCC numeric code.
	 */
	public enum Iso18245MerchantCategoryCode {
		
		// ----------------------
		// Agricultural Services
		// ----------------------

		MCC_0742_VETERINARY_SERVICES 															(742, CONTRACTED_SERVICES, TRBCIndustry.HEALTH_CARE_FACILITIES_AND_SERVICES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.0742")), //$NON-NLS-1$
		MCC_0763_AGRICULTURAL_COOPERATIVES 														(763, CONTRACTED_SERVICES, TRBCIndustry.FISHING_AND_FARMING, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.0763")), //$NON-NLS-1$
		MCC_0780_HORTICULTURAL_AND_LANDSCAPING_SERVICES 										(780, CONTRACTED_SERVICES, TRBCIndustry.ENVIRONMENTAL_SERVICES_AND_EQUIPMENT, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.0780")), //$NON-NLS-1$

		// ----------------------
		// Contracted Services
		// ----------------------

		MCC_1520_GENERAL_CONTRACTORS_RESIDENTIAL_AND_COMMERCIAL 								(1520, CONTRACTED_SERVICES, TRBCIndustry.HOMEBUILDING, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.1520")),																 //$NON-NLS-1$
		MCC_1711_AIR_CONDITIONING_HEATING_AND_PLUMBING_CONTRACTORS 								(1711, CONTRACTED_SERVICES, TRBCIndustry.CONSTRUCTION_SUPPLIES_AND_FIXTURES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.1711")),																 //$NON-NLS-1$
		MCC_1731_ELECTRICAL_CONTRACTORS 														(1731, CONTRACTED_SERVICES, TRBCIndustry.CONSTRUCTION_SUPPLIES_AND_FIXTURES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.1731")),																 //$NON-NLS-1$
		MCC_1740_INSULATION_MASONRY_PLATERING_STONEWORK_AND_TILE_SETTING_CONTRACTORS 			(1740, CONTRACTED_SERVICES, TRBCIndustry.CONSTRUCTION_SUPPLIES_AND_FIXTURES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.1740")),																 //$NON-NLS-1$
		MCC_1750_CARPENTRY_CONTRACTORS 															(1750, CONTRACTED_SERVICES, TRBCIndustry.CONSTRUCTION_SUPPLIES_AND_FIXTURES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.1750")),																 //$NON-NLS-1$
		MCC_1761_ROOFING_AND_SIDING_SHEET_METAL_WORK_CONTRACTORS 								(1761, CONTRACTED_SERVICES, TRBCIndustry.CONSTRUCTION_SUPPLIES_AND_FIXTURES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.1761")),																 //$NON-NLS-1$
		MCC_1771_CONCRETE_WORK_CONTRACTORS 														(1771, CONTRACTED_SERVICES, TRBCIndustry.CONSTRUCTION_SUPPLIES_AND_FIXTURES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.1771")),																 //$NON-NLS-1$
		MCC_1799_CONTRACTORS_SPECIAL_TRADE_NOT_ELSESWHERE_CLASSIFIED 							(1799, CONTRACTED_SERVICES, TRBCIndustry.CONSTRUCTION_SUPPLIES_AND_FIXTURES , TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.1799")), //$NON-NLS-1$
		
		MCC_2741_MISCELLANEOUS_PUBLISHING_AND_PRINTING 											(2741, WHOLESALE, TRBCIndustry.COMMERCIAL_PRINTING_SERVICES, TCC_T_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.2741")),																 //$NON-NLS-1$
		MCC_2791_TYPESETTING_PLATE_MAKING_AND_RELATED_SERVICES 									(2791, WHOLESALE, TRBCIndustry.COMMERCIAL_PRINTING_SERVICES, TCC_T_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.2791")),																 //$NON-NLS-1$
		MCC_2842_SANITATION_POLISHING_AND_SPECIALTY_CLEANING_PREPARATIONS 						(2842, WHOLESALE, TRBCIndustry.BUSINESS_SUPPORT_SUPPLIES, TCC_T_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.2842")), //$NON-NLS-1$
		
		// -----------------------
		// Transportation Services
		// -----------------------

		MCC_4011_RAILROADS_FREIGHT 																(4011, TRANSPORTATION, TRBCIndustry.GROUND_FREIGHT_AND_LOGISTICS, TCC_X_RLW, MCG_1_TRA, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.4011")),																 //$NON-NLS-1$
		MCC_4111_SUBURBAN_AND_LOCAL_COMMUTER_PASSENGER_INCLUDING_FERRIES 						(4111, TRANSPORTATION, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_X_RLW, MCG_1_TRA, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.4111")),																 //$NON-NLS-1$
		MCC_4112_PASSENGER_RAILWAYS																(4112, TRANSPORTATION, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_X_RLW, MCG_1_TRA, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.4112")),																 //$NON-NLS-1$
		MCC_4119_AMBULANCE_SERVICES																(4119, TRANSPORTATION, TRBCIndustry.HEALTH_CARE_FACILITIES_AND_SERVICES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.4119")),																 //$NON-NLS-1$
		MCC_4121_TAXICABS_AND_LIMOUSINES														(4121, TRANSPORTATION, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_R_OTH, MCG_1_TRA, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.4121")),																 //$NON-NLS-1$
		MCC_4131_BUS_LINES 																		(4131, TRANSPORTATION, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_X_TRA, MCG_1_TRA, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.4131")),																 //$NON-NLS-1$
		MCC_4214_MOTOR_FREIGHT_CARRIERS_TRUCKING 												(4214, TRANSPORTATION, TRBCIndustry.GROUND_FREIGHT_AND_LOGISTICS, TCC_R_OTH, MCG_1_TRA, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.4214")),																 //$NON-NLS-1$
		MCC_4215_COURIER_SERVICES 																(4215, TRANSPORTATION, TRBCIndustry.GROUND_FREIGHT_AND_LOGISTICS, TCC_R_OTH, MCG_1_TRA, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.4215")),																 //$NON-NLS-1$
		MCC_4225_PUBLIC_WAREHOUSING 															(4225, TRANSPORTATION, TRBCIndustry.GROUND_FREIGHT_AND_LOGISTICS, TCC_R_OTH, MCG_1_TRA, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.4225")),																 //$NON-NLS-1$
		MCC_4411_CRUISE_LINES 																	(4411, TRANSPORTATION, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_X_TRA, MCG_1_TRA, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.4411")), // TCC_H_HOT for on-board sales																 //$NON-NLS-1$
		MCC_4457_BOAT_LEASES_AND_RENTALS 														(4457, TRANSPORTATION, TRBCIndustry.MARINE_FREIGHT_AND_LOGISTICS, TCC_R_OTH, MCG_1_TRA, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.4457")),																 //$NON-NLS-1$
		MCC_4468_MARINAS_AND_MARINE_SERVICE_SUPPLIES											(4468, TRANSPORTATION, TRBCIndustry.MARINE_PORTS_SERVICES, TCC_R_OTH, MCG_1_TRA, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.4468")),																 //$NON-NLS-1$
		MCC_4511_AIR_LINES_AIR_CARRIERS_NOT_ELSEWHERE_CLASSIFIED 								(4511, TRANSPORTATION, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.4511")), //$NON-NLS-1$
		MCC_4582_AIRPORTS_FLYING_FIELDS_AIRPORT_TERMINALS 										(4582, TRANSPORTATION, TRBCIndustry.AIRPORT_SERVICES, TCC_R_OTH, MCG_1_TRA, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.4582")),																 //$NON-NLS-1$
		MCC_4722_TRAVEL_AGENCIES_AND_TOUR_OPERATORS 											(4722, TRANSPORTATION, TRBCIndustry.LEISURE_AND_RECREATION, TCC_X_TRA, MCG_1_TRA, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.4722")),																 //$NON-NLS-1$
		MCC_4723_PACKAGE_TOUR_OPERATORS_GERMANY_VISA 											(4723, TRANSPORTATION, TRBCIndustry.LEISURE_AND_RECREATION, null, MCG_1_TRA, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.4723")), // not valid for MC																 //$NON-NLS-1$
		MCC_4784_BRIDGE_AND_ROAD_FEES_TOLLS														(4784, TRANSPORTATION, TRBCIndustry.HIGHWAYS_AND_RAILTRACKS, TCC_R_OTH, MCG_1_TRA, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.4784")),																 //$NON-NLS-1$
		MCC_4789_TRANSPORTATION_SERVICES_NOT_ELSEWHERE_CLASSIFIED								(4789, TRANSPORTATION, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_X_TRA, MCG_1_TRA, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.4789")), //$NON-NLS-1$
		
		// ---------
		// Utilities
		// ---------
		
		MCC_4812_TELECOMMUNICATIONS_EQUIPMENT_INCLUDING_TELEPHONE_SALES 						(4812, UTILITIES, TRBCIndustry.COMPUTER_AND_ELECTRONIC_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.4812")),																 //$NON-NLS-1$
		MCC_4813_KEY_ENTRY_TELECOM_MERCHANT_MASTERCARD 											(4813, UTILITIES, TRBCIndustry.INTEGRATED_TELECOMMUNICATION_SERVICES, TCC_R_OTH, null, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.4813")), // Mastercard only																 //$NON-NLS-1$
		MCC_4814_TELECOMMUNICATION_SERVICES 													(4814, UTILITIES, TRBCIndustry.INTEGRATED_TELECOMMUNICATION_SERVICES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.4814")),																 //$NON-NLS-1$
		MCC_4816_COMPUTER_NETWORK_INFORMATION_SERVICES 											(4816, UTILITIES, TRBCIndustry.IT_SERVICES_AND_CONSULTING, TCC_T_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.4816")),																 //$NON-NLS-1$
		MCC_4821_TELEGRAPH_SERVICES 															(4821, UTILITIES, TRBCIndustry.INTEGRATED_TELECOMMUNICATION_SERVICES , TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.4821")),																 //$NON-NLS-1$
		MCC_4829_MONEY_TRANSFER_MERCHANT 														(4829, UTILITIES, TRBCIndustry.OTHER_SPECIALTY_RETAILERS, TCC_U_QEC, MCG_5_MEC, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.4829")),																 //$NON-NLS-1$
		MCC_4899_CABLE_AND_OTHER_PAY_TELEVISION 												(4899, UTILITIES, TRBCIndustry.BROADCASTING, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.4899")),																 //$NON-NLS-1$
		MCC_4900_UTILITIES_ELECTRICITY_GAS_HEATING_OIL_SANITARY_WATER 							(4900, UTILITIES, TRBCIndustry.ELECTRIC_UTILITIES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.4900")),																 //$NON-NLS-1$

		// ----------------------
		// Retail Outlet Services
		// ----------------------
		
		MCC_5013_MOTOR_VEHICLE_SUPPLIES_AND_NEW_PARTS 											(5013, WHOLESALE, TRBCIndustry.AUTO_TRUCK_AND_MOTORCYCLE_PARTS, TCC_T_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5013")),																 //$NON-NLS-1$
		MCC_5021_OFFICE_AND_COMMERCIAL_FURNITURE 												(5021, WHOLESALE, TRBCIndustry.BUSINESS_SUPPORT_SUPPLIES, TCC_T_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5021")),																 //$NON-NLS-1$
		MCC_5039_CONSTRUCTION_MATERIALS_NOT_ELSEWHERE_CLASSIFIED 								(5039, WHOLESALE, TRBCIndustry.CONSTRUCTION_MATERIALS, TCC_T_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5039")),																 //$NON-NLS-1$
		MCC_5044_OFFICE_PHOTOGRAPHIC_PHOTOCOPY_AND_MICROFILM_EQUIPMENT 							(5044, WHOLESALE, TRBCIndustry.BUSINESS_SUPPORT_SUPPLIES, TCC_T_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5044")),																 //$NON-NLS-1$
		MCC_5045_COMPUTERS_COMPUTER_PERIPHERAL_EQUIPMENT_SOFTWARE 								(5045, WHOLESALE, TRBCIndustry.COMPUTER_AND_ELECTRONIC_RETAILERS, TCC_T_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5045")),																 //$NON-NLS-1$
		MCC_5046_COMMERCIAL_EQUIPMENT_NOT_ELSEWHERE_CLASSIFIED 									(5046, WHOLESALE, TRBCIndustry.BUSINESS_SUPPORT_SUPPLIES, TCC_T_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5046")),																 //$NON-NLS-1$
		MCC_5047_MEDICAL_DENTAL_LABOTORY_OPHTALMIC_AND_HOSPITAL_EQUIPMENT_AND_SUPPLIES 			(5047, WHOLESALE, TRBCIndustry.MEDICAL_EQUIPMENT_SUPPLIES_AND_DISTRIBUTION, TCC_T_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5047")),																 //$NON-NLS-1$
		MCC_5051_METAL_SERVICE_CENTERS_AND_OFFICES 												(5051, WHOLESALE, TRBCIndustry.STEEL, TCC_T_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5051")),																 //$NON-NLS-1$
		MCC_5065_ELECTRICAL_PARTS_AND_EQUIPMENT 												(5065, WHOLESALE, TRBCIndustry.ELECTRICAL_COMPONENTS_AND_EQUIPMENT, TCC_T_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5065")),																 //$NON-NLS-1$
		MCC_5072_HARDWARE_EQUIPMENT_AND_SUPPLIES 												(5072, WHOLESALE, TRBCIndustry.CONSTRUCTION_SUPPLIES_AND_FIXTURES, TCC_T_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5072")),																 //$NON-NLS-1$
		MCC_5074_PLUMBING_AND_HEATING_EQUIPMENT_AND_SUPPLIES 									(5074, WHOLESALE, TRBCIndustry.CONSTRUCTION_SUPPLIES_AND_FIXTURES, TCC_T_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5074")),																 //$NON-NLS-1$
		MCC_5085_INDUSTRIAL_SUPPLIES_NOT_ELSEWHERE_CLASSIFIED 									(5085, WHOLESALE, TRBCIndustry.INDUSTRIAL_MACHINERY_AND_EQUIPMENT, TCC_T_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5085")),																 //$NON-NLS-1$
		MCC_5094_PRECIOUS_STONES_AND_METALS_WATCHES_AND_JEWELRY									(5094, WHOLESALE, TRBCIndustry.APPAREL_AND_ACCESSORIES, TCC_T_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5094")),																 //$NON-NLS-1$
		MCC_5099_DURABLE_GOODS_NOT_ELSEWHERE_CLASSIFIED 										(5099, WHOLESALE, TRBCIndustry.DIVERSIFIED_TRADING_AND_DISTRIBUTING, TCC_T_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5099")),																 //$NON-NLS-1$
		MCC_5111_STATIONERY_OFFICE_SUPPLIES_PRINTING_AND_WRITING_PAPER 							(5111, WHOLESALE, TRBCIndustry.BUSINESS_SUPPORT_SUPPLIES, TCC_T_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5111")),																 //$NON-NLS-1$
		MCC_5122_DRUGS_DRUG_PROPRIETORS_AND_DRUGGIST_SUNDRIES 									(5122, WHOLESALE, TRBCIndustry.DRUG_RETAILERS, TCC_T_OTH, MCG_6_RSK, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5122")),																 //$NON-NLS-1$
		MCC_5131_PIECE_GOODS_NOTIONS_AND_OTHER_DRY_GOODS 										(5131, WHOLESALE, TRBCIndustry.PERSONAL_PRODUCTS, TCC_T_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5131")),																 //$NON-NLS-1$
		MCC_5137_MEN_WOMEN_CHILDREN_UNIFORMS_AND_COMMERCIAL_CLOTHING 							(5137, WHOLESALE, TRBCIndustry.APPAREL_AND_ACCESSORIES, TCC_T_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5137")),																 //$NON-NLS-1$
		MCC_5139_COMMERCIAL_FOOTWEAR 															(5139, WHOLESALE, TRBCIndustry.APPAREL_AND_ACCESSORIES, TCC_T_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5139")),																 //$NON-NLS-1$
		MCC_5169_CHEMICAL_AND_ALLIED_PRODUCTS_NOT_ELSEWHERE_CLASSIFIED 							(5169, WHOLESALE, TRBCIndustry.COMMODITY_CHEMICALS, TCC_T_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5169")),																 //$NON-NLS-1$
		MCC_5172_PETROLEUM_AND_PETROLEUM_PRODUCTS 												(5172, WHOLESALE, TRBCIndustry.OIL_AND_GAS_REFINING_AND_MARKETING, TCC_T_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5172")),																 //$NON-NLS-1$
		MCC_5192_BOOKS_PERIODICALS_AND_NEWSPAPERS 												(5192, WHOLESALE, TRBCIndustry.CONSUMER_PUBLISHING, TCC_T_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5192")),																 //$NON-NLS-1$
		MCC_5193_FLORISTS_SUPPLIES_NURSERY_STOCK_AND_FLOWERS 									(5193, WHOLESALE, TRBCIndustry.FISHING_AND_FARMING, TCC_T_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5193")),																 //$NON-NLS-1$
		MCC_5198_PAINTS_VARNISHES_AND_SUPPLIES 													(5198, WHOLESALE, TRBCIndustry.HOME_IMPROVEMENT_PRODUCTS_AND_SERVICES_RETAILERS, TCC_T_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5198")),																 //$NON-NLS-1$
		MCC_5199_NON_DURABLE_GOODS_NOT_ELSEWHERE_CLASSIFIED 									(5199, WHOLESALE, TRBCIndustry.DIVERSIFIED_TRADING_AND_DISTRIBUTING, TCC_T_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5199")),																 //$NON-NLS-1$

		MCC_5200_HOME_SUPPLY_WAREHOUSE_STORES 													(5200, RETAIL_STORES, TRBCIndustry.HOME_FURNISHINGS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5200")),																 //$NON-NLS-1$
		MCC_5211_BUILDING_MATERIALS_LUMBER_STORES 												(5211, RETAIL_STORES, TRBCIndustry.CONSTRUCTION_SUPPLIES_AND_FIXTURES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5211")),																 //$NON-NLS-1$
		MCC_5231_GLASS_PAINT_AND_WALLPAPER_STORES 												(5231, RETAIL_STORES, TRBCIndustry.HOME_IMPROVEMENT_PRODUCTS_AND_SERVICES_RETAILERS  , TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5231")),																 //$NON-NLS-1$
		MCC_5251_HARDWARE_STORES 																(5251, RETAIL_STORES, TRBCIndustry.APPLIANCES_TOOLS_AND_HOUSEWARES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5251")),																 //$NON-NLS-1$
		MCC_5261_NURSERIES_LAWN_AND_GARDEN_SUPPLY_STORE 										(5261, RETAIL_STORES, TRBCIndustry.HOME_IMPROVEMENT_PRODUCTS_AND_SERVICES_RETAILERS , TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5261")),																 //$NON-NLS-1$
		MCC_5271_MOBILE_HOME_DEALERS 															(5271, RETAIL_STORES, TRBCIndustry.HOMEBUILDING, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5271")),																 //$NON-NLS-1$
		MCC_5300_WHOLESALE_CLUBS 																(5300, RETAIL_STORES, TRBCIndustry.DISCOUNT_STORES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5300")),																 //$NON-NLS-1$
		MCC_5309_DUTY_FREE_STORES 																(5309, RETAIL_STORES, TRBCIndustry.DISCOUNT_STORES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5309")),	// In-Flight Commerce transaction															 //$NON-NLS-1$
		MCC_5310_DISCOUNT_STORES 																(5310, RETAIL_STORES, TRBCIndustry.DISCOUNT_STORES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5310")),																 //$NON-NLS-1$
		MCC_5311_DEPARTMENT_STORES 																(5311, RETAIL_STORES, TRBCIndustry.DEPARTMENT_STORES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5311")),																 //$NON-NLS-1$
		MCC_5331_VARIETY_STORES 																(5331, RETAIL_STORES, TRBCIndustry.DISCOUNT_STORES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5331")),																 //$NON-NLS-1$
		MCC_5399_MISCELLANEOUS_GENERAL_MERCHANDISE_STORES 										(5399, RETAIL_STORES, TRBCIndustry.DISCOUNT_STORES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5399")),																 //$NON-NLS-1$
		MCC_5411_GROCERY_STORES_SUPERMARKETS 													(5411, RETAIL_STORES, TRBCIndustry.FOOD_RETAIL_AND_DISTRIBUTION, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5411")),																 //$NON-NLS-1$
		MCC_5422_FREEZER_AND_LOCKER_MEAT_PROVISIONERS 											(5422, RETAIL_STORES, TRBCIndustry.FOOD_RETAIL_AND_DISTRIBUTION, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5422")),																 //$NON-NLS-1$
		MCC_5441_CANDY_NUT_AND_CONFECTIONERY_STORES 											(5441, RETAIL_STORES, TRBCIndustry.FOOD_RETAIL_AND_DISTRIBUTION, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5441")),																 //$NON-NLS-1$
		MCC_5451_DAIRY_PRODUCTS_STORES															(5451, RETAIL_STORES, TRBCIndustry.FOOD_RETAIL_AND_DISTRIBUTION, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5451")),																 //$NON-NLS-1$
		MCC_5462_BAKERIES 																		(5462, RETAIL_STORES, TRBCIndustry.FOOD_RETAIL_AND_DISTRIBUTION, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5462")),																 //$NON-NLS-1$
		MCC_5499_MISCELLANEOUS_FOOD_STORES 														(5499, RETAIL_STORES, TRBCIndustry.FOOD_RETAIL_AND_DISTRIBUTION, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5499")),																 //$NON-NLS-1$

		MCC_5511_AUTOMOBILE_AND_TRUCK_DEALERS 													(5511, AUTOMOBILES_AND_VEHICLES, TRBCIndustry.AUTO_VEHICLES_PARTS_AND_SERVICES_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5511")),																 //$NON-NLS-1$
		MCC_5521_AUTOMOBILE_AND_TRUCK_DEALERS_USED_ONLY 										(5521, AUTOMOBILES_AND_VEHICLES, TRBCIndustry.AUTO_VEHICLES_PARTS_AND_SERVICES_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5521")),																 //$NON-NLS-1$
		MCC_5531_AUTO_STORE_HOME_SUPPLY_STORES 													(5531, AUTOMOBILES_AND_VEHICLES, TRBCIndustry.HOME_FURNISHINGS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5531")),																 //$NON-NLS-1$
		MCC_5532_AUTOMOTIVE_TIRE_STORES 														(5532, AUTOMOBILES_AND_VEHICLES, TRBCIndustry.AUTO_VEHICLES_PARTS_AND_SERVICES_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5532")),																 //$NON-NLS-1$
		MCC_5533_AUTOMOTIVE_PARTS_ACCESSORIES_STORES 											(5533, AUTOMOBILES_AND_VEHICLES, TRBCIndustry.AUTO_VEHICLES_PARTS_AND_SERVICES_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5533")),																 //$NON-NLS-1$
		MCC_5541_SERVICE_STATIONS 																(5541, AUTOMOBILES_AND_VEHICLES, TRBCIndustry.OIL_AND_GAS_REFINING_AND_MARKETING, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5541")),																 //$NON-NLS-1$
		MCC_5542_AUTOMATED_FUEL_DISPENSERS 														(5542, AUTOMOBILES_AND_VEHICLES, TRBCIndustry.OIL_AND_GAS_REFINING_AND_MARKETING, TCC_R_CAT, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5542")),																 //$NON-NLS-1$
		MCC_5551_BOAT_DEALERS 																	(5551, AUTOMOBILES_AND_VEHICLES, TRBCIndustry.RECREATIONAL_PRODUCTS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5551")),																 //$NON-NLS-1$
		MCC_5561_CAMP_DEALERS_RECREATIONAL_AND_UTILITY_TRAILERS 								(5561, AUTOMOBILES_AND_VEHICLES, TRBCIndustry.AUTO_VEHICLES_PARTS_AND_SERVICES_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5561")),																 //$NON-NLS-1$
		MCC_5571_MOTORCYCLE_SHOPS_AND_DEALERS 													(5571, AUTOMOBILES_AND_VEHICLES, TRBCIndustry.AUTO_VEHICLES_PARTS_AND_SERVICES_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5571")),																 //$NON-NLS-1$
		MCC_5592_MOTOR_HOME_DEALERS 															(5592, AUTOMOBILES_AND_VEHICLES, TRBCIndustry.AUTO_VEHICLES_PARTS_AND_SERVICES_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5592")),																 //$NON-NLS-1$
		MCC_5598_SNOWMOBILE_DEALERS 															(5598, AUTOMOBILES_AND_VEHICLES, TRBCIndustry.AUTO_VEHICLES_PARTS_AND_SERVICES_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5598")),																 //$NON-NLS-1$
		MCC_5599_MISCELLANEOUS_AUTOMOTIVE_AIRCRAFTS_AND_FARMS_EQUIPMENT_DEALERS 				(5599, AUTOMOBILES_AND_VEHICLES, TRBCIndustry.AUTO_VEHICLES_PARTS_AND_SERVICES_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5599")), //$NON-NLS-1$
		
		// ---------------
		// Clothing Stores
		// ---------------
			
		MCC_5611_MEN_AND_BOY_CLOTHING_AND_ACCESSORIES_STORES 									(5611, CLOTHING_STORES, TRBCIndustry.APPAREL_AND_ACCESSORIES_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5611")),																 //$NON-NLS-1$
		MCC_5621_WOMEN_READY_TO_WEAR_STORES 													(5621, CLOTHING_STORES, TRBCIndustry.APPAREL_AND_ACCESSORIES_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5621")),																 //$NON-NLS-1$
		MCC_5631_WOMEN_ACCESSORY_AND_SPECIALTY_STORES 											(5631, CLOTHING_STORES, TRBCIndustry.APPAREL_AND_ACCESSORIES_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5631")),																 //$NON-NLS-1$
		MCC_5641_CHILDREN_AND_INFANTS_WEAR_STORES 												(5641, CLOTHING_STORES, TRBCIndustry.APPAREL_AND_ACCESSORIES_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5641")),																 //$NON-NLS-1$
		MCC_5651_FAMILY_CLOTHING_STORES 														(5651, CLOTHING_STORES, TRBCIndustry.APPAREL_AND_ACCESSORIES_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5651")),																 //$NON-NLS-1$
		MCC_5655_SPORTS_APPAREL_RIDING_APPAREL_STORES 											(5655, CLOTHING_STORES, TRBCIndustry.APPAREL_AND_ACCESSORIES_RETAILERS  , TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5655")),																 //$NON-NLS-1$
		MCC_5661_SHOE_STORES 																	(5661, CLOTHING_STORES, TRBCIndustry.APPAREL_AND_ACCESSORIES_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5661")),																 //$NON-NLS-1$
		MCC_5681_FURRIERS_AND_FUR_SHOPS 														(5681, CLOTHING_STORES, TRBCIndustry.APPAREL_AND_ACCESSORIES_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5681")),																 //$NON-NLS-1$
		MCC_5691_MEN_AND_WOMEN_CLOTHING_STORES 													(5691, CLOTHING_STORES, TRBCIndustry.APPAREL_AND_ACCESSORIES_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5691")),																 //$NON-NLS-1$
		MCC_5697_ALTERATIONS_MENDING_SEAMSTRESSES_TAILORS 										(5697, CLOTHING_STORES, TRBCIndustry.APPAREL_AND_ACCESSORIES_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5697")),																 //$NON-NLS-1$
		MCC_5698_WIG_AND_TOUPEE_STORES 															(5698, CLOTHING_STORES, TRBCIndustry.APPAREL_AND_ACCESSORIES_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5698")),																 //$NON-NLS-1$
		MCC_5699_MISCELLANEOUS_APPAREL_AND_ACCESSORY_STORES 									(5699, CLOTHING_STORES, TRBCIndustry.APPAREL_AND_ACCESSORIES_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5699")), //$NON-NLS-1$
		
		// --------------------
		// Miscellaneous Stores
		// --------------------
		
		MCC_5712_EQUIMENT_FURNITURE_AND_HOME_FURNISHINGS_STORES_EXCEPT_APPLIANCES 				(5712, MISCELLANEOUS_STORES, TRBCIndustry.HOME_FURNISHINGS_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5712")),																 //$NON-NLS-1$
		MCC_5713_FLOOR_COVERING_STORES 															(5713, MISCELLANEOUS_STORES, TRBCIndustry.HOME_FURNISHINGS_RETAILERS , TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5713")),																 //$NON-NLS-1$
		MCC_5714_DRAPERY_WINDOW_COVERING_AND_UPHOLSTERY_STORES 									(5714, MISCELLANEOUS_STORES, TRBCIndustry.HOME_IMPROVEMENT_PRODUCTS_AND_SERVICES_RETAILERS , TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5714")),																 //$NON-NLS-1$
		MCC_5718_FIREPLACE_FIREPLACE_SCREENS_AND_ACCESSORIES_STORES 							(5718, MISCELLANEOUS_STORES, TRBCIndustry.HOME_IMPROVEMENT_PRODUCTS_AND_SERVICES_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5718")),																 //$NON-NLS-1$
		MCC_5719_MISCELLANEOUS_HOUSE_FURNISHING_SPECIALTY_SHOPS 								(5719, MISCELLANEOUS_STORES, TRBCIndustry.HOME_FURNISHINGS_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5719")),																 //$NON-NLS-1$
		MCC_5722_HOUSEHOLD_APPLIANCE_STORES 													(5722, MISCELLANEOUS_STORES, TRBCIndustry.APPLIANCES_TOOLS_AND_HOUSEWARES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5722")),																 //$NON-NLS-1$
		MCC_5732_ELECTRONIC_SALES 																(5732, MISCELLANEOUS_STORES, TRBCIndustry.COMPUTER_AND_ELECTRONIC_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5732")),																 //$NON-NLS-1$
		MCC_5733_MUSIC_STORES 																	(5733, MISCELLANEOUS_STORES, TRBCIndustry.OTHER_SPECIALTY_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5733")),																 //$NON-NLS-1$
		MCC_5734_COMPUTER_SOFTWARE_STORES 														(5734, MISCELLANEOUS_STORES, TRBCIndustry.COMPUTER_AND_ELECTRONIC_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5734")),																 //$NON-NLS-1$
		MCC_5735_RECORD_SHOPS 																	(5735, MISCELLANEOUS_STORES, TRBCIndustry.OTHER_SPECIALTY_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5735")),																 //$NON-NLS-1$

		MCC_5811_CATERERS																		(5811, SERVICE_PROVIDERS, TRBCIndustry.FOOD_PROCESSING, TCC_F_RES, MCG_4_RES, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5811")),																 //$NON-NLS-1$

		MCC_5812_EATING_PLACES_AND_RESTAURANTS 													(5812, MISCELLANEOUS_STORES, TRBCIndustry.RESTAURANTS_AND_BARS, TCC_F_RES, MCG_4_RES, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5812")),																 //$NON-NLS-1$
		MCC_5813_DRINKING_PLACES_ALCOHOLIC_BEVERAGES 											(5813, MISCELLANEOUS_STORES, TRBCIndustry.RESTAURANTS_AND_BARS, TCC_F_RES, MCG_4_RES, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5813")),																 //$NON-NLS-1$
		MCC_5814_FAST_FOOD_RESTAURANTS 															(5814, MISCELLANEOUS_STORES, TRBCIndustry.RESTAURANTS_AND_BARS, TCC_F_RES, MCG_4_RES, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5814")),																 //$NON-NLS-1$
		
		MCC_5815_DIGITAL_GOODS_MEDIA_BOOKS_MOVIES_MUSIC 										(5815, MISCELLANEOUS_STORES, TRBCIndustry.COMPUTER_AND_ELECTRONIC_RETAILERS, null, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5815")), // Not recognised by MC															 //$NON-NLS-1$
		MCC_5816_DIGITAL_GOODS_GAMES_EXCEPT_GAMBLING 											(5816, MISCELLANEOUS_STORES, TRBCIndustry.COMPUTER_AND_ELECTRONIC_RETAILERS, null, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5816")), // Not recognised by MC				 //$NON-NLS-1$
		MCC_5817_DIGITAL_GOODS_APPLICATION_EXCEPT_GAMES											(5817, MISCELLANEOUS_STORES, TRBCIndustry.COMPUTER_AND_ELECTRONIC_RETAILERS, null, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5817")), // Not recognised by MC											 //$NON-NLS-1$
		MCC_5818_DIGITAL_GOODS_LARGE_DIGITAL_GOODS_MERCHANT										(5818, MISCELLANEOUS_STORES, TRBCIndustry.COMPUTER_AND_ELECTRONIC_RETAILERS, null, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5818")), // Not recognised by MC											 //$NON-NLS-1$
		
		MCC_5912_DRUG_STORES_PHARMACIES 														(5912, MISCELLANEOUS_STORES, TRBCIndustry.DRUG_RETAILERS, TCC_R_OTH, MCG_6_RSK, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5912")),																 //$NON-NLS-1$
		MCC_5921_PACKAGE_STORES_BEER_WINE_AND_LIQUOR 											(5921, MISCELLANEOUS_STORES, TRBCIndustry.FOOD_RETAIL_AND_DISTRIBUTION, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5921")),																 //$NON-NLS-1$
		MCC_5931_USED_MERCHANDISE_AND_SECONDHAND_STORES 										(5931, MISCELLANEOUS_STORES, TRBCIndustry.OTHER_SPECIALTY_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5931")),																 //$NON-NLS-1$
		MCC_5932_ANTIQUE_SHOPS 																	(5932, MISCELLANEOUS_STORES, TRBCIndustry.HOME_FURNISHINGS_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5932")),																 //$NON-NLS-1$
		MCC_5933_PAWN_SHOPS 																	(5933, MISCELLANEOUS_STORES, TRBCIndustry.OTHER_SPECIALTY_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5933")),																 //$NON-NLS-1$
		MCC_5935_WRECKLING_AND_SALVAGE_YARDS 													(5935, MISCELLANEOUS_STORES, TRBCIndustry.OTHER_SPECIALTY_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5935")),																 //$NON-NLS-1$
		MCC_5937_ANTIQUE_REPRODUCTIONS_STORES 													(5937, MISCELLANEOUS_STORES, TRBCIndustry.HOME_FURNISHINGS_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5937")),																 //$NON-NLS-1$
		MCC_5940_BICYCLE_SHOPS 																	(5940, MISCELLANEOUS_STORES, TRBCIndustry.OTHER_SPECIALTY_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5940")),																 //$NON-NLS-1$
		MCC_5941_SPORTING_GOODS_STORES 															(5941, MISCELLANEOUS_STORES, TRBCIndustry.OTHER_SPECIALTY_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5941")),																 //$NON-NLS-1$
		MCC_5942_BOOK_STORES 																	(5942, MISCELLANEOUS_STORES, TRBCIndustry.OTHER_SPECIALTY_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5942")),																 //$NON-NLS-1$
		MCC_5943_OFFICE_SCHOOL_SUPPLY_AND_STATIONERY_STORES 									(5943, MISCELLANEOUS_STORES, TRBCIndustry.OTHER_SPECIALTY_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5943")),																 //$NON-NLS-1$
		MCC_5944_CLOCK_JEWELRY_WATCH_AND_SILVERWARE_STORES 										(5944, MISCELLANEOUS_STORES, TRBCIndustry.APPAREL_AND_ACCESSORIES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5944")),																 //$NON-NLS-1$
		MCC_5945_GAME_TOY_AND_HOBBY_SHOPS														(5945, MISCELLANEOUS_STORES, TRBCIndustry.TOYS_AND_JUVENILE_PRODUCTS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5945")),																 //$NON-NLS-1$
		MCC_5946_CAMERA_AND_PHOTOGRAPHIC_SUPPLY_STORES 											(5946, MISCELLANEOUS_STORES, TRBCIndustry.HOUSEHOLD_ELECTRONICS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5946")),																 //$NON-NLS-1$
		MCC_5947_CARD_GIFT_NOVELTY_AND_SOUVENIR_SHOPS 											(5947, MISCELLANEOUS_STORES, TRBCIndustry.OTHER_SPECIALTY_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5947")),																 //$NON-NLS-1$
		MCC_5948_LEATHER_GOODS_AND_LUGGAGE_STORES 												(5948, MISCELLANEOUS_STORES, TRBCIndustry.APPAREL_AND_ACCESSORIES_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5948")),																 //$NON-NLS-1$
		MCC_5949_FABRIC_NEEDLEWORK_PIECE_GOODS_AND_SEWING_STORES 								(5949, MISCELLANEOUS_STORES, TRBCIndustry.PERSONAL_PRODUCTS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5949")),																 //$NON-NLS-1$
		MCC_5950_GLASSWARE_CRYSTAL_STORES 														(5950, MISCELLANEOUS_STORES, TRBCIndustry.HOME_FURNISHINGS_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5950")),																 //$NON-NLS-1$
		
		MCC_5960_DIRECT_MARKETING_INSURANCE_SERVICES 											(5960, MOTO, TRBCIndustry.ADVERTISING_AND_MARKETING, TCC_T_OTH, MCG_5_MEC, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5960")),																 //$NON-NLS-1$
		MCC_5962_DIRECT_MARKETING_TRAVEL_RELATED_ARRANGEMENT_SERVICES 							(5962, MOTO, TRBCIndustry.ADVERTISING_AND_MARKETING, TCC_T_OTH, MCG_6_RSK, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5962")),																 //$NON-NLS-1$
		
		MCC_5963_DOOR_TO_DOOR_SALES 															(5963, MISCELLANEOUS_STORES, TRBCIndustry.ADVERTISING_AND_MARKETING, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5963")),																 //$NON-NLS-1$
		
		MCC_5964_DIRECT_MARKETING_CATALOG_MERCHANTS 											(5964, MOTO, TRBCIndustry.ADVERTISING_AND_MARKETING, TCC_T_OTH, MCG_5_MEC, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5964")),																 //$NON-NLS-1$
		MCC_5965_DIRECT_MARKETING_COMBINATION_CATALOG_AND_RETAIL_MERCHANTS 						(5965, MOTO, TRBCIndustry.ADVERTISING_AND_MARKETING, TCC_T_OTH, MCG_5_MEC, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5965")),																 //$NON-NLS-1$
		MCC_5966_DIRECT_MARKETING_OUTBOUND_TELEMARKETING_MERCHANTS 								(5966, MOTO, TRBCIndustry.ADVERTISING_AND_MARKETING, TCC_T_OTH, MCG_6_RSK, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5966")),																 //$NON-NLS-1$
		MCC_5967_DIRECT_MARKETING_INBOUND_TELEMARKETING_MERCHANTS 								(5967, MOTO, TRBCIndustry.ADVERTISING_AND_MARKETING, TCC_T_OTH, MCG_6_RSK, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5967")),																 //$NON-NLS-1$
		MCC_5968_DIRECT_MARKETING_CONTINUITY_SUBSCRIPTION_MERCHANTS 							(5968, MOTO, TRBCIndustry.ADVERTISING_AND_MARKETING, TCC_T_OTH, MCG_5_MEC, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5968")),																 //$NON-NLS-1$
		MCC_5969_DIRECT_MARKETING_OTHER_DIRECT_MARKETERS_NOT_ELSEWHERE_CLASSIFIED 				(5969, MOTO, TRBCIndustry.ADVERTISING_AND_MARKETING, TCC_T_OTH, MCG_5_MEC, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5969")),																 //$NON-NLS-1$
		
		MCC_5970_ARTIST_SUPPLY_AND_CRAFT_SHOPS 													(5970, MISCELLANEOUS_STORES, TRBCIndustry.OTHER_SPECIALTY_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5970")),																 //$NON-NLS-1$
		MCC_5971_ART_DEALERS_AND_GALLERIES 														(5971, MISCELLANEOUS_STORES, TRBCIndustry.HOME_FURNISHINGS_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5971")),																 //$NON-NLS-1$
		MCC_5972_STAMP_AND_COIN_STORES 															(5972, MISCELLANEOUS_STORES, TRBCIndustry.OTHER_SPECIALTY_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5972")),																 //$NON-NLS-1$
		MCC_5973_RELIGIOUS_GOODS_STORES 														(5973, MISCELLANEOUS_STORES, TRBCIndustry.OTHER_SPECIALTY_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5973")),																 //$NON-NLS-1$
		MCC_5975_HEARING_AIDS_SALES_SERVICE_AND_SUPPLY_STORES 									(5975, MISCELLANEOUS_STORES, TRBCIndustry.OTHER_SPECIALTY_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5975")),																 //$NON-NLS-1$
		MCC_5976_ORTHOPEDIC_GOODS_ARTIFICIAL_LIMB_STORES 										(5976, MISCELLANEOUS_STORES, TRBCIndustry.OTHER_SPECIALTY_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5976")),																 //$NON-NLS-1$
		MCC_5977_COSMETIC_STORES 																(5977, MISCELLANEOUS_STORES, TRBCIndustry.OTHER_SPECIALTY_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5977")),																 //$NON-NLS-1$
		MCC_5978_TYPE_WRITER_STORES 															(5978, MISCELLANEOUS_STORES, TRBCIndustry.OTHER_SPECIALTY_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5978")),																 //$NON-NLS-1$
		MCC_5983_FUEL_DEALERS 																	(5983, MISCELLANEOUS_STORES, TRBCIndustry.OIL_AND_GAS_REFINING_AND_MARKETING, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5983")), //$NON-NLS-1$
		MCC_5992_FLORISTS 																		(5992, MISCELLANEOUS_STORES, TRBCIndustry.OTHER_SPECIALTY_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5992")),																 //$NON-NLS-1$
		MCC_5993_CIGAR_STORES_AND_STANDS 														(5993, MISCELLANEOUS_STORES, TRBCIndustry.FOOD_RETAIL_AND_DISTRIBUTION, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5993")),																 //$NON-NLS-1$
		MCC_5994_NEWS_DEALERS_AND_NEWSSTANDS 													(5994, MISCELLANEOUS_STORES, TRBCIndustry.OTHER_SPECIALTY_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5994")),																 //$NON-NLS-1$
		MCC_5995_PET_SHOPS 																		(5995, MISCELLANEOUS_STORES, TRBCIndustry.OTHER_SPECIALTY_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5995")),																 //$NON-NLS-1$
		MCC_5996_SWIMMING_POOLS_SALES_SERVICE_AND_SUPPLIES 										(5996, MISCELLANEOUS_STORES, TRBCIndustry.OTHER_SPECIALTY_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5996")),																 //$NON-NLS-1$
		MCC_5997_ELECTRIC_RAZOR_STORES_SALES_AND_SERVICES 										(5997, MISCELLANEOUS_STORES, TRBCIndustry.OTHER_SPECIALTY_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5997")),																 //$NON-NLS-1$
		MCC_5998_TENT_AND_AWNING_SHOPS 															(5998, MISCELLANEOUS_STORES, TRBCIndustry.OTHER_SPECIALTY_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5998")),																 //$NON-NLS-1$
		MCC_5999_MISCELLANEOUS_AND_SPECIALTY_RETAIL_STORES 										(5999, MISCELLANEOUS_STORES, TRBCIndustry.OTHER_SPECIALTY_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.5999")),																 //$NON-NLS-1$
		
		MCC_6010_MEMBER_FINANCIAL_INSTITUTIONS_MANUAL_CASH 										(6010, SERVICE_PROVIDERS, TRBCIndustry.BANKS, TCC_C_CSH, MCG_8_CSH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.6010")),																 //$NON-NLS-1$
		MCC_6011_MEMBER_FINANCIAL_INSTITUTIONS_AUTOMATED_CASH 									(6011, SERVICE_PROVIDERS, TRBCIndustry.BANKS, TCC_Z_ATM, MCG_9_ATM, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.6011")),																 //$NON-NLS-1$
		MCC_6012_MEMBER_FINANCIAL_INSTITUTIONS_MERCHANDISE_AND_SERVICES 						(6012, SERVICE_PROVIDERS, TRBCIndustry.BANKS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.6012")),																 //$NON-NLS-1$
		MCC_6050_QUASI_CASH_MEMBER_FINANCIAL_INSTITUTION 										(6050, SERVICE_PROVIDERS, TRBCIndustry.BANKS, TCC_U_QEC, MCG_10_QUA, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.6050")),																 //$NON-NLS-1$
		MCC_6051_QUASI_CASH_MERCHANT 															(6051, SERVICE_PROVIDERS, TRBCIndustry.CASINOS_AND_GAMING, TCC_U_QEC, MCG_10_QUA, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.6051")),																 //$NON-NLS-1$
		MCC_6211_SECURITIES_BROKERS_DEALERS 													(6211, SERVICE_PROVIDERS, TRBCIndustry.INVESTMENT_BANKING_AND_BROKERAGE_SERVICES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.6211")),																 //$NON-NLS-1$
		MCC_6300_INSURANCE_SALES_UNDERWRITING_AND_PREMIUMS 										(6300, SERVICE_PROVIDERS, TRBCIndustry.MULTILINE_INSURANCE_AND_BROKERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.6300")), //$NON-NLS-1$
		MCC_6513_REAL_ESTATE_AGENTS_AND_MANAGERS_RENTALS 										(6513, SERVICE_PROVIDERS, TRBCIndustry.REAL_ESTATE_SERVICES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.6513")), //$NON-NLS-1$
		MCC_6529_REMOTE_STORED_VALUE_LOAD_MEMBER_FINANCIAL_INSTITUTION 							(6529, SERVICE_PROVIDERS, TRBCIndustry.BANKS, TCC_U_QEC, null, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.6529")), // Not recognised by Visa //$NON-NLS-1$
		MCC_6530_REMOTE_STORED_VALUE_LOAD_MERCHANT 												(6530, SERVICE_PROVIDERS, TRBCIndustry.BUSINESS_SUPPORT_SERVICES, TCC_U_QEC, null, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.6530")), // Not recognised by Visa //$NON-NLS-1$
		MCC_6531_PAYMENT_SERVICE_PROVIDER_MONEY_TRANSFER_FOR_A_PURCHASE 						(6531,  SERVICE_PROVIDERS, TRBCIndustry.BUSINESS_SUPPORT_SERVICES, TCC_T_OTH, null, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.6531")), // Not recognised by Visa																 //$NON-NLS-1$
		MCC_6532_PAYMENT_SERVICE_PROIDER_MEMBER_FINANCIAL_INSTITUTION_PAYMENT_TRANSACTION 		(6532, SERVICE_PROVIDERS, TRBCIndustry.BANKS, TCC_P_TRX, null, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.6532")), // Not recognised by Visa																 //$NON-NLS-1$
		MCC_6533_PAYMENT_SERVICE_PROVIDER_MERCHANT_PAYMENT_TRANSACTION 							(6533, SERVICE_PROVIDERS, TRBCIndustry.BUSINESS_SUPPORT_SERVICES, TCC_P_TRX, null, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.6533")), // Not recognised by Visa //$NON-NLS-1$
		MCC_6534_MONEY_TRANSFER_MEMBER_FINANCIAL_INSTITUTION 									(6534, SERVICE_PROVIDERS, TRBCIndustry.BANKS, TCC_U_QEC, null, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.6534")), // Not recognised by Visa				 //$NON-NLS-1$
		MCC_6535_VALUE_PURCHASE_MEMBER_FINANCIAL_INSTITUTION 									(6535, SERVICE_PROVIDERS, TRBCIndustry.BANKS, TCC_T_OTH, null, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.6535")), // Not recognised by Visa				 //$NON-NLS-1$
		
		MCC_7011_LODGING_HOTELS_MOTELS_RESORTS_NOT_ELSEWHERE_CLASSIFIED 						(7011, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7011")),																 //$NON-NLS-1$

		MCC_7012_TIMESHARES 																	(7012, SERVICE_PROVIDERS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7012")),																 //$NON-NLS-1$
		MCC_7032_SPORTING_AND_RECREATIONAL_CAMPS 												(7032, SERVICE_PROVIDERS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7032")),																 //$NON-NLS-1$
		MCC_7033_TRAILER_PARKS_AND_CAMP_GROUNDS 												(7033, SERVICE_PROVIDERS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7033")), //$NON-NLS-1$
		
		MCC_7210_LAUNDRY_CLEANSING_AND_ARMENT_SERVICES 											(7210, PERSONAL_SERVICES_PROVIDERS, TRBCIndustry.PERSONAL_SERVICES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7210")),																 //$NON-NLS-1$
		MCC_7211_LAUNDRY_FAMILY_AND_COMMERCIAL 													(7211, PERSONAL_SERVICES_PROVIDERS, TRBCIndustry.PERSONAL_SERVICES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7211")),																 //$NON-NLS-1$
		MCC_7216_DRY_CLEANERS 																	(7216, PERSONAL_SERVICES_PROVIDERS, TRBCIndustry.PERSONAL_SERVICES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7216")),																 //$NON-NLS-1$
		MCC_7217_CARPET_AND_UPHOLSTERY_CLEANING 												(7217, PERSONAL_SERVICES_PROVIDERS, TRBCIndustry.PERSONAL_SERVICES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7217")),																 //$NON-NLS-1$
		MCC_7221_PHOTOGRAPHIC_STUDIOS 															(7221, PERSONAL_SERVICES_PROVIDERS, TRBCIndustry.PERSONAL_SERVICES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7221")),																 //$NON-NLS-1$
		MCC_7230_BARBER_AND_BEAUTY_SHOPS 														(7230, PERSONAL_SERVICES_PROVIDERS, TRBCIndustry.PERSONAL_SERVICES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7230")),																 //$NON-NLS-1$
		MCC_7251_SHOE_REPAIR_SHOPS_AND_SHOE_SHINE_PARLORS_AND_HAT_CLEANING_SHOPS 				(7251, PERSONAL_SERVICES_PROVIDERS, TRBCIndustry.PERSONAL_SERVICES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7251")),																 //$NON-NLS-1$
		MCC_7261_FUNERAL_SERVICE_AND_CREMATORIES 												(7261, PERSONAL_SERVICES_PROVIDERS, TRBCIndustry.PERSONAL_SERVICES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7261")),																 //$NON-NLS-1$
		MCC_7273_DATING_AND_ESCORT_SERVICES 													(7273, PERSONAL_SERVICES_PROVIDERS, TRBCIndustry.PERSONAL_SERVICES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7273")),																 //$NON-NLS-1$
		MCC_7276_TAX_PREPARATION_SERVICE 														(7276, PERSONAL_SERVICES_PROVIDERS, TRBCIndustry.PERSONAL_SERVICES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7276")),																 //$NON-NLS-1$
		MCC_7277_DEBT_MARRIAGE_PERSONAL_COUNSELING_SERVICE 										(7277, PERSONAL_SERVICES_PROVIDERS, TRBCIndustry.PERSONAL_SERVICES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7277")),																 //$NON-NLS-1$
		MCC_7278_BUYING_SHOPPING_CLUBS_SERVICES 												(7278, PERSONAL_SERVICES_PROVIDERS, TRBCIndustry.PERSONAL_SERVICES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7278")),																 //$NON-NLS-1$
		MCC_7296_CLOTHING_RENTAL_COSTUME_FORMAL_WEAR_UNIFORMS 									(7296, PERSONAL_SERVICES_PROVIDERS, TRBCIndustry.APPAREL_AND_ACCESSORIES_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7296")),																 //$NON-NLS-1$
		MCC_7297_MASSAGE_PARLORS 																(7297, PERSONAL_SERVICES_PROVIDERS, TRBCIndustry.OTHER_SPECIALTY_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7297")),																 //$NON-NLS-1$
		MCC_7298_HEALTH_AND_BEAUTY_SPAS 														(7298, PERSONAL_SERVICES_PROVIDERS, TRBCIndustry.OTHER_SPECIALTY_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7298")),																 //$NON-NLS-1$
		MCC_7299_MISCELLANEOUS_PERSONAL_SERVICES_NOT_ELSEWHERE_CLASSIFIED 						(7299, PERSONAL_SERVICES_PROVIDERS, TRBCIndustry.PERSONAL_SERVICES, TCC_R_OTH, MCG_6_RSK, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7299")), // IFC Transaction //$NON-NLS-1$
		
		// --------------------
		// Business Services
		// --------------------
		
		MCC_7311_ADVERTISING_SERVICES															(7311, BUSINESS_SERVICES, TRBCIndustry.ADVERTISING_AND_MARKETING , TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7311")),																 //$NON-NLS-1$
		MCC_7321_CONSUMER_CREDIT_REPORTING_AGENCIES 											(7321, BUSINESS_SERVICES, TRBCIndustry.PROFESSIONAL_INFORMATION_SERVICES , TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7321")),																 //$NON-NLS-1$
		MCC_7333_COMMERCIAL_ART_PHOTOGRAPHY_AND_GRAPHICS										(7333, BUSINESS_SERVICES, TRBCIndustry.BUSINESS_SUPPORT_SERVICES , TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7333")),																 //$NON-NLS-1$
		MCC_7338_QUICK_COPY_REPRODUCTION_AND_BLUE_PRINTING_SERVICES 							(7338, BUSINESS_SERVICES, TRBCIndustry.COMMERCIAL_PRINTING_SERVICES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7338")),																 //$NON-NLS-1$
		MCC_7339_STENOGRAPHIC_AND_SECRETATIAL_SUPPORT_SERVICES 									(7339, BUSINESS_SERVICES, TRBCIndustry.BUSINESS_SUPPORT_SERVICES , TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7339")),																 //$NON-NLS-1$
		MCC_7342_EXTERMINATING_AND_DISINFECTING_SERVICES 										(7342, BUSINESS_SERVICES, TRBCIndustry.BUSINESS_SUPPORT_SERVICES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7342")),																 //$NON-NLS-1$
		MCC_7349_CLEANING_AND_MAINTENANCE_JANITORIAL_SERVICES 									(7349, BUSINESS_SERVICES, TRBCIndustry.BUSINESS_SUPPORT_SERVICES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7349")),																 //$NON-NLS-1$
		MCC_7361_EMPLOYMENT_AGENCIES_TEMPORARY_HELP_SERVICES 									(7361, BUSINESS_SERVICES, TRBCIndustry.EMPLOYMENT_SERVICES , TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7361")),																 //$NON-NLS-1$
		MCC_7372_COMPUTER_PROGRAMMING_INTEGRATED_SYSTEMS_DESIGN_AND_DATA_PROCESSING_SERVICES 	(7372, BUSINESS_SERVICES, TRBCIndustry.IT_SERVICES_AND_CONSULTING, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7372")),																 //$NON-NLS-1$

		MCC_7375_INFORMATION_RETRIEVAL_SERVICES 												(7375, WHOLESALE, TRBCIndustry.PROFESSIONAL_INFORMATION_SERVICES, TCC_T_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7375")),																 //$NON-NLS-1$
		MCC_7379_COMPUTER_MAINTENANCE_AND_REPAIR_SERVICES_NOT_ELSEWHERE_CLASSIFIED 				(7379, WHOLESALE, TRBCIndustry.COMPUTER_AND_ELECTRONIC_RETAILERS, TCC_T_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7379")),																 //$NON-NLS-1$

		MCC_7392_MANAGEMENT_CONSULTING_AND_PUBLIC_RELATIONS_SERVICES 							(7392, BUSINESS_SERVICES, TRBCIndustry.BUSINESS_SUPPORT_SERVICES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7392")),																 //$NON-NLS-1$
		MCC_7393_PROSPECTIVE_AND_SECURITY_SERVICES_INCLUDED_ARMORED_CARS_AND_GUARD_DOGS 		(7393, BUSINESS_SERVICES, TRBCIndustry.BUSINESS_SUPPORT_SERVICES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7393")),																 //$NON-NLS-1$
		MCC_7394_EQUIPMENT_RENTAL_AND_LEASING_SERVICES_TOOL_FURNITURE_AND_APPLIANCE_RENTAL 		(7394, BUSINESS_SERVICES, TRBCIndustry.BUSINESS_SUPPORT_SUPPLIES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7394")),																 //$NON-NLS-1$
		MCC_7395_PHOTOFINISHING_LABOTORIES_PHOTO_DEVELOPPING 									(7395, BUSINESS_SERVICES, TRBCIndustry.BUSINESS_SUPPORT_SERVICES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7395")),																 //$NON-NLS-1$
		MCC_7399_BUSINESS_SERVICES_NOT_ELSEWHERE_CLASSIFIED 									(7399, BUSINESS_SERVICES, TRBCIndustry.BUSINESS_SUPPORT_SERVICES , TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7399")),																 //$NON-NLS-1$
		MCC_7511_TRUCK_STOP_TRANSACTIONS 														(7511, BUSINESS_SERVICES, TRBCIndustry.BUSINESS_SUPPORT_SERVICES, TCC_U_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7511")),																 //$NON-NLS-1$
		
		MCC_7512_CAR_RENTAL_COMPANIES_NOT_ELSEWHERE_CLASSIFIED 									(7512, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA , TCC_A_CAR, MCG_3_AUT, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7512")),																 //$NON-NLS-1$
		MCC_7513_TRUCK_AND_UTILITY_TRAILER_RENTALS 												(7513, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.GROUND_FREIGHT_AND_LOGISTICS , TCC_A_CAR, MCG_3_AUT, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7513")),																 //$NON-NLS-1$
		MCC_7519_MOTOR_HOME_AND_RECREATIONAL_VEHICLE_RENTALS 									(7519, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA  , TCC_A_CAR, MCG_3_AUT, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7519")),																 //$NON-NLS-1$
		
		MCC_7523_AUTOMOBILE_PARKING_LOTS_AND_GARAGES 											(7523, BUSINESS_SERVICES, TRBCIndustry.HIGHWAYS_AND_RAILTRACKS , TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7523")),																 //$NON-NLS-1$

		MCC_7531_AUTOMOTIVE_BODY_REPAIR_SHOPS													(7531, REPAIR_SERVICES, TRBCIndustry.AUTO_VEHICLES_PARTS_AND_SERVICES_RETAILERS , TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7531")),																 //$NON-NLS-1$
		MCC_7534_TIRE_RE_TREADING_AND_REPAIR_SHOPS 												(7534, REPAIR_SERVICES, TRBCIndustry.AUTO_VEHICLES_PARTS_AND_SERVICES_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7534")),																 //$NON-NLS-1$
		MCC_7535_AUTOMOTIVE_PAINT_SHOPS 														(7535, REPAIR_SERVICES, TRBCIndustry.AUTO_VEHICLES_PARTS_AND_SERVICES_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7535")),																 //$NON-NLS-1$
		MCC_7538_AUTOMOTIVE_SERVICE_SHOPS 														(7538, REPAIR_SERVICES, TRBCIndustry.AUTO_VEHICLES_PARTS_AND_SERVICES_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7538")),																 //$NON-NLS-1$
		MCC_7542_CAR_WASHES 																	(7542, REPAIR_SERVICES, TRBCIndustry.AUTO_VEHICLES_PARTS_AND_SERVICES_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7542")),																 //$NON-NLS-1$
		MCC_7549_TOWING_SERVICES 																(7549, REPAIR_SERVICES, TRBCIndustry.AUTO_VEHICLES_PARTS_AND_SERVICES_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7549")),																 //$NON-NLS-1$
		MCC_7622_ELECTRONIC_REPAIR_SHOPS 														(7622, REPAIR_SERVICES, TRBCIndustry.COMPUTER_AND_ELECTRONIC_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7622")),																 //$NON-NLS-1$
		MCC_7623_AIR_CONDITIONING_AND_REFRIGERATION_REPAIR_SHOPS 								(7623, REPAIR_SERVICES, TRBCIndustry.PERSONAL_SERVICES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7623")),																 //$NON-NLS-1$
		MCC_7629_ELECTRICAL_AND_SMALL_APPLIANCE_REPAIR_SHOPS 									(7629, REPAIR_SERVICES, TRBCIndustry.PERSONAL_SERVICES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7629")),																 //$NON-NLS-1$
		MCC_7631_CLOCK_JEWELRY_AND_WATCH_REPAIR_SHOPS 											(7631, REPAIR_SERVICES, TRBCIndustry.PERSONAL_SERVICES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7631")),																 //$NON-NLS-1$
		MCC_7641_FURNITURE_REUPHOLSTERY_AND_REPAIR_REFINISHING 									(7641, REPAIR_SERVICES, TRBCIndustry.PERSONAL_SERVICES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7641")),																 //$NON-NLS-1$
		MCC_7692_WELDING_REPAIR 																(7692, REPAIR_SERVICES, TRBCIndustry.PERSONAL_SERVICES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7692")),																 //$NON-NLS-1$
		MCC_7699_MISCELLANEOUS_REPAIR_SHOPS_AND_RELATED_SERVICES 								(7699, REPAIR_SERVICES, TRBCIndustry.PERSONAL_SERVICES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7699")),																 //$NON-NLS-1$

		MCC_7800_GOVERNEMENT_OWNED_LOTTERIES 													(7800, AMUSEMENT_AND_ENTERTAINMENT, TRBCIndustry.CASINOS_AND_GAMING, null, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7800")), // Not recognised by MC //$NON-NLS-1$
		MCC_7801_GOVERNEMENT_LICENSED_CASINOS 													(7801, AMUSEMENT_AND_ENTERTAINMENT, TRBCIndustry.CASINOS_AND_GAMING, null, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7801")), // Not recognised by MC //$NON-NLS-1$
		MCC_7802_GOVERNEMENT_LICENSED_HORSE_DOG_RACES 											(7801, AMUSEMENT_AND_ENTERTAINMENT, TRBCIndustry.CASINOS_AND_GAMING, null, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7802")), // Not recognised by MC //$NON-NLS-1$
		
		MCC_7829_MOTION_PICTURES_AND_VIDEO_TAPE_PRODUCTION_AND_DISTRIBUTION 					(7829, WHOLESALE, TRBCIndustry.ENTERTAINMENT_PRODUCTION , TCC_T_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7829")),																 //$NON-NLS-1$
		
		MCC_7832_MOTION_PICTURE_THEATERS 														(7832, AMUSEMENT_AND_ENTERTAINMENT, TRBCIndustry.ENTERTAINMENT_PRODUCTION , TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7832")),	 //$NON-NLS-1$
		MCC_7841_VIDEO_TAPE_RENTAL_STORES 														(7841, AMUSEMENT_AND_ENTERTAINMENT, TRBCIndustry.PERSONAL_SERVICES , TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7841")),																 //$NON-NLS-1$
		MCC_7911_DANCE_HALLS_STUDIOS_AND_SCHOOLS 												(7911, AMUSEMENT_AND_ENTERTAINMENT, TRBCIndustry.PERSONAL_SERVICES , TCC_R_OTH, MCG_7_OTH, 	Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7911")),				 //$NON-NLS-1$
		MCC_7922_THEATRICAL_PRODUCERS_TICKET_AGENCIES 											(7922, AMUSEMENT_AND_ENTERTAINMENT, TRBCIndustry.ENTERTAINMENT_PRODUCTION , TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7922")),																 //$NON-NLS-1$
		MCC_7929_BANDS_ORCHESTRAS_AND_MISCELLANEOUS_ENTERTAINERS_NOT_ELSESWHERE_CLASSIFIED 		(7929, AMUSEMENT_AND_ENTERTAINMENT, TRBCIndustry.ENTERTAINMENT_PRODUCTION, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7929")),																 //$NON-NLS-1$
		MCC_7932_BILLIARD_AND_POOL_ESTABLISHMENT 												(7932, AMUSEMENT_AND_ENTERTAINMENT, TRBCIndustry.LEISURE_AND_RECREATION , TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7932")),					 //$NON-NLS-1$
		MCC_7933_BOWLING_ALLEYS 																(7933, AMUSEMENT_AND_ENTERTAINMENT, TRBCIndustry.LEISURE_AND_RECREATION , TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7933")), //$NON-NLS-1$
		MCC_7941_COMMERCIAL_SPORTS_ATHLETIC_FIELDS_PROFESSIONAL_SPORT_CLUBS_AND_SPORT_PROMOTERS	(7941, AMUSEMENT_AND_ENTERTAINMENT, TRBCIndustry.LEISURE_AND_RECREATION , TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7941")),															 //$NON-NLS-1$
		MCC_7991_TOURIST_ATTRACTIONS_AND_EXHIBITS 												(7991, AMUSEMENT_AND_ENTERTAINMENT, TRBCIndustry.LEISURE_AND_RECREATION, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7991")),																 //$NON-NLS-1$
		MCC_7992_GOLF_COURSES_PUBLIC 															(7992, AMUSEMENT_AND_ENTERTAINMENT, TRBCIndustry.LEISURE_AND_RECREATION, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7992")),	 //$NON-NLS-1$
		MCC_7993_VIDEO_AMUSEMENT_GAME_SUPPLIES 													(7993, AMUSEMENT_AND_ENTERTAINMENT, TRBCIndustry.OTHER_SPECIALTY_RETAILERS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7993")),													 //$NON-NLS-1$
		MCC_7994_VIDEO_GAME_ARCADES_ESTABLISHMENT 												(7994, AMUSEMENT_AND_ENTERTAINMENT, TRBCIndustry.CASINOS_AND_GAMING, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7994")), // IFC Transaction																 //$NON-NLS-1$
		MCC_7995_GAMBLING_TRANSACTIONS 															(7995, AMUSEMENT_AND_ENTERTAINMENT, TRBCIndustry.CASINOS_AND_GAMING, TCC_U_OTH, MCG_6_RSK, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7995")), //$NON-NLS-1$
		MCC_7996_AMUSEMENT_PARKS_CARNIVALS_CIRCUSES_FORTUNE_TELLERS								(7996, AMUSEMENT_AND_ENTERTAINMENT, TRBCIndustry.LEISURE_AND_RECREATION, TCC_R_OTH, MCG_7_OTH, 	Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7996")),															 //$NON-NLS-1$
		MCC_7997_CLUBS_MEMBERSHIP_COUNTRY_CLUBS_AND_PRIVATE_GOLF_COURSES 						(7997, AMUSEMENT_AND_ENTERTAINMENT, TRBCIndustry.LEISURE_AND_RECREATION, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7997")),																 //$NON-NLS-1$
		MCC_7998_AQUARIUMS_SEA_AQUARIUMS_DOLPHINARIUMS_ZOOS 									(7998, AMUSEMENT_AND_ENTERTAINMENT, TRBCIndustry.LEISURE_AND_RECREATION, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7998")),															 //$NON-NLS-1$
		MCC_7999_RECREATION_SERVICES_NOT_ELSEWHERE_CLASSIFIED 									(7999, AMUSEMENT_AND_ENTERTAINMENT, TRBCIndustry.LEISURE_AND_RECREATION, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.7999")), //$NON-NLS-1$
		
		
		// --------------------------------------------------
		// Professional Services and Membership Organisations
		// --------------------------------------------------
		
		MCC_8011_DOCTORS_AND_PHYSICIANS_NOT_ELSEWHERE_CLASSIFIED 								(8011, PROFESSIONAL_SERVICES, TRBCIndustry.HEALTH_CARE_FACILITIES_AND_SERVICES  , TCC_R_OTH, MCG_11_MED, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.8011")),																 //$NON-NLS-1$
		MCC_8021_DENTISTS_AND_ORTHODONTISTS 													(8021, PROFESSIONAL_SERVICES, TRBCIndustry.HEALTH_CARE_FACILITIES_AND_SERVICES  , TCC_R_OTH, MCG_11_MED, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.8021")),																 //$NON-NLS-1$
		MCC_8031_OSTEOPATHS 																	(8031, PROFESSIONAL_SERVICES, TRBCIndustry.HEALTH_CARE_FACILITIES_AND_SERVICES  , TCC_R_OTH, MCG_11_MED, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.8031")),																 //$NON-NLS-1$
		MCC_8041_CHIROPRACTORS 																	(8041, PROFESSIONAL_SERVICES, TRBCIndustry.HEALTH_CARE_FACILITIES_AND_SERVICES  , TCC_R_OTH, MCG_11_MED, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.8041")),																 //$NON-NLS-1$
		MCC_8042_OPTOMETRISTS_AND_OPHTALMOLOGISTS 												(8042, PROFESSIONAL_SERVICES, TRBCIndustry.HEALTH_CARE_FACILITIES_AND_SERVICES  , TCC_R_OTH, MCG_11_MED, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.8042")),																 //$NON-NLS-1$
		MCC_8043_OPTICIANS_OPTICAL_GOODS_AND_EYEGLASSES 										(8043, PROFESSIONAL_SERVICES, TRBCIndustry.OTHER_SPECIALTY_RETAILERS, TCC_R_OTH, MCG_11_MED, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.8043")),																 //$NON-NLS-1$
		MCC_8049_PODIATRISTS_AND_CHIROPODISTS 													(8049, PROFESSIONAL_SERVICES, TRBCIndustry.HEALTH_CARE_FACILITIES_AND_SERVICES  , TCC_R_OTH, MCG_11_MED, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.8049")),																 //$NON-NLS-1$
		MCC_8050_NURSING_AND_PERSONAL_CARE_FACILITIES 											(8050, PROFESSIONAL_SERVICES, TRBCIndustry.PERSONAL_SERVICES , TCC_O_HOS, MCG_11_MED, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.8050")),																 //$NON-NLS-1$
		MCC_8062_HOSPITALS 																		(8062, PROFESSIONAL_SERVICES, TRBCIndustry.HEALTH_CARE_FACILITIES_AND_SERVICES  , TCC_O_HOS, MCG_11_MED, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.8062")),																 //$NON-NLS-1$
		MCC_8071_MEDICAL_AND_DENTAL_LABORATORIES												(8071, PROFESSIONAL_SERVICES, TRBCIndustry.HEALTH_CARE_FACILITIES_AND_SERVICES  , TCC_R_OTH, MCG_11_MED, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.8071")),																 //$NON-NLS-1$
		MCC_8099_MEDICAL_SERVICES_AND_HEALTH_PRACTITIONERS_NOT_ELSEWHERE_CLASSIFIED				(8099, PROFESSIONAL_SERVICES, TRBCIndustry.HEALTH_CARE_FACILITIES_AND_SERVICES, TCC_R_OTH, MCG_11_MED, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.8099")),																 //$NON-NLS-1$
		MCC_8111_LEGAL_SERVICES_AND_ATTORNEYS 													(8111, PROFESSIONAL_SERVICES, TRBCIndustry.BUSINESS_SUPPORT_SERVICES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.8111")),																 //$NON-NLS-1$
		MCC_8211_ELEMENTARY_AND_SECONDARY_SCHOOLS 												(8211, PROFESSIONAL_SERVICES, TRBCIndustry.PERSONAL_SERVICES, TCC_O_SCH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.8211")),																 //$NON-NLS-1$
		MCC_8220_COLLEGES_JUNIOR_COLLEGES_UNIVERSITIES_AND_PROFESSIONAL_SCHOOLS					(8220, PROFESSIONAL_SERVICES, TRBCIndustry.PERSONAL_SERVICES, TCC_O_SCH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.8220")),																 //$NON-NLS-1$
		MCC_8241_CORRESPONDENCE_SCHOOLS 														(8241, PROFESSIONAL_SERVICES, TRBCIndustry.PERSONAL_SERVICES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.8241")),																 //$NON-NLS-1$
		MCC_8244_BUSINESS_AND_SECRETARIAL_SCHOOLS 												(8244, PROFESSIONAL_SERVICES, TRBCIndustry.PROFESSIONAL_INFORMATION_SERVICES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.8244")),																 //$NON-NLS-1$
		MCC_8249_VOCATIONAL_AND_TRADE_SCHOOLS 													(8249, PROFESSIONAL_SERVICES, TRBCIndustry.PROFESSIONAL_INFORMATION_SERVICES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.8249")),																 //$NON-NLS-1$
		MCC_8299_SCHOOLS_AND_EDUCATIONAL_SERVICES_NOT_ELSEWHERE_CLASSIFIED						(8299, PROFESSIONAL_SERVICES, TRBCIndustry.PERSONAL_SERVICES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.8299")),																 //$NON-NLS-1$
		MCC_8351_CHILD_CARE_SERVICES															(8351, PROFESSIONAL_SERVICES, TRBCIndustry.PERSONAL_SERVICES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.8351")),																 //$NON-NLS-1$
		
		MCC_8398_CHARITABLE_AND_SOCIAL_SERVICE_ORGANIZATIONS									(8398, MEMBERSHIP_ORGANIZATIONS, TRBCIndustry.MEMBERSHIP_ORGANIZATIONS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.8398")),																 //$NON-NLS-1$
		MCC_8641_CIVIC_FRATERNAL_AND_SOCIAL_ASSOCIATIONS 										(8641, MEMBERSHIP_ORGANIZATIONS, TRBCIndustry.MEMBERSHIP_ORGANIZATIONS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.8641")),																 //$NON-NLS-1$
		MCC_8651_POLITICAL_ORGANIZATIONS														(8651, MEMBERSHIP_ORGANIZATIONS, TRBCIndustry.MEMBERSHIP_ORGANIZATIONS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.8651")),																 //$NON-NLS-1$
		MCC_8661_RELIGIOUS_ORGANIZATIONS														(8661, MEMBERSHIP_ORGANIZATIONS, TRBCIndustry.MEMBERSHIP_ORGANIZATIONS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.8661")),																 //$NON-NLS-1$
		MCC_8675_AUTOMOBILE_ASSOCIATIONS														(8675, MEMBERSHIP_ORGANIZATIONS, TRBCIndustry.MEMBERSHIP_ORGANIZATIONS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.8675")),																 //$NON-NLS-1$
		MCC_8699_MEMBERSHIP_ORGANIZATIONS_NOT_ELSEWHERE_CLASSIFIED 								(8699, MEMBERSHIP_ORGANIZATIONS, TRBCIndustry.MEMBERSHIP_ORGANIZATIONS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.8699")),																 //$NON-NLS-1$
		
		MCC_8734_TESTING_LABORATORIES_NON_MEDICAL 												(8734, PROFESSIONAL_SERVICES, TRBCIndustry.BUSINESS_SUPPORT_SERVICES, TCC_T_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.8734")),																 //$NON-NLS-1$
		MCC_8911_ARCHITECTURAL_ENGINEERING_AND_SURVEYING_SERVIVES 								(8911, PROFESSIONAL_SERVICES, TRBCIndustry.HOMEBUILDING, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.8911")),																 //$NON-NLS-1$
		MCC_8931_ACCOUNTING_AUDITING_AND_BOOKEEPING_SERVICES 									(8931, PROFESSIONAL_SERVICES, TRBCIndustry.BUSINESS_SUPPORT_SERVICES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.8931")),																 //$NON-NLS-1$
		MCC_8999_PROFESSIONAL_SERVICES_NOT_ELSEWHERE_CLASSIFIED									(8999, PROFESSIONAL_SERVICES, TRBCIndustry.PROFESSIONAL_INFORMATION_SERVICES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.8999")),																 //$NON-NLS-1$
		
		// -------------------
		// Government Services
		// -------------------
		
		MCC_9211_COURT_COSTS_INCLUDING_ALIMONY_AND_CHILD_SUPPORT 								(9211, GOVERNMENT_SERVICES, TRBCIndustry.JUSTICE_PUBLIC_ORDER_AND_SAFETY_ACTIVITIES, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.9211")),																 //$NON-NLS-1$
		MCC_9222_FINES 																			(9222, GOVERNMENT_SERVICES, TRBCIndustry.ADMINISTRATION_OF_ECONOMIC_PROGRAMS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.9222")),																 //$NON-NLS-1$
		MCC_9223_BAIL_AND_BOND_PAYMENTS 														(9223, GOVERNMENT_SERVICES, TRBCIndustry.ADMINISTRATION_OF_ECONOMIC_PROGRAMS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.9223")),																 //$NON-NLS-1$
		MCC_9311_TAX_PAYMENTS 																	(9311, GOVERNMENT_SERVICES, TRBCIndustry.ADMINISTRATION_OF_ECONOMIC_PROGRAMS, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.9311")),																 //$NON-NLS-1$
		MCC_9399_GOVERNMENT_SERVICES_NOT_ELSEWHERE_CLASSIFIED 									(9399, GOVERNMENT_SERVICES, TRBCIndustry.EXECUTIVE_LEGISLATIVE_AND_OTHER_GENERAL_GOVERNMENT_SUPPORT, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.9399")),																 //$NON-NLS-1$
		MCC_9402_POSTAL_SERVICES_STAMPS_GOVERNMENT_ONLY											(9402, GOVERNMENT_SERVICES, TRBCIndustry.EXECUTIVE_LEGISLATIVE_AND_OTHER_GENERAL_GOVERNMENT_SUPPORT, TCC_R_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.9402")),																 //$NON-NLS-1$
		MCC_9405_INTRA_GOVERNEMENT_PURCHASES_US_ONLY											(9405, GOVERNMENT_SERVICES, TRBCIndustry.EXECUTIVE_LEGISLATIVE_AND_OTHER_GENERAL_GOVERNMENT_SUPPORT, TCC_T_OTH, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.9405")),																 //$NON-NLS-1$
		
		// ----------------
		// Schemes Services
		// ----------------
		
		MCC_9700_AUTOMATED_REFERRAL_SERVICES 													(9700, VISA_SERVICES, TRBCIndustry.OTHER, null, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.9700")), // Not recognised by MC																 //$NON-NLS-1$
		MCC_9701_VISA_CREDENTIAL_SERVICE 														(9701, VISA_SERVICES, TRBCIndustry.OTHER, null, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.9701")),	// Not recognised by MC					 //$NON-NLS-1$
		MCC_9702_GCAS_EMERGENCY_SERVICES 														(9702, VISA_SERVICES, TRBCIndustry.OTHER, null, MCG_7_OTH, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.9702")),	// Not recognised by MC									 //$NON-NLS-1$

		MCC_9751_UK_SUPERMARKETS_ELECTRONIC_HOT_FILE 											(9751, MASTERCARD_UK, TRBCIndustry.FOOD_RETAIL_AND_DISTRIBUTION, TCC_R_OTH, null, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.9751")), //$NON-NLS-1$
		MCC_9752_UK_PETROL_STATIONS_ELECTRONIC_HOT_FILE 										(9751, MASTERCARD_UK, TRBCIndustry.OIL_AND_GAS_REFINING_AND_MARKETING, TCC_R_OTH, null, Messages.getString("IMerchantCategoryCodes.Iso18245MerchantCategoryCode.9752")), //$NON-NLS-1$
		
		// ------------
		// T&E Airlines 
		// ------------
		
		// Brands as of July 2015 (source MC)
		
		MCC_3000_UNITED_AILINES						 			(3000, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "UNITED AIRLINES;;##VISA##UNITED AIR;;##MC##UNITED"), //$NON-NLS-1$
		MCC_3001_AMERICAN_AIRLINES 					 			(3001, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "AMERICAN AIRLINES;;##VISA##AMERICAN AIR;;##MC##AMERICAN"), //$NON-NLS-1$
		MCC_3002_PAN_AMERICAN 						 			(3002, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "PAN AMERICAN;;##VISA##PAN AM AIR;;##MC##PAN AM"),				 //$NON-NLS-1$
		MCC_3003_EUROFLY 							 			(3003, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "EUROFLY;;##VISA##EUROFLY AIR;;##MC##EUROFLY"), //$NON-NLS-1$
		MCC_3004_DRAGON_AIRLINES 					 			(3004, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "DRAGON AIRLINES;;##VISA##DRAGONAIR;;##MC##DRAGONAIR"), //$NON-NLS-1$
		MCC_3005_BRITISH_AIRWAYS 					 			(3005, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "BRITISH AIRWAYS;;##VISA##BRITISH AWYS;;##MC##BRITISH A"), //$NON-NLS-1$
		MCC_3006_JAPAN_AIRLINES						 			(3006, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "JAPAN AIRLINES;;##VISA##JAL AIRLINES;;##MC##JAL"), //$NON-NLS-1$
		MCC_3007_AIR_FRANCE 						 			(3007, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "AIR FRANCE;;##VISA##AIR FRANCE;;##MC##AIR FRAN"), //$NON-NLS-1$
		MCC_3008_LUFTHANSA 										(3008, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "LUFTHANSA GERMAM AIRLINES;;##VISA##LUFTHANSA;;##MC##LUFTHAN"),	 //$NON-NLS-1$
		MCC_3009_AIR_CANADA 									(3009, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "AIR CANADA;;##VISA##AIR CANADA;;##MC##AIR CAN"),	 //$NON-NLS-1$
		MCC_3010_KLM 											(3010, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "ROYAL DUTCH AIRLINES (KLM);;##VISA##KLM AIRLINE;;##MC##KLM"), //$NON-NLS-1$
		MCC_3011_AEROFLOT 										(3011, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "AEROFLOT;;##VISA##AEROFLOT;;##MC##AEROFLOT"),	 //$NON-NLS-1$
		MCC_3012_QANTAS 										(3012, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "QUANTAS;;##VISA##QANTAS AIR;;##MC##QANTAS"), //$NON-NLS-1$
		MCC_3013_ALITALIA 										(3013, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "ALITALIA;;##VISA##ALITALIA;;##MC##ALITALIA"), //$NON-NLS-1$
		MCC_3014_SAUDIA_ARABIAN_AIRLINES 						(3014, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "SAUDIA ARABIAN AIRLINES;;##VISA##SAUDI AIR;;##MC##SAUDI AI"), //$NON-NLS-1$
		MCC_3015_SWISSAIR 										(3015, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "SWISS INTERNATIONAL AIRLINES (SWISSAIR);;##VISA##SWISSINTAIR;;##MC##SWISS"), //$NON-NLS-1$
		MCC_3016_SAS 											(3016, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "SCANDINAVIAN AIRLINE SYSTEM (SAS);;##VISA##SAS;;##MC##SAS"), //$NON-NLS-1$
		MCC_3017_SOUTH_AFRICAN_AIRLINES 						(3017, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "SOUTH AFRICAN AIRWAYS;;##VISA##SAA AIRWAYS;;##MC##SAFRICAN"), //$NON-NLS-1$
		MCC_3018_VARIG 											(3018, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "VARIG (BRAZIL);;##VISA##VARIG;;##MC##VARIG"), //$NON-NLS-1$
		MCC_3019_GERMAN_WINGS 									(3019, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "GERMAN WINGS;;##TSYS##GRMNWNGSAIR"),  //$NON-NLS-1$
		MCC_3020_AIR_INDIA 										(3020, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "AIR-INDIA;;##VISA##AIR-INDIA;;##MC##AIR-INDI"),	 //$NON-NLS-1$
		MCC_3021_AIR_ALGERIE 									(3021, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "AIR ALGERIE;;##VISA##AIR ALGERIE;;##MC##AIRALGER"), //$NON-NLS-1$
		MCC_3022_PHILIPPINE_AIRLINES 							(3022, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "PHILIPPINE AIRLINES;;##VISA##PAL AIR;;##MC##PAL AIR"),				 //$NON-NLS-1$
		MCC_3023_MEXICANA 										(3023, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "MEXICANA;;##VISA##MEXICANA;;##MC##MEXICANA"),	 //$NON-NLS-1$
		MCC_3024_PAKISTAN_INTERNATIONAL 						(3024, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "PAKISTAN INTERNATIONAL;;##VISA##PAKISTAN AIR;;##MC##PAKISTAN"),				 //$NON-NLS-1$
		MCC_3025_AIR_NEW_ZEALAND 								(3025, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "AIR NEW ZEALAND;;##VISA##AIR NZ;;##MC##AIR NZ"),			 //$NON-NLS-1$
		MCC_3026_EMIRATES_AIRLINES 								(3026, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "EMIRATES AIRLINES;;##VISA##EMIRATES;;##MC##EMIRATES"),		 //$NON-NLS-1$
		MCC_3027_UTA_INTERAIR 									(3027, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "UNION DE TRANSPORTS AERIENS (UTA/INTERAIR);;##VISA##UTA AIRLINE;;##MC##UTAAIR"),		 //$NON-NLS-1$
		MCC_3028_AIR_MALTA 										(3028, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "AIR MALTA;;##VISA##AIR MALTA;;##MC##AIRMALTA"),	 //$NON-NLS-1$
		MCC_3029_SN_BRUSSELS_AIRLINES 							(3029, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "SN BRUSSELS AIRLINES (SABENA);;##VISA##SNBRSSLSAIR;;##MC##SNBRU AIR"), //$NON-NLS-1$
		MCC_3030_AEROLINAS_ARGENTINAS 							(3030, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "AEROLINEAS ARGENTINAS;;##VISA##AERO ARGENT;;##MC##AERO ARG"),				 //$NON-NLS-1$
		MCC_3031_OLYMPIC_AIRWAYS 								(3031, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "OLYMPIC AIRWAYS;;##VISA##OLYMPIC AIR;;##MC##OLYMPICA"),			 //$NON-NLS-1$
		MCC_3032_EL_AL 											(3032, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "EL AL;;##VISA##EL AL;;##MC##EL AL"), //$NON-NLS-1$
		MCC_3033_ANSETT_AIRLINES								(3033, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "ANSETT AIRLINES;;##VISA##ANSETT AIR;;##MC##ANSETT"),			 //$NON-NLS-1$
		MCC_3034_ETIHADAIR 										(3034, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "ETIHADAIR;;##VISA##ETIHADAIR;;##MC##ETIHADAIR"),				 //$NON-NLS-1$
		MCC_3035_TAP 											(3035, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "TAP (PORTUGAL);;##VISA##TAP AIR;;##MC##TAP"), //$NON-NLS-1$
		MCC_3036_VASP 											(3036, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "VIACAO AEREA SAO PAULO (VASP);;##VISA##VASP AIR;;##MC##VASP"), //$NON-NLS-1$
		MCC_3037_EGYPTAIR 										(3037, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "EGYPTAIR;;##VISA##EGYPTAIR;;##MC##EGYPTAIR"),	 //$NON-NLS-1$
		MCC_3038_KUWAIT_AIRLINES 								(3038, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "KUWAIT AIRLINES;;##VISA##KUWAIT AIR;;##MC##KUWAIT"),			 //$NON-NLS-1$
		MCC_3039_AVIANCA 										(3039, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "AVIANCA;;##VISA##AVIANCA;;##MC##AVIANCA"),	 //$NON-NLS-1$
		MCC_3040_GULF_AIR 										(3040, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "GULF AIR (BAHRAIN);;##VISA##GULF AIR;;##MC##GULF AIR"),	 //$NON-NLS-1$
		MCC_3041_BALKAN_BULGARIAN_AIRLINES						(3041, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "BALKAN-BULGARIAN AIRLINES;;##VISA##BALKAN AIR;;##MC##BALKAN"),					 //$NON-NLS-1$
		MCC_3042_FINNAIR 										(3042, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "FINNAIR;;##VISA##FINNAIR;;##MC##FINNAIR"),	 //$NON-NLS-1$
		MCC_3043_AER_LINGUS 									(3043, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "AER LINGUS;;##VISA##AER LINGUS;;##MC##AERLING"),	 //$NON-NLS-1$
		MCC_3044_AIR_LANKA 										(3044, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "AIR LANKA;;##VISA##AIR LANKA;;##MC##AIR LANKA"),	 //$NON-NLS-1$
		MCC_3045_NIGERIA_AIRWAYS 								(3045, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "NIGERIA AIRWAYS;;##VISA##NIGERIA AIR;;##MC##NIGERIA"),			 //$NON-NLS-1$
		MCC_3046_CRUZEIRO_DO_SUL								(3046, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "CRUZEIRO DO SUL (BRAZIL);;##VISA##CRUSEIRO AIR;;##MC##CRUSEIRO"), // According to Citi Visa & MC CRUSEIRO AND NOT CRUZEIRO //$NON-NLS-1$
		MCC_3047_THY 											(3047, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "THY (TURKEY);;##VISA##THY;;##MC##THY"), //$NON-NLS-1$
		MCC_3048_ROYAL_AIR_MAROC 								(3048, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "ROYAL AIR MAROC;;##VISA##AIR MAROC;;##MC##AIRMARO"),			 //$NON-NLS-1$
		MCC_3049_TUNIS_AIR 										(3049, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "TUNIS AIR;;##VISA##TUNIS AIR;;##MC##TUNIS AI"),	 //$NON-NLS-1$
		MCC_3050_ICELANDAIR										(3050, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "ICELANDAIR;;##VISA##ICELANDAIR;;##MC##ICELANDA"),	 //$NON-NLS-1$
		MCC_3051_AUSTRIAN_AIRLINES 								(3051, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "AUSTRIAN AIRLINES;;##VISA##AUSTRIAN AIR;;##MC##AUSTRIAN"),			 //$NON-NLS-1$
		MCC_3052_LAN_AIRLINES 									(3052, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "LAN AIRLINES (CHILE);;##VISA##LAN AIR;;##MC##LAN AIR"),	 //$NON-NLS-1$
		MCC_3053_AVIACO 										(3053, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "AVIACION Y COMERCIO (AVIAC, SPAIN);;##VISA##AVIACO AIR;;##MC##AVIACO"),		 //$NON-NLS-1$
		MCC_3054_LADECO 										(3054, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "LINEA AEREA DEL COBRE (LADECO, CHILE);;##VISA##LADECO AIR;;##MC##LADECO"), //$NON-NLS-1$
		MCC_3055_LAB 											(3055, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "LAB (BOLIVIA);;##VISA##LAB AIR;;##MC##LAB"), //$NON-NLS-1$
		MCC_3056_JET_AIRWAYS 									(3056, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "JET AIRWAYS;;##VISA##JET AIR;;##MC##JET AIR"),	 //$NON-NLS-1$
		MCC_3057_VIRGIN_AMERICA 								(3057, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "VIRGIN AMERICA;;##VISA##VIR AMER;;##MC##VIR AMER"),			 //$NON-NLS-1$
		MCC_3058_DELTA 											(3058, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "DELTA;;##VISA##DELTA AIR;;##MC##DELTA"), //$NON-NLS-1$
		MCC_3060_NORTHWEST_AIRLINES 							(3060, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "NORTHWEST AIRLINES;;##VISA##NWA AIR;;##MC##NWA AIR"),	 //$NON-NLS-1$
		MCC_3061_CONTINENTAL 									(3061, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "CONTINENTAL;;##VISA##CONTINENTAL;;##MC##CONTINEN"),		 //$NON-NLS-1$
		MCC_3062_HAPAG_LLOYD_EXPRESS 							(3062, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "HAPAG-LLOYD EXPRESS;;##VISA##HLX AIR;;##MC##HLX"),	 //$NON-NLS-1$
		MCC_3063_US_AIRWAYS 									(3063, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "US AIRWAYS;;##VISA##USAIRWAYS;;##MC##USAIRWYS"), //$NON-NLS-1$
		MCC_3064_ADRIA_AIRWAYS 									(3064, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "ADRIA AIRWAYS;;##VISA##ADRIA AIR;;##MC##ADRIA AIR"), //$NON-NLS-1$
		MCC_3065_AIR_INTER 										(3065, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "AIR INTER;;##VISA##AIRINTER;;##MC##AIRINTER"),	 //$NON-NLS-1$
		MCC_3066_SOUTHWEST_AIRLINES 							(3066, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "SOUTHWEST AIRLINES;;##VISA##SOUTHWESTAIR;;##MC##SOUTHWES"),	 //$NON-NLS-1$
		MCC_3067_VANGUARD_AIRLINES 								(3067, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "VANGUARD AIRLINES;;##VISA##VANGUARD AIR;;##MC##VANGUARD"),	 //$NON-NLS-1$
		MCC_3068_AIR_ASTANA 									(3068, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "AIR ASTANA;;##VISA##AIR ASTANA;;##MC##AIRSTANA"),			 //$NON-NLS-1$
		MCC_3069_SUN_COUNTEY_AIRLINES 							(3069, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "SUN COUNTRY AIRLINES;;##VISA##SUNCTRYAIR;;##MC##SUNCNTRY"),				 //$NON-NLS-1$
		MCC_3071_AIR_BRITISH_COLUMBIA 							(3071, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "AIR BRITISH COLUMBIA;;##VISA##AIR BC;;##MC##AIR B R C"),				 //$NON-NLS-1$
		MCC_3072_CEBU_PACIFIC_AIRLINES 							(3072, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "CEBU PACIFIC AIRLINES;;##VISA##CEBU PAC;;##MC##CEBU PAC"),				 //$NON-NLS-1$
		MCC_3075_SINGAPORE_AIRLINES 							(3075, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "SINGAPORE AIRLINES;;##VISA##SINGAPORE AIR;;##MC##SINGAPOR"),			 //$NON-NLS-1$
		MCC_3076_AEROMEXICO 									(3076, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "AEROMEXICO;;##VISA##AEROMEXICO;;##MC##AEROMEXI"),	 //$NON-NLS-1$
		MCC_3077_THAI_AIRWAYS 									(3077, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "THAI AIRWAYS;;##VISA##THAI AIRWAYS;;##MC##THAIAIRW"),		 //$NON-NLS-1$
		MCC_3078_CHINA_AILINES 									(3078, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "CHINA AIRLINES;;##VISA##CHINA AIR;;##MC##CHINAAIR"),		 //$NON-NLS-1$
		MCC_3079_JETSTAR_AIRWAYS 								(3079, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "JETSTAR AIRWAYS;;##VISA##JETSTAR AIR;;##MC##JETSTAR"),		 //$NON-NLS-1$
		MCC_3081_NORDAIR 										(3081, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "NORDAIR;;##TSYS##NORDAIR"), 	 //$NON-NLS-1$
		MCC_3082_KOREAN_AIRLINES 								(3082, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "KOREAN AIRLINES;;##VISA##KOREAN AIR;;##MC##KOREAN"),			 //$NON-NLS-1$
		MCC_3083_AIR_AFRIQUE 									(3083, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "AIR AFRIQUE;;##VISA##AIR AFRIQUE;;##MC##AIR AFRIQ"),		 //$NON-NLS-1$
		MCC_3084_EVA_AIRLINES 									(3084, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "EVA AIRLINES;;##VISA##EVA AIR;;##MC##EVA AIR"),		 //$NON-NLS-1$
		MCC_3085_MIDWEST_EXPRESS_AIRLINES 						(3085, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "MIDWEST EXPRESS AIRLINES, INC.;;##VISA##MIDWEST EXP;;##MC##MIDWEST"),					 //$NON-NLS-1$
		MCC_3086_CARNIVAL_AIRLINES 								(3086, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "CARNIVAL AIRLINES;;##VISA##CARNIVAL AIR"),	 //$NON-NLS-1$
		MCC_3087_METRO_AIRLINES									(3087, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "METRO AIRLINES;;##VISA##METRO AIR;;##MC##METROAI"),		 //$NON-NLS-1$
		MCC_3089_TRANSAERO 										(3089, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "TRANSAERO;;##VISA##TRANSAERO;;##MC##TRANSAERO"),	 //$NON-NLS-1$
		MCC_3090_UNI_AIRWAYS 									(3090, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "UNI AIRWAYS CORPORATION;;##VISA##UNIAIR;;##MC##UNIAIR"),		 //$NON-NLS-1$
		MCC_3094_ZAMBIA_AIRWAYS									(3094, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "ZAMBIA AIRWAYS;;##VISA##ZAMBIA AIR;;##MC##ZAMBIA A"),		 //$NON-NLS-1$
		MCC_3096_AIR_ZIMBABWE 									(3096, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "AIR ZIMBABWE;;##VISA##AIR ZIMBABWE;;##MC##AIRZIMBA"),		 //$NON-NLS-1$
		MCC_3097_SPANAIR 										(3097, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "SPANAIR;;##VISA##SPANAIR;;##MC##SPANAIR"),		 //$NON-NLS-1$
		MCC_3098_ASIANA_AIRLINES 								(3098, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "ASIANA AIRLINES;;##VISA##ASIANA AIR;;##MC##ASIANA"),		 //$NON-NLS-1$
		MCC_3099_CATHAY_PACIFIC 								(3099, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "CATHAY PACIFIC;;##VISA##CATHAYPACAIR;;##MC##CATHAYPA"),		 //$NON-NLS-1$
		MCC_3100_MALAYSIAN_AIRLINE_SYSTEM 						(3100, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "MALAYSIAN AIRLINE SYSTEM;;##VISA##MALAY AIR;;##MC##MALAY AI"),					 //$NON-NLS-1$
		MCC_3102_IBERIA 										(3102, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "IBERIA;;##VISA##IBERIA AIR;;##MC##IBERIA"), //$NON-NLS-1$
		MCC_3103_GARUDA 										(3103, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "GARUDA (INDONESIA);;##VISA##GARUDA AIR;;##MC##GARUDA"), //$NON-NLS-1$
		MCC_3106_BRAATHENS_SAFE 								(3106, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "BRAATHENS S.A.F.E. (NORWAY);;##VISA##BRAATHENS;;##MC##BRAATHEN"),	 //$NON-NLS-1$
		MCC_3110_WINGS_AIRWAYS 									(3110, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "WINGS AIRWAYS;;##VISA##WINGS AIR"), 		 //$NON-NLS-1$
		MCC_3111_BRITISH_MIDLAND 								(3111, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "BRITISH MIDLAND;;##VISA##BRMIDLANDAIR;;##MC##BRITISH M"),			 //$NON-NLS-1$
		MCC_3112_WINDSARD_ISLAND 								(3112, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "WINDWARD ISLAND;;##VISA##WINDWRDISAIR;;##MC##WINWARD"),			 //$NON-NLS-1$
		MCC_3115_TOWER_AIR 										(3115, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "TOWER AIR;;##VISA##TOWERAIR;;##MC##TOWERAIR"), //$NON-NLS-1$
		MCC_3117_VIASA 											(3117, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "VENEZOLANA INTERNATIONAL DE AVIACION (VIASA);;##VISA##VIASA;;##MC##VIASA"), //$NON-NLS-1$
		MCC_3118_VALLEY_AIRLINES 								(3118, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "VALLEY AIRLINES;;##VISA##VALLEY AIR;;##MC##VALLEY AIR"),			 //$NON-NLS-1$
		MCC_3125_TAN_SAHSA 										(3125, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "TAN SAHSA;;##VISA##TAN AIR;;##MC##TAN AIR"), //$NON-NLS-1$
		MCC_3126_TALAIR 										(3126, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "TALAIR PTY LTD;;##VISA##TALAIR"),  //$NON-NLS-1$
		MCC_3127_TACA_INTERNATIONAL 							(3127, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "TACA INTERNATIONAL;;##VISA##TACAINTL;;##MC##TACA INT"),			 //$NON-NLS-1$
		MCC_3129_SURINAM_AIRWAYS 								(3129, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "SURINAM AIRWAYS;;##VISA##SURINAM AIR;;##MC##SURINAM"),			 //$NON-NLS-1$
		MCC_3130_SUN_WORLD_INTERNATIONAL 						(3130, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "SUN WORLD INTERNATIONAL;;##VISA##SUNWORLD AIR;;##MC##SUNWORLD"),					 //$NON-NLS-1$
		MCC_3131_VLM_AIRLINES 									(3131, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "VLM AIRLINES;;##VISA##VLM AIR;;##MC##VLM"),			 //$NON-NLS-1$
		MCC_3131_FRONTIER_AIRLINES 								(3132, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "FRONTIER AIRLINES;;##VISA##FRONTIER AIR;;##MC##FRONTIER"),			 //$NON-NLS-1$
		MCC_3133_SUNBELT_AIRLINES 								(3133, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "SUNBELT AIRLINES;;##VISA##SUNBELT AIR"),  //$NON-NLS-1$
		MCC_3135_SUDAN_AIRWAYS 									(3135, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "SUDAN AIRWAYS;;##VISA##SUDAN AIR"),	  //$NON-NLS-1$
		MCC_3136_QATAR_AIRWAYS 									(3136, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "QATAR AIRWAYS;;##VISA##QATAR AIR;;##MC##QATAR AIR"),	 //$NON-NLS-1$
		MCC_3137_SINGLETON 										(3137, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "SINGLETON;;##VISA##SINGLETONAIR"),	 //$NON-NLS-1$
		MCC_3138_SIMMONS_AIRLINES 								(3138, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "SIMMONS AIRLINES;;##VISA##SIMMONS AIR"),  //$NON-NLS-1$
		MCC_3143_SCENIC_AIRLINES 								(3143, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "SCENIC AIRLINES;;##VISA##SCENIC AIR"),	 //$NON-NLS-1$
		MCC_3144_VIRGIN_ATLANTIC 								(3144, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "VIRGIN ATLANTIC;;##VISA##VIRGINATLAIR;;##MC##VIR ATL"),			 //$NON-NLS-1$
		MCC_3145_SAN_JUAN_AIRLINES 								(3145, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "SAN JUAN AIRLINES;;##VISA##SAN JUAN AIR"),  //$NON-NLS-1$
		MCC_3146_LUXAIR 										(3146, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "LUXAIR;;##VISA##LUXAIR;;##MC##LUXAIR"), //$NON-NLS-1$
		MCC_3148_AIR_LITTORAL 									(3148, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "AIR LITTORAL S.A.;;##VISA##AIRLITTORAL;;##MC##LITTORAL"),	 //$NON-NLS-1$
		MCC_3151_AIR_ZAIRE										(3151, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "AIR ZAIRE;;##VISA##AIR ZAIRE;;##MC##AIRZAIRE"),	 //$NON-NLS-1$
		MCC_3154_PRINCEVILLE 									(3154, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "PRINCEVILLE;;##VISA##PRINCVLLEAIR"),  //$NON-NLS-1$
		MCC_3156_GO_FLY 										(3159, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "GO FLY;;##VISA##GOFLY;;##MC##GOFLY"), //$NON-NLS-1$
		MCC_3159_PROVINCETOWN_BOSTON_AIRWAYS 					(3159, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "PROVINCETOWN BOSTON AIRWAYS (PBA);;##VISA##PBA AIRLINE;;##MC##PBA"), //$NON-NLS-1$
		MCC_3161_ALL_NIPPON_AIRWAYS 							(3161, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "ALL NIPPON AIRWAYS;;##VISA##ANA AIR;;##MC##ANAAIR"),			 //$NON-NLS-1$
		MCC_3164_NORONTAIR 										(3164, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "NORONTAIR;;##VISA##NORONTAIR;;##MC##NORONTAI"),	 //$NON-NLS-1$
		MCC_3165_NEW_YORK_HELICOPTER							(3165, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "NEW YORK HELICOPTER;;##VISA##NY HELI"),  //$NON-NLS-1$
		MCC_3167_AERO_CONTINENTE 								(3167, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "AERO CONTINENTE;;##VISA##AEROCONTINEN;;##MC##AERO CONT"), 				 //$NON-NLS-1$
		MCC_3170_MOUNT_COOK 									(3170, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "MOUNT COOK;;##VISA##MT COOK"),	 //$NON-NLS-1$
		MCC_3171_CANADIAN_AIRLINES_INTERNATIONAL 				(3171, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "CANADIAN AIRLINES INTERNATIONAL;;##VISA##CANADIAN AIR;;##MC##CANADIAN"),							 //$NON-NLS-1$
		MCC_3172_NATIONAIR 										(3172, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "NATIONAIR;;##VISA##NATIONAIR;;##MC##NATIONAI"),	 //$NON-NLS-1$
		MCC_3174_JETBLUE_AIRWAYS 								(3174, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "JETBLUE AIRWAYS;;##VISA##JETBLUE;;##MC##JETBLUE"),				 //$NON-NLS-1$
		MCC_3175_MIDDLE_EAST_AIR 								(3175, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "MIDDLE EAST AIR;;##VISA##MIDEAST AIR;;##MC##MIDEASTA"),				 //$NON-NLS-1$
		MCC_3176_METROFLIGHT_AIRLINES 							(3176, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "METROFLIGHT AIRLINES;;##VISA##METROFLT AIR"),  //$NON-NLS-1$
		MCC_3177_AIRTRAN_AIRWAYS 								(3177, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "AIRTRAN AIRWAYS;;##VISA##AIRTRAN AIR;;##MC##AIRTRAN A"),	 //$NON-NLS-1$
		MCC_3178_MESA_AIR 										(3178, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "MESA AIR;;##VISA##MESA AIR;;##MC##MESA AIR"),	 //$NON-NLS-1$
		MCC_3180_WESTJET_AIRLINES 								(3180, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "WESTJET AIRLINES;;##VISA##WESTJETAIR;;##MC##WESTJET"), //$NON-NLS-1$
		MCC_3181_MALEV 											(3181, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "MALEV;;##VISA##MALEV AIR;;##MC##MALEV"), //$NON-NLS-1$
		MCC_3182_LOT 											(3182, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "LOT (POLISH AIRLINES);;##VISA##LOT AIR;;##MC##LOT"), //$NON-NLS-1$
		MCC_3183_OMAN_AIR 										(3183, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "OMAN AIR;;##VISA##OMANAIR;;##MC##OMAN AIR"), //$NON-NLS-1$
		MCC_3184_LIAT 											(3184, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "LIAT;;##VISA##LIAT AIRLINE;;##MC##LIAT"), //$NON-NLS-1$
		MCC_3185_LAV 											(3185, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "LINEAS AEROPOSTAL VENEZOLANA (LAV);;##VISA##LAV AIR;;##MC##LAV"), //$NON-NLS-1$
		MCC_3186_LAP 											(3186, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "LINEAS AEROAS PARAGUAYAS (LAP);;##VISA##LAP AIR;;##MC##LAP"), //$NON-NLS-1$
		MCC_3187_LACSA 											(3187, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "LACSA (COSTA RICA);;##VISA##LACSA AIR;;##MC##LACSA"), //$NON-NLS-1$
		MCC_3188_VIRGIN_EXPRESS 								(3188, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "VIRGIN EXPRESS;;##VISA##VIRGINEXPAIR;;##MC##VIR EXP"), //$NON-NLS-1$
		MCC_3190_JUGOSLAV_AIR 									(3190, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "JUGOSLAV AIR;;##VISA##JUGOSLAV AIR;;##MC##JUGOSLAV"),		 //$NON-NLS-1$
		MCC_3191_ISLAND_AIRLINES 								(3191, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "ISLAND AIRLINES;;##VISA##ISLAND AIR;;##MC##ISLANDAI"),			 //$NON-NLS-1$
		MCC_3192_IRAN_AIR 										(3192, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "IRAN AIR;;##VISA##IRAN AIR;;##MC##IRAN A"), // Supposition for both Visa & MC	 //$NON-NLS-1$
		MCC_3193_INDIAN_AIRLINES 								(3193, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "INDIAN AIRLINES;;##VISA##INDIAN AIR;;##MC##INDIAN A"),			 //$NON-NLS-1$
		MCC_3196_HAWAIIAN_AIR 									(3196, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "HAWAIIAN AIR;;##VISA##HAWAIIAN AIR;;##MC##HAWAIIAN"),		 //$NON-NLS-1$
		MCC_3197_HAVASU_AIRLINES 								(3197, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "HAVASU AIRLINES;;##VISA##HAVASU AIR;;##MC##HAVASUAI"),			 //$NON-NLS-1$
		MCC_3200_GUYANA_AIRWAYS 								(3200, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "GUYANA AIRWAYS;;##VISA##GUYANA AIR;;##MC##GUYANA A"),		 //$NON-NLS-1$
		MCC_3203_GOLDEN_PACIFIC 								(3203, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "GOLDEN PACIFIC AIR;;##VISA##GOLDPAC AIR"),  //$NON-NLS-1$
		MCC_3204_FREEDOM_AIR 									(3204, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "FREEDOM AIR;;##VISA##FREEDOM AIR;;##MC##FREEDOM"),		 //$NON-NLS-1$
		MCC_3206_CHINA_EASTERN_AIRLINES 						(3206, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "CHINA EASTERN AIRLINES;;##VISA##CHINAEASTAIR;;##MC##CHINAEAST"),		 //$NON-NLS-1$
		MCC_3211_NORWEGIAN_AIR_SHUTTLE 							(3211, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "NORWEGIAN AIR SHUTTLE;;##VISA##NORWEGIANAIR;;##MC##NORWEGIAN"),		 //$NON-NLS-1$
		MCC_3212_DOMINICANA_DE_AVIACION 						(3212, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "DOMINICANA DE AVIACION;;##VISA##DOMINICA AIR;;##MC##DOMINICA"),	 //$NON-NLS-1$
		MCC_3213_MALMO_AVIATION 								(3213, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "MALMO AVIATION;;##VISA##MALMO AIR;;##MC##MALMO AV"),			 //$NON-NLS-1$
		MCC_3215_DAN_AIR_SERVICES 								(3215, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "DAN AIR SERVICES;;##VISA##DANAIRSERV"),  //$NON-NLS-1$
		MCC_3216_CUMBERLAND_AIRLINES 							(3216, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "CUMBERLAND AIRLINES;;##VISA##CUMBERLNDAIR"), //$NON-NLS-1$
		MCC_3217_CSA 											(3217, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "CESKOSLOVENSKE AEROLINIE (CSA);;##VISA##CSA AIRLINE;;##MC##CSA"), //$NON-NLS-1$
		MCC_3218_CROWN_AIR 										(3218, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "CROWN AIR;;##VISA##CROWN AIR"),  //$NON-NLS-1$
		MCC_3219_COPA 											(3219, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "COMPANIA PANAMENA DE AVIACION (COPA);;##VISA##COPA AIR;;##MC##COPA"), //$NON-NLS-1$
		MCC_3220_COMPANIA_FAUCETT 								(3220, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "COMPANIA FAUCETT;;##VISA##COM FAU AIR;;##MC##COMPANIA"),			 //$NON-NLS-1$
		MCC_3221_TAME 											(3221, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "TRANSPORTES AEROS MILITARES ECUATORANOS (TAME);;##VISA##TAME AIRLINE;;##MC##TAME AIR"),									 //$NON-NLS-1$
		MCC_3222_COMMAND_AIRWAYS 								(3222, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "COMMAND AIRWAYS;;##VISA##COMMAND AIR;;##MC##COMMAND"),			 //$NON-NLS-1$
		MCC_3223_COMAIR 										(3223, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "COMAIR;;##VISA##COMAIR;;##MC##COMAIR"), //$NON-NLS-1$
		MCC_3226_SKYWAYS 										(3228, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "SKYWAYS;;##VISA##SKYWAYS AIR;;##MC##SKYWAYS"),		 //$NON-NLS-1$
		MCC_3228_CAYMAN_AIRWAYS									(3228, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "CAYMAN AIRWAYS;;##VISA##CAYMANAIR;;##MC##CAYMANAIR"),		 //$NON-NLS-1$
		MCC_3229_SAETA 											(3229, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "SOCIAEDAD ECUATORIANOS DE TRANSPORTES AEREOS (SAETA);;##VISA##SAETA AIR;;##MC##SAETA"), //$NON-NLS-1$
		MCC_3231_SASHA 											(3231, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "SERVICIO AERO DE HONDURAS (SASHA);;##VISA##SAHSA AIR;;##MC##SAHSA"), //$NON-NLS-1$
		MCC_3233_CAPITOL_AIR 									(3233, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "CAPITOL AIR;;##VISA##CAPITOL AIR"),  //$NON-NLS-1$
		MCC_3234_CARIBBEAN_AIRLINES 							(3234, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "CARIBBEAN AIRLINES;;##VISA##CARIBEEANAIR;;##MC##CARIBBEAN"), //$NON-NLS-1$
		MCC_3235_BROKWAY_AIR 									(3235, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "BROKWAY AIR;;##VISA##BROCKWAY AIR"), //$NON-NLS-1$
		MCC_3236_AIR_ARABIA_AIRLINE 							(3236, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "AIR ARABIA AIRLINE;;##VISA##AIR ARABIA;;##MC##AIR ARAB"),  //$NON-NLS-1$
		MCC_3238_BEMIDJI_AVIATION 								(3238, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "BEMIDJI AVIATION;;##VISA##BEMIDJI AIR"),  //$NON-NLS-1$
		MCC_3239_BAR_HARBOR_AIRLINES 							(3239, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "BAR HARBOR AIRLINES;;##VISA##BARHARBORAIR;;##MC##BARHARBO"),				 //$NON-NLS-1$
		MCC_3240_BAHAMASAIR 									(3240, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "BAHAMASAIR;;##VISA##BAHAMASAIR;;##MC##BAHAMASA"),	 //$NON-NLS-1$
		MCC_3241_AVIATECA 										(3241, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "AVIATECA (GUATEMALA);;##VISA##AVIATECA AIR;;##MC##AVIATECA"),	 //$NON-NLS-1$
		MCC_3242_AVENSA 										(3242, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "AVENSA;;##VISA##AVESA AIR;;##MC##AVENSA"), //$NON-NLS-1$
		MCC_3243_AUSTRIAN_AIR_SERVICE 							(3243, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "AUSTRIAN AIR SERVICE;;##VISA##AUST AIRSERV;;##MC##AUSTRAIR"),				 //$NON-NLS-1$
		MCC_3245_EASYJET_AIR 									(3245, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "EASYJET AIR;;##VISA##EASYJET AIR;;##MC##EASYJET"),				 //$NON-NLS-1$
		MCC_3246_RYANAIR 										(3246, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "RYANAIR;;##VISA##RYANAIR;;##MC##RYANAIR"),				 //$NON-NLS-1$
		MCC_3247_GOL_AIRLINES 									(3247, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "GOL AIRLINES;;##VISA##GOL AIR;;##MC##GOL"),				 //$NON-NLS-1$
		MCC_3248_TAM_AIRLINES 									(3248, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "TAM AIRLINES;;##VISA##TAM AIR;;##MC##TAM"),				 //$NON-NLS-1$
		MCC_3251_ALOHA_AIRLINES 								(3251, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "ALOHA AIRLINES;;##VISA##ALOHA AIR"),  //$NON-NLS-1$
		MCC_3252_ALM 											(3252, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "ANTILEAN AIRLINES (ALM);;##VISA##ALM AIRLINE;;##MC##ALM"), //$NON-NLS-1$
		MCC_3253_AMERICA_WEST 									(3253, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "AMERICA WEST;;##MC##AMERWEST"),	 //$NON-NLS-1$
		MCC_3254_US_AIR_SHUTTLE 								(3254, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "US AIR SHUTTLE;;##VISA##USAIRSHUTL"),  //$NON-NLS-1$
		MCC_3256_ALASKA_AIRLINES 								(3256, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "ALASKA AIRLINES;;##VISA##ALASKA AIR;;##MC##ALASKA"),			 //$NON-NLS-1$
		MCC_3259_AMERICAN_TRANS_AIR 							(3259, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "AMERICAN TRANS AIR;;##VISA##ATA AIR"), //$NON-NLS-1$
		MCC_3261_AIR_CHINA 										(3261, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "AIR CHINA;;##VISA##AIR CHINA;;##MC##AIR CHINA"),	 //$NON-NLS-1$
		MCC_3262_RENO_AIR 										(3262, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "RENO AIR, INC.;;##VISA##RENO AIR"),  //$NON-NLS-1$
		MCC_3263_AERO_SERVICIO_CARABOBO 						(3263, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "AERO SERVICIO CARABOBO (ASC);;##VISA##ASC AIRLINE;;##MC##ASERCA"),		 //$NON-NLS-1$
		MCC_3266_AIR_SEYCHELLES 								(3266, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "AIR SEYCHELLES;;##VISA##AIR SEYCH;;##MC##AIR SEYC"),		 //$NON-NLS-1$
		MCC_3267_AIR_PANAMA 									(3267, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "AIR PANAMA;;##VISA##AIR PANAMA;;##MC##AIR PANA"),	 //$NON-NLS-1$
		MCC_3273_RICA_HOTELS 									(3273, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "RICA HOTELS;;##TSYS##RICA HOTELS"), // TSYS only		 //$NON-NLS-1$
		MCC_3274_INTER_NOR_HOTELS 								(3274, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "INTER NOR HOTELS;;##TSYS##INTER NOR HOTELS"), // TSYS only //$NON-NLS-1$
		MCC_3280_AIR_JAMAICA 									(3280, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "AIR JAMAICA;;##VISA##AIR JAMAICA;;##MC##AIR JAMA"),		 //$NON-NLS-1$
		MCC_3281_AIR_DJIBOUTI_TSYS 								(3282, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "AIR DJIBOUTI (TSYS);;##TSYS##AIR DJIBOUTI"), // TSYS only //$NON-NLS-1$
		MCC_3282_AIR_DJIBOUTI 									(3282, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "AIR DJIBOUTI;;##VISA##AIR DJIBOUTI;;##MC##AIR DJIB"),  //$NON-NLS-1$
		MCC_3284_AERO_VIRGIN_ISLANDS 							(3284, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "AERO VIRGIN ISLANDS;;##VISA##AEROVIRGINIS"),  //$NON-NLS-1$
		MCC_3285_AERO_PERU 										(3285, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "AERO PERU;;##VISA##AEROPERU;;##MC##AEROPERU"),	 //$NON-NLS-1$
		MCC_3286_AEROLINAS_NICARAGUENSIS 						(3286, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "AEROLINEAS NICARAGUENSIS;;##VISA##AERONICARAG;;##MC##AERO NIC"),					 //$NON-NLS-1$
		MCC_3287_AERO_COACH_AVIATION 							(3287, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "AERO COACH AVIATION;;##VISA##AEROCOACH AV;;##MC##AEROCOAC"),				 //$NON-NLS-1$
		MCC_3292_CYPRUS_AIRWAYS 								(3292, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "CYPRUS AIRWAYS;;##VISA##CYPRUS AIR;;##MC##CYPRUSA"),		 //$NON-NLS-1$
		MCC_3293_ECUATORIANA 									(3293, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "ECUATORIANA;;##VISA##ECUATORIANA;;##MC##ECUATORI"),		 //$NON-NLS-1$
		MCC_3294_ETHIOPIAN_AIRLINES 							(3294, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "ETHIOPIAN AIRLINES;;##VISA##ETHIOPIAN AIR;;##MC##ETHIOPIA"),			 //$NON-NLS-1$
		MCC_3295_KENYA_AIRLINES 								(3295, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "KENYA AIRLINES;;##VISA##KENYA AIR;;##MC##KENYA"),		 //$NON-NLS-1$
		MCC_3296_AIR_BERLIN 									(3296, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "AIR BERLIN;;##VISA##AIR BERLIN;;##MC##AIRBERLIN"),		 //$NON-NLS-1$
		MCC_3297_TAROM 											(3297, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "ROMANIAN AIR TRANSPORT (TAROM);;##VISA##TAROM AIR;;##MC##TAROM AIR"),		 //$NON-NLS-1$
		MCC_3298_AIR_MAURITIUS 									(3298, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "AIR MAURITIUS;;##VISA##AIRMAURITIUS;;##MC##AIRMAURI"),		 //$NON-NLS-1$
		MCC_3299_WIDEROES_FLYVESELSKAP 							(3299, AIRLINES, TRBCIndustry.AIRLINES, TCC_X_AIR, MCG_1_TRA, "WIDEROES FLYVESELSKAP;;##VISA##WIDEROES;;##MC##WIDEROES"),				 //$NON-NLS-1$

		// --------------
		// T&E Car Rental
		// --------------
		
		// Brands as of July 2015 (source MC )
		
		MCC_3351_AFFILIATED_AUTO_RENTAL  						(3351, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "AFFILIATED AUTO RENTAL"),							 //$NON-NLS-1$
		MCC_3352_AMERICAN_INTERNATIONAL_RENT_A_CAR				(3352, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "AMERICAN INTERNATIONAL RENT-A-CAR"),							 //$NON-NLS-1$
		MCC_3353_BROOKS_RENT_A_CAR  							(3353, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "BROOKS RENT-A-CAR"),							 //$NON-NLS-1$
		MCC_3354_ACTION_AUTO_RENTAL  							(3354, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "ACTION AUTO RENTAL"),							 //$NON-NLS-1$
		MCC_3355_SIXT_CAR_RENTAL 		 						(3354, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "SIXT CAR RENTAL"),							 //$NON-NLS-1$
		MCC_3357_HERTZ  			 							(3357, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "HERTZ RENT-A-CAR"),							 //$NON-NLS-1$
		MCC_3359_PAYLESS_CAR_RENTAL  							(3359, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "PAYLESS CAR RENTAL"),							 //$NON-NLS-1$
		MCC_3360_SNAPPY_CAR_RENTAL  							(3360, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "SNAPPY CAR RENTAL"),							 //$NON-NLS-1$
		MCC_3361_AIRWAYS  			 							(3361, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "AIRWAYS RENT-A-CAR"),							 //$NON-NLS-1$
		MCC_3362_ALTRA_AUTO_RENTAL  							(3362, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "ALTRA AUTO RENTAL"),							 //$NON-NLS-1$
		MCC_3364_AGENCY_RENT_A_CAR  							(3364, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "AGENCY RENT-A-CAR"),							 //$NON-NLS-1$
		MCC_3366_BUDGET_RENT_A_CAR  							(3366, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "BUDGET RENT-A-CAR"),							 //$NON-NLS-1$
		MCC_3368_HOLIDAY_RENT_A_WRECK  							(3368, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "HOLIDAY RENT-A-WRECK"),							 //$NON-NLS-1$
		MCC_3370_RENT_A_WRECK  									(3370, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "RENT-A-WRECK"),							 //$NON-NLS-1$
		MCC_3374_ACCENT_RENT_A_CAR  							(3374, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "ACCENT RENT-A-CAR"),							 //$NON-NLS-1$
		MCC_3376_AJAX_RENT_A_CAR  								(3376, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "AJAX RENT-A-CAR"),							 //$NON-NLS-1$
		MCC_3380_TRIANGLE_RENT_A_CAR  							(3380, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "TRIANGLE RENT-A-CAR"),							 //$NON-NLS-1$
		MCC_3381_EUROPCAR  			 							(3381, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "EUROPCAR"),							 //$NON-NLS-1$
		MCC_3385_TROPICAL_RENT_A_CAR  							(3385, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "TROPICAL RENT-A-CAR"),							 //$NON-NLS-1$
		MCC_3386_SHOWCASE_RENTAL_CARS  							(3386, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "SHOWCASE RENTAL CARS"),							 //$NON-NLS-1$
		MCC_3387_ALAMO_RENT_A_CAR  								(3387, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "ALAMO RENT-A-CAR"),							 //$NON-NLS-1$
		MCC_3388_MERCHANTS_RENT_A_CAR 							(3387, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "MERCHANTS RENT-A-CAR"),							 //$NON-NLS-1$
		MCC_3389_AVIS_RENT_A_CAR  								(3389, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "AVIS RENT-A-CAR"),							 //$NON-NLS-1$
		MCC_3390_DOLLAR_RENT_A_CAR  							(3390, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "DOLLAR RENT-A-CAR"),							 //$NON-NLS-1$
		MCC_3391_EUROPE_BY_CAR  								(3391, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "EUROPE BY CAR"),							 //$NON-NLS-1$
		MCC_3393_NATIONAL_CAR_RENTAL  							(3393, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "NATIONAL CAR RENTAL"),							 //$NON-NLS-1$
		MCC_3394_KEMWELL_GROUP_RENT_A_CAR 						(3394, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "KEMWELL GROUP RENT-A-CAR"),							 //$NON-NLS-1$
		MCC_3395_THRIFTY_RENT_A_CAR  							(3395, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "THRIFTY RENT-A-CAR"),							 //$NON-NLS-1$
		MCC_3396_TILDEN_RENT_A_CAR  							(3396, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "TILDEN RENT-A-CAR"),							 //$NON-NLS-1$
		MCC_3398_ECONO_CAR_RENT_A_CAR  							(3398, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "ECONO-CAR RENT-A-CAR"),							 //$NON-NLS-1$
		MCC_3400_AUTO_HOST_COST_CAR_RENTALS 					(3400, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "AUTO HOST COST CAR RENTALS"),							 //$NON-NLS-1$
		MCC_3405_ENTERPRISE_RENT_A_CAR  						(3405, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "ENTERPRISE RENT-A-CAR"),							 //$NON-NLS-1$
		MCC_3409_GENERAL_RENT_A_CAR  							(3409, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "GENERAL RENT-A-CAR"),							 //$NON-NLS-1$
		MCC_3412_A_1_RENT_A_CAR  								(3412, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "A-1 RENT-A-CAR"),							 //$NON-NLS-1$
		MCC_3414_GODFREY_NATIONAL_RENT_A_CAR	 				(3414, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "GODFREY NATIONAL RENT-A-CAR"),							 //$NON-NLS-1$
		MCC_3420_ANSA_INTERNATIONAL_RENT_A_CAR 					(3420, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "ANSA INTERNATIONAL RENT-A-CAR"),							 //$NON-NLS-1$
		MCC_3421_ALLSTATE_RENT_A_CAR 	 						(3421, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "ALLSTATE RENT-A-CAR"),							 //$NON-NLS-1$
		MCC_3423_AVCAR_RENT_A_CAR  								(3423, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "AVCAR RENT-A-CAR"),							 //$NON-NLS-1$
		MCC_3425_AUTOMATE_RENT_A_CAR  							(3425, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "AUTOMATE RENT-A-CAR"),							 //$NON-NLS-1$
		MCC_3427_AVON_RENT_A_CAR  								(3427, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "AVON RENT-A-CAR"),							 //$NON-NLS-1$
		MCC_3428_CAREY_RENT_A_CAR  								(3428, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "CAREY RENT-A-CAR"),							 //$NON-NLS-1$
		MCC_3429_INSURANCE_RENT_A_CAR  							(3429, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "INSURANCE RENT-A-CAR"),							 //$NON-NLS-1$
		MCC_3430_MAJOR_RENT_A_CAR 								(3430, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "MAJOR RENT-A-CAR"),							 //$NON-NLS-1$
		MCC_3431_REPLACEMENT_RENT_A_CAR 						(3431, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "REPLACEMENT RENT-A-CAR"),							 //$NON-NLS-1$
		MCC_3432_RESERVE_RENT_A_CAR 							(3432, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "RESERVE RENT-A-CAR"),							 //$NON-NLS-1$
		MCC_3433_UGLY_DUCKLING_RENT_A_CAR 						(3433, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "UGLY DUCKLING RENT-A-CAR"),							 //$NON-NLS-1$
		MCC_3434_USA_RENT_A_CAR 								(3434, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "USA RENT-A-CAR"),							 //$NON-NLS-1$
		MCC_3435_VALUE_RENT_A_CAR 								(3435, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "VALUE RENT-A-CAR"),							 //$NON-NLS-1$
		MCC_3436_AUTOHANSA_RENT_A_CAR 							(3436, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "AUTOHANSA RENT-A-CAR"),							 //$NON-NLS-1$
		MCC_3437_CITE_RENT_A_CAR 								(3437, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "CITE RENT-A-CAR"),							 //$NON-NLS-1$
		MCC_3438_INTERENT_RENT_A_CAR							(3438, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "INTERENT RENT-A-CAR"),							 //$NON-NLS-1$
		MCC_3439_MILLEVILLE_RENT_A_CAR 							(3439, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "MILLEVILLE RENT-A-CAR"),							 //$NON-NLS-1$
		MCC_3441_AVANTAGE_RENT_A_CAR							(3441, AUTOMOBILE_VEHICLE_RENTAL, TRBCIndustry.PASSENGER_TRANSPORTATION_GROUND_AND_SEA, TCC_A_CAR, MCG_3_AUT, "AVANTAGE RENT-A-CAR"),							 //$NON-NLS-1$
		

		// -----------
		// T&E Lodging
		// -----------
		
		// Brands as of July 2015 (source MC)
		
		MCC_3501_HOLIDAY_INNS  									(3501, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "HOLIDAY INNS, HOLIDAY INN EXPRESS"),			 //$NON-NLS-1$
		MCC_3502_BEST_WESTERN  									(3502, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "BEST WESTERN HOTELS"),			 //$NON-NLS-1$
		MCC_3503_SHERATON  										(3503, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "SHERATON HOTELS"),			 //$NON-NLS-1$
		MCC_3504_HILTON  										(3504, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "HILTON HOTELS"),			 //$NON-NLS-1$
		MCC_3505_TRUSTHOUSE_FORTE  								(3505, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "TRUSTHOUSE FORTE, FORTE HOTELS"),			 //$NON-NLS-1$
		MCC_3506_GOLDEN_TULIP  									(3506, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "GOLDEN TULIP HOTELS"),			 //$NON-NLS-1$
		MCC_3507_FRIENDSHIP_INNS_INTERNATIONAL					(3507, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "FRIENDSHIP INNS INTERNATIONAL"),			 //$NON-NLS-1$
		MCC_3508_QUALITY_INTERNATIONAL  						(3508, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "QUALITY INTERNATIONAL, QUALITY INNS, QUALITY SUITES"),			 //$NON-NLS-1$
		MCC_3509_MARRIOTT  										(3509, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "MARRIOTT HOTELS"),			 //$NON-NLS-1$
		MCC_3510_DAYS_INNS_OF_AMERICA  							(3510, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "DAYS INNS OF AMERICA, DAYSTOP"),			 //$NON-NLS-1$
		MCC_3511_ARABELLA_HOTELS  								(3511, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "ARABELLA HOTELS"),			 //$NON-NLS-1$
		MCC_3512_INTER_CONTINENTAL  							(3512, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "INTER-CONTINENTAL HOTELS"),			 //$NON-NLS-1$
		MCC_3513_WESTIN_HOTELS  								(3513, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "WESTIN HOTELS"), //$NON-NLS-1$
		MCC_3514_AMERISUITES  									(3514, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "AMERISUITES"), //$NON-NLS-1$
		MCC_3515_RODEWAY_INNS_INTERNATIONAL  					(3515, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "RODEWAY INNS INTERNATIONAL"),			 //$NON-NLS-1$
		MCC_3516_LA_QUINTA_MOTOR_INNS  							(3516, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "LA QUINTA MOTOR INNS"),			 //$NON-NLS-1$
		MCC_3517_AMERICANA_HOTELS_CORPORATION  					(3517, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "AMERICANA HOTELS CORPORATION"),			 //$NON-NLS-1$
		MCC_3518_SOL_HOTELS  									(3518, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "SOL HOTELS"),			 //$NON-NLS-1$
		MCC_3519_PLM_ETAP_INTERNATIONAL  						(3519, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "PULLMAN (PLM)/ETAP INTERNATIONAL HOTELS"),			 //$NON-NLS-1$
		MCC_3520_MERIDIEN  										(3520, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "MERIDIEN HOTELS"),			 //$NON-NLS-1$
		MCC_3521_CREST_HOTELS  									(3521, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "CREST HOTELS"),			 //$NON-NLS-1$
		MCC_3522_TOKYO_GROUP_HOTELS  							(3522, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "TOKYO GROUP HOTELS"),			 //$NON-NLS-1$
		MCC_3523_PENINSULA_HOTELS  								(3523, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "PENNSULA HOTELS"),			 //$NON-NLS-1$
		MCC_3524_WELCOMGROUP  									(3524, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "WELCOMGROUP HOTELS"),			 //$NON-NLS-1$
		MCC_3525_DUNFEY_HOTELS  								(3525, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "DUNFEY HOTELS"),			 //$NON-NLS-1$
		MCC_3526_PRINCE_HOTELS  								(3527, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "PRINCE HOTELS"),			 //$NON-NLS-1$
		MCC_3527_DOWNTOWNER_PASSPORT  							(3527, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "DOWNTOWNER-PASSPORT HOTELS"),			 //$NON-NLS-1$
		MCC_3528_THUNDERBIRD_RED_LIONS  						(3528, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "THUNDERBIRD / RED LION HOTELS, RED LION INNS"),			 //$NON-NLS-1$
		MCC_3529_CANADIAN_PACIFIC  								(3529, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "CANADIAN PACIFIC (CP) HOTELS"),			 //$NON-NLS-1$
		MCC_3530_RENAISSANCE_HOTELS  							(3530, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "RENAISSANCE HOTELS, STOUFFER HOTELS"),			 //$NON-NLS-1$
		MCC_3531_KAUAI_COCONUT_BEACH_RESORT  					(3531, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "KAUAI COCONUT BEACH RESORT"),			 //$NON-NLS-1$
		MCC_3532_ROYAL_KONA_RESORT  							(3532, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "ROYAL KONA RESORT"),			 //$NON-NLS-1$
		MCC_3533_PARK_INN_BY_RADISSON  							(3533, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "PARK INN BY RADISSON"),			 //$NON-NLS-1$
		MCC_3534_SOUTERN_PACIFIC_HOTELS  						(3534, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "SOUTHERN PACIFIC HOTELS"),			 //$NON-NLS-1$
		MCC_3535_HILTON_INTERNATIONAL  							(3535, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "HILTON INTERNATIONAL"),			 //$NON-NLS-1$
		MCC_3536_AMFAC_HOTELS  									(3536, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "AMFAC HOTELS"),			 //$NON-NLS-1$
		MCC_3537_ANA_HOTELS  									(3537, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "ANA HOTEL"),			 //$NON-NLS-1$
		MCC_3538_CONCORDE_HOTELS  								(3538, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "CONCORDE HOTELS"),	 //$NON-NLS-1$
		MCC_3539_SUMMERFIELD_SUITE_HOTELS  						(3539, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "SUMMERFIELD SUITE HOTELS"), //$NON-NLS-1$
		MCC_3540_IBEROTEL  										(3540, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "IBEROTEL HOTELS"),			 //$NON-NLS-1$
		MCC_3541_HOTEL_OKURA  									(3541, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "HOTEL OKURA"),			 //$NON-NLS-1$
		MCC_3542_ROYAL_HOTELS  									(3542, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "ROYAL HOTELS"),			 //$NON-NLS-1$
		MCC_3543_FOUR_SEASONS  									(3543, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "FOUR SEASONS HOTELS"),			 //$NON-NLS-1$
		MCC_3544_CIGA_HOTELS  									(3544, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "CIGA HOTELS"),			 //$NON-NLS-1$
		MCC_3545_SHANGRI_LA_INTERNATIONAL  						(3545, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "SHANGRI-LA INTERNATIONAL"), //$NON-NLS-1$
		MCC_3546_HOTEL_SIERRA  									(3546, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "HOTEL SIERRA"), //$NON-NLS-1$
		MCC_3547_BREAKERS_RESORT  								(3547, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "BREAKERS RESORT"), //$NON-NLS-1$
		MCC_3548_HOTELS_MELIA  									(3548, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "HOTELS MELIA"),			 //$NON-NLS-1$
		MCC_3549_AUBERGE_DES_GOVERNEURS  						(3549, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "AUBERGE DES GOVERNEURS"),			 //$NON-NLS-1$
		MCC_3550_REGAL_8_INNS  									(3550, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "REGAL 8 INNS"), //$NON-NLS-1$
		MCC_3551_MIRAGE_HOTEL_AND_CASINO  						(3551, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "MIRAGE HOTEL AND CASINO"), //$NON-NLS-1$
		MCC_3552_COAST_HOTELS  									(3552, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "COAST HOTELS"),			 //$NON-NLS-1$
		MCC_3553_PARK_INNS_INTERNATIONAL  						(3553, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "PARK INNS INTERNATIONAL"),	 //$NON-NLS-1$
		MCC_3554_PINEHURST_RESORT  								(3554, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "PINEHURST RESORT"),	 //$NON-NLS-1$
		MCC_3555_TREASURE_ISLAND_HOTEL_AND_CASINO 				(3555, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "TREASURE ISLAND HOTEL AND CASINO"),	 //$NON-NLS-1$
		MCC_3556_BARTON_CREEK_RESORT  							(3556, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "BARTON CREEK RESORT"),	 //$NON-NLS-1$
		MCC_3557_MANHATTAN_EAST_SUITE_HOTELS 					(3557, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "MANHATTAN EAST SUITE HOTELS"),	 //$NON-NLS-1$
		MCC_3558_JOLLY_HOTELS  									(3558, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "JOLLY HOTELS"),		 //$NON-NLS-1$
		MCC_3559_CANDLEWOOD_SUITES  							(3559, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "CANDLEWOOD SUITES"),		 //$NON-NLS-1$
		MCC_3560_ALADDIN_RESORT_AND_CASINO  					(3560, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "ALADDIN RESORT AND CASINO"),		 //$NON-NLS-1$
		MCC_3561_GOLDEN_NUGGET  								(3561, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "GOLDEN NUGGET"),		 //$NON-NLS-1$
		MCC_3562_COMFORT_INNS_INTERNATIONAL  					(3562, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "COMFORT INNS INTERNATIONAL"),			 //$NON-NLS-1$
		MCC_3563_JOURNEYS_END_MOTELS  							(3563, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "JOURNEYS END MOTELS"),			 //$NON-NLS-1$
		MCC_3564_SAMS_TOWN_HOTEL_AND_CASINO  					(3564, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "SAMS TOWN HOTEL AND CASINO"),			 //$NON-NLS-1$
		MCC_3565_RELAX_INNS  									(3565, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "RELAX INNS"),			 //$NON-NLS-1$
		MCC_3566_GARDEN_PLACE_HOTEL  							(3566, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "GARDEN PLACE HOTEL"),			 //$NON-NLS-1$
		MCC_3567_SOHO_GRAND_HOTEM  								(3567, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "SOHO GRAND HOTEL"),			 //$NON-NLS-1$
		MCC_3568_LADBROKE_HOTELS  								(3568, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "LADBROKE HOTELS"), //$NON-NLS-1$
		MCC_3569_TRIBECA_GRAND_HOTEL  							(3569, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "TRIBECA GRAND HOTEL"), //$NON-NLS-1$
		MCC_3570_GRAND_MET_FORUM_HOTELS  						(3570, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "GRAND MET FORUM HOTELS"),	 //$NON-NLS-1$
		MCC_3571_GRAND_WAILEA_RESORT  							(3571, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "GRAND WAILEA RESORT"),	 //$NON-NLS-1$
		MCC_3572_MIKAYO_HOTEL_KINTETSU  						(3572, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "MIYAKO HOTEL / KINTETSU"),			 //$NON-NLS-1$
		MCC_3573_SANDMAN_HOTELS  								(3573, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "SANDMAN HOTELS"),			 //$NON-NLS-1$
		MCC_3574_VENTURE_INNS  									(3574, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "VENTURE INNS"),			 //$NON-NLS-1$
		MCC_3575_VAGABOND_HOTELS  								(3575, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "VAGABOND HOTELS"), //$NON-NLS-1$
		MCC_3576_LA_QUINTA_RESORT  								(3576, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "LA QUINTA RESORT"), //$NON-NLS-1$
		MCC_3577_MANDARIN_INTERNATIONAL  						(3577, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "MANDARIN ORIENTAL HOTEL"), //$NON-NLS-1$
		MCC_3578_FRANKENMUTH_BAVARIAN  							(3578, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "FRANKENMUTH BAVARIAN"), //$NON-NLS-1$
		MCC_3579_HOTEL_MERCURE  								(3579, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "HOTEL MERCURE"), //$NON-NLS-1$
		MCC_3580_HOTEL_DEL_CORONADO  							(3580, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "HOTEL DEL CORONADO"), //$NON-NLS-1$
		MCC_3581_DELTA_HOTELS  									(3581, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "DELTA HOTEL"), //$NON-NLS-1$
		MCC_3582_CALIFORNIA_HOTEL_AND_CASINO  					(3582, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "CALIFORNIA HOTEL AND CASINO"), //$NON-NLS-1$
		MCC_3583_RADISSON_BLU  									(3583, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "RADISSON BLU"),			 //$NON-NLS-1$
		MCC_3584_PRINCESS_HOTELS_INTERNATIONAL  				(3584, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "PRINCESS HOTELS INTERNATIONAL"),			 //$NON-NLS-1$
		MCC_3585_HUNGAR_HOTELS  								(3585, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "HUNGAR HOTELS"),			 //$NON-NLS-1$
		MCC_3586_SOKOS_HOTELS  									(3586, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "SOKOS HOTELS"),			 //$NON-NLS-1$
		MCC_3587_DORAL_HOTELS  									(3587, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "DORAL HOTELS"),			 //$NON-NLS-1$
		MCC_3588_HELMSLEY_HOTELS  								(3588, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "HELMSLEY HOTELS"),			 //$NON-NLS-1$
		MCC_3589_DORAL_GULF_RESORT  							(3589, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "DORAL GULF RESORT"),			 //$NON-NLS-1$
		MCC_3590_FAIRMONT_HOTELS_CORPORATION  					(3590, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "FAIRMONT HOTELS CORPORATION"),			 //$NON-NLS-1$
		MCC_3591_SONESTA_HOTELS_INTERNATIONAL  					(3591, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "SONESTA HOTELS INTERNATIONAL"),			 //$NON-NLS-1$
		MCC_3592_OMNI_INTERNATIONAL  							(3592, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "OMNI HOTELS"),			 //$NON-NLS-1$
		MCC_3593_CUNARD_HOTELS  								(3593, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "CUNARD HOTELS"), //$NON-NLS-1$
		MCC_3594_ARIZONA_BILTMORE  								(3594, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "ARIZONA BILTMORE"), //$NON-NLS-1$
		MCC_3595_HOSPITALITY_INNS  								(3595, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "HOSPITALITY INNS INTERNATIONAL"),			 //$NON-NLS-1$
		MCC_3596_WYNN_LAS_VEGAS  								(3596, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "WYNN LAS VEGAS"),			 //$NON-NLS-1$
		MCC_3597_RIVERSIDE_RESORT_AND_CASINO  					(3597, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "RIVERSIDE RESORT AND CASINO"),			 //$NON-NLS-1$
		MCC_3598_REGENT_HOTELS  								(3598, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "REGENT HOTELS INTERNATIONAL"),			 //$NON-NLS-1$
		MCC_3599_PANNONIA_HOTELS  								(3599, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "PANNONIA HOTELS"),			 //$NON-NLS-1$
		MCC_3600_SADDLEBROOK_RESORT_TAMPA  						(3600, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "SADDLEBROOK RESORT-TAMPA"),			 //$NON-NLS-1$
		MCC_3601_TRADEWINDS_RESORT  							(3601, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "TRADEWINDS RESORT"),			 //$NON-NLS-1$
		MCC_3602_HUDSON_HOTELS  								(3602, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "HUDSON HOTELS"),			 //$NON-NLS-1$
		MCC_3603_NOAH_S_HOTEL_MELBOURNE  						(3603, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "NOAH'S HOTEL (MELBOURNE)"),	 //$NON-NLS-1$
		MCC_3604_HILTON_GARDEN_INN  							(3604, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "HILTON GARDEN INN"),	 //$NON-NLS-1$
		MCC_3605_JURYS_DOYLE_HOTEL_GROUP  						(3605, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "JURYS DOYLE HOTEL GROUP"),	 //$NON-NLS-1$
		MCC_3606_JEFFERSON_HOTEM  								(3606, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "JEFFERSON HOTEL"),	 //$NON-NLS-1$
		MCC_3607_FONTAINEBLEAU_RESORT 							(3607, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "FONTAINEBLEAU RESORT"),	 //$NON-NLS-1$
		MCC_3608_GAYLORD_OPRYLAND  								(3608, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "GAYLORD OPRYLAND"),	 //$NON-NLS-1$
		MCC_3609_GAYLORD_PALMS  								(3609, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "GAYLORD PALMS"),	 //$NON-NLS-1$
		MCC_3610_GAYLORD_TEXAN  								(3610, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "GAYLORD TEXAN"),	 //$NON-NLS-1$
		MCC_3611_C_MON_INN  									(3611, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "C MON INN"),	 //$NON-NLS-1$
		MCC_3612_MOEVENPICK_HOTELS  							(3612, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "MOEVENPICK HOTELS"),			 //$NON-NLS-1$
		MCC_3613_MICROTEL_INN_AND_SUITES  						(3613, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "MICROTEL INN AND SUITES"),			 //$NON-NLS-1$
		MCC_3614_AMERICINN  									(3614, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "AMERICINN"),			 //$NON-NLS-1$
		MCC_3615_TRAVELODGE_MOTELS  							(3615, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "TRAVELODGE MOTELS"),			 //$NON-NLS-1$
		MCC_3616_HERMITAGE_HOTELS  								(3616, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "HERMITAGE HOTELS"),			 //$NON-NLS-1$
		MCC_3617_AMERICA_S_BEST_VALUE_INN  						(3617, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "AMERICA'S BEST VALUE INN"),			 //$NON-NLS-1$
		MCC_3618_GREAT_WOLF  									(3618, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "GREAT WOLF"),			 //$NON-NLS-1$
		MCC_3619_ALOFT  										(3619, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "ALOFT"),			 //$NON-NLS-1$
		MCC_3620_BINIONS_HORSESHOE_CLUB  						(3620, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "BINIONS HORSESHOE CLUB"),			 //$NON-NLS-1$
		MCC_3621_EXTENDED_STAY  								(3621, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "EXTENDED STAY"),			 //$NON-NLS-1$
		MCC_3622_MERLIN_HOLTEL_PERTH  							(3622, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "MERLIN HOTEL (PERTH)"),			 //$NON-NLS-1$
		MCC_3623_DORINT_HOTELS  								(3623, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "DORINT HOTELS"),			 //$NON-NLS-1$
		MCC_3624_LADY_LUCK_HOTEL_AND_CASINO  					(3624, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "LADY LUCK HOTEL AND CASINO"),			 //$NON-NLS-1$
		MCC_3625_HOTEL_UNIVERSAL  								(3625, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "HOTEL UNIVERSAL"),			 //$NON-NLS-1$
		MCC_3626_STUDIO_PLUS  									(3626, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "STUDIO PLUS"),			 //$NON-NLS-1$
		MCC_3627_EXTENDED_STAY_AMERICA  						(3627, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "EXTENDED STAY AMERICA"),			 //$NON-NLS-1$
		MCC_3628_EXCALIBUR_HOTEL_AND_CASINO  					(3628, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "EXCALIBUR HOTEL AND CASINO"),			 //$NON-NLS-1$
		MCC_3629_DAN_HOTELS  									(3629, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "DAN HOTELS"),			 //$NON-NLS-1$
		MCC_3630_EXTENDED_STAY_DELUXE  							(3630, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "EXTENDED STAY DELUXE"),			 //$NON-NLS-1$
		MCC_3631_SLEEP_INN  									(3631, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "SLEEP_INN"),			 //$NON-NLS-1$
		MCC_3632_THE_PHOENICIAN  								(3632, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "THE PHOENICIAN"),			 //$NON-NLS-1$
		MCC_3633_RANK_HOTELS  									(3633, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "RANK HOTELS"),			 //$NON-NLS-1$
		MCC_3634_SWISSOTEL  									(3634, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "SWISSOTEL"),			 //$NON-NLS-1$
		MCC_3635_RESO_HOTELS  									(3635, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "RESO HOTELS"),			 //$NON-NLS-1$
		MCC_3636_SAROVA_HOTELS  								(3636, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "SAROVA HOTELS"),			 //$NON-NLS-1$
		MCC_3637_RAMADA_INNS  									(3637, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "RAMADA INNS, RAMADA LIMITED"),			 //$NON-NLS-1$
		MCC_3638_HOWARD_JOHNSON  								(3638, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "HOWARD JOHNSON, HO JO INN"),			 //$NON-NLS-1$
		MCC_3639_MOUNT_CHARLOTTE_HOTELS  						(3639, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "MOUNT CHARLOTTE HOTELS"),			 //$NON-NLS-1$
		MCC_3640_HYATT_HOTELS_INTERNATIONAL  					(3640, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "HYATT HOTELS INTERNATIONAL"),			 //$NON-NLS-1$
		MCC_3641_SOFITEL_HOTELS 	 							(3641, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "SOFITEL HOTELS"),			 //$NON-NLS-1$
		MCC_3642_NOVOTEL_SIEH  									(3642, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "NOVOTEL SIEH (ACCOR)"),			 //$NON-NLS-1$
		MCC_3643_STEINGENBERGER_HOTELS  						(3643, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "STEIGENBERGER HOTELS"),			 //$NON-NLS-1$
		MCC_3644_ECONO_TRAVEL_MOTOR_HOTEL  						(3644, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "ECONO TRAVEL MOTOR HOTEL"),			 //$NON-NLS-1$
		MCC_3645_QUEENS_MOAT_HOUSES  							(3645, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "QUEENS MOAT HOUSES"),			 //$NON-NLS-1$
		MCC_3646_SWALLOW_HOTELS  								(3646, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "SWALLOW HOTELS"),			 //$NON-NLS-1$
		MCC_3647_GRUPO_HOTELS_HUSA  							(3647, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "GRUPO HOTELS HUSA SA"),			 //$NON-NLS-1$
		MCC_3648_DE_VERE_HOTELS  								(3648, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "DE VERE HOTELS"),			 //$NON-NLS-1$
		MCC_3649_RADISSON_HOTELS  								(3649, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "RADISSON HOTELS"),			 //$NON-NLS-1$
		MCC_3650_RED_ROOF_INNS  								(3650, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "RED ROOF INNS"),			 //$NON-NLS-1$
		MCC_3651_IMPERIAL_LONDON_HOTEL  						(3651, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "IMPERIAL LONDON HOTEL"),			 //$NON-NLS-1$
		MCC_3652_EMBASSY_HOTELS  								(3652, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "EMBASSY HOTELS"),			 //$NON-NLS-1$
		MCC_3653_PENTA_HOTELS 									(3653, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "PENTA HOTELS"),			 //$NON-NLS-1$
		MCC_3654_LOEWS_HOTELS  									(3654, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "LOEWS HOTELS"),			 //$NON-NLS-1$
		MCC_3655_SCANDIC_HOTELS  								(3655, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "SCANDIC HOTELS"),			 //$NON-NLS-1$
		MCC_3656_SARA_HOTELS  									(3656, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "SARA HOTELS"),			 //$NON-NLS-1$
		MCC_3657_OBEROI_HOTELS  								(3657, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "OBEROI HOTELS"),			 //$NON-NLS-1$
		MCC_3658_NEW_OTANI_HOTELS  								(3658, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "NEW OTANI HOTELS"),			 //$NON-NLS-1$
		MCC_3659_TAJ_HOTELS_INTERNATIONAL  						(3659, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "TAJ HOTELS INTERNATIONAL"),			 //$NON-NLS-1$
		MCC_3660_KNIGHTS_INNS  									(3660, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "KNIGHTS INNS"),			 //$NON-NLS-1$
		MCC_3661_METROPOLE_HOTELS  								(3661, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "METROPOLE HOTELS"),			 //$NON-NLS-1$
		MCC_3662_CIRCUS_CIRCUS_HOTEL_AND_CASINO 				(3662, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "CIRCUS CIRCUS HOTEL AND CASINO"),			 //$NON-NLS-1$
		MCC_3663_HOTELES_EL_PRESIDENTE 							(3663, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "HOTELES EL PRESIDENTE"),			 //$NON-NLS-1$
		MCC_3664_FLAG_INNS 										(3664, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "FLAG INNS"),			 //$NON-NLS-1$
		MCC_3665_HAMPTON_INNS 									(3665, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "HAMPTON INNS"),			 //$NON-NLS-1$
		MCC_3666_STAKIS_HOTELS 									(3666, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "STAKIS HOTELS"),			 //$NON-NLS-1$
		MCC_3667_LUXOR_HOTEL_AND_CASINO  						(3667, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "LUXOR HOTEL AND CASINO"),			 //$NON-NLS-1$
		MCC_3668_MARITIM_HOTELS  								(3668, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "MARITIM HOTELS"),			 //$NON-NLS-1$
		MCC_3669_ELDORADO_HOTEL_AND_CASINO  					(3669, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "ELDORADO HOTEL AND CASINO"),			 //$NON-NLS-1$
		MCC_3670_ARCADE_HOTELS  								(3670, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "ARCADE HOTELS"),			 //$NON-NLS-1$
		MCC_3671_ARCTIA_HOTELS  								(3671, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "ARCTIA HOTELS"),			 //$NON-NLS-1$
		MCC_3672_CAMPANILE_HOTELS  								(3672, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "CAMPANILE HOTELS"),			 //$NON-NLS-1$
		MCC_3673_IBUSZ_HOTELS  									(3673, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "IBUSZ HOTELS"),			 //$NON-NLS-1$
		MCC_3674_RANTASIPI_HOTELS  								(3674, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "RANTASIPI HOTELS"),			 //$NON-NLS-1$
		MCC_3675_INTERHOTEL_CEDOK  								(3675, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "INTERHOTEL CEDOK"),			 //$NON-NLS-1$
		MCC_3676_MONTE_CARLO_HOTEL_AND_CASINO  					(3676, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "MONTE CARLO HOTEL AND CASINO"),			 //$NON-NLS-1$
		MCC_3677_CLIMAT_DE_FRANCE_HOTELS  						(3677, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "CLIMAT DE FRANCE HOTELS"),			 //$NON-NLS-1$
		MCC_3678_CUMULUS_HOTELS  								(3678, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "CUMULUS HOTELS"),			 //$NON-NLS-1$
		MCC_3679_SILVER_LEGACY_HOTEL_AND_CASINO  				(3679, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "SILVER LEGACY HOTEL AND CASINO"),			 //$NON-NLS-1$
		MCC_3680_HOTEIS_OTHAN  									(3680, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "HOTEIS OTHAN"),			 //$NON-NLS-1$
		MCC_3681_ADAMS_MARK_HOTELS  							(3681, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "ADAMS MARK HOTELS"),			 //$NON-NLS-1$
		MCC_3682_SAHARA_HOTEL_AND_CASINO						(3682, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "SAHARA HOTEL AND CASINO"),			 //$NON-NLS-1$
		MCC_3683_BRADBURY_SUITES  								(3683, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "BRADBURY_SUITES"),			 //$NON-NLS-1$
		MCC_3684_BUDGET_HOST_INNS  								(3684, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "BUDGET HOST INNS"),			 //$NON-NLS-1$
		MCC_3685_BUDGETEL_HOTELS  								(3685, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "BUDGETEL HOTELS"),			 //$NON-NLS-1$
		MCC_3686_SUISSE_CHALETS  								(3686, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "SUISSE CHALETS"),			 //$NON-NLS-1$
		MCC_3687_CLARION_HOTELS  								(3687, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "CLARION HOTELS"),			 //$NON-NLS-1$
		MCC_3688_COMPRI_HOTELS  								(3688, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "COMPRI HOTELS"),			 //$NON-NLS-1$
		MCC_3689_CONSORT_HOTELS  								(3689, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "CONSORT HOTELS"),			 //$NON-NLS-1$
		MCC_3690_COURTYARD_BY_MARRIOTT  						(3690, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "COURTYARD BY MARRIOTT"),			 //$NON-NLS-1$
		MCC_3691_DILLION_INNS  									(3691, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "DILLION INNS"),			 //$NON-NLS-1$
		MCC_3692_DOUBLETREE_HOTELS  							(3692, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "DOUBLETREE HOTELS"),			 //$NON-NLS-1$
		MCC_3693_DRURY_INNS  									(3693, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "DRURY INNS"),			 //$NON-NLS-1$
		MCC_3694_ECONOMY_INNS_OF_AMERICA  						(3694, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "ECONOMY INNS OF AMERICA"),			 //$NON-NLS-1$
		MCC_3695_EMBASSY_SUITES  								(3695, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "EMBASSY SUITES"),			 //$NON-NLS-1$
		MCC_3696_EXCEL_INNS  									(3696, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "EXCEL INNS"),			 //$NON-NLS-1$
		MCC_3697_FAIRFIELD_HOTELS  								(3697, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "FARFIELD HOTELS"),			 //$NON-NLS-1$
		MCC_3698_HARLEY_HOTELS  								(3698, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "HARLEY HOTELS"),			 //$NON-NLS-1$
		MCC_3699_MIDWAY_MOTOR_LODGE  							(3699, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "MIDWAY MOTOR LODGE"),			 //$NON-NLS-1$
		MCC_3700_MOTEL_6  										(3700, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "MOTEL 6"),			 //$NON-NLS-1$
		MCC_3701_LA_MANSION_DEL_RIO  							(3701, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "LA MANSION DEL RIO"),			 //$NON-NLS-1$
		MCC_3702_THE_REGISTRY_HOTELS  							(3702, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "THE REGISTRY HOTELS"),			 //$NON-NLS-1$
		MCC_3703_RESIDENCE_INNS  								(3703, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "RESIDENCE INNS"),			 //$NON-NLS-1$
		MCC_3704_ROYCE_HOTELS  									(3704, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "ROYCE HOTELS"),			 //$NON-NLS-1$
		MCC_3705_SANDMAN_INNS  									(3705, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "SANDMAN INNS"),			 //$NON-NLS-1$
		MCC_3706_SHILO_INNS  									(3706, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "SHILO INNS"),			 //$NON-NLS-1$
		MCC_3707_SHONEY_S_INNS  								(3707, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "SHONEY'S INNS"),			 //$NON-NLS-1$
		MCC_3708_VIRGIN_RIVER_HOTEL_AND_CASINO  				(3708, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "VIRGIN RIVER HOTEL AND CASINO"),			 //$NON-NLS-1$
		MCC_3709_SUPER_8_MOTELS  								(3709, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "SUPER8 MOTELS"),			 //$NON-NLS-1$
		MCC_3710_THE_RITZ_CARLTON_HOTELS  						(3710, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "THE RITZ CARLTON HOTELS"),			 //$NON-NLS-1$
		MCC_3711_FLAG_INNS_AUSTRALIA  							(3711, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "FLAG INNS (AUSTRALIA)"),			 //$NON-NLS-1$
		MCC_3712_BUFFALO_BILL_HOTEL_AND_CASINO  				(3712, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "BUFFALO BILLS HOTEL AND CASINO"),			 //$NON-NLS-1$
		MCC_3713_QUALITY_PACIFIC_HOTEL  						(3713, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "QUALITY PACIFIC HOTEL"),			 //$NON-NLS-1$
		MCC_3714_FOUR_SEASONS_AUSTRALIA  						(3714, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "FOUR SEASONS (AUSTRALIA)"),			 //$NON-NLS-1$
		MCC_3715_FAIRFIELD_INNS  								(3715, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "FAIRFIELD INN"),			 //$NON-NLS-1$
		MCC_3716_CARLTON_HOTELS  								(3716, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "CARLTON HOTELS"),			 //$NON-NLS-1$
		MCC_3717_CITY_LODGE_HOTELS  							(3717, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "CITY LODGE HOTELS"),			 //$NON-NLS-1$
		MCC_3718_KAROS_HOTELS  									(3718, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "KAROS HOTELS"),			 //$NON-NLS-1$
		MCC_3719_PROTEA_HOTELS  								(3719, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "PROTEA HOTELS"),			 //$NON-NLS-1$
		MCC_3720_SOUTHERN_SUN_HOTELS  							(3720, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "SOUTHERN SUN HOTELS"),			 //$NON-NLS-1$
		MCC_3721_CONRAD_HOTELS  								(3721, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "CONRAD HOTELS"),			 //$NON-NLS-1$
		MCC_3722_WINDHAM_HOTEL_AND_RESORTS  					(3722, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "WYNDHAM HOTEL AND RESORTS"),			 //$NON-NLS-1$
		MCC_3723_RICA_HOTELS  									(3723, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "RICA HOTELS"),			 //$NON-NLS-1$
		MCC_3724_INTER_NOR_HOTELS  								(3724, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "INTER NOR HOTELS"),			 //$NON-NLS-1$
		MCC_3725_SEA_PINES_RESORT  								(3725, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "SEA PINES RESORT"),			 //$NON-NLS-1$
		MCC_3726_RIO_SUITES  									(3726, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "RIO SUITES"),			 //$NON-NLS-1$
		MCC_3727_BROADMOOR_HOTEL  								(3727, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "BROADMOOR HOTEL"),			 //$NON-NLS-1$
		MCC_3728_BALLY_S_HOTEL_AND_CASINO  						(3728, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "BALLY'S HOTEL AND CASINO"),			 //$NON-NLS-1$
		MCC_3729_JOHN_ASCUAGA_S_NUGGET  						(3729, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "JOHN ASCUAGA'S NUGGET"),			 //$NON-NLS-1$
		MCC_3730_MGM_GRAND_HOTEL  								(3730, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "MGM GRAND HOTEL"),			 //$NON-NLS-1$
		MCC_3731_HARRAH_S_HOTELS_AND_CASINOS  					(3731, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "HARRAH'S HOTELS AND CASINOS"),			 //$NON-NLS-1$
		MCC_3732_OPRYLAND_HOTEL  								(3732, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "OPRYLAND HOTEL"),			 //$NON-NLS-1$
		MCC_3733_BOCA_RATON_RESORT  							(3733, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "BOCA RATON RESORT"),			 //$NON-NLS-1$
		MCC_3734_HARVEY_BRISTOL_HOTELS  						(3734, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "HARVEY/BRISTOL HOTELS"),			 //$NON-NLS-1$
		MCC_3735_MASTERS_ECONOMY_INNS  							(3735, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "MASTERS ECONOMY INNS"),			 //$NON-NLS-1$
		MCC_3736_COLORADO_BELLE_EDGEWATER_RESORT  				(3736, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "COLORADO BELLE/EDGEWATER RESORT"),			 //$NON-NLS-1$
		MCC_3737_RIVIERA_HOTEL_AND_CASINO  						(3737, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "RIVIERA HOTEL AND CASINO"),			 //$NON-NLS-1$
		MCC_3738_TROPICANA_RESORT_AND_CASINO  					(3738, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "TROPICANA RESORT AND CASINO"),			 //$NON-NLS-1$
		MCC_3739_WOODSIDE_HOTELS_AND_RESORTS  					(3739, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "WOODSIDE HOTELS AND RESORTS"),			 //$NON-NLS-1$
		MCC_3740_TOWNPLACE_SUITES  								(3740, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "TOWNPLACE SUITES"),			 //$NON-NLS-1$
		MCC_3741_MILLENIUM_BROADWAY_HOTEL  						(3741, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "MILLENIUM BROADWAY HOTEL"),			 //$NON-NLS-1$
		MCC_3742_CLUB_MED  										(3742, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "CLUB MED"),			 //$NON-NLS-1$
		MCC_3743_BILTMORE_HOTEL_AND_SUITES  					(3743, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "BILTMORE HOTEL AND SUITES"),			 //$NON-NLS-1$
		MCC_3744_CAREFREE_RESORTS  								(3744, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "CAREFREE RESORTS"),			 //$NON-NLS-1$
		MCC_3745_ST_REGIS_HOTEL  								(3745, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "ST. REGIS HOTEL"),			 //$NON-NLS-1$
		MCC_3746_THE_ELIOT_HOTEL  								(3746, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "THE ELIOT HOTEL"),			 //$NON-NLS-1$
		MCC_3747_CLUB_CORPORATION_CLUB_RESORTS  				(3747, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "CLUB CORPORATION / CLUB RESORTS"),			 //$NON-NLS-1$
		MCC_3748_WELLESLEY_INNS  								(3748, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "WELLESLEY INNS"),			 //$NON-NLS-1$
		MCC_3749_THE_BERERLY_HILLS_HOTEL  						(3749, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "THE BEVERLY HILLS HOTEL"),			 //$NON-NLS-1$
		MCC_3750_CROWNE_PLAZA_HOTELS  							(3750, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "CROWNE PLAZA HOTELS"),			 //$NON-NLS-1$
		MCC_3751_HOMEWOOD_SUITES  								(3751, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "HOMEWOOD SUITES"),			 //$NON-NLS-1$
		MCC_3752_PEABODY_HOTELS  								(3752, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "PEABODY HOTELS"),			 //$NON-NLS-1$
		MCC_3753_GREEBRIAR_RESORTS  							(3753, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "GREENBRIAR RESORTS"),			 //$NON-NLS-1$
		MCC_3754_AMELIA_ISLAND_PLANTATION  						(3754, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "AMELIA ISLAND PLANTATION"),			 //$NON-NLS-1$
		MCC_3755_THE_HOMESTEAD  								(3755, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "THE HOMESTEAD"),			 //$NON-NLS-1$
		MCC_3757_CANYON_RANCH  									(3757, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "CANYON RANCH"),			 //$NON-NLS-1$
		MCC_3758_KAHALA_MANDARIN_ORIENTAL_HOTEL  				(3758, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "KAHALA MANDARIN ORIENTAL HOTEL"),			 //$NON-NLS-1$
		MCC_3759_ORCHID_AT_MAUNA_LAI  							(3759, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "ORCHID AT MAUNA LAI"),			 //$NON-NLS-1$
		MCC_3760_HALEKULANI_HOTEL_WAIKIKI_PARK  				(3760, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "HALEKULANI HOTEL / WAIKIKI PARK"),			 //$NON-NLS-1$
		MCC_3761_PRIMADONNA_HOTEL_AND_CASINO  					(3761, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "PRIMADONNA HOTEL AND CASINO"),			 //$NON-NLS-1$
		MCC_3762_WHISKEY_PETE_S_HOTEL_AND_CASINO  				(3762, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "WHISKEY PETE'S HOTEL AND CASINO"),			 //$NON-NLS-1$
		MCC_3763_CHATEAU_ELAN_WINERY_AND_RESORT  				(3763, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "CHATEAU ELAN WINERY AND RESORT"),			 //$NON-NLS-1$
		MCC_3764_BEAU_RIVAGE_HOTEL_AND_CASINO  					(3764, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "BEAU RIVAGE HOTEL AND CASINO"),			 //$NON-NLS-1$
		MCC_3765_BELLAGIO  										(3765, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "BELLAGIO"),			 //$NON-NLS-1$
		MCC_3766_FREMONT_HOTEL_AND_CASINO  						(3766, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "FREMONT HOTEL AND CASINO"),			 //$NON-NLS-1$
		MCC_3767_MAIN_STREET_STATION_HOTEL_AND_CASINO  			(3767, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "MAIN STREET STATION HOTEL AND CASINO"),			 //$NON-NLS-1$
		MCC_3768_SILVER_STAR_HOTEL_AND_CASINO  					(3768, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "SILVER STAR HOTEL AND CASINO"),			 //$NON-NLS-1$
		MCC_3769_STRATOSPHERE_HOTEL_AND_CASINO  				(3769, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "STRATOSPHERE HOTEL AND CASINO"),			 //$NON-NLS-1$
		MCC_3770_SPRINGHILL_SUITES  							(3770, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "SPRINGHILL SUITES"),			 //$NON-NLS-1$
		MCC_3771_CAESARS_HOTEL_AND_CASINO  						(3771, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "CAESARS HOTEL AND CASINO"),			 //$NON-NLS-1$
		MCC_3772_NEMACOLIN_WOODLANDS  							(3772, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "NEMACOLIN WOODLANDS"),			 //$NON-NLS-1$
		MCC_3773_VENETIAN_RESORT_HOTEL_AND_CASINO  				(3773, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "VENETIAN RESORT HOTEL AND CASINO"),			 //$NON-NLS-1$
		MCC_3774_NEW_YORK_HOTEL_AND_CASINO  					(3774, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "NEW YORK HOTEL AND CASINO"),			 //$NON-NLS-1$
		MCC_3775_SANDS_RESORT  									(3775, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "SANDS RESORT"),			 //$NON-NLS-1$
		MCC_3776_NEVELE_GRANDE_RESORT_AND_COUNTRY_CLUB 			(3776, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "NEVELE GRANDE RESORT AND COUNTRY CLUB"),			 //$NON-NLS-1$
		MCC_3777_MANDALAY_BAY_RESORT 							(3777, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "MANDALAY BAY RESORT"),			 //$NON-NLS-1$
		MCC_3778_FOUR_POINTS_HOTEL 								(3778, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "FOUR POINTS HOTEL"),			 //$NON-NLS-1$
		MCC_3779_W_HOTELS 										(3779, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "W HOTELS"),			 //$NON-NLS-1$
		MCC_3780_DISNEYLAND_RESORTS 							(3780, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "DISNEYLAND RESORTS"),			 //$NON-NLS-1$
		MCC_3781_PATRICIA_GRAND_RESORT_HOTEL 					(3781, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "PATRICIA GRAND RESORT HOTEL"),			 //$NON-NLS-1$
		MCC_3782_ROSEN_HOTEL_AND_RESORTS 						(3782, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "ROSEN HOTEL AND RESORTS"),			 //$NON-NLS-1$
		MCC_3783_TOWN_AND_COUNTRY_RESORT_AND_CONVENTION_CENTER 	(3783, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "TOWN AND COUNTRY RESORT AND CONVENTION CENTER"),			 //$NON-NLS-1$
		MCC_3784_FIRST_HOSPITALITY_HOTELS 						(3784, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "FIRST HOSPITALITY HOTELS"),			 //$NON-NLS-1$
		MCC_3785_OUTRIGGER_HOTELS_AND_RESORTS 					(3785, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "OUTRIGGER HOTELS AND RESORTS"),			 //$NON-NLS-1$
		MCC_3786_OHANA_HOTELS_OF_HAWAII 						(3786, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "OHANA HOTELS OF HAWAII"),			 //$NON-NLS-1$
		MCC_3787_CARIBE_ROYAL_RESORT_SUITE_AND_VILLAS 			(3787, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "CARIBE ROYAL RESORT SUITE AND VILLAS"),			 //$NON-NLS-1$
		MCC_3788_ALA_MOANA_HOTEL 								(3788, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "ALA MOANA HOTEL"),			 //$NON-NLS-1$
		MCC_3789_SMUGGLERS_NOTCH_RESORT 						(3789, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "SMUGGLERS NOTCH RESORT"),			 //$NON-NLS-1$
		MCC_3790_RAFFLE_HOTELS 									(3790, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "RAFFLE HOTELS"),			 //$NON-NLS-1$
		MCC_3791_STAYBRIDGE_SUITES 								(3791, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "STAYBRIDGE SUITES"),			 //$NON-NLS-1$
		MCC_3792_CLARIDGE_CASINO_HOTELS 						(3792, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "CLARIDGE CASINO HOTELS"),			 //$NON-NLS-1$
		MCC_3793_THE_FLAMINGO_HOTELS 							(3793, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "THE FLAMINGO HOTELS"),			 //$NON-NLS-1$
		MCC_3794_GRAND_CASINO_HOTELS 							(3794, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "GRAND CASINO HOTELS"),			 //$NON-NLS-1$
		MCC_3795_PARIS_LAS_VEGAS_HOTEL 							(3795, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "PARIS LAS VEGAS HOTEL"),			 //$NON-NLS-1$
		MCC_3796_PEPPERMILL_HOTEL_AND_CASINO 					(3796, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "PEPPERMILL HOTEL AND CASINO"),			 //$NON-NLS-1$
		MCC_3797_ATLANTIC_CITY_HILTON 							(3797, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "ATLANTIC CITY HILTON"),			 //$NON-NLS-1$
		MCC_3798_EMBASSY_VACATION_RESORT 						(3798, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "EMBASSY VACATION RESORT"),			 //$NON-NLS-1$
		MCC_3799_HALE_KOA_HOTEL 								(3799, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "HALE KOA HOTEL"),			 //$NON-NLS-1$
		MCC_3800_HOMESTEAD_SUITES 								(3800, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "HOMESTEAD SUITES"),			 //$NON-NLS-1$
		MCC_3801_WILDERNESS_HOTEL_AND_RESORT 					(3801, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "WILDERNESS HOTEL AND RESORT"),			 //$NON-NLS-1$
		MCC_3802_THE_PALACE_HOTEL 								(3802, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "THE PALACE HOTEL"),			 //$NON-NLS-1$
		MCC_3803_THE_WIGWAM_GOLF_RESORT_AND_SPA 				(3803, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "THE WIGWAM GOLF RESORT AND SPA"),			 //$NON-NLS-1$
		MCC_3804_THE_DIPLOMAT_COUNTRY_CLUB_AND_SPA 				(3804, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "THE DIPLOMAT COUNTRY CLUB AND SPA"),			 //$NON-NLS-1$
		MCC_3805_THE_ATLANTIC									(3805, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "THE ATLANTIC"),			 //$NON-NLS-1$
		MCC_3806_PRINCEVILLE_RESORT 							(3806, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "PRINCEVILLE RESORT"),			 //$NON-NLS-1$
		MCC_3807_ELEMENT 										(3807, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "ELEMENT"),			 //$NON-NLS-1$
		MCC_3808_LUXURY_RESORTS 								(3808, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "LUXURY RESORTS"),			 //$NON-NLS-1$
		MCC_3809_SETTLE_INN 									(3809, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "SETTLE_INN"),			 //$NON-NLS-1$
		MCC_3810_LA_COSTAL_RESORT 								(3810, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT,  "LA COSTAL RESORT"),			 //$NON-NLS-1$
		MCC_3811_PREMIER_TRAVEL_INNS 							(3811, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "PREMIER TRAVEL INNS"),			 //$NON-NLS-1$
		MCC_3812_HYATT_PLACE 									(3812, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "HYATT PLACE"),			 //$NON-NLS-1$
		MCC_3813_HOTEL_INDIGO 									(3813, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "HOTEL INDIGO"),			 //$NON-NLS-1$
		MCC_3814_THE_ROOSEVELT_HOTEL_NEW_YORK 					(3814, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "THE ROOSEVELT HOTEL NEW YORK"),			 //$NON-NLS-1$
		MCC_3815_NICKELODEON_FAMILY_SUITES_BY_HOLIDAY_INN 		(3815, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "NICKELODEON FAMILY SUITES BY HOLIDAY INN"),			 //$NON-NLS-1$
		MCC_3816_HOME_2_SUITES 									(3816, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "HOME 2 SUITES"),			 //$NON-NLS-1$
		MCC_3817_AFFINIA 										(3817, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "AFFINIA"),			 //$NON-NLS-1$
		MCC_3818_MAINSTAY_SUITES 								(3818, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "MAINSTAY_SUITES"),			 //$NON-NLS-1$
		MCC_3819_OXFORF_SUITES 									(3819, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "OXFORD SUITES"),			 //$NON-NLS-1$
		MCC_3820_JUMEIRAH_ESSEX_HOUSE 							(3820, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "JUMEIRAH ESSEX HOUSE"),			 //$NON-NLS-1$
		MCC_3821_CARIBE_ROYAL 									(3821, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "CARIBE_ROYAL"),			 //$NON-NLS-1$
		MCC_3822_CROSSLAND 										(3822, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "CROSSLAND"),			 //$NON-NLS-1$
		MCC_3823_GRAND_SIERRA_RESORT 							(3823, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "GRAND SIERRA_RESORT"),			 //$NON-NLS-1$
		MCC_3824_ARIA 											(3824, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "ARIA"),			 //$NON-NLS-1$
		MCC_3825_VDARA 											(3825, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "VDARA"),			 //$NON-NLS-1$
		MCC_3826_AUTOGRAPH 										(3826, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "AUTOGRAPH"),			 //$NON-NLS-1$
		MCC_3827_GALT_HOUSE 									(3827, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "GALT_HOUSE"),			 //$NON-NLS-1$
		MCC_3828_COSMOPOLITAN_OF_LAS_VEGAS 						(3828, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "COSMOPOLITAN OF LAS VEGAS"),			 //$NON-NLS-1$
		MCC_3829_COUNTRY_INN_BY_CARLSON 						(3829, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "COUNTRY INN BY CARLSON"),			 //$NON-NLS-1$
		MCC_3830_PARK_PLAZA_HOTEL 								(3830, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "PARK PLAZA HOTEL"),			 //$NON-NLS-1$
		MCC_3831_WALDORF 										(3831, HOTELS_MOTELS, TRBCIndustry.HOTELS_MOTELS_AND_CRUISE_LINES, TCC_H_HOT, MCG_2_HOT, "WALDORF");			 //$NON-NLS-1$
		
		/** The separator used to separate airlines brand name from required abbreviations in description */
		private static final String SEPARATOR = ";;"; //$NON-NLS-1$
		/** Reserved word for airlines - Mastercard required abbreviation */
		private static final String MASTERCARD_REQUIRED_ABBREVIATION = "##MC##"; //$NON-NLS-1$
		/** Reserved word for airlines - Visa required abbreviation */
		private static final String VISA_REQUIRED_ABBREVIATION = "##VISA##"; //$NON-NLS-1$
		/** Reserved word for airlines - TSYS required abbreviation */
		private static final String TSYS_REQUIRED_ABBREVIATION = "##TSYS##"; //$NON-NLS-1$

		/** The Merchant Category numeric Code */
		private int code;
		/** The Merchant Category Code description */
		private String description;
		/** The Visa Airline brand required abbreviation */
		private String visaBrandAbbreviation;
		/** The Mastercard Airline brand required abbreviation */
		private String mastercardBrandAbbreviation;
		/** The TSYS (Germany) Airline brand required abbreviation */
		private String tsysBrandAbbreviation;
		/** The category range this MCC falls in */
		private MerchantCategoryRange categoryRange;
		/** The Visa Merchant Category Group related to this MCC */
		private VisaMerchantCategoryGroup schemeMCG;
		/** The Mastercard Transaction Category Code related to this MCC */
		private MastercardTransactionCategoryCode schemeTCC;
		/** The (Mastercard) classification in head category for this MCC */
		private MastercardMerchantCategory headCategory;
		/** The Thomson Reuters Business Classification for this MCC */
		private TRBCIndustry TRBClassification;
		
		/** The flat list of Iso18245MerchantCategoryCode enumeration values */
		private static List<MerchantCategoryCode> mccFlatList;
		/** The scheme nested list (2 levels - merchant category range / merchant head category) of Iso18245MerchantCategoryCode enumeration values */
		private static SchemeNestedList mccSchemeList;
		/** The Thomson Reuters nested list (4 levels) of Iso18245MerchantCategoryCode enumeration values */
		private static ThomsonReutersNestedList mccTRBCList;

		/** The indentation index for use in MerchantCategoryList (must be declared in super class) */
		private static int tabIndex = 0;
		
		/** 
		 * Constructs a ISO 18245 Merchant Category Code enumeration value.
		 * <p>
		 * @param code the MCC code
		 * @param headCategory the merchant category as classified by Mastercard
		 * @param classification the Thomson Reuters Business Classification Industry category for this MCC
		 * @param schemeTCC the Mastercard Transaction Category Code for this MCC
		 * @param schemeMCG the Visa Merchant Category Group for this MCC
		 * @param description the MCC description (for airlines, with additional required scheme abbreviations)
		 */
		private Iso18245MerchantCategoryCode (int code, MastercardMerchantCategory headCategory, TRBCIndustry TRBClassification,
				MastercardTransactionCategoryCode schemeTCC, VisaMerchantCategoryGroup schemeMCG, String description) 
				throws IllegalArgumentException {
			
			this.code = code;
			this.categoryRange = MerchantCategoryRange.valueOf(this.code);
			this.schemeMCG = schemeMCG;
			this.schemeTCC = schemeTCC;
			if (description.indexOf(SEPARATOR) >= 0) {
				parseBrandSchemeAbbreviation(description); 
			} else this.description = description;
			this.headCategory = headCategory;
			this.TRBClassification = TRBClassification;
			addMCC(this);
			
		}
		
		/** 
		 * Special handling for airlines description to set schemes' specific brand abbreviation.
		 * <p>
		 * @param description the airline description in the form <pre>brand name[;;##VISA##abbreviation][;;##MC##abbreviation][;;##TSYS##abbreviation])</pre>
		 * @throws IllegalArgumentException if <code>description</code> does not follow the expected format
		 */
		private void parseBrandSchemeAbbreviation(String description) throws IllegalArgumentException {

			String[] splitStr = description.split(SEPARATOR);
			int len = splitStr.length;
			if (len > 4) throw new IllegalArgumentException ("Airline MCC must follow the form \"brand name[;;##VISA##abbreviation][;;##MC##abbreviation][;;##TSYS##abrreviation])\""); //$NON-NLS-1$
			// First String must be the brand name
			String brand = splitStr[0];
			if (brand.indexOf(MASTERCARD_REQUIRED_ABBREVIATION) >= 0 || brand.indexOf(VISA_REQUIRED_ABBREVIATION) >= 0 || brand.indexOf(TSYS_REQUIRED_ABBREVIATION) >= 0 ) {
				throw new IllegalArgumentException ("Airline MCC must follow the form \"brand name[;;##VISA##abbreviation][;;##MC##abbreviation][;;##TSYS##abrreviation])\""); //$NON-NLS-1$
			} else this.description = brand;
			// Others are required scheme brand abbreviations prefixed (mandatory) by corresponding reserved word
			String[] abbrs = Arrays.copyOfRange(splitStr, 1, len);
			for (String abbr : abbrs) {
				if (abbr.indexOf(MASTERCARD_REQUIRED_ABBREVIATION) >=0) this.mastercardBrandAbbreviation = abbr.replace(MASTERCARD_REQUIRED_ABBREVIATION, ""); //$NON-NLS-1$
				else if (abbr.indexOf(VISA_REQUIRED_ABBREVIATION) >=0) this.visaBrandAbbreviation = abbr.replace(VISA_REQUIRED_ABBREVIATION, ""); //$NON-NLS-1$
				else if (abbr.indexOf(TSYS_REQUIRED_ABBREVIATION) >=0) this.tsysBrandAbbreviation = abbr.replace(TSYS_REQUIRED_ABBREVIATION, ""); //$NON-NLS-1$
				else throw new IllegalArgumentException ("Airline MCC must follow the form \"brand name[;;##VISA##abbreviation][;;##MC##abbreviation][;;##TSYS##abrreviation])\""); //$NON-NLS-1$
			}
			
		}

		/** Adds <code>mcc</code> to the top level range category list if the range category does not exist or to the nested list otherwise. */
		private static void addMCC (Iso18245MerchantCategoryCode mcc) {
			if (mccFlatList == null) mccFlatList = new ArrayList<>();
			if (mccSchemeList == null) mccSchemeList = mcc.new SchemeNestedList();
			if (mccTRBCList == null) mccTRBCList = mcc.new ThomsonReutersNestedList();
			mccFlatList.add(mcc.new MerchantCategoryCode(mcc));
			mccSchemeList.add(mcc);
			mccTRBCList.add(mcc);
		}
		
		/** 
		 * Returns the ISO 18245 MCC enumeration value corresponding to <code>code</code> as int value (alternative to valueOf(String) )
		 * <p>
		 * @param code, the code to search
		 * @throws IllegalArgumentExcepption if the code is not recognised 
		 */
		public static Iso18245MerchantCategoryCode valueOf (int code) throws IllegalArgumentException {
			Iso18245MerchantCategoryCode merchantCategoryCode = null;
			for (Iso18245MerchantCategoryCode mcc : values()) if (mcc.getCode() == code) { merchantCategoryCode = mcc; break; }
			if (merchantCategoryCode == null) throw new IllegalArgumentException ("Invalid MCC " + code);
			return merchantCategoryCode; 
		}

		/** Returns this MCC code as String (for use in protocols for instance) */ 
		public String getCodeAsString() { return String.format("%04d", code); } //$NON-NLS-1$

		/** Returns this MCC code */
		public int getCode() { return code; }
		
		/** Returns this MCC description */
		public String getDescription() { return description; }
		
		/** Returns the Visa required airline brand abbreviation */
		public String getVisaBrandAbbreviation() { return visaBrandAbbreviation; }

		/** Returns the Mastercard required airline brand abbreviation */
		public String getMastercardBrandAbbreviation() { return mastercardBrandAbbreviation; }

		/** Returns the TSYS (Germany) required airline brand abbreviation */
		public String getTsysBrandAbbreviation() { return tsysBrandAbbreviation; }

		/** Returns the MCC category range for this MCC */
		public MerchantCategoryRange getCategoryRange() { return categoryRange; }

		/** Returns the Visa Merchant Category Group related to this MCC */
		public VisaMerchantCategoryGroup getSchemeMCG() { return schemeMCG; }

		/** Returns the Mastercard Transaction Category Code related to this MCC */
		public MastercardTransactionCategoryCode getSchemeTCC() { return schemeTCC; }

		/** Returns the (Mastercard) classification in head category for this MCC */
		public MastercardMerchantCategory getHeadCategory() { return headCategory; }

		/** Returns the Thomson Reuters Business Classification for this MCC */
		public TRBCIndustry getTRBCClassification() { return TRBClassification; }

		/** Return a Human readable representation of this Currency Code. */
		@Override public String toString() {
			StringBuffer buf = new StringBuffer();
			buf.append("MCC (" + getCodeAsString() + "): " + getDescription()); //$NON-NLS-1$ //$NON-NLS-2$
			buf.append("\n  Merchant Category Code Range         = " + getCategoryRange()); //$NON-NLS-1$
			buf.append("\n  (Mastercard) Merchant Category       = " + getHeadCategory()); //$NON-NLS-1$
			buf.append("\n  Mastercard Transaction Category Code = " + getSchemeTCC()); //$NON-NLS-1$
			buf.append("\n  Visa Merchant Category Group         = " + getSchemeMCG()); //$NON-NLS-1$
			buf.append("\n  Thomson Reuters Classification       = " + getTRBCClassification()); //$NON-NLS-1$
			return buf.toString();
		}

		
		/** Gets this enumeration values as list of MerchantCategoryCode ordered by ascending code. */
		public static List<MerchantCategoryCode> getFlatListOrderedByCode() {
			Collections.sort(mccFlatList, new OrderMCCByCode());
			return mccFlatList;
		}
		
		/** Gets this enumeration values as list of MerchantCategoryCode ordered by description alphabetical order. */
		public static List<MerchantCategoryCode> getFlatListOrderedByDescription() {
			Collections.sort(mccFlatList, new OrderMCCByDescription());
			return mccFlatList;
		}
		
		/** Gets the Merchant Category nested List according to Scheme classification, with category sorted by code ascending order and MCC sorted by code ascending order */
		public static MerchantCategoryList getSchemeNestedListOrderedByCodeWithListOrderedByCode() {
			return mccSchemeList.getMCCList(new OrderCategoryByCode(), new OrderMCCByCode());
		}
		
		/** Gets the Merchant Category nested List according to Scheme classification, with category sorted by label alphabetical order and MCC sorted by code ascending order */
		public static MerchantCategoryList getSchemeNestedListOrderedByCodeWithListOrderedByDescription() {
			return mccSchemeList.getMCCList(new OrderCategoryByDescription(), new OrderMCCByCode());
		}
		
		/** Gets the Merchant Category nested List according to Scheme classification, with category sorted by code and MCC sorted by description alphabetical order */
		public static MerchantCategoryList getSchemeNestedListOrderedByDescriptionWithListOrderedByCode() {
			return mccSchemeList.getMCCList(new OrderCategoryByCode(), new OrderMCCByDescription());
		}

		/** Gets the Merchant Category nested List according to Scheme classification, with category sorted by label alphabetical order and MCC sorted by description alphabetical order */
		public static MerchantCategoryList getSchemeNestedListOrderedByDescriptionWithListOrderedByDescription() {
			return mccSchemeList.getMCCList(new OrderCategoryByDescription(), new OrderMCCByDescription());
		}

		/** Gets the Merchant Category nested List as JSON according to Scheme classification, with category sorted by code ascending order and MCC sorted by code ascending order */
		public static String getSchemeNestedListAsJsonOrderedByCodeWithListOrderedByCode() {
			return mccSchemeList.getMCCListAsJSON(new OrderCategoryByCode(), new OrderMCCByCode());
		}
		
		/** Gets the Merchant Category nested List as JSON according to Scheme classification, with category sorted by label alphabetical order and MCC sorted by code ascending order */
		public static String getSchemeNestedListAsJsonOrderedByCodeWithListOrderedByDescription() {
			return mccSchemeList.getMCCListAsJSON(new OrderCategoryByDescription(), new OrderMCCByCode());
		}
		
		/** Gets the Merchant Category nested List as JSON according to Scheme classification, with category sorted by code and MCC sorted by description alphabetical order */
		public static String getSchemeNestedListAsJsonOrderedByDescriptionWithListOrderedByCode() {
			return mccSchemeList.getMCCListAsJSON(new OrderCategoryByCode(), new OrderMCCByDescription());
		}

		/** Gets the Merchant Category nested List as JSON according to Scheme classification, with category sorted by label alphabetical order and MCC sorted by description alphabetical order */
		public static String getSchemeNestedListAsJsonOrderedByDescriptionWithListOrderedByDescription() {
			return mccSchemeList.getMCCListAsJSON(new OrderCategoryByDescription(), new OrderMCCByDescription());
		}

		/** Gets the Merchant Category nested List according to Thomson Reuters classification, with category sorted by code ascending order and MCC sorted by code ascending order */
		public static MerchantCategoryList getThomsonReutersNestedListOrderedByCodeWithListOrderedByCode() {
			return mccTRBCList.getMCCList(new OrderCategoryByCode(), new OrderMCCByCode());
		}
		
		/** Gets the Merchant Category nested List according to Thomson Reuters classification, with category sorted by label alphabetical order and MCC sorted by code ascending order */
		public static MerchantCategoryList getThomsonReutersNestedListOrderedByCodeWithListOrderedByDescription() {
			return mccTRBCList.getMCCList(new OrderCategoryByDescription(), new OrderMCCByCode());
		}
		
		/** Gets the Merchant Category nested List according to Thomson Reuters classification, with category sorted by code and MCC sorted by description alphabetical order */
		public static MerchantCategoryList getThomsonReutersNestedListOrderedByDescriptionWithListOrderedByCode() {
			return mccTRBCList.getMCCList(new OrderCategoryByCode(), new OrderMCCByDescription());
		}

		/** Gets the Merchant Category nested List according to Thomson Reuters classification, with category sorted by label alphabetical order and MCC sorted by description alphabetical order */
		public static MerchantCategoryList getThomsonReutersNestedListOrderedByDescriptionWithListOrderedByDescription() {
			return mccTRBCList.getMCCList(new OrderCategoryByDescription(), new OrderMCCByDescription());
		}

		/** Gets the Merchant Category nested List as JSON according to Thomson Reuters classification, with category sorted by code ascending order and MCC sorted by code ascending order */
		public static String getThomsonReutersNestedListAsJsonOrderedByCodeWithListOrderedByCode() {
			return mccTRBCList.getMCCListAsJSON(new OrderCategoryByCode(), new OrderMCCByCode());
		}
		
		/** Gets the Merchant Category nested List as JSON according to Thomson Reuters classification, with category sorted by label alphabetical order and MCC sorted by code ascending order */
		public static String getThomsonReutersNestedListAsJsonOrderedByCodeWithListOrderedByDescription() {
			return mccTRBCList.getMCCListAsJSON(new OrderCategoryByDescription(), new OrderMCCByCode());
		}
		
		/** Gets the Merchant Category nested List as JSON according to Thomson Reuters  classification, with category sorted by code and MCC sorted by description alphabetical order */
		public static String getThomsonReutersNestedListAsJsonOrderedByDescriptionWithListOrderedByCode() {
			return mccTRBCList.getMCCListAsJSON(new OrderCategoryByCode(), new OrderMCCByDescription());
		}

		/** Gets the Merchant Category nested List as JSON according to Thomson Reuters classification, with category sorted by label alphabetical order and MCC sorted by description alphabetical order */
		public static String getThomsonReutersNestedListAsJsonOrderedByDescriptionWithListOrderedByDescription() {
			return mccTRBCList.getMCCListAsJSON(new OrderCategoryByDescription(), new OrderMCCByDescription());
		}

		// --------------------------------------------------------------
		// This Iso18245MerchantCategoryCode enumeration value as a POJO
		// --------------------------------------------------------------
		
	    /** Simple POJO wrapper class for MCC enumeration */
		public class MerchantCategoryCode implements Serializable {
			
			/** For compatibility when serialized (as pojo or RMI argument) */
			private static final long serialVersionUID = -7870986844454097L;

			/** The MCC enumeration value */
			private Iso18245MerchantCategoryCode mcc;
			
			/** The MCC numeric code (for JSON) */
			@Expose private int code;
			/** The MCC description (for JSON) */
			@Expose private String description;
			
			/** Builds a new wrapper for this MCC. */
			public MerchantCategoryCode (Iso18245MerchantCategoryCode mcc) {
				this.mcc = mcc;
				this.code = mcc.getCode();
				this.description = mcc.getDescription();
			}

			/** Returns the numeric code for this MCC */
			public int getCode() { return code; }
			
			/** Returns the numeric code for this MCC as a String of 4 numerical characters. */
			public String getCodeAsString() { return String.format("%04d", code); } //$NON-NLS-1$
			
			/** Returns the description for this MCC */
			public String getDescription() { return description; }
			
			/** Returns this MCC underlying enumeration value */
			public Iso18245MerchantCategoryCode getMCC() { return mcc; }


			/** Return a Human readable representation of this Country Code. */
			@Override public String toString() {
				return "("+getCodeAsString()+ ") "+ description; //$NON-NLS-1$ //$NON-NLS-2$
			}

		}

		// --------------------------------------------------------------
		// A Iso18245MerchantCategoryCode Taxonomy nested List as a POJO
		// --------------------------------------------------------------

		/** Simple POJO wrapper for a Nested list of Categories. */
		public class MerchantCategoryList implements Serializable, ITaxonomyList {

			/** For compatibility when serialized (as pojo or RMI argument) */
			private static final long serialVersionUID = -3171279055191105982L;
			/** The taxonomy level description */
			@Expose private String label;
			/** The taxonomy level code */
			private int code;
			/** The list of MerchantCategoryList or MerchantCategoryCode, that is one of the ICategory instance underlying List transformed in MerchantCategoryList */
			@Expose private List<?> list;

			/** 
			 * Builds a new Merchant Category nested List 
			 * <p>
			 * @param code the taxonomy level code
			 * @param label the taxonomy level description
			 * @param list the unwrapped list 
			 */
			public MerchantCategoryList(int code, String label, List<?> list) {
				this.code = code;
				this.label = label;
				this.list = list;
			}
			
			// ------------------------------
			// Fulfils ITaxonomyList contract
			// ------------------------------
			
			/** Returns the code for this list level = taxonomy code */
			@Override public int getCode() { return code; }
			
			/** Returns the label for this list level = taxonomy description */
			@Override public String getLabel() { return label; }
			
			/** 
			 * Gets the list for this nested level.
			 * <p>
			 * The list might be a list of List or a List of MerchantCategoryCode for the lowest level 
			 * <br>At the maximum, e.g. for Thomson Reuters classification, the root list = List<List<List<List<List<List<MerchantCategoryCode>>>>>
			 */
			@Override public List<?> getList() { return list; }
			
			/** Return a Human readable representation of this Country Code. */
			@Override public String toString() {
				StringBuffer buf = new StringBuffer();
				buf.append(tab(label + " {")); //$NON-NLS-1$
				for (ListIterator<?> i = list.listIterator(); i.hasNext(); ) {
					Object obj = i.next();
					if (obj instanceof MerchantCategoryList) {
						tabIndex++;
						buf.append(obj);
						tabIndex--;
					} else {
						buf.append(tab("  " + obj)); // Merchant Category Code //$NON-NLS-1$
					}
				}
				buf.append(tab("}")); //$NON-NLS-1$
				return buf.toString();
			}

		}
		
		/** Prefixes <code>str</code> by N tabulation according to static <code>tabIndex</code> value representing the actual list level. */
		private String tab(String str) {
			StringBuffer buf = new StringBuffer();
			for (int j=0; j<=tabIndex; j++) buf.append("  "); //$NON-NLS-1$
			buf.append(str + "\n"); //$NON-NLS-1$
			return buf.toString();
		}
		
		// -------------------------------------------------------------------
		// Internal Helpers: Category (List), Nested List and Sorting Criteria
		// -------------------------------------------------------------------
		
		/** The different List that can be produced. */
		private interface IListType {
			public MerchantCategoryList getMCCList (Comparator<ICategory> listCriterion, Comparator<MerchantCategoryCode> mccCriterion);
			public String getMCCListAsJSON (Comparator<ICategory> listCriterion, Comparator<MerchantCategoryCode> mccCriterion);
		}
		
		/** General Category contract. A category contains a list of MerchantCategoryCode */
	    private interface ICategory extends ITaxonomyList {
	    	public void addMCC(ITaxonomy taxonomy, Iso18245MerchantCategoryCode mcc);
			public void sortList(Comparator<MerchantCategoryCode> criterion);
			public MerchantCategoryList getCategoryList();
	    }
		
	    /** General CategoryList contract. A category list contains either a list of Category (containing a list of MerchantCategoryCode) or a list of CategoryList */
	    private interface ICategoryList extends ICategory {
			public ICategory get (ITaxonomy taxonomy);
			public void addCategory (ICategory category);
	    	public void sortList(Comparator<ICategory> listCriterion, Comparator<MerchantCategoryCode> mccCriterion);
	    }
	    
	    /** The top container fake Taxonomy */
		private static class Container implements ITaxonomy {
			@Override public int getCode() { return -1; }
			@Override public String getDescription() { return Messages.getString("IMerchantCategoryCodes.ContainerTaxonomy.Root"); } //$NON-NLS-1$
			@Override public ITaxonomy getParent() { return null; }
		}
		
		/** Comparator implementation to sort Category list based on description alphabetical order */
	    private static class OrderCategoryByDescription implements Comparator<ICategory> {
	        @Override public int compare(ICategory list, ICategory other) {
	            return list.getLabel().compareTo(other.getLabel());
	        }
	    }
	    
		/** Comparator implementation to sort Category list based on code numerical order */
	    private static class OrderCategoryByCode implements Comparator<ICategory> {
	        @Override public int compare(ICategory list, ICategory other) {
	            return list.getCode() > other.getCode() ? 1 : (list.getCode() < other.getCode() ? -1 : 0);
	        }
	    }

		/** Comparator implementation to sort a MCC list based on description alphabetical order */
	    private static class OrderMCCByDescription implements Comparator<MerchantCategoryCode> {
	        @Override public int compare(MerchantCategoryCode mcc, MerchantCategoryCode other) {
	            return mcc.description.compareTo(other.description);
	        }
	    }

		/** Comparator implementation to sort a MCC list based on code numerical order */
	    private static class OrderMCCByCode implements Comparator<MerchantCategoryCode> {
	        @Override public int compare(MerchantCategoryCode mcc, MerchantCategoryCode other) {
	            return mcc.code > other.code ? 1 : (mcc.code < other.code ? -1 : 0);
	        }
	    }
		
		/** List of MCCs for a specific category (scheme or TRBC). */
	    @SuppressWarnings("serial") private class Category extends ArrayList<MerchantCategoryCode> implements ICategory {
			
			/** This category label = taxonomy description */
	    	private String label;
			/** This category code = taxonomy code */
			private int code;
			
			/** Builds a category listing MCC for the given <code>taxonomy</code> */
			private Category (ITaxonomy taxonomy) {
				this.label = taxonomy.getDescription();
				this.code = taxonomy.getCode();
			}
			
			
			// --------------------------
			// Fulfils ICategory contract
			// --------------------------
			
			/** Gets this category taxonomy label */
			@Override public String getLabel() { return label; }

			/** Gets this category taxonomy code */
			@Override public int getCode() { return code; }
			
			/** Sorts this list with specified Merchant Category Code sorting <code>criterion</code> using {@link java.util.Collections.sort(List<?>, Comparator<?>)}. */
			@Override public void sortList(Comparator<MerchantCategoryCode> criterion) { 
				Collections.sort (this, criterion);
			}

			/** Adds the given <code>mcc</code> to the list of Merchant Category Code for this category. */
			@Override public void addMCC (ITaxonomy taxonomy, Iso18245MerchantCategoryCode mcc) {
				super.add(new MerchantCategoryCode(mcc));
			}

			/** Gets this list as a simple nested list POJO. */
			@Override public MerchantCategoryList getCategoryList() {
				return new MerchantCategoryList (code, label, this);
			}

			/** Simply returns the underlying List. */
			@Override public List<?> getList() { return this; }

	    }
		

		/** List of ICategory instances. */
	    @SuppressWarnings("serial") private class CategoryList extends ArrayList<ICategory> implements ICategoryList  {
			
			/** This list label = taxonomy description */
	    	private String label;
			/** This list code  = taxonomy code */
	    	private int code;
			
			/** Builds a Category container for the given <code>taxonomy</code> */
			private CategoryList (ITaxonomy taxonomy) {
				this.label = taxonomy.getDescription();
				this.code = taxonomy.getCode();
			}
			
			// --------------------------
			// Fulfils ICategory contract
			// --------------------------
			
			/** Gets this list taxonomy label */
			@Override public String getLabel() { return label; }

			/** Gets this list taxonomy code */
			@Override public int getCode() { return code; }

			
			/** Sorts all this list of Category instances with specified Merchant Category Code sorting <code>criterion</code>. */
			@Override public void sortList(Comparator<MerchantCategoryCode> criterion) { 
				for (ListIterator<ICategory> i = this.listIterator(); i.hasNext();) {
					ICategory category = i.next();
					category.sortList(criterion);
				}
			}

			/** Sorts this list with <code>listCriterion</code> and sublist of MCC according to <code>mccCriterion</code>. */
			@Override public void sortList(Comparator<ICategory> listCriterion, Comparator<MerchantCategoryCode> mccCriterion) { 
				Collections.sort (this, listCriterion);
				sortList(mccCriterion);
			}

			/** Adds the given <code>mcc</code> to the category corresponding to <code>taxonomy</code>; creates a new Category if it does not exist yet. */
			@Override public void addMCC(ITaxonomy taxonomy, Iso18245MerchantCategoryCode mcc) {
				ICategory category = get (taxonomy);
				if (category == null) { super.add(createCategory(taxonomy)); }
				category.addMCC(taxonomy, mcc);
			}

			/** Returns a new Category for the given <code>taxonomy</code>. <br>Isolated to let subclass instantiating a different kind of ICategory (e.g. a CategoryList) */
			protected ICategory createCategory(ITaxonomy taxonomy) { return new Category(taxonomy); } 

			/** Returns the category corresponding to <code>taxonomy</code> or null if no Category exists yet for this taxonomy. */
			@Override public ICategory get (ITaxonomy taxonomy) {
				int code = taxonomy.getCode();
				for (ListIterator<ICategory> i = this.listIterator(); i.hasNext(); ) {
					ICategory category = i.next();
					if (category.getCode() == code) return category;
				}
				return null;
			}

			/** Adds a new Category to this underlying list. */
			@Override public void addCategory (ICategory category) { 
				super.add(category);
			}

			/** Gets this list as a simple nested list POJO. */
			@Override public MerchantCategoryList getCategoryList() {
				List<MerchantCategoryList> list = Collections.synchronizedList(new ArrayList<>(this.size())); 
				for (ListIterator<ICategory> i = this.listIterator(); i.hasNext(); ) {
					ICategory category = i.next();
					list.add(category.getCategoryList());
				}
				return new MerchantCategoryList (code, label, list);
			}

			/** Simply returns the underlying List. */
			@Override public List<?> getList() { return this; }

	    }
		
		/** List of (List of) ICategoryList instances. Very simple class that just overrides {@link #createCategory(ITaxonomy)} */
	    @SuppressWarnings("serial") private class ListCategoryList extends CategoryList  {
			
			/** Builds a Category List container for the given <code>taxonomy</code> */
			private ListCategoryList (ITaxonomy taxonomy) {
				super(taxonomy);
			}
			
			/** Returns a new CategoryList for the given <code>taxonomy</code>. <br>Overrides superclass one. */
			@Override protected ICategory createCategory(ITaxonomy taxonomy) { return new CategoryList(taxonomy); } 
						
	    }

	    /** 
	     * Convenient helper to return an instance of <code>cls</code> which can be either assignable from Category, CategoryList or ListCategoryList.
	     * <p>
	     * @param cls the type of the <code>ICategory</code> class to instantiate
	     * @param taxonomy <code>ICategory</code> instance constructor parameter
	     * @param mcc the enclosing class to be able to instantiating <code>cls</code>
	     */
	    private static ICategory getListInstance (Class<?> cls, ITaxonomy taxonomy, Iso18245MerchantCategoryCode mcc) {
	    	ICategory category = null;
			if (cls.isAssignableFrom(ListCategoryList.class)) category = mcc.new ListCategoryList(taxonomy);
			else if (cls.isAssignableFrom(CategoryList.class)) category = mcc.new CategoryList(taxonomy);
			else category = mcc.new Category(taxonomy);
			return category;
	    }
	    
	    
	    /** The common behaviour for a NestedList (either Scheme or Thomson Reuters type) */
	    private abstract class NestedList implements IListType {

	    	/** 
	    	 * Gets the category in <code>container</code> for the given <code>taxonomy</code>.
	    	 * <p> 
	    	 * If the category is not yet existing, created a new container using the specified <code>cls</code> list type
	    	 */
			protected ICategory getOrCreateCategory (ICategoryList container, ITaxonomy taxonomy, Class<?> cls, Iso18245MerchantCategoryCode mcc) {
				ICategory category = container.get(taxonomy);
				if (category == null) {
					category = getListInstance(cls, taxonomy, mcc);
					container.addCategory(category);
				}
				return category;
			}
			
			/** Subclasses must provide the root container. */
			protected abstract ICategoryList getRoot();
			
			/** 
			 * Sorts this NestedList root (recursively for sub-levels) according to given <code>listCriterion</code> and <code>mccCriterion</code>.
			 * <br>Then returns the corresponding Merchant Category nested list wrapper.
			 */
			@Override public MerchantCategoryList getMCCList(Comparator<ICategory> listCriterion, Comparator<MerchantCategoryCode> mccCriterion) {
				ICategoryList root = getRoot();
				root.sortList(listCriterion, mccCriterion);
				return root.getCategoryList();
			}

			/** 
			 * Sorts this NestedList root (recursively for sub-levels) according to given <code>listCriterion</code> and <code>mccCriterion</code>.
			 * <br>Then returns the corresponding JSON representation.
			 * <p>
			 * For instance, here is an extract of corresponding output for Scheme nested list (smart printing option turned on for readability):
			 * <pre>
			 * {
  			 * 	 "label": "ROOT",
  			 *   "list": [
    		 *     {
      		 *       "label": "Agricultural Services",
      		 * 		 "list": [
        	 *         {
          	 * 			 "label": "Contracted Services",
          	 * 			 "list": [
             * 			   {
             *				 "code": 742,
             *				 "description": "Veterinary Services"
             *			   },
             * 			   {
             *				 "code": 763,
             *			     "description": "Agricultural Cooperatives"
             * 			   },
             *			   {
             *				 "code": 780,
             *				 "description": "Horticultural and Landscaping Services"
             *			   }
          	 *			]
             *		  }
      	     * 		]
    		 * 	  },
    		 * 	  {
      		 * 		"label": "Contracted Services",
      		 * 	    "list" : [ ...
			 *
			 * </pre>
			 */
			@Override public String getMCCListAsJSON(Comparator<ICategory> listCriterion, Comparator<MerchantCategoryCode> mccCriterion) {
				ICategoryList root = getRoot();
				root.sortList(listCriterion, mccCriterion);
				return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create().toJson(root.getCategoryList());
			}

	    }
	    
	    /** The specialised NestedList according to Thomson Reuters classification. */
		private class ThomsonReutersNestedList extends NestedList {
			
			/** The root container = a List of ICategoryList in this case */
			private ListCategoryList root = new ListCategoryList(new Container());
			
			/** Fulfils NestedList contract */
			@Override protected ICategoryList getRoot() { return root; }

			/** Adds the given <code>mcc</code> to the nested list, i.e. classifies it according to Thomson Reuters classification (creates parent level(s) if not yet existing). */
			private void add (Iso18245MerchantCategoryCode mcc) {
				TRBCIndustry industry = mcc.getTRBCClassification();
				TRBCIndustryGroup industryGroup = industry.industryGroup;
				TRBCBusinessSector businessSector = industryGroup.businessSector;
				TRBCEconomicSector economicSector = businessSector.economicSector;
				add(root, economicSector, businessSector, industryGroup, industry, mcc);
			}
			
			/** Adds <code>economicSector</code> to <code>container</code> and continues with sub levels (invokes {@link #add(ICategoryList, ITaxonomy, ITaxonomy, ITaxonomy, Iso18245MerchantCategoryCode)}*/
			private void add (ICategoryList container, ITaxonomy economicSector, ITaxonomy businessSector, ITaxonomy industryGroup, ITaxonomy industry, Iso18245MerchantCategoryCode mcc) {
				ICategory category = getOrCreateCategory(container, economicSector, ListCategoryList.class, mcc);
				add ((ICategoryList)category, businessSector, industryGroup, industry, mcc);
			}

			/** Adds <code>businessSector</code> to <code>container</code> and continues with sub levels (invokes {@link #add(ICategoryList, ITaxonomy, ITaxonomy, Iso18245MerchantCategoryCode)}*/
			private void add (ICategoryList container, ITaxonomy businessSector, ITaxonomy industryGroup, ITaxonomy industry, Iso18245MerchantCategoryCode mcc) {
				ICategory category = getOrCreateCategory(container, businessSector, ListCategoryList.class, mcc);
				add ((ICategoryList)category, industryGroup, industry, mcc);
			}

			/** Adds <code>industryGroup</code> to <code>container</code> and continues with sub levels (invokes {@link #add(ICategoryList, ITaxonomy, Iso18245MerchantCategoryCode)}*/
			private void add (ICategoryList container, ITaxonomy industryGroup, ITaxonomy industry, Iso18245MerchantCategoryCode mcc) {
				ICategory category = getOrCreateCategory(container, industryGroup, CategoryList.class, mcc);
				add ((ICategoryList)category, industry, mcc);
			}
			
			/** Adds <code>industry</code> to <code>container</code> and finally add <code>mcc</code> to this industry category. */
			private void add (ICategoryList container, ITaxonomy industry, Iso18245MerchantCategoryCode mcc) {
				ICategory category = getOrCreateCategory(container, industry, Category.class, mcc);
				category.addMCC(industry, mcc);
			}

		}

	    /** The specialised NestedList according to scheme (Mastercard) classification. */
		private class SchemeNestedList extends NestedList {
			
			/** The root container = a ICategoryList in this case */
			private CategoryList root = new CategoryList(new Container());
			
			/** Fulfils NestedList contract */
			@Override protected ICategoryList getRoot() { return root; }

			/** Adds the given <code>mcc</code> to the nested list, i.e. classifies it according to scheme (Mastercard) classification (creates parent level(s) if not yet existing). */
			private void add (Iso18245MerchantCategoryCode mcc) {
				MastercardMerchantCategory category = mcc.getHeadCategory();
				MerchantCategoryRange range = mcc.getCategoryRange();
				add(root, range, category, mcc);
			}
			
			/** Adds <code>mastercardMerchantRange</code> to <code>container</code> and continues with sub levels (invokes {@link #add(ICategoryList, ITaxonomy, Iso18245MerchantCategoryCode)}*/
			private void add (ICategoryList container, ITaxonomy merchantCategoryRange, ITaxonomy mastercardMerchantCategory, Iso18245MerchantCategoryCode mcc) {
				ICategory category = getOrCreateCategory(container, merchantCategoryRange, CategoryList.class, mcc);
				add ((ICategoryList)category, mastercardMerchantCategory, mcc);
			}

			/** Adds <code>mastercardMerchantCategory</code> to <code>container</code> and finally add <code>mcc</code> to this mastercardMerchantCategory. */
			private void add (ICategoryList container, ITaxonomy mastercardMerchantCategory, Iso18245MerchantCategoryCode mcc) {
				ICategory category = getOrCreateCategory(container, mastercardMerchantCategory, Category.class, mcc);
				category.addMCC(mastercardMerchantCategory, mcc);
			}

		}

	}	

}
