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

import poo2.uniderp.agencia.pojo.Endereco;
import poo2.uniderp.agencia.service.EnderecoService;

@RestController
@RequestMapping("/api/agencia/recursoshumanos/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoService servico;

    public EnderecoController(EnderecoService srv){
        this.servico = srv;
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> obterTodos(){
        List<Endereco> lista = this.servico.browse();
        return new ResponseEntity<List<Endereco>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Endereco> obterPorId(@PathVariable Long codigo){
        Optional<Endereco> optResposta = this.servico.read(codigo);
        if (optResposta.isPresent() == false){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            Endereco resposta = optResposta.get();
            return new ResponseEntity<Endereco>(resposta, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Endereco> inserir(@RequestBody Endereco instancia){
        if (instancia == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else{
            Endereco resposta =  this.servico.add(instancia);
            return new ResponseEntity<Endereco>(resposta, HttpStatus.CREATED);
        }
    }

    @PutMapping
    public ResponseEntity<Endereco> alterar(@RequestBody Endereco instancia){
        if (instancia == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else{
            if (this.servico.read(instancia.getCodigo()) == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            Endereco resposta = this.servico.edit(instancia);
            return new ResponseEntity<Endereco>(resposta, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Endereco> apagar(@PathVariable Long codigo){
        if (this.servico.read(codigo) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            Endereco resposta = this.servico.delete(codigo);
            return new ResponseEntity<Endereco>(resposta, HttpStatus.OK);
        }
    }    
}
