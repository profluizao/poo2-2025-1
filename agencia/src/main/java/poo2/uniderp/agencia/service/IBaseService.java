package poo2.uniderp.agencia.service;

import java.util.List;

public interface IBaseService<TPojo> {

    List<TPojo> browse();

    TPojo read(Long chave);

    TPojo edit(TPojo instancia);

    TPojo add(TPojo instancia);

    TPojo delete(Long chave);
}
