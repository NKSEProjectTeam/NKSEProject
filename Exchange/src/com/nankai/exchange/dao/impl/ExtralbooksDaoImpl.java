package com.nankai.exchange.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nankai.exchange.dao.IExtrabooksDao;
import com.nankai.exchange.db.ConnectionManager;
import com.nankai.exchange.db.DBUtils;
import com.nankai.exchange.db.TransactionManager;
import com.nankai.exchange.po.Extrabooks;




public class ExtralbooksDaoImpl implements IExtrabooksDao {

	//锟斤拷锟斤拷一锟斤拷锟斤拷菘锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷一锟斤拷锟斤拷菘锟斤拷锟斤拷锟斤拷锟斤拷
	private ConnectionManager connectionManager;
	private DBUtils dbUtils;
	
	
	//锟睫参癸拷锟斤拷
	public ExtralbooksDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager=new ConnectionManager();
		this.dbUtils=new DBUtils();
	}
	@Override
	public int insert(Extrabooks extrabooks) {
		// TODO Auto-generated method stub
		Connection  conn = this.connectionManager.openConnection();
		//锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
		TransactionManager.conn = conn;
		TransactionManager.beginTransaction();
		
		//锟斤拷锟斤拷锟斤拷锟�
		//Date posttime=extrabooks.getPosttime();
		String ebname =extrabooks.getEbname();
		String ebauthor =extrabooks.getEbauthor();
		String ebpublish = extrabooks.getEbpublish();
		int ebstate =extrabooks.getEbstate();
		String ebmark = extrabooks.getEbmark();
		String ebresource =extrabooks.getEbresource();
		int uid=extrabooks.getUid();
		
	
		//锟斤拷锟斤拷锟接Ｑｏ拷锟斤拷锟斤拷模锟斤拷
		String strSQL = "insert into extrabooks values(null,now(),?,?,?,?,?,?,?)";
		Object[] params = new Object[]{ebname,ebauthor,ebpublish,ebstate,ebmark,ebresource,uid};
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
	public List<Extrabooks> selectAll() {
		// TODO Auto-generated method stub
		 List<Extrabooks> lstExtrabooks=new ArrayList<Extrabooks>();
			//锟斤拷锟接讹拷锟斤拷
			Connection conn=connectionManager.openConnection();
			//SQL锟斤拷锟�
			String strSQL= "select * from extrabooks order by ebid";
			
			ResultSet resultSet=this.dbUtils.execQuery(conn, strSQL, new Object[]{});
			//锟斤拷锟截讹拷锟襟，凤拷装
			try {
				while(resultSet.next()){
					
					Extrabooks extrabooks=new Extrabooks();
					extrabooks.setEbid(resultSet.getInt(1));
					extrabooks.setPosttime(resultSet.getDate(2));
					extrabooks.setEbname(resultSet.getString(3));
					extrabooks.setEbauthor(resultSet.getString(4));
					extrabooks.setEbpublish(resultSet.getString(5));
					extrabooks.setEbstate(resultSet.getInt(6));
					extrabooks.setEbmark(resultSet.getString(7));
					extrabooks.setEbresource(resultSet.getString(8));
				    extrabooks.setUid(resultSet.getInt(9));
					
					lstExtrabooks.add(extrabooks);
					
				}
					return lstExtrabooks;
					
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}finally{
				this.connectionManager.closeConnection(conn);//锟截憋拷锟斤拷锟斤拷
			}
		
			
			
		}

	@Override
	public int deleteById(int ebid) {
		// TODO Auto-generated method stub
		//锟斤拷锟斤拷锟斤拷锟斤拷
        Connection conn=connectionManager.openConnection();
		//锟斤拷锟斤拷锟斤拷锟斤拷
		TransactionManager.conn=conn;
		TransactionManager.beginTransaction();
		//锟斤拷锟斤拷SQL锟斤拷锟�
		String strSQL="delete from extrabooks where ebid=?";
		
		Object[] params=new Object[]{ebid};
		
		int affectRows=this.dbUtils.execOthers(conn, strSQL, params);
		
		if(affectRows>0){
			TransactionManager.commit();//锟结交
		}else{
			TransactionManager.rollback();//锟截癸拷
		} 
					
		return affectRows;
		
	}

	@Override
	public Extrabooks selectById(int ebid) {
		// TODO Auto-generated method stub
		Connection conn=connectionManager.openConnection();
		//锟斤拷锟斤拷锟斤拷锟�
		String strSQL= "select * from extrabooks where ebid=?";
		
		Object[] params=new Object[]{ebid};
		
		ResultSet resultSet=this.dbUtils.execQuery(conn, strSQL, params);
		
	//锟斤拷装锟斤拷锟斤拷
		try {
			if(resultSet.next()){
				
				Extrabooks extrabooks=new Extrabooks();
				extrabooks.setEbid(resultSet.getInt(1));
				extrabooks.setPosttime(resultSet.getDate(2));
				extrabooks.setEbname(resultSet.getString(3));
				extrabooks.setEbauthor(resultSet.getString(4));
				extrabooks.setEbpublish(resultSet.getString(5));
				extrabooks.setEbstate(resultSet.getInt(6));
				extrabooks.setEbmark(resultSet.getString(7));
				extrabooks.setEbresource(resultSet.getString(8));
			    extrabooks.setUid(resultSet.getInt(9));
				
				
				return extrabooks;
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
	public int update(Extrabooks extrabooks) {
		// TODO Auto-generated method stub
		//锟斤拷锟斤拷锟斤拷锟斤拷
		Connection  conn = this.connectionManager.openConnection();
		//锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
		TransactionManager.conn = conn;
		TransactionManager.beginTransaction();
		//锟斤拷锟斤拷锟斤拷锟�
		int ebid = extrabooks.getEbid();
		Date posttime=extrabooks.getPosttime();
		String ebname =extrabooks.getEbname();
		String ebauthor =extrabooks.getEbauthor();
		String ebpublish = extrabooks.getEbpublish();
		int ebstate =extrabooks.getEbstate();
		String ebmark = extrabooks.getEbmark();
		String ebresource =extrabooks.getEbresource();
		int uid=extrabooks.getUid();
		
	
		//锟斤拷锟斤拷锟接Ｑｏ拷锟斤拷锟斤拷模锟斤拷
		String strSQL = "update extrabooks set posttime=?,ebname=?,ebauthor=?,abpublish=?,ebstate=?,ebmark=?,ebresource=?,uid=? where ebid=?";
		Object[] params = new Object[]{posttime,ebname,ebauthor,ebpublish,ebstate,ebmark,ebresource,uid,ebid};		
		
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
	public List<Extrabooks> selectByName(String ebname) {
		// TODO Auto-generated method stub
		List<Extrabooks> lstExtrabooks = new ArrayList<Extrabooks>();
		// 锟斤拷锟接讹拷锟斤拷
		Connection conn = connectionManager.openConnection();
		// SQL锟斤拷锟�
		String strSQL = "select * from extrabooks where ebname like '%" + ebname + "%'";

		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,
				new Object[] {});
		// 锟斤拷锟截讹拷锟襟，凤拷装
		try {
			while (resultSet.next()) {

				Extrabooks extrabooks = new Extrabooks();
				extrabooks.setEbid(resultSet.getInt(1));
				extrabooks.setPosttime(resultSet.getDate(2));
				extrabooks.setEbname(resultSet.getString(3));
				extrabooks.setEbauthor(resultSet.getString(4));
				extrabooks.setEbpublish(resultSet.getString(5));
				extrabooks.setEbstate(resultSet.getInt(6));
				extrabooks.setEbmark(resultSet.getString(7));
				extrabooks.setEbresource(resultSet.getString(8));
				extrabooks.setUid(resultSet.getInt(9));

				lstExtrabooks.add(extrabooks);

			}
			return lstExtrabooks;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);// 锟截憋拷锟斤拷锟斤拷
		}

	}



}
