package com.nankai.exchange.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nankai.exchange.dao.ICosmeticsDao;
import com.nankai.exchange.db.ConnectionManager;
import com.nankai.exchange.db.DBUtils;
import com.nankai.exchange.db.TransactionManager;
import com.nankai.exchange.po.Cosmetics;

public class CosmeticsDaoImpl implements ICosmeticsDao {

	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;
	
	public CosmeticsDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}

	@Override
	public int insert(Cosmetics cosmetic) {
		// TODO Auto-generated method stub
		// 1銆佽幏鍙栨暟鎹簱杩炴帴
		this.conn = this.connectionManager.openConnection();
		// 2銆佸紑鍚簨鍔�
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 3銆佹媶鍒嗗睘鎬�
		String cosname = cosmetic.getCosname();
		int cosstate = cosmetic.getCosstate();
		String cosbrand = cosmetic.getCosbrand();
		String cosmark = cosmetic.getCosmark();
		String cosresource = cosmetic.getCosresource();
		String costype = cosmetic.getCostype();
		int uid = cosmetic.getUid();
		// 4銆丼QL妯℃澘
		String strSQL = "insert into cosmetics values(null, now(), ?, ?, ?, ?, ?, ?, ?)";
		Object[] params = new Object[] { cosname, cosstate, cosbrand, cosmark, cosresource, costype, uid };
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
	public List<Cosmetics> selectAll() {
		// TODO Auto-generated method stub
		// 1銆佺┖闆嗗悎瀛樻斁鏌ヨ缁撴灉
		List<Cosmetics> lstCosmetics = new ArrayList<Cosmetics>();
		// 2銆佽幏鍙栨暟鎹簱杩炴帴
		this.conn = connectionManager.openConnection();
		// 3銆丼QL妯℃澘
		String strSQL = "select * from cosmetics order by cosid";
		// 4銆佸疄鐜版煡璇�
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, new Object[] {});
		// resultSet缁撴灉闆嗚浆鍖朙ist
		try {
			while (resultSet.next()) {
				Cosmetics cosmetic = new Cosmetics();
				cosmetic.setCosid(resultSet.getInt(1));
				cosmetic.setPosttime(resultSet.getDate(2));
				cosmetic.setCosname(resultSet.getString(3));
				cosmetic.setCosstate(resultSet.getInt(4));
				cosmetic.setCosbrand(resultSet.getString(5));
				cosmetic.setCosmark(resultSet.getString(6));
				cosmetic.setCosresource(resultSet.getString(7));
				cosmetic.setCostype(resultSet.getString(8));
				cosmetic.setUid(resultSet.getInt(9));
				lstCosmetics.add(cosmetic);
			}
			return lstCosmetics;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}

	@Override
	public int deleteById(int cosid) {
		// TODO Auto-generated method stub
		// 1銆佽幏鍙栬繛鎺ュ璞�
		this.conn = this.connectionManager.openConnection();
		// 2銆佸紑鍚簨鍔�
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 3銆丼QL妯℃澘
		String strSQL = "delete from cosmetics where cosid = ?";
		Object[] params = new Object[] { cosid };
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
	public Cosmetics selectById(int cosid) {
		// TODO Auto-generated method stub
		// 1銆佽幏鍙栬繛鎺ュ璞�
		this.conn = this.connectionManager.openConnection();
		// 2銆丼QL妯℃澘
		String strSQL = "select * from cosmetics where cosid = ?";
		Object[] params = new Object[] { cosid };
		// 3銆佸畬鎴愭煡鎵�
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		// 4銆佽幏鍙栥�灏佽
		try {
			if (resultSet.next()) {
				// 5銆佸垱寤哄璞″苟灏佽
				Cosmetics cosmetic = new Cosmetics();
				cosmetic.setCosid(resultSet.getInt(1));
				cosmetic.setPosttime(resultSet.getDate(2));
				cosmetic.setCosname(resultSet.getString(3));
				cosmetic.setCosstate(resultSet.getInt(4));
				cosmetic.setCosbrand(resultSet.getString(5));
				cosmetic.setCosmark(resultSet.getString(6));
				cosmetic.setCosresource(resultSet.getString(7));
				cosmetic.setCostype(resultSet.getString(8));
				cosmetic.setUid(resultSet.getInt(9));
				// 6銆佽繑鍥炵粨鏋�
				return cosmetic;
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
	public int update(Cosmetics cosmetic) {
		// TODO Auto-generated method stub
		// 1銆佽幏鍙栬繛鎺ュ璞�
		this.conn = this.connectionManager.openConnection();
		// 2銆佸紑鍚簨鍔�
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 3銆丼QL妯℃澘
		String strSQL = "update cosmetics set posttime=?, cosname=?, cosstate=?, cosbrand=?, cosmark=?, cosresource=?, costype=?, uid=? where cosid = ?";
		Object[] params = new Object[] { cosmetic.getPosttime(),cosmetic.getCosname(), cosmetic.getCosstate(), cosmetic.getCosbrand(), cosmetic.getCosmark(), cosmetic.getCosresource(), cosmetic.getCostype(), cosmetic.getUid(), cosmetic.getCosid()};
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
	public List<Cosmetics> selectByName(String cosname) {
		// TODO Auto-generated method stub
		// 1銆佺┖闆嗗悎瀛樻斁鏌ヨ缁撴灉
		List<Cosmetics> lstCosmetics = new ArrayList<Cosmetics>();
		// 2銆佽幏鍙栨暟鎹簱杩炴帴
		this.conn = connectionManager.openConnection();
		// 3銆丼QL妯℃澘
		String strSQL = "select * from cosmetics where cosname like '%" + cosname + "%'";
		// 4銆佸疄鐜版煡璇�
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,
				new Object[] {});
		// resultSet缁撴灉闆嗚浆鍖朙ist
		try {
			while (resultSet.next()) {
				Cosmetics cosmetic = new Cosmetics();
				cosmetic.setCosid(resultSet.getInt(1));
				cosmetic.setPosttime(resultSet.getDate(2));
				cosmetic.setCosname(resultSet.getString(3));
				cosmetic.setCosstate(resultSet.getInt(4));
				cosmetic.setCosbrand(resultSet.getString(5));
				cosmetic.setCosmark(resultSet.getString(6));
				cosmetic.setCosresource(resultSet.getString(7));
				cosmetic.setCostype(resultSet.getString(8));
				cosmetic.setUid(resultSet.getInt(9));
				lstCosmetics.add(cosmetic);
			}
			return lstCosmetics;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}
}
