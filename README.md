Zorro
=====

Quick and simple JDBC wrapper for quick and simple MySQL manipulation in java


Dependency
============
JDBC connector library
Download avalible at: http://dev.mysql.com/downloads/connector/j/#downloads



Example usage:
==============
    //Setup your db settings in the config file or provide them in the connect() method
    
		//Minimal usage example, selects content and print it the connection is also closed
		new Zorro("select * from mytable");
		
		//More control
		Zorro z = new Zorro();
		z.connect();
		ResultSet rset=z.exe("select * from mytable");
		while(rset.next()){
			System.out.println(rset.getString(0)); //print first column
		}
		z.closeStmt(); //closes the last statement used
		z.close(); //closes the connection
		
		//Parameters (prepared statements are used)
		Zorro z2 = new Zorro();
		z2.connect();
		z2.exe("select * from mytable where val=?", new Object[]{"the value"});
		z2.printResult(); //prints the result
		z2.close();
