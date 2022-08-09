package modelo;

import utilities.Utilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProyactoDAO {

    public Utilities utilities = new Utilities();

    public List<Proyecto> Informe(){
        java.util.List<Proyecto> proyectos= new ArrayList<Proyecto>();
        Proyecto lider;
        try{
            Connection acceso= utilities.getConnection();
            PreparedStatement ps = acceso.prepareStatement("Select id_proyecto, constructora, numero_habitaciones, ciudad from proyecto;");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                lider = new Proyecto();
                lider.setIdProyecto(rs.getInt(1));
                lider.setConstructora(rs.getString(2));
                lider.setNumeroHabitaciones(rs.getInt(3));
                lider.setCiudad(rs.getString(4));
                proyectos.add(lider);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return proyectos;
    }

}
