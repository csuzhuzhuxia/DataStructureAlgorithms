public class Leetcode69 {
    public int mySqrt(int x) {
        if (x==1){
            return 1;
        }else if (x>1&&x<=4){
            return 2;
        }

        int left = 0;
        int right = x/2;

        while (left<right){
            double mid = (left+right)/2;
            if (mid*mid<=x){
                if ((mid+1)*(mid+1)>x){
                    return (int)mid;
                }
                left=(int)mid+1;
            }else {
                right=(int)mid-1;
            }
        }
        return left;

    }

    public static void main(String[] args) {
        Leetcode69 leetcode69 = new Leetcode69();
        System.out.println(leetcode69.mySqrt(2147395599));;
    }
}
