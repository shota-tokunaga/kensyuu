

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*,java.util.*"%>
<%
MSTKOKYAKU mstkokyaku = (MSTKOKYAKU)request.getAttribute("mstkokyaku");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style>



.buttoncss {
  display       : inline-block;
  font-size     : 12pt;        /* 文字サイズ */
  text-align    : center;      /* 文字位置   */
  cursor        : pointer;     /* カーソル   */
  padding       : 7px 8px;   /* 余白       */
  background    : #007749;     /* 背景色     */
  color         : #ffffff;     /* 文字色     */
  line-height   : 1em;         /* 1行の高さ  */
  opacity       : 1;         /* 透明度     */
  transition    : .3s;         /* なめらか変化 */
  border: none;/*線を消す*/
  text-decoration: none;
}
.buttoncss:hover {
  background    : rgb(0,140,86);     /* 背景色     */
}

.buttoncss:active {
 /* border-bottom: solid 2px #fd9535;
  box-shadow: 0 0 2px rgba(0, 0, 0, 0.30);*/
  background    : #007749;     /* 背景色     */   */  
}


</style>



<body>

<a href="/20221017tokunagakaihatu/Readmstkokyaku">
    <button  class="buttoncss" type="button">ホーム画面へ</button>
</a>




<form action="/20221017tokunagakaihatu/Updatemstkokyaku" method="Post">


	

顧客コード:<input type="text" name="kokyaku_code" value="<%=mstkokyaku.getKokyaku_code()%>"><br>

顧客名:<input type="text" name="kokyaku_name" value="<%=mstkokyaku.getKokyaku_name()%>"><br>

住所:<input type="text" name="kokyaku_address" value="<%=mstkokyaku.getKokyaku_address()%>"><br>

電話番号:<input type="text" name="kokyaku_tel" value="<%=mstkokyaku.getKokyaku_tel()%>"><br>




<button type="submit">更新</button>
</form>
</body>
</html>