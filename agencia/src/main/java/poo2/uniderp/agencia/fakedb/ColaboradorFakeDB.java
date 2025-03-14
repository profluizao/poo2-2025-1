package poo2.uniderp.agencia.fakedb;

import java.util.ArrayList;

import poo2.uniderp.agencia.pojo.Colaborador;

public class ColaboradorFakeDB {
    private ArrayList<Colaborador> instancia;

    public ArrayList<Colaborador> getInstancia() {
        if (this.instancia == null){
            this.instancia = new ArrayList<>();
        }
        return this.instancia;
    }

    public ColaboradorFakeDB(){
        this.instancia = new ArrayList<>();
        this.preencherInstancia();
    }

    private void preencherInstancia(){
        this.instancia.add(new Colaborador(1L, "Adão", "123"));
        this.instancia.add(new Colaborador(2L, "Eva", "456"));
        this.instancia.add(new Colaborador(3L, "Caim", "789"));
        this.instancia.add(new Colaborador(4L, "Abel", "987"));
        this.instancia.add(new Colaborador(5L, "Lucifer", "159"));
    }
    
    public Colaborador obterPorId(Long codigo){
        for (Colaborador item : this.instancia) {
            if (item.getCodigo() == codigo)
            {
                return item;
            }
        }
        return null;
    }
}
