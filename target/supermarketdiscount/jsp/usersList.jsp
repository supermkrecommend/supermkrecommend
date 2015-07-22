<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/jsp/taglibs.jsp" %>

<stripes:layout-render name="/jsp/layout/standard.jsp" title="Bug List">
    <stripes:layout-component name="contents">
        <stripes:errors/>

        <stripes:form action="/UsersList.action">
            <c:choose>
                <c:when test="${(actionBean == null)||(action.className != 'UsersListActionBean')}">
                    <c:set var="actionBean" value="<%= new org.supermarketdiscount.action.UsersListActionBean()%>"
                           scope="session"/>
                </c:when>
            </c:choose>
            <table class="table">
                <tr>
                    <th class="th">用户ID</th>
                    <th class="th">用户姓名</th>
                    <th class="th">用户会员号</th>
                    <th class="th">用户手机号</th>
                </tr>

                <c:forEach items="${actionBean.pages}" var="user" varStatus="rowstat">
                    <tr class="${rowstat.count mod 2 == 0 ? "even" : "odd"}">
                        <td class="td">${user.userid}</td>
                        <td class="td">${user.username}</td>
                        <td class="td">${user.membership}</td>
                        <td class="td">${user.phoneNumber}</td>
                        <td class="td">
                            <stripes:link href="/SingleUser.action" event="userEdit">
                                详细
                                <stripes:param name="user.userid" value="${user.userid}"/>
                            </stripes:link>
                        </td>
                        <td class="td">
                            <stripes:link href="/UserDiscountList.action" event="userDiscountList">
                                用户折扣
                                <stripes:param name="userDiscount.userid" value="${user.userid}"/>
                            </stripes:link>
                        </td>
                        <td class="td">
                            <stripes:link href="/UsersList.action" event="delUser">
                                删除
                                <stripes:param name="user.userid" value="${user.userid}"/>
                            </stripes:link>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <div class="buttons">
                <stripes:hidden name="pageCount" value="${actionBean.pageCount}"/>
                <stripes:hidden name="pageNum" value="${actionBean.pageNum}"/>
                <stripes:submit name="getLastPage" value="上一页"/>
                <stripes:select id="jumpPage" name="jumpPage" value="this.options[this.selectedIndex].value">
                    <stripes:options-collection collection="${actionBean.allpageNum}"/>
                </stripes:select>
                <stripes:submit name="pageJump" value="goto"/>
                <stripes:submit name="getNextPage" value="下一页"/>
            </div>
        </stripes:form>
    </stripes:layout-component>
</stripes:layout-render>