package model.decorator;

public class TraditionalMilkTea implements IMilkTea {

	public double cost() {
		return 10d;
	}

	public static String getName() {
		return "Trà sữa truyền thống";
	}
}
