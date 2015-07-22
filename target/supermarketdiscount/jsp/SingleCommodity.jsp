<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/jsp/taglibs.jsp" %>

<stripes:layout-render name="/jsp/layout/standard.jsp" title="Bug List">
    <stripes:layout-component name="contents">
        <stripes:form action="/SingleCommodity.action">
            <stripes:errors/>

            <c:choose>
                <c:when test="${actionBean == null}">
                    <c:set var="actionBean" value="<%= new org.supermarketdiscount.action.SingleCommodityActionBean()%>"
                           scope="page"/>
                </c:when>
            </c:choose>
            <table class="table">
                <tr>
                    <th class="th">商品详细信息</th>
                </tr>
                <tr>
                    <th class="td">ID</th>
                    <td class="td">${actionBean.commodity.commodityid}</td>
                    <stripes:hidden name="commodity.commodityid"/>
                </tr>
                <tr>
                    <th class="td">商品名称</th>
                    <td class="td"><stripes:text name="商品名称" value="${actionBean.commodity.commodityName}"/></td>
                </tr>
                <tr>
                    <th class="td">产品产地</th>
                    <td class="td"><stripes:text name="产品产地" value="${actionBean.commodity.manufacture}"/></td>
                </tr>
                <tr>
                    <th class="td">商品规格</th>
                    <td class="td"><stripes:text name="商品规格" value="${actionBean.commodity.qualification}"/></td>
                </tr>
                <tr>
                    <th class="td">条形码</th>
                    <th class="th">${actionBean.commodity.shapeCode}</th>
                </tr>
                <tr>
                    <th class="td">产品价格</th>
                    <td class="td"><stripes:text name="产品价格" value="${actionBean.commodity.basePrice}"/></td>
                </tr>
                <tr>
                    <th class="td">是否快消</th>
                    <td class="td">
                        <stripes:select name="是否快消">
                            <stripes:options-collection collection="${actionBean.quickSalebiz}" label="description"
                                                        value="isquickSale"/>
                        </stripes:select>
                    </td>
                </tr>
                <tr>
                    <th class="td">统计间隔时间</th>
                    <td class="td"><stripes:text name="统计间隔时间" value="${actionBean.calculateTime.spaceTime}"/></td>
                </tr>
                <tr>
                    <th class="td">提前通知天数</th>
                    <td class="td"><stripes:text name="提前通知天数" value="${actionBean.calculateTime.spaceTime}"/></td>
                </tr>
                <tr>
                    <th class="td">预估使用天数</th>
                    <td class="td"><stripes:text name="预估使用天数" value="${actionBean.commodity.consumeday}"/></td>
                </tr>
                <tr>
                    <th class="td">上次统计时间</th>
                    <td class="td"><fmt:formatDate value="${actionBean.calculateTime.lastDate}"
                                                   dateStyle="medium"/></td>
                    <stripes:hidden name="calculateTime.lastDate" value="actionBean.calculateTime.alertAheadTime"/>
                </tr>
                <th class="th">
                    <stripes:submit name="updateCommodity" value="修改商品信息"/>
                </th>
                </tr>
            </table>
        </stripes:form>
    </stripes:layout-component>
</stripes:layout-render>
