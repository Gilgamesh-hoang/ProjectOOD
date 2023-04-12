package decorator;

public class TaroMilkTea implements IMilkTea {
	private static double price = 15;
	public double cost() {
		return price;
	}
	public static double getPrice() {
		return price;
	}
	public static String getName() {
		return "Trà sữa khoai môn";
	}
}
