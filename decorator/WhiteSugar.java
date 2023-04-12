package decorator;

public class WhiteSugar extends MilkTeaDecorator {
	private static double price = 32;
	public WhiteSugar(IMilkTea inner) {
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
		return "Trân châu trắng";
	}
}
