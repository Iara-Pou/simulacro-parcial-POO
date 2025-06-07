package org.example.controllers;

import org.example.dtos.UsuarioResidencialDTO;
import org.example.models.UsuarioResidencial;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class EmpresaElectricaControllerTest {

    EmpresaElectricaController empresaElectricaController;
    UsuarioResidencialDTO usuarioResidencialDTO;
    UsuarioResidencial usuarioResidencial;

    @BeforeEach
    void setUp() {
        empresaElectricaController = EmpresaElectricaController.getINSTANCE();

        usuarioResidencialDTO = new UsuarioResidencialDTO(
                "Iara",
                43627825,
                        "Calle Falsa",
                        123,
                        1,
                        "A",
                        111,
                        "Lomas",
                        "Buenos Aires"
        );

        usuarioResidencial = new UsuarioResidencial(
                "Iara",
                43627825,
                "Calle Falsa",
                123,
                1,
                "A",
                111,
                "Lomas",
                "Buenos Aires"
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
        empresaElectricaController.crearUsuarioResidencial(usuarioResidencialDTO);

        UsuarioResidencial usuarioResidencial = empresaElectricaController.toModel(usuarioResidencialDTO);

        assertAll("Verificar que el usuario se agregó correctamente",
                () -> assertNotNull(empresaElectricaController.obtenerUsuariosResidenciales()),
                () -> assertEquals(1, empresaElectricaController.obtenerUsuariosResidenciales().size()),
                () -> assertTrue(empresaElectricaController.existeUsuarioResidencial(usuarioResidencial))
        );
    }

    @Test
    @DisplayName("Verificar si un usuario ya existe después de agregarlo")
    void usuarioResidencialExiste() throws Exception {
        empresaElectricaController.crearUsuarioResidencial(usuarioResidencialDTO);

        UsuarioResidencial usuarioResidencial = empresaElectricaController.toModel(usuarioResidencialDTO);
        boolean existe = empresaElectricaController.existeUsuarioResidencial(usuarioResidencial);

        assertTrue(existe, "El usuario debería existir en la lista");
    }

    @Test
    @DisplayName("Parsear un DTO a UsuarioResidencial debería mantener los datos")
    void parsearDTO() throws Exception {
        UsuarioResidencial esperado = new UsuarioResidencial(
                usuarioResidencialDTO.getNombre(),
                usuarioResidencialDTO.getDNI(),
                usuarioResidencialDTO.getCalle(),
                usuarioResidencialDTO.getAltura(),
                usuarioResidencialDTO.getPiso(),
                usuarioResidencialDTO.getDepto(),
                usuarioResidencialDTO.getCodigoPostal(),
                usuarioResidencialDTO.getLocalidad(),
                usuarioResidencialDTO.getProvincia()
        );

        UsuarioResidencial resultado = empresaElectricaController.toModel(usuarioResidencialDTO);

        assertAll("Comparar campos del usuario parseado",
                () -> assertNotNull(resultado),
                () -> assertEquals(esperado.getNombre(), resultado.getNombre()),
                () -> assertEquals(esperado.getDNI(), resultado.getDNI()),
                () -> assertEquals(esperado.getCalle(), resultado.getCalle()),
                () -> assertEquals(esperado.getAltura(), resultado.getAltura()),
                () -> assertEquals(esperado.getPiso(), resultado.getPiso()),
                () -> assertEquals(esperado.getDepto(), resultado.getDepto()),
                () -> assertEquals(esperado.getCodigoPostal(), resultado.getCodigoPostal()),
                () -> assertEquals(esperado.getLocalidad(), resultado.getLocalidad()),
                () -> assertEquals(esperado.getProvincia(), resultado.getProvincia())
        );
    }
}
