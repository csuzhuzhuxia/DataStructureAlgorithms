import java.util.ArrayList;
import java.util.Comparator;

public class Leetcode179 {


    public String largestNumber(int[] nums) {

        ArrayList<String> strings = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            strings.add(String.valueOf(nums[i]));
        }
        strings.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if ((o1+o2).compareTo(o2+o1)>0)
                    return -1;
                if ((o1+o2).compareTo(o2+o1)<0)
                    return 1;
                return 0;
            }
        });

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < nums.length; i++) {
            builder.append(strings.get(i));
        }
        int pos = 0;
        for (int i = 0; i <builder.toString().length()-1 ; i++) {
            if (builder.toString().charAt(i)=='0'){
                pos++;
            }else
                break;
        }

        return builder.toString().substring(pos);
    }

    public static void main(String[] args) {
        Leetcode179 leetcode179 = new Leetcode179();
        int[] nums = {3,30,34,5,9};
        System.out.println(leetcode179.largestNumber(nums));;
    }
}
