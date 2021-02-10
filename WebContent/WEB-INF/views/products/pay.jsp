<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:if test="${errors != null}">
    <div id="flush_error">
    入力内容にエラーがあります。<br />
    <c:forEach var="error" items="${errors}">
        ・<c:out value="${error}" /><br />
    </c:forEach>

    </div>
 </c:if>

 <h2>集計<c:out value="${totalization.total}"/>円</h2>

<form method="POST" action="$/products/totalization/pay">



 <input type="hidden" name="plus" value="${totalization.total}" />




 <input type="hidden" name="total" value="${totalization.total}"/>


 <input type="hidden" name="_token" value="${_token}" />
 <button type="submit">確定</button>
</form>