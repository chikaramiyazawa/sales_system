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
 <label for="s_product">商品名</label><br />
 <c:out value="${sales.s_product}"/>
 <input type="hidden" name="s_product" value="${sales.s_product}"/>
 <br /><br />

 <label for="s_price">値段</label><br />
 <c:out value="${sales.s_price}"/>
 <input type="hidden" name="s_price" value="${sales.s_price}" />
 <br /><br />

 <label for="count">個数</label><br/>
 <input type="text" name="count" value="${sales.count}"/>
 <br /><br />




 <input type="hidden" name="_token" value="${_token}" />
 <button type="submit">変更</button>
