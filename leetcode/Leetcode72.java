public class Leetcode72 {
    public int minDistance(String word1, String word2) {

        int length1 = word1.length();
        int length2 = word2.length();
        int[][] result = new int[length1+1][length2+1];
        result[0][0] = 0;
        for (int i = 1; i <length1+1;i++) {
            result[i][0] = result[i-1][0]+1;
        }
        for (int i = 1; i <length2+1; i++) {
            result[0][i] = result[0][i-1]+1;
        }

        for (int i = 1; i < length1+1 ; i++) {
            for (int j = 1; j < length2+1; j++) {
                int distance1 = result[i-1][j-1]+(word1.charAt(i-1)==word2.charAt(j-1)?0:1);
                int distance2 = result[i-1][j]+1;
                int distance3 = result[i][j-1]+1;
                result[i][j] = Math.min(Math.min(distance1,distance2),distance3);
            }
        }
        return result[length1][length2];

//        int length1 =word1.length();
//        int length2 =word2.length();
//
//        int[][] result = new int[length1+1][length2+1];
//        result[0][0]=0;
//        for (int i = 1; i < length1+1; i++) {
//            result[i][0] = i;
//        }
//        for (int i = 1; i < length2+1; i++) {
//            result[0][i]= i;
//        }
//
//
//
//        for (int i = 1; i <length1+1 ; i++) {
//            for (int j = 1; j < length2+1; j++) {
//                int distance1 = result[i-1][j-1]+(word1.charAt(i-1)==word2.charAt(j-1)?0:1);
//                int distance2 = result[i-1][j]+1;
//                int distance3 = result[i][j-1]+1;
//                result[i][j] = Math.min(Math.min(distance1,distance2),distance3);
//            }
//        }
//        return result[length1][length2];

    }


    public static void main(String[] args) {
        Leetcode72 leetcode72 =new Leetcode72();
        System.out.println(leetcode72.minDistance("123","1"));;
    }
}
