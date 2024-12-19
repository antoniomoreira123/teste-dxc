package com.dxc.api;

import com.dxc.api.domain.Cliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class ClienteDxcApplication implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(ClienteDxcApplication.class);
	@Autowired
	JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ClienteDxcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Criando tabela");

		jdbcTemplate.execute("DROP TABLE CLIENTE IF EXISTS");
		jdbcTemplate.execute("CREATE TABLE CLIENTE(" +
				"id SERIAL, nome VARCHAR(255), cpf VARCHAR(255), " +
				"data_nascimento date, telefone VARCHAR(255), " +
				"email VARCHAR(255), endereco VARCHAR(255))");

		List<Object[]> splitUpNames = Stream.of(
						"Toni 12345678900 1980-01-03 91988888888 teste@123 rua-beijamin,centro,belem,Pará",
						"Vicente 99999999999 1999-10-01 91988888888 teste@123 rua-beijamin,centro,belem,Pará",
						"Maria 00000000000 1989-05-05 91988888888 teste@123 rua-beijamin,centro,belem,Pará")
				.map(name -> name.split(" "))
				.collect(Collectors.toList());

		log.info("Inserindo dados na tabela CLIENTE");

		jdbcTemplate.batchUpdate("INSERT INTO CLIENTE(nome, cpf, data_nascimento, telefone, email, endereco) " +
				" VALUES (?,?,?,?,?,?)", splitUpNames);

		log.info("Busca clientes com nome Toni...");
		jdbcTemplate.query(
						"SELECT id, nome, cpf, data_nascimento, telefone, email, endereco FROM CLIENTE WHERE nome = ?",
						(rs, rowNum) -> new Cliente(
								rs.getLong("id"),
								rs.getString("nome"),
								rs.getString("cpf"),
								rs.getDate("data_nascimento"),
								rs.getString("telefone"),
								rs.getString("email"),
								rs.getString("endereco")), "Toni")
				.forEach(cliente -> log.info(cliente.getNome()));
	}
}
