package observer;

public interface SubjectMilkTea {
	void addMilkTea(ObserverMilkTea observer);// thêm một observer vào danh sách
	void removeMilkTea(ObserverMilkTea observer);// xóa một observer vào danh sách
	void notifyObserver();// thông báo đến tất cả observer có trong danh sách
}
