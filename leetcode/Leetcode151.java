public class Leetcode151 {
    public String reverseWords(String s) {

        String[] split = s.split(" ");
        StringBuilder builder  = new StringBuilder();
        boolean first = true;
        for (int i = split.length-1; i >=0; i--) {

            if (!split[i].trim().isEmpty()){
                if (!first){
                    builder.append(" ");
                }
                builder.append(split[i]);
                first = true;
            }

        }
        return  builder.toString();


    }

    public static void main(String[] args) {
        Leetcode151 leetcode151 = new Leetcode151();
        leetcode151.reverseWords("the sky is blue");
    }
}
