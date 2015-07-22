<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/jsp/taglibs.jsp" %>

<stripes:layout-render name="/jsp/layout/standard.jsp" title="Bug List">
    <stripes:layout-component name="contents">
        <stripes:form action="/UpdateUserAddress.action">
            <stripes:errors/>

            <c:choose>
                <c:when test="${actionBean == null}">
                    <c:set var="actionBean"
                           value="<%= new org.supermarketdiscount.action.UpdateUserAddressActionBean()%>" scope="page"/>
                </c:when>
            </c:choose>
            <stripes:hidden name="targetUrl" value="${actionBean.targetUrl}"/>
            <table class="table">
                <tr>
                    <th class="th">地址ID</th>
                    <td class="td">${actionBean.address.addressKey}</td>
                    <stripes:hidden name="address.addressKey" value="${actionBean.address.addressKey}"/>
                    <stripes:hidden name="address.useraddressid" value="${actionBean.address.useraddressid}"/>
                </tr>
                <tr>
                    <th class="th">地址</th>
                    <td class="td"><stripes:text name="地址" value="${actionBean.address.userAddress}"/></td>
                </tr>
                <tr>
                    <th class="th">收件人</th>
                    <td class="td"><stripes:text name="收件人" value="${actionBean.address.recipientName}"/></td>
                </tr>
                <tr>
                    <th class="th">电话</th>
                    <td class="td"><stripes:text name="电话" value="${actionBean.address.phoneNumber}"/></td>
                </tr>
                <tr>
                    <th class="th">邮编</th>
                    <td class="td"><stripes:text name="邮编" value="${actionBean.address.postcode}"/></td>
                </tr>
                <tr>
                    <th class="th"><stripes:submit name="update" value="保存"/></th>
                </tr>
            </table>
        </stripes:form>
    </stripes:layout-component>
</stripes:layout-render>
