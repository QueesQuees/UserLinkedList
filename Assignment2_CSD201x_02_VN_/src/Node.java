public class Node {

    private Products products;
    private Node next;

    public Node(Products products, Node next) {
        this.products = products;
        this.next = next;
    }

    public Node(Products products) {
        this.products = products;
        this.next = null;
    }

    //lấy node tiếp theo
    public Node getNext() {
        return next;
    }

    //Tạo Node tiếp theo
    public void setNext(Node next) {
        this.next = next;
    }

    //Lấy ra sản phẩm
    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    @Override
    public String toString () {
        return this.products.toString();
    }

}
