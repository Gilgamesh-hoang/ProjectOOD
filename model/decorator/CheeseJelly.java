package model.decorator;

public class CheeseJelly extends MilkTeaDecorator {

	public CheeseJelly(IMilkTea inner) {
		super(inner);
	}

	@Override
	public double cost() {
		return this.priceOfTopping() + super.cost();
	}

	@Override
	public double priceOfTopping() {
		
		return 2d;
	}
	public static String getName() {
		return "Thạch phô mai";
	}
}
