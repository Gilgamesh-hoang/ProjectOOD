package decorator;

public class MatchaMilkTea implements IMilkTea {
	private static double price = 20;
	public double cost() {
		return price;
	}
	public static double getPrice() {
		return price;
	}
	public static String getName() {
		return "Trà sữa matcha";
	}
}
