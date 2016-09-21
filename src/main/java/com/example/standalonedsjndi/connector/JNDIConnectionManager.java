package com.example.standalonedsjndi.connector;

import java.sql.Connection;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

//TODO weblogic needs to be in class path. Connection should be weblogic specific
public class JNDIConnectionManager {

	public Connection getConnection() {
		Connection conn = null;
		javax.sql.DataSource ds = null;
		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY,
				"weblogic.jndi.WLInitialContextFactory");
		env.put(Context.PROVIDER_URL, "t3://localhost:7001");

		try {
			Context context = new InitialContext(env);
			// you will need to have create a Data Source with JNDI name testDS
			ds = (javax.sql.DataSource) context.lookup("testDS");
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
