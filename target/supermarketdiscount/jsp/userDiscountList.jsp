<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/jsp/taglibs.jsp" %>

<stripes:layout-render name="/jsp/layout/standard.jsp" title="Bug List">
    <stripes:layout-component name="contents">
        <stripes:form action="/UserDiscountList.action">
            <stripes:errors/>

            <c:choose>
                <c:when test="${(actionBean == null)||(actionBean.className != 'UserDiscountListActionBean')}">
                    <c:set var="actionBean"
                           value="<%= new org.supermarketdiscount.action.UserDiscountListActionBean()%>"
                           scope="page"/>
                </c:when>
            </c:choose>

            <table class="table">
                <tr>
                    <th class="th">用户折扣</th>
                </tr>
                <th class="th">用户ID</th>
                <th char="th">商品ID</th>
                <th class="th">折扣等级</th>
                <th class="th">优惠价格</th>
                <th class="th">周期消费数量</th>
                <%--<th>${pageContext.request.queryString}</th>--%>
                <c:forEach items="${actionBean.userDiscountlist}" var="userDiscount" varStatus="rowstat">
                    <tr class="${rowstat.count mod 2 == 0 ? "even" : "odd"}">
                        <td class="td">${userDiscount.userid}</td>
                        <td class="td">${userDiscount.commodityid}</td>
                        <td class="td">
                                ${userDiscount.promotionstandard}
                            <stripes:link href="/UpdateUserDiscount.action" event="update">
                                修改
                                <stripes:param name="targetUrl"
                                               value="/UserDiscountList.action?${pageContext.request.queryString}"/>
                                <stripes:param name="discount.commodityid" value="${userDiscount.commodityid}"/>
                                <stripes:param name="discount.userid" value="${userDiscount.userid}"/>
                                <stripes:param name="discount.promotionstandard"
                                               value="${userDiscount.promotionstandard}"/>
                            </stripes:link>
                        </td>
                        <td class="td">${userDiscount.promotionPrice}</td>
                        <td class="td">${userDiscount.salseCount}</td>
                        <td class="td">
                            <stripes:link href="/UserDiscountList.action" event="delUserDiscount">
                                删除
                                <stripes:param name="userDiscount.userid" value="${actionBean.userDiscount.userid}"/>
                                <stripes:param name="userDiscount.commodityid"
                                               value="${actionBean.userDiscount.commodityid}"/>
                                <stripes:param name="delUserDiscount.commodityid" value="${userDiscount.commodityid}"/>
                                <stripes:param name="delUserDiscount.userid" value="${userDiscount.userid}"/>
                                <stripes:param name="delUserDiscount.promotionstandard"
                                               value="${userDiscount.promotionstandard}"/>
                            </stripes:link>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <div class="buttons">
                <stripes:hidden name="userDiscount.userid" value="${actionBean.userDiscount.userid}"/>
                <stripes:hidden name="userDiscount.commodityid" value="${actionBean.userDiscount.commodityid}"/>
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
