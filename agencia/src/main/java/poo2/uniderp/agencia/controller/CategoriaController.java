package poo2.uniderp.agencia.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poo2.uniderp.agencia.pojo.Categoria;
import poo2.uniderp.agencia.repository.ICategoriaRepoJPA;

@RestController
@RequestMapping("/api/agencia/almoxarifado/categoria")
public class CategoriaController {
    
    private ICategoriaRepoJPA repo;

    public CategoriaController(ICategoriaRepoJPA repoJPA){
        this.repo = repoJPA;
    }

    @GetMapping
    public List<Categoria> obterTodos(){
        return this.repo.findAll();
    }
}
