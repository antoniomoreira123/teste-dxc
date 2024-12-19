package com.dxc.api.controller;

import com.dxc.api.domain.Cliente;
import com.dxc.api.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;

@MockitoSettings(strictness = Strictness.LENIENT)
@ExtendWith(MockitoExtension.class)
public class ClienteControllerTest {

    @InjectMocks
    private ClienteController controller;

    @Mock
    private ClienteService service;

    private List<Cliente> clientes;

    private Cliente cliente;

    @BeforeEach
    void setUp(){

        cliente = new Cliente();
        cliente.setNome("Teste");
        cliente.setCpf("00000000000");
        cliente.setDataNascimento(new Date());
        cliente.setTelefone("9999999999");
        cliente.setEmail("@teste");
        cliente.setEndereco("Teste");

        clientes = new ArrayList<>();
        clientes.add(cliente);
    }

    @DisplayName("Valida listagem de Clientes")
    @Test
    void valida_listar_clientes_success() {

        Mockito.when(service.findAll())
                .thenReturn(clientes);

        clientes = controller.findAll();

        assertNotNull(clientes);
        assertEquals(HttpStatus.OK, clientes.isEmpty()?false:HttpStatus.OK);
    }

    @DisplayName("Valida cadastro ou update de Cliente")
    @Test
    void valida_cadastro_update_cliente_success() throws Exception {

        Mockito.when(service.cadastroCliente(cliente))
                .thenReturn(cliente);

        Cliente c = controller.cadastroCliente(cliente);

        assertNotNull(c);
        assertEquals(HttpStatus.OK, c==null?false:HttpStatus.OK);
    }

    @DisplayName("Valida delete de Cliente")
    @Test
    void valida_delete_cliente_success() throws Exception {

        Mockito.when(service.deletaCliente(cliente))
                .thenReturn("Deletado");

        String deletado = controller.deletaCliente(cliente);

        assertNotNull(deletado);
        assertEquals(HttpStatus.OK, deletado.isEmpty()?false:HttpStatus.OK);
    }

    @DisplayName("Valida busca de Cliente por CPF")
    @Test
    void valida_buscar_cliente_por_cpf_success() throws Exception {

        Mockito.when(service.findClienteByCpf(cliente.getCpf()))
                .thenReturn(cliente);

        Cliente c = controller.findClienteByCpf(cliente.getCpf());

        assertNotNull(c);
        assertEquals(HttpStatus.OK, c==null?false:HttpStatus.OK);
    }

    @DisplayName("Valida busca de Cliente por ID")
    @Test
    void valida_buscar_cliente_por_id_success() throws Exception {

        Mockito.when(service.findClienteById(cliente.getId()))
                .thenReturn(cliente);

        Cliente c = controller.findClienteById(cliente.getId());

        assertNotNull(c);
        assertEquals(HttpStatus.OK, c==null?false:HttpStatus.OK);
    }
}
