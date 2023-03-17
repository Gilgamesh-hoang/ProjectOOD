package view;

import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.Util;
import model.observer.MilkTeaData;
import model.observer.ObserverMilkTea;

public class BillView extends JFrame implements ObserverMilkTea {

	private JPanel contentPane;
	private JTextArea textArea;
	private JLabel lbNgayBan;
	private JLabel lbSoHoaDon;
	private JLabel lbNhanVienBan;
	private JLabel lbTongTien;
	private JLabel lbTienTra;
	private JLabel lbTienNhan;

	public BillView(MilkTeaData data) {
		this.init();
		data.addMilkTea(this);
	}
	
	public void init() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Hóa đơn bán hàng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(134, 17, 237, 34);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Ngày bán:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(27, 80, 92, 20);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Số hóa đơn: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(27, 110, 109, 20);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Mã NV: ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(25, 140, 74, 20);
		contentPane.add(lblNewLabel_3);

		textArea = new JTextArea();
		textArea.setTabSize(6);
		textArea.setEditable(false);
		textArea.setEnabled(false);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 19));
		textArea.setBounds(22, 216, 477, 233);
		contentPane.add(textArea);

		JLabel lblNewLabel_4 = new JLabel("Tổng tiền thanh toán:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(27, 469, 203, 20);
		contentPane.add(lblNewLabel_4);

		JSeparator separator = new JSeparator();
		separator.setBounds(72, 61, 374, 1);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(72, 176, 374, 1);
		contentPane.add(separator_1);

		JLabel lblNewLabel_5 = new JLabel("Cảm ơn quý khách đã mua hàng.");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_5.setBounds(159, 580, 211, 27);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Rất mong nhận được sự góp ý và phương thức phục vụ ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_6.setBounds(82, 605, 374, 27);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("giá cả, chất lượng của chúng tôi.");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_7.setBounds(159, 631, 211, 27);
		contentPane.add(lblNewLabel_7);

		lbNgayBan = new JLabel("");
		lbNgayBan.setEnabled(false);
		lbNgayBan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbNgayBan.setBounds(118, 80, 166, 20);
		contentPane.add(lbNgayBan);

		lbSoHoaDon = new JLabel("");
		lbSoHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbSoHoaDon.setEnabled(false);
		lbSoHoaDon.setBounds(134, 110, 166, 20);
		contentPane.add(lbSoHoaDon);

		lbNhanVienBan = new JLabel("");
		lbNhanVienBan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbNhanVienBan.setEnabled(false);
		lbNhanVienBan.setBounds(93, 140, 166, 20);
		contentPane.add(lbNhanVienBan);

		lbTongTien = new JLabel("");
		lbTongTien.setHorizontalAlignment(SwingConstants.RIGHT);
		lbTongTien.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbTongTien.setEnabled(false);
		lbTongTien.setBounds(370, 469, 119, 20);
		contentPane.add(lbTongTien);

		JLabel lblNewLabel_4_1 = new JLabel("Số tiền nhận:");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4_1.setBounds(27, 499, 203, 20);
		contentPane.add(lblNewLabel_4_1);

		lbTienNhan = new JLabel("");
		lbTienNhan.setHorizontalAlignment(SwingConstants.RIGHT);
		lbTienNhan.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbTienNhan.setEnabled(false);
		lbTienNhan.setBounds(370, 499, 119, 20);
		contentPane.add(lbTienNhan);

		JLabel lblNewLabel_4_2 = new JLabel("Số tiền trả lại:");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4_2.setBounds(27, 532, 203, 20);
		contentPane.add(lblNewLabel_4_2);

		lbTienTra = new JLabel("");
		lbTienTra.setHorizontalAlignment(SwingConstants.RIGHT);
		lbTienTra.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbTienTra.setEnabled(false);
		lbTienTra.setBounds(370, 532, 119, 20);
		contentPane.add(lbTienTra);

		setLocationRelativeTo(null);
		setBounds(100, 100, 537, 717);
		this.setLocationRelativeTo(null);
	}

	/**
	 * cộng tên và giá sản phẩm vào StringBuilder rồi sau đó in ra view
	 */
	@Override
	public void update(String milkTea, List<String> listToppings, double cost, double moneyInput, double refundMoney,
			String employeeCode, String billCode, String dateNow) {
		int index = 1; // là số thứ tự của sản phẩm lúc in ra view
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(String.format("STT\tTên sản phẩm\t\t\tĐơn giá\n"));
		String[] milkTeaName = Util.getName(milkTea);// lấy ra tên và giá trà sữa
		stringBuilder.append(String.format("%s\t%s\t\t%s\n", index++, milkTeaName[0], milkTeaName[1]));
		for (String toppings : listToppings) {
			String[] topping = Util.getName(toppings);// lấy ra tên và giá topping
			if (topping[0].equals("Hạt sen")) {
				stringBuilder.append(String.format("%s\t%s\t\t\t%s\n", index++, topping[0], topping[1]));
			} else {
				stringBuilder.append(String.format("%s\t%s\t\t%s\n", index++, topping[0], topping[1]));
			}
		}
		textArea.setText(stringBuilder.toString());
		lbNgayBan.setText(dateNow);
		lbTongTien.setText(cost + "$");
		lbNhanVienBan.setText(employeeCode);
		lbSoHoaDon.setText(billCode);
		lbTienNhan.setText(moneyInput + "$");
		lbTienTra.setText(refundMoney + "$");
		this.setVisible(true);
	}

}
