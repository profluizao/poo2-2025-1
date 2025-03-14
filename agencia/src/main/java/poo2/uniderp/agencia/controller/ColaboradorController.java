package poo2.uniderp.agencia.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poo2.uniderp.agencia.fakedb.ColaboradorFakeDB;
import poo2.uniderp.agencia.pojo.Colaborador;

@RestController
@RequestMapping("/api/agencia/recursoshumanos/colaborador")
public class ColaboradorController {
    private ColaboradorFakeDB fakeDB;

    public ColaboradorController(){
        this.fakeDB = new ColaboradorFakeDB();
    }

    @GetMapping
    public ArrayList<Colaborador> getAll(){
        return this.fakeDB.getInstancia();
    }

    @GetMapping("/{codigo}")
    public Colaborador getById(@PathVariable Long codigo){
        Colaborador temp = this.fakeDB.obterPorId(codigo);
        return temp;
    }
}
