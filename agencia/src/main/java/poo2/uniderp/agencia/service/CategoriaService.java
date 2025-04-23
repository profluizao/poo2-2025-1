package poo2.uniderp.agencia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poo2.uniderp.agencia.pojo.Categoria;
import poo2.uniderp.agencia.repository.ICategoriaRepoJPA;

@Service
public class CategoriaService implements IBaseService<Categoria> {
    
    @Autowired
    private ICategoriaRepoJPA repositorio;

    public CategoriaService(ICategoriaRepoJPA repo){
        this.repositorio = repo;
    }

    @Override
    public List<Categoria> browse() {
        return this.repositorio.findAll();
    }

    @Override
    public Optional<Categoria> read(Long chave) {
        return this.repositorio.findById(chave);
    }

    @Override
    public Categoria edit(Categoria instancia) {
        return this.repositorio.save(instancia);
    }

    @Override
    public Categoria add(Categoria instancia) {
        return this.repositorio.save(instancia);
    }

    @Override
    public Categoria delete(Long chave) {
        Optional<Categoria> optDeletado= this.repositorio.findById(chave);
        if (optDeletado.isPresent() == false){
            return null;
        }
        else{
            Categoria deletado = optDeletado.get();
            this.repositorio.deleteById(chave);
            return deletado;
        }
    }
}
