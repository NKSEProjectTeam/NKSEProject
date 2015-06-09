package com.nankai.exchange.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nankai.exchange.dao.IInstrumentsDao;
import com.nankai.exchange.db.ConnectionManager;
import com.nankai.exchange.db.DBUtils;
import com.nankai.exchange.db.TransactionManager;
import com.nankai.exchange.po.Instruments;

public class InstrumentsDaoImpl implements IInstrumentsDao {
	//锟斤拷锟斤拷一锟斤拷锟斤拷菘锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷一锟斤拷锟斤拷菘锟斤拷锟斤拷锟斤拷锟斤拷
			private ConnectionManager connectionManager;
			private DBUtils dbUtils;
			
			
			//锟睫参癸拷锟斤拷
			public InstrumentsDaoImpl() {
				super();
				// TODO Auto-generated constructor stub
				this.connectionManager=new ConnectionManager();
				this.dbUtils=new DBUtils();
			}	
	@Override
	public int insert(Instruments instruments) {
		// TODO Auto-generated method stub
		Connection  conn = this.connectionManager.openConnection();
		//锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
		TransactionManager.conn = conn;
		TransactionManager.beginTransaction();
		
		//锟斤拷锟斤拷锟斤拷锟�
		//Date posttime=instruments.getPosttime();
		String instrumentbrand =instruments.getInstrumentbrand();
		String instrumentname =instruments.getInstrumentname();
		String instrumenttype = instruments.getInstrumenttype();
		int instrumentstate =instruments.getInstrumentstate();
		String instrumentmark = instruments.getInstrumentmark();
		String instrumentresource =instruments.getInstrumentresource();
		int uid=instruments.getUid();
		
	
		//锟斤拷锟斤拷锟接Ｑｏ拷锟斤拷锟斤拷模锟斤拷
		String strSQL = "insert into instruments values(null,now(),?,?,?,?,?,?,?)";
		Object[] params = new Object[]{instrumentbrand,instrumentname,instrumenttype,instrumentstate,instrumentmark,instrumentresource,uid};
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
	public List<Instruments> selectAll() {
		// TODO Auto-generated method stub
		 List<Instruments> lstInstruments=new ArrayList<Instruments>();
			//锟斤拷锟接讹拷锟斤拷
			Connection conn=connectionManager.openConnection();
			//SQL锟斤拷锟�
			String strSQL= "select * from instruments order by instrumentid";
			
			ResultSet resultSet=this.dbUtils.execQuery(conn, strSQL, new Object[]{});
			//锟斤拷锟截讹拷锟襟，凤拷装
			try {
				while(resultSet.next()){
					
					Instruments instruments=new Instruments();
					instruments.setInstrumentid(resultSet.getInt(1));
					instruments.setPosttime(resultSet.getDate(2));
					instruments.setInstrumentbrand(resultSet.getString(3));
					instruments.setInstrumentname(resultSet.getString(4));
					instruments.setInstrumenttype(resultSet.getString(5));
					instruments.setInstrumentstate(resultSet.getInt(6));
					instruments.setInstrumentmark(resultSet.getString(7));
					instruments.setInstrumentresource(resultSet.getString(8));
					instruments.setUid(resultSet.getInt(9));
					
					lstInstruments.add(instruments);
					
				}
					return lstInstruments;
					
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}finally{
				this.connectionManager.closeConnection(conn);//锟截憋拷锟斤拷锟斤拷
			}
		
			
			
		}


	@Override
	public int deleteById(int instrumentid) {
		// TODO Auto-generated method stub
		//锟斤拷锟斤拷锟斤拷锟斤拷
        Connection conn=connectionManager.openConnection();
		//锟斤拷锟斤拷锟斤拷锟斤拷
		TransactionManager.conn=conn;
		TransactionManager.beginTransaction();
		//锟斤拷锟斤拷SQL锟斤拷锟�
		String strSQL="delete from instruments where instrumentid=?";
		
		Object[] params=new Object[]{instrumentid};
		
		int affectRows=this.dbUtils.execOthers(conn, strSQL, params);
		
		if(affectRows>0){
			TransactionManager.commit();//锟结交
		}else{
			TransactionManager.rollback();//锟截癸拷
		} 
					
		return affectRows;
		
	}

	@Override
	public Instruments selectById(int instrumentid) {
		// TODO Auto-generated method stub
		Connection conn=connectionManager.openConnection();
		//锟斤拷锟斤拷锟斤拷锟�
		String strSQL= "select * from instruments where instrumentid=?";
		
		Object[] params=new Object[]{instrumentid};
		
		ResultSet resultSet=this.dbUtils.execQuery(conn, strSQL, params);
		
	    //锟斤拷装锟斤拷锟斤拷
		try {
			if(resultSet.next()){
				
				Instruments instruments=new Instruments();
				instruments.setInstrumentid(resultSet.getInt(1));
				instruments.setPosttime(resultSet.getDate(2));
				instruments.setInstrumentbrand(resultSet.getString(3));
				instruments.setInstrumentname(resultSet.getString(4));
				instruments.setInstrumenttype(resultSet.getString(5));
				instruments.setInstrumentstate(resultSet.getInt(6));
				instruments.setInstrumentmark(resultSet.getString(7));
				instruments.setInstrumentresource(resultSet.getString(8));
				instruments.setUid(resultSet.getInt(9));
				
				
				return instruments;
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
	public int update(Instruments instruments) {
		// TODO Auto-generated method stub
		//锟斤拷锟斤拷锟斤拷锟斤拷
				Connection  conn = this.connectionManager.openConnection();
				//锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
				TransactionManager.conn = conn;
				TransactionManager.beginTransaction();
				//锟斤拷锟斤拷锟斤拷锟�
				int instrumentid = instruments.getInstrumentid();
				Date posttime=instruments.getPosttime();
				String instrumentbrand =instruments.getInstrumentbrand();
				String instrumentname =instruments.getInstrumentname();
				String instrumenttype = instruments.getInstrumenttype();
				int instrumentstate =instruments.getInstrumentstate();
				String instrumentmark = instruments.getInstrumentmark();
				String instrumentresource =instruments.getInstrumentresource();
				int uid=instruments.getUid();
				
			
				//锟斤拷锟斤拷锟接Ｑｏ拷锟斤拷锟斤拷模锟斤拷
				String strSQL = "update instruments set posttime=?,instrumentbrand=?,instrumentname=?,instrumenttype=?,instrumentstate=?,instrumentmark=?,instrumentresource=?,uid=? where instrumentid=?";
				Object[] params = new Object[]{posttime,instrumentbrand,instrumentname,instrumenttype,instrumentstate,instrumentmark,instrumentresource,uid,instrumentid};
				
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
	public List<Instruments> selectByName(String instrumentname) {
		// TODO Auto-generated method stub
		List<Instruments> lstInstruments = new ArrayList<Instruments>();
		// 锟斤拷锟接讹拷锟斤拷
		Connection conn = connectionManager.openConnection();
		// SQL锟斤拷锟�
		String strSQL = "select * from instruments where instrumentname like '%" + instrumentname + "%'";

		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,
				new Object[] {});
		// 锟斤拷锟截讹拷锟襟，凤拷装
		try {
			while (resultSet.next()) {

				Instruments instruments = new Instruments();
				instruments.setInstrumentid(resultSet.getInt(1));
				instruments.setPosttime(resultSet.getDate(2));
				instruments.setInstrumentbrand(resultSet.getString(3));
				instruments.setInstrumentname(resultSet.getString(4));
				instruments.setInstrumenttype(resultSet.getString(5));
				instruments.setInstrumentstate(resultSet.getInt(6));
				instruments.setInstrumentmark(resultSet.getString(7));
				instruments.setInstrumentresource(resultSet.getString(8));
				instruments.setUid(resultSet.getInt(9));

				lstInstruments.add(instruments);

			}
			return lstInstruments;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);// 锟截憋拷锟斤拷锟斤拷
		}

	}
}
