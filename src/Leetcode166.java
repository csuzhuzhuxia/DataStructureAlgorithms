import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Leetcode166 {

    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder builder = new StringBuilder();
        long k = getEasy(numerator,denominator);
        boolean flag = false;
        if ((numerator>0&&denominator>0)||
                (numerator<0&&denominator<0))
            flag=true;

        long long_numerator = Math.abs((long) numerator);
        long long_denominator = (long) Math.abs((double) denominator);


        if (k!=0){
            long_numerator =long_numerator/k;
            long_denominator = long_denominator/k;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        long result = (int)(long_numerator/long_denominator);
        if (long_numerator%long_denominator==0){
            if (flag){
                return "-"+result;
            }
            return result+"";
        }

        long_numerator = long_numerator%long_denominator*10;
        int point = 0;
        int index=0;
        while (long_numerator%long_denominator!=0){
            long value = (long_numerator/long_denominator);
            if (map.containsKey((int)long_numerator)){
                point = map.get((int)long_numerator);
                System.out.println(point);
                break;
            }
            builder.append(value);
            map.put((int)long_numerator,index++);
            long_numerator = long_numerator%long_denominator*10;
        }
        StringBuilder res = new StringBuilder();
        if (long_numerator%long_denominator!=0){
            res.append(result).append(".").append(builder.toString().substring(0,point)).append("(").append(builder.toString().substring(point)).append(")");
        }else {
            if (long_numerator/long_denominator>0){
                res.append(result).append(".").append(builder.toString()).append(long_numerator/long_denominator);
            }

        }

        System.out.println(res.toString());
        if (flag){
            return res.insert(0,"-").toString();
        }
        return res.toString();

    }

    public long getEasy(long x,long y){
        if (y==0)
            return x;
        return getEasy(y,x%y);
    }

    public static void main(String[] args) {
        Leetcode166 leetcode166 = new Leetcode166();
        leetcode166.fractionToDecimal(-2147483648,1);
    }
}
