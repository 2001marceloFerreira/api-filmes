package br.com.apifilmesseriesfree.repositories;

import br.com.apifilmesseriesfree.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
}
