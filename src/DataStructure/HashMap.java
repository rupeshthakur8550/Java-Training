package DataStructure;

import java.util.*;

public class HashMap<K, V> {
    private ArrayList<LinkedList<Entity>> list;

    private int size = 0;
    private float lf = 0.5f;

    private class Entity{
        private String key;
        private String value;

        public Entity(String K, String V){
            this.key = K;
            this.value = V;
        }
    }

    public HashMap(){
        list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            list.add(new LinkedList<>());
        }
    }

    public void put(K key, V value){
        int hash = Math.abs(key.hashCode() % list.size());
        LinkedList<Entity> entities = list.get(hash);

        for(Entity entity: entities){
            if(entity.key.equals(key)){
                entity.value = value;
                return ;
            }
        }
        if((float)(size) / list.size() > lf){
            reHash();
        }

        entities.add(new Entity(key, value));
        size++;
    }

    public void reHash(){
        System.out.println("We are now rehashing....");
    }
}