package model.decorator;

public class BlackSugar extends MilkTeaDecorator {

	public BlackSugar(IMilkTea inner) {
		super(inner);
	}
	@Override
	public double cost() {
		return this.priceOfTopping() + super.cost();
	}

	@Override
	public double priceOfTopping() {
		return 16d;
	}
	public static String getName() {
		return "Trân châu đen";
	}

}
