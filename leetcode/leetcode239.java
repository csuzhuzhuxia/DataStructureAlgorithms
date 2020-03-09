import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class leetcode239 {
    public static int[] maxSlidingWindow(int[] a, int k) {

//        Queue<Integer> queue = new LinkedList();
//        int index = 0;
//        int max = 0;
//        int[] res_max = new int[nums.length-k+1];
//        for (; index < k; index++)
//        {
//            max+=nums[index];
//            queue.add(nums[index]);
//        }
//        res_max[0]=max;
//        for (;index<nums.length;index++)
//        {
//            max -= queue.poll();
//            max += nums[index];
//            res_max[index-k+1] = Math.max(max,res_max[index-k]);
//            queue.add(nums[index]);
//        }
//        return res_max;

        if (a == null || k <= 0) {
            return new int[0];
        }
        int n = a.length;
        int[] r = new int[n-k+1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }
            // q contains index... r contains content
            q.add(i);
            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
            }
        }
        return r;



    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        maxSlidingWindow(nums,3);
    }
}
