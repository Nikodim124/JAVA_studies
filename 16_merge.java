/*
Задача, поставленная разработчику, звучит следующим образом:

Компания PineApple анализирует продажи подразделений, расположенных в разных магазинах, на определенную дату. Аналитикам компании необходима возможность отсортировать магазины по возрастанию объемов продаж.

Использованный ранее метод sortSales хорошо себя показал при работе с аналитикой по странам. Однако когда аналитики попытались применить тот же метод для сортировки данных по магазинам, приложение долго не отвечало на запросы пользователей, после чего сообщило об ошибке timeout.
Тестировщик проанализировал жалобу пользователей и сделал вывод, что метод sortSales работает крайне медленно, если объем данных о продажах превышает 1000 элементов.
Организация PineApple владеет 30 000 магазинов по всему миру, поэтому при анализе данных по всем магазинам метод sortSales недостаточно производителен.

Необходимо в приложение добавить статический метод sortStoresSales, который не возвращает значение, но сортирует данные о продажах. В метод sortStoresSales должны передаваться 2 массива данных:

Массив идентификаторов магазинов (строки);
Массив данных о продажах (действительные числа).
Данные, которые будут передаваться в метод, по умолчанию синхронизированы (0-й элемент массива данных о продажах соответствует 0-му элементу массива магазинов, 1-й - 1-му и т.д.).

Необходимо реализовать следующую логику работы метода:

Если в метод были переданы поврежденные данные (размеры массивов не соответствуют друг другу), необходимо вывести на консоль сообщение "Corrupted Data" и не выполнять сортировки;
Если в метод были переданы пустые массивы, необходимо вывести на консоль сообщение "Empty Data" и не выполнять сортировки;
Во всех остальных случаях необходимо выполнить сортировку обоих массивов с учетом следующих требований:
необходимо использовать алгоритм сортировки слиянием;
необходимо, чтобы алгоритм выполнялся полностью не дольше 1,2 секунд;
сортировку необходимо провести синхронно, т. е. если осуществляется перестановка значений в массиве данных о продажах, должна осуществляться аналогичная (по индексам) перестановка в массиве идентификаторов магазинов;
после завершения сортировки каждого из массивов на каждом из этапов слияния на экран должен выводиться результат сортировки на этом этапе; для вывода на экран используйте метод printData (см. ниже). 


Приведи фрагмент кода, который определяет публичный статичный метод sortStoresSales в соответствии с приведенным описанием задачи.
*/

public static void sortStoresSales(String[] c, double[] s) {
	if (s.length != c.length) { //проверка на равность массивов
		System.out.println("Corrupted Data");
	} else if (s.length == 0 && c.length == 0) { //проверка на наличие элементов
		System.out.println("Empty Data");
	} else {
		double[] s1 = new double[s.length / 2]; //заводим новый контейнер в половину длины
		String[] c1 = new String[c.length / 2]; //то же для строк
		double[] s2 = new double[s.length - s1.length]; //вторая часть
		String[] c2 = new String[c.length - c1.length]; //то же для строк
		for (int i = 0; i < s.length; i++) { //наполняем части массивов
			if(i < s1.length) {
				s1[i] = s[i];
				c1[i] = c[i];
			} else {
				s2[i - s1.length] = s[i];
				c2[i - c1.length] = c[i];
			}
		}
		if(s2.length>1) { //проверяем, дошёл ли массив до одного элемента
				sortStoresSales(c1, s1); //иначе делим дальше
				sortStoresSales(c2, s2); //то же для строк
		}
		int s1index = 0; //заводим индексацию для первой половины массива
		int c1index = 0; //то же для строк
		int s2index = 0; //и для второй части
		int c2index = 0; //то же для строк
		for (int i = 0; i < s.length; i++) { //пробегаем по массиву для слияния
			if(s1index==s1.length && s2index<s2.length) { //если правая часть массива не закончена
				s[i] = s2[s2index++];
				c[i] = c2[c2index++];
			} else if (s2index==s2.length && s1index<s1.length) { //если левая часть массива не закончена
				s[i] = s1[s1index++];
				c[i] = c1[c1index++];
			} else {
				s[i] = (s1[s1index]<s2[s2index])?s1[s1index++]:s2[s2index++]; //непосредственно сортировка
				c[i] = (s1[c1index]<s2[c2index])?c1[c1index++]:c2[c2index++]; //то же для строк
			}
		printData(c, s); //вывод
		}
	}
}

private static void printData(String[] names, double[] data) {
    System.out.print("{");
    for (int i=0; i<data.length;i++){
        System.out.print(names[i]+": "+data[i]+", ");
    }
    System.out.println("\b\b}");
}