package com.nankai.exchange.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nankai.exchange.dao.ITextbooksDao;
import com.nankai.exchange.db.ConnectionManager;
import com.nankai.exchange.db.DBUtils;
import com.nankai.exchange.db.TransactionManager;
import com.nankai.exchange.po.Textbooks;

public class TextbooksDaoImpl implements ITextbooksDao {
	private ConnectionManager connectionManager;
	private DBUtils dbUtils;
	
	public TextbooksDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager=new ConnectionManager();
		this.dbUtils=new DBUtils();
	}

	@Override
	public int insert(Textbooks textbooks) {
		// TODO Auto-generated method stub
    	//锟斤拷取一锟斤拷锟斤拷锟捷匡拷锟斤拷锟斤拷锟�
		Connection  conn = this.connectionManager.openConnection();
		//锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
		TransactionManager.conn = conn;
		TransactionManager.beginTransaction();
		
		//锟斤拷锟斤拷锟斤拷锟�
		//Date posttime=textbooks.getPosttime();
		String tbauthor=textbooks.getTbauthor();
	
		String tbmark=textbooks.getTbmark();
		String tbname=textbooks.getTbname();
		String tbpublish=textbooks.getTbpublish();
		String tbresource=textbooks.getTbresource();
		int tbstate=textbooks.getTbstate();
		String tbversion=textbooks.getTbversion();
		int uid=textbooks.getUid();
		
	
		//锟斤拷锟斤拷锟接Ｑｏ拷锟斤拷锟斤拷模锟斤拷
		String strSQL = "insert into textbooks values(null,?,now(),?,?,?,?,?,?,?)";
		Object[] params = new Object[]{uid,tbname,tbauthor,tbpublish,tbversion,tbstate,tbmark,tbresource};
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		//锟斤拷锟斤拷锟斤拷一锟斤拷锟侥斤拷锟斤拷锟斤拷锟斤拷应锟斤拷锟斤拷锟斤拷锟斤拷
		if(affectedRows > 0){
			// 锟结交锟斤拷锟斤拷
			TransactionManager.commit();
		}else{
			// 锟截癸拷锟斤拷锟斤拷
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public List<Textbooks> selectAll() {
		// TODO Auto-generated method stub
				List<Textbooks> lstTextbooks=new ArrayList<Textbooks>();
				
				Connection conn=connectionManager.openConnection();
				
				String strSQL= "select * from textbooks order by tbid";
				
				ResultSet resultSet=this.dbUtils.execQuery(conn, strSQL, new Object[]{});
				
				try {
					while(resultSet.next()){
						Textbooks textbooks=new Textbooks();
					    textbooks.setTbid(resultSet.getInt(1));
					    textbooks.setUid(resultSet.getInt(2));
					    textbooks.setPosttime(resultSet.getDate(3));
						textbooks.setTbname(resultSet.getString(4));
						textbooks.setTbauthor(resultSet.getString(5));
						textbooks.setTbpublish(resultSet.getString(6));
						textbooks.setTbversion(resultSet.getString(7));
						textbooks.setTbstate(resultSet.getInt(8));
						textbooks.setTbmark(resultSet.getString(9));
						textbooks.setTbresource(resultSet.getString(10));
						lstTextbooks.add(textbooks);
						
					}
						return lstTextbooks;
						
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}finally{
					this.connectionManager.closeConnection(conn);
				}
			
	}

	@Override
	public int deleteById(int tbid) {
		// TODO Auto-generated method stub
        Connection conn=connectionManager.openConnection();
		
		TransactionManager.conn=conn;
		TransactionManager.beginTransaction();
		
		String strSQL="delete from textbooks where tbid=?";
		
		Object[] params=new Object[]{tbid};
		
		int affectRows=this.dbUtils.execOthers(conn, strSQL, params);
		
		if(affectRows>0){
			TransactionManager.commit();
		}else{
			TransactionManager.rollback();
		} 
					
		return affectRows;
		
	}

	@Override
	public Textbooks selectById(int tbid) {
		// TODO Auto-generated method stub
Connection conn=connectionManager.openConnection();
		
		String strSQL= "select * from textbooks where tbid=?";
		
		Object[] params=new Object[]{tbid};
		
		ResultSet resultSet=this.dbUtils.execQuery(conn, strSQL, params);
		
		try {
			if(resultSet.next()){
				Textbooks textbooks=new Textbooks();
				 textbooks.setTbid(resultSet.getInt(1));
				    textbooks.setUid(resultSet.getInt(2));
				    textbooks.setPosttime(resultSet.getDate(3));
					textbooks.setTbname(resultSet.getString(4));
					textbooks.setTbauthor(resultSet.getString(5));
					textbooks.setTbpublish(resultSet.getString(6));
					textbooks.setTbversion(resultSet.getString(7));
					textbooks.setTbstate(resultSet.getInt(8));
					textbooks.setTbmark(resultSet.getString(9));
					textbooks.setTbresource(resultSet.getString(10));
				
				
				
				return textbooks;
			}else{
				return null;
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			this.connectionManager.closeConnection(conn);
		}
	
	}

	@Override
	public int update(Textbooks textbooks) {
		// TODO Auto-generated method stub
		 Connection  conn = this.connectionManager.openConnection();
			//锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
			TransactionManager.conn = conn;
			TransactionManager.beginTransaction();
			
			Date posttime=textbooks.getPosttime();
			String tbauthor=textbooks.getTbauthor();
			int tbid=textbooks.getTbid();
			String tbmark=textbooks.getTbmark();
			String tbname=textbooks.getTbname();
			String tbpublish=textbooks.getTbpublish();
			String tbresource=textbooks.getTbresource();
			int tbstate=textbooks.getTbstate();
			String tbversion=textbooks.getTbversion();
			int uid=textbooks.getUid();
			
			
		
		
			//锟斤拷锟斤拷锟接Ｑｏ拷锟斤拷锟斤拷模锟斤拷
			String strSQL = "update textbooks set uid=?, posttime=?,tbname=?,tbauthor=?,tbpublish=?,tbversion=?,tbstate=?,tbmark=?,tbresource=? where tbid=?";
			Object[] params = new Object[]{uid,posttime,tbname,tbauthor,tbpublish,tbversion,tbstate,tbmark,tbresource,tbid};
			// 锟斤拷锟斤拷dbutils锟斤拷锟襟，诧拷锟斤拷锟斤拷execothers锟斤拷锟斤拷实锟斤拷锟斤拷锟捷匡拷锟斤拷锟接诧拷锟斤拷锟斤拷
			int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
			System.out.println(affectedRows);
			//锟斤拷锟斤拷锟斤拷一锟斤拷锟侥斤拷锟斤拷锟斤拷锟斤拷应锟斤拷锟斤拷锟斤拷锟斤拷
			if(affectedRows > 0){
				// 锟结交锟斤拷锟斤拷
				TransactionManager.commit();
			}else{
				// 锟截癸拷锟斤拷锟斤拷
				TransactionManager.rollback();
			}
			return affectedRows;
	}

	@Override
	public List<Textbooks> selectByName(String tbname) {
		// TODO Auto-generated method stub
		List<Textbooks> lstTextbooks = new ArrayList<Textbooks>();

		Connection conn = connectionManager.openConnection();

		String strSQL = "select * from textbooks where tbname like '%" + tbname + "%'";

		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,
				new Object[] {});

		try {
			while (resultSet.next()) {
				Textbooks textbooks = new Textbooks();
				textbooks.setTbid(resultSet.getInt(1));
				textbooks.setUid(resultSet.getInt(2));
				textbooks.setPosttime(resultSet.getDate(3));
				textbooks.setTbname(resultSet.getString(4));
				textbooks.setTbauthor(resultSet.getString(5));
				textbooks.setTbpublish(resultSet.getString(6));
				textbooks.setTbversion(resultSet.getString(7));
				textbooks.setTbstate(resultSet.getInt(8));
				textbooks.setTbmark(resultSet.getString(9));
				textbooks.setTbresource(resultSet.getString(10));
				lstTextbooks.add(textbooks);

			}
			return lstTextbooks;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}

	}

}
