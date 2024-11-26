public class TestPassingParameter {

    public static void main(String[] args) {
        // Tạo hai đối tượng DigitalVideoDisc
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        // Gọi phương thức swap với hai đối tượng jungleDVD và cinderellaDVD
        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle()); // In tiêu đề của jungleDVD
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle()); // In tiêu đề của cinderellaDVD

        // Thay đổi tiêu đề của jungleDVD bằng phương thức changeTitle
        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle()); // In tiêu đề của jungleDVD sau khi thay đổi
    }

    // Phương thức swap: hoán đổi hai đối tượng bất kỳ 
    public static void swap(Object o1, Object o2) {
        Object tmp = o1; // Lưu tạm tham chiếu o1
        o1 = o2;         // Gán tham chiếu o2 cho o1
        o2 = tmp;        // Gán tham chiếu tạm cho o2
    }

    // Phương thức changeTitle: thay đổi tiêu đề của đối tượng DVD
    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle(); // Lưu tiêu đề cũ
        dvd.setTitle(title);              // Thay đổi tiêu đề mới
        dvd = new DigitalVideoDisc(oldTitle); // Tạo đối tượng mới với tiêu đề cũ, nhưng không ảnh hưởng đến dvd ban đầu
    }
}