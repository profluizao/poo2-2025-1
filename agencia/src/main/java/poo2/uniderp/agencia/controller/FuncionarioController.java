package poo2.uniderp.agencia.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poo2.uniderp.agencia.fakedb.FuncionarioFakeDB;
import poo2.uniderp.agencia.pojo.Funcionario;

@RestController
@RequestMapping("/api/agencia/recursoshumanos/funcionario")
public class FuncionarioController {
    private FuncionarioFakeDB fakeDB;

    public FuncionarioController(){
        this.fakeDB = new FuncionarioFakeDB();
    }

    @GetMapping
    public ArrayList<Funcionario> get(){
        return this.fakeDB.getInstancia();
    }

    @GetMapping("/{codigo}")
    public Funcionario getPorId(@PathVariable Long codigo){
        Funcionario temp = this.fakeDB.obterPorId(codigo);
        return temp;
    }

 

}
