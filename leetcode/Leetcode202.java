import java.util.HashSet;
import java.util.Set;

public class Leetcode202 {

    public boolean isHappy1(int n) {
        Set<Integer> set = new HashSet<>();
        while(!set.contains(n)){
            set.add(n);
            int num = 0;
            while (n>0){
                num+=Math.pow(n,2);
                n = n/10;
            }
            n = num;
            if (n==1)
                return true;
        }
        return false;
    }

    public boolean isHappy(int n) {
        int low=-1,fast =0;
        low = get_new(n);
        fast = get_new(n);
        fast = get_new(fast);

        while (low!=fast){
            if (low==1||fast==1)
                return true;
            low = get_new(n);
            fast = get_new(n);
            fast = get_new(fast);

        }
        return low==1;
    }

    private int get_new(int n) {
        int num = 0;
        while (n>0){
            num+=Math.pow(n,2);
            n = n/10;
        }
        return num;
    }


}
