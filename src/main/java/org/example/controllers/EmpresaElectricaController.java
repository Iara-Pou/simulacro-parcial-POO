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
    }


    /*
     * Metodos del controlador
     * */
    public void crearUsuarioResidencial(UsuarioResidencialDTO usuarioResidencialDTO) throws Exception {
        UsuarioResidencial usuarioNuevo;

        try {
            usuarioNuevo = parsearDTO(usuarioResidencialDTO);
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

    //si existe por datos, dar error
    public boolean existeUsuarioResidencial(UsuarioResidencial usuarioNuevo) {
        for (Usuario usuario : usuarios) {
            if (usuario instanceof UsuarioResidencial &&
                    usuarioNuevo.equals(usuario)) return true;
        }
        return false;
    }

    public UsuarioResidencial parsearDTO(UsuarioResidencialDTO usuarioResidencialDTO) throws Exception {
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

    public UsuarioResidencialDTO parsearADTO(UsuarioResidencial usuarioResidencial) throws Exception {
        UsuarioResidencialDTO usuarioResidencialDTO = null;
        try {
            usuarioResidencialDTO = new UsuarioResidencialDTO(
                    usuarioResidencial.getNombre(),
                    usuarioResidencial.getDNI(),
                    usuarioResidencial.getCalle(),
                    usuarioResidencial.getAltura(),
                    usuarioResidencial.getPiso(),
                    usuarioResidencial.getDepto(),
                    usuarioResidencial.getCodigoPostal(),
                    usuarioResidencial.getLocalidad(),
                    usuarioResidencial.getProvincia());
        } catch (Exception e) {
            throw new Exception("Los datos ingresados son inválidos");
        }

        return usuarioResidencialDTO;
    }

    public List<UsuarioResidencialDTO> obtenerUsuariosResidenciales() throws Exception {
        List<UsuarioResidencialDTO> usuariosResidencialesDTO = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            if (usuario instanceof UsuarioResidencial) {
                UsuarioResidencialDTO usuarioResidencialDTO = parsearADTO((UsuarioResidencial) usuario);
                usuariosResidencialesDTO.add(usuarioResidencialDTO);
            }
        }

        return usuariosResidencialesDTO;
    }
}
