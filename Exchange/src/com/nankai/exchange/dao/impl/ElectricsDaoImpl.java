package com.nankai.exchange.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nankai.exchange.dao.IElectricsDao;
import com.nankai.exchange.db.ConnectionManager;
import com.nankai.exchange.db.DBUtils;
import com.nankai.exchange.db.TransactionManager;
import com.nankai.exchange.po.Electrics;

public class ElectricsDaoImpl implements IElectricsDao {

	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;
	
	public ElectricsDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}

	@Override
	public int insert(Electrics electric) {
		// TODO Auto-generated method stub
		// 1銆佽幏鍙栨暟鎹簱杩炴帴
		this.conn = this.connectionManager.openConnection();
		// 2銆佸紑鍚簨鍔�
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 3銆佹媶鍒嗗睘鎬�
		String elename = electric.getElename();
		String eletype = electric.getEletype();
		int elestate = electric.getElestate();
		String elemark = electric.getElemark();
		String eleresource = electric.getEleresource();
		int uid = electric.getUid();
		// 4銆丼QL妯℃澘
		String strSQL = "insert into electrics values(null, now(), ?, ?, ?, ?, ?, ?)";
		Object[] params = new Object[] { elename, eletype, elestate, elemark, eleresource, uid, };
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
	public List<Electrics> selectAll() {
		// TODO Auto-generated method stub
		// 1銆佺┖闆嗗悎瀛樻斁鏌ヨ缁撴灉
		List<Electrics> lstElectrics = new ArrayList<Electrics>();
		// 2銆佽幏鍙栨暟鎹簱杩炴帴
		this.conn = connectionManager.openConnection();
		// 3銆丼QL妯℃澘
		String strSQL = "select * from electrics order by eleid";
		// 4銆佸疄鐜版煡璇�
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, new Object[] {});
		// resultSet缁撴灉闆嗚浆鍖朙ist
		try {
			while (resultSet.next()) {
				Electrics electrics = new Electrics();
				electrics.setEleid(resultSet.getInt(1));
				electrics.setPosttime(resultSet.getDate(2));
				electrics.setElename(resultSet.getString(3));
				electrics.setEletype(resultSet.getString(4));
				electrics.setElestate(resultSet.getInt(5));
				electrics.setElemark(resultSet.getString(6));
				electrics.setEleresource(resultSet.getString(7));
				electrics.setUid(resultSet.getInt(8));
				lstElectrics.add(electrics);
			}
			return lstElectrics;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}

	@Override
	public int deleteById(int eleid) {
		// TODO Auto-generated method stub
		// 1銆佽幏鍙栬繛鎺ュ璞�
		this.conn = this.connectionManager.openConnection();
		// 2銆佸紑鍚簨鍔�
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 3銆丼QL妯℃澘
		String strSQL = "delete from electrics where eleid = ?";
		Object[] params = new Object[] { eleid };
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
	public Electrics selectById(int eleid) {
		// TODO Auto-generated method stub
		// 1銆佽幏鍙栬繛鎺ュ璞�
		this.conn = this.connectionManager.openConnection();
		// 2銆丼QL妯℃澘
		String strSQL = "select * from electrics where eleid = ?";
		Object[] params = new Object[] { eleid };
		// 3銆佸畬鎴愭煡鎵�
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		// 4銆佽幏鍙栥�灏佽
		try {
			if (resultSet.next()) {
				// 5銆佸垱寤哄璞″苟灏佽
				Electrics electrics = new Electrics();
				electrics.setEleid(resultSet.getInt(1));
				electrics.setPosttime(resultSet.getDate(2));
				electrics.setElename(resultSet.getString(3));
				electrics.setEletype(resultSet.getString(4));
				electrics.setElestate(resultSet.getInt(5));
				electrics.setElemark(resultSet.getString(6));
				electrics.setEleresource(resultSet.getString(7));
				electrics.setUid(resultSet.getInt(8));
				// 6銆佽繑鍥炵粨鏋�
				return electrics;
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
	public int update(Electrics electric) {
		// TODO Auto-generated method stub
		// 1銆佽幏鍙栬繛鎺ュ璞�
		this.conn = this.connectionManager.openConnection();
		// 2銆佸紑鍚簨鍔�
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 3銆丼QL妯℃澘
		String strSQL = "update electrics set posttime=?, elename=?, eletype=?, elestate=?, elemark=?, eleresource=?, uid=? where eleid = ?";
		Object[] params = new Object[] {electric.getPosttime(), electric.getElename(), electric.getEletype(), electric.getElestate(), electric.getElemark(), electric.getEleresource(), electric.getUid(), electric.getEleid() };
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
	public List<Electrics> selectByName(String elename) {
		// TODO Auto-generated method stub
		// 1銆佺┖闆嗗悎瀛樻斁鏌ヨ缁撴灉
		List<Electrics> lstElectrics = new ArrayList<Electrics>();
		// 2銆佽幏鍙栨暟鎹簱杩炴帴
		this.conn = connectionManager.openConnection();
		// 3銆丼QL妯℃澘
		String strSQL = "select * from electrics where elename like '%" + elename + "%'";
		// 4銆佸疄鐜版煡璇�
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,
				new Object[] {});
		// resultSet缁撴灉闆嗚浆鍖朙ist
		try {
			while (resultSet.next()) {
				Electrics electrics = new Electrics();
				electrics.setEleid(resultSet.getInt(1));
				electrics.setPosttime(resultSet.getDate(2));
				electrics.setElename(resultSet.getString(3));
				electrics.setEletype(resultSet.getString(4));
				electrics.setElestate(resultSet.getInt(5));
				electrics.setElemark(resultSet.getString(6));
				electrics.setEleresource(resultSet.getString(7));
				electrics.setUid(resultSet.getInt(8));
				lstElectrics.add(electrics);
			}
			return lstElectrics;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}

}
