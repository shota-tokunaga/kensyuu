<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<a href="/20221017tokunagakaihatu/Readmstkokyaku">
    <button type="button">ホーム画面へ</button>
</a>

<form action="/20221017tokunagakaihatu/Createmstkokyaku" method="post">



製品コード:<input type="text" name="kokyaku_code"><br>
製品名:<input type="text" name="kokyaku_name"><br>
製品原価:<input type="text" name="kokyaku_address"><br>
製品定価:<input type="text" name="kokyaku_tel"><br>

<button type="submit">追加</button>



<a href="/20221017tokunagakaihatu/Kanryougamen">
    <button type="button">完了画面処理</button>
</a>


<script type="text/javascript">

function p_reload(){
var pwin=window.opener;
pwin.location.reload();
pwin.focus();
window.close();
}

</script>
…
<button type="submit" onclick="p_reload()">親を更新して閉じる</button>

</form>
</body>
</html>