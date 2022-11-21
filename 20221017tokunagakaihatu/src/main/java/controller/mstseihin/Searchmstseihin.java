
package controller.mstseihin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SeihinDAO;
import model.MSTSEIHIN;

@WebServlet("/Searchmstseihin")
public class Searchmstseihin extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String seihin_code2=request.getParameter("seihin_code");
		String seihin_name2=request.getParameter("seihin_name");
		
		
		SeihinDAO dao=new SeihinDAO();
		List<MSTSEIHIN> list=dao.searchAll(seihin_name2,seihin_code2);
		
		List<MSTSEIHIN> list1=dao.listAll();
		request.setAttribute("list1", list1);
		
		
		
		
		request.setAttribute("list", list);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/lib/view/searchmstseihin.jsp");
		rd.forward(request, response);
		
		
//
//		MSTSEIHIN mstseihin=new MSTSEIHIN(seihin_code);
//
//
//
//		mstseihin.setSeihin_code(seihin_code);
//		
//		SeihinDAO ld=new SeihinDAO();
//		ld.insertOne(mstseihin);

		
		
		
		
		
		
		
	}

	
	
	
	
}

	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
//	
//	
//	Connection con = null;
//    PreparedStatement st = null;
//    try{
//        con = 省略;
//	
//	
//	
//        String sql = "SELECT * FROM usertable WHERE 1=1 ";
//
//        List<String> parameters = new ArrayList<>();
//
//        if (!user.getName().equals("")) {
//          sql += "AND name like ? ";
//          parameters.add("name");
//        }
//
//        if (user.getBirthday()!=null) {
//          sql += "AND birthday like ? ";
//          parameters.add("birthday");
//        }
//	
//	
	
	
	
	
//	$where = []; //検索条件の配列 ここからいろいろ変更してみる
//	$stValues = []; //プリペアドステートメントにセットするValue
//	if(!empty($username)){
//	  $where[] = " name like ? ";
//	  $valueinfo["value"] = $username;
//	  $valueinfo["type"] = "string";
//	  $stValues[] = $valueinfo;
//	}
//	
//	
//	$sql = "SELECT * FROM usertable";
//	if(count($where) > 0){ //検索条件があれば配列をandで結合
//	  $sql .= " where ".implode(" and ",$where);
//	}
//
//
//	$stmt = $dbh->prepare($sql);
//	for($i=0;$i<count($stValues);$i++){ //パラメータをそれぞれの型で判定してバインド
//	  $paramset = $stValues[$i];
//	  $setType = PDO::PARAM_STR; //カラムの型
//	  switch($paramset["type"]){
//	     case "string":
//	      $setvalue = "%".$paramset["value"]."%";
//	      break;
//	     case "yeardate":
//	      $setvalue = $paramset["value"]."%";
//	      break;
//	     case "integer":
//	      $setvalue = $paramset["value"];
//	      $setType = PDO::PARAM_INT;
//	      break;
//	  }
//	  $stmt->bindParam(($i+1), $setvalue,$setType);
//	}
//
//	$stmt->execute();
//	
	
	
	
	
	
	
	
	
	
	
	