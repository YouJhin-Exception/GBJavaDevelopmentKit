package tsk5;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Класс DatabaseManager представляет собой механизм управления базой данных,
 * который поддерживает базовые операции, такие как сохранение, удаление и извлечение данных.
 * Этот класс синхронизируется с использованием ReentrantLock, чтобы избежать условий гонки.
 *
 * @param <T> тип элементов, хранящихся в базе данных.
 */
public class DatabaseManager<T> implements DatabaseOperations<T> {
    /**
     * Список элементов, эмулирующих базу данных.
     */
    private final List<T> database;

    /**
     * Замок, для обеспечения синхронизации при выполнении операций с базой данных.
     */
    private final Lock lock = new ReentrantLock();

    /**
     * Создает новый менеджер базы данных с предоставленным списком элементов.
     *
     * @param database список элементов для инициализации менеджера.
     */
    public DatabaseManager(List<T> database) {
        this.database = new ArrayList<>(database);
    }

    /**
     * Сохраняет предоставленный элемент в базе данных.
     * Синхронизация обеспечивается через ReentrantLock.
     *
     * @param data элемент для сохранения.
     * @return всегда возвращает false (нужно обновить согласно выбранной логике).
     */
    @Override
    public boolean save(T data) {
        lock.lock();
        try {
            database.add(data);
        } finally {
            lock.unlock();
        }

        return false;
    }

    /**
     * Удаляет предоставленный элемент из базы данных.
     * Синхронизация обеспечивается через ReentrantLock.
     *
     * @param data элемент для удаления.
     * @return всегда возвращает false (нужно обновить согласно выбранной логике).
     */
    @Override
    public boolean delete(T data) {
        lock.lock();
        try {
            database.remove(data);
        } finally {
            lock.unlock();
        }
        return false;
    }

    /**
     * Извлекает элемент из базы данных по местоположению.
     * Синхронизация обеспечивается через ReentrantLock.
     *
     * @param id местоположение элемента для извлечения.
     * @return элемент имеющийся в базе данных по указанному индексу или пустое значение.
     */
    @Override
    public Optional<T> retrieveById(int id) {
        lock.lock();
        try {
            if (id >= 0 && id < database.size()) {
                return Optional.of(database.get(id));
            }
        } finally {
            lock.unlock();
        }
        return Optional.empty();
    }

    /**
     * Извлекает все элементы из базы данных.
     * Синхронизация обеспечивается через ReentrantLock.
     *
     * @return список всех элементов, сохраненных в базе данных.
     */
    @Override
    public List<T> retrieveAll() {
        lock.lock();
        try {
            return new ArrayList<>(database); // Возвращаем копию БД, чтобы избежать внешней модификации
        } finally {
            lock.unlock();
        }
    }
}

