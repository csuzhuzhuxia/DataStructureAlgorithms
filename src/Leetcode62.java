public class Leetcode62 {
    public int uniquePaths1(int m, int n) {
        int result = tracaback(m-1,n-1);
        return result;
    }

    private int tracaback(int m, int n) {
        if (m==0&&n==0){
            return 1;
        }else if (m<0||n<0){
            return 0;
        }
        int result1=0,result2=0;
        if (m>0){
            result1 = tracaback(m-1,n);
        }
        if(n>0){
            result2 = tracaback(m,n-1);
        }

        return result1+result2;
    }

    public int uniquePaths(int m, int n) {
        //创建一个m*n的数组矩阵来存储
        int [][] result = new int[m+1][n+1];

        for (int i = 1; i < m+1; i++) {
            result[i][1]=1;
        }

        for (int i = 1; i < n+1; i++) {
            result[1][i]=1;
        }

        for (int i = 2; i <m+1 ; i++) {
            for (int j = 1; j <n+1; j++) {
                result[i][j] = result[i-1][j]+result[i][j-1];
            }
        }
        return result[m][n];

    }
}
