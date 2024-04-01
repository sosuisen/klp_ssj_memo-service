<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メモアプリ</title>
</head>
<body>
	<h1>メモを入力してください</h1>
	<form action="./" method="post">
		<input type="text" name="memo">
		<button>追加</button>
	</form>
	<h2>メモ一覧</h2>
	<ul>
	<%
	var memoList = (List<String>)request.getAttribute("memoList");
    for (var memo : memoList) { %>
		<li><%= memo %>
	<%
	}
    %>
	</ul>
</body>
</html>
