package org.example.controllers;

import org.example.exceptions.UsuarioRepetidoException;
import org.example.dtos.UsuarioResidencialDTO;
import org.example.models.*;

import java.util.ArrayList;
import java.util.List;

public class EmpresaElectricaController {

    private List<Usuario> usuarios;
    private List<Tarifa> tarifas;
    private List<Factura> facturas;
    private static EmpresaElectricaController INSTANCE;

    private EmpresaElectricaController() {
        usuarios = new ArrayList<>();
    }

    public static synchronized EmpresaElectricaController getINSTANCE() {
        if (INSTANCE == null) INSTANCE = new EmpresaElectricaController();
        return INSTANCE;
    }

    public void reset() {
        usuarios = new ArrayList<>();
        Usuario.setIdActual(0);
    }

    /*
     * Metodos del controlador
     * */
    public void crearUsuarioResidencial(UsuarioResidencialDTO usuarioResidencialDTO) throws Exception {
        UsuarioResidencial usuarioNuevo;

        try {
            usuarioNuevo = toModel(usuarioResidencialDTO);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        if (existeUsuarioResidencial(usuarioNuevo)) throw new UsuarioRepetidoException("El usuario ya existe.");

        usuarios.add(usuarioNuevo);
        System.out.println("USUARIO AGREGADO: " + usuarioNuevo);

    }

    public int crearUsuarioIndustrial() {
        return 0;
    }

    public boolean existeUsuarioResidencial(UsuarioResidencial usuarioNuevo) throws Exception {
        List<UsuarioResidencial> usuariosResidenciales = obtenerUsuariosResidenciales();
        for (UsuarioResidencial usuario : usuariosResidenciales) {
            if (usuarioNuevo.equals(usuario)) return true;
        }
        return false;
    }

    public UsuarioResidencial toModel(UsuarioResidencialDTO usuarioResidencialDTO) throws Exception {
        UsuarioResidencial usuarioResidencial;
        try {
            usuarioResidencial = new UsuarioResidencial(usuarioResidencialDTO.getNombre(),
                    usuarioResidencialDTO.getDNI(),
                    usuarioResidencialDTO.getCalle(),
                    usuarioResidencialDTO.getAltura(),
                    usuarioResidencialDTO.getPiso(),
                    usuarioResidencialDTO.getDepto(),
                    usuarioResidencialDTO.getCodigoPostal(),
                    usuarioResidencialDTO.getLocalidad(),
                    usuarioResidencialDTO.getProvincia());
        } catch (Exception e) {
            throw new Exception("Los datos ingresados son inválidos");
        }

        return usuarioResidencial;
    }

    public List<UsuarioResidencial> obtenerUsuariosResidenciales() throws Exception {
        List<UsuarioResidencial> usuariosResidenciales = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            if (usuario instanceof UsuarioResidencial) {
                usuariosResidenciales.add((UsuarioResidencial) usuario);
            }
        }
        return usuariosResidenciales;
    }
}
