package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.MSTKOKYAKU;

public class KokyakuDAO {
	
		private Connection db;
		private PreparedStatement ps;
		private ResultSet rs;

		//接続共通処理
		private void connect() throws NamingException, SQLException {
			Context context = new InitialContext();
//			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/jsp");
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/Test-DB");
			this.db = ds.getConnection();
		}

		//切断共通処理
		private void disconnect() {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (db != null) {
					db.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		public List<MSTKOKYAKU> findAll() {
			List<MSTKOKYAKU> list = new ArrayList<>();
			try {
				this.connect();
				ps = db.prepareStatement("SELECT * FROM MST_KOKYAKU");
				rs = ps.executeQuery();
				while (rs.next()) {
					String kokyaku_code = rs.getString("kokyaku_code");
					String kokyaku_name = rs.getString("kokyaku_name");
					String kokyaku_address = rs.getString("kokyaku_address");
					String kokyaku_tel = rs.getString("kokyaku_tel");
					MSTKOKYAKU l = new MSTKOKYAKU(kokyaku_code,kokyaku_name,kokyaku_address,kokyaku_tel);
					
			
					l.setKokyaku_code(rs.getString("kokyaku_code"));
					l.setKokyaku_name(rs.getString("kokyaku_name"));
					l.setKokyaku_address(rs.getString("kokyaku_address"));
					l.setKokyaku_tel(rs.getString("kokyaku_tel"));
					
					
					
					list.add(l);
					
					
					
					
				
					
					
					
					
					
					
				}
			} catch (NamingException | SQLException e) {

				e.printStackTrace();
			}finally {
				this.disconnect();
			}

			return list;
		}
		
		
		
		
		
		public void insertOne(MSTKOKYAKU mstkokyaku) {
			try {
				this.connect();
				ps=db.prepareStatement("INSERT INTO mst_kokyaku(kokyaku_code,kokyaku_name,kokyaku_address,kokyaku_tel) VALUES(?,?,?,?)");
				ps.setString(1,mstkokyaku.getKokyaku_code());
				ps.setString(2,mstkokyaku.getKokyaku_name());
				ps.setString(3,mstkokyaku.getKokyaku_address());
				ps.setString(4,mstkokyaku.getKokyaku_tel());
				
				ps.executeUpdate();
			} catch (NamingException | SQLException e) {
				e.printStackTrace();
			}finally {
				this.disconnect();
			}
		}
		
		
		
		
		public MSTKOKYAKU findOne(String s_kokyaku_code) {
			MSTKOKYAKU mstkokyaku1=null;
			try {
				this.connect();
				ps=db.prepareStatement("SELECT * FROM MST_KOKYAKU WHERE kokyaku_code=?");
				ps.setString(1, s_kokyaku_code);
				rs=ps.executeQuery();
				if(rs.next()) {
					String Kokyaku_code=rs.getString("kokyaku_code");
					String Kokyaku_name=rs.getString("kokyaku_name");				
					String kokyaku_address = rs.getString("kokyaku_address");
					String kokyaku_tel = rs.getString("kokyaku_tel");
					
					mstkokyaku1=new MSTKOKYAKU(Kokyaku_code,Kokyaku_name,kokyaku_address,kokyaku_tel);
					
					mstkokyaku1.setKokyaku_code(rs.getString("kokyaku_code"));
					mstkokyaku1.setKokyaku_name(rs.getString("kokyaku_name"));
					mstkokyaku1.setKokyaku_address(rs.getString("kokyaku_address"));
					mstkokyaku1.setKokyaku_address(rs.getString("kokyaku_tel"));		
					
				}
			} catch (NamingException | SQLException e) {
				e.printStackTrace();
			}finally {
				this.disconnect();
			}

			return mstkokyaku1;
		}
		
		
		
		
		public void updateOne(MSTKOKYAKU mstkokyaku) {
			try {
				this.connect();
				ps=db.prepareStatement("UPDATE MST_KOKYAKU SET kokyaku_code=?,kokyaku_name=?,kokyaku_address=?,kokyaku_tel=? WHERE kokyaku_code=?");
				
				
				ps.setString(1,mstkokyaku.getKokyaku_code());
				ps.setString(2,mstkokyaku.getKokyaku_name());
				ps.setString(3,mstkokyaku.getKokyaku_address());
				ps.setString(4,mstkokyaku.getKokyaku_tel());
				ps.setString(5,mstkokyaku.getKokyaku_code());
				
				ps.executeUpdate();
			} catch (NamingException | SQLException e) {
				e.printStackTrace();
			}finally {
				this.disconnect();
			}
		}
		
		
		
		
		
		public void deleteOne(String kokyaku_code) {
			try {
				this.connect();
				ps=db.prepareStatement("DELETE FROM MST_KOKYAKU WHERE kokyaku_code=?");
				ps.setString(1, kokyaku_code);
				ps.executeUpdate();
			} catch (NamingException | SQLException e) {
				e.printStackTrace();
			}finally {
				this.disconnect();
			}
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
		
		public List<MSTKOKYAKU> searchAll(String kokyaku_code2,String kokyaku_name2) {
			List<MSTKOKYAKU> list = new ArrayList<>();
			try {
			
				this.connect();
				ps = db.prepareStatement("SELECT * FROM MST_KOKYAKU WHERE kokyaku_name LIKE ? AND kokyaku_code LIKE ?");
				
				
				ps.setString(1, "%"+kokyaku_name2+"%");
				ps.setString(2, "%"+kokyaku_code2+"%");
				rs = ps.executeQuery();
				while (rs.next()) {
					String kokyaku_code = rs.getString("kokyaku_code");
					String kokyaku_name = rs.getString("kokyaku_name");
					String kokyaku_address = rs.getString("kokyaku_address");
					String kokyaku_tel = rs.getString("kokyaku_tel");
					
					
					MSTKOKYAKU l = new MSTKOKYAKU(kokyaku_code, kokyaku_name, kokyaku_address, kokyaku_tel);
					
			
					l.setKokyaku_code(rs.getString("kokyaku_code"));
					l.setKokyaku_name(rs.getString("kokyaku_name"));
					l.setKokyaku_address(rs.getString("kokyaku_address"));
					l.setKokyaku_tel(rs.getString("kokyaku_tel"));
					
					list.add(l);
				}
			} catch (NamingException | SQLException e) {

				e.printStackTrace();
			}finally {
				this.disconnect();
			}

			return list;
		}
		
		
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
		
		
		
		
		

		public List<MSTKOKYAKU> listAll() {
			List<MSTKOKYAKU> list = new ArrayList<>();
			try {
				this.connect();
				ps = db.prepareStatement("SELECT * FROM MST_KOKYAKU");
				rs = ps.executeQuery();
				while (rs.next()) {
					String kokyaku_code = rs.getString("kokyaku_code");
					String kokyaku_name = rs.getString("kokyaku_name");
					String kokyaku_address = rs.getString("kokyaku_address");
					String kokyaku_tel = rs.getString("kokyaku_tel");
					MSTKOKYAKU l = new MSTKOKYAKU(kokyaku_code, kokyaku_name, kokyaku_address, kokyaku_tel);
					
			
					l.setKokyaku_code(rs.getString("kokyaku_code"));
					l.setKokyaku_name(rs.getString("kokyaku_name"));
					l.setKokyaku_address(rs.getString("kokyaku_address"));
					l.setKokyaku_tel(rs.getString("kokyaku_tel"));
					
					list.add(l);
				}
			} catch (NamingException | SQLException e) {

				e.printStackTrace();
			}finally {
				this.disconnect();
			}

			return list;
		}
		

		
		
		
		
}

