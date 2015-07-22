<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/jsp/taglibs.jsp" %>

<stripes:layout-render name="/jsp/layout/standard.jsp" title="Bug List">
    <stripes:layout-component name="contents">
        <stripes:form action="/AddUser.action">
            <stripes:errors/>

            <c:choose>
                <c:when test="${(actionBean == null)||(actionBean.className != 'AddUserActionBean')}">
                    <c:set var="actionBean" value="<%= new org.supermarketdiscount.action.AddUserActionBean()%>"
                           scope="page"/>
                </c:when>
            </c:choose>
            <table class="table">
                <tr>
                    <th class="th">增加用户</th>
                </tr>
                <tr>
                    <th class="th">用户名</th>
                    <th class="th">用户密码</th>
                    <th class="th">电话号码</th>
                </tr>
                <tr>
                    <td class="td"><stripes:text name="用户名" value=""/></td>
                    <td class="td"><stripes:text name="密码" value=""/></td>
                    <td class="td"><stripes:text name="电话" value=""/></td>
                </tr>
                <tr>
                    <th class="th">
                        <stripes:submit name="saveUser" value="添加用户"/>
                    </th>
                </tr>
            </table>
        </stripes:form>
    </stripes:layout-component>
</stripes:layout-render>
