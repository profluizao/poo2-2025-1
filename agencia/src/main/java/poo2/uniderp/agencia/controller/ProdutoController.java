package poo2.uniderp.agencia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import poo2.uniderp.agencia.pojo.Produto;
import poo2.uniderp.agencia.service.ProdutoService;

@RestController
@RequestMapping("/api/agencia/almoxarifado/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService servico;

    public ProdutoController(ProdutoService srv){
        this.servico = srv;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> obterTodos(){
        List<Produto> lista = this.servico.browse();
        return new ResponseEntity<List<Produto>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Produto> obterPorId(@PathVariable Long codigo){
        Optional<Produto> optResposta = this.servico.read(codigo);
        if (optResposta.isPresent() == false){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            Produto resposta = optResposta.get();
            return new ResponseEntity<Produto>(resposta, HttpStatus.OK);
        }
    }

    @GetMapping("/{page}/{size}")
    public Page<Produto> listarProdutosPaginados(@PathVariable int page, @PathVariable int size){
        return this.servico.listarProdutosPaginados(page, size);
    }

    @PostMapping
    public ResponseEntity<Produto> inserir(@RequestBody Produto instancia){
        if (instancia == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else{
            Produto resposta =  this.servico.add(instancia);
            return new ResponseEntity<Produto>(resposta, HttpStatus.CREATED);
        }
    }

    @PutMapping
    public ResponseEntity<Produto> alterar(@RequestBody Produto instancia){
        if (instancia == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else{
            if (this.servico.read(instancia.getCodigo()) == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            Produto resposta = this.servico.edit(instancia);
            return new ResponseEntity<Produto>(resposta, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Produto> apagar(@PathVariable Long codigo){
        if (this.servico.read(codigo) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            Produto resposta = this.servico.delete(codigo);
            return new ResponseEntity<Produto>(resposta, HttpStatus.OK);
        }
    }
}
