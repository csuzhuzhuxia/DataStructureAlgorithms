import java.util.*;

public class Leetcode133 {

    class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) {
          label = x; neighbors = new ArrayList<UndirectedGraphNode>();
      }
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node==null)
            return null;
        UndirectedGraphNode res = new UndirectedGraphNode(node.label);
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer,UndirectedGraphNode> map = new HashMap<>();
        set.add(node.label);
        map.put(node.label,res);
        traceback(res,node,set,map);
        return res;
    }

    private void traceback(UndirectedGraphNode res, UndirectedGraphNode node, HashSet<Integer> set, HashMap<Integer, UndirectedGraphNode> map) {
        if (node.neighbors==null||node.neighbors.isEmpty())
            return;
        for (int i = 0; i < node.neighbors.size(); i++) {
            UndirectedGraphNode neigth_node = node.neighbors.get(i);
            if (!set.contains(neigth_node.label)){
                UndirectedGraphNode new_node = new UndirectedGraphNode(neigth_node.label);
                res.neighbors.add(new_node);
                set.add(neigth_node.label);
                map.put(neigth_node.label,new_node);
                traceback(res.neighbors.get(i),node.neighbors.get(i),set,map);
            }else {
                res.neighbors.add(map.get(neigth_node.label));
            }
        }
    }
}
