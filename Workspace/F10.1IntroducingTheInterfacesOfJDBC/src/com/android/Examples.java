package com.android;

import java.sql.Connection;
import java.sql.DriverManager;

public class Examples {
	
	static void ex1() {

		String url="jdbc:mysql://localhost:3306/mydatabase";

	/*EXPLANATION OF URL
	 * jdbc: 
	 * this is the protocol we will use to connect to the database, other such protocols are
	 * ODBC. Protocols are just sets of rules, so this is saying we are connecting to a database using
	 * the rules set down by jdbc
	 * mysql:
	 * this is the name of the external application we are using jdbc to connect to. so this is EXTERNAL
	 * to our java code
	 * localhost:
	 * this is the name of the machine, on which mysql is running, thus becoming a database server. Now this
	 * is the same machine as we are running the java code on, so we put in the name "localhost", which is
	 * always the name given to the machine you are currently on. you can also put in 127.0.0.1 as this is 
	 * always the ip address of the machine you are currently on. this can be a remote database server on the
	 * other side of the world, if it was then whoever is maintaining would have to provide you with teh 
	 * address (can be ip number based or look like a web address). Java does not differentiate between MySQL 
	 * server running on your own machine or on a machine 1000's of miles away.
	 * :3306
	 * this is a port number. A port number is just a setting that tells anything that is connecting to
	 * a particular MySQL database to use this setting. 3306 is always reserved for MySQL database connections.
	 * mydatabase
	 * this is the actual name of the database
	 * other examples of URL strings are
	 * jdbc:postgresql://localhost/zoo
		jdbc:oracle:thin:@123.123.123.123:1521:zoo
	jdbc:mysql://localhost:3306/zoo?profileSQL=true
	 */
	/*
	 * every mysql database we connect to has a User and a password, which we have to provide in
	 * the code. again these should be provided by whoever is the database administrator. by default
	 * our username is "root" and password is blank, which we still define as "". a root user has complete control
	 * of the database and can delete databases, tables, records and add all as well. As a general rule if
	 * you are a database administrator you should not give root user access to everyone
	 */
	String userName="root";
	String password="";
	/*
	 * we then have to create a database Connection object (or to be more precise an object that implements
	 * the Connection interface)
	 * this can throw SQLException, which is a checked exception, so this has to be either in a try/catch block,
	 * a try with resources, or have the method in which the connection is in throw the exception. As a database is
	 * always EXTERNAL to a java application, just like when connecting to file, whether the database exists or 
	 * not is outside of java's control so it has to throw a checked exception.
	 */
	
	try{
		/*
		 * Connection takes three variables
		 * the URL of the database you are  using
		 * the username you use to log on to the database
		 * the password we use to log on to the database
		 * you really should not be using DriverManager in proper coding,
		 * instead you should use Datasource. Datasource is not on the exam but this 
		 * will be covered in a seperate section as using Datasource is the way you
		 * SHOULD connect to a databse. 
		 */
		//have to cover this
		//Class.forName("com.mysql.cj.jdbc.Driver");
		/*
		 * Connection is one of the interfaces of JDBC, which means you can't create 
		 * a Connection object. here we use the DriverManager class, which implements
		 * Connection. The DriverManager class uses the factory pattern, which means
		 * it uses a static method, getConnection() in this case, to get a connection.
		 */
		Connection con=DriverManager.getConnection(url,userName,password);
		System.out.println("connection is ");
		System.out.println(con);
		/*
		 * should always close a connection when you are finished with it
		 * if you use try with resources this connection will be closed automatically
		 */
		con.close();
		
	}
	catch(Exception e) {
		System.out.println("exception is "+e);
	}
		
	}
}
