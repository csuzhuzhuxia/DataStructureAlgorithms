import java.util.*;

public class Leetcode127 {

    class Levelword{
        String word;
        int level;
        public Levelword(String word,int level){
            this.word = word;
            this.level = level;
        }
    }

    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        int end = wordList.indexOf(endWord);
        if (end==-1){
            return 0;
        }
        if (!wordList.contains(beginWord)){
            wordList.add(beginWord);
        }

        boolean[][] nextWords = new boolean[wordList.size()][wordList.size()];
        HashMap<String,Boolean> visited = new HashMap<>();


        for (int i = 0; i < wordList.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (hashpath(wordList.get(i).toCharArray(),wordList.get(j).toCharArray())){
                    nextWords[i][j] = nextWords[j][i] = true;
                }
            }
            visited.put(wordList.get(i),false);
        }

        Queue<Levelword> queue = new LinkedList<>();
        queue.add(new Levelword(beginWord,0));
        visited.put(beginWord,true);
        while (!queue.isEmpty()){
            Levelword temp =queue.poll();
            if (temp.word.equals(endWord)){
                return temp.level+1;
            }
            List<String> nextString = new ArrayList<>();
            int n = wordList.indexOf(temp.word);
            for (int i = 0; i < nextWords[n].length; i++) {
                if (nextWords[n][i])
                    nextString.add(wordList.get(i));
            }
            for (int i = 0; i < nextString.size(); i++) {
                String nextTemp = nextString.get(i);
                if (!visited.get(nextTemp)){
                    queue.add(new Levelword(nextTemp,temp.level+1));
                    visited.put(nextTemp,true);
                }
            }

        }
        return 0;
    }

    private boolean hashpath(char[] s, char[] s1) {
        int diff=0;
        for (int i = 0; i < s.length; i++) {
            if (s[i]!=s1[i]){
                diff++;
            }
        }
        if (diff==1){
            return true;
        }
        return false;
    }


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        final int INF = 1000000000;
        HashSet<String> wordset = new HashSet<>(wordList);
        wordset.add(beginWord);
        if (!wordset.contains(endWord))
            return 0;
        List<String> list = new ArrayList<>();
        int start = 0;
        int end = 0;
        int index = 0;
        for (String str:wordset) {
            list.add(str);
            if (beginWord.equals(str))
                start = index;
            if (endWord.equals(str))
                end = index;
            index++;
        }
        int size = list.size();
        boolean[][] graph = new boolean[size][size];
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (hashpath(list.get(i).toCharArray(),list.get(j).toCharArray())){
                    graph[i][j] = graph[j][i] = true;
                }
            }
        }
        int[] d = new int[size];
        for (int i = 0; i < size; i++) {
            d[i] = INF;
        }
        int[] countInq =new int[size];
        boolean[] inq = new boolean[size];
        spfa(start,d,inq,countInq,graph);
        if(INF == d[end]){
            return 0;
        }
        return d[end] + 1;
    }

    private boolean spfa(int start, int[] d, boolean[] inq, int[] countInq, boolean[][] graph) {
        Queue<Integer> queue = new LinkedList<>();
        d[start] = 0;
        queue.add(start);
        countInq[start]++;
        inq[start]=true;
        while (!queue.isEmpty()){
            int u = queue.poll();
            inq[u] = false;
            for (int i = 0; i < graph.length; i++) {
                if (graph[u][i]&&d[u]+1<d[i]){
                    d[i] = d[u]+1;
                    if (!inq[i]){
                        queue.add(i);
                        countInq[i]++;
                        inq[i] = true;
                        if (countInq[i]>graph.length)
                            return false;
                    }
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        Leetcode127 leetcode127= new Leetcode127();

        String[] strings ={"hot","dot","dog","lot","log","cog"};
        List<String> wordList = new ArrayList<>();
        for (String s :strings) {
            wordList.add(s);
        }
        leetcode127.ladderLength1("hit","cog",wordList);
    }
}
