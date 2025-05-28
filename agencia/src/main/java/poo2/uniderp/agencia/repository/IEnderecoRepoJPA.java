package poo2.uniderp.agencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import poo2.uniderp.agencia.pojo.Endereco;

public interface IEnderecoRepoJPA extends JpaRepository<Endereco, Long> {
    
}
