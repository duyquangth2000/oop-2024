public class Cart {

    // Số lượng tối đa các đĩa DVD có thể thêm vào giỏ hàng
    public static final int MAX_NUMBERS_ORDERED = 20;

    // Mảng chứa các đối tượng DigitalVideoDisc
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    // Số lượng đĩa DVD hiện có trong giỏ hàng
    public int qtyOrdered = 0;

    // Phương thức thêm một đĩa DVD vào giỏ hàng
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered >= MAX_NUMBERS_ORDERED) { // Kiểm tra giỏ hàng đã đầy hay chưa
            System.out.println("The cart is full! Cannot add more DVDs.");
        } else {
            itemsOrdered[qtyOrdered] = disc; // Thêm đĩa vào vị trí tiếp theo trong mảng
            System.out.println(disc.getTitle() + " has been added!");
            qtyOrdered++; // Tăng số lượng đĩa hiện tại
        }
    }

    // Phương thức thêm một danh sách các đĩa DVD vào giỏ hàng
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc dvd : dvdList) {
            if (qtyOrdered >= MAX_NUMBERS_ORDERED) { // Kiểm tra nếu giỏ hàng đầy trong quá trình thêm
                System.out.println("The cart is full! Cannot add more DVDs.");
                break;
            } else {
                itemsOrdered[qtyOrdered] = dvd; // Thêm từng đĩa vào mảng
                System.out.println(dvd.getTitle() + " has been added!");
                qtyOrdered++;
            }
        }
    }

    // Phương thức thêm hai đĩa DVD cùng lúc vào giỏ hàng
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        // Sử dụng phương thức trên để thêm một danh sách chứa hai đĩa
        DigitalVideoDisc[] dvdList = {dvd1, dvd2};
        addDigitalVideoDisc(dvdList);
    }

    // Phương thức xóa một đĩa DVD khỏi giỏ hàng
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered == 0) { // Kiểm tra giỏ hàng có trống hay không
            System.out.println("Nothing to remove!");
        } else {
            int index = -1; // Lưu vị trí của đĩa cần xóa
            for (int i = 0; i < qtyOrdered; i++) {
                if (itemsOrdered[i] == disc) { // Tìm đĩa cần xóa trong mảng
                    index = i;
                    break;
                }
            }
            if (index == -1) { // Nếu không tìm thấy đĩa cần xóa
                System.out.println("Disc not found in cart!");
            } else {
                // Dịch chuyển các phần tử sau đĩa cần xóa lên trước
                for (int i = index; i < qtyOrdered - 1; i++) {
                    itemsOrdered[i] = itemsOrdered[i + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null; // Đặt phần tử cuối là null
                qtyOrdered--; // Giảm số lượng đĩa trong giỏ hàng
                System.out.println(disc.getTitle() + " has been removed from the cart.");
            }
        }
    }

    // Phương thức tính tổng chi phí của các đĩa trong giỏ hàng
    public float totalCost() {
        float totalCost = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            totalCost += itemsOrdered[i].getCost(); // Cộng chi phí của từng đĩa
        }
        return totalCost;
    }
    
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println(itemsOrdered[i]);
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }
}
