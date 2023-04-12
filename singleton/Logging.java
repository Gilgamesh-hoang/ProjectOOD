package singleton;

import java.util.Arrays;
import java.util.List;

public class Logging {
	private String milkTeaName;
	private List<String> toppings;
	private String billCode;
	private String employeeCode;
	private String dateNow;
	private double cost;

	
	public Logging(String milkTeaName, List<String> toppings, String billCode, String employeeCode, String dateNow,
			double cost) {
		this.milkTeaName = milkTeaName;
		this.toppings = toppings;
		this.billCode = billCode;
		this.employeeCode = employeeCode;
		this.dateNow = dateNow;
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Trà sữa: " + milkTeaName + ",\nCác loại topping: " + Arrays.toString(toppings.toArray()) + ",\nMã hóa đơn: "
				+ billCode + ",\nMã nhân viên: " + employeeCode + ",\nNgày mua: "+ dateNow +",\nGiá: " + cost + "\n";
	}

}
