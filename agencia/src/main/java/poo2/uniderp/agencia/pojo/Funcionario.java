package poo2.uniderp.agencia.pojo;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String nome;

    private String matricula;

    private LocalDate dataDeInsercao;

    public Long getCodigo() {
        return codigo;
    }
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public LocalDate getDataDeInsercao() {
        return dataDeInsercao;
    }
    public void setDataDeInsercao(LocalDate dataDeInsercao) {
        this.dataDeInsercao = dataDeInsercao;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_codigo", referencedColumnName = "codigo")
    private Endereco endereco;

    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    
}

// Explicação
// @OneToOne(cascade = CascadeType.ALL) indica o relacionamento um para um e a propagação de operações
// (ex: salvar/excluir) do Funcionario para o Endereco.
//
// @JoinColumn(name = "endereco_id", referencedColumnName = "codigo") cria a chave estrangeira na tabela 
// Funcionario, apontando para o campo codigo da tabela Endereco.
