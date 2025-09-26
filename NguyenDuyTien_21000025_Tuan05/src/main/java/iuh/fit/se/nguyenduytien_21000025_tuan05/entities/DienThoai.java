package iuh.fit.se.nguyenduytien_21000025_tuan05.entities;

public class DienThoai {
    private int maDT;
    private String tenDT;
    private int namSX;
    private String cauHinh;
    private int maNCC;
    private String hinhAnh;

    public DienThoai() {
    }

    public DienThoai(int maDT, String tenDT, int namSX, String cauHinh, int maNCC, String hinhAnh) {
        this.maDT = maDT;
        this.tenDT = tenDT;
        this.namSX = namSX;
        this.cauHinh = cauHinh;
        this.maNCC = maNCC;
        this.hinhAnh = hinhAnh;
    }

    // getter & setter
    public int getMaDT() {
        return maDT;
    }

    public void setMaDT(int maDT) {
        this.maDT = maDT;
    }

    public String getTenDT() {
        return tenDT;
    }

    public void setTenDT(String tenDT) {
        this.tenDT = tenDT;
    }

    public int getNamSX() {
        return namSX;
    }

    public void setNamSX(int namSX) {
        this.namSX = namSX;
    }

    public String getCauHinh() {
        return cauHinh;
    }

    public void setCauHinh(String cauHinh) {
        this.cauHinh = cauHinh;
    }

    public int getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(int maNCC) {
        this.maNCC = maNCC;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
