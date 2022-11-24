package com.ads.farmacia.entidades;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer cpf;

	@column (name = "crf")
	private Integer crf;

	@column (name = "nome")
	private String nome;

	@column (name = "email")
	private String email;

	@column (name = "senha")
	private String senha;

	@column (name = "cargo")
	private String cargo;

	@column (name = "telefone")
	private String telefone;

	@column (name = "situacao")
	private String situacao = "Pendente"; //iniciar o insert como pendente, quando for autorizado, atualizar para "Ativo"

	@column (name = loja)
	private Loja loja;

	public Usuario() {
	}

	public Usuario(Integer cpf, Integer crf, String nome, String email, String senha, String cargo, String telefone) {
		this.cpf = cpf;
		this.crf = crf;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cargo = cargo;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Integer getCpf() {
		return cpf;
	}

	public Integer getCrf() {
		return crf;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(cpf, other.cpf);
	}

}
