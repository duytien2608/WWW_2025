package iuh.fit.se.nguyenduytien_21000025_tuan05.dao.impl;

import iuh.fit.se.dao.NhaCungCapDAO;
import iuh.fit.se.entities.NhaCungCap;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NhaCungCapDAOImpl implements NhaCungCapDAO {
    private DataSource dataSource;

    public NhaCungCapDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<NhaCungCap> findAll() {
        List<NhaCungCap> list = new ArrayList<>();
        String sql = "SELECT * FROM NHACUNGCAP";
        try (Connection con = dataSource.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new NhaCungCap(
                        rs.getInt("MANCC"),
                        rs.getString("TENNHACC"),
                        rs.getString("DIACHI"),
                        rs.getString("SODIENTHOAI")
                ));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    @Override
    public NhaCungCap findById(int maNCC) {
        String sql = "SELECT * FROM NHACUNGCAP WHERE MANCC=?";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, maNCC);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new NhaCungCap(
                        rs.getInt("MANCC"),
                        rs.getString("TENNHACC"),
                        rs.getString("DIACHI"),
                        rs.getString("SODIENTHOAI")
                );
            }
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }

    @Override
    public List<NhaCungCap> search(String keyword) {
        List<NhaCungCap> list = new ArrayList<>();
        String sql = "SELECT * FROM NHACUNGCAP WHERE TENNHACC LIKE ? OR DIACHI LIKE ? OR SODIENTHOAI LIKE ?";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            ps.setString(3, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new NhaCungCap(
                        rs.getInt("MANCC"),
                        rs.getString("TENNHACC"),
                        rs.getString("DIACHI"),
                        rs.getString("SODIENTHOAI")
                ));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    @Override
    public void save(NhaCungCap ncc) {
        String sql = "INSERT INTO NHACUNGCAP (TENNHACC, DIACHI, SODIENTHOAI) VALUES (?,?,?)";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, ncc.getTenNCC());
            ps.setString(2, ncc.getDiaChi());
            ps.setString(3, ncc.getSoDienThoai());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public void delete(int maNCC) {
        String sql = "DELETE FROM NHACUNGCAP WHERE MANCC=?";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, maNCC);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }
}
