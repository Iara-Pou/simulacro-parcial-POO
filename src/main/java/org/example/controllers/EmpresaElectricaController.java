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

    private int idUsuarioActual = 0;

    private EmpresaElectricaController() {
        usuarios = new ArrayList<>();
    }

    public static synchronized EmpresaElectricaController getINSTANCE() {
        if (INSTANCE == null) INSTANCE = new EmpresaElectricaController();
        return INSTANCE;
    }

    public void reset() {
        usuarios = new ArrayList<>();
    }

    /*
     * Metodos del controlador
     * */
    public int crearUsuarioResidencial(UsuarioResidencialDTO usuarioResidencialDTO) throws Exception {
        UsuarioResidencial usuarioNuevo;

        try {
            usuarioNuevo = toModel(usuarioResidencialDTO);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        if (existeUsuarioResidencial(usuarioNuevo.getDNI())) throw new UsuarioRepetidoException("El usuario ya existe.");

        asignarIdUsuario(usuarioNuevo);

        System.out.println("USUARIO AGREGADO: " + usuarioNuevo);
        usuarios.add(usuarioNuevo);
        return usuarioNuevo.getNroUsuario();

    }

    private void asignarIdUsuario(UsuarioResidencial usuarioNuevo) {
        usuarioNuevo.setNroUsuario(idUsuarioActual);
        idUsuarioActual++;
    }

    public int crearUsuarioIndustrial() {
        return 0;
    }

    public Usuario buscarUsuario(int nroUsuario){
        return null;
    }

    public float consultarConsumo(int nroUsuario, int anio, int bimestre){
        return Float.parseFloat("");
    }

    public boolean existeUsuarioResidencial(int DNI) throws Exception {
        List<UsuarioResidencial> usuariosResidenciales = obtenerUsuariosResidenciales();
        for (UsuarioResidencial usuario : usuariosResidenciales) {
            if (DNI == usuario.getDNI()) return true;
        }
        return false;
    }

    public boolean existeUsuarioIndustrial(String cuit){
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
