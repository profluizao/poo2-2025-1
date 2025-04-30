package poo2.uniderp.agencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import poo2.uniderp.agencia.pojo.Produto;

public interface IProdutoRepoJPA extends JpaRepository<Produto, Long> {

}
