package tsk2;

public class Calculator {

    /**
     * Вычисляет сумму двух чисел.
     *
     * @param numb1 первое число
     * @param numb2 второе число
     * @return сумма чисел numb1 и numb2
     */
    public <T extends Number> double sum(T numb1, T numb2) {
        return toDouble(numb1) + toDouble(numb2);
    }

    /**
     * Вычисляет произведение двух чисел.
     *
     * @param numb1 первое число
     * @param numb2 второе число
     * @return произведение чисел numb1 и numb2
     */
    public <T extends Number> double multiply(T numb1, T numb2) {
        return toDouble(numb1) * toDouble(numb2);
    }

    /**
     * Делит первое число на второе.
     *
     * @param numb1 первое число
     * @param numb2 второе число
     * @return результат деления числа numb1 на число numb2
     * @throws ArithmeticException если numb2 равно нулю
     */
    public <T extends Number> double divide(T numb1, T numb2) {
        double divisor = toDouble(numb2);
        ensureNotZero(divisor);
        return toDouble(numb1) / divisor;
    }

    /**
     * Вычисляет разность двух чисел.
     *
     * @param numb1 первое число
     * @param numb2 второе число
     * @return разность чисел numb1 и numb2
     */
    public <T extends Number> double subtract(T numb1, T numb2) {
        return toDouble(numb1) - toDouble(numb2);
    }

    /**
     * Переводит число в тип double.
     *
     * @param number число, которое нужно перевести
     * @return число в формате double
     */
    private <T extends Number> double toDouble(T number) {
        return number.doubleValue();
    }

    /**
     * Проверяет число на равенство нулю. Если число равно нулю, бросается исключение.
     *
     * @param number число для проверки
     * @throws ArithmeticException если number равно нулю
     */
    private void ensureNotZero(double number) {
        if (number == 0) {
            throw new ArithmeticException("Деление на ноль");
        }
    }

}

