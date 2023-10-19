package tsk4;

import java.util.Objects;

/**
 * Представляет собой пару из двух значений.
 *
 * @param <T> тип первого значения
 * @param <V> тип второго значения
 */
public final class Pair<T, V> {

    private final T first;
    private final V second;

    /**
     * Создает пару значений.
     *
     * @param first  первое значение, не должно быть null
     * @param second второе значение, не должно быть null
     */
    public Pair(T first, V second) {
        this.first = Objects.requireNonNull(first, "Первое значение не может быть null");
        this.second = Objects.requireNonNull(second, "Второе значение не может быть null");
    }

    /**
     * Возвращает первое значение.
     *
     * @return первое значение
     */
    public T getFirst() {
        return first;
    }

    /**
     * Возвращает второе значение.
     *
     * @return второе значение
     */
    public V getSecond() {
        return second;
    }

    /**
     * Возвращает строковое представление пары.
     *
     * @return строковое представление пары
     */
    @Override
    public String toString() {
        return "Pair { first = " + first + ", second = " + second + " }";
    }


    // equals и hash для сравнения объектов

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair<?, ?> pair)) return false;
        return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}

