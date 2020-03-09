import java.util.ArrayList;
import java.util.List;

public class Leetcode68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int lineSum=0;
        int wordsize=0;
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            lineSum+=words[i].length()+(wordsize==0?0:1);
            if (lineSum<=maxWidth){
                wordsize++;
            }else {
                lineSum-=(words[i].length()+1);
                String str = getString(lineSum,i-wordsize,i-1,words,maxWidth);
                res.add(str);
                wordsize=1;
                lineSum=words[i].length();
            }


            if (i==words.length-1){
                String str = getString(lineSum, i-wordsize+1,i,words,maxWidth);
                res.add(str);

            }
        }


        return res;
    }

    private String getString(int lineSum, int start, int end, String[] words, int maxWidth) {
        StringBuilder builder = new StringBuilder();
        if (end==start||end==words.length-1){
            for (int i = start; i <= end; i++) {
                if (i>start){
                    builder.append(" ");
                }
                builder.append(words[i]);
            }
            for (int i = 0; i < (maxWidth-lineSum); i++) {
                builder.append(" ");
            }
        }else {

//            空格数目
            int length = end-start;
//            空格数目
            int every_space_num = (maxWidth-lineSum)/length;
//            左边较大的空格数目
            int left_num = (maxWidth-lineSum)%length;
            for (int i=start;i<=end;i++){
                if (i>start){
                    builder.append(" ");
                    if (i-start<=left_num){
                        builder.append(" ");
                    }
                    for (int j = 0; j < every_space_num; j++) {
                        builder.append(" ");
                    }
                }
                builder.append(words[i]);

            }
        }
        return builder.toString();

    }

    public static void main(String[] args) {
        Leetcode68 leetcode68 = new Leetcode68();
        String[] words={"This", "is", "an", "example", "of", "text", "justification."};
        List<String> res = leetcode68.fullJustify(words,16);
        System.out.println(res);
    }
}
