package poo2.uniderp.agencia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poo2.uniderp.agencia.pojo.Endereco;
import poo2.uniderp.agencia.repository.IEnderecoRepoJPA;

@Service
public class EnderecoService implements IBaseService<Endereco> {
    
    @Autowired
    private IEnderecoRepoJPA repositorio;

    public EnderecoService(IEnderecoRepoJPA repo){
        this.repositorio = repo;
    }

    @Override
    public List<Endereco> browse() {
        return this.repositorio.findAll();
    }

    @Override
    public Optional<Endereco> read(Long chave) {
        return this.repositorio.findById(chave);
    }

    @Override
    public Endereco edit(Endereco instancia) {
        return this.repositorio.save(instancia);
    }

    @Override
    public Endereco add(Endereco instancia) {
        return this.repositorio.save(instancia);
    }

    @Override
    public Endereco delete(Long chave) {
        Optional<Endereco> optDeletado= this.repositorio.findById(chave);
        if (optDeletado.isPresent() == false){
            return null;
        }
        else{
            Endereco deletado = optDeletado.get();
            this.repositorio.deleteById(chave);
            return deletado;
        }
    }

    @Override
    public Optional<Endereco> delete(Endereco instancia) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

}
