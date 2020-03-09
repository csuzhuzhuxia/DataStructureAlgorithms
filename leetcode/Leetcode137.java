public class Leetcode137 {
    public int singleNumber1(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int sum =0;
            for (int num:nums) {
                if ((num>>i&1)!=0){
                    sum++;
                }
            }
            if (sum%3!=0){
                ans|=(1<<i);
            }
        }
        return ans;

    }

    public int singleNumber(int[] nums) {
        int one=0 ,two =0;
        for (int num:nums) {
            one = (one^num)^(~two);
            two = (two^num)^(~one);
        }
        return one;
    }

}
