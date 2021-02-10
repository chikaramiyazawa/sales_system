<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:import url="../layout/app.jsp">
    <c:param name="content">


        <h2>編集ページ</h2>

        <form method = "POST" action= "${pageContext.request.contextPath}/product/buy/update">
            <c:import url="buy_update.jsp" />
        </form>

        <p><a href="${pageContext.request.contextPath}/products/buy">一覧に戻る</a></p>
        <p><a href= "#" onclick="confirmDestroy();">購入を取り消す</a></p>
        <form method="POST" action="${pageContext.request.contextPath}/products/buy/cancel">
            <input type = "hidden" name="_token" value="${_token}" />
        </form>
        <script>
        function confirmDestroy(){
            if(confirm("本当に取り消してよろしいですか？")){
                document.forms[1].submit();
            }
        }

        </script>


</c:param>
</c:import>