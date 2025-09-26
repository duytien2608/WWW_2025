package iuh.fit.se.nguyenduytien_21000025_tuan05.dao;


import iuh.fit.se.nguyenduytien_21000025_tuan05.entities.NhaCungCap;

import java.util.List;

public interface NhaCungCapDAO {
    List<NhaCungCap> findAll();
    NhaCungCap findById(int maNCC);
    List<NhaCungCap> search(String keyword);
    void save(NhaCungCap ncc);
    void delete(int maNCC);
}
