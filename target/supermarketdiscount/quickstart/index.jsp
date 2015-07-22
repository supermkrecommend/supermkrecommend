<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
    <title>My First Stripe</title>
    <style type="text/css">
        input.error {
            background-color: yellow;
        }
    </style>
</head>
<body>
<h1>Stripes Calculator</h1>

Hi, I'm the Stripes Calculator. I can only do addition. Maybe, some day, a nice programmer
will come along and teach me how to do other things?

<stripes:form action="/Calculator.action" focus="">
    <stripes:errors/>
    <table>
        <tr>
            <td>数字1:</td>
            <td><stripes:text name="numberOne"/></td>
        </tr>
        <tr>
            <td>数字 2:</td>
            <td><stripes:text name="numberTwo"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <stripes:submit name="addition" value="加法"/>
                <stripes:submit name="division" value="除法"/>
            </td>
        </tr>
        <tr>
            <td>Result:</td>
            <td>${actionBean.result}</td>
        </tr>
    </table>
</stripes:form>
</body>
</html>