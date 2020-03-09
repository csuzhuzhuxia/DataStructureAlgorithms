public class Leetcode88 {
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int index_m = 0;
        int index_n =0;
        int start_n = 0;
        while (index_n<n) {
            while (index_n<n&&nums2[index_n]<nums1[index_m]){
                index_n++;
            }
            insert_nums1(nums1,index_m,nums2,start_n,index_n-start_n,m);
            if (index_n==n){
                return;
            }
            m+=(index_n-start_n);
            index_m+=(index_n-start_n);
            start_n = index_n;

            while (index_m<m&&nums2[index_n]>=nums1[index_m]){
                index_m++;
            }
            if (index_m==m){
                insert_nums1(nums1,index_m,nums2,start_n,n-start_n,m);
                System.out.println("ss");
                return;
            }
        }
    }

    private void insert_nums1(int[] nums1, int index_m, int[] nums2, int start_n, int size_n,int size_m) {
        for (int i = size_m-1; i >=index_m; i--) {
            nums1[i+size_n] = nums1[i];
        }

        for (int i = 0; i < size_n; i++) {
            nums1[index_m+i] = nums2[start_n+i];
        }
    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1=m-1,index2=n-1;
        int size =0;
        while (index1>=0&&index2>=0){
            nums1[m+n-1-size] = nums1[index1]<nums2[index2]?nums2[index2--]:nums1[index1--];
            size++;
        }



    }

    public static void main(String[] args) {
        Leetcode88 leetcode88 =  new Leetcode88();
        int[] num1 = {2,0};
        int[] num2 = {1};
        leetcode88.merge(num1,1,num2,1);
    }
}
