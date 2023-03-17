package model.decorator;

public class MatchaMilkTea implements IMilkTea {

	public double cost() {
		return 20d;
	}

	public static String getName() {
		return "Trà sữa matcha";
	}
}
