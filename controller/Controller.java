package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import Util.Util;
import decorator.IMilkTea;
import factory.Factory;
import factory.FactoryMilkTea;
import observer.MilkTeaData;
import singleton.LoggSingleton;
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
			Factory factoryMilkTea = new FactoryMilkTea(orderView);
			IMilkTea milkTea = factoryMilkTea.milkTeaSelected();// lấy ra trà sữa được chọn
			double moneyInput = Double.parseDouble(orderView.lbMoney.getText());// lấy ra số tiền đã nạp
			
			if (milkTea == null) {
				this.orderView.warning("Vui lòng chọn 1 loại trà sữa.");
			} else {
				milkTea = factoryMilkTea.createMilkTea(milkTea);// tạo ra trà sữa
				double cost = milkTea.cost();// lấy ra được tổng tiền khi mua trà sữa và topping
				if (moneyInput < cost) {
					this.orderView.warning("Số tiền không đủ.");
				} else {
					String employeeCode = Util.createRandomCode();
					String billCode = Util.createRandomCode();
					String milkTeaName = factoryMilkTea.getMilkTeaName();
					List<String> listToppings = factoryMilkTea.getListTopping();
					double refundMoney = moneyInput - cost;// tính số tiền còn lại 
					orderView.setLabelMoney(refundMoney);// set số tiền còn lại vào labelMoney trong orderView
					milkTeaData.setChanged(milkTeaName, listToppings, cost, moneyInput, refundMoney, employeeCode,
							billCode, Util.getDateNow());//dùng để notify đến BillView và LoggSingleton(dùng mẫu Observer)
				}

			}
		} else if (action.equals("Bỏ chọn")) {
			this.orderView.cancelButton();
		} else if (action.equals("Nạp tiền")) {
			try {
				double soTien = Double.valueOf(orderView.getMoneyInput());
				orderView.setLabelMoney(soTien);
			} catch (Exception e2) {
				this.orderView.warning("Số tiền nhập vào không hợp lệ.");
			}
		}
	}

}
