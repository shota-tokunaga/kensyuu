<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<a href="/20221017tokunagakaihatu/Readmstseihin">
    <button type="button">ホーム画面へ</button>
</a>

<form action="/20221017tokunagakaihatu/Createmstseihin" method="post">



製品コード:<input type="text" name="seihin_code"><br>
製品名:<input type="text" name="seihin_name"><br>
製品原価:<input type="text" name="seihin_genka"><br>
製品定価:<input type="text" name="seihin_teika"><br>

<button type="submit">追加</button>
</form>
</body>
</html>