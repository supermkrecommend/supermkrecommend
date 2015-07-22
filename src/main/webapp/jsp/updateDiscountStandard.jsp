<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/jsp/taglibs.jsp" %>

<stripes:layout-render name="/jsp/layout/standard.jsp" title="Bug List">
    <stripes:layout-component name="contents">
        <stripes:form action="/UpdateDiscount.action">
            <stripes:errors/>

            <c:choose>
                <c:when test="${actionBean == null}">
                    <c:set var="actionBean" value="<%= new org.supermarketdiscount.action.UpdateDiscountActionBean()%>"
                           scope="page"/>
                </c:when>
            </c:choose>

            <stripes:hidden name="targetUrl" value="${actionBean.targetUrl}"/>
            <table class="table">
                <tr>
                    <th class="th">修改折扣</th>
                </tr>
                <tr>
                    <th class="th">折扣等级</th>
                    <th class="th">优惠价格</th>
                    <th class="th">周期最小购买数</th>
                    <th class="th">周期最大购买数</th>
                    <th class="th">提前通知数量</th>
                </tr>
                <tr>
                    <stripes:hidden name="discount.salsePriceid" value="actionBean.discount.salsePriceid"/>
                    <stripes:hidden name="discount.commodityid" value="actionBean.discount.commodityid"/>
                    <stripes:hidden name="discount.promotionstandard" value="actionBean.discount.promotionstandard"/>
                    <td class="td">${actionBean.discount.promotionstandard}</td>
                    <td class="td"><stripes:text name="优惠价格" value="${actionBean.discount.promotionsalse}"/></td>
                    <td class="td"><stripes:text name="周期最小购买数" value="${actionBean.discount.minCount}"/></td>
                    <td class="td"><stripes:text name="周期最大购买数" value="${actionBean.discount.maxCount}"/></td>
                    <td class="td"><stripes:text name="提前通知数量" value="${actionBean.discount.alterAmount}"/></td>
                </tr>
                <tr>
                    <th class="th">
                        <stripes:submit name="update" value="修改折扣"/>
                    </th>
                </tr>
            </table>
        </stripes:form>
    </stripes:layout-component>
</stripes:layout-render>
