public class KMP {

    public static int KMP(String main,String sub){
        int k = 0;
        int[] next = makeNext(sub);
        int main_length = main.length();
        int sub_length = sub.length();
        int i=0,j=0;
        for (i=0;i<main_length;i++){
            while (j>0&&main.charAt(i)!=sub.charAt(j)){
                j = next[j-1];
            }
            if (main.charAt(i)==sub.charAt(j)){
                j++;
            }
            if (j==sub_length){
                System.out.println("shiftL:"+(i-j+1));
                return i-j+1;
            }
        }
        return -1;
//        String str1 = "1 1";
//        int[] nums = {1,23};
//        nums.length;

//        str1.split();
//        str1.length();
//        System.out.print();
//
//        Integer.parseInt();
//        Pattern occurs with shift:%d\n",(i-m+1)



    }
//
    public static int[] makeNext(String sub){
        int length = sub.length();
        int[] next = new int[length];
        next[0] = 0;
        int k = 0;
        for (int i = 1; i < length ; i++) {
            while (k>0 && sub.charAt(i)!=sub.charAt(k)){
                k = next[k-1];
            }
            if (sub.charAt(i)==sub.charAt(k)){
                k++;
            }
            next[i] = k;
        }
        for (int i:next){
            System.out.print(i);
        }
        System.out.println("\n");

        return next;

    }

    public static void main(String[] args) {
        String main = "ababxabcdabdbababcadfdsss";
        String sub = "abcdabd";
        System.out.println("main:"+main);
        System.out.println("sub:"+sub);
        int shift = KMP(main,sub);
        System.out.println(shift);
    }
}
