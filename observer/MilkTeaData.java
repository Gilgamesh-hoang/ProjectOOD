package observer;

import java.util.ArrayList;
import java.util.List;

public class MilkTeaData implements SubjectMilkTea {
	private List<ObserverMilkTea> listObserver;
	private String milkTeaName;
	private List<String> listToppings;
	private double cost;
	private double moneyInput;
	private double refundMoney;
	private String employeeCode;
	private String billCode;
	private String dateNow;

	public MilkTeaData() {
		this.listObserver = new ArrayList<>();
	}

	@Override
	public void addMilkTea(ObserverMilkTea observer) {
		if (!listObserver.contains(observer))
			listObserver.add(observer);
	}

	@Override
	public void removeMilkTea(ObserverMilkTea observer) {
		listObserver.remove(observer);
	}

	@Override
	public void notifyObserver() {
		for (ObserverMilkTea observer : listObserver) {
			observer.update(milkTeaName, listToppings, cost, moneyInput, refundMoney, employeeCode, billCode, dateNow);
		}

	}

	public void setChanged(String milkTeaName, List<String> listToppings, double cost, double moneyInput,
			double refundMoney, String employeeCode, String billCode, String dateNow) {
		this.milkTeaName = milkTeaName;
		this.listToppings = listToppings;
		this.cost = cost;
		this.moneyInput = moneyInput;
		this.refundMoney = refundMoney;
		this.employeeCode = employeeCode;
		this.billCode = billCode;
		this.dateNow = dateNow;
		notifyObserver();
	}

}
