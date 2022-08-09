import view.ReportesView;



public class Main {
    public static void main(String[] args) {

        var reportesView = new ReportesView();
        var banco = "Conavi";
        reportesView.proyectosFinanciadosPorBanco(banco)
        ;
    }
}