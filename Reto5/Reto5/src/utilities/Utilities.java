package utilities;

import java.sql.Connection;
import java.sql.DriverManager;

public class Utilities {

    public Utilities(){

    }

    public Connection getConnection(){
        Connection myConnection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Estableciendo conexion");
            myConnection= DriverManager.getConnection("jdbc:mysql://localhost:3306:proyectos","root","2301");
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Conexion establecida");
        return myConnection;
    }
}
