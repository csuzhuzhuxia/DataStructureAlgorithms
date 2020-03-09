public class Leetcode66 {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        int carry =1;
        for (int i = length-1; i >=0 ; i--) {
            int temp =digits[i];
            digits[i]=(temp+carry)%10;
            carry=(temp+carry)/10;
            if (carry==0){
                return digits;
            }
        }
        if (carry==1){
            int[] resutl = new int[length+1];
            resutl[0]=1;
            return resutl;
        }
        return digits;

    }
}
