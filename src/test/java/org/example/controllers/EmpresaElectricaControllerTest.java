package org.example.controllers;

import org.example.dtos.UsuarioResidencialDTO;
import org.example.models.Direccion;
import org.example.models.UsuarioResidencial;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class EmpresaElectricaControllerTest {

    EmpresaElectricaController empresaElectricaController;
    UsuarioResidencialDTO usuarioResidencialDTO;

    @BeforeEach
    void setUp() {
        empresaElectricaController = EmpresaElectricaController.getINSTANCE();

        usuarioResidencialDTO = new UsuarioResidencialDTO(
                "Iara",
                43627825,
                new Direccion(
                        "Calle Falsa",
                        123,
                        1,
                        "A",
                        111,
                        "Lomas",
                        "Buenos Aires"
                )
        );
    }

    @AfterEach
    void tearDown() {
        // Limpiar los datos para que no se arrastren entre tests
        empresaElectricaController.reset();
    }

    @Test
    @DisplayName("Agregar un usuario y verificar que fue almacenado correctamente")
    void agregarUsuarioResidencial() throws Exception {
        empresaElectricaController.agregarUsuarioResidencial(usuarioResidencialDTO);

        UsuarioResidencial usuarioResidencial = empresaElectricaController.parsearDTO(usuarioResidencialDTO);

        assertAll("Verificar que el usuario se agregó correctamente",
                () -> assertNotNull(empresaElectricaController.obtenerUsuariosResidenciales()),
                () -> assertEquals(1, empresaElectricaController.obtenerUsuariosResidenciales().size()),
                () -> assertTrue(empresaElectricaController.usuarioResidencialExiste(usuarioResidencial))
        );
    }

    @Test
    @DisplayName("Verificar si un usuario ya existe después de agregarlo")
    void usuarioResidencialExiste() throws Exception {
        empresaElectricaController.agregarUsuarioResidencial(usuarioResidencialDTO);

        UsuarioResidencial usuarioResidencial = empresaElectricaController.parsearDTO(usuarioResidencialDTO);
        boolean existe = empresaElectricaController.usuarioResidencialExiste(usuarioResidencial);

        assertTrue(existe, "El usuario debería existir en la lista");
    }

    @Test
    @DisplayName("Comparar dos usuarios con los mismos datos debe dar true")
    void usuariosSonIguales() {
        Direccion direccion = new Direccion(
                "Calle Falsa", 123, 1, "A", 111, "Lomas", "Buenos Aires");

        UsuarioResidencial usuario1 = new UsuarioResidencial("Iara", 43262782, direccion);
        UsuarioResidencial usuario2 = new UsuarioResidencial("Iara", 43262782, direccion);

        boolean sonIguales = empresaElectricaController.usuariosSonIguales(usuario1, usuario2);

        assertTrue(sonIguales, "Los usuarios deberían considerarse iguales");
    }

    @Test
    @DisplayName("Parsear un DTO a UsuarioResidencial debería mantener los datos")
    void parsearDTO() throws Exception {
        UsuarioResidencial esperado = new UsuarioResidencial(
                usuarioResidencialDTO.getNombre(),
                usuarioResidencialDTO.getDNI(),
                usuarioResidencialDTO.getDireccion()
        );

        UsuarioResidencial resultado = empresaElectricaController.parsearDTO(usuarioResidencialDTO);

        assertAll("Comparar campos del usuario parseado",
                () -> assertNotNull(resultado),
                () -> assertEquals(esperado.getNombre(), resultado.getNombre()),
                () -> assertEquals(esperado.getDNI(), resultado.getDNI()),
                () -> assertEquals(esperado.getDireccion(), resultado.getDireccion())
        );
    }
}
