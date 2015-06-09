package com.nankai.exchange.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nankai.exchange.dao.IMalesDao;
import com.nankai.exchange.db.ConnectionManager;
import com.nankai.exchange.db.DBUtils;
import com.nankai.exchange.db.TransactionManager;
import com.nankai.exchange.po.Males;

public class MalesDaoImpl implements IMalesDao {
	//锟斤拷锟斤拷一锟斤拷锟斤拷菘锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷一锟斤拷锟斤拷菘锟斤拷锟斤拷锟斤拷锟斤拷
			private ConnectionManager connectionManager;
			private DBUtils dbUtils;
			
			
			//锟睫参癸拷锟斤拷
			public MalesDaoImpl() {
				super();
				// TODO Auto-generated constructor stub
				this.connectionManager=new ConnectionManager();
				this.dbUtils=new DBUtils();
			}	
	@Override
	public int insert(Males males) {
		// TODO Auto-generated method stub
		Connection  conn = this.connectionManager.openConnection();
		//锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
		TransactionManager.conn = conn;
		TransactionManager.beginTransaction();
		
		//锟斤拷锟斤拷锟斤拷锟�

		//Date posttime=males.getPosttime();
		String maletype =males.getMaletype();
		String malesize =males.getMalesize();
		int malestate =males.getMalestate();
		String malemark = males.getMalemark();
		String maleresource =males.getMaleresource();
		int uid=males.getUid();
		
		
	
		//锟斤拷锟斤拷锟接Ｑｏ拷锟斤拷锟斤拷模锟斤拷
		String strSQL = "insert into males values(null,now(),?,?,?,?,?,?)";
		Object[] params = new Object[]{maletype,malesize,malestate,malemark,maleresource,uid};
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
	public List<Males> selectAll() {
		// TODO Auto-generated method stub
		List<Males> lstMales=new ArrayList<Males>();
		//锟斤拷锟接讹拷锟斤拷
		Connection conn=connectionManager.openConnection();
		//SQL锟斤拷锟�
		String strSQL= "select * from males order by maleid";
		
		ResultSet resultSet=this.dbUtils.execQuery(conn, strSQL, new Object[]{});
		//锟斤拷锟截讹拷锟襟，凤拷装
		try {
			while(resultSet.next()){
				
				Males males=new Males();
				males.setMaleid(resultSet.getInt(1));
				males.setPosttime(resultSet.getDate(2));
				males.setMaletype(resultSet.getString(3));
				males.setMalesize(resultSet.getString(4));
				males.setMalestate(resultSet.getInt(5));
				males.setMalemark(resultSet.getString(6));
				males.setMaleresource(resultSet.getString(7));
				males.setUid(resultSet.getInt(8));
				
				
				lstMales.add(males);
				
			}
				return lstMales;
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			this.connectionManager.closeConnection(conn);//锟截憋拷锟斤拷锟斤拷
		}
	
		
		
	}


	@Override
	public int deleteById(int maleid) {
		// TODO Auto-generated method stub
		//锟斤拷锟斤拷锟斤拷锟斤拷
        Connection conn=connectionManager.openConnection();
		//锟斤拷锟斤拷锟斤拷锟斤拷
		TransactionManager.conn=conn;
		TransactionManager.beginTransaction();
		//锟斤拷锟斤拷SQL锟斤拷锟�
		String strSQL="delete from males where maleid=?";
		
		Object[] params=new Object[]{maleid};
		
		int affectRows=this.dbUtils.execOthers(conn, strSQL, params);
		
		if(affectRows>0){
			TransactionManager.commit();//锟结交
		}else{
			TransactionManager.rollback();//锟截癸拷
		} 
					
		return affectRows;
		
	}

	@Override
	public Males selectById(int maleid) {
		// TODO Auto-generated method stub
		Connection conn=connectionManager.openConnection();
		//锟斤拷锟斤拷锟斤拷锟�
		String strSQL= "select * from males where maleid=?";
		
		Object[] params=new Object[]{maleid};
		
		ResultSet resultSet=this.dbUtils.execQuery(conn, strSQL, params);
		
	//锟斤拷装锟斤拷锟斤拷
		try {
			if(resultSet.next()){
				
				Males males=new Males();
				males.setMaleid(resultSet.getInt(1));
				males.setPosttime(resultSet.getDate(2));
				males.setMaletype(resultSet.getString(3));
				males.setMalesize(resultSet.getString(4));
				males.setMalestate(resultSet.getInt(5));
				males.setMalemark(resultSet.getString(6));
				males.setMaleresource(resultSet.getString(7));
				males.setUid(resultSet.getInt(8));
				
				return males;
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
	public int update(Males males) {
		// TODO Auto-generated method stub
		//锟斤拷锟斤拷锟斤拷锟斤拷
		Connection  conn = this.connectionManager.openConnection();
		//锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
		TransactionManager.conn = conn;
		TransactionManager.beginTransaction();
		//锟斤拷锟斤拷锟斤拷锟�
		int maleid = males.getMaleid();
		Date posttime=males.getPosttime();
		String maletype =males.getMaletype();
		String malesize =males.getMalesize();
		int malestate =males.getMalestate();
		String malemark = males.getMalemark();
		String maleresource =males.getMaleresource();
		int uid=males.getUid();
	
		//锟斤拷锟斤拷锟接Ｑｏ拷锟斤拷锟斤拷模锟斤拷
		String strSQL = "update males set posttime=?,maletype=?,malesize=?,malestate=?,malemark=?,maleresource=?,uid=? where maleid=?";
		Object[] params = new Object[]{posttime,maletype,malesize,malestate,malemark,maleresource,uid,maleid};
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
	public List<Males> selectByName(String maletype) {
		// TODO Auto-generated method stub
		List<Males> lstMales = new ArrayList<Males>();
		// 锟斤拷锟接讹拷锟斤拷
		Connection conn = connectionManager.openConnection();
		// SQL锟斤拷锟�
		String strSQL = "select * from males where maletype like '%" + maletype + "%'";

		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,
				new Object[] {});
		// 锟斤拷锟截讹拷锟襟，凤拷装
		try {
			while (resultSet.next()) {

				Males males = new Males();
				males.setMaleid(resultSet.getInt(1));
				males.setPosttime(resultSet.getDate(2));
				males.setMaletype(resultSet.getString(3));
				males.setMalesize(resultSet.getString(4));
				males.setMalestate(resultSet.getInt(5));
				males.setMalemark(resultSet.getString(6));
				males.setMaleresource(resultSet.getString(7));
				males.setUid(resultSet.getInt(8));

				lstMales.add(males);

			}
			return lstMales;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);// 锟截憋拷锟斤拷锟斤拷
		}

	}


}
