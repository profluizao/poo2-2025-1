package poo2.uniderp.agencia.pojo;

import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String descricao;

    private LocalDate dataDeInclusao;

    private LocalDate dataDeAlteracao;
    public Long getCodigo() {
        return codigo;
    }
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public LocalDate getDataDeInclusao() {
        return dataDeInclusao;
    }
    public void setDataDeInclusao(LocalDate dataDeInclusao) {
        this.dataDeInclusao = dataDeInclusao;
    }
    public LocalDate getDataDeAlteracao() {
        return dataDeAlteracao;
    }
    public void setDataDeAlteracao(LocalDate dataDeAlteracao) {
        this.dataDeAlteracao = dataDeAlteracao;
    }

    public Categoria(){}

    @OneToMany(mappedBy = "categoria", 
        cascade = CascadeType.ALL, 
        fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Produto> produtos;

}
