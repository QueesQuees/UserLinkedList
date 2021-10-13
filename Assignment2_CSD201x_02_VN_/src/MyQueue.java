import java.io.File;
import java.util.Scanner;

public class MyQueue {

    private Node head, tail;

    public MyQueue () {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public Products front() throws Exception {
        if (isEmpty()) throw new Exception();
        return head.getProducts();
    }

    public Products deQueue () throws Exception {
        if (isEmpty()) throw new Exception();
        Products products = head.getProducts();
        head = head.getNext();
        if (head == null) tail = null;
        return products;
    }

    public void enQueue (Products products){
        if (head == null) {
            head = tail = new Node(products);
        } else {
            Node nextNode = new Node(products);
            tail.setNext(nextNode);
            tail = nextNode;
        }
    }

    //Thêm sản phẩm từ file đến queue
    public void addMany () {
        try {
            File myObj = new File("D:\\Users\\Asus\\IdeaProjects\\Assignment2_CSD201x_02_VN_\\ListProducts.txt");
            Scanner myRead = new Scanner(myObj);
            while (myRead.hasNextLine()) {
                String data = myRead.nextLine();
                String[] ArrData = data.split(" ");
                String maSanPham = ArrData[0];
                String tenSanPham = ArrData[1];
                Double donGia = Double.parseDouble(ArrData[2]);
                Double soLuong = Double.parseDouble(ArrData[2]);
                Products products = new Products(maSanPham, tenSanPham, donGia, soLuong);
                enQueue(products);
            }
            myRead.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Hiển thị Queue
    @Override
    public String toString () {
        Node current = this.head;
        String answer = "";
        while (current != null) {
            answer += current.getProducts().toString() + "\n";
            current = current.getNext();
        }
        return answer;
    }
}
