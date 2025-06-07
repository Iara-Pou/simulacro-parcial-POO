package org.example.controllers;

import org.example.dtos.UsuarioResidencialDTO;
import org.example.exceptions.UsuarioRepetidoException;
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
    @DisplayName("Dado que agrego un usuario, cuando verifico que usuarios contiene, entonces el registro pertenece al usuario agregado.")
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
    @DisplayName("Dado que agrego dos usuarios, cuando verifico cuantos usuarios se almacenaron, entonces el número es 2.")
    void agregarDosUsuariosResidenciales() throws Exception {
        UsuarioResidencialDTO usuarioResidencialDTO1 = new UsuarioResidencialDTO(
                "Ara",
                43627,
                "Falsa",
                222,
                1,
                "A",
                111,
                "Lomas",
                "Buenos Aires"
        );

        empresaElectricaController.crearUsuarioResidencial(usuarioResidencialDTO);
        empresaElectricaController.crearUsuarioResidencial(usuarioResidencialDTO1);
        assertEquals(2, empresaElectricaController.obtenerUsuariosResidenciales().size());
    }

    @Test
    @DisplayName("Dado que agrego un usuario, cuando consulto si existe, el sistema informa que es el caso.")
    void usuarioResidencialExiste() throws Exception {
        empresaElectricaController.crearUsuarioResidencial(usuarioResidencialDTO);

        UsuarioResidencial usuarioResidencial = empresaElectricaController.toModel(usuarioResidencialDTO);
        boolean existe = empresaElectricaController.existeUsuarioResidencial(usuarioResidencial);

        assertTrue(existe, "El usuario debería existir en la lista");
    }

    @Test
    @DisplayName("Dado que parse un DTO a UsuarioResidencial, cuando comparo los datos, debería mantener los mismos.")
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

    @Test
    @DisplayName("Dado que intento agregar un usuario residencial repetido, entonces retorna una excepción.")
    void noAgregarUsuarioResidencialRepetido() throws Exception {
        empresaElectricaController.crearUsuarioResidencial(usuarioResidencialDTO);

        Exception exception = assertThrows(UsuarioRepetidoException.class, () -> {
            empresaElectricaController.crearUsuarioResidencial(usuarioResidencialDTO);
        });

        assertEquals("El usuario ya existe.", exception.getMessage());
    }

}
