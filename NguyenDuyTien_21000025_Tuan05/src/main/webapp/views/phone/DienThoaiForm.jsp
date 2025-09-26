<%@ page contentType="text/html; charset=UTF-8" %>
<h2>Thêm mới điện thoại</h2>
<form action="${pageContext.request.contextPath}/themDienThoai" method="post" enctype="multipart/form-data">
    <label>Tên điện thoại:</label>
    <input type="text" name="tenDT" required/><br/><br/>

    <label>Năm sản xuất:</label>
    <input type="text" name="namSX" pattern="\d{4}" required/><br/><br/>

    <label>Cấu hình:</label>
    <textarea name="cauHinh" maxlength="255" required></textarea><br/><br/>

    <label>Mã Nhà cung cấp:</label>
    <input type="number" name="maNCC" required/><br/><br/>

    <label>Hình ảnh:</label>
    <input type="file" name="hinhAnh" accept=".png,.jpg,.jpeg" required/><br/><br/>

    <button type="submit">Thêm sản phẩm</button>
</form><br><br>
<a href="${pageContext.request.contextPath}/views/phone/layout.jsp">Quay lại HomePage</a>
