package poo2.uniderp.agencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import poo2.uniderp.agencia.pojo.Funcionario;

public interface IFuncionarioRepoJPA extends JpaRepository<Funcionario, Long>{
    
}
