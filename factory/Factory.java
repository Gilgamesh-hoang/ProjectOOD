package factory;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractButton;

import Util.Util;
import decorator.BlackSugar;
import decorator.CheeseJelly;
import decorator.EggPudding;
import decorator.FruitJelly;
import decorator.IMilkTea;
import decorator.LotusSeeds;
import decorator.MatchaMilkTea;
import decorator.SocolateMilkTea;
import decorator.TaroMilkTea;
import decorator.TraditionalMilkTea;
import decorator.WhiteSugar;
import view.OrderView;

public abstract class Factory {
	protected List<String> listTopping;
	protected OrderView orderView;
	protected String milkTeaName;
	
	
	public Factory(OrderView orderView) {
		this.orderView = orderView;
		listTopping = new ArrayList<>();
	}

	public abstract IMilkTea createMilkTea(IMilkTea milkTea);
	public abstract IMilkTea milkTeaSelected();
	public abstract String getMilkTeaName();
	public abstract List<String> getListTopping();
	
	

}