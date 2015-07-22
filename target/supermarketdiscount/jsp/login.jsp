<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/jsp/taglibs.jsp" %>

<stripes:layout-render name="/jsp/layout/standard.jsp" title="登陆">
    <input type="datetime-local" name="fname"/>
    <stripes:layout-component name="contents">

        <!-- Somewhat contrived example of using the errors tag 'action' attribute. -->

        <%--<stripes:errors/>--%>
        <stripes:form action="/Login.action" focus="">

            <table id="login">
                <tr>
                    <td><stripes:errors action="/Login.action"/></td>
                </tr>
                <tr>
                    <td id="normal" style="font-weight: bold;"><stripes:label for="用户名"/>:</td>
                </tr>
                <tr>
                    <td><stripes:text name="用户名" value="${user.username}"/></td>
                </tr>
                <tr>
                    <td style="font-weight: bold;"><stripes:label for="密码"/>:</td>
                </tr>
                <tr>
                    <td><stripes:password name="密码"/></td>
                </tr>
                <tr>
                    <td style="text-align: center;">
                            <%-- If the security servlet attached a targetUrl, carry that along. --%>
                        <stripes:hidden name="targetUrl" value="${request.parameterMap['targetUrl']}"/>
                        <stripes:submit name="login" value="Login"/>
                    </td>
                </tr>
            </table>
        </stripes:form>
    </stripes:layout-component>
</stripes:layout-render>
