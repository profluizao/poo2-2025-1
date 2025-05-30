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

import poo2.uniderp.agencia.pojo.Funcionario;
import poo2.uniderp.agencia.service.FuncionarioService;

@RestController
@RequestMapping("/api/agencia/recursoshumanos/funcionario")
public class FuncionarioController {
    @Autowired
    private FuncionarioService servico;

    public FuncionarioController(FuncionarioService srv){
        this.servico = srv;
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> obterTodos(){
        List<Funcionario> lista = this.servico.browse();
        return new ResponseEntity<List<Funcionario>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Funcionario> obterPorId(@PathVariable Long codigo){
        Optional<Funcionario> optResposta = this.servico.read(codigo);
        if (optResposta.isPresent() == false){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            Funcionario resposta = optResposta.get();
            return new ResponseEntity<Funcionario>(resposta, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Funcionario> inserir(@RequestBody Funcionario instancia){
        if (instancia == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else{
            Funcionario resposta =  this.servico.add(instancia);
            return new ResponseEntity<Funcionario>(resposta, HttpStatus.CREATED);
        }
    }

    @PutMapping
    public ResponseEntity<Funcionario> alterar(@RequestBody Funcionario instancia){
        if (instancia == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else{
            if (this.servico.read(instancia.getCodigo()) == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            Funcionario resposta = this.servico.edit(instancia);
            return new ResponseEntity<Funcionario>(resposta, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Funcionario> apagar(@PathVariable Long codigo){
        if (this.servico.read(codigo) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            Funcionario resposta = this.servico.delete(codigo);
            return new ResponseEntity<Funcionario>(resposta, HttpStatus.OK);
        }
    }

}
