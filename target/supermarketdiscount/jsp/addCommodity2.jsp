<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/jsp/taglibs.jsp" %>

<stripes:layout-render name="/jsp/layout/standard.jsp" title="Bug List">
    <stripes:layout-component name="contents">
        <stripes:form action="/AddCommodity.action">

            <c:choose>
                <c:when test="${actionBean == null}">
                    <c:set var="actionBean" value="<%= new org.supermarketdiscount.action.AddCommodityActionBean()%>"
                           scope="page"/>
                </c:when>
            </c:choose>
            <table class="table">
                <tr>
                    <th>增加的商品</th>
                </tr>
                <tr>
                    <th class="th">商品名称</th>
                    <th class="th">商品规格</th>
                    <th class="th">产品产地</th>
                    <th class="th">产品价格</th>
                    <th class="th">是否快消</th>
                    <th class="th">统计间隔时间</th>
                    <th class="th">提前通知天数</th>
                    <th class="th">上次统计时间</th>
                </tr>
                <tr>
                    <td class="td">${actionBean.commodity.commodityName}</td>
                    <stripes:hidden name="commodity.commodityName" value="${actionBean.commodity.commodityName}"/>
                    <td class="td">${actionBean.commodity.qualification}</td>
                    <stripes:hidden name="commodity.qualification" value="${actionBean.commodity.qualification}"/>
                    <td class="td">${actionBean.commodity.manufacture}</td>
                    <stripes:hidden name="commodity.manufacture" value="${actionBean.commodity.manufacture}"/>
                    <td class="td">${actionBean.commodity.basePrice}</td>
                    <stripes:hidden name="commodity.basePrice" value="${actionBean.commodity.basePrice}"/>
                    <td class="td">${actionBean.commodity.isquickSale}</td>
                    <stripes:hidden name="commodity.isquickSale" value="${actionBean.commodity.isquickSale}"/>
                    <td class="td">${actionBean.calculateTime.spaceTime}</td>
                    <stripes:hidden name="calculateTime.spaceTimee" value="${actionBean.calculateTime.spaceTime}"/>
                    <td class="td">${actionBean.calculateTime.alertAheadTime}</td>
                    <stripes:hidden name="calculateTime.alertAheadTime" value="${actionBean.calculateTime.alertAheadTime}"/>
                    <td class="td"><fmt:formatDate value="${actionBean.calculateTime.lastDate}" dateStyle="medium"/></td>
                    <stripes:hidden name="calculateTime.lastDate" value="${actionBean.calculateTime.lastDate}"/>
                </tr>
            </table>
            <table class="table">
                <tr>
                    <th>商品折扣</th>
                </tr>
                <tr>
                    <th class="th">商品名称</th>
                    <th class="th">折扣等级</th>
                    <th class="th">优惠价格</th>
                    <th class="th">周期最小购买数</th>
                    <th class="th">周期最大购买数</th>
                    <th class="th">提前通知数量</th>
                </tr>
                <c:forEach items="${actionBean.discountStandard}" var="discount" varStatus="rowstat">
                    <tr class="${rowstat.count mod 2 == 0 ? "even" : "odd"}">
                        <td class="td">${actionBean.commodity.commodityName}</td>
                        <td class="td">${discount.promotionstandard}</td>
                        <td class="td">${discount.salse}</td>
                        <td class="td">${discount.minCount}</td>
                        <td class="td">${discount.maxCount}</td>
                        <td class="td">${discount.alterAmount}</td>
                        <td class="td">
                            <stripes:link href="/UpdateDiscount.action" event="updateDiscount">
                                修改
                                <stripes:param name="discount.salsePriceid" value="${discount.salsePriceid}"/>
                            </stripes:link>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <stripes:errors action="/AddCommodity.action"/>
                    <th class="th">${actionBean.commodity.commodityName}</th>
                    <stripes:hidden name="standard.commodityid" value="${actionBean.commodity.commodityid}"/>
                    <stripes:hidden name="commodity.commodityid" value="${actionBean.commodity.commodityid}"/>
                    <th class="th"><stripes:text name="折扣等级" value=""/></th>
                    <th class="th"><stripes:text name="优惠价格" value=""/></th>
                    <th class="th"><stripes:text name="周期最小购买数" value=""/></th>
                    <th class="th"><stripes:text name="周期最大购买数" value=""/></th>
                    <th class="th"><stripes:text name="提前通知数量" value=""/></th>
                    <th class="th"><stripes:submit name="saveDiscount" value="保存"/></th>
                </tr>
            </table>
        </stripes:form>
    </stripes:layout-component>
</stripes:layout-render>
