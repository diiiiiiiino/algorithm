package 자바코딩인터뷰완벽가이드.연결리스트와맵.맵에값을삽입검색삭제하기;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class MyMap2<K, V> {
    private static final int DEFAULT_CAPACITY = 16;

    private Entry<K, V>[] entries;
    private int size;

    public MyMap2() {
        this.entries = new Entry[DEFAULT_CAPACITY];
    }

    private final class Entry<K, V>{
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    public void put(K key, V value){
        boolean success = true;

        for(int i = 0; i < size; i++){
            if(entries[i].key.equals(key)){
                success = false;
            }
        }

        if(success){
            checkCapacity();
            entries[size++] = new Entry<>(key, value);
        }
    }

    private void checkCapacity() {
        if(size == entries.length){
            entries = Arrays.copyOf(entries, entries.length * 2);
        }
    }

    public void remove(K key){
        for(int i = 0; i < size; i++){
            if(entries[i].key.equals(key)){
                entries[i] = null;
                size--;
                condenseArray(i);
                return;
            }
        }
    }

    private void condenseArray(int start) {
        int i;
        for(i = start; i < size; i++){
            entries[i] = entries[i + 1];
        }

        entries[i] = null;
    }

    public V get(K key){
        for(int i = 0; i < size; i++){
            if(entries[i].key.equals(key)){
                return entries[i].value;
            }
        }

        return null;
    }

    public Set<K> keySet(){
        return Arrays.stream(entries)
                .filter(Objects::nonNull)
                .map(kvEntry -> kvEntry.key)
                .collect(Collectors.toSet());
    }

    public Collection<V> values(){
        return Arrays.stream(entries)
                .filter(Objects::nonNull)
                .map(kvEntry -> kvEntry.value)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return Arrays.toString(entries);
    }

    public static void main(String[] args) {
        MyMap2<String, Integer> map = new MyMap2<>();

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
