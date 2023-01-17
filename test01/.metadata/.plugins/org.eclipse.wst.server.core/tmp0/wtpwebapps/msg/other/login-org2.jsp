<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<!-- リクエストスコープからエラーメッセージを受け取る -->
<%String failureMessage = (String)request.getAttribute("loginFailure"); %>

<script type="text/javascript">
function check () {
var userName = document.loginForm.username.value;
var passWord = document.loginForm.password,value;

if ( userName == "" ) {
alert ( "ユーザ名を入力して下さい。" );
document.loginForm.username.focus();
return false;
}

if ( passWord == "" ) {
alert ( "パスワードを入力して下さい。" );
document.loginForm.password.focus();
return false;
}

return true;
}
</script>
</head>
    <form action="login" method="post" onSubmit="returncheck();">
    <div>ID: <input type="text" name="id"></div>
    <div>PASS: <input type="password" name="password"></div>
    <div><button type="submit">ログイン</button></div>
    <span class="label label-danger">${message}</span>
    </form>
  </body>
</html>