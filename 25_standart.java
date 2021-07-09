/*
Фирма RandomMoney работает с биржей акций и различных валют. Они хотят заработать на продаже акции другой компании. 
Стоимость акции изменяется в зависимости от времени. Данную зависимость описывает функция y = 5*sin(1/2 * t), где y – цена акции, а t – время. 
Компания в случайный момент времени продает часть акций. Если значение функции больше нуля, 
то компания совершила выгодную продажу, иначе – понесла убыток. 

Тебе поставили задачу разработать соответствующее приложение.

Требуется создать пакет com.intellekta.randommoney, а в нем класс RandomMoney, удовлетворяющий следующим условиям:

1. В классе определено поле double price с геттером.
2. В классе определен публичный метод void sale(), принимающий в качестве параметра количество акций для продажи и время продажи (действительное число).
3. Метод sale() должен соответствовать следующим требованиям:

-метод вычисляет и сохраняет в поле price текущую стоимость акций, вычисленную по указанной в требованиях формуле (t-time);
-метод вычисляет финансовый результат сделки на основе произведения числа продаваемых акций на текущую стоимость акций;
-если финансовый результат положительный, метод должен выводить на экран сообщение: 
«The company has earned USD» с точностью до двух знаков после запятой, без перевода на новую строку;
-если финансовый результат нулевой, метод должен выводить на экран сообщение: 
«The company did not earn anything and did not lose on the sale» без перевода на новую строку;
-если финансовый результат отрицательный, метод должен выводить на экран сообщение: 
«The company has lost USD» с точностью до двух знаков после запятой, без перевода на новую строку.

4. В классе должен быть определен публичный метод testSale, который не принимает параметры, 
но трижды вызывает метод sale с произвольными целыми значениями для количества продаваемых акций и произвольными действительными значениями от 0 до 50 для времени продажи.

В качестве ответа приведи исходный код класса RandomMoney.
*/

package com.intellekta.randommoney;
import static java.lang.Math.sin;
import java.util.Random;

public class RandomMoney {
	private double price; //наша стоимость

	public double getPrice() { //геттер
		return price;
	}

	public void sale(int a, double t) {
		double y = 5* sin(1/2.0 * t); //вычисляем стоимость
		price = y; //устанавливаем
		double res = y*a; //вычисляем результат торгов
		if (res > 0) { //проверяем прибыль
			System.out.printf("The company has earned %8.2f USD",res);
		} else if (res == 0) { //проверяем 0
			System.out.printf("The company did not earn anything and did not lose on the sale");
		} else { //проверяем убытки
			System.out.printf("The company has lost %8.2f USD",-res);
		}
	}

	public void testSale() {
		int i = 50;
		Random r = new Random();
		double b = r.nextDouble()+r.nextInt(i+1); //рандомим время
		int a = (int)(Math.random()*100); //рандомим количество
		sale(a, b);
	}
}
