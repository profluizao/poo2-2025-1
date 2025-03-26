package poo2.uniderp.agencia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poo2.uniderp.agencia.pojo.Categoria;
import poo2.uniderp.agencia.service.CategoriaService;

@RestController
@RequestMapping("/api/agencia/almoxarifado/categoria")
public class CategoriaController {
    
    @Autowired
    private CategoriaService servico;

    public CategoriaController(CategoriaService srv){
        this.servico = srv;
    }

    @GetMapping
    public List<Categoria> obterTodos(){
        return this.servico.browse();
    }
}
