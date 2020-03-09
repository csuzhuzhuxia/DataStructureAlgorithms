import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test1225 {



    public int[] get(int[] nums){

        Stack<Integer> stack= new Stack<>();
        for (int num:nums) {
            stack.push(num);
        }

        Queue<Integer> queue  = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            queue.add(i);
        }
        int[] res = new int[nums.length];
        int index =0;//判断奇偶
        while (!queue.isEmpty()){
            if(index%2==0){
                int index_1 = queue.poll();
                res[index_1] = stack.pop();
            }else {
                int index_1 = queue.poll();
                queue.add(index_1);
            }
            index++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {13,12,11,10,9,8,7,6,5,4,3,2,1};
        Test1225 test1225 = new Test1225();
        int[] res = test1225.get(nums);
        for (int num:res) {
            System.out.print(num+"--");
        }
    }
}
