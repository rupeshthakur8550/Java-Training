package DataStructure;

import java.util.*;

public class HashMap<K, V> {

    private ArrayList<LinkedList<Entity<K, V>>> list;
    private int size = 0;
    private final float loadFactor;
    private static final int INITIAL_CAPACITY = 10;

    private static class Entity<K, V> {
        private final K key;
        private V value;

        public Entity(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashMap() {
        this(INITIAL_CAPACITY, 0.5f);
    }

    public HashMap(int initialCapacity, float loadFactor) {
        this.list = new ArrayList<>(initialCapacity);
        this.loadFactor = loadFactor;
        for (int i = 0; i < initialCapacity; i++) {
            list.add(new LinkedList<>());
        }
    }

    public void put(K key, V value) {
        int hash = Math.abs(key.hashCode() % list.size());
        LinkedList<Entity<K, V>> entities = list.get(hash);

        for (Entity<K, V> entity : entities) {
            if (entity.key.equals(key)) {
                entity.value = value;
                return;
            }
        }

        if ((float) (size + 1) / list.size() > loadFactor) {
            rehash();
            hash = Math.abs(key.hashCode() % list.size());
            entities = list.get(hash);
        }

        entities.add(new Entity<>(key, value));
        size++;
    }

    public V get(K key) {
        int hash = Math.abs(key.hashCode() % list.size());
        LinkedList<Entity<K, V>> entities = list.get(hash);

        for (Entity<K, V> entity : entities) {
            if (entity.key.equals(key)) {
                return entity.value;
            }
        }

        return null;
    }

    public void remove(K key) {
        int hash = Math.abs(key.hashCode() % list.size());
        LinkedList<Entity<K, V>> entities = list.get(hash);

        Iterator<Entity<K, V>> iterator = entities.iterator();
        while (iterator.hasNext()) {
            Entity<K, V> entity = iterator.next();
            if (entity.key.equals(key)) {
                iterator.remove();
                size--;
                return;
            }
        }
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public void printMap() {
        StringBuilder builder = new StringBuilder("{");
        for (LinkedList<Entity<K, V>> entities : list) {
            for (Entity<K, V> entity : entities) {
                builder.append(entity.key).append(" = ").append(entity.value).append(", ");
            }
        }
        if (builder.length() > 1) {
            builder.setLength(builder.length() - 2); // Remove trailing ", "
        }
        builder.append("}");
        System.out.println(builder.toString());
    }

    private void rehash() {
        System.out.println("Rehashing...");
        ArrayList<LinkedList<Entity<K, V>>> oldList = list;
        list = new ArrayList<>(oldList.size() * 2);
        for (int i = 0; i < oldList.size() * 2; i++) {
            list.add(new LinkedList<>());
        }

        for (LinkedList<Entity<K, V>> entities : oldList) {
            for (Entity<K, V> entity : entities) {
                put(entity.key, entity.value);
            }
        }
    }
}
