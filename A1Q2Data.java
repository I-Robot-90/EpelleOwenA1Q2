/**
 * Name of class or program (A1Q2Data)
 * COMP 1020 SECTION A03
 * INSTRUCTOR    Rogerio de Leon Pereira
 * ASSIGNMENT    Assignment 1, question 2
 * @author       Owen Epelle, 7930402
 * @version      date of completion
 * PURPOSE: display:
 * • the average total compensation of all these CEOs;
 * • the companies and total compensation of CEOs where their total compensation is greater than the average;
 * • the companies whose CEOs received trivial ($0 or $1) salaries;
 * • the number of CEOs where their awards exceeds the total of their salary and other compensation (that is, awards are more than half their compensation) - display only the count and not the individual companies or amounts; and
 * • all information (each of the four values from the arrays and total compensation) of the top five (the greatest total compensation) CEOs, in order of most to the least total compensation
 */


import java.text.NumberFormat;
import java.util.Arrays;

public class A1Q2Data {
    // Data source: https://monitormag.ca/reports/breakfast-of-champions-ceo-pay-in-2021-hits-new-all-time-high/

    private final String[] COMPANIES = {
            "Fortis Inc",
            "Methanex Corp",
            "Brp Inc",
            "Element Fleet Management Corp",
            "CI Financial Corp",
            "Empire Company Ltd",
            "B2Gold Corp",
            "Shopify Inc",
            "WSP Global Inc",
            "Cenovus Energy Inc",
            "Transalta Corp",
            "Spin Master Corp",
            "Bausch Health Companies Inc",
            "Sun Life Financial Inc",
            "BCE Inc",
            "Imperial Oil",
            "Bank of Nova Scotia",
            "National Bank of Canada",
            "Tc Energy Corp",
            "First Majestic Silver Corp Common",
            "Alimentation Couche-Tard Inc",
            "Celestica Inc",
            "Tilray Inc",
            "Tricon Capital Group Inc",
            "Lightspeed POS Inc",
            "Gfl Environmental Inc",
            "Canaccord Genuity Group Inc",
            "CGI Group Inc",
            "Russel Metals",
            "Stelco Holdings Inc",
            "Barrick Gold Corp",
            "Cae Inc",
            "Pembina Pipeline Corp",
            "Suncor Energy Inc",
            "Shaw Communications Inc",
            "Magna International Inc",
            "Ivanhoe Mines Ltd",
            "Bank of Montreal",
            "Yamana Gold Inc",
            "Intact Financial Corp",
            "Pembina Pipeline Corp",
            "Canada Goose Holdings Inc",
            "Colliers International Group Inc",
            "Dollarama Inc",
            "Canadian Pacific Railway Ltd",
            "Open Text Corp",
            "Manulife Financial Corp",
            "Dye & Durham Ltd",
            "Firstservice Corp",
            "Brookfield Infrastructure Partners LP",
            "Waste Connections Inc",
            "Nutrien Ltd",
            "Ecn Capital Corp",
            "Canadian National Railway Co.",
            "Smartcentres Real Estate Investment Trust",
            "Royal Bank of Canada",
            "Canadian Imperial Bank of Commerce",
            "Royal Bank of Canada",
            "Aecon Group Inc",
            "Canadian Natural Resources Ltd",
            "Toronto-Dominion Bank",
            "Tilray Inc",
            "Enbridge Inc",
            "Ritchie Bros Auctioneers Inc",
            "Rogers Communications Inc",
            "Cameco Corp",
            "Teck Resources Ltd",
            "Kinross Gold Corp",
            "George Weston Ltd",
            "Endeavour Mining Corporation",
            "Transcontinental Inc",
            "Snc-Lavalin Group Inc",
            "Emera Incorporated",
            "CGI Group Inc",
            "Brookfield Asset Management Inc",
            "Power Corp of Canada",
            "Ssr Mining Inc",
            "Telus Corp",
            "Gildan Activewear Inc",
            "Onex Corp",
            "Altagas Ltd",
            "Great-West Lifeco Inc",
            "Nexgen Energy Ltd",
            "Nuvei",
            "Maple Leaf Foods",
            "Canadian Natural Resources Ltd",
            "West Fraser Timber CO Ltd",
            "Primo Water Corp",
            "Canadian Tire Corp",
            "Lightspeed POS Inc",
            "Tfi International Inc",
            "Sun Life Financial Inc",
            "Linamar Corp",
            "Descartes Systems Group Inc",
            "Thomson Reuters Corp",
            "Agnico Eagle Mines Ltd",
            "Bank of Montreal",
            "Brookfield Renewable Partners LP",
            "Restaurant Brands International Inc",
            "Nutrien Ltd"
    };

    private final int[] SALARIES = {
            1378850,
            1299500,
            1166041,
            1000000,
            1125000,
            1124994,
            1300000,
            1,
            1347837,
            1225000,
            250000,
            931679,
            2005600,
            655769,
            1300000,
            968956,
            1300000,
            1125015,
            1000000,
            1504200,
            1716644,
            1190825,
            177580,
            1050433,
            505604,
            1973298,
            850000,
            1004808,
            1191015,
            4056960,
            2256300,
            906847,
            668182,
            1235000,
            2000000,
            407388,
            814775,
            600000,
            2104313,
            1284100,
            1068182,
            331154,
            1628116,
            1275552,
            1496068,
            1116398,
            1518805,
            0,
            1005056,
            700117,
            1128150,
            1106454,
            1566875,
            1090545,
            391993,
            1500000,
            1000000,
            700000,
            1014390,
            616600,
            1450000,
            241114,
            1648679,
            1128150,
            1206980,
            1060900,
            1733850,
            1552356,
            1221000,
            2005600,
            1094547,
            1386884,
            1098077,
            1556353,
            1034739,
            4500000,
            1168262,
            1543750,
            1557233,
            1629550,
            1159510,
            1262000,
            780000,
            818785,
            1214459,
            1,
            984375,
            1152883,
            1100000,
            0,
            1754900,
            863462,
            662337,
            607948,
            1495478,
            1850078,
            1000000,
            948511,
            1153943,
            555769
    };

    private final int[] AWARDS = {
            5392003,
            5421751,
            3576169,
            4500000,
            5581250,
            3093750,
            5000000,
            25070573,
            5824507,
            9624985,
            2800000,
            7217686,
            23579788,
            6500039,
            6000000,
            3447056,
            7547000,
            6420948,
            6000000,
            3386931,
            6712260,
            9025200,
            0,
            4136550,
            26822186,
            31518243,
            6246000,
            6905032,
            4250719,
            0,
            8664192,
            4186216,
            5865000,
            9008397,
            2880650,
            9025200,
            6393475,
            5835000,
            3658325,
            15600000,
            5220000,
            7017984,
            0,
            4589511,
            22049529,
            23035606,
            8622705,
            15292574,
            5341414,
            6102802,
            4666955,
            7060668,
            2695025,
            9101299,
            463042,
            9900000,
            8547840,
            5980000,
            3684000,
            3808590,
            9555010,
            0,
            11122295,
            5345607,
            8500054,
            3872184,
            7504800,
            4439735,
            6105343,
            2711571,
            3292780,
            4200000,
            5500018,
            5768343,
            10467703,
            8421237,
            3504786,
            13111500,
            8095900,
            0,
            4871639,
            5626341,
            17540000,
            138386400,
            4739936,
            6133550,
            2303957,
            4387250,
            2969880,
            10851664,
            4453400,
            4200058,
            3743409,
            5878266,
            8090213,
            9147888,
            8302500,
            8104028,
            13499775,
            11303306
    };

    private final int[] OTHERS = {
            2367503,
            3770209,
            3445372,
            1310000,
            3896924,
            3272611,
            1385375,
            0,
            2074672,
            3143910,
            4726120,
            4242931,
            3106145,
            1390341,
            3843038,
            4334537,
            3332152,
            3114493,
            2813923,
            1939920,
            4396619,
            2923578,
            16975314,
            5435177,
            379967,
            9949057,
            6974643,
            3035620,
            5829336,
            8621040,
            7226196,
            2313175,
            1047403,
            2616394,
            7063419,
            4192958,
            2749866,
            3051894,
            3738363,
            2823004,
            8057185,
            5703989,
            16767312,
            1966352,
            3183384,
            2124652,
            6718676,
            0,
            3502530,
            39648,
            3335223,
            3592587,
            3917188,
            3356373,
            21498575,
            5271877,
            3205210,
            3231000,
            2215000,
            5045898,
            2486296,
            7854901,
            6268994,
            6539742,
            17673285,
            1745000,
            3975100,
            2772979,
            3280046,
            18000597,
            2739334,
            2042743,
            1682449,
            3475241,
            77605,
            579500,
            2311958,
            5167633,
            4892936,
            6267500,
            3242677,
            4445632,
            1666454,
            1573331,
            977799,
            9979200,
            4352300,
            1144462,
            2854315,
            3437,
            9808361,
            6264099,
            10958720,
            942632,
            5224873,
            4695432,
            5573237,
            2006252,
            2856157,
            11273515
    };


    public void totalAverageCompensation(int[] salary, int[] awards, int[] other) {
        System.out.println("THE AVERAGE TOTAL COMPENSATION OF CEOS");
        System.out.println("--------------------------------------");

        int sum = Arrays.stream(salary).sum() + Arrays.stream(awards).sum() + Arrays.stream(other).sum();
        int average = sum / getCOMPANIES().length;
        NumberFormat averageCurrency = NumberFormat.getCurrencyInstance();
        String result = averageCurrency.format(average);
        System.out.println(result);
    }

    public void aboveAverage(String[] companies, int[] salary, int[] awards, int[] other) {
        System.out.println();
        System.out.println("TOTAL COMPENSATION OF CEOS (GREATER THAN AVG TOTAL COMPENSATION)");
        System.out.println("----------------------------------------------------------------");

        int totalSum = Arrays.stream(salary).sum() + Arrays.stream(awards).sum() + Arrays.stream(other).sum();
        int average = totalSum / getCOMPANIES().length;
        for (int i = 0; i < getCOMPANIES().length; i++) {
            int eachCeoSum = salary[i] + awards[i] + other[i];
            if (eachCeoSum > average) {
                NumberFormat ceoSumCurrency = NumberFormat.getCurrencyInstance();
                String result = ceoSumCurrency.format(eachCeoSum);
                System.out.printf("%s\t %s\n", companies[i], result);
            }
        }
    }

    public void trivialSalaries(String[] companies, int[] salaries) {
        System.out.println();
        System.out.println("CEOS WITH TRIVIAL SALARIES");
        System.out.println("--------------------------");

        for (int i = 0; i < getCOMPANIES().length; i++) {
            if (salaries[i] <= 1) {
                System.out.println(companies[i]);
            }
        }
    }

    public void awardsExceedsCompensation(int[] salaries, int[] awards, int[] others) {
        System.out.println();
        System.out.println("NUMBER OF CEOS WITH AWARDS EXCEEDING SALARY AND OTHER COMPENSATIONS");
        System.out.println("-------------------------------------------------------------------");

        int numberOfCeos = 0;
        for (int i = 0; i < getCOMPANIES().length; i++) {
            if (awards[i] > (salaries[i] + others[i])) {
                numberOfCeos++;
            }
        }
        System.out.println(numberOfCeos);
    }

    public void allInfo(String[] companies, int[] salaries, int[] awards, int[] others) {
        System.out.println();
        System.out.println("ALL THE INFORMATION OF THE TOP FIVE CEOS");
        System.out.println("----------------------------------------");

        int ArrayIndexCount = getCOMPANIES().length;
        int[][] eachInfo = new int[ArrayIndexCount][5];

        for (int i = 0; i < ArrayIndexCount; i++) {
            eachInfo[i][0] = i;
            eachInfo[i][1] = salaries[i];
            eachInfo[i][2] = awards[i];
            eachInfo[i][3] = others[i];
            eachInfo[i][4] = salaries[i] + awards[i] + others[i];
        }

        Arrays.sort(eachInfo, (a, b) -> b[4] - a[4]);

        int topFive = 5;
        for (int i = 0; i < topFive; i++) {
            int index = eachInfo[i][0];
            int salary = eachInfo[i][1];
            int award = eachInfo[i][2];
            int other = eachInfo[i][3];
            int totalSum = eachInfo[i][4];

            NumberFormat salariesCurrency = NumberFormat.getCurrencyInstance();
            String resultSalaries = salariesCurrency.format(salary);

            NumberFormat awardsCurrency = NumberFormat.getCurrencyInstance();
            String resultAwards = awardsCurrency.format(award);

            NumberFormat othersCurrency = NumberFormat.getCurrencyInstance();
            String resultOthers = othersCurrency.format(other);

            NumberFormat totalSumCurrency = NumberFormat.getCurrencyInstance();
            String resultTotalSum = totalSumCurrency.format(totalSum);

            System.out.printf("%s\t %s\t %s\t %s\t %s\n\n", companies[index], resultSalaries, resultAwards, resultOthers, resultTotalSum);
        }
    }

    public String[] getCOMPANIES() {
        return COMPANIES;
    }

    public int[] getSALARIES() {
        return SALARIES;
    }

    public int[] getAWARDS() {
        return AWARDS;
    }

    public int[] getOTHERS() {
        return OTHERS;
    }
}