package tsk1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class GenericArrayAndIterator<T> implements Iterable<T> {
    private static final int INITIAL_SIZE = 10;
    private Object[] list;
    private int size;

    /**
     * Создает пустой массив с начальной вместимостью INITIAL_SIZE.
     */
    public GenericArrayAndIterator() {
        this.list = new Object[INITIAL_SIZE];
        this.size = 0;
    }

    /**
     * Добавляет указанный элемент в конец этого массива.
     *
     * @param t элемент, который нужно добавить в массив
     */
    public void add(T t) {
        resizeArrayIfFull();
        list[size] = t;
        size++;
    }

    /**
     * Увеличивает размер массива, если он полностью заполнен.
     */
    private void resizeArrayIfFull() {
        if (size == list.length) {
            Object[] newArray = new Object[list.length * 2];
            System.arraycopy(list, 0, newArray, 0, size);
            list = newArray;
        }
    }

    /**
     * Удаляет первое вхождение указанного элемента из этого массива, если он присутствует.
     * Если массив не содержит элемента, он остается без изменений.
     *
     * @param t элемент, который нужно удалить из массива, если он присутствует
     */
    public void remove(T t) {
        if (size == 0)
            return;

        int newIndex = 0;
        for (int oldIndex = 0; oldIndex < size; oldIndex++) {
            if (!list[oldIndex].equals(t)) {
                list[newIndex++] = list[oldIndex];
                list[oldIndex] = null;
            }
        }
        size = newIndex;
    }

    /**
     * Возвращает элемент на указанной позиции в этом массиве.
     *
     * @param index индекс элемента, который следует вернуть
     * @return элемент на указанной позиции в этом массиве
     * @throws IndexOutOfBoundsException если индекс выходит за пределы массива
     */
    public T get(int index) {
        if (index >= 0 && index < size) {
            return (T) list[index];
        } else {
            throw new IndexOutOfBoundsException("Индекс вне диапазона");
        }
    }
//    public int size() {
//        return size;
//    }
//
//    public boolean isEmpty() {
//        return size == 0;
//    }
//
//    public void clear() {
//        for (int i = 0; i < size; i++) {
//            list[i] = null;
//        }
//        size = 0;
//    }

    /**
     * Возвращает строковое представление массива.
     *
     * @return строковое представление массива
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(list[i].toString());
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Возвращает итератор по элементам типа {@code T}.
     *
     * @return итератор.
     */
    @Override
    public Iterator<T> iterator() {
        return new GenericIterator();
    }

    /**
     * Внутренний класс для реализации итератора для элементов массива.
     */
    private class GenericIterator implements Iterator<T> {
        private int index = 0;

        /**
         * Возвращает следующий элемент в массиве и сдвигает позицию курсора.
         *
         * @return следующий элемент в массиве
         * @throws NoSuchElementException если больше нет элементов для возврата
         */
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("В массиве больше нет элементов");
            }
            return (T) list[index++];
        }

        /**
         * Возвращает {@code true}, если в массиве есть еще элементы.
         *
         * @return {@code true}, если в массиве есть еще элементы
         */
        @Override
        public boolean hasNext() {
            return (index < size);
        }
    }
}
