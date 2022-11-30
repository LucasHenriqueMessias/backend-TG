package com.ads.farmacia.dto;
import java.io.Serializable;
import com.ads.farmacia.entidades.Loja;
import com.ads.farmacia.entidades.Usuario;



public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer cpf;
	private Integer crf;
	private String nome;
	private String email;
	private String senha;
	private String cargo;
	private String telefone;
	private String situacao = "Pendente"; //iniciar o insert como pendente, quando for autorizado, atualizar para "Ativo"
	private Loja loja;

	public UsuarioDTO() {
	}

	public UsuarioDTO(Integer cpf, Integer crf, String nome, String email, String senha, String cargo, String telefone) {
		this.cpf = cpf;
		this.crf = crf;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cargo = cargo;
		this.telefone = telefone;
	}
	
	public UsuarioDTO(Usuario entidade) {
		this.cpf = entidade.getCpf();
		this.crf = entidade.getCrf();
		this.nome = entidade.getNome();
		this.email = entidade.getEmail();
		this.senha = entidade.getSenha();
		this.cargo = entidade.getCargo();
		this.telefone = entidade.getTelefone();
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
}