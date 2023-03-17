package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Random;

import javax.swing.AbstractButton;

import model.Util;
import model.decorator.BlackSugar;
import model.decorator.CheeseJelly;
import model.decorator.EggPudding;
import model.decorator.FruitJelly;
import model.decorator.IMilkTea;
import model.decorator.LotusSeeds;
import model.decorator.MatchaMilkTea;
import model.decorator.SocolateMilkTea;
import model.decorator.TaroMilkTea;
import model.decorator.TraditionalMilkTea;
import model.decorator.WhiteSugar;
import model.observer.MilkTeaData;
import model.singleton.LoggSingleton;
import model.singleton.Logging;
import view.BillView;
import view.OrderView;

public class Controller implements ActionListener {
	MilkTeaData milkTeaData = new MilkTeaData();
	OrderView orderView;
	BillView billView = new BillView(milkTeaData);
	LoggSingleton logg = LoggSingleton.getInstance(milkTeaData);

	public Controller(OrderView view) {
		this.orderView = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();// lấy ra hành động vừa thực hiện
		if (action.equals("Mua")) {
			IMilkTea milkTeaCategory = this.milkTeaSelected();
			IMilkTea toppings = null;
			double moneyInput = Double.parseDouble(orderView.lbMoney.getText());// lấy ra số tiền đã nạp
			
			if (milkTeaCategory == null) {
				this.orderView.warning("Vui lòng chọn 1 loại trà sữa.");
			} else {
				toppings = this.decoratorMilkTea(this.getToppingName(), 0, milkTeaCategory);
				double cost = toppings.cost();// lấy ra được tổng tiền khi mua trà sữa và topping
				if (moneyInput < cost) {
					this.orderView.warning("Số tiền không đủ.");
				} else {
					String employeeCode = Util.createRandomCode();
					String billCode = Util.createRandomCode();
					String milkTeaName = this.getMilkTea();
					ArrayList<String> listToppings = this.getToppingName();
					double refundMoney = moneyInput - cost;// tính số tiền còn lại 
					orderView.setLabelMoney(refundMoney);// set số tiền còn lại vào labelMoney trong orderView
					milkTeaData.setChanged(milkTeaName, listToppings, cost, moneyInput, refundMoney, employeeCode,
							billCode, Util.getDateNow());//dùng để notify đến BillView và LoggSingleton(dùng mẫu Observer)
				}

			}
		} else if (action.equals("Bỏ chọn")) {
			this.orderView.cancelButton();
		} else if (action.equals("Nạp tiền")) {
			String soTien_String = orderView.getMoneyInput();
			try {
				double soTien = Double.valueOf(soTien_String);
				orderView.setLabelMoney(soTien);
			} catch (Exception e2) {
				this.orderView.warning("Số tiền nhập vào không hợp lệ.");
			}
		}
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
	
	/**
	 * từ danh sách topping người dùng chọn thì ta sẽ decorator cho trà sữa
	 * dùng đệ quy để thực hiện
	 * index sẽ là chỉ mục của các topping trong list, vừa dùng để làm điều kiện dừng kết thúc đệ quy
	 * milkTeaCategory là loại trà sữa mà người dùng chọn
	 */
	public IMilkTea decoratorMilkTea(ArrayList<String> list, int index, IMilkTea milkTeaCategory) {
		if (index < list.size()) {
			String toppingName = Util.splitName(list.get(index));
			index = index + 1;
			if (toppingName.equals(BlackSugar.getName()))
				return new BlackSugar(decoratorMilkTea(list, index, milkTeaCategory));
			else if (toppingName.equals(CheeseJelly.getName()))
				return new CheeseJelly(decoratorMilkTea(list, index, milkTeaCategory));
			else if (toppingName.equals(EggPudding.getName()))
				return new EggPudding(decoratorMilkTea(list, index, milkTeaCategory));
			else if (toppingName.equals(WhiteSugar.getName()))
				return new WhiteSugar(decoratorMilkTea(list, index, milkTeaCategory));
			else if (toppingName.equals(LotusSeeds.getName()))
				return new LotusSeeds(decoratorMilkTea(list, index, milkTeaCategory));
			else if (toppingName.equals(FruitJelly.getName()))
				return new FruitJelly(decoratorMilkTea(list, index, milkTeaCategory));
		}
		return milkTeaCategory;
	}

	/**
	 * lấy ra đối tượng trà sữa được chọn
	 */
	public IMilkTea milkTeaSelected() {
		String milkTeaName = Util.splitName(this.getMilkTea());
		if (milkTeaName.equals(SocolateMilkTea.getName()))
			return new SocolateMilkTea();
		else if (milkTeaName.equals(MatchaMilkTea.getName()))
			return new MatchaMilkTea();
		else if (milkTeaName.equals(TaroMilkTea.getName()))
			return new SocolateMilkTea();
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

}
