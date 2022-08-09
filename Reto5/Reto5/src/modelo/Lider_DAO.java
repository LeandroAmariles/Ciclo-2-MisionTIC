package modelo;



import utilities.Utilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Lider_DAO {

    public Utilities utilities = new Utilities();

    public List<Lider> Informe1(){
        List<Lider> lideres= new ArrayList<Lider>();
        Lider lider;
        try{
            Connection acceso= utilities.getConnection();
            PreparedStatement ps = acceso.prepareStatement("Select id_lider, nombre, primer_apellido, ciudad_residencia from proyectos.lider order by ciudad_residencia asc;");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                lider = new Lider();
                lider.setId(rs.getInt(1));
                lider.setNombre(rs.getString(2));
                lider.setApellido(rs.getString(3));
                lider.setCiudad(rs.getString(4));
                lideres.add(lider);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return lideres;
    }
}
