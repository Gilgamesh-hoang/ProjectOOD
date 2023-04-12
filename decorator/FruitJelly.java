package decorator;

public class FruitJelly extends MilkTeaDecorator {
	private static double price = 1;
	
	public FruitJelly(IMilkTea inner) {
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
		return "Thạch rau câu";
	}
}
