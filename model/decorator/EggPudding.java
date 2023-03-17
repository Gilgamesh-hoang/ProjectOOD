package model.decorator;

public class EggPudding extends MilkTeaDecorator {

	public EggPudding(IMilkTea inner) {
		super(inner);
	}
	@Override
	public double cost() {
		return this.priceOfTopping() + super.cost();
	}

	@Override
	public double priceOfTopping() {
		
		return 8d;
	}
	public static String getName() {
		return "Pudding trứng";
	}
}
