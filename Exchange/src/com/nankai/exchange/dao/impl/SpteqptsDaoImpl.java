package com.nankai.exchange.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nankai.exchange.dao.ISpteqptsDao;
import com.nankai.exchange.db.ConnectionManager;
import com.nankai.exchange.db.DBUtils;
import com.nankai.exchange.db.TransactionManager;
import com.nankai.exchange.po.Spteqpts;

public class SpteqptsDaoImpl implements ISpteqptsDao {

	//锟斤拷锟斤拷一锟斤拷锟斤拷菘锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷一锟斤拷锟斤拷菘锟斤拷锟斤拷锟斤拷锟斤拷
		private ConnectionManager connectionManager;
		private DBUtils dbUtils;
		
		
		//锟睫参癸拷锟斤拷
		public SpteqptsDaoImpl() {
			super();
			// TODO Auto-generated constructor stub
			this.connectionManager=new ConnectionManager();
			this.dbUtils=new DBUtils();
		}	
	@Override
	public int insert(Spteqpts spteqpts) {
		// TODO Auto-generated method stub
		Connection  conn = this.connectionManager.openConnection();
		//锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
		TransactionManager.conn = conn;
		TransactionManager.beginTransaction();
		
		//锟斤拷锟斤拷锟斤拷锟�

		//Date posttime=spteqpts.getPosttime();
		String sename =spteqpts.getSename();
		String setype =spteqpts.getSetype();
		int sestate =spteqpts.getSestate();
		String semark = spteqpts.getSemark();
		String seresource =spteqpts.getSeresource();
		int uid=spteqpts.getUid();
		
		
		
	
		//锟斤拷锟斤拷锟接Ｑｏ拷锟斤拷锟斤拷模锟斤拷
		String strSQL = "insert into spteqpts values(null,now(),?,?,?,?,?,?)";
		Object[] params = new Object[]{sename,setype,sestate,semark,seresource,uid};
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
	public List<Spteqpts> selectAll() {
		// TODO Auto-generated method stub
		//锟斤拷锟斤拷一锟斤拷List锟斤拷锟斤拷
        List<Spteqpts> lstSpteqpts=new ArrayList<Spteqpts>();
		//锟斤拷锟接讹拷锟斤拷
		Connection conn=connectionManager.openConnection();
		//SQL锟斤拷锟�
		String strSQL= "select * from spteqpts order by seid";
		
		ResultSet resultSet=this.dbUtils.execQuery(conn, strSQL, new Object[]{});
		//锟斤拷锟截讹拷锟襟，凤拷装
		try {
			while(resultSet.next()){
				
				Spteqpts spteqpts=new Spteqpts();
				spteqpts.setSeid(resultSet.getInt(1));
				spteqpts.setPosttime(resultSet.getDate(2));
				spteqpts.setSename(resultSet.getString(3));

				spteqpts.setSetype(resultSet.getString(4));
				spteqpts.setSestate(resultSet.getInt(5));
				spteqpts.setSemark(resultSet.getString(6));				
				spteqpts.setSeresource(resultSet.getString(7));
				spteqpts.setUid(resultSet.getInt(8));
				
				lstSpteqpts.add(spteqpts);
				
			}
				return lstSpteqpts;
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			this.connectionManager.closeConnection(conn);//锟截憋拷锟斤拷锟斤拷
		}
	
	}
		

	@Override
	public int deleteById(int seid) {
		// TODO Auto-generated method stub
		Connection conn=connectionManager.openConnection();
		//锟斤拷锟斤拷锟斤拷锟斤拷
		TransactionManager.conn=conn;
		TransactionManager.beginTransaction();
		//锟斤拷锟斤拷SQL锟斤拷锟�
		String strSQL="delete from spteqpts where seid=?";
		
		Object[] params=new Object[]{seid};
		
		int affectRows=this.dbUtils.execOthers(conn, strSQL, params);
		
		if(affectRows>0){
			TransactionManager.commit();//锟结交
		}else{
			TransactionManager.rollback();//锟截癸拷
		} 
					
		return affectRows;
		
	}
	@Override
	public Spteqpts selectById(int seid) {
		// TODO Auto-generated method stub
		//锟斤拷锟斤拷锟斤拷锟斤拷
	    Connection conn=connectionManager.openConnection();
		//锟斤拷锟斤拷锟斤拷锟�
		String strSQL= "select * from spteqpts where seid=?";
		
		Object[] params=new Object[]{seid};
		
		ResultSet resultSet=this.dbUtils.execQuery(conn, strSQL, params);
		
	//锟斤拷装锟斤拷锟斤拷
		try {
			if(resultSet.next()){
				

				Spteqpts spteqpts=new Spteqpts();
				spteqpts.setSeid(resultSet.getInt(1));
				spteqpts.setPosttime(resultSet.getDate(2));
				spteqpts.setSename(resultSet.getString(3));

				spteqpts.setSetype(resultSet.getString(4));
				spteqpts.setSestate(resultSet.getInt(5));
				spteqpts.setSemark(resultSet.getString(6));				
				spteqpts.setSeresource(resultSet.getString(7));
				spteqpts.setUid(resultSet.getInt(8));
				
				
				return spteqpts;
				
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
	public int update(Spteqpts spteqpts) {
		// TODO Auto-generated method stub
		//锟斤拷锟斤拷锟斤拷锟斤拷
				Connection  conn = this.connectionManager.openConnection();
				//锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
				TransactionManager.conn = conn;
				TransactionManager.beginTransaction();
				//锟斤拷锟斤拷锟斤拷锟�
				int seid =spteqpts.getSeid();
				Date posttime=spteqpts.getPosttime();
				String sename =spteqpts.getSename();
				String setype =spteqpts.getSetype();
				int sestate =spteqpts.getSestate();
				String semark = spteqpts.getSemark();
				String seresource =spteqpts.getSeresource();
				int uid=spteqpts.getUid();
			
			
				//锟斤拷锟斤拷锟接Ｑｏ拷锟斤拷锟斤拷模锟斤拷
				String strSQL = "update spteqpts set posttime=?, sename=?,setype=?,sestate=?,semark=?,seresource=?,uid=? where seid=?";
				Object[] params = new Object[]{posttime,sename,setype,sestate,semark,seresource,uid,seid};
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
	public List<Spteqpts> selectByName(String sename) {
		// TODO Auto-generated method stub
		// 锟斤拷锟斤拷一锟斤拷List锟斤拷锟斤拷
		List<Spteqpts> lstSpteqpts = new ArrayList<Spteqpts>();
		// 锟斤拷锟接讹拷锟斤拷
		Connection conn = connectionManager.openConnection();
		// SQL锟斤拷锟�
		String strSQL = "select * from spteqpts where sename like '%" + sename + "%'";

		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,
				new Object[] {});
		// 锟斤拷锟截讹拷锟襟，凤拷装
		try {
			while (resultSet.next()) {

				Spteqpts spteqpts = new Spteqpts();
				spteqpts.setSeid(resultSet.getInt(1));
				spteqpts.setPosttime(resultSet.getDate(2));
				spteqpts.setSename(resultSet.getString(3));

				spteqpts.setSetype(resultSet.getString(4));
				spteqpts.setSestate(resultSet.getInt(5));
				spteqpts.setSemark(resultSet.getString(6));
				spteqpts.setSeresource(resultSet.getString(7));
				spteqpts.setUid(resultSet.getInt(8));

				lstSpteqpts.add(spteqpts);

			}
			return lstSpteqpts;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);// 锟截憋拷锟斤拷锟斤拷
		}
	}

}
