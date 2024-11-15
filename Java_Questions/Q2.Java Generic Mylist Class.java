public class MyList<T> {
    private T[] array;
    private int size;
    private static final int INITIAL_CAPACITY = 100;
    private static final int GROWTH_FACTOR = 2;
    private static final float SHRINK_THRESHOLD = 0.25f;

    @SuppressWarnings("unchecked")
    public MyList() {
 
        array = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    
    public void add(T value) {
        if (size == array.length) {
            grow();
        }
        array[size] = value;
        size++;
    }

    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
       
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        
        array[size - 1] = null;
        size--;
        
        if (size > 0 && size < array.length * SHRINK_THRESHOLD) {
            shrink();
        }
    }

    public boolean deleteValue(T value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == null ? value == null : array[i].equals(value)) {
                deleteAtIndex(i);
                return true;
            }
        }
        return false;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return array[index];
    }

    
    public int size() {
        return size;
    }

    
    public int capacity() {
        return array.length;
    }

    @SuppressWarnings("unchecked")
    private void grow() {
        int newCapacity = array.length * GROWTH_FACTOR;
        T[] newArray = (T[]) new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    @SuppressWarnings("unchecked")
    private void shrink() {
        int newCapacity = Math.max(INITIAL_CAPACITY, array.length / GROWTH_FACTOR);
        if (newCapacity < array.length) {
            T[] newArray = (T[]) new Object[newCapacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}