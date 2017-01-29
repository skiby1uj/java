package kolokwium2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.stream.Stream;

//hsqldb ten sam co na zajeciach
//java 1.8

public class ReadAndSaveDb {
	static Connection c;
	static Vector<String> columnNames = new Vector<>();
	
	public static void listFilesForFolder(final File folder) throws ClassNotFoundException, SQLException {
		 Class.forName("org.hsqldb.jdbc.JDBCDriver");
	     c = DriverManager.getConnection("jdbc:hsqldb:file:PhoneBookDB", "SA", "");
	     createTable(c);
		
	    for (final File fileEntry : folder.listFiles()) {
//	    	System.out.println(fileEntry.getName() + " ");
//	    	System.out.println(folderSize(fileEntry));
	    	addFile(c, fileEntry.getName(), folderSize(fileEntry));
	    }
//	     readDb(c);
	}
	
	
	public static int folderSize(File directory) {
	    int length = 0;
	    if(!directory.isFile()){
	    	for (File file : directory.listFiles()) {
		        if (file.isFile()){
		        	length += file.length();
		        }
		            
		        else{
		        	length += folderSize(file);
		        }
		    }
	    }else{
	    	length = (int) directory.length();
	    }
	    
	    return length;
	}
	
	public static void setColumnNames()
    {
        columnNames.addElement("Name");
        columnNames.addElement("Size");
    }
	
	public static void createTable(Connection c) throws SQLException
    {
        Statement s = c.createStatement();
        s.executeQuery("DROP TABLE IF EXISTS FileSize");
        s.executeUpdate("CREATE TABLE FileSize (Name VARCHAR(100), Size int);");
        s.close();
    }
	
	public static void addFile(Connection c, String name, int rozmiar) throws SQLException
    {
        Statement s = c.createStatement();
        s.executeUpdate("INSERT INTO FileSize VALUES('" + name + "', '" + rozmiar + "');");
        s.close();
    }

	public static void readDb(Connection c) throws SQLException
    {
        Statement s = c.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM FileSize");
        while(rs.next()){
            System.out.print(rs.getInt("Size"));
            System.out.println(" " + rs.getString("Name"));
        }
        s.close();
    }
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		File folder = null;
		try{
			folder = new File(args[0]);
			listFilesForFolder(folder);
		}catch (Exception e) {
			System.out.println("Cos poszlo nie tak");
		}
	}
}
