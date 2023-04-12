package decorator;

public class LotusSeeds extends MilkTeaDecorator {
	private static double price = 4;
	public LotusSeeds(IMilkTea inner) {
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
		return "Hạt sen";
	}
}
