package decorator;

public class EggPudding extends MilkTeaDecorator {
	private static double price = 8;

	public EggPudding(IMilkTea inner) {
		super(inner);
	}
	@Override
	public double cost() {
		return price + super.cost();
	}
	public static double getPrice() {
		return price;
	}
	public static String getName() {
		return "Pudding trứng";
	}
	
	
}
