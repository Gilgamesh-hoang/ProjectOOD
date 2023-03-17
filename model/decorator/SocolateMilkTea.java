package model.decorator;

public class SocolateMilkTea implements IMilkTea {

	@Override
	public double cost() {
		return 25d;
	}

	public static String getName() {
		return "Trà sữa Socola";
	}

}
