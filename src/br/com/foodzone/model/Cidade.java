package br.com.foodzone.model;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "cidade")
public class Cidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    @NotNull(message="Cidade é obrigatório!")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @JoinColumn(name = "estado_id", referencedColumnName = "id")
    @OneToOne(optional = true)
    private Estado estadoId;
    @OneToMany( cascade = CascadeType.ALL, mappedBy = "cidadeId")
    private List<Endereco> enderecoList;

    public Cidade() {
    }

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

    public Estado getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(Estado estadoId) {
		this.estadoId = estadoId;
	}

	public List<Endereco> getEnderecoList() {
        return enderecoList;
    }

    public void setEnderecoList(List<Endereco> enderecoList) {
        this.enderecoList = enderecoList;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    
}