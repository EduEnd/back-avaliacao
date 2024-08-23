package br.com.ifba.service;

import br.com.ifba.entity.Avaliacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface AvaliacaoIService {

    public Page<Avaliacao> findAll(Pageable pageable);
    public List<Avaliacao> findByName(String name);
    public Avaliacao findById(Long id);
    public Avaliacao save(Avaliacao avaliacao);
    public void update(Avaliacao avaliacao);
    public Map<String, String> delete(Long id);
}
