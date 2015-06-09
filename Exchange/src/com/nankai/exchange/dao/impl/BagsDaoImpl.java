package com.nankai.exchange.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nankai.exchange.dao.IBagsDao;
import com.nankai.exchange.db.ConnectionManager;
import com.nankai.exchange.db.DBUtils;
import com.nankai.exchange.db.TransactionManager;
import com.nankai.exchange.po.Bags;


public class BagsDaoImpl implements IBagsDao {

	private ConnectionManager connectionManager;
	private DBUtils dbUtils;
	
	
	
	public BagsDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager=new ConnectionManager();
		this.dbUtils=new DBUtils();
	}

	@Override
	public int insert(Bags bags) {
		// TODO Auto-generated method stub
		Connection  conn = this.connectionManager.openConnection();
		//锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
		TransactionManager.conn = conn;
		TransactionManager.beginTransaction();
		
		//锟斤拷锟斤拷锟斤拷锟�
		//Date posttime=bags.getPosttime();
		String bagbrand =bags.getBagbrand();
		String bagtype = bags.getBagtype();
		int bagstate = bags.getBagstate();
		String bagmark = bags.getBagmark();
		String bagresource =bags.getBagresource();
		int uid=bags.getUid();
		
	
		//锟斤拷锟斤拷锟接Ｑｏ拷锟斤拷锟斤拷模锟斤拷
		String strSQL = "insert into bags values(null,now(),?,?,?,?,?,?)";
		Object[] params = new Object[]{bagbrand,bagtype,bagstate,bagmark,bagresource,uid};
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
	public List<Bags> selectAll() {
		// TODO Auto-generated method stub
        List<Bags> lstBags=new ArrayList<Bags>();
		
		Connection conn=connectionManager.openConnection();
		
		String strSQL= "select * from bags order by bagid";
		
		ResultSet resultSet=this.dbUtils.execQuery(conn, strSQL, new Object[]{});
		
		try {
			while(resultSet.next()){
				
				Bags bags=new Bags();
				bags.setBagid(resultSet.getInt(1));
				bags.setPosttime(resultSet.getDate(2));
				bags.setBagbrand(resultSet.getString(3));
				bags.setBagtype(resultSet.getString(4));
				bags.setBagstate(resultSet.getInt(5));
				bags.setBagmark(resultSet.getString(6));
				bags.setBagresource(resultSet.getString(7));
				bags.setUid(resultSet.getInt(8));
				
				lstBags.add(bags);
				
			}
				return lstBags;
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			this.connectionManager.closeConnection(conn);
		}
	
		
		
	}

	@Override
	public int deleteById(int bagid) {
		// TODO Auto-generated method stub
        Connection conn=connectionManager.openConnection();
		
		TransactionManager.conn=conn;
		TransactionManager.beginTransaction();
		
		String strSQL="delete from bags where bagid=?";
		
		Object[] params=new Object[]{bagid};
		
		int affectRows=this.dbUtils.execOthers(conn, strSQL, params);
		
		if(affectRows>0){
			TransactionManager.commit();
		}else{
			TransactionManager.rollback();
		} 
					
		return affectRows;
		
	}

	@Override
	public Bags selectById(int bagid) {
		// TODO Auto-generated method stub
        Connection conn=connectionManager.openConnection();
		
		String strSQL= "select * from bags where bagid=?";
		
		Object[] params=new Object[]{bagid};
		
		ResultSet resultSet=this.dbUtils.execQuery(conn, strSQL, params);
		
		try {
			if(resultSet.next()){
				
				Bags bags=new Bags();
				bags.setBagid(resultSet.getInt(1));
				bags.setPosttime(resultSet.getDate(2));
				bags.setBagbrand(resultSet.getString(3));
				bags.setBagtype(resultSet.getString(4));
				bags.setBagstate(resultSet.getInt(5));
				bags.setBagmark(resultSet.getString(6));
				bags.setBagresource(resultSet.getString(7));
				bags.setUid(resultSet.getInt(8));
				
				
				return bags;
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
	public int update(Bags bags) {
		// TODO Auto-generated method stub
		Connection  conn = this.connectionManager.openConnection();
		//锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
		TransactionManager.conn = conn;
		TransactionManager.beginTransaction();
		
		int bagid=bags.getBagid();
		Date posttime=bags.getPosttime();
		String bagbrand =bags.getBagbrand();
		String bagtype = bags.getBagtype();
		int bagstate = bags.getBagstate();
		String bagmark = bags.getBagmark();
		String bagresource =bags.getBagresource();
		int uid=bags.getUid();
		
	
	
		//锟斤拷锟斤拷锟接Ｑｏ拷锟斤拷锟斤拷模锟斤拷
		String strSQL = "update bags set posttime=?, bagbrand=?,bagtype=?,bagstate=?,bagmark=?,bagresource=?,uid=? where bagid=?";
		Object[] params = new Object[]{posttime,bagbrand,bagtype,bagstate,bagmark,bagresource,uid,bagid};
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
	public List<Bags> selectByName(String bagbrand) {
		// TODO Auto-generated method stub
		List<Bags> lstBags = new ArrayList<Bags>();

		Connection conn = connectionManager.openConnection();

		String strSQL = "select * from bags where bagbrand like '%" + bagbrand + "%'";

		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,
				new Object[] {});

		try {
			while (resultSet.next()) {

				Bags bags = new Bags();
				bags.setBagid(resultSet.getInt(1));
				bags.setPosttime(resultSet.getDate(2));
				bags.setBagbrand(resultSet.getString(3));
				bags.setBagtype(resultSet.getString(4));
				bags.setBagstate(resultSet.getInt(5));
				bags.setBagmark(resultSet.getString(6));
				bags.setBagresource(resultSet.getString(7));
				bags.setUid(resultSet.getInt(8));

				lstBags.add(bags);

			}
			return lstBags;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}

	}


}
