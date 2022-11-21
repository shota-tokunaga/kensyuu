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

import model.MSTSEIHIN;

public class SeihinDAO {
	
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

		public List<MSTSEIHIN> findAll() {
			List<MSTSEIHIN> list = new ArrayList<>();
			try {
				this.connect();
				ps = db.prepareStatement("SELECT * FROM MST_SEIHIN");
				rs = ps.executeQuery();
				while (rs.next()) {
					String seihin_code = rs.getString("seihin_code");
					String seihin_name = rs.getString("seihin_name");
					int seihin_genka = rs.getInt("seihin_genka");
					int seihin_teika = rs.getInt("seihin_teika");
					MSTSEIHIN l = new MSTSEIHIN(seihin_code, seihin_name, seihin_genka, seihin_teika);
					
			
					l.setSeihin_code(rs.getString("seihin_code"));
					l.setSeihin_name(rs.getString("seihin_name"));
					l.setSeihin_genka(rs.getInt("seihin_genka"));
					l.setSeihin_teika(rs.getInt("seihin_teika"));
					
					list.add(l);
				}
			} catch (NamingException | SQLException e) {

				e.printStackTrace();
			}finally {
				this.disconnect();
			}

			return list;
		}
		
		
		
		
		
		public void insertOne(MSTSEIHIN mstseihin) {
			try {
				this.connect();
				ps=db.prepareStatement("INSERT INTO mst_seihin(seihin_code,seihin_name,seihin_genka,seihin_teika) VALUES(?,?,?,?)");
				ps.setString(1,mstseihin.getSeihin_code());
				ps.setString(2,mstseihin.getSeihin_name());
				ps.setInt(3,mstseihin.getSeihin_genka());
				ps.setInt(4,mstseihin.getSeihin_teika());
				
				ps.executeUpdate();
			} catch (NamingException | SQLException e) {
				e.printStackTrace();
			}finally {
				this.disconnect();
			}
		}
		
		
		
		
		public MSTSEIHIN findOne(String s_seihin_code) {
			MSTSEIHIN mstseihin1=null;
			try {
				this.connect();
				ps=db.prepareStatement("SELECT * FROM MST_SEIHIN WHERE seihin_code=?");
				ps.setString(1, s_seihin_code);
				rs=ps.executeQuery();
				if(rs.next()) {
					String Seihin_code=rs.getString("seihin_code");
					String Seihin_name=rs.getString("seihin_name");				
					int seihin_genka = rs.getInt("seihin_genka");
					int seihin_teika = rs.getInt("seihin_teika");
					
					mstseihin1=new MSTSEIHIN(Seihin_code,Seihin_name,seihin_genka,seihin_teika);
					
					mstseihin1.setSeihin_code(rs.getString("seihin_code"));
					mstseihin1.setSeihin_name(rs.getString("seihin_name"));
					mstseihin1.setSeihin_genka(rs.getInt("seihin_genka"));
					mstseihin1.setSeihin_teika(rs.getInt("seihin_teika"));
					
					
					
						
					
				}
			} catch (NamingException | SQLException e) {
				e.printStackTrace();
			}finally {
				this.disconnect();
			}

			return mstseihin1;
		}
		
		
		
		
		public void updateOne(MSTSEIHIN mstseihin) {
			try {
				this.connect();
				ps=db.prepareStatement("UPDATE MST_SEIHIN SET seihin_code=?,seihin_name=?,seihin_genka=?,seihin_teika=? WHERE seihin_code=?");
				
				
				ps.setString(1,mstseihin.getSeihin_code());
				ps.setString(2,mstseihin.getSeihin_name());
				ps.setInt(3,mstseihin.getSeihin_genka());
				ps.setInt(4,mstseihin.getSeihin_teika());
				ps.setString(5,mstseihin.getSeihin_code());
				
				ps.executeUpdate();
			} catch (NamingException | SQLException e) {
				e.printStackTrace();
			}finally {
				this.disconnect();
			}
		}
		
		
		
		
		
		public void deleteOne(String seihin_code) {
			try {
				this.connect();
				ps=db.prepareStatement("DELETE FROM MST_SEIHIN WHERE seihin_code=?");
				ps.setString(1, seihin_code);
				ps.executeUpdate();
			} catch (NamingException | SQLException e) {
				e.printStackTrace();
			}finally {
				this.disconnect();
			}
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		
//		public void searchmstseihin(String seihin_name) {
//			try {
//				this.connect();
//				ps=db.prepareStatement("WHERE FROM MST_SEIHIN WHERE seihin_name=?");
//				ps.setString(1, seihin_name);
//				ps.executeUpdate();
//			} catch (NamingException | SQLException e) {
//				e.printStackTrace();
//			}finally {
//				this.disconnect();
//			}
//		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		public List<MSTSEIHIN> searchAll(String seihin_name2,String seihin_code2) {
			List<MSTSEIHIN> list = new ArrayList<>();
			try {
			
				this.connect();
				ps = db.prepareStatement("SELECT * FROM MST_SEIHIN WHERE seihin_name LIKE ? AND seihin_code LIKE ?");
				
				
				ps.setString(1, "%"+seihin_name2+"%");
				ps.setString(2, "%"+seihin_code2+"%");
				rs = ps.executeQuery();
				while (rs.next()) {
					String seihin_code = rs.getString("seihin_code");
					String seihin_name = rs.getString("seihin_name");
					int seihin_genka = rs.getInt("seihin_genka");
					int seihin_teika = rs.getInt("seihin_teika");
					
					
					MSTSEIHIN l = new MSTSEIHIN(seihin_code, seihin_name, seihin_genka, seihin_teika);
					
			
					l.setSeihin_code(rs.getString("seihin_code"));
					l.setSeihin_name(rs.getString("seihin_name"));
					l.setSeihin_genka(rs.getInt("seihin_genka"));
					l.setSeihin_teika(rs.getInt("seihin_teika"));
					
					list.add(l);
				}
			} catch (NamingException | SQLException e) {

				e.printStackTrace();
			}finally {
				this.disconnect();
			}

			return list;
		}
		
		
		
		
		
		
		
		public List<MSTSEIHIN> listAll() {
			List<MSTSEIHIN> list = new ArrayList<>();
			try {
				this.connect();
				ps = db.prepareStatement("SELECT * FROM MST_SEIHIN");
				rs = ps.executeQuery();
				while (rs.next()) {
					String seihin_code = rs.getString("seihin_code");
					String seihin_name = rs.getString("seihin_name");
					int seihin_genka = rs.getInt("seihin_genka");
					int seihin_teika = rs.getInt("seihin_teika");
					MSTSEIHIN l = new MSTSEIHIN(seihin_code, seihin_name, seihin_genka, seihin_teika);
					
			
					l.setSeihin_code(rs.getString("seihin_code"));
					l.setSeihin_name(rs.getString("seihin_name"));
					l.setSeihin_genka(rs.getInt("seihin_genka"));
					l.setSeihin_teika(rs.getInt("seihin_teika"));
					
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
