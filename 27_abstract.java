/*
Компания производит микроволновки двух типов – автоматически выключающиеся и те, 
которые по завершению таймера продолжают подогревать еду и требующие ручного выключения. Управление микроволновками осуществляется Java-приложением MicrowaveCC.

Вам необходимо доработать функционал приложения MicrowaveCC, в соответствии с указанными ниже требованиями.

При включении микроволновки, на её экране должно выводиться сообщение о том, что прибор начал работу. 
Для этого необходимо реализовать метод void printHeatingMode(), сообщающий о том, что прибор 
начал подогревать еду. Метод должен выводить сообщение «The device is in heating mode». 
Данный метод должен быть определен в отдельном интерфейсе DeviceMode. Также требуется создать абстрактный класс, 
оторый будет содержать в себе методы для включения и выключения микроволновки, назвав его DeviceFunction. 
Абстрактный класс должен реализовывать описанный выше интерфейс. В классе DeviceFunction реализовать 
метод printHeatingMode(), чтобы он выводил строку, указанную ранее. А также реализовать метод void deviceOn(), 
который выводит на консоль методом println строку «Device is ON». И ещё один метод void deviceOff(), 
который сделать абстрактным.

Далее создать 2 класса AutomaticMicrowave и ManualMicrowave, которые наследуются от абстрактного класса. 
В классе AutomaticMicrowave реализовать метод void deviceOff(), чтобы тот выводил методом println строку «Done». 
 в классе ManualMicrowave в этом же методе выводить так же строку «Waiting for new task».


Привести исходные коды интерфейса DeviceMode, абстрактного класса DeviceFunction и классов AutomaticMicrowave и ManualMicrowave. 
Все классы и интерфейсы задания должны быть описаны в пакете com.intellekta.microwavecc.
*/

//Исходный код интерфейса DeviceMode
public interface DeviceMode{

	void printHeatingMode(); //заводим функцию

}

//Исходный код абстрактного класса DeviceFunction
public abstract class DeviceFunction implements DeviceMode {

	@Override
	public void printHeatingMode() { //определяем функцию
		System.out.println("The device is in heating mode");
	}

	public void deviceOn() {
		System.out.println("Device is ON"); //работающая микроволновка
	}

	public abstract void deviceOff(); //определяем метод выключения

}

//Исходный код класса AutomaticMicrowave
public class AutomaticMicrowave extends DeviceFunction {

	@Override
	public void deviceOff() { //определяем автоматическое выключение
		System.out.println("Done");
	}
}

//Исходный код класса ManualMicrowave
public class ManualMicrowave extends DeviceFunction {

	@Override
	public void deviceOff() {
		System.out.println("Waiting for new task"); //определяем ручное выключение
	}
}