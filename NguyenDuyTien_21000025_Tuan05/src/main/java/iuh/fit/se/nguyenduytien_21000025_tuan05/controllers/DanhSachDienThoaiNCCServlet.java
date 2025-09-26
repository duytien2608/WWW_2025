package iuh.fit.se.nguyenduytien_21000025_tuan05.controllers;


import iuh.fit.se.nguyenduytien_21000025_tuan05.dao.DienThoaiDAO;
import iuh.fit.se.nguyenduytien_21000025_tuan05.dao.NhaCungCapDAO;
import iuh.fit.se.nguyenduytien_21000025_tuan05.dao.impl.DienThoaiDAOImpl;
import iuh.fit.se.nguyenduytien_21000025_tuan05.dao.impl.NhaCungCapDAOImpl;
import iuh.fit.se.nguyenduytien_21000025_tuan05.entities.DienThoai;
import iuh.fit.se.nguyenduytien_21000025_tuan05.entities.NhaCungCap;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet("/dienThoai")
public class DanhSachDienThoaiNCCServlet extends HttpServlet {

    @Resource(name = "jdbc/quanlydienthoai")
    private DataSource dataSource;

    private iuh.fit.se.nguyenduytien_21000025_tuan05.dao.DienThoaiDAO dienThoaiDAO;
    private iuh.fit.se.nguyenduytien_21000025_tuan05.dao.NhaCungCapDAO nhaCungCapDAO;

    @Override
    public void init() throws ServletException {
        dienThoaiDAO = new DienThoaiDAOImpl(dataSource);
        nhaCungCapDAO = new NhaCungCapDAOImpl(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");
        if (action == null) action = "list";

        if (action.equals("search")) {
            String keyword = req.getParameter("keyword");
            List<DienThoai> result = dienThoaiDAO.search(keyword);
            req.setAttribute("listDT", result);
        } else {
            String mancc = req.getParameter("mancc");
            if (mancc != null) {
                int maNCC = Integer.parseInt(mancc);
                List<DienThoai> list = dienThoaiDAO.findAllByNCC(maNCC);
                req.setAttribute("listDT", list);

                NhaCungCap ncc = nhaCungCapDAO.findById(maNCC);
                req.setAttribute("ncc", ncc);
            }
        }

        List<NhaCungCap> dsNCC = nhaCungCapDAO.findAll();
        req.setAttribute("listNCC", dsNCC);

        req.getRequestDispatcher("views/phone/DanhSachDienThoaiNCC.jsp").forward(req, resp);
    }
}
