package iuh.fit.se.nguyenduytien_21000025_tuan05.dao;


import iuh.fit.se.nguyenduytien_21000025_tuan05.entities.DienThoai;

import java.util.List;

public interface DienThoaiDAO {
    List<DienThoai> findAllByNCC(int maNCC);
    List<DienThoai> search(String keyword);
    void save(DienThoai dt);
    void delete(int maDT);
}
