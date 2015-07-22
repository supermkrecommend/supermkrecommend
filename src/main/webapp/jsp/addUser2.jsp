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
                    <th class="th">用户信息</th>
                </tr>
                <tr>
                    <th class="th">用户名</th>
                    <th class="th">用户密码</th>
                    <th class="th">电话号码</th>
                </tr>
                <tr>
                    <td class="td">${actionBean.user.username}</td>
                    <stripes:hidden name="user.username" value="${actionBean.user.username}"/>
                    <stripes:hidden name="user.userid" value="${actionBean.user.userid}"/>
                    <td class="td">${actionBean.user.password}</td>
                    <stripes:hidden name="user.password" value="${actionBean.user.password}"/>
                    <td class="td">${actionBean.user.phoneNumber}</td>
                    <stripes:hidden name="user.phoneNumber" value="${actionBean.user.phoneNumber}"/>
                    <stripes:hidden name="user.useraddressid" value="${actionBean.user.useraddressid}"/>
                </tr>
            </table>
            <table class="table">
                <tr>
                    <th>地址信息</th>
                </tr>
                <tr>
                    <th class="th">地址ID</th>
                    <th class="th">地址</th>
                    <th class="th">收件人</th>
                    <th class="th">电话</th>
                    <th class="th">邮编</th>
                    <th></th>
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
                            </stripes:link>
                        </td>
                        <td>
                            <stripes:link href="/AddUser.action" event="delAddress">
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
                    <td class="td"><stripes:text name="地址" value=""/></td>
                    <td class="td"><stripes:text name="收件人" value=""/></td>
                    <td class="td"><stripes:text name="电话" value=""/></td>
                    <td class="td"><stripes:text name="邮编" value=""/></td>
                    <th class="th"><stripes:submit name="saveAddress" value="添加"/></th>
                </tr>
            </table>
        </stripes:form>
    </stripes:layout-component>
</stripes:layout-render>
