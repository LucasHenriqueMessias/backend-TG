package com.ads.farmacia.servicos;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ads.farmacia.dto.UsuarioDTO;
import com.ads.farmacia.entidades.Usuario;
import com.ads.farmacia.repositorios.UsuarioRepositorio;
import com.ads.farmacia.servicos.execoes.EntidadeNaoEncontrada;
import com.ads.farmacia.servicos.execoes.IntegridadeDatabase;

@Service
public class UsuarioServico {

	@Autowired
	private UsuarioRepositorio repositorio;
	

	
	@Transactional(readOnly = true)
	public List<UsuarioDTO> findAll() {
		List<Usuario> lista = repositorio.findAll();
		return lista.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public UsuarioDTO findById(Integer cpf) {
		Optional<Usuario> obj = repositorio.findById(cpf);
		Usuario entidade = obj.orElseThrow(() -> new EntidadeNaoEncontrada("Usuario Não Encontrado"));
		return new UsuarioDTO(entidade);
	}

	@Transactional
	public UsuarioDTO insert(UsuarioDTO dto) {
		Usuario entidade = new Usuario();
		
		entidade.setCargo(dto.getCargo());
		entidade.setEmail(dto.getEmail());		
		entidade.setTelefone(dto.getTelefone());
		entidade.setLoja(dto.getLoja());
		entidade.setNome(dto.getNome());
		entidade.setSenha(dto.getSenha());
		entidade.setSituacao(dto.getSituacao());
		
		entidade = repositorio.save(entidade);
		return new UsuarioDTO(entidade);
	}

	@Transactional
	public UsuarioDTO update(Integer cpf, UsuarioDTO dto) {
		try {
			Usuario entidade = repositorio.getOne(cpf);
			entidade.setCargo(dto.getCargo());
			entidade.setEmail(dto.getEmail());		
			entidade.setTelefone(dto.getTelefone());
			entidade.setLoja(dto.getLoja());
			entidade.setNome(dto.getNome());
			entidade.setSenha(dto.getSenha());
			entidade.setSituacao(dto.getSituacao());
			
			entidade = repositorio.save(entidade);
			return new UsuarioDTO(entidade);
		} catch (EntityNotFoundException e) {
			throw new EntidadeNaoEncontrada("CPF não encontrado: " + cpf);
		}
	}

	public void delete(Integer cpf) {
		try {
			repositorio.deleteById(cpf);
		}
		catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontrada("CPF não encontrado: " + cpf);
		}
		catch (DataIntegrityViolationException e) {
			throw new IntegridadeDatabase("Integridade violada");
		}
	}
}
