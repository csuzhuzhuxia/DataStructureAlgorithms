import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        int left_gas =0;
        boolean[] used = new boolean[length];
        int index = 0;
        int value =-1;
        for (int i = 0; i < length; i++){
            left_gas = gas[i]-cost[i];
            if (left_gas>0){
                if (find(i,gas,cost)){
                    return i;
                }
            }
        }
        return -1;




    }

    private boolean find(int i, int[] gas, int[] cost) {
        int left = 0;
        for (int j = 0; j < gas.length; j++) {
            int index = (i+j)%gas.length;
            left += gas[index]-cost[index];
            if (left<0){
                return false;
            }
        }
        return true;
    }

    private int traceback(int[] gas, int[] cost, int index, List<Integer> rout, int gas_left) {
//        int value = -1;
//        if (rout.size()==gas.length){
//            return rout.get(0);
//        }
//        for (int i = 0; i < cost.length; i++) {
//            int new_index = (index+i)%cost.length;
//            int gas_left_new = gas_left + gas[i]-cost[i];
//            if (gas_left_new>=0){
//                rout.add(new_index);
//                value = traceback(gas,cost,new_index,rout,gas_left+gas[index]-cost[index]);
//                if (value!=-1){
//                    return value;
//                }
//                rout.remove(rout.size()-1);
//            }
//        }
        return -1;
    }
}
