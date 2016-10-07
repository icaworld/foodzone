package br.com.foodzone.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "indicador")
public class Indicador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "data_inclusao")
    private Date dataInclusao;
    @Column(name = "data_inatividade")
    private Date dataInatividade;
    @Column(name = "ativo")
    private Integer flagAtivo = 1;
    
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
    public Date getDataInclusao() {
        return dataInclusao;
    }
    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }
    public Date getDataInatividade() {
        return dataInatividade;
    }
    public void setDataInatividade(Date dataInatividade) {
        this.dataInatividade = dataInatividade;
    }
    public Integer getFlagAtivo() {
        return flagAtivo;
    }
    public void setFlagAtivo(Integer flagAtivo) {
        this.flagAtivo = flagAtivo;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}