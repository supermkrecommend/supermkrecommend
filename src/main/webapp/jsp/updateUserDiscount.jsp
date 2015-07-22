<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/jsp/taglibs.jsp" %>

<stripes:layout-render name="/jsp/layout/standard.jsp" title="Bug List">
    <stripes:layout-component name="contents">
        <stripes:form action="/UpdateUserDiscount.action">
            <stripes:errors/>

            <c:choose>
                <c:when test="${actionBean == null}">
                    <c:set var="actionBean"
                           value="<%= new org.supermarketdiscount.action.UpdateUserDiscountActionBean()%>"
                           scope="page"/>
                </c:when>
            </c:choose>
            <stripes:hidden name="targetUrl" value="${actionBean.targetUrl}"/>
            <table class="table">
                <tr>
                    <th class="th">修改用户折扣</th>
                </tr>
                <tr>
                    <th class="th">用户ID</th>
                    <th class="th">用户名</th>
                    <th class="th">商品名称</th>
                    <th class="th">折扣等级</th>
                    <th class="th">优惠价格</th>
                    <th class="th">周期最小购买数量</th>
                    <th class="th">周期最大购买数量</th>
                    <th class="th">本周期购买数量</th>
                </tr>
                <tr>
                    <td class="td">${actionBean.user.userid}</td>
                    <td class="td">${actionBean.user.username}</td>
                    <td class="td">${actionBean.commodity.commodityName}</td>
                    <td class="td">
                        <stripes:select name="discountStandard" onchange="handleChangepromotionstandard(this, event)">
                            <stripes:options-collection collection="${actionBean.discountStandardbiz}"
                                                        label="promotionstandard" value="discountStandard"/>
                        </stripes:select>
                    </td>
                    <td class="td" id="salse">${actionBean.standard.salse}</td>
                    <td class="td" id="minCount">${actionBean.standard.minCount}</td>
                    <td class="td" id="maxCount">${actionBean.standard.maxCount}</td>
                    <td class="td">${actionBean.discount.salseCount}</td>
                    <stripes:hidden name="discount.userid" value="${actionBean.discount.userid}"/>
                    <stripes:hidden name="discount.commodityid" value="${actionBean.discount.commodityid}"/>
                    <stripes:hidden name="discount.salseCount" value="${actionBean.discount.salseCount}"/>
                    <stripes:hidden name="discount.typeid" value="${actionBean.discount.typeid}"/>
                </tr>
                <tr>
                    <th class="th">
                        <stripes:submit name="updateDscount" value="修改折扣"/>
                    </th>
                </tr>
            </table>
        </stripes:form>
    </stripes:layout-component>
</stripes:layout-render>
