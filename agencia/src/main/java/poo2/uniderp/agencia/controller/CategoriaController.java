package poo2.uniderp.agencia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<List<Categoria>> obterTodos(){
        List<Categoria> lista = this.servico.browse();
        return new ResponseEntity<List<Categoria>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Categoria> obterPorId(@PathVariable Long codigo){
        Optional<Categoria> optResposta = this.servico.read(codigo);
        if (optResposta.isPresent() == false){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            Categoria resposta = optResposta.get();
            return new ResponseEntity<Categoria>(resposta, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Categoria> inserir(@RequestBody Categoria instancia){
        if (instancia == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else{
            Categoria resposta =  this.servico.add(instancia);
            return new ResponseEntity<Categoria>(resposta, HttpStatus.CREATED);
        }
    }

    @PutMapping
    public ResponseEntity<Categoria> alterar(@RequestBody Categoria instancia){
        if (instancia == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else{
            if (this.servico.read(instancia.getCodigo()) == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            Categoria resposta = this.servico.edit(instancia);
            return new ResponseEntity<Categoria>(resposta, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Categoria> apagar(@PathVariable Long codigo){
        if (this.servico.read(codigo) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            Categoria resposta = this.servico.delete(codigo);
            return new ResponseEntity<Categoria>(resposta, HttpStatus.OK);
        }
    }
}
