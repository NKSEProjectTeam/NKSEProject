package com.nankai.exchange.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nankai.exchange.dao.ITypeDao;
import com.nankai.exchange.db.ConnectionManager;
import com.nankai.exchange.db.DBUtils;
import com.nankai.exchange.db.TransactionManager;
import com.nankai.exchange.po.Type;

public class TypeDaoImpl implements ITypeDao {

	private ConnectionManager connectionManager;
	private DBUtils dbUtils;
	
	public TypeDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager=new ConnectionManager();
		this.dbUtils=new DBUtils();
	}

	@Override
	public int insert(Type type) {
		// TODO Auto-generated method stub
		Connection  conn = this.connectionManager.openConnection();
		//开启一个事务
		TransactionManager.conn = conn;
		TransactionManager.beginTransaction();
		
		//差分属性
		
		
		//int typeid=type.getTypeid();
		String typename=type.getTypename();
		int faid=type.getFaid();
		
		
	
		//创建ＳＱＬ语言模板
		String strSQL = "insert into type values(null,?,?)";
		Object[] params = new Object[]{typename,faid};
		// 创建dbutils对象，并调用execothers方法实现数据库的添加操作。
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		//根据上一步的结果完成相应的事务处理
		if(affectedRows > 0){
			// 提交事务
			TransactionManager.commit();
		}else{
			// 回滚事务
			TransactionManager.rollback();
		}
		return affectedRows;
	}


		

	@Override
	public List<Type> selectAll() {
		// TODO Auto-generated method stub
		List<Type> lstType=new ArrayList<Type>();
		
		Connection conn=connectionManager.openConnection();
		
		String strSQL= "select * from type order by typeid";
		
		ResultSet resultSet=this.dbUtils.execQuery(conn, strSQL, new Object[]{});
		
		try {
			while(resultSet.next()){
				
				Type type=new Type();
				type.setTypeid(resultSet.getInt(1));
				type.setTypename(resultSet.getString(2));
				type.setFaid(resultSet.getInt(3));
				
				lstType.add(type);
				
			}
				return lstType;
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			this.connectionManager.closeConnection(conn);
		}
	
	}

	@Override
	public int deleteById(int typeid) {
		// TODO Auto-generated method stub
		 Connection conn=connectionManager.openConnection();
			
			TransactionManager.conn=conn;
			TransactionManager.beginTransaction();
			
			String strSQL="delete from type where typeid=?";
			
			Object[] params=new Object[]{typeid};
			
			int affectRows=this.dbUtils.execOthers(conn, strSQL, params);
			
			if(affectRows>0){
				TransactionManager.commit();
			}else{
				TransactionManager.rollback();
			} 
						
			return affectRows;
			
		}

	

	@Override
	public Type selectById(int typeid) {
		// TODO Auto-generated method stub
		  Connection conn=connectionManager.openConnection();
			
			String strSQL= "select * from type where typeid=?";
			
			Object[] params=new Object[]{typeid};
			
			ResultSet resultSet=this.dbUtils.execQuery(conn, strSQL, params);
			
			try {
				if(resultSet.next()){
					
					Type type=new Type();
					type.setTypeid(resultSet.getInt(1));
					type.setTypename(resultSet.getString(2));
					type.setFaid(resultSet.getInt(3));
					
					
					
					return type;
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
	public int update(Type type) {
		// TODO Auto-generated method stub
		Connection  conn = this.connectionManager.openConnection();
		//开启一个事务
		TransactionManager.conn = conn;
		TransactionManager.beginTransaction();
		
		int typeid=type.getTypeid();
		String typename=type.getTypename();
		int faid=type.getFaid();
		
		//创建ＳＱＬ语言模板
		String strSQL = "update type set typename=?,faid=? where typeid=?";
		Object[] params = new Object[]{typename,faid,typeid};
		// 创建dbutils对象，并调用execothers方法实现数据库的添加操作。
		int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
		System.out.println(affectedRows);
		//根据上一步的结果完成相应的事务处理
		if(affectedRows > 0){
			// 提交事务
			TransactionManager.commit();
		}else{
			// 回滚事务
			TransactionManager.rollback();
		}
		return affectedRows;
	}


}
