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
        <h2>商品　一覧</h2>
        <img src="../image/売上システムの画像.png" >
        <table id="products_list">
            <tbody>
                <tr>
                    <th>商品名</th>
                    <th>値段</th>
                    <th>いいね</th>
                    <th>操作</th>
                </tr>
                <c:forEach var="products" items="${products}" varStatus="status">
                    <tr class="row${status.count % 2}">
                        <td><c:out value="${products.name}" /></td>
                        <td><c:out value="${products.price}円" /></td>
                        <td><c:out value="${products.good}" /></td>
                        <td><a href="<c:url value='/products/show?id=${products.id}' />">詳細を表示</a></td>
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
                        <a href="<c:url value='/products/index?page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>



          <p><a href="<c:url value='/products/new' />">新規商品の登録へ</a></p>
          <p><a href="<c:url value='/products/sale/index' />">商品購入画面へ</a></p>

        </div>

    </c:param>


</c:import>