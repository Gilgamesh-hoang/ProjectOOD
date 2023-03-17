package model.decorator;

public class TaroMilkTea implements IMilkTea {

	public double cost() {
		return 15d;
	}

	public static String getName() {
		return "Trà sữa khoai môn";
	}
}
