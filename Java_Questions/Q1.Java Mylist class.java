public class MyList {
    private int[] array;
    private int size;
    private static final int INITIAL_CAPACITY = 100;
    private static final int GROWTH_FACTOR = 2;
    private static final float SHRINK_THRESHOLD = 0.25f;

    public MyList() {
        array = new int[INITIAL_CAPACITY];
        size = 0;
    }

    
    public void add(int value) {
        
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
        size--;
        
        
        if (size > 0 && size < array.length * SHRINK_THRESHOLD) {
            shrink();
        }
    }

    
    public boolean deleteValue(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                deleteAtIndex(i);
                return true;
            }
        }
        return false;
    }

    
    public int get(int index) {
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

   
    private void grow() {
        int newCapacity = array.length * GROWTH_FACTOR;
        int[] newArray = new int[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    
    private void shrink() {
        int newCapacity = Math.max(INITIAL_CAPACITY, array.length / GROWTH_FACTOR);
        if (newCapacity < array.length) {
            int[] newArray = new int[newCapacity];
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