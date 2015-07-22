<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/jsp/taglibs.jsp" %>

<stripes:layout-render name="/jsp/layout/standard.jsp" title="Bug List">
    <stripes:layout-component name="contents">
        <stripes:form action="/CommodityList.action">
            <stripes:errors/>

            <c:choose>
                <c:when test="${(actionBean == null)||(actionBean.className != 'CommodityListActionBean' )}">
                    <c:set var="actionBean" value="<%= new org.supermarketdiscount.action.CommodityListActionBean()%>"
                           scope="page"/>
                </c:when>
            </c:choose>
            <table class="table">
                <tr>
                    <th class="th">商品ID</th>
                    <th class="th">商品名称</th>
                    <th class="th">产地</th>
                    <th class="th">规格</th>
                    <th class="th">基础价格</th>
                    <th class="th">是否快消</th>
                </tr>
                <c:forEach items="${actionBean.pages}" var="commodity" varStatus="rowstat">
                    <tr class="${rowstat.count mod 2 == 0 ? "even" : "odd"}">
                        <td class="td">${commodity.commodityid}</td>
                        <td class="td">${commodity.commodityName}</td>
                        <td class="td">${commodity.manufacture}</td>
                        <td class="td">${commodity.qualification}</td>
                        <td class="td">${commodity.basePrice}</td>
                        <td class="td">${commodity.isquickSale}</td>
                        <td class="td">
                            <stripes:link href="/SingleCommodity.action" event="commodityEdit">
                                详细
                                <stripes:param name="commodity.commodityid" value="${commodity.commodityid}"/>
                            </stripes:link>
                        </td>
                        <td class="td">
                            <stripes:link href="/DiscountStandardList.action" event="standardList">
                                折扣等级
                                <stripes:param name="commodity.commodityid" value="${commodity.commodityid}"/>
                            </stripes:link>
                        </td>
                        <td class="td">
                            <stripes:link href="/UserDiscountList.action" event="userDiscountList">
                                用户折扣
                                <stripes:param name="userDiscount.commodityid" value="${commodity.commodityid}"/>
                            </stripes:link>
                        </td>
                        <td class="td">
                            <stripes:link href="/CommodityList.action" event="delCommodity">
                                删除
                                <stripes:param name="commodity.commodityid" value="${commodity.commodityid}"/>
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
