package decorator;

public class CheeseJelly extends MilkTeaDecorator {
	private static double price = 2;
	public CheeseJelly(IMilkTea inner) {
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
		return "Thạch phô mai";
	}
}
