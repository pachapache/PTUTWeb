package model;

import java.sql.SQLException;
import javax.sql.DataSource;

public class DataSourceConfig {

	public static DataSource getDataSource() throws SQLException {
		org.apache.derby.jdbc.ClientDataSource ds = new org.apache.derby.jdbc.ClientDataSource();
		ds.setDatabaseName("ptut_freq_res\"");
		ds.setUser("root");
		ds.setPassword("root");
		ds.setServerName("localhost");
		ds.setPortNumber(3306);
                System.out.println("Connection à la base de donnees");
		return ds;
	}	    
}
