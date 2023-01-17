<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String id = (String) request.getAttribute("id");
%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>マイページ</title>
  </head>
  <body>
    <div>
     <p>ようこそ <%= id %> さん </p>
    </div>
    </body>
</html>