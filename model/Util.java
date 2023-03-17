package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

public class Util {

	/** lấy ra ngày giờ hiện tại */
	public static String getDateNow() {
		StringBuilder s = new StringBuilder();
		// date có dạng: yyyy-mm-dd
		LocalDate date = LocalDate.now();
		s.append(date.toString() + " ");
		// time có dạng: hh:mm:ss.xxxxxxx
		LocalTime time = LocalTime.now();
		s.append(time.toString());
		// sau khi cộng chuỗi s có dạng: yyyy-mm-dd hh:mm:ss.xxxxxxx
		// vì không lấy giây nên ta sẽ xóa từ dấu ":" cuối cùng trong s đến hết
		return s.delete(s.lastIndexOf(":"), s.length()).toString();
	}

	public static String createRandomCode() {
		Random rd = new Random();
		String result = "";
		String text = "QWERTYUIOPASDFGHJKLZXCVBNM01234567890";
		for (int i = 0; i < 5; i++) {
			result += text.charAt(rd.nextInt(text.length()));
		}
		return result;
	}

	public static String splitName(String name) {
		String[] arr = name.split("\\(");
		return arr[0].trim();
	}

	/**
	 * chuỗi có dạng: "Giá: 10$)" kết quả trả về là: 10$
	 */
	public static String getPrice(String st) {
		int start = st.indexOf(":");
		int end = st.indexOf("$");
		// start + 2 là bắt đầu từ số 1
		// end + 1 là kết thúc ở dấu $
		return st.substring(start + 2, end + 1);
	}

	/**
	 * chuỗi có dạng: "Trà sữa Socola (Giá: 25$)" 
	 * kết quả trả về là: [Trà sữa Socola, 25$] 
	 * split("\\("): thêm \\ thì java mới hiểu là cắt ở dấu (
	 */
	public static String[] getName(String st) {
		String[] s = new String(st).split("\\(");
		s[0] = s[0].trim();
		s[1] = getPrice(s[1]).trim();
		return s;
	}
}
