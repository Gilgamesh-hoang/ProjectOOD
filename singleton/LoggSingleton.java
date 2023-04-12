package singleton;

import java.util.ArrayList;
import java.util.List;

import observer.MilkTeaData;
import observer.ObserverMilkTea;

public class LoggSingleton implements ObserverMilkTea {
	private static LoggSingleton instance = null;
	private ArrayList<Logging> listLogg;

	private LoggSingleton(MilkTeaData data) {
		data.addMilkTea(this);
		listLogg = new ArrayList<>();
	}

	// dùng singleton pattern để tạo ra nhật kí mua trà sữa
	public static LoggSingleton getInstance(MilkTeaData data) {
		if (instance == null) {
					instance = new LoggSingleton(data);
		}
		return instance;
	}

	public void printListLogg() {
		for (int i = 1; i <= listLogg.size(); i++)
			System.out.println(i + ". " + listLogg.get(i - 1).toString());
		System.out.println("------------------------");
	}

	@Override
	public void update(String milkTeaName, List<String> listToppings, double cost, double moneyInput,
			double refundMoney, String employeeCode, String billCode, String dateNow) {
		listLogg.add(new Logging(milkTeaName, listToppings, billCode, employeeCode, dateNow, cost));
		printListLogg();
	}
}
