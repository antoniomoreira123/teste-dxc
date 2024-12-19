package com.dxc.api.service;

import com.dxc.api.domain.Cliente;
import com.dxc.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {//Classe responsavel pelos serviços de persistecia referente a cliente
	
	@Autowired //anotação respnsavel por carregar(injetar) o bean para o seriço, neste caso injetando o repository para ser utilizado nesta classe de serviço
	private ClienteRepository repository; //Responsável por disponibilizar o repository de perstencia na base a ser chamado
	

	public List<Cliente> findAll() {
		return repository.findAll();
	}
	
	public Cliente cadastroCliente(Cliente cliente) throws Exception {
		Cliente c = repository.save(cliente);
		
		if(c!=null)//verifica se a entinde Cliente foi salva. Caso retorne o objeto é dado como salvo, caso null é dando como não salvo.
			return c;
		else return null;
	}
	
	public String deletaCliente(Cliente cliente) {
		if(cliente.getId() == null)//Verifica se foi passado o id da cliente para ser removida
			return "ID invalido para o delete";
		
		try {
			Cliente c = repository.findById(cliente.getId()).get();//busca na base pelo id a cliente atualizada a ser deletada
			
			repository.deleteById(c.getId());//deleta na base a cliente que foi buscado pelo id.
			return "deletado";
			
		}catch (Exception e) {
			return "cliente não encontrada!";//caso não encontrado
		}
		
	}

	public Cliente findClienteByCpf(String cpf) {
		return repository.getByCpf(cpf);
	}

	public Cliente findClienteById(Long id) {
		return repository.getByIdNative(id);
	}
}
