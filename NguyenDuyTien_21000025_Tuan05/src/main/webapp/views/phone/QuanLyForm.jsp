<%@ page contentType="text/html; charset=UTF-8" %>
<h2>Xóa sản phẩm</h2>
<form action="${pageContext.request.contextPath}/xoaDienThoai" method="get"
      onsubmit="return confirm('Bạn có chắc chắn muốn xóa sản phẩm này không?');">
    <label>Nhập Mã Điện Thoại cần xóa:</label>
    <input type="number" name="madt" required/>
    <button type="submit">Xóa</button><br><br>
    <a href="${pageContext.request.contextPath}/views/phone/layout.jsp">Quay lại HomePage</a>

</form>


