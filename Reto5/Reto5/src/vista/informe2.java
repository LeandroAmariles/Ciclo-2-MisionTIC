package vista;

import modelo.Lider;
import modelo.Lider_DAO;
import modelo.ProyactoDAO;
import modelo.Proyecto;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class informe2 extends JFrame{

    private JPanel contentPane;
    private JTable table;

    public informe2() {

        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(25, 93, 401, 160);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);
        table.setCellSelectionEnabled(true);
        table.setEnabled(false);
        table.setColumnSelectionAllowed(true);
        table.setBackground(Color.GRAY);
        table.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                },
                new String[] {
                        "Id", "Constructora", "Numero Habitaciones", "Ciudad"
                }
        ));

        Label label = new Label("Informe 2");
        label.setFont(new Font("Arial", Font.PLAIN, 18));
        label.setBounds(181, 10, 135, 63);
        contentPane.add(label);
    }
    public void listar() {
        List<Proyecto> list = new ProyactoDAO().Informe();
        DefaultTableModel model = new DefaultTableModel();
        table.setModel(model);

        Object[] columna = new Object[4];

        int numero = list.size();

        for (int i = 0; i < numero; i++) {
            columna[0] = list.get(i).getIdProyecto();
            columna[1] = list.get(i).getConstructora();
            columna[2] = list.get(i).getNumeroHabitaciones();
            columna[3] = list.get(i).getCiudad();

            model.addRow(columna);

        }
    }
}
