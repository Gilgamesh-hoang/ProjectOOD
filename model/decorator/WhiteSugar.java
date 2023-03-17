package model.decorator;

public class WhiteSugar extends MilkTeaDecorator {

	public WhiteSugar(IMilkTea inner) {
		super(inner);
	}
	@Override
	public double cost() {
		return this.priceOfTopping() + super.cost();
	}

	@Override
	public double priceOfTopping() {
		return 32d;
	}
	public static String getName() {
		return "Trân châu trắng";
	}
}
