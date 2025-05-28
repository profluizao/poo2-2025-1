package poo2.uniderp.agencia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import poo2.uniderp.agencia.pojo.Funcionario;
import poo2.uniderp.agencia.repository.IFuncionarioRepoJPA;

@Service
public class FuncionarioService implements IBaseService<Funcionario> {
    
    @Autowired
    private IFuncionarioRepoJPA repositorio;

    public FuncionarioService(IFuncionarioRepoJPA repo){
        this.repositorio = repo;
    }

    @Override
    public List<Funcionario> browse() {
        return this.repositorio.findAll();
    }

    @Override
    public Optional<Funcionario> read(Long chave) {
        return this.repositorio.findById(chave);
    }

    @Override
    public Funcionario edit(Funcionario instancia) {
        return this.repositorio.save(instancia);
    }

    @Override
    public Funcionario add(Funcionario instancia) {
        return this.repositorio.save(instancia);
    }

    @Override
    public Funcionario delete(Long chave) {
        Optional<Funcionario> optDeletado= this.repositorio.findById(chave);
        if (optDeletado.isPresent() == false){
            return null;
        }
        else{
            Funcionario deletado = optDeletado.get();
            this.repositorio.deleteById(chave);
            return deletado;
        }
    }

    @Override
    public Optional<Funcionario> delete(Funcionario instancia) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }
}