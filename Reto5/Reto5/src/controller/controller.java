package controller;

import modelo.Lider;
import vista.Informe1;
import vista.Interface_Principal;
import vista.informe2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class controller {

    public void accion(String eleccion) {

        switch (eleccion) {
            case "Informe 1":
                Informe1 informe1 = new Informe1();
                informe1.listar();
                informe1.setVisible(true);
                break;
            case "Informe 2":
                informe2 inf = new informe2();
                inf.listar();
                inf.setVisible(true);
                break;
        }
    }
}


