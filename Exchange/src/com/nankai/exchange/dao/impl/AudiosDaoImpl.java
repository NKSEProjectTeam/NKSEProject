package com.nankai.exchange.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nankai.exchange.dao.IAudiosDao;
import com.nankai.exchange.db.ConnectionManager;
import com.nankai.exchange.db.DBUtils;
import com.nankai.exchange.db.TransactionManager;
import com.nankai.exchange.po.Audios;



public class AudiosDaoImpl implements IAudiosDao {

	private ConnectionManager connectionManager;
	private DBUtils dbUtils;
	
	
	
	public AudiosDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager=new ConnectionManager();
		this.dbUtils=new DBUtils();
	}

    @Override
    public int insert(Audios audios) {
	// TODO Auto-generated method stub
    	//锟斤拷取一锟斤拷锟斤拷菘锟斤拷锟斤拷锟斤拷
		Connection  conn = this.connectionManager.openConnection();
		//锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
		TransactionManager.conn = conn;
		TransactionManager.beginTransaction();
		
		//锟斤拷锟斤拷锟斤拷锟�
		//Date posttime=audios.getPosttime();
		String audioname =audios.getAudioname();
		String audiopublish =audios.getAudiopublish();
		int audiostate = audios.getAudiostate();
		String audiomark=audios.getAudiomark();
		String audioresource=audios.getAudioresource();
		int uid=audios.getUid();
		
	
		//锟斤拷锟斤拷锟接Ｑｏ拷锟斤拷锟斤拷模锟斤拷
		String strSQL = "insert into audios values(null,now(),?,?,?,?,?,?)";
		Object[] params = new Object[]{audioname,audiopublish,audiostate,audiomark,audioresource,uid};
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
	public int deleteById(int audioid) {
		// TODO Auto-generated method stub
		Connection conn=connectionManager.openConnection();
		
		TransactionManager.conn=conn;
		TransactionManager.beginTransaction();
		
		String strSQL="delete from audios where audioid=?";
		
		Object[] params=new Object[]{audioid};
		
		int affectRows=this.dbUtils.execOthers(conn, strSQL, params);
		
		if(affectRows>0){
			TransactionManager.commit();
		}else{
			TransactionManager.rollback();
		} 
					
		return affectRows;
		
	}



	@Override
	public int update(Audios audios) {
		// TODO Auto-generated method stub
	    Connection  conn = this.connectionManager.openConnection();
		//锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
		TransactionManager.conn = conn;
		TransactionManager.beginTransaction();
		
		int audioid=audios.getAudioid();
		Date posttime=audios.getPosttime();
		String audioname =audios.getAudioname();
		String audiopublish =audios.getAudiopublish();
		int audiostate = audios.getAudiostate();
		String audiomark=audios.getAudiomark();
		String audioresource=audios.getAudioresource();
		int uid=audios.getUid();
		
	
	
		//锟斤拷锟斤拷锟接Ｑｏ拷锟斤拷锟斤拷模锟斤拷
		String strSQL = "update audios set posttime=?, audioname=?,audiopublish=?,audiostate=?,audiomark=?,audioresource=?,uid=? where audioid=?";
		Object[] params = new Object[]{posttime, audioname,audiopublish,audiostate,audiomark,audioresource,uid,audioid};
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
	public Audios selectById(int audioid) {
		// TODO Auto-generated method stub
		Connection conn=connectionManager.openConnection();
		
		String strSQL= "select * from audios where audioid=?";
		
		Object[] params=new Object[]{audioid};
		
		ResultSet resultSet=this.dbUtils.execQuery(conn, strSQL, params);
		
		try {
			if(resultSet.next()){
				
				Audios audios=new Audios();
				audios.setAudioid(resultSet.getInt(1));
				audios.setPosttime(resultSet.getDate(2));
				audios.setAudioname(resultSet.getString(3));
				audios.setAudiopublish(resultSet.getString(4));
				audios.setAudiostate(resultSet.getInt(5));
				audios.setAudiomark(resultSet.getString(6));
				audios.setAudioresource(resultSet.getString(7));
				audios.setUid(resultSet.getInt(8));
				
				
				return audios;
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
	public List<Audios> selectAll() {
		// TODO Auto-generated method stub
		List<Audios> lstAudios=new ArrayList<Audios>();
		
		Connection conn=connectionManager.openConnection();
		
		String strSQL= "select * from audios order by audioid";
		
		ResultSet resultSet=this.dbUtils.execQuery(conn, strSQL, new Object[]{});
		
		try {
			while(resultSet.next()){
				
				Audios audios=new Audios();
				audios.setAudioid(resultSet.getInt(1));
				audios.setPosttime(resultSet.getDate(2));
				audios.setAudioname(resultSet.getString(3));
				audios.setAudiopublish(resultSet.getString(4));
				audios.setAudiostate(resultSet.getInt(5));
				audios.setAudiomark(resultSet.getString(6));
				audios.setAudioresource(resultSet.getString(7));
				audios.setUid(resultSet.getInt(8));
				
				lstAudios.add(audios);
				
			}
				return lstAudios;
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			this.connectionManager.closeConnection(conn);
		}
	
		
		
	}

	@Override
	public List<Audios> selectByName(String audioname) {
		// TODO Auto-generated method stub
		List<Audios> lstAudios = new ArrayList<Audios>();

		Connection conn = connectionManager.openConnection();

		String strSQL = "select * from audios where audioname like '%" + audioname + "%'";

		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,
				new Object[] {});

		try {
			while (resultSet.next()) {

				Audios audios = new Audios();
				audios.setAudioid(resultSet.getInt(1));
				audios.setPosttime(resultSet.getDate(2));
				audios.setAudioname(resultSet.getString(3));
				audios.setAudiopublish(resultSet.getString(4));
				audios.setAudiostate(resultSet.getInt(5));
				audios.setAudiomark(resultSet.getString(6));
				audios.setAudioresource(resultSet.getString(7));
				audios.setUid(resultSet.getInt(8));

				lstAudios.add(audios);

			}
			return lstAudios;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}

	}




}
