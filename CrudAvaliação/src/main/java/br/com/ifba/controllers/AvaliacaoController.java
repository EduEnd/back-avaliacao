package br.com.ifba.controllers;



import br.com.ifba.dto.AvaliacaoGetResponseDto;
import br.com.ifba.dto.AvaliacaoPostRequestDto;
import br.com.ifba.entity.Avaliacao;
import br.com.ifba.infrastructure.mapper.ObjectMapperUtil;
import br.com.ifba.service.AvaliacaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/avaliacao")
@CrossOrigin("*")
@RequiredArgsConstructor
public class AvaliacaoController {

    private final AvaliacaoService avaliacaoService;
    private final ObjectMapperUtil objectMapperUtil;

    @GetMapping(path = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<AvaliacaoGetResponseDto>>findAll(Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.avaliacaoService.findAll(pageable).map(c -> objectMapperUtil.
                        map(c, AvaliacaoGetResponseDto.class)));
    }

    @GetMapping(path = "/findByName", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>findByName(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(objectMapperUtil.mapAll(
                        this.avaliacaoService.findByName(findByName().toString()),
                        AvaliacaoGetResponseDto.class));
    }

    @GetMapping("/avaliacao/{id}")
    public ResponseEntity<AvaliacaoGetResponseDto> findById(@PathVariable Long id) {
        Avaliacao avaliacao = avaliacaoService.findById(id);
            AvaliacaoGetResponseDto responseDto = objectMapperUtil.map(avaliacao, AvaliacaoGetResponseDto.class);
            return ResponseEntity.ok(responseDto);
        }


    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody @Valid AvaliacaoPostRequestDto avaliacaoPostRequestDto) {
         System.out.println("Recebendo requisição de salvar avaliação: " + avaliacaoPostRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(objectMapperUtil.map(avaliacaoService.save(
                        (objectMapperUtil.map(avaliacaoPostRequestDto, Avaliacao.class))),
                        AvaliacaoGetResponseDto.class));
    }

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> update(@RequestBody @Valid AvaliacaoPostRequestDto avaliacaoPostRequestDto) {
        Avaliacao avaliacao = objectMapperUtil.map(avaliacaoPostRequestDto, Avaliacao.class);
        avaliacaoService.update(avaliacao);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(avaliacaoService.delete(id));
    }
}
