package org.example.views;

import org.example.exceptions.UsuarioRepetidoException;
import org.example.controllers.EmpresaElectricaController;
import org.example.dtos.UsuarioResidencialDTO;
import org.example.models.Direccion;

import javax.swing.*;
import java.awt.*;

public class AgregarUsuarioResidencial extends JFrame {

    private EmpresaElectricaController empresaElectricaController = EmpresaElectricaController.getINSTANCE();

    private JLabel nombreLabel;
    private JTextField nombreTXT;

    private JLabel DNILabel;
    private JTextField DNITXT;

    private JLabel calleLabel;
    private JTextField calleTXT;

    private JLabel alturaLabel;
    private JTextField alturaTXT;

    private JLabel pisoLabel;
    private JTextField pisoTXT;

    private JLabel deptoLabel;
    private JTextField deptoTXT;

    private JLabel codigoPostalLabel;
    private JTextField codigoPostalTXT;

    private JLabel localidadLabel;
    private JTextField localidadTXT;

    private JLabel provinciaLabel;
    private JTextField provinciaTXT;

    private JButton imprimir;
    private JButton cancelar;

    public AgregarUsuarioResidencial() {
        super("Agregar Usuario Residencial");
        setLayout(new GridLayout(10, 2, 10, 10));
        setSize(400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //crea label nombre
        nombreLabel = new JLabel("Nombre:");
        add(nombreLabel);
        nombreTXT = new JTextField();
        add(nombreTXT);

        //crea label DNI
        DNILabel = new JLabel("DNI:");
        add(DNILabel);
        DNITXT = new JTextField();
        add(DNITXT);

        //crea label calle
        calleLabel = new JLabel("Calle:");
        add(calleLabel);
        calleTXT = new JTextField();
        add(calleTXT);

        //crea label altura
        alturaLabel = new JLabel("Altura:");
        add(alturaLabel);
        alturaTXT = new JTextField();
        add(alturaTXT);

        //crea label piso
        pisoLabel = new JLabel("Piso:");
        add(pisoLabel);
        pisoTXT = new JTextField();
        add(pisoTXT);

        //crea label depto
        deptoLabel = new JLabel("Depto:");
        add(deptoLabel);
        deptoTXT = new JTextField();
        add(deptoTXT);

        //crea label codigoPostal
        codigoPostalLabel = new JLabel("Codigo Postal:");
        add(codigoPostalLabel);
        codigoPostalTXT = new JTextField();
        add(codigoPostalTXT);

        //crea label localidad
        localidadLabel = new JLabel("Localidad:");
        add(localidadLabel);
        localidadTXT = new JTextField();
        add(localidadTXT);

        //crea label Provincia
        provinciaLabel = new JLabel("Provincia:");
        add(provinciaLabel);
        provinciaTXT = new JTextField();
        add(provinciaTXT);

        //accion Aceptar
        imprimir = new JButton("Aceptar");
        add(imprimir);

        //accion Cancelar
        cancelar = new JButton("Cancelar");
        add(cancelar);

        imprimir.addActionListener(e -> manejarEnvio());
        cancelar.addActionListener( e -> cancelar());
        setVisible(true);
    }

    private void cancelar() {
        nombreTXT.setText("");
        DNITXT.setText("");
        calleTXT.setText("");
        alturaTXT.setText("");
        pisoTXT.setText("");
        deptoTXT.setText("");
        codigoPostalTXT.setText("");
        localidadTXT.setText("");
        provinciaTXT.setText("");
    }

    private void manejarEnvio() {
        try {
            String nombre = nombreTXT.getText();
            int DNI = Integer.parseInt(DNITXT.getText());
            String calle = calleTXT.getText();
            int altura = Integer.parseInt(alturaTXT.getText());
            int piso = Integer.parseInt(pisoTXT.getText());
            String depto = deptoTXT.getText();
            int codigoPostal = Integer.parseInt(codigoPostalTXT.getText());
            String localidad = localidadTXT.getText();
            String provincia = provinciaTXT.getText();

            Direccion direccion = new Direccion(calle, altura, piso, depto, codigoPostal, localidad, provincia);
            UsuarioResidencialDTO usuarioResidencialDTO = new UsuarioResidencialDTO(nombre, DNI, direccion);

            empresaElectricaController.agregarUsuarioResidencial(usuarioResidencialDTO);
            JOptionPane.showMessageDialog(null, "Usuario residencial " + nombre + " agregado con éxito.");
            System.out.println(usuarioResidencialDTO);

        } catch (UsuarioRepetidoException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "No ingresaste los tipos de datos correctos.");
            e.printStackTrace();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

}
