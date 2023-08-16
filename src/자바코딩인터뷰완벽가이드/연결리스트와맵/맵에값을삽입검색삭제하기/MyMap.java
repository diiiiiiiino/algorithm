package 자바코딩인터뷰완벽가이드.연결리스트와맵.맵에값을삽입검색삭제하기;

import java.util.*;

public class MyMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private int size;
    private MyEntry<K,V>[] entries = new MyEntry[DEFAULT_CAPACITY];

    public void put(K key, V value){
        boolean success = true;

        for(int i = 0; i < size; i++){
            if(entries[i].getKey().equals(key)){
                success = false;
            }
        }

        if(success){
            checkCapacity();
            entries[size++] = new MyEntry<>(key, value);
        }
    }

    public V get(K key){
        for(int i = 0; i < size; i++){
            MyEntry<K,V> myEntry = entries[i];
            if(myEntry != null){
                if(myEntry.getKey().equals(key)){
                    return myEntry.getValue();
                }
            }
        }

        return null;
    }

    public void remove(K key){
        for(int i = 0; i < size; i++){
            if(entries[i].getKey().equals(key)){
                entries[i] = null;
                size--;
                condenseArray(i);
            }
        }
    }

    public Set<K> keySet(){
        Set<K> set = new HashSet<>();
        for(int i = 0; i < size; i++){
            set.add(entries[i].getKey());
        }

        return set;
    }

    public Collection<V> values(){
        List<V> list = new ArrayList<>();
        for(int i = 0; i < size; i++){
            list.add(entries[i].getValue());
        }

        return list;
    }

    private void condenseArray(int start) {
        int i;
        for(i = start; i < size; i++){
            entries[i] = entries[i + 1];
        }

        entries[i] = null;
    }

    private void checkCapacity() {
        if(size == entries.length){
            int newSize = entries.length * 2;
            entries = Arrays.copyOf(entries, newSize);
        }
    }


    private final class MyEntry<K, V>{
        private final K key;
        private V value;

        public MyEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + "key=" + key + ", value=" + value + '}';
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(entries);
    }

    public static void main(String[] args) {
        MyMap<String, Integer> map = new MyMap<>();

        map.put("Alex", 1);
        map.put("Tomy", 2);
        map.put("Anna", 3);

        System.out.println("Alex value is: " + map.get("Alex"));

        map.remove("Alex");

        System.out.println(map);
        System.out.println(map.keySet());
        System.out.println(map.values());
    }
}
