package com.nankai.exchange.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nankai.exchange.dao.IPhonesDao;
import com.nankai.exchange.db.ConnectionManager;
import com.nankai.exchange.db.DBUtils;
import com.nankai.exchange.db.TransactionManager;
import com.nankai.exchange.po.Phones;

public class PhonesDaoImpl implements IPhonesDao {
	//锟斤拷锟斤拷一锟斤拷锟斤拷菘锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷一锟斤拷锟斤拷菘锟斤拷锟斤拷锟斤拷锟斤拷
			private ConnectionManager connectionManager;
			private DBUtils dbUtils;
			
			
			//锟睫参癸拷锟斤拷
			public PhonesDaoImpl() {
				super();
				// TODO Auto-generated constructor stub
				this.connectionManager=new ConnectionManager();
				this.dbUtils=new DBUtils();
			}	
	@Override
	public int insert(Phones phones) {
		// TODO Auto-generated method stub
		Connection  conn = this.connectionManager.openConnection();
		//锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
		TransactionManager.conn = conn;
		TransactionManager.beginTransaction();
		
		//锟斤拷锟斤拷锟斤拷锟�

		//Date posttime=phones.getPosttime();
		String phonebrand =phones.getPhonebrand();
		String phonemodel =phones.getPhonemodel();
		String phonetype = phones.getPhonetype();
		int phonestate =phones.getPhonestate();
		String phonemark = phones.getPhonemark();
		String phoneresource =phones.getPhoneresource();
		int uid=phones.getUid();
		
		
		
	
		//锟斤拷锟斤拷锟接Ｑｏ拷锟斤拷锟斤拷模锟斤拷
		String strSQL = "insert into phones values(null,now(),?,?,?,?,?,?,?)";
		Object[] params = new Object[]{phonebrand,phonemodel,phonetype,phonestate,phonemark,phoneresource,uid};
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
	public List<Phones> selectAll() {
		// TODO Auto-generated method stub
		//锟斤拷锟斤拷一锟斤拷List锟斤拷锟斤拷
        List<Phones> lstPhones=new ArrayList<Phones>();
		//锟斤拷锟接讹拷锟斤拷
		Connection conn=connectionManager.openConnection();
		//SQL锟斤拷锟�
		String strSQL= "select * from phones order by phoneid";
		
		ResultSet resultSet=this.dbUtils.execQuery(conn, strSQL, new Object[]{});
		//锟斤拷锟截讹拷锟襟，凤拷装
		try {
			while(resultSet.next()){
				
				Phones phones=new Phones();
				phones.setPhoneid(resultSet.getInt(1));
				phones.setPosttime(resultSet.getDate(2));
				phones.setPhonebrand(resultSet.getString(3));
				phones.setPhonemodel(resultSet.getString(4));
				phones.setPhonetype(resultSet.getString(5));
				phones.setPhonestate(resultSet.getInt(6));
				phones.setPhonemark(resultSet.getString(7));				
				phones.setPhoneresource(resultSet.getString(8));
				phones.setUid(resultSet.getInt(9));
				
				lstPhones.add(phones);
				
			}
				return lstPhones;
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			this.connectionManager.closeConnection(conn);//锟截憋拷锟斤拷锟斤拷
		}
	
		
		
	}

	@Override
	public int deleteById(int phoneid) {
		// TODO Auto-generated method stub
		//锟斤拷锟斤拷锟斤拷锟斤拷
        Connection conn=connectionManager.openConnection();
		//锟斤拷锟斤拷锟斤拷锟斤拷
		TransactionManager.conn=conn;
		TransactionManager.beginTransaction();
		//锟斤拷锟斤拷SQL锟斤拷锟�
		String strSQL="delete from phones where phoneid=?";
		
		Object[] params=new Object[]{phoneid};
		
		int affectRows=this.dbUtils.execOthers(conn, strSQL, params);
		
		if(affectRows>0){
			TransactionManager.commit();//锟结交
		}else{
			TransactionManager.rollback();//锟截癸拷
		} 
					
		return affectRows;
		
	}

	@Override
	public Phones selectById(int phoneid) {
		// TODO Auto-generated method stub
		//锟斤拷锟斤拷锟斤拷锟斤拷
	    Connection conn=connectionManager.openConnection();
		//锟斤拷锟斤拷锟斤拷锟�
		String strSQL= "select * from phones where phoneid=?";
		
		Object[] params=new Object[]{phoneid};
		
		ResultSet resultSet=this.dbUtils.execQuery(conn, strSQL, params);
		
	//锟斤拷装锟斤拷锟斤拷
		try {
			if(resultSet.next()){
				

				Phones phones=new Phones();
				phones.setPhoneid(resultSet.getInt(1));
				phones.setPosttime(resultSet.getDate(2));
				phones.setPhonebrand(resultSet.getString(3));
				phones.setPhonemodel(resultSet.getString(4));
				phones.setPhonetype(resultSet.getString(5));
				phones.setPhonestate(resultSet.getInt(6));
				phones.setPhonemark(resultSet.getString(7));				
				phones.setPhoneresource(resultSet.getString(8));
				phones.setUid(resultSet.getInt(9));
				
				return phones;
				
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
	public int update(Phones phones) {
		// TODO Auto-generated method stub
		//锟斤拷锟斤拷锟斤拷锟斤拷
				Connection  conn = this.connectionManager.openConnection();
				//锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
				TransactionManager.conn = conn;
				TransactionManager.beginTransaction();
				//锟斤拷锟斤拷锟斤拷锟�
				int phoneid =phones.getPhoneid();
				Date posttime=phones.getPosttime();
				String phonebrand =phones.getPhonebrand();
				String phonemodel =phones.getPhonemodel();
				String phonetype = phones.getPhonetype();
				int phonestate =phones.getPhonestate();
				String phonemark = phones.getPhonemark();
				String phoneresource =phones.getPhoneresource();
				int uid=phones.getUid();
				
			
			
				//锟斤拷锟斤拷锟接Ｑｏ拷锟斤拷锟斤拷模锟斤拷
				String strSQL = "update phones set posttime=?, phonebrand=?,phonemodel=?,phonetype=?,phonestate=?,phonemark=?,phoneresource=?,uid=? where phoneid=?";
				Object[] params = new Object[]{posttime,phonebrand,phonemodel,phonetype,phonestate,phonemark,phoneresource,uid,phoneid};
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
	public List<Phones> selectByName(String phonemodel) {
		// TODO Auto-generated method stub
		// 锟斤拷锟斤拷一锟斤拷List锟斤拷锟斤拷
		List<Phones> lstPhones = new ArrayList<Phones>();
		// 锟斤拷锟接讹拷锟斤拷
		Connection conn = connectionManager.openConnection();
		// SQL锟斤拷锟�
		String strSQL = "select * from phones where phonemodel like '%" + phonemodel + "%'";

		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,
				new Object[] {});
		// 锟斤拷锟截讹拷锟襟，凤拷装
		try {
			while (resultSet.next()) {

				Phones phones = new Phones();
				phones.setPhoneid(resultSet.getInt(1));
				phones.setPosttime(resultSet.getDate(2));
				phones.setPhonebrand(resultSet.getString(3));
				phones.setPhonemodel(resultSet.getString(4));
				phones.setPhonetype(resultSet.getString(5));
				phones.setPhonestate(resultSet.getInt(6));
				phones.setPhonemark(resultSet.getString(7));
				phones.setPhoneresource(resultSet.getString(8));
				phones.setUid(resultSet.getInt(9));

				lstPhones.add(phones);

			}
			return lstPhones;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);// 锟截憋拷锟斤拷锟斤拷
		}

	}


}
