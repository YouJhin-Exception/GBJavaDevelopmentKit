package tsk5;

import java.util.List;
import java.util.Optional;

public interface DatabaseOperations<T> {
    /**
     * Сохраняет данные в базу данных.
     *
     * @param data данные для сохранения
     * @return возвращает true, если операция завершилась успехом. Иначе, возвращает false.
     */
    boolean save(T data);

    /**
     * Удаляет данные из базы данных.
     *
     * @param data данные для удаления
     * @return возвращает true, если операция завершилась успехом. Иначе, возвращает false.
     */
    boolean delete(T data);

    /**
     * Восстанавливает данные по их id.
     *
     * @param id идентификатор данных для восстановления
     * @return возвращает данные, если они были найдены. Иначе, возвращает Optional.empty().
     */
    Optional<T> retrieveById(int id);

    /**
     * Восстанавливает все данные из базы данных.
     *
     * @return возвращает список всех данных.
     */
    List<T> retrieveAll();
}
