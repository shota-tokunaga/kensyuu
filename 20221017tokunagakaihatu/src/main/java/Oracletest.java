あああああああ
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
 
public class Oracletest {
 
    public static void main(String[] args) throws Exception {
 
        Connection con = null;
        Statement smt = null;
        ResultSet rs = null;
 
        //ホスト名
        String hostname = "163.149.99.38";
        //SID
        String sid = "oracle";
        //ユーザー名
        String username = "kenshu";
        //パスワード
        String passwd = "kenshu";
 
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@" + hostname + ":1521:" + sid,username,passwd);
 
            smt = con.createStatement();
            rs = smt.executeQuery("SELECT * FROM MST_SEIHIN");
 
            while(rs.next()){
                System.out.println(
                    "SEIHIN_CODE=" + rs.getString("SEIHIN_CODE")
                    + ",SEIHIN_NAME=" + rs.getString("SEIHIN_NAME")
                    + ",SEIHIN_GENKA=" + rs.getString("SEIHIN_GENKA")
                    + ",SEIHIN_TEIKA=" + rs.getString("SEIHIN_TEIKA")
                );
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        smt.close();
        con.close();
    }
 
}