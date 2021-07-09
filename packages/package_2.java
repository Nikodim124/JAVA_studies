/*
Создать класс Radius, принадлежащий пакету mypackage, в котором реализовать статический метод getSquare, принимающий на вход целочисленное значение и возвращающее площадь круга (Pi*radius^2). Требуется также добавить проверку на получаемое значение. Если на вход поступает отрицательно число, то функция должна вернуть -1.

В пакете taskpackage в классе Task в статический метод task передается целое число, которое далее нужно использовать в методе getSquare который следует статически подключить и вызвать метод getSquare для вычисления площади круга.

Приведите исходные коды классов Radius и Task с учетом заданной структуры пакетов.
*/

package taskpackage; //объявляем пакетик
import static mypackage.Radius.*; //импортируем из mypackage

public class Task {
	public static double task(int a) {
		double result = getSquare(a); //вызываем getSquare
		return result; //возвращаем расчёты
	}
}