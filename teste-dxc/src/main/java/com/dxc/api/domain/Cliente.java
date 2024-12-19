package com.dxc.api.domain;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "CLIENTE")
public class Cliente {
	@Id
	@Column(name = "id", nullable = false, precision = 3, scale = 0)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="nome", nullable = false)
	private String nome;

	@Column(name="cpf", nullable = false)
	private String cpf;

	@Column(name="data_nascimento", nullable = false)
	private Date dataNascimento;
	
	@Column(name="telefone", nullable = false)
	private String telefone;

	@Column(name="email", nullable = false)
	private String email;

	@Column(name="endereco", nullable = false)
	private String endereco;

	public Cliente() {
	}

	public Cliente(Long id, String nome, String cpf, Date dataNascimento, String telefone, String email, String endereco) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
