public class Leetcode4 {
    public double findMedianSortedArrays1(int[] A, int[] B) {
        int length_A = A.length;
        int length_B = B.length;
        int index_A = 0,index_B = 0;
        int ans1=0,ans2=0;
        int flag = (length_A+length_B)/2;
        int index=1;
        while (index_A<length_A&&index_B<length_B){
            //记录两个数
            if (index==flag){
                if (A[index_A]<B[index_B]){
                    ans1 =A[index_A];
                }else {
                    ans1 =B[index_B];
                }
            }
            if (index==flag+1){
                if (A[index_A]<B[index_B]){
                    ans2 =A[index_A];
                }else {
                    ans2 =B[index_B];
                }
            }



            if (A[index_A]<B[index_B]){
                index_A++;
            }else {
                index_B++;
            }
            index++;
        }
        while (index_A<length_A){
            if (index==flag-1){
                ans1 =A[index_A];
            }
            if (index==flag){
                ans2 =A[index_A];
            }
            index_A++;
            index++;
        }

        while (index_B<length_B){
            if (index==flag-1){
                ans1 =B[index_B];
            }
            if (index==flag){
                ans2 =B[index_B];
            }
            index_B++;
            index++;
        }
        if ((length_A+length_B)%2==0){
            return (double) (ans1+ans2)/2;
        }
        return ans2;
    }

    public double findMedianSortedArrays(int[] A, int[] B) {
        int length_A = A.length;
        int length_B = B.length;
        if(length_A>length_B){
            int [] temp = A;	A = B; B = temp;
            int temp_length= length_A;length_A = length_B;length_B = temp_length;
        }
        int left = 0, right = length_A;//我们来求解i，left,right分别来标示i的左右边界
        while(left<=right){
            int i = (left+right)/2;
            int j = (length_A+length_B+1)/2-i;
            if(A[i]<B[j-1]){
                left = i+1;
            }else if(B[j]<A[i-1]){
                right = i-1;
            }else{
                int left_num=0;
                if(i==0){
                    left_num = B[j-1];
                }else if (j==0){
                    left_num = A[i-1];
                }else{
                    left_num = Math.max(A[i-1],B[j-1]);
                }
                if((length_A+length_B)%2==1) return left_num;
                int right_num = 0;
                if(i==length_A) right_num = B[j];
                else if(j==length_B) right_num= A[i];
			else  right_num= Math.min(A[i],B[j]);
                return (left_num+right_num)/2.0;
            }
        }
        return 0.0;
//        int length_A = A.length;
//        int length_B = B.length;
//        if (length_A>length_B){
//            int[] temp = A;
//            A = B;
//            B = temp;
//            int length_temp = length_A;
//            length_A = length_B;
//            length_B = length_temp;
//        }
//
//        int iMin = 0;
//        int iMax = length_A;
//        while (iMin<=iMax){
//            int i = (iMax+iMin)/2;
//            int j = (length_A+length_B+1)/2-i;
//            if (i<iMax&&A[i]<B[j-1]){
//                iMin = i++;
//            }else if (i>iMin&&A[i-1]>B[j]){
//                iMax = i--;
//            }else {
//                int maxLeft =0;
//                if (i==0){
//                    maxLeft = B[j-1];
//                }else if (j==0){
//                    maxLeft = A[i-1];
//                }else
//                    maxLeft = Math.max(A[i-1],B[j-1]);
//                if ((length_A+length_B)%2==1)
//                    return maxLeft;
//
//
//                int maxRight = 0;
//                if (i==length_A){
//                    maxRight = B[j];
//                }else if (j==length_B){
//                    maxRight = A[i];
//                }else
//                    maxRight = Math.max(A[i],B[j]);
//
//                return (maxLeft+maxRight)/2.0;
//            }
//        }
//        return 0.0;
    }
}
