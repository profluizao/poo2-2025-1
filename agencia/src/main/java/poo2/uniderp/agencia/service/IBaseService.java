package poo2.uniderp.agencia.service;

import java.util.List;
import java.util.Optional;

public interface IBaseService<TPojo> {

    List<TPojo> browse();

    Optional<TPojo> read(Long chave);

    TPojo edit(TPojo instancia);

    TPojo add(TPojo instancia);

    TPojo delete(Long chave);

    Optional<TPojo> delete(TPojo instancia);
}
