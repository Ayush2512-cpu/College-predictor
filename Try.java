package sample4.java;

import java.util.ArrayList;

public class Try {
    private String college[] = {"IIT Bombay", "IIT Delhi", "IIT Kanpur", "IIT Kharagpur", "IIT Madras", "IIT Roorkee", "IIT BHU", "IIT Bhubaneswar", "IIT Gandhinagar", "IIT Hyderabad", "IIT Dhanbad", "IIT Indore", "IIT Mandi", "IIT Patna", "IIT Ropar", "IIT Guwahati", "IIT Palakkad", "IIT Tirupati", "IIT Jammu", "IIT Goa", "IIT Jodhpur"};
    private String state[] = {"Maharashtra","New Delhi","Uttar Pradesh","West Bengal","Tamil Nadu","Uttarakhand","Uttar Pradesh","Odisha","Gujarat","Hyderabad","Jharkhand","Madhya Pradesh","Himachal Pradesh","Bihar","Punjab","Assam","Kerala","Andhra Pradesh","Jammu & Kashmir","Goa","Rajasthan"};
    private String nrif[] ={"3","2","4","5","1","6","11","22","24","8","12","10","31","26","25","7","NA","NA","NA","NA","53"};
    private String colfee[] = {"950000","850000","850000","1000000","800000","507040" ,"862350","1000000","1000000","900000","800000","1000000","850000","820000","444700","850000","910800","871760","950000","900000","950000"};
    public ArrayList<String>[] cry(String a[], String k, int r,String w) {
        ArrayList<String> list[] = new ArrayList[4];
        for (int i = 0; i < a.length; i++) {
            if (a[i].equals(k)) {
                if(w.equals("General"))
                list = gcheck(i, r);
                else if(w.equals("OBC"))
                list = ocheck(i, r);
                else if(w.equals("SC/ST"))
                list = scheck(i, r);
                    break;
            }
        }
        return list;
    }

    public ArrayList<String>[] gcheck(int a, int r) {
        int i, j;
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> list2 = new ArrayList<String>();
        ArrayList<String> list3 = new ArrayList<String>();
        ArrayList<String> list4 = new ArrayList<String>();
        ArrayList<String>[] al = new ArrayList[4];
        al[0] = list;
        al[1] = list2;
        al[2] = list3;
        al[3] = list4;
        int b[][] = {{1739, 1940, 3430, 3516, 3308, 4384, 6421, 0, 6671, 5923, 8743, 0, 0, 10497, 8692, 5697, 0, 11424, 12057, 0},
                {3005, 3429, 4681, 4955, 4839, 5261, 6984, 9269, 8122, 6357, 8895, 7971, 9388, 10163, 9826, 6487, 11394, 11814, 12391, 0},
                {63, 93, 217, 283, 188, 412, 796, 2088, 1548, 616, 2856, 0, 0, 2617, 2049, 588, 0, 3551, 5536, 3865, 3110},
                {296, 469, 994, 1417, 722, 3026, 4915, 3299, 1868, 5873, 3635, 5366, 2049, 5057, 0, 7925, 6966, 8916, 0, 6135},
                {0, 0, 0, 0, 0, 567, 0, 1291, 0, 0, 744, 0, 0, 0, 0, 1655, 0, 0, 0, 0, 0},
                {999, 1222, 2108, 2259, 2032, 2748, 4268, 6183, 4476, 3609, 6740, 5279, 7222, 7872, 6838, 3417, 9885, 9179, 10404, 9473, 7783, 9835, 10341},
                {0, 0, 0, 0, 0, 3358, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3971, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 657, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 4403, 6292, 6312, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1198, 0, 0, 0, 0, 0, 0, 0, 2028, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 7112, 0, 0, 0, 10212, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {2028, 0, 1854, 3822, 3612, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        for (int m = 0; m < 20; m++) {
            if (r <= b[a][m]) {
                list.add(college[m]);
                list2.add(state[m]);
                list3.add(nrif[m]);
                list4.add(colfee[m]);
            }
        }
        return al;
    }

    public ArrayList<String>[] ocheck(int a, int r) {
        int i, j;
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> list2 = new ArrayList<String>();
        ArrayList<String> list3 = new ArrayList<String>();
        ArrayList<String> list4 = new ArrayList<String>();
        ArrayList<String>[] al = new ArrayList[4];
        al[0] = list;
        al[1] = list2;
        al[2] = list3;
        al[3] = list4;
        int b[][] = {
                {1118, 1242, 1550, 1743, 1594, 1990, 2757, 0, 3182, 2225, 3224, 0, 0, 3843, 3501, 2343, 0, 4048, 4266, 0},
                {1208, 1329, 1787, 1813, 1690, 1992, 2483, 3095, 2872, 2364, 3033, 2894, 3278, 3450, 3350, 2382, 3969, 3767, 4037, 0},
                {37, 65, 133, 119, 83, 195, 367, 616, 287, 1005, 977, 0, 0, 1010, 288, 1318, 0, 2332, 1662, 1279},
                {296, 469, 994, 1417, 722, 3026, 4915, 3299, 1868, 5873, 3635, 5366, 2049, 5057, 0, 7925, 6966, 8916, 0, 6135},
                {0, 0, 0, 0, 0, 1198, 0, 3691, 0, 0, 5106, 0, 0, 0, 0, 1729, 0, 0, 0, 0, 0},
                {477, 606, 890, 921, 846, 1084, 1680, 2233, 2263, 1260, 2420, 2027, 2915, 2783, 2828, 1358, 3467, 3243, 3828, 3605, 3125},
                {0, 0, 0, 0, 0, 7566, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8643, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 368, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 2771, 3399, 3155, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 844, 0, 0, 0, 0, 0, 0, 0, 2194, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 2512, 0, 0, 0, 3887, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1330, 0, 1717, 1651, 1471, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        for (int m = 0; m < 20; m++) {
            if (r <= b[a][m]) {
                list.add(college[m]);
                list2.add(state[m]);
                list3.add(nrif[m]);
                list4.add(colfee[m]);
            }
        }
        return al;
    }

    public ArrayList<String>[] scheck(int a, int r) {
        int i, j;
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> list2 = new ArrayList<String>();
        ArrayList<String> list3 = new ArrayList<String>();
        ArrayList<String> list4 = new ArrayList<String>();
        ArrayList<String>[] al = new ArrayList[4];
        al[0] = list;
        al[1] = list2;
        al[2] = list3;
        al[3] = list4;
        int b[][] = {
                {604, 753, 1109, 1093, 1133, 1240, 1728, 0, 1775, 1603, 1970, 0, 0, 2100, 1977, 1457, 0, 2263, 2365, 0},
                {661, 681, 1030, 908, 872, 1048, 1276, 1655, 1632, 1214, 1557, 1405, 1723, 1750, 1729, 1178, 1921, 2029, 2090, 0},
                {21, 39, 88, 72, 48, 102, 214, 402, 473, 208, 499, 612, 709, 176, 1023, 1311, 1057, 0, 825, 1079},
                {296,469,994,1417,722,3026,4915,3299,1868,5873,3635,5366,2049,5057,0,7925,6966,8916,0,6135},
                {0, 0, 0, 0, 0, 391, 0, 877, 0, 0, 1077, 0, 0, 0, 0, 503, 0, 0, 0, 0, 0},
                {250, 310, 576, 453, 534, 654, 1046, 1354, 1350, 840, 1380, 1170, 1443, 1700, 1694, 793, 1768, 1895, 2051, 1583, 1731},
                {0, 0, 0, 0, 0, 2096, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2408, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 232, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1720, 1819, 2341, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1394, 0, 0, 0, 0, 0, 0, 0, 559, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 2341, 0, 0, 0, 1720, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {564, 0, 1084, 1079, 866, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        for (int m = 0; m < 20; m++) {
            if (r <= b[a][m]) {
                list.add(college[m]);
                list2.add(state[m]);
                list3.add(nrif[m]);
                list4.add(colfee[m]);
            }
        }
        return al;
    }

}
