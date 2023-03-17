package Test;
import javax.swing.UIManager;

import view.OrderView;

public class Main {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			OrderView view = new OrderView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
