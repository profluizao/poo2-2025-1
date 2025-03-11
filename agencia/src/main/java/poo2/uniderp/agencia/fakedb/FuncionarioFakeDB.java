package poo2.uniderp.agencia.fakedb;

import java.time.LocalDate;
import java.util.ArrayList;

import poo2.uniderp.agencia.pojo.Funcionario;

public class FuncionarioFakeDB {
    private ArrayList<Funcionario> instancia;

    public ArrayList<Funcionario> getInstancia() {
        if (this.instancia == null){
            this.instancia = new ArrayList<>();
        }
        return instancia;
    }
    
    public FuncionarioFakeDB(){
        this.instancia = new ArrayList<>();
        this.preencherInstancia();
    }

    private void preencherInstancia(){
        this.instancia.add(new Funcionario(1L, "Mateus", "123", LocalDate.now()));
        this.instancia.add(new Funcionario(2L, "Lucas", "456", LocalDate.now()));
        this.instancia.add(new Funcionario(3L, "João", "789", LocalDate.now()));
        this.instancia.add(new Funcionario(4L, "Pedro", "987", LocalDate.now()));
        this.instancia.add(new Funcionario(5L, "Paulo", "654", LocalDate.now()));
    }

    public Funcionario obterPorId(Long id){
        for (Funcionario item : this.instancia) {
            if(item.getCodigo() == id) return item;
        }
        return null;
    }
}
