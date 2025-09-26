package iuh.fit.se.nguyenduytien_21000025_tuan05.dao.impl;

import iuh.fit.se.dao.DienThoaiDAO;
import iuh.fit.se.entities.DienThoai;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DienThoaiDAOImpl implements DienThoaiDAO {
    private DataSource dataSource;

    public DienThoaiDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<DienThoai> findAllByNCC(int maNCC) {
        List<DienThoai> list = new ArrayList<>();
        String sql = "SELECT * FROM DIENTHOAI WHERE MANCC=?";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, maNCC);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new DienThoai(
                        rs.getInt("MADT"),
                        rs.getString("TENDT"),
                        rs.getInt("NAMSANXUAT"),
                        rs.getString("CAUHINH"),
                        rs.getInt("MANCC"),
                        rs.getString("HINHANH")
                ));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    @Override
    public List<DienThoai> search(String keyword) {
        List<DienThoai> list = new ArrayList<>();
        String sql = "SELECT * FROM DIENTHOAI WHERE TENDT LIKE ? OR CAUHINH LIKE ?";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new DienThoai(
                        rs.getInt("MADT"),
                        rs.getString("TENDT"),
                        rs.getInt("NAMSANXUAT"),
                        rs.getString("CAUHINH"),
                        rs.getInt("MANCC"),
                        rs.getString("HINHANH")
                ));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    @Override
    public void save(DienThoai dt) {
        String sql = "INSERT INTO DIENTHOAI (TENDT, NAMSANXUAT, CAUHINH, MANCC, HINHANH) VALUES (?,?,?,?,?)";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, dt.getTenDT());
            ps.setInt(2, dt.getNamSX());
            ps.setString(3, dt.getCauHinh());
            ps.setInt(4, dt.getMaNCC());
            ps.setString(5, dt.getHinhAnh());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public void delete(int maDT) {
        String sql = "DELETE FROM DIENTHOAI WHERE MADT=?";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, maDT);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }
}
