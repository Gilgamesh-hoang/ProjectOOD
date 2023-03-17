package model.decorator;

public class FruitJelly extends MilkTeaDecorator {

	
	public FruitJelly(IMilkTea inner) {
		super(inner);
	}
	@Override
	public double cost() {
		return this.priceOfTopping() + super.cost();
	}

	@Override
	public double priceOfTopping() {
		
		return 1d;
	}
	public static String getName() {
		return "Thạch rau câu";
	}
}
