package org.iso4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.iso4j.ICountries.Iso3166CountryCode;
import org.iso4j.ICurrencies.Iso4217CurrencyCode;
import org.iso4j.ILanguages.Iso639LanguageCode;
import org.iso4j.IMerchantCategoryCodes.Iso18245MerchantCategoryCode;
import org.iso4j.IMerchantCategoryCodes.Iso18245MerchantCategoryCode.MerchantCategoryCode;
import org.iso4j.IMerchantCategoryCodes.Iso18245MerchantCategoryCode.MerchantCategoryList;

public class Test {

	private static void testCountries(PrintStream out) {
		out.println();
		out.println();
		out.println("*******************************");
		out.println("*          Countries          *");
		out.println("*******************************");
		Iso3166CountryCode[] countries = Iso3166CountryCode.values();
		for (int i=0 ; i<countries.length; i++) out.println(countries[i]);
		out.println();
		out.println();
	}
	
	private static void testCurrencies(PrintStream out) {
		out.println();
		out.println();
		out.println("*******************************");
		out.println("*          Currencies         *");
		out.println("*******************************");
		Iso4217CurrencyCode[] currencies = Iso4217CurrencyCode.values();
		for (int i=0 ; i<currencies.length; i++) out.println(currencies[i]);
		out.println(Iso4217CurrencyCode.getAmountWithSymbol(Iso4217CurrencyCode.EUR, 45600, 2));
		out.println(Iso4217CurrencyCode.getAmountWithSymbol(Iso4217CurrencyCode.USD, new BigDecimal(BigInteger.valueOf(45600), 2)));
		out.println();
		out.println();
	}
	
	private static void testLanguages(PrintStream out) {
		out.println();
		out.println();
		out.println("*******************************");
		out.println("*        Language codes       *");
		out.println("*******************************");
		Iso639LanguageCode[] languages = Iso639LanguageCode.values();
		for (int i=0 ; i<languages.length; i++) out.println(languages[i]);
		out.println();
		out.println();
	}
	
	private static void testMCC(PrintStream out) {
		out.println();
		out.println();
		out.println("*******************************");
		out.println("*            MCC              *");
		out.println("*******************************");
		//testEnum(out);
		//testFlatListCode(out);
		//testFlatListDesc(out);
		//testSchemeNestedListCodeCode(out);
		//testSchemeNestedListCodeDesc(out);
		//testSchemeNestedListDescCode(out);
		//testSchemeNestedListDescDesc(out);
		//testSchemeNestedListJsonCodeCode(out);
		//testSchemeNestedListJsonCodeDesc(out);
		//testSchemeNestedListJsonDescCode(out);
		//testSchemeNestedListJsonDescDesc(out);
		//testTRBCNestedListCodeCode(out);
		//testTRBCNestedListCodeDesc(out);
		//testTRBCNestedListDescCode(out);
		//testTRBCNestedListDescDesc(out);
		//testTRBCNestedListJsonCodeCode(out);
		//testTRBCNestedListJsonCodeDesc(out);
		//testTRBCNestedListJsonDescCode(out);
		//testTRBCNestedListJsonDescDesc(out);
		
	}
	
	private static void testEnum(PrintStream out) {
		out.println();
		out.println();
		out.println("---------------------------------------------");
		out.println(" MCC enumeration values");
		out.println("---------------------------------------------");
		Iso18245MerchantCategoryCode[] mccs = Iso18245MerchantCategoryCode.values();
		for (int i=0 ; i<mccs.length; i++) out.println(mccs[i]);
		out.println();
		out.println();
	}
	
	private static void testFlatListCode(PrintStream out) {
		out.println();
		out.println();
		out.println("---------------------------------------------");
		out.println(" MCC flat list ordered by code ");
		out.println("---------------------------------------------");
		List<MerchantCategoryCode> flatListCode = Iso18245MerchantCategoryCode.getFlatListOrderedByCode();
		out.println(flatListCode);
		out.println();
		out.println();
	}

	private static void testFlatListDesc(PrintStream out) {
		out.println();
		out.println();
		out.println("---------------------------------------------");
		out.println(" MCC flat list ordered by description ");
		out.println("---------------------------------------------");
		List<MerchantCategoryCode> flatListDesc = Iso18245MerchantCategoryCode.getFlatListOrderedByDescription();
		out.println(flatListDesc);
		out.println();
		out.println();
	}

	private static void testSchemeNestedListCodeCode(PrintStream out) {
		out.println();
		out.println();
		out.println("---------------------------------------------");
		out.println(" MCC Scheme nested list (code, code) ");
		out.println("---------------------------------------------");
		MerchantCategoryList list = Iso18245MerchantCategoryCode.getSchemeNestedListOrderedByCodeWithListOrderedByCode();
		out.println(list);
		out.println();
		out.println();
	}
	
	private static void testSchemeNestedListCodeDesc(PrintStream out) {
		out.println();
		out.println();
		out.println("---------------------------------------------");
		out.println(" MCC Scheme nested list (code, desc) ");
		out.println("---------------------------------------------");
		MerchantCategoryList list = Iso18245MerchantCategoryCode.getSchemeNestedListOrderedByDescriptionWithListOrderedByCode();
		out.println(list);
		out.println();
		out.println();
	}
	
	private static void testSchemeNestedListDescCode(PrintStream out) {
		out.println();
		out.println();
		out.println("---------------------------------------------");
		out.println(" MCC Scheme nested list (desc, code) ");
		out.println("---------------------------------------------");
		MerchantCategoryList list = Iso18245MerchantCategoryCode.getSchemeNestedListOrderedByCodeWithListOrderedByDescription();
		out.println(list);
		out.println();
		out.println();
	}

	private static void testSchemeNestedListDescDesc(PrintStream out) {
		out.println();
		out.println();
		out.println("---------------------------------------------");
		out.println(" MCC Scheme nested list (desc, desc) ");
		out.println("---------------------------------------------");
		MerchantCategoryList list = Iso18245MerchantCategoryCode.getSchemeNestedListOrderedByDescriptionWithListOrderedByDescription();
		out.println(list);
		out.println();
		out.println();
	}
	

	private static void testSchemeNestedListJsonCodeCode(PrintStream out) {
		out.println();
		out.println();
		out.println("---------------------------------------------");
		out.println(" MCC Scheme JSON nested list (code, code) ");
		out.println("---------------------------------------------");
		String json = Iso18245MerchantCategoryCode.getSchemeNestedListAsJsonOrderedByCodeWithListOrderedByCode();
		out.println(json);
		out.println();
		out.println();
	}
	
	private static void testSchemeNestedListJsonCodeDesc(PrintStream out) {
		out.println();
		out.println();
		out.println("---------------------------------------------");
		out.println(" MCC Scheme JSON nested list (code, desc) ");
		out.println("---------------------------------------------");
		String json = Iso18245MerchantCategoryCode.getSchemeNestedListAsJsonOrderedByDescriptionWithListOrderedByCode();
		out.println(json);
		out.println();
		out.println();
	}
	
	private static void testSchemeNestedListJsonDescCode(PrintStream out) {
		out.println();
		out.println();
		out.println("---------------------------------------------");
		out.println(" MCC Scheme JSON nested list (desc, code) ");
		out.println("---------------------------------------------");
		String json = Iso18245MerchantCategoryCode.getSchemeNestedListAsJsonOrderedByCodeWithListOrderedByDescription();
		out.println(json);
		out.println();
		out.println();
	}

	private static void testSchemeNestedListJsonDescDesc(PrintStream out) {
		out.println();
		out.println();
		out.println("---------------------------------------------");
		out.println(" MCC Scheme JSON nested list (desc, desc) ");
		out.println("---------------------------------------------");
		String json= Iso18245MerchantCategoryCode.getSchemeNestedListAsJsonOrderedByDescriptionWithListOrderedByDescription();
		out.println(json);
		out.println();
		out.println();
	}
	

	private static void testTRBCNestedListCodeCode(PrintStream out) {
		out.println();
		out.println();
		out.println("---------------------------------------------");
		out.println(" MCC TRBC nested list (code, code) ");
		out.println("---------------------------------------------");
		MerchantCategoryList list = Iso18245MerchantCategoryCode.getThomsonReutersNestedListOrderedByCodeWithListOrderedByCode();
		out.println(list);
		out.println();
		out.println();
	}
	
	private static void testTRBCNestedListCodeDesc(PrintStream out) {
		out.println();
		out.println();
		out.println("---------------------------------------------");
		out.println(" MCC TRBC nested list (code, desc) ");
		out.println("---------------------------------------------");
		MerchantCategoryList list = Iso18245MerchantCategoryCode.getThomsonReutersNestedListOrderedByDescriptionWithListOrderedByCode();
		out.println(list);
		out.println();
		out.println();
	}
	
	private static void testTRBCNestedListDescCode(PrintStream out) {
		out.println();
		out.println();
		out.println("---------------------------------------------");
		out.println(" MCC TRBC nested list (desc, code) ");
		out.println("---------------------------------------------");
		MerchantCategoryList list = Iso18245MerchantCategoryCode.getThomsonReutersNestedListOrderedByCodeWithListOrderedByDescription();
		out.println(list);
		out.println();
		out.println();
	}

	private static void testTRBCNestedListDescDesc(PrintStream out) {
		out.println();
		out.println();
		out.println("---------------------------------------------");
		out.println(" MCC TRBC nested list (desc, desc) ");
		out.println("---------------------------------------------");
		MerchantCategoryList list = Iso18245MerchantCategoryCode.getThomsonReutersNestedListOrderedByDescriptionWithListOrderedByDescription();
		out.println(list);
		out.println();
		out.println();
	}
	

	private static void testTRBCNestedListJsonCodeCode(PrintStream out) {
		out.println();
		out.println();
		out.println("---------------------------------------------");
		out.println(" MCC TRBC JSON nested list (code, code) ");
		out.println("---------------------------------------------");
		String json = Iso18245MerchantCategoryCode.getThomsonReutersNestedListAsJsonOrderedByCodeWithListOrderedByCode();
		out.println(json);
		out.println();
		out.println();
	}
	
	private static void testTRBCNestedListJsonCodeDesc(PrintStream out) {
		out.println();
		out.println();
		out.println("---------------------------------------------");
		out.println(" MCC TRBC JSON nested list (code, desc) ");
		out.println("---------------------------------------------");
		String json = Iso18245MerchantCategoryCode.getThomsonReutersNestedListAsJsonOrderedByDescriptionWithListOrderedByCode();
		out.println(json);
		out.println();
		out.println();
	}
	
	private static void testTRBCNestedListJsonDescCode(PrintStream out) {
		out.println();
		out.println();
		out.println("---------------------------------------------");
		out.println(" MCC TRBC JSON nested list (desc, code) ");
		out.println("---------------------------------------------");
		String json = Iso18245MerchantCategoryCode.getThomsonReutersNestedListAsJsonOrderedByCodeWithListOrderedByDescription();
		out.println(json);
		out.println();
		out.println();
	}

	private static void testTRBCNestedListJsonDescDesc(PrintStream out) {
		out.println();
		out.println();
		out.println("---------------------------------------------");
		out.println(" MCC TRBC JSON nested list (desc, desc) ");
		out.println("---------------------------------------------");
		String json= Iso18245MerchantCategoryCode.getThomsonReutersNestedListAsJsonOrderedByDescriptionWithListOrderedByDescription();
		out.println(json);
		out.println();
		out.println();
	}

	private static String getFinalFileName(String path) {
		File tmp = new File (path);
		String date = new SimpleDateFormat("YYYY-MMDDThh:mm:ss.ss").format(Calendar.getInstance());
		String name = tmp.getName();
		String extWDot = name.substring(name.lastIndexOf("."));
		String nameWoExt = name.substring(0, name.lastIndexOf("."));
		String fileName = nameWoExt + "_" + date + extWDot ;
		return fileName;
	}
	
	
	private static PrintStream getPrintStream(String path) {
		PrintStream printer = null;
		String fileName = getFinalFileName(path);
		File file = new File(fileName); 
		FileOutputStream os = null;
		try {
			os = new FileOutputStream(file);
			printer = new PrintStream(os, true);
		} catch (FileNotFoundException e) {
			printer = System.out;
			printer.println("Cannot create file (" +  path + "), use console");
		} 
		return printer;
	}
	
	public static void main(String[] args) {

		PrintStream printer = null;
		if (args.length == 0) printer = System.out;
		else printer = getPrintStream(args[0]); 

		String step = null;
		try {
			//step = "ISO 3166 Country Code"; testCountries(printer);
			//step = "ISO 4217 Currency Code"; testCurrencies(printer);
			//step = "ISO 639 Language Code"; testLanguages(printer);
			//step = "ISO 18245 Merchant Category Code"; testMCC(printer);
		} catch (Throwable e) {
			printer.println("Caught unexpected error while testing " + step);
			e.printStackTrace(printer);
		}

	}

}
