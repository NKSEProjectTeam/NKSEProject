package com.nankai.exchange.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nankai.exchange.dao.IHireDao;
import com.nankai.exchange.db.ConnectionManager;
import com.nankai.exchange.db.DBUtils;
import com.nankai.exchange.db.TransactionManager;
import com.nankai.exchange.po.Hire;

@SuppressWarnings("unused")
public class HireDaoImpl implements IHireDao {

	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;
	
	public HireDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}

	@Override
	public int insert(Hire hire) {
		// TODO Auto-generated method stub
		// 获取连接
		this.conn = connectionManager.openConnection();
		// 开启事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 拆分属性
		//int hireid = hire.getHireid();
		int userid1 = hire.getUserid1();
		int userid2 = hire.getUserid2();
		//Date hiretime = hire.getHiretime();
		int typeid1 = hire.getTypeid1();
		int typeid2 = hire.getTypeid2();
		String hireresource = hire.getHireresource();
		// SQL语句
		String strSQL = "insert into hire values(null, ?, ?, now(), ?, ?, ?)";
		Object[] params = new Object[]{userid1, userid2, typeid1, typeid2, hireresource};
		// 执行
		int affectedRows = dbUtils.execOthers(conn, strSQL, params);
		// 提交或回滚
		if(affectedRows > 0 ) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public int deleteById(int hireid) {
		// TODO Auto-generated method stub
		// 获取连接
		this.conn = connectionManager.openConnection();
		// 开启事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		//SQL语句
		String strSQL = "delete from hire where hireid = ?";
		Object[] params = new Object[]{hireid};
		// 执行
		int affectedRows = dbUtils.execOthers(conn, strSQL, params);
		// 提交或回滚
		if(affectedRows > 0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public int update(Hire hire) {
		// TODO Auto-generated method stub
		// 获取连接
		this.conn = connectionManager.openConnection();
		// 开启事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 拆分属性
		int hireid = hire.getHireid();
		int userid1 = hire.getUserid1();
		int userid2 = hire.getUserid2();
		//Date hiretime = hire.getHiretime();
		int typeid1 = hire.getTypeid1();
		int typeid2 = hire.getTypeid2();
		String hireresource = hire.getHireresource();
		// SQL语句
		String strSQL = "update hire set userid1 = ?, userid2 = ?, hiretime = now(), typeid1 = ?, typeid2 = ?, hireresource = ? where hireid = ?";
		Object[] params = new Object[]{userid1, userid2, typeid1, typeid2, hireresource, hireid};
		// 执行
		int affectedRows = dbUtils.execOthers(conn, strSQL, params);
		// 提交或回滚
		if(affectedRows > 0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public List<Hire> selectAll() {
		// TODO Auto-generated method stub
		// 准备List
		List<Hire> lstHires = new ArrayList<Hire>();
		// 获取连接
		this.conn = connectionManager.openConnection();
		// SQL语句
		String strSQL = "select * from hire";
		// 执行
		ResultSet resultSet = dbUtils.execQuery(conn, strSQL, new Object[]{});
		
		try {
			while(resultSet.next()) {
				Hire hire = new Hire();
				hire.setHireid(resultSet.getInt(1));
				hire.setUserid1(resultSet.getInt(2));
				hire.setUserid2(resultSet.getInt(3));
				hire.setHiretime(resultSet.getDate(4));
				hire.setTypeid1(resultSet.getInt(5));
				hire.setTypeid2(resultSet.getInt(6));
				hire.setHireresource(resultSet.getString(7));
				lstHires.add(hire);
			}
			return lstHires;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			connectionManager.closeConnection(conn);
		}
	}

	@Override
	public Hire selectById(int hireid) {
		// TODO Auto-generated method stub
		// 准备Hire
		Hire hire = new Hire();
		// 获取连接
		this.conn = connectionManager.openConnection();
		// SQL语句
		String strSQL = "select * from hire where hireid = ?";
		Object[] params = new Object[]{hireid};
		// 执行
		ResultSet resultSet = dbUtils.execQuery(conn, strSQL, params);
		
		try {
			if(resultSet.next()) {
				hire.setHireid(resultSet.getInt(1));
				hire.setUserid1(resultSet.getInt(2));
				hire.setUserid2(resultSet.getInt(3));
				hire.setHiretime(resultSet.getDate(4));
				hire.setTypeid1(resultSet.getInt(5));
				hire.setTypeid2(resultSet.getInt(6));
				hire.setHireresource(resultSet.getString(7));
				return hire;
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			connectionManager.closeConnection(conn);
		}
	}

	@Override
	public List<Hire> selectUserId(int userid) {
		// TODO Auto-generated method stub
		// 准备List
		List<Hire> lstHires = new ArrayList<Hire>();
		// 获取连接
		this.conn = connectionManager.openConnection();
		// SQL语句
		String strSQL = "select * from hire where userid1 = ?";
		Object[] params = new Object[]{userid};
		// 执行
		ResultSet resultSet = dbUtils.execQuery(conn, strSQL, params);

		try {
			while (resultSet.next()) {
				Hire hire = new Hire();
				hire.setHireid(resultSet.getInt(1));
				hire.setUserid1(resultSet.getInt(2));
				hire.setUserid2(resultSet.getInt(3));
				hire.setHiretime(resultSet.getDate(4));
				hire.setTypeid1(resultSet.getInt(5));
				hire.setTypeid2(resultSet.getInt(6));
				hire.setHireresource(resultSet.getString(7));
				lstHires.add(hire);
			}
			return lstHires;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			connectionManager.closeConnection(conn);
		}
	}

}
