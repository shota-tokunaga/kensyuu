


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*,java.util.*"%>
<%
@SuppressWarnings("unchecked")
List<MSTSEIHIN> list=(List<MSTSEIHIN>)request.getAttribute("list");
@SuppressWarnings("unchecked")
List<MSTSEIHIN> list1=(List<MSTSEIHIN>)request.getAttribute("list1");
%>
<!DOCTYPE html>
<html>
<head>






<style>

.indicator::before {
  content: "";
  height: 100px;
  width: 100px;
  position: absolute;
  border: 50px solid transparent;;
  border-bottom-color: #aaa;
  margin-top: -5px;
}


.indicator::after {
  content: "";
  height: 100px;
  width: 100px;
  position: absolute;
  border: 50px solid transparent;;
  border-top-color: #555;
  margin-top: 105px;
}


.listcss{
    overflow: auto;
     /*width: 100%;*/
    height: 400px;
}
.listcss table{
    margin: 0;
    border-spacing: 0;
    table-layout: fixed;
    width: 100%;

}

.body{
    white-space: nowrap;
    border-right: 1px solid #999;
    border-bottom: 1px solid #999;
    background: #FFF;
    padding: 2px;
}

.listcss tr:nth-child(even) td{
	background: #ffffe0;
}

.listcss th{
	cursor: pointer;

	
    white-space: nowrap;
    border-right: 1px solid #999;
    border-bottom: 1px solid #999;
    background: #f2f2f2;
    position: sticky;
    top: 0;
    left: 0;
    
}



.listcss th::before, .listcss th::after {
  content: "";
  height: 0;
  width: 0;
  position: absolute;
  border: 5px solid transparent;
  right: 7px;
  top: 50%;
}

.listcss th::before {
    border-bottom-color: #aaa;
    margin-top: -10px;
}
.listcss th::after {
    border-top-color: #aaa;
    margin-top: 2px;
}





.errormessage {
	color: #ff0000;
}

.label{
/* 背景の上から95％に色をつける */
background:linear-gradient(to bottom,#f2f2f2 0% 95%, rgba(0,0,0,0) 95% 100%);
}


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



body {
	width:90%;
    margin: 0 auto;
}







</style>



















<body>

<a href="/20221017tokunagakaihatu/Readmstseihin">
    <button   class="buttoncss"  type="button">ホーム画面へ</button>
</a>



<form action="/20221017tokunagakaihatu/Searchmstseihin" method="post">
	<div>
	
		
	
  



   <select name="seihin_code">
    <option value="">製品コードを選択</option>
   <%for(MSTSEIHIN mstseihin:list1){ %>
   
     
      <option value="<%=mstseihin.getSeihin_code() %>"> <%=mstseihin.getSeihin_code() %></option>
     <%}%>	
   </select>

		
	
		
		
		
		
		
		
		
		
		
	 <label for="search">製品名から検索</label>
		<input type="search" name="seihin_name" placeholder="キーワードを入力">
		
		
		
	</div>
	<input class="label" type="submit" value="検索する" />

	
	
</form>








<a href="/20221017tokunagakaihatu/Createmstseihin">新規追加</a>
<%//if(list !=null && list.size()>0){ %>


<div class="listcss" >

<table border="1">
<tr><th>製品コード</th><th>製品名</th><th>製品定価</th><th>製品原価</th><th>機能</th></tr>



<%for(MSTSEIHIN mstseihin:list){ %>



<tr>
<td><%=mstseihin.getSeihin_code() %></td>
<td><%=mstseihin.getSeihin_name() %></td>
<td><%=mstseihin.getSeihin_genka() %></td>
<td><%=mstseihin.getSeihin_teika() %></td>
<td>
<a href="/20221017tokunagakaihatu/Updatemstseihin?seihin_code=<%=mstseihin.getSeihin_code() %>">更新</a>
<a href="/20221017tokunagakaihatu/Deletemstseihin?seihin_code=<%=mstseihin.getSeihin_code() %>" onclick="return confirm('seihin_code=<%=mstseihin.getSeihin_code()%>を削除してよろしいですか？');">削除</a>
</td>
</tr>

<%} %>

</table>
</div>
<%//} %>
</body>
</html>