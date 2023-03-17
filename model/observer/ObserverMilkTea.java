package model.observer;

import java.util.List;

public interface ObserverMilkTea {
	void update(String milkTeaName, List<String> listToppings, double cost, double moneyInput,
			double refundMoney, String employeeCode, String billCode, String dateNow);
}
