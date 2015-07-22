<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/jsp/taglibs.jsp" %>
<div id="imageHeader">
    <table style="padding: 5px; margin: 0px; width: 100%;">
        <tr>
            <%--<td id="pageHeader">超市系统</td>--%>
            <td id="loginInfo">
                <c:if test="${not empty admin}">
                    Welcome: ${admin.username}
                    |
                    <stripes:link href="/Logout.action">退出</stripes:link>
                </c:if>
            </td>
        </tr>
    </table>
    <c:if test="${not empty admin}">
        <table class="leftRightForm">
            <tr>
                <td><stripes:link href="/jsp/CommodityList.jsp">商品列表</stripes:link></td>
                <td><stripes:link href="/jsp/usersList.jsp">用户列表</stripes:link></td>
                <td><stripes:link href="/jsp/addCommodity.jsp">增加商品</stripes:link></td>
                <td><stripes:link href="/jsp/addUser.jsp">增加用户</stripes:link></td>
            </tr>
        </table>
    </c:if>
    <%--<div id="navLinks">--%>
    <%----%>
    <%----%>
    <%----%>
    <%--</div>--%>
</div>