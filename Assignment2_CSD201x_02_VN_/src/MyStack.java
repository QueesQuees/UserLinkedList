import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Scanner;

public class MyStack {
    private Node head;

    public MyStack () {
        this.head = null;
    }

    public boolean isEmpty () {
        return head == null;
    }
    //Thêm vào một sản phẩm
    public void push (Products products) {
        head = new Node(products, head);
    }

    public Products top () {
        if (isEmpty()) throw new EmptyStackException();
        return head.getProducts();
    }
    //xóa và lấy ra sản phẩm đã xóa
    public Products pop() {
        if (isEmpty()) throw new EmptyStackException();
        Products products = head.getProducts();
        head = head.getNext();
        return products;
    }

    //Thêm sản phẩm vào stack từ file
    public void pushFromFile () {
        try {
            File myObj= new File("D:\\Users\\Asus\\IdeaProjects\\Assignment2_CSD201x_02_VN_\\ListProducts.txt");
            Scanner myRead = new Scanner(myObj);
            while (myRead.hasNextLine()) {
                String data = myRead.nextLine();
                String[] ArrData = data.split(" ");
                String maSanPham = ArrData[0];
                String tenSanPham = ArrData[1];
                Double donGia = Double.parseDouble(ArrData[2]);
                Double soLuong = Double.parseDouble(ArrData[2]);
                Products products = new Products(maSanPham, tenSanPham, donGia, soLuong);
                push(products);
            }
            myRead.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
