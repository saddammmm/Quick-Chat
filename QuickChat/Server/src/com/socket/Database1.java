package com.socket;

import java.sql.*;

public class Database1{
    public String filePath;
    
    public Database1(String filePath){
        this.filePath = filePath;}
    

public boolean userExists(String username)
		{
                            try{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
				Connection con = DriverManager.getConnection("jdbc:odbc:DEVLOPER");

				Statement stmt = con.createStatement();

				stmt.execute("select Username from log"); // execute query in table student

				ResultSet rs = stmt.getResultSet(); // get any Result that came from our query

           
				while ( rs.next() ){

                String u1=rs.getString("Username");
				if(u1.equals(username)){
				return true;
				}
				


                
	  }return false;
           

}
catch(Exception ex){
            System.out.println("Database exception : userExists()");
            return false;
        }
   // return false;

}




    public boolean checkLogin(String username, String password) {
			if(!userExists(username))
			{
				return false;
			}
        try {

            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

            //String accessFileName = "C:/Users/Developer/Documents/Database1";

            //String connURL="jdbc:odbc:DRIVER={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+accessFileName+".accdb;";

            Connection con = DriverManager.getConnection("jdbc:odbc:DEVLOPER");

            Statement stmt = con.createStatement();
			
            stmt.execute("select Password, Username from log"); // execute query in table student

            ResultSet rs = stmt.getResultSet(); // get any Result that came from our query

           
             while ( rs.next() ){

               // System.out.println(rs.getString("ID"));
				if(rs.getString("Username").equals(username)&&rs.getString("Password").equals(password))
				{
				
				return true;
				//break;
				/*int id=rs.getString("ID");
				
				 Statement stmt1 = con.createStatement();
				 stmt1.execute("select  from log");*/
				}
				
				
				
				

                }
				return false;

             
            }
            catch (Exception err) {
                System.out.println("ERROR: " + err);
            return false;
			}
    
			

}

public boolean addUser(String username,String password)
{
	try {

            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

            //String accessFileName = "C:/Users/Developer/Documents/Database1";

            //String connURL="jdbc:odbc:DRIVER={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+accessFileName+".accdb;";

            Connection con = DriverManager.getConnection("jdbc:odbc:DEVLOPER");

            Statement stmt = con.createStatement();
			
            stmt.execute("select ID from log"); // execute query in table student

            ResultSet rs = stmt.getResultSet(); // get any Result that came from our query
			//String username="bakchod";String password="asad";
           int id=0;
             while ( rs.next() ){

                id=Integer.parseInt(rs.getString("ID"));
				}
			//	System.out.println(id);
			id+=1;
			 Statement stmt1 = con.createStatement();
if(!stmt1.execute("insert into log(ID,Username,Password)values('"+id+"','"+username+"','"+password+"')"))
			  {return true;}
			  else{
                              return false;
                          }

              
            }
            catch (Exception err) {
                System.out.println("ERROR: " + err);
            }return false;
    }
}