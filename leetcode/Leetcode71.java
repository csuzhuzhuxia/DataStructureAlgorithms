import java.util.ArrayList;
import java.util.Stack;

public class Leetcode71 {
    public String simplifyPath1(String path) {
        String simplePath = "";
        ArrayList<String> strings = new ArrayList<>();

        for(int i=0;i<path.length();i++){
            while(i<path.length()&& path.charAt(i)=='/')
                i++;	//该操作跳过斜线'/'
            if (i==path.length()){
                break;
            }

            int start = i;

            while(i<path.length() && path.charAt(i)!='/')
                i++;

            int end = i;
            String substring = path.substring(start,end);
            System.out.println(substring);
            if(substring.equals("..")){
                if (!strings.isEmpty()){
                    strings.remove(strings.size()-1);
                }
            }else if (!substring.equals(".")){
                strings.add(substring);
            }
        }
        if(strings.isEmpty()){
            simplePath="/";
            return simplePath;
        }

        for (String str:strings) {
            simplePath+="/"+str;
        }
        return simplePath;
    }

    public String simplifyPath(String path) {
        ArrayList<String> strings =new ArrayList<>();
        String[] paths = path.split("/");
        for (String path_item:paths) {
            if(path_item.equals("..")){
                if (!strings.isEmpty()){
                    strings.remove(strings.size()-1);
                }
            }else if(!path_item.equals("")&&!path_item.equals(".")){
                strings.add(path_item);
            }
        }
        if (strings.isEmpty()){
            return "/";
        }
        String simple="";
        for (String str:strings) {
            simple+="/"+str;
        }
        return simple;

    }

    public static void main(String[] args) {
        Leetcode71 leetcode71 = new Leetcode71();
        System.out.println(leetcode71.simplifyPath("/home/"));;
    }
}
