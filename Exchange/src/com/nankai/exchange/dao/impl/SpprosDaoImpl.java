package com.nankai.exchange.dao.impl;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nankai.exchange.dao.ISpprosDao;
import com.nankai.exchange.db.ConnectionManager;
import com.nankai.exchange.db.DBUtils;
import com.nankai.exchange.db.TransactionManager;
import com.nankai.exchange.po.Sppros;


public class SpprosDaoImpl implements ISpprosDao {

	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;
	
	public SpprosDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}

	@Override
	public int insert(Sppros sppro) {
		// TODO Auto-generated method stub
		//1銆佽幏鍙栨暟鎹簱杩炴帴
		this.conn = this.connectionManager.openConnection();
		//2銆佸紑鍚簨鍔�
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		//3銆佹媶鍒嗗睘鎬�
		String spname = sppro.getSpname();
		String sptype = sppro.getSptype();
		String splocation = sppro.getSplocation();
		int spstate = sppro.getSpstate();
		String spmark = sppro.getSpmark();
		String spresource = sppro.getSpresource();
		int uid = sppro.getUid();
		//4銆丼QL妯℃澘
		String strSQL = "insert into sppros values(null, ?, ?, now(), ?, ?, ?, ?, ?)";
		Object[] params = new Object[]{spname, sptype, splocation, spstate, spmark, spresource, uid};
		//5銆佸疄鐜版坊鍔犳暟鎹�
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		//6銆佹彁浜や簨鍔�
		if (affectedRows > 0) {
			//鎻愪氦
			TransactionManager.commit();
		}else {
			//鍥炴粴
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public List<Sppros> selectAll() {
		// TODO Auto-generated method stub
		//1銆佺┖闆嗗悎瀛樻斁鏌ヨ缁撴灉
		List<Sppros> lstSppros = new ArrayList<Sppros>();
		//2銆佽幏鍙栨暟鎹簱杩炴帴
		this.conn = connectionManager.openConnection();
		//3銆丼QL妯℃澘
		String strSQL = "select * from sppros order by spid";
		//4銆佸疄鐜版煡璇�
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, new Object[]{});
		//resultSet缁撴灉闆嗚浆鍖朙ist
		try {
			while (resultSet.next()) {
				Sppros sppro = new Sppros();
				sppro.setSpid(resultSet.getInt(1));
				sppro.setSpname(resultSet.getString(2));
				sppro.setSptype(resultSet.getString(3));
				sppro.setPosttime(resultSet.getDate(4));
				sppro.setSplocation(resultSet.getString(5));
				sppro.setSpstate(resultSet.getInt(6));
				sppro.setSpmark(resultSet.getString(7));
				sppro.setSpresource(resultSet.getString(8));
				sppro.setUid(resultSet.getInt(9));
				lstSppros.add(sppro);
			}
			return lstSppros;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}	
	}

	@Override
	public int deleteById(int spid) {
		// TODO Auto-generated method stub
		//1銆佽幏鍙栬繛鎺ュ璞�
		this.conn = this.connectionManager.openConnection();
		//2銆佸紑鍚簨鍔�
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		//3銆丼QL妯℃澘
		String strSQL = "delete from sppros where spid = ?";
		Object[] params = new Object[]{ spid };
		//4銆佸畬鎴愬垹闄�
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		//5銆佹彁浜ゆ垨鍥炴粴
		if (affectedRows > 0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public Sppros selectById(int spid) {
		// TODO Auto-generated method stub
		//1銆佽幏鍙栬繛鎺ュ璞�
		this.conn = this.connectionManager.openConnection();
		//2銆丼QL妯℃澘
		String strSQL = "select * from sppros where spid = ?";
		Object[] params = new Object[]{ spid };
		//3銆佸畬鎴愭煡鎵�
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		//4銆佽幏鍙栥�灏佽
		try {
			if (resultSet.next()) {
				//5銆佸垱寤哄璞″苟灏佽
				Sppros sppro = new Sppros();
				sppro.setSpid(resultSet.getInt(1));
				sppro.setSpname(resultSet.getString(2));
				sppro.setSptype(resultSet.getString(3));
				sppro.setPosttime(resultSet.getDate(4));
				sppro.setSplocation(resultSet.getString(5));
				sppro.setSpstate(resultSet.getInt(6));
				sppro.setSpmark(resultSet.getString(7));
				sppro.setSpresource(resultSet.getString(8));
				sppro.setUid(resultSet.getInt(9));
				//6銆佽繑鍥炵粨鏋�
				return sppro;
			} else{
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
	public int update(Sppros sppro) {
		// TODO Auto-generated method stub
		//1銆佽幏鍙栬繛鎺ュ璞�
		this.conn = this.connectionManager.openConnection();
		//2銆佸紑鍚簨鍔�
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		//3銆丼QL妯℃澘
		String strSQL = "update sppros set spname=?, sptype=?, posttime=?, splocation=?, spstate=?, spmark=?, spresource=?, uid=? where spid = ?";
		Object[] params = new Object[]{sppro.getSpname(), sppro.getSptype(), sppro.getSplocation(), sppro.getSpstate(), sppro.getSpmark(), sppro.getSpresource(), sppro.getUid(), sppro.getSpid()};
		//4銆佸畬鎴愯窡鏂�
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		//5銆佹彁浜ゆ垨鍥炴粴
		if (affectedRows > 0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback();
		}		
		return affectedRows;
	}

	@Override
	public List<Sppros> selectByName(String spname) {
		// TODO Auto-generated method stub
		// 1銆佺┖闆嗗悎瀛樻斁鏌ヨ缁撴灉
		List<Sppros> lstSppros = new ArrayList<Sppros>();
		// 2銆佽幏鍙栬繛鎺ュ璞�
		this.conn = this.connectionManager.openConnection();
		// 3銆丼QL妯℃澘
		String strSQL = "select * from sppros where spname like '%" + spname + "%'";
		Object[] params = new Object[] { spname };
		// 4銆佸畬鎴愭煡鎵�
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		// 5銆佽幏鍙栥�灏佽
		try {
			if (resultSet.next()) {
				// 6銆佸垱寤哄璞″苟灏佽
				Sppros sppro = new Sppros();
				sppro.setSpid(resultSet.getInt(1));
				sppro.setSpname(resultSet.getString(2));
				sppro.setSptype(resultSet.getString(3));
				sppro.setPosttime(resultSet.getDate(4));
				sppro.setSplocation(resultSet.getString(5));
				sppro.setSpstate(resultSet.getInt(6));
				sppro.setSpmark(resultSet.getString(7));
				sppro.setSpresource(resultSet.getString(8));
				sppro.setUid(resultSet.getInt(9));
				lstSppros.add(sppro);
				// 7銆佽繑鍥炵粨鏋�
				return lstSppros;
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
}
