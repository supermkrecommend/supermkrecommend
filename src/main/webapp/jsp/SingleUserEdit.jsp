<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/jsp/taglibs.jsp" %>

<stripes:layout-render name="/jsp/layout/standard.jsp" title="Bug List">
    <stripes:layout-component name="contents">
        <stripes:form action="/SingleUser.action">
            <stripes:errors/>

            <c:choose>
                <c:when test="${actionBean == null}">
                    <c:set var="actionBean" value="<%= new org.supermarketdiscount.action.SingleUserActionBean()%>"
                           scope="page"/>
                </c:when>
            </c:choose>
            <table class="table">
                <tr>
                    <td>用户信息</td>
                </tr>
                <tr>
                    <th class="td">用户ID</th>
                    <td class="td">${actionBean.user.userid}</td>
                    <stripes:hidden name="user.userid"/>
                </tr>
                <tr>
                    <th class="td">用户名</th>
                    <td class="td">${actionBean.user.username}</td>
                    <stripes:hidden name="user.username"/>
                </tr>
                <th class="td">用户密码</th>
                <td class="td"><stripes:text name="用户密码" value="${actionBean.user.password}"/></td>
                <tr>
                    <th class="td">用户电话</th>
                    <td class="td"><stripes:text name="用户电话" value="${actionBean.user.phoneNumber}"/></td>
                </tr>
                <tr>
                    <th class="td">用户会员号</th>
                    <td class="td">${actionBean.user.membership}</td>
                    <stripes:hidden name="user.membership"/>
                </tr>
                <stripes:hidden name="user.useraddressid"/>
                <th class="th"><stripes:submit name="updateUser" value="修改用户信息"/></th>
                </tr>
            </table>
            <table class="table">
                <tr>
                    <th class="th">地址信息</th>
                </tr>
                <tr>
                    <th class="th">地址ID</th>
                    <th class="th">地址</th>
                    <th class="th">收件人</th>
                    <th class="th">电话</th>
                    <th class="th">邮编</th>
                    <th class="th"></th>
                </tr>
                <c:forEach items="${actionBean.listAddress}" var="address" varStatus="rowstat">
                    <tr class="${rowstat.count mod 2 == 0 ? "even" : "odd"}">
                        <td class="td">${address.addressKey}</td>
                        <td class="td">${address.userAddress}</td>
                        <td class="td">${address.recipientName}</td>
                        <td class="td">${address.phoneNumber}</td>
                        <td class="td">${address.postcode}</td>
                        <stripes:hidden name="addressid" value="${address.useraddressid}"/>
                        <td class="td">
                            <stripes:link href="/UpdateUserAddress.action" event="updateAddress">
                                修改
                                <stripes:param name="address.addressKey" value="${address.addressKey}"/>
                                <stripes:param name="targetUrl" value="/SingleUser.action?${pageContext.request.queryString}"/>
                            </stripes:link>
                        </td>
                        <td class="td">
                            <stripes:link href="/SingleUser.action" event="delAddress">
                                删除
                                <stripes:param name="delAddress.addressKey" value="${address.addressKey}"/>
                                <stripes:param name="user.userid" value="${actionBean.user.userid}"/>
                            </stripes:link>
                        </td>
                    </tr>
                </c:forEach>
                <tr/>
                <tr>
                    <th class="th">新地址</th>
                    <th class="th"><stripes:text name="地址" value=""/></th>
                    <th class="th"><stripes:text name="收件人" value=""/></th>
                    <th class="th"><stripes:text name="电话" value=""/></th>
                    <th class="th"><stripes:text name="邮编" value=""/></th>
                    <th class="th"><stripes:submit name="saveAddress" value="添加"/></th>
                </tr>
            </table>

        </stripes:form>
    </stripes:layout-component>
</stripes:layout-render>
