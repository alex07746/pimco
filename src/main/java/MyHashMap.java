import java.util.*;



     class Node<Integer, String>{

        private Integer k;
        private String v;


        public Node(Integer key, String val){
            this.k = key; this.v = val;
        }
        public Integer getKey(){
            return k;
        }
        public String getValue() {
            return v;
        }
    }

    public class MyHashMap{

    public List<Node<Integer, String>> al = null;
    public static final int size = 16;

    public MyHashMap(){
        al = new ArrayList<>(size);
        for(int i =0; i < size; i++){
            al.add(null);
        }
    }

    public void put(Integer key, String val){
        int idx = key.hashCode()%size;
        if(al.get(idx) == null)
            al.add(idx, new Node(key, val));
        else
            al.set(idx, new Node(key, val));
    }
    public String get(Integer key){
        int idx = key.hashCode()%size;
        return al.get(idx).getValue();
    }

    public static void main(String[] args){
        MyHashMap h = new MyHashMap();
        h.put(1,"Alex");
        h.put(2,"John");

        System.out.println("Before replace : getting value at key = 1" + h.get(1));
        h.put(1,"Jamie");

        System.out.println("After replace : getting value at key = 1" + h.get(1));
    }
}