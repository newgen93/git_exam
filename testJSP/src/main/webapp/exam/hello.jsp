<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
//전역, 1번, init()
String name = "홍길동";
int age = 25;
%>

<%
//지역, 매번, service()
age++;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Hello JSP!!<br> -->

<%--안녕하세요 JSP!!<br> --%>

Hello JSP!!<br>

안녕하세요 JSP<br>

나의 이름은<%=name %> 입니다<br>

<!-- 내 나이는<%=age %>살 입니다<br>  --> 

<%-- <% out.println("내 나이는 " + age + "살 입니다"); %> --%>

</body>
</html>