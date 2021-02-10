<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${products != null}">
                <h2>${products.name}の詳細ページ</h2>

                <table>
                    <tbody>
                        <tr>
                        <th>商品名</th>
                        <td><c:out value="${products.name}" /></td>
                        </tr>
                        <tr>
                        <th>値段</th>
                        <td><c:out value="${products.price}" /></td>
                        </tr>
                        <tr>
                            <th>いいね</th>
                            <td><c:out value="${products.good}"/></td>
                          <tr>
                            <tr>
                                <th>登録日時</th>
                                <td>
                                    <fmt:formatDate value="${products.created_at}" pattern="yyyy-MM-dd HH:mm:ss" />
                                </td>
                             </tr>
                             <tr>
                                <th>更新日時</th>
                                <td>
                                    <fmt:formatDate value="${products.updated_at}" pattern="yyyy-MM-dd HH:mm:ss" />
                                </td>
                                </tr>
                                </tbody>
                                </table>

                                <p><a href="<c:url value='/products/edit?id=${products.id}' />">この商品情報を編集する</a></p>
                                </c:when>
                                <c:otherwise>
                                    <h2>お探しのデータは見つかりませんでした。</h2>
                                </c:otherwise>
                                </c:choose>

                                <p><a href="<c:url value='/products/index'/>">一覧に戻る</a></p>

                            </c:param>
                           </c:import>