package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import javax.swing.SwingConstants;

public class OrderView extends JFrame {

	public JPanel contentPane;
	public JButton btnCancel;
	public JButton btnBuy;
	public JCheckBox cbTranChauDen;
	public JCheckBox cbPhoMai;
	public JCheckBox cbPudding;
	public JCheckBox cbTranChauTrang;
	public JCheckBox cbHatSen;
	public JCheckBox cbRauCau;
	public ButtonGroup buttonGroupMilkTea;
	public JRadioButton rbTsSocola;
	public JRadioButton rbTsMatcha;
	public JRadioButton rbTsTruyenThong;
	public JRadioButton rbTsKhoaiMon;
	public ArrayList<JCheckBox> listTopping = new ArrayList<>();
	public JLabel lbMoney;

	public OrderView() {
		this.init();
	}

	public void init() {
		Controller controller = new Controller(this);

		Font fontOrder = new Font("Tahoma", Font.PLAIN, 13);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbTitle = new JLabel("Chọn món");
		lbTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbTitle.setBounds(274, 10, 175, 40);
		contentPane.add(lbTitle);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(22, 49, 644, 646);
		tabbedPane.setFont(new Font("Dialog", Font.BOLD, 13));
		contentPane.add(tabbedPane);

		JPanel panelMilkTea = new JPanel();
		tabbedPane.addTab("Milk Tea", null, panelMilkTea, null);
		panelMilkTea.setLayout(null);

		JPanel panelTopping = new JPanel();
		tabbedPane.addTab("Topping", null, panelTopping, null);
		panelTopping.setLayout(null);

		JLabel lbTSTruyenThong = new JLabel("");
		lbTSTruyenThong.setBounds(43, 15, 226, 250);
		setImgInLabel(lbTSTruyenThong, "ts-truyen-thong.jpeg");
		panelMilkTea.add(lbTSTruyenThong);

		JLabel lbTSKhoaiMon = new JLabel("");
		lbTSKhoaiMon.setBounds(358, 15, 226, 250);
		setImgInLabel(lbTSKhoaiMon, "ts-khoai-mon.jpeg");
		panelMilkTea.add(lbTSKhoaiMon);

		JLabel lbTSMatcha = new JLabel("");
		lbTSMatcha.setBounds(43, 325, 226, 250);
		setImgInLabel(lbTSMatcha, "ts-matcha.jpeg");
		panelMilkTea.add(lbTSMatcha);

		JLabel lbTSSocola = new JLabel("");
		lbTSSocola.setBounds(358, 319, 226, 250);
		setImgInLabel(lbTSSocola, "ts-socola.jpeg");
		panelMilkTea.add(lbTSSocola);

		JLabel lbThachRauCau = new JLabel("");
		lbThachRauCau.setBounds(22, 27, 180, 235);
		setImgInLabel(lbThachRauCau, "thachraucau.jpeg");
		panelTopping.add(lbThachRauCau);

		JLabel lbThachCuNang = new JLabel("");
		lbThachCuNang.setBounds(436, 27, 180, 235);
		setImgInLabel(lbThachCuNang, "thachcunang.jpeg");
		panelTopping.add(lbThachCuNang);

		JLabel lbPudding = new JLabel("");
		lbPudding.setBounds(22, 327, 180, 235);
		setImgInLabel(lbPudding, "pudding.jpeg");
		panelTopping.add(lbPudding);

		JLabel lbKhucBach = new JLabel("");
		lbKhucBach.setBounds(436, 327, 180, 235);
		setImgInLabel(lbKhucBach, "tranchautrang.jpg");
		panelTopping.add(lbKhucBach);

		JLabel lbTranChau = new JLabel("");
		lbTranChau.setBounds(230, 327, 180, 235);
		setImgInLabel(lbTranChau, "tranchau.jpeg");
		panelTopping.add(lbTranChau);

		JLabel lbThachPhoMai = new JLabel("");
		lbThachPhoMai.setBounds(230, 27, 180, 235);
		setImgInLabel(lbThachPhoMai, "thachphomai.jpeg");
		panelTopping.add(lbThachPhoMai);

		rbTsTruyenThong = new JRadioButton("Trà sữa truyền thống (Giá: 10$)");
		rbTsTruyenThong.setFont(fontOrder);
		rbTsTruyenThong.setForeground(Color.BLACK);
		rbTsTruyenThong.setBounds(43, 277, 226, 21);
		panelMilkTea.add(rbTsTruyenThong);

		rbTsKhoaiMon = new JRadioButton("Trà sữa khoai môn (Giá: 15$)");
		rbTsKhoaiMon.setFont(fontOrder);
		rbTsKhoaiMon.setBounds(358, 277, 226, 21);
		panelMilkTea.add(rbTsKhoaiMon);

		rbTsMatcha = new JRadioButton("Trà sữa matcha (Giá: 20$)");
		rbTsMatcha.setFont(fontOrder);
		rbTsMatcha.setForeground(Color.BLACK);
		rbTsMatcha.setBounds(43, 581, 190, 21);
		panelMilkTea.add(rbTsMatcha);

		rbTsSocola = new JRadioButton("Trà sữa Socola (Giá: 25$)");
		rbTsSocola.setFont(fontOrder);
		rbTsSocola.setBounds(358, 581, 214, 21);
		panelMilkTea.add(rbTsSocola);

		buttonGroupMilkTea = new ButtonGroup();
		buttonGroupMilkTea.add(rbTsTruyenThong);
		buttonGroupMilkTea.add(rbTsKhoaiMon);
		buttonGroupMilkTea.add(rbTsMatcha);
		buttonGroupMilkTea.add(rbTsSocola);

		cbRauCau = new JCheckBox("Thạch rau câu (Giá: 1$)");
		cbRauCau.setFont(fontOrder);
		cbRauCau.setBounds(22, 268, 170, 29);
		panelTopping.add(cbRauCau);

		cbHatSen = new JCheckBox("Hạt sen (Giá: 4$)");
		cbHatSen.setFont(fontOrder);
		cbHatSen.setBounds(436, 268, 170, 29);
		panelTopping.add(cbHatSen);

		cbTranChauTrang = new JCheckBox("Trân châu trắng (Giá: 32$)");
		cbTranChauTrang.setFont(fontOrder);
		cbTranChauTrang.setBounds(436, 568, 180, 29);
		panelTopping.add(cbTranChauTrang);

		cbPudding = new JCheckBox("Pudding trứng (Giá: 8$)");
		cbPudding.setFont(fontOrder);
		cbPudding.setBounds(22, 568, 170, 29);
		panelTopping.add(cbPudding);

		cbPhoMai = new JCheckBox("Thạch phô mai (Giá: 2$)");
		cbPhoMai.setFont(fontOrder);
		cbPhoMai.setBounds(230, 268, 170, 29);
		panelTopping.add(cbPhoMai);

		cbTranChauDen = new JCheckBox("Trân châu đen (Giá: 16$)");
		cbTranChauDen.setFont(fontOrder);
		cbTranChauDen.setBounds(230, 568, 170, 29);
		panelTopping.add(cbTranChauDen);

		listTopping.add(cbTranChauTrang);
		listTopping.add(cbPhoMai);
		listTopping.add(cbPudding);
		listTopping.add(cbRauCau);
		listTopping.add(cbTranChauDen);
		listTopping.add(cbHatSen);

		btnBuy = new JButton("Mua");
		btnBuy.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBuy.setBounds(267, 754, 100, 35);
		btnBuy.addActionListener(controller);
		contentPane.add(btnBuy);

		btnCancel = new JButton("Bỏ chọn");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancel.setBounds(429, 754, 100, 35);
		btnCancel.addActionListener(controller);
		contentPane.add(btnCancel);
		
		JButton btnNapTien = new JButton("Nạp tiền");
		btnNapTien.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNapTien.setBounds(113, 754, 100, 35);
		btnNapTien.addActionListener(controller);
		contentPane.add(btnNapTien);
		
		 lbMoney = new JLabel("0");
		lbMoney.setHorizontalAlignment(SwingConstants.RIGHT);
		lbMoney.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbMoney.setBounds(587, 716, 61, 23);
		contentPane.add(lbMoney);
		
		JLabel lblTinCaBn = new JLabel("Tiền của bạn: ");
		lblTinCaBn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTinCaBn.setBounds(510, 716, 86, 23);
		contentPane.add(lblTinCaBn);
		
		JLabel lbMoney_1 = new JLabel("$");
		lbMoney_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lbMoney_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbMoney_1.setBounds(653, 716, 7, 23);
		contentPane.add(lbMoney_1);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 694, 850);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
	/** dùng để điều chỉnh kích thước(resize) của ảnh cho phù hợp với kích thước của lable */
	public void setImgInLabel(JLabel label, String imgName) {
		ImageIcon imgIcon = new ImageIcon("src\\imgs\\" + imgName);
		Image image = imgIcon.getImage();
		Image moddifi = image.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		imgIcon = new ImageIcon(moddifi);
		label.setIcon(imgIcon);
	}

	/** dùng để xóa bỏ hết các lựa chọn */
	public void cancelButton() {
		buttonGroupMilkTea.clearSelection();
		if (listTopping.size() > 0) {
			for (AbstractButton button : listTopping) {
				button.setSelected(false);
			}
		}
	}

	/**
	 * xuất hiện trong các trường hợp: chưa chọn trà sữa, nhập sai số tiền, không có đủ tiền
	 * this: xuất hiện trên frame hiện tại
	 * str: lỗi xảy ra
	 */
	public void warning(String str) {
		JOptionPane.showMessageDialog(this, str, "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
	}
	
	/** dùng để lưu lại số tiền, soTien+"" là để đưa sotien về kiểu String */
	public void setLabelMoney(double soTien) {
		lbMoney.setText(soTien+"");
	}
	
	/** xuất hiện khi nạp tiền, trả về là số tiền đã nạp ở kiểu string */
	public String getMoneyInput() {
		return (String) JOptionPane.showInputDialog(
				this,
	               "Nhập vào số tiền:",
	                "Thông báo",
	                JOptionPane.PLAIN_MESSAGE);
	}
}
