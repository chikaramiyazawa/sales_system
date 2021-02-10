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
          <h2>購入リスト</h2>
          <h3>合計金額　<c:out value="${getTotal}"/></h3>

        <table id="sales_list">
            <tbody>
                <tr>
                    <th>商品名</th>
                    <th>個数</th>
                    <th>合計</th>
                    <th>操作</th>

                </tr>
                <c:forEach var="sales" items="${sales}" varStatus="status">
                    <tr class="row${status.count % 2}">

                    <td><c:out value="${sales.s_product}" /></td>
                    <td><c:out value="${sales.count}個" /></td>
                    <td><c:out value="${sales.sum}円"/></td>
                    <td><a href="<c:url value='/products/buy/edit?id=${sales.id}' />">個数の変更、購入取り消し</a></td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>


        <p><a href="<c:url value='/products/sale/index' />">商品購入画面へ戻る</a></p>

    </c:param>


</c:import>