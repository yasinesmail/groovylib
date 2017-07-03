package com.dogvacay.database

import groovy.sql.Sql

class Db {
	
	private static def local = [name:"local", url:'jdbc:mysql://127.0.0.1:3306/dogvacay', user:'root', pass:'', driver:"com.mysql.jdbc.Driver"]
	private static def sandbox = [name:"sandbox", url:'jdbc:mysql://sandbox-db.dogvacay.com:3306/dogvacay', user:'dogvacay', pass:'#Tbnl..25H6&b20GgG', driver:"com.mysql.jdbc.Driver"]
	//private static Db prod = new Db()
	
	//private static def sql = null
	private static def connections = [:]
	
	private static Sql connect(dbConfig) {
		if (connections[dbConfig.name]) return connections[dbConfig]
		
		Sql sql = Sql.newInstance(dbConfig.url, dbConfig.user, dbConfig.password, dbConfig.driver)
		connections[dbConfig.name] = sql
		return sql;
	}
	
	public static Sql local() {
		return connect(local)
	}
	
	public static void disconnect(sql) {
		if (sql != null) sql.close()
	}
}
