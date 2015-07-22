<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/jsp/taglibs.jsp" %>

<stripes:layout-render name="/jsp/layout/standard.jsp" title="Bug List">
    <stripes:layout-component name="contents">
        <stripes:form action="/DiscountStandardList.action">
            <stripes:errors/>

            <c:choose>
                <c:when test="${(actionBean == null)||(actionBean.className != 'DiscountStandardListActionBean')}">
                    <c:set var="actionBean"
                           value="<%= new org.supermarketdiscount.action.DiscountStandardListActionBean()%>"
                           scope="page"/>
                </c:when>
            </c:choose>
            <table class="table">
                <tr>
                    <th class="th">商品信息</th>
                </tr>
                <tr>
                    <td class="td">ID</td>
                    <td class="td">${actionBean.commodity.commodityid}</td>
                </tr>
                <tr>
                    <td class="td">名称</td>
                    <td class="td">${actionBean.commodity.commodityName}</td>
                </tr>
                <tr>
                    <td class="td">产地</td>
                    <td class="td">${actionBean.commodity.manufacture}</td>
                </tr>
                <tr>
                    <td class="td">规格</td>
                    <td class="td">${actionBean.commodity.qualification}</td>
                </tr>
                <tr>
                    <td class="td">基础价格</td>
                    <td class="td">${actionBean.commodity.basePrice}</td>
                </tr>
                <tr>
                    <td class="td">预估使用天数</td>
                    <td class="td">${actionBean.commodity.consumeday}</td>
                </tr>
                <tr>
                    <td class="td">是否快消</td>
                    <td class="td">${actionBean.commodity.isquickSale}</td>
                </tr>
            </table>
            <table class="table">
                <tr>
                    <th class="th">商品折扣</th>
                </tr>
                <th class="th">商品名称</th>
                <th class="th">折扣等级</th>
                <th class="th">优惠价格</th>
                <th class="th">周期最小购买数</th>
                <th class="th">周期最大购买数</th>
                <th class="th">提前通知数量</th>
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
                                <stripes:param name="targetUrl"
                                               value="/DiscountStandardList.action?${pageContext.request.queryString}"/>
                                <stripes:param name="discount.salsePriceid" value="${discount.salsePriceid}"/>
                            </stripes:link>
                        </td>
                        <td class="td">
                            <stripes:link href="/DiscountStandardList.action" event="delDiscountStandard">
                                删除
                                <stripes:param name="delStandard.commodityid" value="${discount.commodityid}"/>
                                <stripes:param name="delStandard.promotionstandard"
                                               value="${discount.promotionstandard}"/>
                            </stripes:link>
                        </td>
                    </tr>
                </c:forEach>
                <th class="th">添加折扣</th>
                <stripes:hidden name="commodity.commodityid" value="${actionBean.commodity.commodityid}"/>
                <stripes:hidden name="standard.commodityid" value="${actionBean.commodity.commodityid}"/>
                <th class="th"><stripes:text name="折扣等级" value=""/></th>
                <th class="th"><stripes:text name="优惠价格" value=""/></th>
                <th class="th"><stripes:text name="周期最小购买数" value=""/></th>
                <th class="th"><stripes:text name="周期最大购买数" value=""/></th>
                <th class="th"><stripes:text name="提前通知数量" value=""/></th>
                <th class="th"><stripes:submit name="saveDiscount" value="保存"/></th>
            </table>

        </stripes:form>
    </stripes:layout-component>
</stripes:layout-render>
