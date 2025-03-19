package poo2.uniderp.agencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import poo2.uniderp.agencia.pojo.Categoria;

public interface ICategoriaRepoJPA extends JpaRepository<Categoria, Long>{

    
}
