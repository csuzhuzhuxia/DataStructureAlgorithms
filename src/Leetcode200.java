public class Leetcode200 {



    public int numIslands(char[][] grid) {
        int height = grid.length;
        if(height==0)
            return 0;
        int width = grid[0].length;
        if(width==0)
            return 0;
        boolean[][] isUsed = new boolean[height][width];
        int index =0;
        for(int i=0;i<height;i++)
        {
            for(int j=0;j<width;j++)
                if(grid[i][j]=='1'&&!isUsed[i][j])
                {
                    search(i,j,grid,isUsed);
                    index+=1;
                }
        }
        return index;
    }

    public void search(int i,int j,char[][] grid,boolean[][] isUsed)
    {
        if(i<0||j<0||i==grid.length||j==grid[0].length){
            return;
        }
        if(grid[i][j]=='0'||isUsed[i][j])
            return;
        isUsed[i][j] = true;
        search(i+1,j,grid,isUsed);
        search(i-1,j,grid,isUsed);
        search(i,j+1,grid,isUsed);
        search(i,j-1,grid,isUsed);
    }


    //查并集
    public int numIslands111(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int height = grid.length;
        int width = grid[0].length;
        int[] rank = new int[height*width];
        int[] parent = new int[height*width];
        int nums = 0;
        for(int i=0;i<height;i++)
        {
            for(int j=0;j<width;j++)
            {
                if(grid[i][j]=='1')
                {
                    parent[i*width+j]=i*width+j;
                    nums++;
                }

                rank[i*width+j]=0;
            }
        }
        for(int i=0;i<height;i++)
        {
            for(int j=0;j<width;j++)
            {
                if(grid[i][j]!='0'){
                    grid[i][j] ='0';
                    if(i+1<height&&grid[i+1][j]=='1'){
                        if(union(parent,rank,i*width+j,(i+1)*width+j))
                            nums--;
                    }
                    if(j+1<width&&grid[i][j+1]=='1'){
                        if(union(parent,rank,i*width+j,i*width+j+1))
                            nums--;
                    }
                }
            }
        }
        return nums;

    }

    public int find(int[] parent,int i){
        while(parent[i]!=i) i = parent[i];
        return parent[i];
    }
    public boolean union(int[] parent ,int[] rank, int i,int j)
    {
        int root_i = find(parent,i);
        int root_j = find(parent,j);
        if(root_i!=root_j){
            if(rank[root_i]>=rank[root_j])
            {
                parent[root_j] = root_i;
                rank[root_i]+=root_j;
            }else if(rank[root_i]<rank[root_j]){
                parent[root_i] = root_j;
                rank[root_j]+=root_i;
            }
            return true;
        }
        return false;

    }


}
