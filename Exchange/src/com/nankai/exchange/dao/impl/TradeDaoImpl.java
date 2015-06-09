package com.nankai.exchange.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nankai.exchange.dao.ITradeDao;
import com.nankai.exchange.db.ConnectionManager;
import com.nankai.exchange.db.DBUtils;
import com.nankai.exchange.db.TransactionManager;
import com.nankai.exchange.po.Trade;

@SuppressWarnings("unused")
public class TradeDaoImpl implements ITradeDao {
	
	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;

	public TradeDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}

	@Override
	public int insert(Trade trade) {
		// TODO Auto-generated method stub
		// 获取连接
		this.conn = connectionManager.openConnection();
		// 开启事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 拆分属性
		//int traid = trade.getTraid();
		int userid1 = trade.getUserid1();
		int userid2 = trade.getUserid2();
		//Date tratime = trade.getTratime();
		int type1id1 = trade.getType1id1();
		int type1id2 = trade.getType1id2();
		int type2id1 = trade.getType2id1();
		int type2id2 = trade.getType2id2();
		String traresource = trade.getTraresource();
		// SQL语句
		String strSQL = "insert into trade values(null, ?, ?, now(), ?, ?, ?, ?, ?)";
		Object[] params = new Object[]{userid1, userid2, type1id1, type1id2, type2id1, type2id2, traresource};
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
	public int deleteById(int traid) {
		// TODO Auto-generated method stub
		// 获取连接
		this.conn = connectionManager.openConnection();
		// 开启事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// SQL语句
		String strSQL = "delete from trade where traid = ?";
		Object[] params = new Object[]{traid};
		// 执行
		int affectedRows = dbUtils.execOthers(conn, strSQL, params);
		if(affectedRows > 0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public int update(Trade trade) {
		// TODO Auto-generated method stub
		// 获取连接
		this.conn = connectionManager.openConnection();
		// 开启事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 拆分属性
		int traid = trade.getTraid();
		int userid1 = trade.getUserid1();
		int userid2 = trade.getUserid2();
		//Date tratime = trade.getTratime();
		int type1id1 = trade.getType1id1();
		int type1id2 = trade.getType1id2();
		int type2id1 = trade.getType2id1();
		int type2id2 = trade.getType2id2();
		String traresource = trade.getTraresource();
		// SQL语句
		String strSQL = "update trade set userid1 = ?, userid2 = ?, tratime = now(), type1id1 = ?, type1id2 = ?, type2id1 = ?, type2id2 = ?, traresource = ? where traid = ?";
		Object[] params = new Object[]{userid1, userid2, type1id1, type1id2, type2id1, type2id2, traresource, traid};
		// 执行
		int affectedRows = dbUtils.execOthers(conn, strSQL, params);
		if(affectedRows > 0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public List<Trade> selectAll() {
		// TODO Auto-generated method stub
		// 准备List
		List<Trade> lstTrades = new ArrayList<Trade>();
		// 获取连接
		this.conn = connectionManager.openConnection();
		// SQL语句
		String strSQL = "select * from trade";
		// 执行
		ResultSet resultSet = dbUtils.execQuery(conn, strSQL, new Object[]{});
		
		try {
			while(resultSet.next()) {
				Trade trade = new Trade();
				trade.setTraid(resultSet.getInt(1));
				trade.setUserid1(resultSet.getInt(2));
				trade.setUserid2(resultSet.getInt(3));
				trade.setTratime(resultSet.getDate(4));
				trade.setType1id1(resultSet.getInt(5));
				trade.setType1id2(resultSet.getInt(6));
				trade.setType2id1(resultSet.getInt(7));
				trade.setType2id2(resultSet.getInt(8));
				trade.setTraresource(resultSet.getString(9));
				lstTrades.add(trade);
			}
			return lstTrades;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			connectionManager.closeConnection(conn);
		}
	}

	@Override
	public Trade selectById(int traid) {
		// TODO Auto-generated method stub
		// 准备Trade
		Trade trade = new Trade();
		// 获取连接
		this.conn = connectionManager.openConnection();
		// SQL语句
		String strSQL = "select * from trade where traid = ?";
		Object[] params = new Object[]{traid};
		// 执行
		ResultSet resultSet = dbUtils.execQuery(conn, strSQL, params);
		
		try {
			if(resultSet.next()) {
				trade.setTraid(resultSet.getInt(1));
				trade.setUserid1(resultSet.getInt(2));
				trade.setUserid2(resultSet.getInt(3));
				trade.setTratime(resultSet.getDate(4));
				trade.setType1id1(resultSet.getInt(5));
				trade.setType1id2(resultSet.getInt(6));
				trade.setType2id1(resultSet.getInt(7));
				trade.setType2id2(resultSet.getInt(8));
				trade.setTraresource(resultSet.getString(9));
				return trade;
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
	public List<Trade> selectUserId(int userid1) {
		// TODO Auto-generated method stub
		// 准备List
		List<Trade> lstTrades = new ArrayList<Trade>();
		// 获取连接
		this.conn = connectionManager.openConnection();
		// SQL语句
		String strSQL = "select * from trade where userid1=" + userid1;
		// 执行
		ResultSet resultSet = dbUtils.execQuery(conn, strSQL, new Object[] {});

		try {
			while (resultSet.next()) {
				Trade trade = new Trade();
				trade.setTraid(resultSet.getInt(1));
				trade.setUserid1(resultSet.getInt(2));
				trade.setUserid2(resultSet.getInt(3));
				trade.setTratime(resultSet.getDate(4));
				trade.setType1id1(resultSet.getInt(5));
				trade.setType1id2(resultSet.getInt(6));
				trade.setType2id1(resultSet.getInt(7));
				trade.setType2id2(resultSet.getInt(8));
				trade.setTraresource(resultSet.getString(9));
				lstTrades.add(trade);
			}
			return lstTrades;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			connectionManager.closeConnection(conn);
		}
	}

}
