<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- リクエストスコープからログインユーザーのIDを取得する -->
<%String id = (String)request.getAttribute("id1"); %>

<!-- メッセージを表示する -->
<h1>ログイン成功！！</h1>
<h2>こんにちは！<%= id %>さん</h2>
</body>
</html>