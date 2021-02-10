<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h2>購入画面</h2>


        <table id="products_list">
            <tbody>
                <tr>
                    <th>商品名</th>
                    <th>値段</th>
                    <th>操作</th>
                </tr>
                <c:forEach var="products" items="${products}" varStatus="status">
                    <tr class="row${status.count % 2}">
                        <td><c:out value="${products.name}" /></td>
                        <td><c:out value="${products.price}円" /></td>
                        <td><a href="<c:url value='/products/sale/form?id=${products.id}' />">この商品を購入する</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div id="pagination">
            （全 ${products_count} 件）<br />
            <c:forEach var="i" begin="1" end="${((products_count - 1) / 15) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='/products/sale/index?page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <p><a href="<c:url value='/products/index'/>">商品一覧へ</a></p>

        </div>

    </c:param>


</c:import>