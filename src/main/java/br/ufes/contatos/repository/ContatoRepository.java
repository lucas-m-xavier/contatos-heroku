package br.ufes.contatos.repository;

import br.ufes.contatos.model.Contato;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends CrudRepository<Contato, Long> {
}
