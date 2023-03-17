package model.decorator;

public class LotusSeeds extends MilkTeaDecorator {

	public LotusSeeds(IMilkTea inner) {
		super(inner);
	}
	@Override
	public double cost() {
		return this.priceOfTopping() + super.cost();
	}

	@Override
	public double priceOfTopping() {
		
		return 4d;
	}
	public static String getName() {
		return "Hạt sen";
	}
}
