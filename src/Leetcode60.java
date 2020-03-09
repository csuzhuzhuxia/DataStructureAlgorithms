import java.util.LinkedList;

public class Leetcode60 {
    public String getPermutation(int n, int k) {

        k--;
        StringBuilder builder = new StringBuilder();

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i < n+1; i++) {
            list.add(i);
        }
        for (int i = 0; i < n; i++) {
            int result = k/fact(n-1-i);
            builder.append(list.get(result));
            list.remove(result);
            k=k%fact(n-1-i);
        }
        return builder.toString();
    }

    private int fact(int i) {
        int result=1;
        while (i>=1){
            result*=i;
            i--;
        }
        return result;
    }

    public static void main(String[] args) {
        Leetcode60 leetcode60 = new Leetcode60();
        System.out.println(leetcode60.getPermutation(4,3));;
    }


}
