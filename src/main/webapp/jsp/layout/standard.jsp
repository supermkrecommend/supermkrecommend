<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/jsp/taglibs.jsp" %>
<stripes:layout-definition>
    <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
    <html>
    <head>
        <title>超市折扣 - ${title}</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link rel="stylesheet" type="text/css" href="${ctx}/jsp/supermarket.css"/>
        <script type="text/javascript" src="${ctx}/jsp/supermarket.js"></script>
    </head>
    <body>
    <div id="contentPanel">
        <stripes:layout-component name="header">
            <jsp:include page="/jsp/layout/header.jsp"/>
        </stripes:layout-component>

        <div id="pageContent">
            <stripes:messages/>
            <stripes:layout-component name="contents"/>
        </div>

    </div>
    </body>
    </html>
</stripes:layout-definition>