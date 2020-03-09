public class Leetcode214 {

    public String shortestPalindrome(String s) {
        StringBuilder builder_s = new StringBuilder(s);
        String rev = builder_s.reverse().toString();
        String all = s+"#"+rev;
        int length = s.length()*2+1;
        int[] pal = new int[length];
        pal[0]=0;
        int j=0;
        for (int i = 1; i < length; i++) {
            int k = pal[i-1];
            if(pal[i]==pal[j]){
                pal[i]=k+1;
                i++;
                j++;
            }else {
                while (k>0&&all.charAt(i)!=all.charAt(k)){
                    k = pal[k];
                }
                if(pal[i]==pal[j]){
                    pal[i]=k+1;
                    i++;
                    j++;
                }
            }
        }
        return rev.substring(0,s.length()-pal[length-1])+s;

    }
}
