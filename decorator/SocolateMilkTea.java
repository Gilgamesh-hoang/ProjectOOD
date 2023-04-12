package decorator;

public class SocolateMilkTea implements IMilkTea {
	private static double price = 25;
	@Override
	public double cost() {
		return price;
	}
	public static double getPrice() {
		return price;
	}
	public static String getName() {
		return "Trà sữa Socola";
	}

}
