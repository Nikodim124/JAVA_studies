/*
В операционный офис компании PinApple из регионального представительства в Китае поступили сведения о клиентах компании. Операционному офису PinApple требуется выбрать всех клиентов, являющихся юридическими лицами, и передать их в формате CSV в аналитический отдел для подготовки коммерческих предложений.
 
Из-за того что данные поступили смешанными (в данных присутствуют как физические лица, так и юридические), специалисты операционного офиса не могут оперативно выполнить поставленную задачу, поэтому они обратились в отдел автоматизации с просьбой реализовать утилиту, которая бы позволила решать данную задачу максимально быстро.
 
Руководитель отдела автоматизации поставил тебе, как программисту, следующую задачу:
 
1. Создай пакет com.intellekta.pinapple.
2. В пакете com.intellekta.pinapple создай класс Client, определи в классе следующие поля:
	id (целое 12-тизначное число) – идентификационный номер клиента;
	type (строка) – тип клиента;
	name (строка) – название клиента;
	sum (действительное число) – сумма покупок клиента.
3. Определи конструктор класса, принимающий и инициализирующий значение параметров в следующей последовательности:
	id;
	type;
	name;
	sum.
4. В конструкторе реализуй проверку переданных параметров в соответствии со следующей логикой:
	если id меньше 100000000000, то установи значение id в 100000000000;
	если type не равно “institution” и не равно “individual”, установи значение type в “institution”;
	если name не определено (null), установи значение name в “Default”;
	если sum меньше 0, установи значение sum в 0.
5. В пакете com.intellekta.pinapple определи класс ClientClassifier. В классе определи публичный статический свободный метод getClientsByType, принимающий в качестве параметров:
	массив клиентов (clients);
	строку с целевым типом клиентов (type);
	массив клиентов для заполнения (result);
6. В методе getClientsByType реализуй алгоритм, который добавляет в массив result всех клиентов из массива clients, тип которых соответствует типу, переданному в метод (type).

При реализации метода учти сценарии его некорректного использования.
Если в метод был передан пустой или не существующий (null) массив клиентов, выведи на экран значение «Clients array is null or empty».
Если в метод был передан пустой или не существующий (null) массив для сохранения результатов, выведи на экран значение «Result array is null or empty».
Если в процессе выполнения алгоритма, количество искомых клиентов будет больше, чем размер массива result, выведи на экран значение «Result array length exceeded». Массив результатов должен содержать первых клиентов из массива clients, соответствующих заявленному типу.
7. В классе ClientClassifier определи публичный статический свободный метод printClients, который принимает в качестве параметров массив клиентов.
8. В методе printClients реализуй алгоритм вывода на экран сведений о каждом клиенте из массива в следующем формате: «{id};{name};{type};{sum}\n». Если переданный в метод printClients массив был пустым или не существующим (null), метод не должен выполнять никаких действий.

В качестве ответа приведи исходные коды:
	1. Класса Client;
	2. Класса ClientClassifier.
*/

public class Client {

	final String TYPE1 = "institution"; //вот так?
	final String TYPE2 = "individual";
	long id;
	String type;
	String name;
	double sum; //заводим переменные

	public Client(long id, String type, String name, double sum) { //заводим конструктор
		if (id < 100000000000L) { //проверяем данные id
			this.id = 100000000000L;
		} else {
			this.id = id;
		}
		if (type != TYPE1 && type != TYPE2) { //проверяем данные type
			this.type = TYPE1;
		} else {
			this.type = type;
		}
		if (name == null) { //проверяем данные name
			this.name = "Default";
		} else {
			this.name = name;
		}
		if (sum < 0) { //проверяем данные sum
			this.sum = 0;
		} else {
			this.sum = sum;
		}
	}
}

public class ClientClassifier {
	public static void getClientsByType(Client[] clients, String type, Client[] result) {
		int n = 0; //заводим флажок для отслеживаения конца result
		String a = type.intern();
		if (clients == null) { //проверка clients на null
			System.out.println("Clients array is null or empty");
		} else if (clients.length == 0) { //проверка clients на пустой массив
			System.out.println("Clients array is null or empty");
		} else if (result == null) { //проверка result на null
			System.out.println("Result array is null or empty");
		} else if (result.length == 0) { //проверка result на пустой массив
			System.out.println("Result array is null or empty");
		} else {
			for (Client i : clients) { //бежим по клиентам
				if (i.type == a) { //ищем нужных
					if (n == result.length) { //проверяем место в result
						System.out.println("Result array length exceeded");
						break; //заканчиваем запись
					} else {
						result[n] = i; //иначе записываем клиента в result
						n+=1;
					}
				}
			}
		}
	}

	public static void printClients(Client[] clients) {
		if (clients == null) { //проверка на null
			//пропускаем
		} else if (clients.length == 0) { //проверка на пустой массив
			//пропускаем
		} else {
			for (int i = 0; i < clients.length; i++) { //бежим по массиву
				if (clients[i] != null) { //отсекаем пустые ячейки
					System.out.println("«{"+clients[i].id+"}; {"+clients[i].name+"}; {"+clients[i].type+"}; {"+clients[i].sum+"}»");
				} //вывод
			}
		}
	}
}