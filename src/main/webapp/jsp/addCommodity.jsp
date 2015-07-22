<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/jsp/taglibs.jsp" %>

<stripes:layout-render name="/jsp/layout/standard.jsp" title="Bug List">
    <stripes:layout-component name="contents">
        <stripes:form action="/AddCommodity.action">
            <stripes:errors/>

            <c:choose>
                <c:when test="${(actionBean == null)||(actionBean.className != 'AddCommodityActionBean')}">
                    <c:set var="actionBean" value="<%= new org.supermarketdiscount.action.AddCommodityActionBean()%>"
                           scope="page"/>
                </c:when>
            </c:choose>
            <table class="table">
                <tr>
                    <th>增加商品</th>
                </tr>
                <tr>
                    <th class="th">商品名称</th>
                    <th class="th">商品规格</th>
                    <th class="th">产品产地</th>
                    <th class="th">产品价格</th>
                    <th class="th">是否快消</th>
                    <th class="th">统计间隔时间</th>
                    <th class="th">预估使用天数</th>
                    <th class="th">提前通知天数</th>
                </tr>
                <tr>
                    <td class="td"><stripes:text name="商品名称" value=""/></td>
                    <td class="td"><stripes:text name="商品规格" value=""/></td>
                    <td class="td"><stripes:text name="产品产地" value=""/></td>
                    <td class="td"><stripes:text name="产品价格" value=""/></td>
                    <td class="td">
                        <stripes:select name="是否快消">
                            <stripes:options-collection collection="${actionBean.quickSalebiz}" label="description"
                                                        value="isquickSale"/>
                        </stripes:select>
                    </td>
                    <td class="td"><stripes:text name="统计间隔时间" value=""/></td>
                    <td class="td"><stripes:text name="预估使用天数" value=""/></td>
                    <td class="td"><stripes:text name="提前通知天数" value=""/></td>
                </tr>
                <tr>
                    <th class="th">
                        <stripes:submit name="add" value="添加商品"/>
                    </th>
                </tr>
            </table>
        </stripes:form>
    </stripes:layout-component>
</stripes:layout-render>
