package com.ws.rodrigo.modelo;

import com.ws.rodrigo.dto.PessoaDTO;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.validator.constraints.NotBlank;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement(required = true)
    private Integer id;

    @Column(name = "nome", length = 50, nullable = false)
    @XmlElement(required = true)
    @NotBlank @NotNull
    private String nome;

    @Column(name = "email", length = 50, nullable = false)
    @XmlElement(required = true)
    @NotBlank @NotNull
    private String email;

    public Pessoa() {
    }
    
    public Pessoa(PessoaDTO pessoaDTO){
        this.nome = pessoaDTO.getNome();
        this.email = pessoaDTO.getEmail();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomePessoa() {
        return nome;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nome = nomePessoa;
    }

    public String getEmailPessoa() {
        return email;
    }

    public void setEmailPessoa(String emailPessoa) {
        this.email = emailPessoa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
