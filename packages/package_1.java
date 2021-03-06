/*
Создать класс Radius, принадлежащий пакету mypackage, в котором реализовать статический метод getSquare, 
принимающий на вход целочисленное значение и возвращающее площадь круга (Pi*radius^2). Требуется также добавить проверку на получаемое значение. 
Если на вход поступает отрицательно число, то функция должна вернуть -1.

В пакете taskpackage в классе Task в статический метод task передается целое число, 
которое далее нужно использовать в методе getSquare который следует статически подключить и вызвать метод getSquare для вычисления площади круга.

Приведите исходные коды классов Radius и Task с учетом заданной структуры пакетов.
*/

package mypackage; //объявить пакетик
import static java.lang.Math.PI; //импортировать пи

public class Radius {
	public static double getSquare(int a) {
		if(a<0) { //проверка радиуса на отрицательное значение
			return -1; //вернуть -1
		} else {
			return PI*Math.pow(a,2); //вернуть расчёты
		}
	}
}
