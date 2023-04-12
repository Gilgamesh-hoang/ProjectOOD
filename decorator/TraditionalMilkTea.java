package decorator;

public class TraditionalMilkTea implements IMilkTea {
	private static double price = 10;
	
	@Override
	public double cost() {
		return price;
	}
	public static double getPrice() {
		return price;
	}
	public static String getName() {
		return "Trà sữa truyền thống";
	}
}
