package com.nankai.exchange.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nankai.exchange.dao.IEntertainmentsDao;
import com.nankai.exchange.db.ConnectionManager;
import com.nankai.exchange.db.DBUtils;
import com.nankai.exchange.db.TransactionManager;
import com.nankai.exchange.po.Entertainments;

public class EntertainmentsDaoImpl implements IEntertainmentsDao {

	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;
	
	public EntertainmentsDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}

	@Override
	public int insert(Entertainments entertainment) {
		// TODO Auto-generated method stub
		// 1銆佽幏鍙栨暟鎹簱杩炴帴
		this.conn = this.connectionManager.openConnection();
		// 2銆佸紑鍚簨鍔�
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 3銆佹媶鍒嗗睘鎬�
		String entername = entertainment.getEntername();
		String entertype = entertainment.getEntertype();
		int enterstate = entertainment.getEnterstate();
		String entermark = entertainment.getEntermark();
		String enterresource = entertainment.getEnterresource();
		int uid = entertainment.getUid();
		// 4銆丼QL妯℃澘
		String strSQL = "insert into entertainments values(null, now(), ?, ?, ?, ?, ?, ?)";
		Object[] params = new Object[] { entername, entertype, enterstate, entermark, enterresource, uid };
		// 5銆佸疄鐜版坊鍔犳暟鎹�
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		// 6銆佹彁浜や簨鍔�
		if (affectedRows > 0) {
			// 鎻愪氦
			TransactionManager.commit();
		} else {
			// 鍥炴粴
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public List<Entertainments> selectAll() {
		// TODO Auto-generated method stub
		// 1銆佺┖闆嗗悎瀛樻斁鏌ヨ缁撴灉
		List<Entertainments> lstEntertainments = new ArrayList<Entertainments>();
		// 2銆佽幏鍙栨暟鎹簱杩炴帴
		this.conn = connectionManager.openConnection();
		// 3銆丼QL妯℃澘
		String strSQL = "select * from entertainments order by enterid";
		// 4銆佸疄鐜版煡璇�
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, new Object[] {});
		// resultSet缁撴灉闆嗚浆鍖朙ist
		try {
			while (resultSet.next()) {
				Entertainments entertainment = new Entertainments();
				entertainment.setEnterid(resultSet.getInt(1));
				entertainment.setPosttime(resultSet.getDate(2));
				entertainment.setEntername(resultSet.getString(3));
				entertainment.setEntertype(resultSet.getString(4));
				entertainment.setEnterstate(resultSet.getInt(5));
				entertainment.setEntermark(resultSet.getString(6));
				entertainment.setEnterresource(resultSet.getString(7));
				entertainment.setUid(resultSet.getInt(8));
				lstEntertainments.add(entertainment);
			}
			return lstEntertainments;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
		
	}

	@Override
	public int deleteById(int enterid) {
		// TODO Auto-generated method stub
		// 1銆佽幏鍙栬繛鎺ュ璞�
		this.conn = this.connectionManager.openConnection();
		// 2銆佸紑鍚簨鍔�
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 3銆丼QL妯℃澘
		String strSQL = "delete from entertainments where enterid = ?";
		Object[] params = new Object[] { enterid };
		// 4銆佸畬鎴愬垹闄�
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		// 5銆佹彁浜ゆ垨鍥炴粴
		if (affectedRows > 0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public Entertainments selectById(int enterid) {
		// TODO Auto-generated method stub
		// 1銆佽幏鍙栬繛鎺ュ璞�
		this.conn = this.connectionManager.openConnection();
		// 2銆丼QL妯℃澘
		String strSQL = "select * from entertainments where enterid = ?";
		Object[] params = new Object[] { enterid };
		// 3銆佸畬鎴愭煡鎵�
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		// 4銆佽幏鍙栥�灏佽
		try {
			if (resultSet.next()) {
				// 5銆佸垱寤哄璞″苟灏佽
				Entertainments entertainment = new Entertainments();
				entertainment.setEnterid(resultSet.getInt(1));
				entertainment.setPosttime(resultSet.getDate(2));
				entertainment.setEntername(resultSet.getString(3));
				entertainment.setEntertype(resultSet.getString(4));
				entertainment.setEnterstate(resultSet.getInt(5));
				entertainment.setEntermark(resultSet.getString(6));
				entertainment.setEnterresource(resultSet.getString(7));
				entertainment.setUid(resultSet.getInt(8));
				// 6銆佽繑鍥炵粨鏋�
				return entertainment;
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}

	@Override
	public int update(Entertainments entertainment) {
		// TODO Auto-generated method stub
		// 1銆佽幏鍙栬繛鎺ュ璞�
		this.conn = this.connectionManager.openConnection();
		// 2銆佸紑鍚簨鍔�
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 3銆丼QL妯℃澘
		String strSQL = "update entertainments set posttime=?, entername=?, entertype=?, enterstate=?, entermark=?, enterresource=?, uid=? where enterid=?";
		Object[] params = new Object[] {entertainment.getPosttime(),entertainment.getEntername(), entertainment.getEntertype(), entertainment.getEnterstate(), entertainment.getEntermark(), entertainment.getEnterresource(), entertainment.getUid(),entertainment.getEnterid() };
		// 4銆佸畬鎴愯窡鏂�
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		// 5銆佹彁浜ゆ垨鍥炴粴
		if (affectedRows > 0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public List<Entertainments> selectByName(String entername) {
		// TODO Auto-generated method stub
		// 1銆佺┖闆嗗悎瀛樻斁鏌ヨ缁撴灉
		List<Entertainments> lstEntertainments = new ArrayList<Entertainments>();
		// 2銆佽幏鍙栨暟鎹簱杩炴帴
		this.conn = connectionManager.openConnection();
		// 3銆丼QL妯℃澘
		String strSQL = "select * from entertainments where entername like '%" + entername + "%'";
		// 4銆佸疄鐜版煡璇�
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,
				new Object[] {});
		// resultSet缁撴灉闆嗚浆鍖朙ist
		try {
			while (resultSet.next()) {
				Entertainments entertainment = new Entertainments();
				entertainment.setEnterid(resultSet.getInt(1));
				entertainment.setPosttime(resultSet.getDate(2));
				entertainment.setEntername(resultSet.getString(3));
				entertainment.setEntertype(resultSet.getString(4));
				entertainment.setEnterstate(resultSet.getInt(5));
				entertainment.setEntermark(resultSet.getString(6));
				entertainment.setEnterresource(resultSet.getString(7));
				entertainment.setUid(resultSet.getInt(8));
				lstEntertainments.add(entertainment);
			}
			return lstEntertainments;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}
}
