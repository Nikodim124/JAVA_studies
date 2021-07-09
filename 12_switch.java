/*
Задача, поставленная разработчику, звучит следующим образом:

Необходимо в приложение добавить статический метод sayHello, 
который не возвращает значение, но выводит в консоль приветствие. 
В метод sayHello должны передаваться параметры, с которыми было запущено приложение. 
Приложение можно запускать с параметрами "-u", "-s", "-su" или "-us". 
Необходимо реализовать логику приложения по следующим бизнес-правилам.

Если приложение вызвано с параметром "-u", оно должно выдавать приветствие 
в формате "Hello, < имя_пользователя >!", где < имя_пользователя > — это имя пользователя системы.
Если приложение вызвано с параметром "-s", оно должно выдавать приветствие 
в формате "Hello, < название_операционной_системы >!", 
где < название_операционной_системы > — это название операционной системы, в которой запущено приложение.
Если приложение вызвано с параметром "-su" или "-us" оно должно выдавать приветствие 
в формате "Hello, < имя_пользователя > of < название_операционной_системы >!".
Во всех остальных случаях приложение должно выдавать приветствие в формате "Hello!".
Приведи фрагмент кода, который определяет публичный статичный метод sayHello 
в соответствии с приведенным описанием задачи. Используй оператор выбора для реализации заявленной логики.



Примечание 1. Для получения имени пользователя 
и названия операционной системы используй метод System.getProperty.

Примечание 2. Будь внимателен — пользователи не всегда ведут себя так, как заявлено в условиях задачи.

Примечание 3. Для проверки того, сколько параметров было передано приложению, 
используй команду args.length, где args — имя переменной массива параметров.
*/

public static void sayHello(String[] args) {
	String name = System.getProperty("user.name"); //получаем имя пользователя
	String os = System.getProperty("os.name"); //получаем имя системы
	if (args.length == 1) { //проверка количества параматров
		switch (args[0]){ //сравниваем параметр
			case "-u": //кейс с именем пользователя
				System.out.println("Hello, "+name+"!");
				break;
			case "-s": //кейс с именем системы
				System.out.println("Hello, "+os+"!");
				break;
			case "-us": //кейс с двойным обращением
				System.out.println("Hello, "+name+" of "+os+"!");
				break;
			case "-su": //второй вариант кейса с двойным обращением
				System.out.println("Hello, "+name+" of "+os+"!");
				break;
			default: //станлартное значение для любых других параметров
				System.out.println("Hello!");
		}
	} else { //случаи без параметров или с несколькими
		System.out.println("Hello!");
	}
}