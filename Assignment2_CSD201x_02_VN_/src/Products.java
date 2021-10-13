public class Products {
    private String maSanPham;
    private String tenSanPham;
    private double donGia;
    private double soLuong;

    public Products(String maSanPham, String tenSanPham, double donGia, double soLuong) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }
    //Hiển thị thông tin sản phẩm
    @Override
    public String toString () {
        return  maSanPham + " " + tenSanPham + " " + donGia + " " + soLuong;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public double getSoLuong() {
        return soLuong;
    }

    public String getMaSanPham() {
        return maSanPham;
    }
}
