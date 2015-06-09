package com.nankai.exchange.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nankai.exchange.dao.ISptastsDao;
import com.nankai.exchange.db.ConnectionManager;
import com.nankai.exchange.db.DBUtils;
import com.nankai.exchange.db.TransactionManager;
import com.nankai.exchange.po.Sptasts;

public class SptastsDaoImpl implements ISptastsDao {
	//锟斤拷锟斤拷一锟斤拷锟斤拷菘锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷一锟斤拷锟斤拷菘锟斤拷锟斤拷锟斤拷锟斤拷
	private ConnectionManager connectionManager;
	private DBUtils dbUtils;
	
	
	//锟睫参癸拷锟斤拷
	public SptastsDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager=new ConnectionManager();
		this.dbUtils=new DBUtils();
	}	
	@Override
	public int insert(Sptasts sptasts) {
		// TODO Auto-generated method stub
		Connection  conn = this.connectionManager.openConnection();
		//锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
		TransactionManager.conn = conn;
		TransactionManager.beginTransaction();
		
		//锟斤拷锟斤拷锟斤拷锟�

		//Date posttime=sptasts.getPosttime();
		String saname =sptasts.getSaname();
		String satype =sptasts.getSatype();
		int sastate =sptasts.getSastate();
		String samark = sptasts.getSamark();
		String saresource =sptasts.getSaresource();
		int uid=sptasts.getUid();
		
		
		
	
		//锟斤拷锟斤拷锟接Ｑｏ拷锟斤拷锟斤拷模锟斤拷
		String strSQL = "insert into sptasts values(null,now(),?,?,?,?,?,?)";
		Object[] params = new Object[]{saname,satype,sastate,samark,saresource,uid};
		// 锟斤拷锟斤拷dbutils锟斤拷锟襟，诧拷锟斤拷锟斤拷execothers锟斤拷锟斤拷实锟斤拷锟斤拷菘锟斤拷锟斤拷硬锟斤拷锟斤拷锟�
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		//锟斤拷锟斤拷锟揭伙拷锟斤拷慕锟斤拷锟斤拷锟斤拷锟接︼拷锟斤拷锟斤拷锟斤拷锟�
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
	public List<Sptasts> selectAll() {
		// TODO Auto-generated method stub
		//锟斤拷锟斤拷一锟斤拷List锟斤拷锟斤拷
        List<Sptasts> lstSptasts=new ArrayList<Sptasts>();
		//锟斤拷锟接讹拷锟斤拷
		Connection conn=connectionManager.openConnection();
		//SQL锟斤拷锟�
		String strSQL= "select * from sptasts order by said";
		
		ResultSet resultSet=this.dbUtils.execQuery(conn, strSQL, new Object[]{});
		//锟斤拷锟截讹拷锟襟，凤拷装
		try {
			while(resultSet.next()){
				
				Sptasts sptasts=new Sptasts();
				sptasts.setSaid(resultSet.getInt(1));
				sptasts.setPosttime(resultSet.getDate(2));
				sptasts.setSaname(resultSet.getString(3));

				sptasts.setSatype(resultSet.getString(4));
				sptasts.setSastate(resultSet.getInt(5));
				sptasts.setSamark(resultSet.getString(6));				
				sptasts.setSaresource(resultSet.getString(7));
				sptasts.setUid(resultSet.getInt(8));
				
				lstSptasts.add(sptasts);
				
			}
				return lstSptasts;
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			this.connectionManager.closeConnection(conn);//锟截憋拷锟斤拷锟斤拷
		}
	
		
		
	}
	@Override
	public int deleteById(int said) {
		// TODO Auto-generated method stub
		Connection conn=connectionManager.openConnection();
		//锟斤拷锟斤拷锟斤拷锟斤拷
		TransactionManager.conn=conn;
		TransactionManager.beginTransaction();
		//锟斤拷锟斤拷SQL锟斤拷锟�
		String strSQL="delete from sptasts where said=?";
		
		Object[] params=new Object[]{said};
		
		int affectRows=this.dbUtils.execOthers(conn, strSQL, params);
		
		if(affectRows>0){
			TransactionManager.commit();//锟结交
		}else{
			TransactionManager.rollback();//锟截癸拷
		} 
					
		return affectRows;
		
	}


	@Override
	public Sptasts selectById(int said) {
		// TODO Auto-generated method stub
		//锟斤拷锟斤拷锟斤拷锟斤拷
	    Connection conn=connectionManager.openConnection();
		//锟斤拷锟斤拷锟斤拷锟�
		String strSQL= "select * from sptasts where said=?";
		
		Object[] params=new Object[]{said};
		
		ResultSet resultSet=this.dbUtils.execQuery(conn, strSQL, params);
		
	//锟斤拷装锟斤拷锟斤拷
		try {
			if(resultSet.next()){
				

				Sptasts sptasts=new Sptasts();
				sptasts.setSaid(resultSet.getInt(1));
				sptasts.setPosttime(resultSet.getDate(2));
				sptasts.setSaname(resultSet.getString(3));

				sptasts.setSatype(resultSet.getString(4));
				sptasts.setSastate(resultSet.getInt(5));
				sptasts.setSamark(resultSet.getString(6));				
				sptasts.setSaresource(resultSet.getString(7));
				sptasts.setUid(resultSet.getInt(8));
				
				
				return sptasts;
				
			}else{
				return null;
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			this.connectionManager.closeConnection(conn);//锟截憋拷锟斤拷锟斤拷
		}
	
		
		
	}

	@Override
	public int update(Sptasts sptasts) {
		// TODO Auto-generated method stub
		//锟斤拷锟斤拷锟斤拷锟斤拷
		Connection  conn = this.connectionManager.openConnection();
		//锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
		TransactionManager.conn = conn;
		TransactionManager.beginTransaction();
		//锟斤拷锟斤拷锟斤拷锟�
		int said =sptasts.getSaid();
		Date posttime=sptasts.getPosttime();
		String saname =sptasts.getSaname();
		String satype =sptasts.getSatype();
		int sastate =sptasts.getSastate();
		String samark = sptasts.getSamark();
		String saresource =sptasts.getSaresource();
		int uid=sptasts.getUid();
	
	
		//锟斤拷锟斤拷锟接Ｑｏ拷锟斤拷锟斤拷模锟斤拷
		String strSQL = "update sptasts set posttime=?, saname=?,satype=?,sastate=?,samark=?,saresource=?,uid=? where said=?";
		Object[] params = new Object[]{posttime,saname,satype,sastate,samark,saresource,uid,said};
		// 锟斤拷锟斤拷dbutils锟斤拷锟襟，诧拷锟斤拷锟斤拷execothers锟斤拷锟斤拷实锟斤拷锟斤拷菘锟斤拷锟斤拷硬锟斤拷锟斤拷锟�
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		System.out.println(affectedRows);
		//锟斤拷锟斤拷锟揭伙拷锟斤拷慕锟斤拷锟斤拷锟斤拷锟接︼拷锟斤拷锟斤拷锟斤拷锟�
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
	public List<Sptasts> selectByName(String saname) {
		// TODO Auto-generated method stub
		// 锟斤拷锟斤拷一锟斤拷List锟斤拷锟斤拷
		List<Sptasts> lstSptasts = new ArrayList<Sptasts>();
		// 锟斤拷锟接讹拷锟斤拷
		Connection conn = connectionManager.openConnection();
		// SQL锟斤拷锟�
		String strSQL = "select * from sptasts where saname like '%" + saname + "%'";

		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,
				new Object[] {});
		// 锟斤拷锟截讹拷锟襟，凤拷装
		try {
			while (resultSet.next()) {

				Sptasts sptasts = new Sptasts();
				sptasts.setSaid(resultSet.getInt(1));
				sptasts.setPosttime(resultSet.getDate(2));
				sptasts.setSaname(resultSet.getString(3));

				sptasts.setSatype(resultSet.getString(4));
				sptasts.setSastate(resultSet.getInt(5));
				sptasts.setSamark(resultSet.getString(6));
				sptasts.setSaresource(resultSet.getString(7));
				sptasts.setUid(resultSet.getInt(8));

				lstSptasts.add(sptasts);

			}
			return lstSptasts;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);// 锟截憋拷锟斤拷锟斤拷
		}
	}

}
