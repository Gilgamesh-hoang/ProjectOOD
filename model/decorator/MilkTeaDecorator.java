package model.decorator;

public abstract class MilkTeaDecorator implements IMilkTea {
	private IMilkTea milkTea;


	protected MilkTeaDecorator(IMilkTea wrappee) {
		milkTea = wrappee;
	}

	@Override
	public double cost() {
		return milkTea.cost();
	}
	
	public abstract double priceOfTopping();

}
