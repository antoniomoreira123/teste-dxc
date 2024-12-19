package com.dxc.api.repository;

import com.dxc.api.domain.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

	List<Cliente> findAll();

	@Query(value = "select c from Cliente c where c.cpf=?1")
	Cliente getByCpf(String cpf);

	@Query(value = "SELECT * FROM CLIENTE where id=?1", nativeQuery = true)
	Cliente getByIdNative(Long id);
}
