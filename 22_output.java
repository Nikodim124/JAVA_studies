/*
Менеджерам банка «Кредит Банк» требуется быстро вычислять сумму ежемесячных платежей по кредитам потенциальных клиентов.

Руководитель команды разработки поставил тебе задачу реализовать утилиту расчета ежемесячных платежей на основании введенных данных о клиенте и условиях кредитования.

Для реализации поставленной задачи тебе необходимо реализовать класс CreditCalculator в пакете com.intellekta.creditbank, удовлетворяющий следующим условиям:

1. В классе должны быть определены поля:
	lastName (тип данных - String) – фамилия человека, имеющего кредит;
	firstName (тип данных - String) – имя человека, имеющего кредит;
	secondName (тип данных - String) – отчество человека, имеющего кредит;
	sum (тип данных - double) – сумма кредита;
	loanMaturity (тип данных - int) – срок погашения кредита;
	interestRate (тип данных - double) – процентная ставка по кредиту.
2.  В классе должен быть реализован конструктор без параметров, который будет собирать данные о пользователе с помощью консоли и заполнять поля объекта данными, введенными пользователем.

3. В классе должен быть реализован метод printCreditAgreement, который не принимает параметры и не возвращает значения. Метод должен выводить на консоль сумму ежемесячного платежа для клиента в виде действительного числа с точностью до копеек.

Необходимо обеспечить выполнение следующих требований к алгоритму ввода данных:

1) Утилита должна выводить информацию о том, какие данные должен ввести пользователь в следующей последовательности и в формате:

«Lastname: »
«Firstname: »
«Secondname: »
«Interest rate: »
«Credit amount: »
«Loan maturity: »

2) При вводе данных должна осуществляться проверка вводимых данных, и если пользователь ввел некорректные данные, должно выводиться предупреждение и новое приглашение ввода данных (для того поля, значение которого пользователь ввел некорректно)

3) При выводе предупреждений необходимо руководствоваться следующими правилами:

если пользователь ввел в качестве Lastname пустую строку, выводить предупреждение: «Lastname is incorrect. It must be not empty string»;
если пользователь ввел в качестве Firstname пустую строку, выводить предупреждение: «Firstname is incorrect. It must be not empty string»;
если пользователь ввел в качестве Interest rate значение, не являющееся действительным положительным числом, выводить предупреждение: «Interest rate is incorrect. It must be strictly positive number»;
если пользователь ввел в качестве Credit amount значение, не являющееся действительным положительным числом, выводить предупреждение: «Credit amount is incorrect. It must be strictly positive number»;
если пользователь ввел в качестве Loan maturity значение, не являющееся целым положительным числом, выводить предупреждение: «Loan maturity is incorrect. It must be strictly positive int».

Примечание:
Кредит выплачивается аннуитетными платежами (т. е. каждый месяц человек, имеющий кредит, должен выплачивать фиксированную сумму, состоящую из части от общей суммы долга и начисленных процентов). Формула для расчетов данного вида платежей представлена ниже:

Pl = (S * (Pg/(12*100))) / (1 - (1 + Pg/(12*100))^(-T))

где Pl – размер ежемесячного платежа, S – общая сумма кредита, Pg – размер годовой процентной ставки, Т – время выплаты кредита (в месяцах).

Для возведения в степень можно использовать статический метод pow класса Math.

В качестве ответа на задание приведи исходный код разработанного класса CreditCalculator.
*/

public class CreditCalculator {
	String lastName; //заводим переменные
	String firstName;
	String secondName;
	double sum;
	int loanMaturity;
	double interestRate;

	public CreditCalculator() {
		Scanner a = new Scanner(System.in);
		boolean invalid_in = true; //флажок для ввода
		int i;
		double d;
		String s; //временные хранилища
		System.out.print("Lastname: "); //выводим сообщение
		s = a.nextLine(); //просим значение
		while (s.length() == 0) { //проверяем
			System.out.println("Lastname is incorrect. It must be not empty string");
			System.out.print("Lastname: " + a.nextLine());
		}
		lastName = s; //присваиваем
		System.out.print("Firstname: "); //выводим сообщение
		s = a.nextLine(); //просим значение
		while (s.length() == 0) { //проверяем
			System.out.println("Firstname is incorrect. It must be not empty string");
			System.out.print("Firstname: " + a.nextLine());
		}
		firstName = s; //присваиваем
		System.out.print("Secondname: "); //выводим сообщение
		s = a.nextLine(); // просим значение
		secondName = s; //присваиваем
		while (invalid_in) { //заходим в цикл
			System.out.print("Interest rate: "); //выводим сообщение
			if (a.hasNextDouble()) { //ищем double
			d = a.nextDouble(); //запоминаем
				if (d > 0) { //проверяем
					invalid_in = false;
					interestRate = d; //присваиваем
				} else {
					System.out.println("Interest rate is incorrect. It must be strictly positive number");
				}
			} else {
				System.out.println("Interest rate is incorrect. It must be strictly positive number");
				a.next(); //обнуляем
			}
		}
		invalid_in = true; //обнуляем переменную для цикла
		while (invalid_in) { //заходим в цикл
			System.out.print("Credit amount: "); //выводим сообщение
			if (a.hasNextDouble()) { //ищем double
				d = a.nextDouble(); //запоминаем
				if (d > 0) { //проверяем
					invalid_in = false;
					sum = d; //присваиваем
				} else {
					System.out.println("Credit amount is incorrect. It must be strictly positive number");
				}
			} else {
				System.out.println("Credit amount is incorrect. It must be strictly positive number");
				a.next(); //обнуляем
			}
		}
		invalid_in = true; //обнуляем переменную для цикла
		while (invalid_in) { //заходим в цикл
			System.out.print("Loan maturity: "); //выводим сообщение
			if (a.hasNextInt()) { //ищем int
				i = a.nextInt(); //запоминаем
				if (i > 0) { //проверяем
					invalid_in = false;
					loanMaturity = i; //присваиваем
				} else {
				Systemem.out.println("Loan maturity is incorrect. It must be strictly positive int");
				}
			} else {
				System.out.println("Loan maturity is incorrect. It must be strictly positive int");
				a.next(); //обнуляем
			}
		}
		printCreditAgreement(); //идём считать
	}

	public void printCreditAgreement() {
		double Pl; //заводим переменную
		Pl = (sum * (interestRate/(12*100))) / (1 - (Math.pow(1 + interestRate/(12*100), -loanMaturity))); //подсчёт
		System.out.printf("%1.2f%n", Pl); //вывод с точностью до копеек
	}
}