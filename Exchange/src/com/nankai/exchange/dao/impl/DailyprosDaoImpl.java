package com.nankai.exchange.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nankai.exchange.dao.IDailyprosDao;
import com.nankai.exchange.db.ConnectionManager;
import com.nankai.exchange.db.DBUtils;
import com.nankai.exchange.db.TransactionManager;
import com.nankai.exchange.po.Dailypros;

public class DailyprosDaoImpl implements IDailyprosDao {

	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;
	
	public DailyprosDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}

	@Override
	public int insert(Dailypros dailypro) {
		// TODO Auto-generated method stub
		// 1銆佽幏鍙栨暟鎹簱杩炴帴
		this.conn = this.connectionManager.openConnection();
		// 2銆佸紑鍚簨鍔�
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 3銆佹媶鍒嗗睘鎬�
		String dpname = dailypro.getDpname();
		String dptype = dailypro.getDptype();
		int dpstate = dailypro.getDpstate();
		String dpmark = dailypro.getDpmark();
		String dpresource = dailypro.getDpresource();
		int uid = dailypro.getUid();
		// 4銆丼QL妯℃澘
		String strSQL = "insert into dailypros values(null, ?, ?, now(), ?, ?, ?, ?)";
		Object[] params = new Object[] { dpname, dptype, dpstate, dpmark, dpresource, uid};
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
	public List<Dailypros> selectAll() {
		// TODO Auto-generated method stub
		// 1銆佺┖闆嗗悎瀛樻斁鏌ヨ缁撴灉
		List<Dailypros> lstDailypros = new ArrayList<Dailypros>();
		// 2銆佽幏鍙栨暟鎹簱杩炴帴
		this.conn = connectionManager.openConnection();
		// 3銆丼QL妯℃澘
		String strSQL = "select * from dailypros order by dpid";
		// 4銆佸疄鐜版煡璇�
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, new Object[] {});
		// resultSet缁撴灉闆嗚浆鍖朙ist
		try {
			while (resultSet.next()) {
				Dailypros dailypro = new Dailypros();
				dailypro.setDpid(resultSet.getInt(1));
				dailypro.setDpname(resultSet.getString(2));
				dailypro.setDptype(resultSet.getString(3));
				dailypro.setPosttime(resultSet.getDate(4));
				dailypro.setDpstate(resultSet.getInt(5));
				dailypro.setDpmark(resultSet.getString(6));
				dailypro.setDpresource(resultSet.getString(7));
				dailypro.setUid(resultSet.getInt(8));
				lstDailypros.add(dailypro);
			}
			return lstDailypros;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}

	@Override
	public int deleteById(int dpid) {
		// TODO Auto-generated method stub
		// 1銆佽幏鍙栬繛鎺ュ璞�
		this.conn = this.connectionManager.openConnection();
		// 2銆佸紑鍚簨鍔�
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 3銆丼QL妯℃澘
		String strSQL = "delete from dailypros where dpid = ?";
		Object[] params = new Object[] { dpid };
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
	public Dailypros selectById(int dpid) {
		// TODO Auto-generated method stub
		// 1銆佽幏鍙栬繛鎺ュ璞�
		this.conn = this.connectionManager.openConnection();
		// 2銆丼QL妯℃澘
		String strSQL = "select * from dailypros where dpid = ?";
		Object[] params = new Object[] { dpid };
		// 3銆佸畬鎴愭煡鎵�
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		// 4銆佽幏鍙栥�灏佽
		try {
			if (resultSet.next()) {
				// 5銆佸垱寤哄璞″苟灏佽
				Dailypros dailypro = new Dailypros();
				dailypro.setDpid(resultSet.getInt(1));
				dailypro.setDpname(resultSet.getString(2));
				dailypro.setDptype(resultSet.getString(3));
				dailypro.setPosttime(resultSet.getDate(4));
				dailypro.setDpstate(resultSet.getInt(5));
				dailypro.setDpmark(resultSet.getString(6));
				dailypro.setDpresource(resultSet.getString(7));
				dailypro.setUid(resultSet.getInt(8));
				// 6銆佽繑鍥炵粨鏋�
				return dailypro;
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
	public int update(Dailypros dailypro) {
		// TODO Auto-generated method stub
		// 1銆佽幏鍙栬繛鎺ュ璞�
		this.conn = this.connectionManager.openConnection();
		// 2銆佸紑鍚簨鍔�
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 3銆丼QL妯℃澘
		String strSQL = "update dailypros set dpname=?, dptype=?, posttime=?, dpstate=?, dpmark=?, dpresource=?, uid=? where dpid=?";
		Object[] params = new Object[] { dailypro.getDpname(), dailypro.getDptype(),dailypro.getPosttime(), dailypro.getDpstate(), dailypro.getDpmark(), dailypro.getDpresource(), dailypro.getUid(),dailypro.getDpid()};
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
	public List<Dailypros> selectByName(String dpname) {
		// TODO Auto-generated method stub
		// 1銆佺┖闆嗗悎瀛樻斁鏌ヨ缁撴灉
		List<Dailypros> lstDailypros = new ArrayList<Dailypros>();
		// 2銆佽幏鍙栨暟鎹簱杩炴帴
		this.conn = connectionManager.openConnection();
		// 3銆丼QL妯℃澘
		String strSQL = "select * from dailypros where dpname like '%" + dpname + "%'";
		// 4銆佸疄鐜版煡璇�
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,
				new Object[] {});
		// resultSet缁撴灉闆嗚浆鍖朙ist
		try {
			while (resultSet.next()) {
				Dailypros dailypro = new Dailypros();
				dailypro.setDpid(resultSet.getInt(1));
				dailypro.setDpname(resultSet.getString(2));
				dailypro.setDptype(resultSet.getString(3));
				dailypro.setPosttime(resultSet.getDate(4));
				dailypro.setDpstate(resultSet.getInt(5));
				dailypro.setDpmark(resultSet.getString(6));
				dailypro.setDpresource(resultSet.getString(7));
				dailypro.setUid(resultSet.getInt(8));
				lstDailypros.add(dailypro);
			}
			return lstDailypros;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}
}

