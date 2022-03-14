package HashMap.com;
import com.company.DllWithKey;

// Allowed key type int && value type Generic (any)
public class CustomHashMap<K, V> {
    final int capacity;
    final DllWithKey<Integer, V>[] storage; // make a capacity for dllwithKey
    private int size = 0;

    public CustomHashMap(int capacity) {
        if (capacity <= 1) {
            throw new ArrayStoreException("Capacity Requirement above than one ");
        }
        this.capacity = capacity;
        storage = new DllWithKey[capacity];
    }

    public void put(int key, V value) {
        int index = calculateHash(key);

        DllWithKey<Integer, V> dll = getDll(index);
        if( !dll.contains(value)){
            dll.add(key, value);
            size++;
        }
    }

    public V get(int key) {
        int index = calculateHash(key);
        DllWithKey<Integer, V> dll = storage[index];

        if(dll == null){
            return  null;
        }
        return dll.getByKey(key);
    }

    private DllWithKey<Integer, V> getDll(int index) {
        DllWithKey<Integer, V> dll = storage[index]; //  make a referance
        if (dll == null) {
            dll = new DllWithKey<>();
        }
        storage[index] = dll;
        return dll;
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public boolean containsKey(int key) {
        V v = get(key);
        return v != null;

    }

    public void clear() {
        for (int i = 0; i < capacity - 1; i++) {
            storage[i] = null;
        }
        System.out.println("Empty");
    }


    private int calculateHash(K key) {
        return Math.abs(key.hashCode());
    }

    public int calculateHash(int key) {

        if (key == 0) {
            return 0;
        }
        return key % (capacity - 1);
    }
}
