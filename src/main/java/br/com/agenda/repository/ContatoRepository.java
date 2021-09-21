package br.com.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.com.agenda.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer> , JpaSpecificationExecutor<Contato> {

}
