package br.com.ifba.service;



import br.com.ifba.entity.Avaliacao;
import br.com.ifba.exception.BusinessException;
import br.com.ifba.repository.AvaliacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AvaliacaoService implements AvaliacaoIService {

    private final AvaliacaoRepository avaliacaoRepository;

    public Page<Avaliacao> findAll(Pageable pageable) {

        return avaliacaoRepository.findAll(pageable);
    }

    public List<Avaliacao> findByName(String name) {

        return avaliacaoRepository.findByName(name);
    }

    public Avaliacao findById(Long id) {
        return avaliacaoRepository.findById(id)
                .orElseThrow(()->new BusinessException("Recurso não encontrado!"));
    }

    @Transactional
    public Avaliacao save(Avaliacao avaliacao) {
        return avaliacaoRepository.save(avaliacao);
    }

    @Transactional
    public void update(Avaliacao avaliacao) {
        avaliacaoRepository.save(avaliacao);
    }

    public Map<String, String> delete(Long id) {
        avaliacaoRepository.deleteById(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Usuario deletado com sucesso");
        return response;
    }
}

