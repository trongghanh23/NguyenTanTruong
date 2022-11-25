package _10_list.exercise.arraylist1;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private Object[] elements;
    static final int DEFAULT_CAPACITY = 10;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        if (capacity > 0) {
            System.out.println("Khởi tạo thành công với kích thước  : " + capacity);
            elements = new Object[capacity];
        } else {
            System.out.println("Lỗi tham số truyền vào");
            throw new IllegalArgumentException("capacity : " + capacity);
        }
    }

    public void ensureCapacity(int minCapacity) {
        if (minCapacity >= 0) {
            int newSize = this.elements.length + minCapacity;
            elements = Arrays.copyOf(elements, newSize);
            System.out.println("Khởi tạo thành công với kích thước  : " + elements.length);
        } else {
            throw new IllegalArgumentException("minCapacity : " + minCapacity);
        }
    }

    public void add(E o, int index) {
        if (index > elements.length) {
            throw new IllegalArgumentException("Lỗi index : " + index);
        } else if (elements.length == index + 1) {
            ensureCapacity(1);
        }
        if (elements[index] == null) {
            size++;
            elements[index] = o;
        } else {
            if (size == elements.length) {
                ensureCapacity(1);
            }
            System.arraycopy(elements, index, elements, index + 1,
                    size - index);
            elements[index] = o;
            size++;
        }

    }

    public boolean add(E o) {
        if (size == elements.length) {
            ensureCapacity(1);
        }
        elements[size] = o;
        size++;
        return true;
    }

    public E remove(int index) {
        if (index < 0 || index > elements.length) {
            throw new IllegalArgumentException("Lỗi index: " + index);
        }
        E element = (E) elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return element;
    }

    public int size() {
        return size;
    }

    public int length() {
        return elements.length;
    }

    public MyList<E> clone() {
        MyList<E> v = new MyList<>();
        v.elements = Arrays.copyOf(elements, size);
        v.size = size;
        return v;
    }

    public int indexOf(E o) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (this.elements[i].equals(o)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public E get(int index) {
        return (E) elements[index];
    }

    public boolean contains(E e) {
        return this.indexOf(e) >= 0;
    }

    public void clear() {
        size = 0;
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
    }
}
