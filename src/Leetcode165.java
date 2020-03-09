public class Leetcode165 {

    public int compareVersion(String version1, String version2) {
        String[] v_1 = version1.split("\\.");
        String[] v_2 = version2.split("\\.");
        int length = Math.max(v_1.length,v_2.length);

        for (int i = 0; i < length; i++) {
            int value1=0,value2=0;
            if (i<v_1.length)
                value1 =Integer.parseInt(v_1[i]);
            if (i<v_2.length)
                value2 =Integer.parseInt(v_2[i]);
            if (value1<value2)
                return -1;
            if (value1>value2)
                return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Leetcode165 leetcode165 = new Leetcode165();
        leetcode165.compareVersion("0.1","1.1");
        String s = "1.1.1.";
        String[] strings  = s.split(".");
        System.out.println(1);
    }
}
