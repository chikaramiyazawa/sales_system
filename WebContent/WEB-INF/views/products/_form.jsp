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
 <label for="name">商品名</label><br />
 <input type="text" name="name" value="${product.name}"/>
 <br /><br />

 <label for="price">値段</label><br />
 <input type="text" name="price" value="${product.price}" />
 <br /><br />

 <input type="hidden" name="_token" value="${_token}" />
 <button type="submit">投稿</button>
