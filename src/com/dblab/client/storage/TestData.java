package com.dblab.client.storage;

import com.dblab.client.model.AqlMember;

public class TestData {
/*	private final AqlMember[] regionMember
		= {new AqlMember("Afria", 0, 0, 1), new AqlMember("Asia", 1, 2, 4), new AqlMember("Europe", 2, 5, 10),
		   new AqlMember("North America", 3, 11, 13), new AqlMember("Oceania", 4, 14, 14), 
		   new AqlMember("South America", 5, 15, 16)};
	
	private final AqlMember[] countryMember
		= {new AqlMember("Egypt", 0, 0, 0), new AqlMember("South Africa", 0, 1, 1), new AqlMember("China", 1, 2, 2),
		   new AqlMember("Japan", 1, 3, 3), new AqlMember("South Korea", 1, 4, 4), new AqlMember("France", 2, 5, 5),
		   new AqlMember("Germany", 2, 6, 6), new AqlMember("Italy", 2, 7, 7), new AqlMember("Russia", 2, 8, 8),
		   new AqlMember("Spain", 2, 9, 9), new AqlMember("United Kingdom", 2, 10, 10), new AqlMember("Canada", 3, 11, 11),
		   new AqlMember("Mexico", 3, 12, 12), new AqlMember("United States", 3, 13, 13), new AqlMember("Australia", 4, 14, 14),
		   new AqlMember("Argentina", 5, 15, 15), new AqlMember("Brazil", 5, 16, 16)};
	
	private final AqlMember[] cityMember
		= {new AqlMember("Cairo", 0, 0, 0), new AqlMember("Pretoria", 1, 1, 1), new AqlMember("Beijing", 2, 2, 2),
		   new AqlMember("Tokyo", 3, 3, 3), new AqlMember("Seoul", 4, 4, 4), new AqlMember("Paris", 5, 5, 5),
		   new AqlMember("Berlin", 6, 6, 6), new AqlMember("Rome", 7, 7, 7), new AqlMember("Moscow", 8, 8, 8),
		   new AqlMember("Madrid", 9, 9, 9), new AqlMember("London", 10, 10, 10), new AqlMember("Ottawa", 11, 11, 11),
		   new AqlMember("Mexico City", 12, 12, 12), new AqlMember("Wasington", 13, 13, 13), new AqlMember("Canberra", 14, 14, 14),
		   new AqlMember("Buenos Aires", 15, 15, 15), new AqlMember("Brasilia", 16, 16, 16)};
	
	private final AqlMember[] companyMember
		= {new AqlMember("icCube", 0, 0, 1)};
	
	private final AqlMember[] categoryMember
	 	= {new AqlMember("License", 0, 0, 1), new AqlMember("Support", 0, 2, 4)};
	
	private final AqlMember[] articleMember
		= {new AqlMember("Personal", 0, 0, 1), new AqlMember("Server", 0, 2, 4),
		   new AqlMember("Gold", 1, 0, 1), new AqlMember("Platium", 1, 2, 4),
		   new AqlMember("Silver", 1, 0, 0)};

	private final AqlMember[] yearMember
		= {new AqlMember("2005", 0, 0, 3), new AqlMember("2006", 0, 0, 3),
		   new AqlMember("2007", 0, 0, 3), new AqlMember("2008", 0, 0, 3),
		   new AqlMember("2009", 0, 0, 3), new AqlMember("2010", 0, 0, 3)};

	private final AqlMember[] quarterMember
		= {new AqlMember("Q1", -1, 0, 2), new AqlMember("Q2", -1, 3, 5),
		   new AqlMember("Q3", -1, 6, 8), new AqlMember("Q4", -1, 9, 11)};*/

    	
	private final AqlMember[] regionMember
		= {new AqlMember("Afria", 0, 0, 1, 52600, 68), new AqlMember("Asia", 1, 2, 4, 788250, 227), new AqlMember("Europe", 2, 5, 10, 719700, 386),
		   new AqlMember("North America", 3, 11, 13, 993300, 402), new AqlMember("Oceania", 4, 14, 14, 47400, 48), 
		   new AqlMember("South America", 5, 15, 16, 134400, 107)};

	private final AqlMember[] countryMember
		= {new AqlMember("Egypt", 0, 0, 0, 24700, 34), new AqlMember("South Africa", 0, 1, 1, 27900, 34), new AqlMember("China", 1, 2, 2, 462350, 173),
		   new AqlMember("Japan", 1, 3, 3, 249300, 102), new AqlMember("South Korea", 1, 4, 4, 76600, 52), new AqlMember("France", 2, 5, 5, 122150, 67),
		   new AqlMember("Germany", 2, 6, 6, 166450, 77), new AqlMember("Italy", 2, 7, 7, 104050, 49), new AqlMember("Russia", 2, 8, 8, 122650, 69),
		   new AqlMember("Spain", 2, 9, 9, 78550, 51), new AqlMember("United Kingdom", 2, 10, 10, 1258050, 73), new AqlMember("Canada", 3, 11, 11, 74350, 51),
		   new AqlMember("Mexico", 3, 12, 12, 87100, 62), new AqlMember("United States", 3, 13, 13, 831850, 289), new AqlMember("Australia", 4, 14, 14, 47400, 48),
		   new AqlMember("Argentina", 5, 15, 15, 112350, 40), new AqlMember("Brazil", 5, 16, 16, 21950, 67)};

	private final AqlMember[] cityMember
		= {new AqlMember("Cairo", 0, 0, 0, 24700, 34), new AqlMember("Pretoria", 1, 1, 1, 27900, 34), new AqlMember("Beijing", 2, 2, 2, 462350, 173),
		   new AqlMember("Tokyo", 3, 3, 3, 249300, 102), new AqlMember("Seoul", 4, 4, 4, 76600, 52), new AqlMember("Paris", 5, 5, 5, 122150, 67),
		   new AqlMember("Berlin", 6, 6, 6, 166450, 77), new AqlMember("Rome", 7, 7, 7, 104050, 49), new AqlMember("Moscow", 8, 8, 8, 122650, 69),
		   new AqlMember("Madrid", 9, 9, 9, 78550, 51), new AqlMember("London", 10, 10, 10, 1258050, 73), new AqlMember("Ottawa", 11, 11, 11, 74350, 51),
		   new AqlMember("Mexico City", 12, 12, 12, 87100, 62), new AqlMember("Wasington", 13, 13, 13, 831850, 289), new AqlMember("Canberra", 14, 14, 14, 47400, 48),
		   new AqlMember("Buenos Aires", 15, 15, 15, 112350, 40), new AqlMember("Brasilia", 16, 16, 16, 21950, 67)};

	private final AqlMember[] companyMember
		= {new AqlMember("icCube", 0, 0, 1, 3354150, 1901)};

	private final AqlMember[] categoryMember
 		= {new AqlMember("License", 0, 0, 1, 112600, 992), new AqlMember("Support", 0, 2, 4, 2241550, 909)};

	private final AqlMember[] articleMember
		= {new AqlMember("Personal", 0, 0, 1, 897350, 131), new AqlMember("Server", 0, 2, 4, 215250, 861),
		   new AqlMember("Gold", 1, 0, 1, 727650, 927), new AqlMember("Platium", 1, 2, 4, 886050, 179),
		   new AqlMember("Silver", 1, 0, 0, 627850, 433)};

/*	private final AqlMember[] yearMember
		= {new AqlMember("2005", 0, 0, 3), new AqlMember("2006", 0, 0, 3),
		   new AqlMember("2007", 0, 0, 3), new AqlMember("2008", 0, 0, 3),
		   new AqlMember("2009", 0, 0, 3), new AqlMember("2010", 0, 0, 3)};

	private final AqlMember[] quarterMember
		= {new AqlMember("Q1", -1, 0, 2), new AqlMember("Q2", -1, 3, 5),
		   new AqlMember("Q3", -1, 6, 8), new AqlMember("Q4", -1, 9, 11)};
*/
	
	public AqlMember[] getRegionMember() {
		return regionMember;
	}

	public AqlMember[] getCountryMember() {
		return countryMember;
	}

	public AqlMember[] getCityMember() {
		return cityMember;
	}

	public AqlMember[] getCompanyMember() {
		return companyMember;
	}

	public AqlMember[] getCategoryMember() {
		return categoryMember;
	}

	public AqlMember[] getArticleMember() {
		return articleMember;
	}

	public AqlMember[] getYearMember() {
		/*return yearMember;*/
		return null;
	}

	public AqlMember[] getQuarterMember() {
		/*return quarterMember;*/
		return null;
	}
}
