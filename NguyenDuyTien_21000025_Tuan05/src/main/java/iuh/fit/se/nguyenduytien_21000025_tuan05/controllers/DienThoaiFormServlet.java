package iuh.fit.se.nguyenduytien_21000025_tuan05.controllers;


import iuh.fit.se.nguyenduytien_21000025_tuan05.dao.DienThoaiDAO;
import iuh.fit.se.nguyenduytien_21000025_tuan05.dao.impl.DienThoaiDAOImpl;
import iuh.fit.se.nguyenduytien_21000025_tuan05.entities.DienThoai;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@WebServlet("/themDienThoai")
@MultipartConfig
public class DienThoaiFormServlet extends HttpServlet {

    @Resource(name = "jdbc/quanlydienthoai")
    private DataSource dataSource;

    private DienThoaiDAO dienThoaiDAO;

    @Override
    public void init() throws ServletException {
        dienThoaiDAO = new DienThoaiDAOImpl(dataSource);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String ten = req.getParameter("tenDT");
        int namSX = Integer.parseInt(req.getParameter("namSX"));
        String cauHinh = req.getParameter("cauHinh");
        int maNCC = Integer.parseInt(req.getParameter("maNCC"));

        // Xử lý upload ảnh
        Part filePart = req.getPart("hinhAnh");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        // Lưu ảnh vào thư mục webapp/images
        String uploadPath = getServletContext().getRealPath("/images/") + File.separator + fileName;

        File uploadDir = new File(getServletContext().getRealPath("/images/"));
        if (!uploadDir.exists()) {
            uploadDir.mkdirs(); // tạo folder nếu chưa có
        }

        filePart.write(uploadPath);

        // Tạo đối tượng và lưu DB
        DienThoai dt = new DienThoai(0, ten, namSX, cauHinh, maNCC, fileName);
        dienThoaiDAO.save(dt);

        req.setAttribute("message", "Thêm sản phẩm thành công!");
        req.getRequestDispatcher("views/phone/KetQua.jsp").forward(req, resp);
    }
}

