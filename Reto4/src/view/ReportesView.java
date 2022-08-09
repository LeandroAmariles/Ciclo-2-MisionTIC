/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import  util.*;
 import java.sql.*;


public class ReportesView {
    
   private String repitaCaracter(Character caracter, Integer veces) {
        String respuesta = "";
        for (int i = 0; i < veces; i++) {
            respuesta += caracter;
        }
        return respuesta;
    }

    public void proyectosFinanciadosPorBanco(String banco) {
        System.out.println(repitaCaracter('=', 36) + " LISTADO DE PROYECTOS POR BANCO "
                + repitaCaracter('=', 37));
        if (banco != null && !banco.isBlank()) {
            System.out.println(String.format("%3s %-25s %-20s %-15s %-7s %-30s",
                    "ID", "CONSTRUCTORA", "CIUDAD", "CLASIFICACION", "ESTRATO", "LIDER"));
            System.out.println(repitaCaracter('-', 105));
            // TODO Imprimir en pantalla la información del proyecto
            try{
            	System.out.println("Conectando");
                Connection miConexion = JDBCUtilities.getConection();
                Statement statement = null;
                ResultSet rs=null;

                String  consulta="SELECT P.ID_PROYECTO AS ID, P.CONSTRUCTORA, P.CIUDAD, P.CLASIFICACION, T.ESTRATO, L.NOMBRE||' '||L.PRIMER_APELLIDO||' '||L.SEGUNDO_APELLIDO AS LIDER\n" +
                        "FROM PROYECTO P \n" +
                        "JOIN TIPO T ON (P.ID_TIPO = T.ID_TIPO)\n" +
                        "JOIN LIDER L ON (P.ID_LIDER = L.ID_LIDER)\n" +
                        "WHERE P.BANCO_VINCULADO = 'Conavi'\n" +
                        "ORDER BY FECHA_INICIO DESC, CIUDAD, CONSTRUCTORA;";

                statement = miConexion.createStatement();
                rs= statement.executeQuery(consulta);

                while(rs.next()){
                    int id = rs.getInt(1);
                    String constructora = rs.getString(2);
                    String ciudad = rs.getString(3);
                    String clasificacion = rs.getString(4);
                    int estrato = rs.getInt(5);
                    String lider = rs.getString(6);
                    System.out.println(String.format("%3d %-25s %-20s %-15s %7d %-30s", id, constructora, ciudad,
                            clasificacion, estrato, lider));
                }
            }catch (Exception e){
                System.out.println("No se puede conectar");
            }
        }
    }

    public void totalAdeudadoPorProyectosSuperioresALimite(Double limiteInferior) {
        System.out.println(repitaCaracter('=', 1) + " TOTAL DEUDAS POR PROYECTO "
                + repitaCaracter('=', 1));
        if (limiteInferior != null) {
            System.out.println(String.format("%3s %15s", "ID", "VALOR "));
            System.out.println(repitaCaracter('-', 29));
            // TODO Imprimir en pantalla la información del total adeudado
            System.out.println(repitaCaracter('=', 6) + " 10 LIDERES MAS COMPRADORES "
                    + repitaCaracter('=', 7));
            System.out.println(String.format("%-25s %15s", "LIDER", "VALOR "));
            System.out.println(repitaCaracter('-', 41));
            // TODO Imprimir en pantalla la información de los líderes
        }

    }

    public void lideresQueMasGastan() {
    }
}
