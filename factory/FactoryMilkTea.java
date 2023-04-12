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

public class FactoryMilkTea extends Factory{
	

	public FactoryMilkTea(OrderView orderView) {
		super(orderView);
		// TODO Auto-generated constructor stub
	}

	/**
	 * từ danh sách topping người dùng chọn thì ta sẽ decorator cho trà sữa
	 * dùng đệ quy để thực hiện
	 * index sẽ là chỉ mục của các topping trong list, vừa dùng để làm điều kiện dừng kết thúc đệ quy
	 * milkTeaCategory là loại trà sữa mà người dùng chọn
	 */
	@Override
	public IMilkTea createMilkTea(IMilkTea milkTea) {
		milkTea = decoratorMilkTea(0, milkTea);
		return milkTea;
	}
	
	public IMilkTea decoratorMilkTea(int index, IMilkTea milkTeaCategory) {
		if (index < getListTopping().size()	) {
			String toppingName = Util.splitName(super.listTopping.get(index));
			index = index + 1;
			if (toppingName.equals(BlackSugar.getName()))
				return new BlackSugar(decoratorMilkTea(index, milkTeaCategory));
			else if (toppingName.equals(CheeseJelly.getName()))
				return new CheeseJelly(decoratorMilkTea(index, milkTeaCategory));
			else if (toppingName.equals(EggPudding.getName()))
				return new EggPudding(decoratorMilkTea(index, milkTeaCategory));
			else if (toppingName.equals(WhiteSugar.getName()))
				return new WhiteSugar(decoratorMilkTea(index, milkTeaCategory));
			else if (toppingName.equals(LotusSeeds.getName()))
				return new LotusSeeds(decoratorMilkTea(index, milkTeaCategory));
			else if (toppingName.equals(FruitJelly.getName()))
				return new FruitJelly(decoratorMilkTea(index, milkTeaCategory));
		}
		return milkTeaCategory;
	}
	/**
	 * lấy ra đối tượng trà sữa được chọn
	 */
	@Override
	public IMilkTea milkTeaSelected() {
		super.milkTeaName = getMilkTea();
		String milkTeaName = Util.splitName(this.milkTeaName);
		if (milkTeaName.equals(SocolateMilkTea.getName()))
			return new SocolateMilkTea();
		else if (milkTeaName.equals(MatchaMilkTea.getName()))
			return new MatchaMilkTea();
		else if (milkTeaName.equals(TaroMilkTea.getName()))
			return new TaroMilkTea();
		else if (milkTeaName.equals(TraditionalMilkTea.getName()))
			return new TraditionalMilkTea();
		else
			return null;
	}
	
	/**
	 * lấy ra sản phẩm được chọn ở dạng chuỗi vd: Trà sữa Socola (Giá: 25$)
	 */
	public String getMilkTea() {
		String milkTeaName = "";
		Enumeration<AbstractButton> buttonMilkTea = orderView.buttonGroupMilkTea.getElements();
		while (buttonMilkTea.hasMoreElements()) {
			AbstractButton button = buttonMilkTea.nextElement();
			if (button.isSelected()) {
				milkTeaName = button.getText();
				break;
			}
		}
		return milkTeaName;
	}
	
	/**
	 * lấy ra một danh sách các topping mà người dùng đã chọn
	 */
	public ArrayList<String> getToppingName() {
		ArrayList<String> list = new ArrayList<>();
		for (AbstractButton button : orderView.listTopping) {
			if (button.isSelected()) {
				list.add(button.getText());
			}
		}
		return list;
	}


	@Override
	public String getMilkTeaName() {
		if(super.milkTeaName == null)
			super.milkTeaName = getMilkTea();
		return super.milkTeaName;
	}

	@Override
	public List<String> getListTopping() {
		if(super.listTopping.isEmpty())
			super.listTopping = getToppingName();
		return super.listTopping;
	}


}
