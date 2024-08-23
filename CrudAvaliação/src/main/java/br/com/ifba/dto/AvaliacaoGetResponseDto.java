package br.com.ifba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvaliacaoGetResponseDto {
    @JsonProperty(value = "nome")
    private String name;
    @JsonProperty(value = "descricao")
    private String descricao;
    @JsonProperty(value = "data_avaliacao")
    private Calendar data_avaliacao;
    @JsonProperty(value = "peso")
    private float peso;
}
