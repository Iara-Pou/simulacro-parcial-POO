package org.example.controllers;

import org.example.exceptions.UsuarioRepetidoException;
import org.example.dtos.UsuarioResidencialDTO;
import org.example.models.Usuario;
import org.example.models.UsuarioIndustrial;
import org.example.models.UsuarioResidencial;

import java.util.ArrayList;
import java.util.List;

public class EmpresaElectricaController {
    private List<Usuario> usuarios;
    private static EmpresaElectricaController INSTANCE;

    private EmpresaElectricaController() {
        usuarios = new ArrayList<>();
    }

    public static synchronized EmpresaElectricaController getINSTANCE() {
        if (INSTANCE == null) INSTANCE = new EmpresaElectricaController();
        return INSTANCE;
    }

    public void reset(){
        usuarios = new ArrayList<>();
    }


    /*
     * Metodos del controlador
     * */
    public void agregarUsuarioResidencial(UsuarioResidencialDTO usuarioResidencialDTO) throws Exception {
        UsuarioResidencial usuarioNuevo;

        try {
            usuarioNuevo = parsearDTO(usuarioResidencialDTO);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        if (usuarioResidencialExiste(usuarioNuevo)) throw new UsuarioRepetidoException("El usuario ya existe.");

        usuarios.add(usuarioNuevo);
        System.out.println("USUARIO AGREGADO: " + usuarioNuevo);

    }

    //si existe por datos, dar error
    public boolean usuarioResidencialExiste(UsuarioResidencial usuarioNuevo) {
        for (Usuario usuario : usuarios) {
            if (usuario instanceof UsuarioResidencial &&
                    usuariosSonIguales(usuarioNuevo, usuario)) return true;
        }
        return false;
    }

    public boolean usuariosSonIguales(Usuario usuario1, Usuario usuario2) {
        return usuario1.getDNI() == usuario2.getDNI() &&
                usuario1.getNombre().equals(usuario2.getNombre()) &&
                usuario1.getDireccion().hashCode() == (usuario2.getDireccion()).hashCode();
    }

    public UsuarioResidencial parsearDTO(UsuarioResidencialDTO usuarioResidencialDTO) throws Exception {
        UsuarioResidencial usuarioResidencial;
        try {
            usuarioResidencial = new UsuarioResidencial(usuarioResidencialDTO.getNombre(),
                    usuarioResidencialDTO.getDNI(),
                    usuarioResidencialDTO.getDireccion());
        } catch (Exception e) {
            throw new Exception("Los datos ingresados son inválidos");
        }

        return usuarioResidencial;
    }

    public UsuarioResidencialDTO parsearADTO(UsuarioResidencial usuarioResidencial) throws Exception {
        UsuarioResidencialDTO usuarioResidencialDTO = null;
        try {
            usuarioResidencialDTO = new UsuarioResidencialDTO(usuarioResidencial.getNombre(),
                    usuarioResidencial.getDNI(),
                    usuarioResidencial.getDireccion());
        } catch (Exception e) {
            throw new Exception("Los datos ingresados son inválidos");
        }

        return usuarioResidencialDTO;
    }

    public List <UsuarioResidencialDTO> obtenerUsuariosResidenciales() throws Exception {
        List <UsuarioResidencialDTO> usuariosResidencialesDTO = new ArrayList<>();
        for (Usuario usuario : usuarios){
            if (usuario instanceof UsuarioResidencial) {
                UsuarioResidencialDTO usuarioResidencialDTO = parsearADTO((UsuarioResidencial) usuario);
                usuariosResidencialesDTO.add(usuarioResidencialDTO);
            }
        }

        return usuariosResidencialesDTO;
    }
}
