package iuh.fit.se.nguyenduytien_21000025_tuan05.controllers;


import iuh.fit.se.nguyenduytien_21000025_tuan05.dao.DienThoaiDAO;
import iuh.fit.se.nguyenduytien_21000025_tuan05.dao.impl.DienThoaiDAOImpl;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet("/xoaDienThoai")
public class QuanLyFormServlet extends HttpServlet {

    @Resource(name = "jdbc/quanlydienthoai")
    private DataSource dataSource;

    private DienThoaiDAO dienThoaiDAO;

    @Override
    public void init() throws ServletException {
        dienThoaiDAO = new DienThoaiDAOImpl(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int maDT = Integer.parseInt(req.getParameter("madt"));
        dienThoaiDAO.delete(maDT);

        req.setAttribute("message", "Đã xóa sản phẩm!");
        req.getRequestDispatcher("views/phone/KetQua.jsp").forward(req, resp);
    }
}
