package org.example.views;

import org.example.exceptions.UsuarioRepetidoException;
import org.example.controllers.EmpresaElectricaController;
import org.example.dtos.UsuarioResidencialDTO;

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
        setLayout(new BorderLayout());
        setSize(400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel(new GridLayout(10, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        //crea label nombre
        nombreLabel = new JLabel("Nombre:");
        panel.add(nombreLabel);
        nombreTXT = new JTextField();
        panel.add(nombreTXT);

        //crea label DNI
        DNILabel = new JLabel("DNI:");
        panel.add(DNILabel);
        DNITXT = new JTextField();
        panel.add(DNITXT);

        //crea label calle
        calleLabel = new JLabel("Calle:");
        panel.add(calleLabel);
        calleTXT = new JTextField();
        panel.add(calleTXT);

        //crea label altura
        alturaLabel = new JLabel("Altura:");
        panel.add(alturaLabel);
        alturaTXT = new JTextField();
        panel.add(alturaTXT);

        //crea label piso
        pisoLabel = new JLabel("Piso:");
        panel.add(pisoLabel);
        pisoTXT = new JTextField();
        panel.add(pisoTXT);

        //crea label depto
        deptoLabel = new JLabel("Depto:");
        panel.add(deptoLabel);
        deptoTXT = new JTextField();
        panel.add(deptoTXT);

        //crea label codigoPostal
        codigoPostalLabel = new JLabel("Codigo Postal:");
        panel.add(codigoPostalLabel);
        codigoPostalTXT = new JTextField();
        panel.add(codigoPostalTXT);

        //crea label localidad
        localidadLabel = new JLabel("Localidad:");
        panel.add(localidadLabel);
        localidadTXT = new JTextField();
        panel.add(localidadTXT);

        //crea label Provincia
        provinciaLabel = new JLabel("Provincia:");
        panel.add(provinciaLabel);
        provinciaTXT = new JTextField();
        panel.add(provinciaTXT);

        //accion Aceptar
        imprimir = new JButton("Aceptar");
        panel.add(imprimir);

        //accion Cancelar
        cancelar = new JButton("Cancelar");
        panel.add(cancelar);

        imprimir.addActionListener(e -> manejarEnvio());
        cancelar.addActionListener( e -> cancelar());

        add(panel, BorderLayout.CENTER);
        pack();
        setSize(500, getHeight());
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

            UsuarioResidencialDTO usuarioResidencialDTO = new UsuarioResidencialDTO(nombre, DNI, calle, altura, piso, depto, codigoPostal, localidad, provincia);

            empresaElectricaController.crearUsuarioResidencial(usuarioResidencialDTO);
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
