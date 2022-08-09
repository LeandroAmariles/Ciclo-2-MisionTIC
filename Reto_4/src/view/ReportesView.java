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
                System.out.println("Conexion establecida");
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
                rs.close();
                statement.close();
                miConexion.close();

            }catch (Exception e){
            	e.printStackTrace();
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
            try{
                System.out.println("Conectando");
                Connection miConexion = JDBCUtilities.getConection();
                System.out.println("Conexion establecida");
                Statement statement = null;
                ResultSet rs=null;

                String  consulta="SELECT P.ID_PROYECTO, SUM(C.CANTIDAD * MC.PRECIO_UNIDAD) AS VALOR\n" +
                        "FROM PROYECTO P \n" +
                        "JOIN COMPRA C ON (P.ID_PROYECTO = C.ID_PROYECTO)\n" +
                        "JOIN MATERIALCONSTRUCCION MC ON (C.ID_MATERIALCONSTRUCCION = MC.ID_MATERIALCONSTRUCCION)\n" +
                        "WHERE C.PAGADO = 'No'\n" +
                        "GROUP BY P.ID_PROYECTO\n" +
                        "HAVING SUM(C.CANTIDAD * MC.PRECIO_UNIDAD) > 50000\n" +
                        "ORDER BY VALOR DESC";

                statement = miConexion.createStatement();
                rs=statement.executeQuery(consulta);

                while(rs.next()){
                    int id= rs.getInt(1);
                    int valor = rs.getInt(2);
                    System.out.println(String.format("%3d %,15.1f", id, valor));
                }
                rs.close();
                statement.close();
                miConexion.close();

            }catch(Exception e){
                e.printStackTrace();

            }

        }

    }

    public void lideresQueMasGastan() {
        System.out.println(repitaCaracter('=', 6) + " 10 LIDERES MAS COMPRADORES "
                + repitaCaracter('=', 7));
        System.out.println(String.format("%-25s %15s", "LIDER", "VALOR "));
        System.out.println(repitaCaracter('-', 41));
        // TODO Imprimir en pantalla la información de los líderes
        try{
            System.out.println("Conectando");
            Connection miConexion = JDBCUtilities.getConection();
            System.out.println("Conexion establecida");
            Statement statement = null;
            ResultSet rs=null;

            String  consulta="SELECT L.NOMBRE ||' '||L.PRIMER_APELLIDO ||' '||L.SEGUNDO_APELLIDO AS LIDER, SUM(C.CANTIDAD * MC.PRECIO_UNIDAD) AS VALOR\n" +
                    "FROM LIDER L \n" +
                    "JOIN PROYECTO P ON (P.ID_LIDER = L.ID_LIDER)\n" +
                    "JOIN COMPRA C ON (P.ID_PROYECTO = C.ID_PROYECTO)\n" +
                    "JOIN MATERIALCONSTRUCCION MC ON (C.ID_MATERIALCONSTRUCCION = MC.ID_MATERIALCONSTRUCCION)\n" +
                    "GROUP BY L.NOMBRE ||' '||L.PRIMER_APELLIDO ||' '||L.SEGUNDO_APELLIDO\n" +
                    "ORDER BY VALOR DESC\n" +
                    "LIMIT 10";

            statement = miConexion.createStatement();
            rs=statement.executeQuery(consulta);

            while(rs.next()){
                String lider= rs.getString(1);
                int valor = rs.getInt(2);
                System.out.println(String.format("%-25s %,15.1f", lider, valor));

            }
            rs.close();
            statement.close();
            miConexion.close();

        }catch(Exception e){
            e.printStackTrace();

        }

    }
}
