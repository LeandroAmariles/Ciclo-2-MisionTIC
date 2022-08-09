package util;

import java.io.File;
import java.net.MalformedURLException;
import java.sql.*;

public class JDBCUtilities {
	
	
	private static  final String UBICACION_BD="ProyectosConstruccion.db";

	/*static{
		try{
			UBICACION_BD = String.valueOf(new File("src/ProyectosConstruccion.db").toURI().toURL());
		}catch (MalformedURLException e){
			throw new RuntimeException(e);
		}
	}*/
	public static Connection getConection() throws SQLException{
		String url ="jdbc:sqlite:"+ UBICACION_BD;
		//String url = "jdbc:sqlite:/C:\\Users\\Leandro\\Desktop\\ProyectosContruccion.db";
		return DriverManager.getConnection(url, null);
	}

}
