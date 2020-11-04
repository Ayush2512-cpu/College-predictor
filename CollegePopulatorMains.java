package database;

import model.College;

public class CollegePopulatorMains {

    private static final String fields [] = {"Chemical Engineering",
            "Civil Engineering",
            "Computer Science and Engineering",
            "Electrical Engineering","Electronics and Communication Engineering","Mechanical Engineering","Bio Technology","Artificial intelligence","Biotechnology and Biochemical Engineering","Electrical and Electronics Engineering","Mining Engineering","Aerospace Engineering"};

    private static final String college[] = {"NIT Tiruchirapalli(Trichy)", "NIT Rourkela", "NIT Surathkal", "NIT Warangal", "Motil Lal Nehru National Institute of Technology", "Visvesvaraya NIT", "NIT Calicut", "SVNIT", "NIT Silchar", "NIT Durgapur", "NIT Hamirpur", "NIT Kurukshetra", "Maulana Azad NIT (MANIT)", "Malaviya National Institute of Technology ", "NIT Manipur", "NIT Meghalaya", "NIT Agartala", "NIT Tadepalligudem", "NIT Yupia", "NIT Raipur", "NIT Delhi"};
    private static final String state[] = {"Tamil Nadu","Odisha","Karnataka","Telangana","Uttar Pradesh","Maharashtra","Kerala","Gujarat","Assam","West Bengal","Himachal Pradesh","Haryana","Madhya Pradesh","Rajasthan","Manipur","Meghalaya","Tripura","Andhra Pradesh","Arunachal Pradesh","Chhatisgarh","New Delhi"};
    private static final String nrif[] ={"9","16","13","19","48","27","23","54","46","47","NA","40","65","35","158","61","75","NA","NA","NA","NA"};
    private static final String fees[] = {"950000","850000","850000","1000000","800000","507040" ,"862350","1000000","1000000","900000","800000","1000000","850000","820000","444700","850000","910800","871760","950000","900000","950000"};

    private static final String[] categories = {"general", "obs", "scst"};


    private static final int general[][] = {{0, 18067, 13820, 14401, 0, 0, 23362, 0, 23698,27965,30991, 0, 0, 0, 0,0, 0,36412,0,0},
        {12485, 18067, 17125,15698,19847,23282,22930,26063,33501,27965,27965,30687,25854,26436,24422,40273,38539,37432,0,0,31500,0},
        {666,6472,12646,9329,4329,2498,10965,1126,12909,3421,6537,4902,1934,0,3109,13349,1785,0,0,0,2111},
        {12188,0,10031,8929,0,12160,22259,20453,0,26242,63971,0,16898,10807,0,0,214317,0,0,0,24438},
        {3019,5674, 5112,4755,0,8422,8378,10004,32004,30666,17452,18000, 0, 0, 0,16502, 204170, 0, 0, 0, 20003},
        {20032,36002,31420,25031,22032,42748,15620,18302,22501,18002, 26740, 25279, 17222, 37872, 26838, 43417,19885,29179,0,0,7783},
        {20001,0, 0, 0, 0,23358, 0, 0, 0, 0, 0, 0, 0, 0, 0,33971, 0, 0, 0, 0,0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 4403, 6292, 6312, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0},
        {0,30004,27212, 0, 0, 34516,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

    private static final int obc[][] = {{0, 20067, 16820, 16401, 0, 0, 25362, 0, 25698, 29965, 33991, 0, 0, 0, 0, 0, 0, 38412, 0, 0},
            {13485, 19067, 19125, 19698, 20847, 25282, 25930, 28063, 36501, 29965, 30965, 33687, 28854, 29436, 27422, 42273, 40539, 40432, 0, 0, 33500, 0},
            {1666, 6672, 13646, 9929, 4629, 2898, 12965, 1226, 13909, 3621, 6937, 5002, 2334, 0, 3509, 18349, 1985, 0, 0, 0, 2211},
            {15188, 0, 12031, 9229, 0, 13160, 24259, 22453, 0, 28242, 65971, 0, 19898, 15807, 0, 0, 215317, 0, 0, 0, 23438},
            {3519, 5974, 5912, 5055, 0, 8922, 8998, 15004, 35004, 35666, 19452, 20000, 0, 0, 0, 18502, 224170, 0, 0, 0, 22003},
            {25032, 38002, 37420, 28031, 25032, 45748, 19620, 20302, 25501, 19002, 28740, 29279, 19222, 40872, 28838, 50417, 20885, 30179, 0, 0, 7983},
            {25001, 0, 0, 0, 0, 25358, 0, 0, 0, 0, 0, 0, 0, 0, 0, 39971, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 4903, 16292, 16312, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 32004, 30212, 0, 0, 45516, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

    private static final int scst[][] =  {{0, 22067, 19820, 19401, 0, 0, 27362, 0, 29698,30965,35991, 0, 0, 0, 0,0, 0,40412,0,0},
            {15485, 20067, 20125,21698,26847,27282,27930,30063,38501,30965,32965,35687,31854,30436,29422,45273,42539,43432,0,0,35500,0},
            {1966,6972,15646,10029,4929,3098,13965,1526,15909,3821,7067,5102,2534,0,3711,19349,2065,0,0,0,2312},
            {16188,0,14031,9629,0,15160,25259,26453,0,29242,68971,0,20898,16807,0,0,216317,0,0,0,24620},
            {3619,6074, 6012,5255,0,9022,9098,16004,37004,37666,20452,20950, 0, 0, 0,20502, 225180, 0, 0, 0, 22305},
            {26032,40002,39420,29031,26032,46748,20620,21302,27501,20002, 29740, 30279, 19924, 42972, 29858, 51427,22885,32179,0,0,8083},
            {26001,0, 0, 0, 0,27358, 0, 0, 0, 0, 0, 0, 0, 0, 0,40971, 0, 0, 0, 0,0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 5003, 17292, 18312, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0},
            {0,33056,31522, 0, 0, 45918,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };

    public static final String type = "mains";

    public static void populate(CollegeDAO collegeDAO) throws Exception {

        int[][] ranksByCategory = null;
        for(String category : categories){
            switch(category){
                case "general":
                    ranksByCategory = general;
                    break;
                case "obc" :
                    ranksByCategory = obc;
                    break;
                case "scst":
                    ranksByCategory = scst;
                    break;
                default:
                    System.out.print("Unknown Category : " + category);
            }

            for(int i=0; i<college.length; i++){
                String name = college[i];
                String st = state[i];
                int nrif_rank = Integer.parseInt(nrif[i]);
                int fee = Integer.parseInt(fees[i]);

                for(int j=0; j<fields.length; j++){
                    String field  = fields[j];

                    int rank = ranksByCategory[j][i];

                    College college = new College( name,  st,  nrif_rank,  fee, type, field,  category, rank);

                    System.out.println(college);
                    collegeDAO.insert(college);
                }
            }
        }


    }
}