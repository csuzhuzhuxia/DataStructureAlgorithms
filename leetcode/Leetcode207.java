import java.util.HashSet;
import java.util.Set;

public class Leetcode207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[][] line =  new boolean[numCourses][numCourses];
        int length = prerequisites.length;
        if(length==0)
            return true;
        for(int i=0;i<length;i++)
        {
            line[prerequisites[i][0]][prerequisites[i][1]]=true;
        }
        Set<Integer> used_set = new HashSet<>();
        for(int i=0;i<numCourses;i++)
        {
            Set<Integer> set = new HashSet<>();
            if(!searchSDF(line,set,i,used_set))
                return false;
            used_set.add(i);
        }

        return true;
    }
    public boolean searchSDF(boolean[][] line,Set<Integer> set,int index,Set<Integer> used_set)
    {
        for(int i=0;i<line.length;i++)
        {
            if(line[index][i]&&!used_set.contains(i))
            {
                if(set.contains(i))
                {
                    return false;
                }
                set.add(i);
                if(!searchSDF(line,set,i,used_set)){
                    return false;
                }
                set.remove(i);
            }
        }
        return true;
    }


    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        boolean[][] line =  new boolean[numCourses][numCourses];
        int length = prerequisites.length;
        if(length==0)
            return true;
        for(int i=0;i<length;i++)
        {
            line[prerequisites[i][0]][prerequisites[i][1]]=true;
        }
        int[] flag = new int[numCourses];
        for(int i=0;i<numCourses;i++)
        {
            if(!searchSDF1(line,flag,i))
                return false;
        }
        return true;

    }
    public boolean searchSDF1(boolean[][] line,int[] flag ,int index)
    {
        if(flag[index]==1)
            return true;
        if(flag[index]==2)
        {
            return false;
        }
        for(int i=0;i<line.length;i++)
        {
            if(line[index][i]){
                flag[index]=2;
                if(!searchSDF1(line,flag,i))
                    return false;
            }
        }
        flag[index] = 1;
        return true;
    }



}
