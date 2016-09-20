package br.com.foodzone.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "estabelecimento")
public class Estabelecimento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    @NotNull(message = "é obrigatório!")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "nome_fantasia")
    private String nomeFantasia;
    @Column(name = "cnpj")
    private String cnpj;
    @Column(name = "inscricao_estadual")
    private String inscricaoEstadual;
    @Column(name = "data_inclusao")
    private Date dataInclusao;
    @Column(name = "ativo")
    private Integer flagAtivo;
//    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Endereco enderecoId;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getNomeFantasia() {
	return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
	this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
	return cnpj;
    }

    public void setCnpj(String cnpj) {
	this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
	return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
	this.inscricaoEstadual = inscricaoEstadual;
    }

    public Date getDataInclusao() {
	return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
	this.dataInclusao = dataInclusao;
    }

    public Integer getFlagAtivo() {
	return flagAtivo;
    }

    public void setFlagAtivo(Integer flagAtivo) {
	this.flagAtivo = flagAtivo;
    }

    public Endereco getEnderecoId() {
	return enderecoId;
    }

    public void setEnderecoId(Endereco enderecoId) {
	this.enderecoId = enderecoId;
    }

    public static long getSerialversionuid() {
	return serialVersionUID;
    }
}