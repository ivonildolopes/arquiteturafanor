package br.edu.fanor.progweb.arquitetura.manager.usuario;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.fanor.progweb.arquitetura.bussines.UsuarioBO;
import br.edu.fanor.progweb.arquitetura.entity.Usuarios;
import br.edu.fanor.progweb.arquitetura.utils.Navigation;
/**
 * @author patrick.cunha
 * 
 */
@RequestScoped
@ManagedBean(name="listUsuario")
@Component(value="listUsuario")
public class ListUsuarioManager {

	@Autowired
	private UsuarioBO usuarioBO;
	private String nome;
	private List<Usuarios> usuarios;
	
	public void lista(){
		
		usuarios = usuarioBO.listaUsuarioPorNome(nome);
		
	}
	
	public void excluir(Usuarios usuario){
		usuarioBO.excluir(usuario);
		usuarios = usuarioBO.listaUsuarioPorNome(nome);
	}
	
	public String preparaAtualizar(Usuarios usuario){
		System.out.println(usuario.getNome());
		return null;
	}
	
	public String preparaListar(){
		this.limparDados();
		return Navigation.SUCESSO;
	}
	
	public void limparDados(){
		this.nome = "";
		this.usuarios = null;
	}
	
	
	public String salvar(){
		return null;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Usuarios> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuarios> usuarios) {
		this.usuarios = usuarios;
	}
	
}
