import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;

public class MainTest {

    public static LinkedList list;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        menu();

    }
    //Menu control
    public static void menu () {
        while (true) {

            System.out.println("--------------------------------------------");
            System.out.println("Choose one of this options:");
            System.out.println("Product list:");
            System.out.println("!. Load data from file and display.");
            System.out.println("2. Input and add to the end.");
            System.out.println("3. Display data.");
            System.out.println("4. Save product list to file.");
            System.out.println("5. Search by ID.");
            System.out.println("6. Delete by ID.");
            System.out.println("7. Sort by ID");
            System.out.println("8. Convert to Binary");
            System.out.println("9. Load to stack and display.");
            System.out.println("10. Load to Queue and display.");
            System.out.println("Exit:");
            System.out.println("0. Exit");
            System.out.println("--------------------------------------------");

            System.out.print("Your choice: "); String choice = sc.next();

            if (choice == "0") {
                System.out.println("Have a good day!");
                return;
            }
            switch (choice) {
                case "1":
                    loadData();
                    break;
                case "2":
                    addEndList();
                    break;
                case "3":
                    display();
                    break;
                case "4":
                    saveToFile();
                    break;
                case "5":
                    searchByID();
                    break;
                case "6":
                    deleteByID();
                    break;
                case "7":
                    sortByID();
                    break;
                case "8":
                    convertToBinary();
                    break;
                case "9":
                    loadToStack();
                    break;
                case "10":
                    loadToQueue();
                    break;
                default: System.out.println("Choice again");
            }

        }//end while.
    }

    // Choice 01
    public static void loadData() {
        list = new LinkedList();
        list.addManyFromFile("D:\\Users\\Asus\\IdeaProjects\\Assignment2_CSD201x_02_VN_\\ListProducts.txt");
        System.out.println("?????c th??nh c??ng");
    }

    //Th??m s???n ph???m v??o cu???i linkedList. Choice 2
    public static void addEndList () {
        System.out.println("Nh???p th??ng tin m???t s???n ph???m m???i: ");
        System.out.print("M?? s???n ph???m: ");  String maSanPhan = sc.next();
        System.out.print("T??n s???n Ph???m: ");  String tenSanPham = sc.next();
        System.out.print("S??? l?????ng: ");  Double donGia = Double.parseDouble(sc.next());
        System.out.print("D??n gi??: ");  Double soLuong = Double.parseDouble(sc.next());

        Products newProduct = new Products(maSanPhan, tenSanPham, donGia, soLuong);
        list.addHead(newProduct);
        System.out.println("L??u th??nh c??ng");
    }

    //Choice 3 display from LinkedList
    public static void display () {
        System.out.println(list.toString());
    }

    //Choice 4 Save list to file
    public static void saveToFile () {
        try {
            String data = list.toString();
            FileWriter myWrite = new FileWriter("D:\\Users\\Asus\\IdeaProjects\\Assignment2_CSD201x_02_VN_\\ListProducts.txt");
            myWrite.write(data);
            myWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("L??u th??nh c??ng");
    }

    //Choice 5 Search by ID
    public static void searchByID () {
        System.out.print("Input the ID to search: "); String id = sc.next();
        Node head = list.getHead();
        String answer ="";
        while (head != null) {
            String maSanPhan = head.getProducts().getMaSanPham();
            if (maSanPhan.equals(id)) {
                answer = head.toString();
            }
            head = head.getNext();
        }
        System.out.println("Th??ng tin s???n ph???m t??m ???????c: ");
        if (answer.isEmpty()) {
            System.out.println("M?? s???n ph???m kh??ng t???n t???i");
            return;
        }
        System.out.println(answer);
    }

    //Choice 6 Delete by ID
    public static void deleteByID() {

        System.out.print("Nh???p m?? s???n ph???m c???n x??a: "); String id = sc.next();
        Node head = list.getHead();
        if (head.getProducts().getMaSanPham().equals(id)) {
            list.setHead(head.getNext());
            return;
        }
        while (head != null) {
            Node nodeDelete = head.getNext();
            if (nodeDelete == null) {
                return;
            }
            String maSanPhan = nodeDelete.getProducts().getMaSanPham();
            if (maSanPhan.equals(id)) {
                Node nodeNextNodeDelete = nodeDelete.getNext();
                head.setNext(nodeNextNodeDelete);
                nodeDelete.setNext(null);
            }
            head = head.getNext();
        }
        System.out.println("X??a th??nh c??ng");
    }

    //Choice 7 Sort By ID
    public static void sortByID () {
        list.sortList();
        System.out.println("S???p x???p th??nh c??ng");
    }

    //Choice 8 convert to binary
    public static void convertToBinary() {
        System.out.println("M?? nh??? ph??n c???a s??? l?????ng ph???n t??? ?????u ti??n l??");
        Node node = list.getHead();
        int  soLuong = (int) node.getProducts().getSoLuong();
        String subAnswer = "";
        String answer = "";
        while (soLuong != 0) {
            subAnswer += soLuong % 2;
            soLuong = soLuong / 2;
        }

        for (int i = subAnswer.length() - 1; i >=0; i--) {
            answer += subAnswer.charAt(i);
        }
        System.out.println(answer);
    }

    //Choice 9 Load to Stack
    public static void loadToStack () {
        System.out.println("Load to stack and display");
        MyStack myStack = new MyStack();
        myStack.pushFromFile();
        String printStack = myStack.toString();
        System.out.println(printStack);
    }

    //Choice 10 Load to Queue
    public static void loadToQueue () {
        System.out.println("Load to queue and display.");
        MyQueue myQueue = new MyQueue();
        myQueue.addMany();
        String printQueue = myQueue.toString();
        System.out.println(printQueue);
    }

}
