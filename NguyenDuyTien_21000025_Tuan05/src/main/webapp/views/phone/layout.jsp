<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản lý Điện Thoại</title>
    <style>
        body { font-family: Arial; }
        .header { text-align: center; }
        .menu { text-align: center; background: #f2f2f2; padding: 10px; }
        .menu a { margin: 0 15px; text-decoration: none; font-weight: bold; }
        .footer { text-align: center; margin-top: 20px; font-size: 13px; color: gray; }
    </style>
</head>
<body>
<div class="header">
    <img src="${pageContext.request.contextPath}/images/logo.jpg" alt="Logo" height="300" width="50%"/>
</div>

<div class="menu">
    <a href="${pageContext.request.contextPath}/dienThoai">Danh sách sản phẩm</a> |
    <a href="${pageContext.request.contextPath}/views/phone/DienThoaiForm.jsp">Thêm mới sản phẩm</a> |
    <a href="${pageContext.request.contextPath}/views/phone/QuanLyForm.jsp">Chức năng quản lý</a>
</div>


<div class="content">
    <jsp:include page="${pageContent}"/>
</div>

<div class="footer">
    Họ tên sinh viên – Mã sinh viên – Lớp
</div>
</body>
</html>
