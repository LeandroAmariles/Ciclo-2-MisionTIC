package vista;

import controller.controller;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface_Principal extends JFrame {
    private JPanel contentPane;
    public JButton btnNewButton;

    public JComboBox comboBox;

    public Interface_Principal() {
        setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);



        comboBox=new JComboBox<>();
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Informe 1", "Informe 2", "Informe 3"}));
        comboBox.setBounds(136, 59, 171, 34);

        contentPane.add(comboBox);

        btnNewButton=new JButton("Aceptar");
        btnNewButton.setBounds(178, 177, 85, 21);
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            String eleccion = comboBox.getSelectedItem().toString();
            controller c = new controller();
            c.accion(eleccion);
            }
        });
        contentPane.add(btnNewButton);
    }

}
