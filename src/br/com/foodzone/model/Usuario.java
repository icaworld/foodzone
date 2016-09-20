/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.foodzone.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
@NamedQueries({
		@NamedQuery(name = "Usuario.numeroUsuarios", query = "SELECT COUNT(u.id) FROM Usuario u "),
		@NamedQuery(name = "Usuario.findAllNotInUsuId", query = "SELECT u FROM Usuario u WHERE u.id  NOT IN (:id)"),
		@NamedQuery(name = "Usuario.findUsuNome", query = "SELECT u FROM Usuario u WHERE u.nome = :nome "),
		@NamedQuery(name = "Usuario.findUsuNomeSenha", query = "SELECT u FROM Usuario u WHERE u.nome = :nome AND u.senha = :senha"),
		@NamedQuery(name = "Usuario.findUsuEmailPergunta", query = "SELECT u FROM Usuario u WHERE u.email = :email AND u.pergunta = :pergunta AND u.tipoPergunta = :tipo_pergunta"),
		@NamedQuery(name = "Usuario.findMaxUsuId", query = "SELECT MAX(u.id) FROM Usuario u")
})
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer Id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "senha")
	private String senha;
	@Column(name = "tipo")
	private Integer tipo;
	@Column(name = "tipo_pergunta")
	private Integer tipoPergunta;
	@Column(name = "pergunta")
	private String pergunta;
	@Column(name = "email")
	private String email;

	public Usuario() {
	}


	public Integer getId() {
		return Id;
	}


	public void setId(Integer id) {
		Id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public Integer getTipo() {
		return tipo;
	}


	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}


	public Integer getTipoPergunta() {
		return tipoPergunta;
	}


	public void setTipoPergunta(Integer tipoPergunta) {
		this.tipoPergunta = tipoPergunta;
	}


	public String getPergunta() {
		return pergunta;
	}


	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

}
