<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<h2>Danh sách điện thoại</h2>

<form action="dienThoai" method="get">
    <input type="hidden" name="action" value="search"/>
    <input type="text" name="keyword" placeholder="Tìm kiếm..."/>
    <button type="submit">Search</button>
</form>

<h3>Chọn Nhà Cung Cấp</h3>
<ul>
    <c:forEach var="ncc" items="${listNCC}">
        <li><a href="dienThoai?mancc=${ncc.maNCC}">${ncc.tenNCC}</a></li>
    </c:forEach>
</ul>

<table border="1" width="100%">
    <tr>
        <th>Mã</th>
        <th>Tên điện thoại</th>
        <th>Năm SX</th>
        <th>Cấu hình</th>
        <th>Hình ảnh</th>
        <th>Thao tác</th>
    </tr>
    <c:forEach var="dt" items="${listDT}">
        <tr>
            <td>${dt.maDT}</td>
            <td>${dt.tenDT}</td>
            <td>${dt.namSX}</td>
            <td>${dt.cauHinh}</td>
            <td><img src="${pageContext.request.contextPath}/images/${dt.hinhAnh}" width="100"/></td>
            <td><a href="${pageContext.request.contextPath}/xoaDienThoai?madt=${dt.maDT}"
                   onclick="return confirm('Bạn có chắc chắn muốn xóa ${dt.tenDT}?');">
                Xóa
            </a></td>
        </tr>
    </c:forEach>
</table><br><br>
<a href="${pageContext.request.contextPath}/views/phone/layout.jsp">Quay lại HomePage</a>
