package com.nankai.exchange.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nankai.exchange.dao.IFemalesDao;
import com.nankai.exchange.db.ConnectionManager;
import com.nankai.exchange.db.DBUtils;
import com.nankai.exchange.db.TransactionManager;
import com.nankai.exchange.po.Females;

public class FemalesDaoImpl implements IFemalesDao {

	//锟斤拷锟斤拷一锟斤拷锟斤拷菘锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷一锟斤拷锟斤拷菘锟斤拷锟斤拷锟斤拷锟斤拷
		private ConnectionManager connectionManager;
		private DBUtils dbUtils;
		
		
		//锟睫参癸拷锟斤拷
		public FemalesDaoImpl() {
			super();
			// TODO Auto-generated constructor stub
			this.connectionManager=new ConnectionManager();
			this.dbUtils=new DBUtils();
		}	
	@Override
	public int insert(Females females) {
		// TODO Auto-generated method stub
		Connection  conn = this.connectionManager.openConnection();
		//锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
		TransactionManager.conn = conn;
		TransactionManager.beginTransaction();
		
		//锟斤拷锟斤拷锟斤拷锟�
		int uid=females.getUid();
		//Date posttime=females.getPosttime();
		String femaletype =females.getFemaletype();
		String femalesize =females.getFemalesize();
		int femalestate =females.getFemalestate();
		String femalemark = females.getFemalemark();
		String femaleresource =females.getFemaleresource();
		
		
	
		//锟斤拷锟斤拷锟接Ｑｏ拷锟斤拷锟斤拷模锟斤拷
		String strSQL = "insert into females values(null,?,now(),?,?,?,?,?)";
		Object[] params = new Object[]{uid,femaletype,femalesize,femalestate,femalemark,femaleresource};
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
	public List<Females> selectAll() {
		// TODO Auto-generated method stub
		List<Females> lstFemales=new ArrayList<Females>();
		//锟斤拷锟接讹拷锟斤拷
		Connection conn=connectionManager.openConnection();
		//SQL锟斤拷锟�
		String strSQL= "select * from females order by femaleid";
		
		ResultSet resultSet=this.dbUtils.execQuery(conn, strSQL, new Object[]{});
		//锟斤拷锟截讹拷锟襟，凤拷装
		try {
			while(resultSet.next()){
				
				Females females=new Females();
				females.setFemaleid(resultSet.getInt(1));
				females.setUid(resultSet.getInt(2));
				females.setPosttime(resultSet.getDate(3));
				females.setFemaletype(resultSet.getString(4));
				females.setFemalesize(resultSet.getString(5));
				females.setFemalestate(resultSet.getInt(6));
				females.setFemalemark(resultSet.getString(7));
				females.setFemaleresource(resultSet.getString(8));
				
				
			    lstFemales.add(females);
				
			}
				return lstFemales;
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			this.connectionManager.closeConnection(conn);//锟截憋拷锟斤拷锟斤拷
		}
	
		
		
	}

	@Override
	public int deleteById(int femaleid) {
		// TODO Auto-generated method stub
		//锟斤拷锟斤拷锟斤拷锟斤拷
        Connection conn=connectionManager.openConnection();
		//锟斤拷锟斤拷锟斤拷锟斤拷
		TransactionManager.conn=conn;
		TransactionManager.beginTransaction();
		//锟斤拷锟斤拷SQL锟斤拷锟�
		String strSQL="delete from females where femaleid=?";
		
		Object[] params=new Object[]{femaleid};
		
		int affectRows=this.dbUtils.execOthers(conn, strSQL, params);
		
		if(affectRows>0){
			TransactionManager.commit();//锟结交
		}else{
			TransactionManager.rollback();//锟截癸拷
		} 
					
		return affectRows;
		
	}
	@Override
	public Females selectById(int femaleid) {
		// TODO Auto-generated method stub
		Connection conn=connectionManager.openConnection();
		//锟斤拷锟斤拷锟斤拷锟�
		String strSQL= "select * from females where femaleid=?";
		
		Object[] params=new Object[]{femaleid};
		
		ResultSet resultSet=this.dbUtils.execQuery(conn, strSQL, params);
		
	//锟斤拷装锟斤拷锟斤拷
		try {
			if(resultSet.next()){
				
				Females females=new Females();
				females.setFemaleid(resultSet.getInt(1));
				females.setUid(resultSet.getInt(2));
				females.setPosttime(resultSet.getDate(3));
				females.setFemaletype(resultSet.getString(4));
				females.setFemalesize(resultSet.getString(5));
				females.setFemalestate(resultSet.getInt(6));
				females.setFemalemark(resultSet.getString(7));
				females.setFemaleresource(resultSet.getString(8));
				
				return females;
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
	public int update(Females females) {
		// TODO Auto-generated method stub
		//锟斤拷锟斤拷锟斤拷锟斤拷
				Connection  conn = this.connectionManager.openConnection();
				//锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
				TransactionManager.conn = conn;
				TransactionManager.beginTransaction();
				//锟斤拷锟斤拷锟斤拷锟�
				int femaleid = females.getFemaleid();
				int uid=females.getUid();
				Date posttime=females.getPosttime();
				String femaletype =females.getFemaletype();
				String femalesize =females.getFemalesize();
				int femalestate =females.getFemalestate();
				String femalemark = females.getFemalemark();
				String femaleresource =females.getFemaleresource();
				
			
				//锟斤拷锟斤拷锟接Ｑｏ拷锟斤拷锟斤拷模锟斤拷
				String strSQL = "update females set uid=?,posttime=?,femaletype=?,femalesize=?,femalestate=?,femalemark=?,femaleresource=? where femaleid=?";
				Object[] params = new Object[]{uid,posttime,femaletype,femalesize,femalestate,femalemark,femaleresource,femaleid};
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
	public List<Females> selectByName(String femaletype) {
		// TODO Auto-generated method stub
		List<Females> lstFemales = new ArrayList<Females>();
		// 锟斤拷锟接讹拷锟斤拷
		Connection conn = connectionManager.openConnection();
		// SQL锟斤拷锟�
		String strSQL = "select * from females where femaletype like '%" + femaletype + "%'";

		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,
				new Object[] {});
		// 锟斤拷锟截讹拷锟襟，凤拷装
		try {
			while (resultSet.next()) {

				Females females = new Females();
				females.setFemaleid(resultSet.getInt(1));
				females.setUid(resultSet.getInt(2));
				females.setPosttime(resultSet.getDate(3));
				females.setFemaletype(resultSet.getString(4));
				females.setFemalesize(resultSet.getString(5));
				females.setFemalestate(resultSet.getInt(6));
				females.setFemalemark(resultSet.getString(7));
				females.setFemaleresource(resultSet.getString(8));

				lstFemales.add(females);

			}
			return lstFemales;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);// 锟截憋拷锟斤拷锟斤拷
		}
	}

}
