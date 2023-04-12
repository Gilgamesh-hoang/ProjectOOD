package decorator;

public class BlackSugar extends MilkTeaDecorator {
	private static double price = 16;

	public BlackSugar(IMilkTea inner) {
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
		return "Trân châu đen";
	}
	

}
