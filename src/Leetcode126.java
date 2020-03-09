import java.util.*;


public class Leetcode126 {
    public List<List<String>> findLadders1(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if(!wordList.contains(endWord)){
            return res;
        }
        if (!wordList.contains(beginWord)){
            wordList.add(beginWord);
        }


        HashMap<String,List<String>> from = new HashMap<>();
        List<String> visited = new ArrayList<>();
        HashMap<Integer,List<Integer>> next_words = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            next_words.put(i,new ArrayList<>());
        }
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (hashpath(wordList.get(i).toCharArray(),wordList.get(j).toCharArray())){
                    next_words.get(i).add(j);
                    next_words.get(j).add(i);
                }
            }
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visited.add(beginWord);
        while (!queue.isEmpty()){
            int level = queue.size();
            List<String> tempVisited = new ArrayList<>();
            while (level-- >0){
                String temp = queue.poll();
                int n = wordList.indexOf(temp);
                List<Integer> nextWord = next_words.get(n);
                for (int i = 0; i < nextWord.size(); i++) {
                    String str = wordList.get(nextWord.get(i));
                    if (!visited.contains(str)){
                        if (!from.containsKey(str)){
                            tempVisited.add(str);
                            queue.add(str);

                            List<String> temp_from = new ArrayList<>();
                            temp_from.add(str);
                            from.put(str,temp_from);
                        }else {
                            List<String> temp_from = from.get(str);
                            temp_from.add(str);
                            from.put(str,temp_from);
                        }
                    }
                }
            }
            for (String str:tempVisited) {
                visited.add(str);
            }
            if (visited.contains(endWord))
                break;
        }
        from.put(beginWord,null);
        dfs(beginWord, endWord, new ArrayList<>(), from, res);
        return res;

    }

    private void dfs(String beginWord, String endWord, List<String> item, HashMap<String, List<String>> from, List<List<String>> res) {
        if (endWord.equals(beginWord)){
            item.add(beginWord);
            Collections.reverse(item);
            res.add(item);
            return;
        }
        item.add(endWord);
        if (from.get(endWord)!=null){
            for (String str:from.get(endWord)) {
                dfs(beginWord,str,new ArrayList<>(item),from,res);
            }
        }
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


    public List<List<String>> findLadders2(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        int end_index = wordList.indexOf(endWord);
        if (end_index==-1)
            return res;

        int start_index = wordList.indexOf(beginWord);
        if (start_index==-1)
            wordList.add(beginWord);
        start_index = wordList.indexOf(beginWord);

        HashMap<Integer,Integer> dis = new HashMap<>();
        HashMap<Integer,List<Integer>> next_word = new HashMap<>();
        int size = wordList.size();
        for (int i = 0; i <size ; i++) {
            next_word.put(i,new ArrayList<>());
        }
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (hashpath(wordList.get(i).toCharArray(),wordList.get(j).toCharArray())){
                    next_word.get(i).add(j);
                    next_word.get(j).add(i);
                }
            }
        }
        //图的广度遍历
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start_index);
        dis.put(start_index,0);
        while(!queue.isEmpty()){
            int temp = queue.poll();
            List<Integer> temp_next = next_word.get(temp);
            for (int i = 0; i < temp_next.size(); i++) {
                if (!dis.containsKey(temp_next.get(i))){
                    dis.put(temp_next.get(i),dis.get(temp)+1);
                    queue.add(temp_next.get(i));
                }
            }
        }
        List<Integer> item = new ArrayList<>();
        item.add(start_index);
        dfs(start_index,end_index,item,next_word,dis,res,wordList);
        return res;
    }

    private void dfs(int start_index, int end_index, List<Integer> item, HashMap<Integer, List<Integer>> next_word, HashMap<Integer, Integer> dis, List<List<String>> res, List<String> wordList) {
        if (item.size()>0&&item.get(item.size()-1).equals(end_index)){
            List<String> item_int = getPath(item,wordList);
            res.add(item_int);
            return;
        }

        for (int i = 0; i < next_word.get(start_index).size(); i++) {
            if (dis.get(next_word.get(start_index).get(i)).equals(dis.get(start_index)+1)){
                item.add(next_word.get(start_index).get(i));
                dfs(next_word.get(start_index).get(i),end_index,item,next_word,dis,res,wordList);
                item.remove(item.size()-1);
            }
        }
    }

    private List<String> getPath(List<Integer> item, List<String> wordList) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < item.size() ; i++) {
            res.add(wordList.get(i));
        }
        return res;
    }


    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        HashSet<String> wordset = new HashSet<>(wordList);
        if (!wordset.contains(endWord))
            return res;
        if (!wordset.contains(beginWord)){
            wordList.add(beginWord);
        }
        int index=0;
        int begin_index=0;
        int end_index = 0;
        for (String str:wordList) {
            if (str.equals(beginWord))
                begin_index=index;
            if (str.equals(endWord))
                end_index=index;
            index++;
        }
        int size = wordList.size();
        boolean[][] graph = new boolean[size][size];
        int[] dis = new int[size];
        for (int i = 0; i < size; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        boolean[] isUsed = new boolean[size];

        List<HashSet<Integer>> pre= new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (hashpath(wordList.get(i).toCharArray(),wordList.get(j).toCharArray())){
                    graph[i][j] = graph[j][i] = true;
                }
            }
            pre.add(new HashSet<>());
        }
        dpfs(begin_index,end_index,dis,wordList,graph,isUsed,pre);
        List<Integer> item = new ArrayList<>();
        item.add(end_index);
        dfs(begin_index,end_index,wordList,pre,item,res);
        return res;
    }

    private void dfs(int begin_index, int end_index, List<String> wordList, List<HashSet<Integer>> pre, List<Integer> item,List<List<String>> res) {
        if (end_index==begin_index){
            List<String> item_string = getPath(item,wordList);
            Collections.reverse(item_string);
            res.add(item_string);
            return;
        }
        HashSet<Integer> pre_cur = pre.get(end_index);
        for (Integer integer:pre_cur) {
            item.add(integer);
            dfs(begin_index,integer,wordList,pre,item,res);
            item.remove(item.size()-1);
        }
    }
    private boolean dpfs(int begin_index, int end_index, int[] dis, List<String> wordList, boolean[][] graph, boolean[] isUsed, List<HashSet<Integer>> pre) {
        int[] useTime = new int[isUsed.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(begin_index);
        isUsed[begin_index] = true;
        dis[begin_index]=0;
        useTime[begin_index]++;
        while (!queue.isEmpty()){
            int index = queue.poll();
            isUsed[index]=false;
            for (int i = 0; i < graph.length; i++) {
                if (graph[index][i]){
                    if (dis[index]+1<dis[i]){
                        dis[i] = dis[index]+1;
                        pre.get(i).clear();;
                        pre.get(i).add(index);
                        if (!isUsed[i]){
                            queue.add(i);
                            useTime[i]++;
                            isUsed[i]=true;
                            if (useTime[i]>graph.length){
                                return false;
                            }
                        }
                    }else if (dis[index]+1==dis[i]){
                        pre.get(i).add(index);
                        if (!isUsed[i]){
                            queue.add(i);
                            useTime[i]++;
                            isUsed[i]=true;
                            if (useTime[i]>graph.length){
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;


    }


}
