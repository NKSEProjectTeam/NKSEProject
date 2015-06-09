package com.nankai.exchange.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nankai.exchange.dao.IOthersDao;
import com.nankai.exchange.db.ConnectionManager;
import com.nankai.exchange.db.DBUtils;
import com.nankai.exchange.db.TransactionManager;
import com.nankai.exchange.po.Others;

public class OthersDaoImpl implements IOthersDao {
	//锟斤拷锟斤拷一锟斤拷锟斤拷菘锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷一锟斤拷锟斤拷菘锟斤拷锟斤拷锟斤拷锟斤拷
	private ConnectionManager connectionManager;
	private DBUtils dbUtils;
	
	
	//锟睫参癸拷锟斤拷
	public OthersDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager=new ConnectionManager();
		this.dbUtils=new DBUtils();
	}	
	@Override
	public int insert(Others others) {
		// TODO Auto-generated method stub
		Connection  conn = this.connectionManager.openConnection();
		//锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
		TransactionManager.conn = conn;
		TransactionManager.beginTransaction();
		
		//锟斤拷锟斤拷锟斤拷锟�

		//Date posttime=others.getPosttime();
		String othersname =others.getOthersname();
		String othertype =others.getOthertype();
		int othersstate =others.getOthersstate();
		String othermark = others.getOthermark();
		String otherresource =others.getOtherresource();
		int uid=others.getUid();
		
		
	
		//锟斤拷锟斤拷锟接Ｑｏ拷锟斤拷锟斤拷模锟斤拷
		String strSQL = "insert into others values(null,now(),?,?,?,?,?,?)";
		Object[] params = new Object[]{othersname,othertype,othersstate,othermark,otherresource,uid};
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
	public List<Others> selectAll() {
		// TODO Auto-generated method stub
		List<Others> lstOthers=new ArrayList<Others>();
		//锟斤拷锟接讹拷锟斤拷
		Connection conn=connectionManager.openConnection();
		//SQL锟斤拷锟�
		String strSQL= "select * from others order by otherid";
		
		ResultSet resultSet=this.dbUtils.execQuery(conn, strSQL, new Object[]{});
		//锟斤拷锟截讹拷锟襟，凤拷装
		try {
			while(resultSet.next()){
				
				Others others=new Others();
				others.setOtherid(resultSet.getInt(1));
				others.setPosttime(resultSet.getDate(2));
				others.setOthersname(resultSet.getString(3));
				others.setOthertype(resultSet.getString(4));
				others.setOthersstate(resultSet.getInt(5));
				others.setOthermark(resultSet.getString(6));
				others.setOtherresource(resultSet.getString(7));
				others.setUid(resultSet.getInt(8));
				
				
				lstOthers.add(others);
				
			}
				return lstOthers;
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			this.connectionManager.closeConnection(conn);//锟截憋拷锟斤拷锟斤拷
		}
	
		
		
	}
	@Override
	public int deleteById(int otherid) {
		// TODO Auto-generated method stub
		//锟斤拷锟斤拷锟斤拷锟斤拷
        Connection conn=connectionManager.openConnection();
		//锟斤拷锟斤拷锟斤拷锟斤拷
		TransactionManager.conn=conn;
		TransactionManager.beginTransaction();
		//锟斤拷锟斤拷SQL锟斤拷锟�
		String strSQL="delete from others where otherid=?";
		
		Object[] params=new Object[]{otherid};
		
		int affectRows=this.dbUtils.execOthers(conn, strSQL, params);
		
		if(affectRows>0){
			TransactionManager.commit();//锟结交
		}else{
			TransactionManager.rollback();//锟截癸拷
		} 
					
		return affectRows;
		
	}

	@Override
	public Others selectById(int otherid) {
		// TODO Auto-generated method stub
		Connection conn=connectionManager.openConnection();
		//锟斤拷锟斤拷锟斤拷锟�
		String strSQL= "select * from others where otherid=?";
		
		Object[] params=new Object[]{otherid};
		
		ResultSet resultSet=this.dbUtils.execQuery(conn, strSQL, params);
		
	//锟斤拷装锟斤拷锟斤拷
		try {
			if(resultSet.next()){
				
				Others others=new Others();
				others.setOtherid(resultSet.getInt(1));
				others.setPosttime(resultSet.getDate(2));
				others.setOthersname(resultSet.getString(3));
				others.setOthertype(resultSet.getString(4));
				others.setOthersstate(resultSet.getInt(5));
				others.setOthermark(resultSet.getString(6));
				others.setOtherresource(resultSet.getString(7));
				others.setUid(resultSet.getInt(8));
				
				
				return others;
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
	public int update(Others others) {
		// TODO Auto-generated method stub
		//锟斤拷锟斤拷锟斤拷锟斤拷
				Connection  conn = this.connectionManager.openConnection();
				//锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
				TransactionManager.conn = conn;
				TransactionManager.beginTransaction();
				//锟斤拷锟斤拷锟斤拷锟�
				int otherid = others.getOtherid();
				Date posttime=others.getPosttime();
				String othersname =others.getOthersname();
				String othertype =others.getOthertype();
				int othersstate =others.getOthersstate();
				String othermark = others.getOthermark();
				String otherresource =others.getOtherresource();
				int uid=others.getUid();
				
				
			
				//锟斤拷锟斤拷锟接Ｑｏ拷锟斤拷锟斤拷模锟斤拷
				String strSQL = "update others set posttime=?,othersname=?,othertype=?,othersstate=?,othermark=?,otherresource=?,uid=? where otherid=?";
				Object[] params = new Object[]{posttime,othersname,othertype,othersstate,othermark,otherresource,uid,otherid};
				
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
	public List<Others> selectByName(String othersname) {
		// TODO Auto-generated method stub
		List<Others> lstOthers=new ArrayList<Others>();
		//锟斤拷锟接讹拷锟斤拷
		Connection conn=connectionManager.openConnection();
		//SQL锟斤拷锟�
		String strSQL= "select * from others where othersname like '%" + othersname + "%'";
		
		ResultSet resultSet=this.dbUtils.execQuery(conn, strSQL, new Object[]{});
		//锟斤拷锟截讹拷锟襟，凤拷装
		try {
			while(resultSet.next()){
				
				Others others=new Others();
				others.setOtherid(resultSet.getInt(1));
				others.setPosttime(resultSet.getDate(2));
				others.setOthersname(resultSet.getString(3));
				others.setOthertype(resultSet.getString(4));
				others.setOthersstate(resultSet.getInt(5));
				others.setOthermark(resultSet.getString(6));
				others.setOtherresource(resultSet.getString(7));
				others.setUid(resultSet.getInt(8));
				
				
				lstOthers.add(others);
				
			}
				return lstOthers;
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			this.connectionManager.closeConnection(conn);//锟截憋拷锟斤拷锟斤拷
		}
	
		
	}


}
