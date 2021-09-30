package br.com.agenda.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.agenda.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer> , JpaSpecificationExecutor<Contato> {
	
	@Query("SELECT c FROM Contato c WHERE c.nome = ?1 and c.sobrenome = ?2 and c.dataNascimento = ?3")
	List<Contato> searchByContato(String nome, String sobrenome, LocalDate dataNascimento);

}
