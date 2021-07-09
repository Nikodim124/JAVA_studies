/*
У компании существует три типа работников: с почасовой зарплатой, месячной и недельной. Требуется создать для каждого классы и общий интерфейс Staff, 
в котором будет метод int calculateSalary(int salary) для расчета зарплаты.  Все классы реализовать в пакете com.intellekta.staff.

Первый класс – class HourlyStaff – работники с почасовой зарплатой. 
В классе должно быть поле private int workTime, обозначающее количество отработанных в сутки часов, 
и геттер для него. Кроме того, должен быть реализован конструктор, 
в котором поле workTime инициализируется значением, лежащим в диапазоне от 4 до 10 часов. 
Если значение выходит за рамки диапазона, то присваивать workTime значение 0. 
И требуется реализовать метод int calculateSalary(int salary), который возвращает зарплату 
за отработанный промежуток времени (salary*workTime);

Второй класс – class MonthlyStaff – работники с месячной зарплатой. 
Класс должен иметь два приватных поля: int workDays, int premium, означающие 
количество отработанных дней и премию, а также геттеры для этих полей. 
В конструкторе инициализировать обе переменные передающимися значениями. 
Если количество отработанных дней меньше или равно нулю или больше 30, то присвоить 
переменной workDays значение 0. Если премия меньше нуля или больше 10000, 
то присвоить переменной premium значение 0, а также реализовать метод int calculateSalary(int salary), 
чтобы он возвращал зарплату за месяц, т. е. salary*workDays+premium.

От второго класса унаследовать класс WeeklyStaff – работники, которые работают две недели из четырех в месяц. 
В нем добавить приватную переменную workWeeks и геттер для нее. 
Реализовать конструктор, вызывающий базовый конструктор и инициализирующий 
переменную workWeeks значением в диапазоне от 2 до 4. При выходе значения из данного диапазона переменной 
присваивать значение 0. Переопределить метод int calculateSalary(int salary), 
чтобы тот возвращал зарплату за неделю, т. е. workWeeks*salary, а также добавить метод void printYearSalary, 
выводящий методом println годовую  зарплату работника, 
т. е. workWeeks*salary*26 (Количество недель в году -52, из них половина рабочих).

Привести исходные коды классов HourlyStaff, MonthlyStaff, WeeklyStaff и интерфейса Staff.
*/

//Исходный код класса HourlyStaff
public class HourlyStaff implements Staff {
	private int workTime;

	public HourlyStaff(int a) {
		if (4<=a && a<=10) { //проверяем часы работы
			workTime = a;
		} else {
			workTime = 0;
		}
	}

	public int getWorkTime() { //геттер
		return workTime;
	}

	@Override
	public int calculateSalary(int salary) {
		if (salary >= 0) {
			return (salary*getWorkTime()); //считаем и возвращаем
		} else {
			return (0*getWorkTime());
		}
	}
}

//Исходный код класса MonthlyStaff
public class MonthlyStaff implements Staff {
	private int workDays;
	private int premium;

	public MonthlyStaff(int a, int b) {
		if (0<a && a<=30) { //проверяем дни работы
			workDays = a;
		} else {
			workDays = 0;
		}
		if (0<=b && b<=10000) { //проверяем премию
			premium = b;
		} else {
			premium = 0;
		}
	}

	public int getWorkDays() { //геттер
		return workDays;
	}

	public int getPremium() { //геттер
		return premium;
	}

	@Override
	public int calculateSalary(int salary) {
		if (salary >= 0) {
			return (salary*getWorkDays()+getPremium()); //считаем и выводим
		} else {
			return (0*getWorkDays()+getPremium());
		}
	}
}

//Исходный код класса WeeklyStaff
public class WeeklyStaff extends MonthlyStaff implements Staff {
	private int workWeeks;

	public WeeklyStaff(int a, int b, int c) {
		super(a, b); //вызываем базовый конструктор
		if (2<=c && c<=4) {
			workWeeks = c; //записываем
		} else {
			workWeeks = 0;
		}
	}

	public int getWorkWeeks() { //геттер
		return workWeeks;
	}

	@Override
	public int calculateSalary(int salary) {
		if (salary>0) { //проверяем, что зарплата есть
			return (salary*getWorkWeeks()); //считаем и возвращаем
		} else {
			return (0*getWorkWeeks());
		}
	}

	public void printYearSalary(int salary) {
		if (salary>0) {
			System.out.println(getWorkWeeks()*salary*26); //считаем и выводим
		} else {
			System.out.println(getWorkWeeks()*0*26);
		}
	}
}

//Исходный код интерфейса Staff
public interface Staff{ //интерфейс
	int calculateSalary(int salary); //объявленный метод
}
