
import view.ReportesView;
public class Principal {  
    public static void main(String[] args) {

        var reportesView = new ReportesView();
        var banco = "Conavi";
        reportesView.proyectosFinanciadosPorBanco(banco)
        ;
    }

    
}
