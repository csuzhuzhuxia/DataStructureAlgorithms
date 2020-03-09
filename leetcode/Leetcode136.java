public class Leetcode136 {
    public int singleNumber(int[] nums) {
        /*
        看到这道题的时候，我的想法就是异或，可能因为之前了解过异或加密解密算法。我们先看一下异或的性质。

        1. 满足交换律：A^B = B^A
        2. 满足结合律：(A^B)^C = A^(B^C)
        3. 0^A = A
        4. A^A = 0
         */
        int a=0;
        for (int i = 0; i < nums.length; i++) {
            a = a ^ nums[i];
        }
        return a;
    }
}
