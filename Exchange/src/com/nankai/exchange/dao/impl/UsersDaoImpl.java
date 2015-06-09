package com.nankai.exchange.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nankai.exchange.dao.IUsersDao;
import com.nankai.exchange.db.ConnectionManager;
import com.nankai.exchange.db.DBUtils;
import com.nankai.exchange.db.TransactionManager;
import com.nankai.exchange.po.Users;

@SuppressWarnings("unused")
public class UsersDaoImpl implements IUsersDao {

	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;
	
	public UsersDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}

	@Override
	public int insert(Users user) {
		// TODO Auto-generated method stub
		// 获取连接
		this.conn = connectionManager.openConnection();
		// 开启事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 拆分属性
		//int userid = user.getUserid();
		String username = user.getUsername();
		String userpwd = user.getUserpwd();
		String usernum = user.getUsernum();
		String usermail = user.getUsermail();
		int sex = user.getSex();
		//Date regtime = user.getRegtime();
		int score = user.getScore();
		String resource = user.getResource();
		String mark = user.getMark();
		// SQL语句
		String strSQL = "insert into users values(null, ?, ?, ?, ?, ?, now(), ?, ?, ?)";
		Object[] params = new Object[]{username, userpwd, usernum, usermail, sex, score, resource, mark};
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
	public int deleteById(int userid) {
		// TODO Auto-generated method stub
		// 获取连接
		this.conn = connectionManager.openConnection();
		// 开启事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// SQL语句
		String strSQL = "delete from users where userid = ?";
		Object[] params = new Object[]{userid};
		// 执行
		int affectedRows = dbUtils.execOthers(conn, strSQL, params);
		// 提交会回滚
		if(affectedRows > 0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public int update(Users user) {
		// TODO Auto-generated method stub
		// 获取连接
		this.conn = connectionManager.openConnection();
		// 开启事务
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		// 拆分属性
		int userid = user.getUserid();
		String username = user.getUsername();
		String userpwd = user.getUserpwd();
		String usernum = user.getUsernum();
		String usermail = user.getUsermail();
		int sex = user.getSex();
		//Date regtime = user.getRegtime();
		int score = user.getScore();
		String resource = user.getResource();
		String mark = user.getMark();
		// SQL语句
		String strSQL = "update users set username = ?, userpwd = ?, usernum = ?, usermail = ?, sex = ?, score = ?, resource = ?, mark = ? where userid = ?";
		Object[] params = new Object[]{username, userpwd, usernum, usermail, sex, score, resource, mark, userid};
		int affectedRows = dbUtils.execOthers(conn, strSQL, params);
		// 提交会回滚
		if(affectedRows > 0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public List<Users> selectAll() {
		// TODO Auto-generated method stub
		// 准备List
		List<Users> lstUsers = new ArrayList<Users>();
		// 获取连接
		this.conn = connectionManager.openConnection();
		// SQL语句
		String strSQL = "select * from users";
		// 执行
		ResultSet resultSet = dbUtils.execQuery(conn, strSQL, new Object[]{});
		
		try {
			while(resultSet.next()){
				Users user = new Users();
				user.setUserid(resultSet.getInt(1));
				user.setUsername(resultSet.getString(2));
				user.setUserpwd(resultSet.getString(3));
				user.setUsernum(resultSet.getString(4));
				user.setUsermail(resultSet.getString(5));
				user.setSex(resultSet.getInt(6));
				user.setRegtime(resultSet.getDate(7));
				user.setScore(resultSet.getInt(8));
				user.setResource(resultSet.getString(9));
				user.setMark(resultSet.getString(10));
				lstUsers.add(user);
			}
			return lstUsers;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			connectionManager.closeConnection(conn);
		}
	}

	@Override
	public Users selectById(int userid) {
		// TODO Auto-generated method stub
		// 准备User
		Users user = new Users();
		// 获取连接
		this.conn = connectionManager.openConnection();
		// SQL语句
		String strSQL = "select * from users where userid = ?";
		Object[] params = new Object[]{userid};
		// 执行
		ResultSet resultSet = dbUtils.execQuery(conn, strSQL, params);
		
		try {
			if(resultSet.next()) {
				user.setUserid(resultSet.getInt(1));
				user.setUsername(resultSet.getString(2));
				user.setUserpwd(resultSet.getString(3));
				user.setUsernum(resultSet.getString(4));
				user.setUsermail(resultSet.getString(5));
				user.setSex(resultSet.getInt(6));
				user.setRegtime(resultSet.getDate(7));
				user.setScore(resultSet.getInt(8));
				user.setResource(resultSet.getString(9));
				user.setMark(resultSet.getString(10));
				return user;
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
	public Users selectByName(String username) {
		// TODO Auto-generated method stub
		// 准备User
		Users user = new Users();
		// 获取连接
		this.conn = connectionManager.openConnection();
		// SQL语句
		String strSQL = "select * from users where username = ?";
		Object[] params = new Object[]{username};
		// 执行
		ResultSet resultSet = dbUtils.execQuery(conn, strSQL, params);
		
		try {
			if(resultSet.next()) {
				user.setUserid(resultSet.getInt(1));
				user.setUsername(resultSet.getString(2));
				user.setUserpwd(resultSet.getString(3));
				user.setUsernum(resultSet.getString(4));
				user.setUsermail(resultSet.getString(5));
				user.setSex(resultSet.getInt(6));
				user.setRegtime(resultSet.getDate(7));
				user.setScore(resultSet.getInt(8));
				user.setResource(resultSet.getString(9));
				user.setMark(resultSet.getString(10));
				return user;
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

}
