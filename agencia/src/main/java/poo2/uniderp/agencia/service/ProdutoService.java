package poo2.uniderp.agencia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import poo2.uniderp.agencia.pojo.Produto;
import poo2.uniderp.agencia.repository.IProdutoRepoJPA;

@Service
public class ProdutoService implements IBaseService<Produto> {

    @Autowired
    private IProdutoRepoJPA repositorio;

    public ProdutoService(IProdutoRepoJPA repo){
        this.repositorio = repo;
    }

    @Override
    public List<Produto> browse() {
        return this.repositorio.findAll();
    }

    @Override
    public Optional<Produto> read(Long chave) {
        return this.repositorio.findById(chave);
    }

    @Override
    public Produto edit(Produto instancia) {
        return this.repositorio.save(instancia);
    }

    @Override
    public Produto add(Produto instancia) {
        return this.repositorio.save(instancia);
    }

    @Override
    public Produto delete(Long chave) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Optional<Produto> delete(Produto instancia) {
        Optional<Produto> optDeletado = 
            this.repositorio.findById(instancia.getCodigo());
        if (optDeletado.isPresent() == false){
            return null;
        }
        else{
            return optDeletado;
        }
    }

    public Page<Produto> listarProdutosPaginados(int page, int size){
        Pageable pg = PageRequest.of(page, size);
        return this.repositorio.findAll(pg);
    }
    
}
