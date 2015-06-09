package com.nankai.exchange.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nankai.exchange.dao.IVirtualsDao;
import com.nankai.exchange.db.ConnectionManager;
import com.nankai.exchange.db.DBUtils;
import com.nankai.exchange.db.TransactionManager;
import com.nankai.exchange.po.Virtuals;

public class VirtualsDaoImpl implements IVirtualsDao {

	private ConnectionManager connectionManager;
	private DBUtils dbUtils;
	
	public VirtualsDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager=new ConnectionManager();
		this.dbUtils=new DBUtils();
	}
	@Override
	public int insert(Virtuals virtuals) {
		// TODO Auto-generated method stub
		Connection  conn = this.connectionManager.openConnection();
		//锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
		TransactionManager.conn = conn;
		TransactionManager.beginTransaction();
		
		//锟斤拷锟斤拷锟斤拷锟�
		//int virtualid=virtuals.getVirtualid();
		String virtualname=virtuals.getVirtualname();
		int virtualstate=virtuals.getVirtualstate();
		String virtualmark=virtuals.getVirtualmark();
		//Date posttime=virtuals.getPosttime();
		String virtualresource=virtuals.getVirtualresource();
		int uid=virtuals.getUid();
		
		
	
		//锟斤拷锟斤拷锟接Ｑｏ拷锟斤拷锟斤拷模锟斤拷
		String strSQL = "insert into virtuals values(null,?,?,?,now(),?,?)";
		Object[] params = new Object[]{virtualname,virtualstate,virtualmark,virtualresource,uid};
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
	public List<Virtuals> selectAll() {
		// TODO Auto-generated method stub
        List<Virtuals> lstVirtuals=new ArrayList<Virtuals>();
		
		Connection conn=connectionManager.openConnection();
		
		String strSQL= "select * from virtuals order by virtualid";
		
		ResultSet resultSet=this.dbUtils.execQuery(conn, strSQL, new Object[]{});
		
		try {
			while(resultSet.next()){
				
				Virtuals virtuals=new Virtuals();
				virtuals.setVirtualid(resultSet.getInt(1));
				virtuals.setVirtualname(resultSet.getString(2));
				virtuals.setVirtualstate(resultSet.getInt(3));
				virtuals.setVirtualmark(resultSet.getString(4));
				virtuals.setPosttime(resultSet.getDate(5));
				virtuals.setVirtualresource(resultSet.getString(6));
				virtuals.setUid(resultSet.getInt(7));
	
				
				lstVirtuals.add(virtuals);
				
			}
				return lstVirtuals;
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			this.connectionManager.closeConnection(conn);
		}
	
		
		
	}


	@Override
	public int deleteById(int virtualid) {
		// TODO Auto-generated method stub
		  Connection conn=connectionManager.openConnection();
			
			TransactionManager.conn=conn;
			TransactionManager.beginTransaction();
			
			String strSQL="delete from virtuals where virtualid=?";
			
			Object[] params=new Object[]{virtualid};
			
			int affectRows=this.dbUtils.execOthers(conn, strSQL, params);
			
			if(affectRows>0){
				TransactionManager.commit();
			}else{
				TransactionManager.rollback();
			} 
						
			return affectRows;
			
		}


	@Override
	public Virtuals selectById(int virtualid) {
		// TODO Auto-generated method stub
		 Connection conn=connectionManager.openConnection();
			
			String strSQL= "select * from virtuals where virtualid=?";
			
			Object[] params=new Object[]{virtualid};
			
			ResultSet resultSet=this.dbUtils.execQuery(conn, strSQL, params);
			
			try {
				if(resultSet.next()){
					
					Virtuals virtuals=new Virtuals();
					virtuals.setVirtualid(resultSet.getInt(1));
					virtuals.setVirtualname(resultSet.getString(2));
					virtuals.setVirtualstate(resultSet.getInt(3));
					virtuals.setVirtualmark(resultSet.getString(4));
					virtuals.setPosttime(resultSet.getDate(5));
					virtuals.setVirtualresource(resultSet.getString(6));
					virtuals.setUid(resultSet.getInt(7));
		
					
					
					return virtuals;
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
	public int update(Virtuals virtuals) {
		// TODO Auto-generated method stub
		Connection  conn = this.connectionManager.openConnection();
		//锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
		TransactionManager.conn = conn;
		TransactionManager.beginTransaction();
		
		int virtualid=virtuals.getVirtualid();
		String virtualname=virtuals.getVirtualname();
		int virtualstate=virtuals.getVirtualstate();
		String virtualmark=virtuals.getVirtualmark();
		Date posttime=virtuals.getPosttime();
		String virtualresource=virtuals.getVirtualresource();
		int uid=virtuals.getUid();
		
		//锟斤拷锟斤拷锟接Ｑｏ拷锟斤拷锟斤拷模锟斤拷
		String strSQL = "update virtuals set virtualname=?, virtualstate=?,virtualmark=?,posttime=?,virtualresource=?,uid=? where virtualid=?";
		Object[] params = new Object[]{virtualname,virtualstate,virtualmark,posttime,virtualresource,uid,virtualid};
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
	public List<Virtuals> selectByName(String virtualname) {
		// TODO Auto-generated method stub
		List<Virtuals> lstVirtuals = new ArrayList<Virtuals>();

		Connection conn = connectionManager.openConnection();

		String strSQL = "select * from virtuals where virtualname like '%" + virtualname + "%'";

		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,
				new Object[] {});

		try {
			while (resultSet.next()) {

				Virtuals virtuals = new Virtuals();
				virtuals.setVirtualid(resultSet.getInt(1));
				virtuals.setVirtualname(resultSet.getString(2));
				virtuals.setVirtualstate(resultSet.getInt(3));
				virtuals.setVirtualmark(resultSet.getString(4));
				virtuals.setPosttime(resultSet.getDate(5));
				virtuals.setVirtualresource(resultSet.getString(6));
				virtuals.setUid(resultSet.getInt(7));

				lstVirtuals.add(virtuals);

			}
			return lstVirtuals;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}

	}

}
