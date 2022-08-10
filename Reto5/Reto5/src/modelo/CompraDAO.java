package modelo;

import utilities.Utilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CompraDAO {
    public Utilities utilities = new Utilities();

    public List<Compra> Informe3(){
        List<Compra> compras= new ArrayList<Compra>();
        Compra lider;
        try{
            Connection acceso= utilities.getConnection();
            PreparedStatement ps = acceso.prepareStatement("select compra.id_compra, proyecto.constructora, proyecto.banco_vinculado from compra inner join proyecto\n" +
                    "on compra.id_proyecto = proyecto.id_proyecto where proveedor =\"homecenter\" and ciudad =\"salento\";");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                lider = new Compra();
                lider.setId(rs.getInt(1));
                lider.setConstructora(rs.getString(2));
                lider.setBancoVinculado(rs.getString(4));

                compras.add(lider);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return compras;
    }
}
