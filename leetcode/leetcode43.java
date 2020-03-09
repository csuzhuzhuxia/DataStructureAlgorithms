public class leetcode43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0")||num2.equals("0")){
            return "0";
        }
        String str_num1 = reverseString(num1);
        String str_num2 = reverseString(num2);

        int length1 = str_num1.length();
        int length2 = str_num2.length();
        StringBuilder result=new StringBuilder("");
        int c = 0;

        for (int i = 0; i < length1+length2-1; i++) {
            int temp = c;
            for (int j=0;j<=i;j++){
                int a = j<str_num1.length()?str_num1.charAt(j)-'0':0;
                int b = i-j<str_num2.length()?str_num2.charAt(i-j)-'0':0;
                temp +=a*b;
            }
            result.insert(0,(temp)%10);
            c = temp/10;
        }
        if (c!=0)
            result.insert(0,c);
        return result.toString();


    }



    private String reverseString(String num1) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < num1.length(); i++) {
            stringBuilder.append(num1.charAt(num1.length()-1-i));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        leetcode43 leetcode43 = new leetcode43();
        System.out.println(leetcode43.multiply("433","43"));;
//        System.out.println(Math.pow(10,2));
    }


}
