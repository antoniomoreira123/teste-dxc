package com.dxc.api.controller;

import com.dxc.api.domain.Cliente;
import com.dxc.api.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")//possibilita qualquer aplicação externa a se comunicar com a API
@RestController
@RequestMapping("/cliente-api")
public class ClienteController {
	@Autowired
	private ClienteService service;

	
	@Description(value = "Retorna uma lista de Clientes")
	@GetMapping("/list")
	@ResponseBody
	public List<Cliente> findAll() {
		return service.findAll();
	}

	@Description(value = "API para salvar ou atualizar novo cliente")
	@PostMapping("/cadastro-update")
	@ResponseBody
	public Cliente cadastroCliente(@RequestBody Cliente cliente) throws Exception {
		return service.cadastroCliente(cliente);
	}

	@Description(value = "API para deletar um Cliente pelo ID")
	@DeleteMapping("/delete")
	public String deletaCliente(@RequestBody Cliente cliente) {
		return service.deletaCliente(cliente);
	}

	@Description(value = "Retorna um Cliente por cpf")
	@GetMapping("/get-by-cpf")
	@ResponseBody
	public Cliente findClienteByCpf(@RequestParam("cpf") String cpf) {
		return service.findClienteByCpf(cpf);
	}

	@Description(value = "Retorna um Cliente por ID")
	@GetMapping("/get-by-id")
	@ResponseBody
	public Cliente findClienteById(@RequestParam("id") Long id) {
		return service.findClienteById(id);
	}
}
