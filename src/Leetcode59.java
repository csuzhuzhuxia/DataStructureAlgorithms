public class Leetcode59 {
    public int[][] generateMatrix(int n) {
        int cur_falg =0;
        int border=0;
        int index=0;
        int[][] res = new int[n][n];
        if (n==2){
            res[0][0]=1;
            res[0][1]=2;
            res[1][1]=3;
            res[1][0]=4;
            return res;
        }


        for (int i = 1; i <= n*n; i++) {
            int line = n-2*border;
            switch (cur_falg){
                case 0:
                    res[border][index+border]=i;
                    if (index+1==line-1){
                        cur_falg=(cur_falg+1)%4;
                    }
                    index++;
                    break;

                case 1:
                    res[border+index-(line-1)][n-1-border]=i;
                    if (index+1==2*(line-1)){
                        cur_falg=(cur_falg+1)%4;
                    }
                    index++;
                    break;
                case 2:
                    res[n-1-border][3*(line-1)-index+border]=i;
                    if (index+1==3*(line-1)){
                        cur_falg=(cur_falg+1)%4;
                    }
                    index++;
                    break;
                case 3:
                    res[4*(line-1)-index+border][border]=i;
                    if (index+1==4*(line-1)){
                        cur_falg=(cur_falg+1)%4;
                        border++;
                        index=0;
                    }else {
                        index++;
                    }


                    break;
            }

        }
        return res;
    }


    public static void main(String[] args) {
        Leetcode59 leetcode59 = new Leetcode59();
        leetcode59.generateMatrix(4);
    }
}
