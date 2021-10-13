import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class LinkedList {
    private Node head, tail;

    public LinkedList() {
        head = tail = null;
    }

    public void addHead (Products products) {
        if (head == null) {
            head = tail = new Node(products);
        }else {
            Node newNode = new Node(products);
            tail.setNext(newNode);
            tail = newNode;

        }
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }


    //Sort list by ID
    public void sortList() {
        Node current = this.head, index = null;
        if (head == null) {
            return;
        }
        //Dùng bubble sort sắp xếp list
        while (current != null) {
            index = current.getNext();
            while (index != null) {
                String maSanPham1 = current.getProducts().getMaSanPham();
                String maSanPham2 = index.getProducts().getMaSanPham();
                int x = maSanPham2.compareTo(maSanPham1);
                // So sanh và hoán đổi sản phẩm cho các Node
                if (x < 0) {
                    Products products = current.getProducts();
                    current.setProducts(index.getProducts());
                    index.setProducts(products);
                }
                index = index.getNext();
            }
            current = current.getNext();
        }
    }

    //hàm trả lại thông tin Node
    @Override
    public String toString() {
        String str = "";
        Node current = this.head;
        while (current != null) {
            str += current.getProducts().toString()+ "\n";
            current = current.getNext();
        }
        return str;
    }

    //Thêm sản phẩm từ file vào linked list
    public void addManyFromFile(String linkFile) {
        try {
            File myObj = new File(linkFile);
            Scanner myRead = new Scanner(myObj);
            while (myRead.hasNextLine()) {
                String data = myRead.nextLine();
                String[] ArrData = data.split(" ");
                String maSanPham = ArrData[0];
                String tenSanPham = ArrData[1];
                Double donGia = Double.parseDouble(ArrData[2]);
                Double soLuong = Double.parseDouble(ArrData[2]);
                Products products = new Products(maSanPham, tenSanPham, donGia, soLuong);
                addHead(products);
                System.out.println(maSanPham + "        " + tenSanPham + "         " + donGia + "        " + soLuong);
            }
            myRead.close();
        }catch (FileNotFoundException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }
}
