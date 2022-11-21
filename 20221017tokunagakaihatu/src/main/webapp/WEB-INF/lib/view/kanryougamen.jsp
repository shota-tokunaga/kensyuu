<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


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
















</body>
</html>