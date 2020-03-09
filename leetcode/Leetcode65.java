public class Leetcode65 {
    public boolean isNumber(String s) {
        s = s.trim();
        int length = s.length();
        boolean isDight=false,isDot=false,isE=false,isFirst=false;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c>='0'&&c<='9'){
                isDight=isFirst=true;
            }else {
                switch (c){
                    case 'e':
                        if (isE||!isDight) return false;
                        isE=true;
                        isDot=true;
                        isFirst = isDight = false;
                        break;
                    case '.':
                        if (isDot) return false;
                        isDot=true;
                        isE=true;
                        isFirst=true;
                        break;
                    case '+':
                    case '-':
                        if (isFirst) return false;
                        isFirst =true;
                        break;
                    default:
                        return false;
                }
            }

        }
        return isDight;

    }

    public static void main(String[] args) {
        Leetcode65 leetcode65 = new Leetcode65();
        System.out.println(leetcode65.isNumber("12  4"));;
    }

}
