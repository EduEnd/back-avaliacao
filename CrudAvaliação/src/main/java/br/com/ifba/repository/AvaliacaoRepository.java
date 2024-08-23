package br.com.ifba.repository;


import br.com.ifba.entity.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {

    public List<Avaliacao> findByName(String name);

    public Optional<Avaliacao> findById(Long id);

}
