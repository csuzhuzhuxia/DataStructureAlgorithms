

public class Leetcode80 {

    public int removeDuplicates1(int[] nums) {
        if (nums.length<2){
            return nums.length;
        }
        int flag = 0;
        int length = nums.length;
        int index=1;
        while (index < length) {
            while (index<length&&nums[index]==nums[index-1]){
                flag++;
                index++;
            }
            if (flag>=2){
                if(index<length){
                    changeNum(nums,index,length,flag-1);
                }
                length-=(flag-1);
                index-=(flag-1);
            }
            flag=0;
            index++;
        }
        for (int i = 0; i < length; i++) {
            System.out.println(nums[i]+"--");
        }
        return length;

    }

    private void changeNum(int[] nums, int index, int length, int offset) {
        for (int i = index; i < length; i++) {
            nums[i-offset] = nums[i];
        }
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length<2){
            return nums.length;
        }
        int pos=2;
        for (int i = 2; i <nums.length ; i++) {
            if (nums[i]!=nums[pos-2]){
                nums[pos++] = nums[i++];
            }
        }
        return  pos;
    }

}
