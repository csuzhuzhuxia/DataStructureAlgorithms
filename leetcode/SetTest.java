import java.util.*;

public class SetTest {




    public static void main(String[] args) {
        Set<Character> set = new HashSet<>();
        String str = "aa aa aa";
        System.out.println(str.trim());

        Set<Integer> set1 = new HashSet<>();

        LinkedHashMap<Integer,Integer> linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(1,1);
        linkedHashMap.put(2,2);
        linkedHashMap.put(3,3);
        Set<Integer> set2 = linkedHashMap.keySet();
        Iterator<Integer> integerIterator = set2.iterator();
        while (integerIterator.hasNext()){
            System.out.println(linkedHashMap.get(integerIterator.next()).toString());;
        }

//        str.trim()()
//        char c = str.charAt(0);
//        System.out.println((int)c);
//        System.out.println(set.add(c));
//        System.out.println(set.size());
//        Integer
        StringBuffer stringBuffer = new StringBuffer();

//        stringBuffer.toString().par
//        Integer.MAX_VALUE
//        stringBuffer.delete()
//        Math.max()
        Vector<Integer> vector = new Vector<>();
//        Character.isDigit()


        Integer integer1 = Integer.valueOf(5);
        Integer integer2 = Integer.valueOf(5);

        System.out.println(integer1.equals(integer2));

        String string = new String("hello");
        String string2 = new String("hello");
        System.out.println(string.equals(string2));






    }



}
