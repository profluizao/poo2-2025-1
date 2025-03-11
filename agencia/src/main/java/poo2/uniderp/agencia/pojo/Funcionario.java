package poo2.uniderp.agencia.pojo;

import java.time.LocalDate;

public class Funcionario {
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
    public Funcionario() {
    }
    public Funcionario(Long codigo, String nome, String matricula, LocalDate dataDeInsercao) {
        this.codigo = codigo;
        this.nome = nome;
        this.matricula = matricula;
        this.dataDeInsercao = dataDeInsercao;
    }
}
