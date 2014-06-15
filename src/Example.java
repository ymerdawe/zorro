import java.sql.ResultSet;


public class Example {
	public static void main(String [] args) throws Exception{
		//Shortest usage example, selects content and print it the connection is also closed
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
		
	}
}
