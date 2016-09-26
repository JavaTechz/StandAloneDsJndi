package com.example.standalonedsjndi.connector;

import java.sql.Connection;
import java.util.Hashtable;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.example.standalonedsjndi.properties.PropertyLoader;

//TODO weblogic needs to be in class path. Connection should be weblogic specific
public class JNDIConnectionManager {

	private static String jndifactory;
	private static String providerurl;
	private static String dbusuername;
	private static String dbpassword;
	private static String datasource;
	
	static {
		Properties props = PropertyLoader.getProps();
		jndifactory = props.getProperty("jndifactory");
		providerurl = props.getProperty("providerurl");
		dbusuername = props.getProperty("dbusuername");
		dbpassword = props.getProperty("dbpassword");
		datasource = props.getProperty("datasource");
	}

	public Connection getConnection() {
		Connection conn = null;
		javax.sql.DataSource ds = null;
		Hashtable envHashTab = new Hashtable();
		envHashTab.put(Context.INITIAL_CONTEXT_FACTORY, jndifactory);
		envHashTab.put(Context.PROVIDER_URL, providerurl);
		envHashTab.put(Context.SECURITY_PRINCIPAL, dbusuername);
		envHashTab.put(Context.SECURITY_CREDENTIALS, dbpassword);

		try {
			Context context = new InitialContext(envHashTab);
			// you will need to have create a Data Source with JNDI name testDS
			ds = (javax.sql.DataSource) context.lookup(datasource);
			conn = (Connection) ds.getConnection();
			java.util.Properties prop = new java.util.Properties();
			System.out.println("Connection object details : " + conn);
			conn.close();
		} catch (Exception ex) {
			// handle the exception
			ex.printStackTrace();
		}
		return conn;
	}
}
