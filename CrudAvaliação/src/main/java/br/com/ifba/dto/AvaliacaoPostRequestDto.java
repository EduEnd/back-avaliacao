package br.com.ifba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvaliacaoPostRequestDto {
    @JsonProperty(value = "nome")
    @NotNull( message = "O nome é obrigatório!")
    @NotBlank(message = "O nome não pode ser vazio!")
    private String name;

    @JsonProperty(value = "descricao")
    @NotNull( message = "A descricao é obrigatória!")
    @NotBlank(message = " A descricao não pode ser vazia!")
    @Size(min = 20, max = 150, message = "A descricao precisa" +
            "ter pelo menos 20 caracteres e 150 no máximo!")
    private String descricao;

    @JsonProperty(value = "data_avaliacao")
    @NotNull(message = "A data da avaliacao é obrigatória!")
    @NotBlank(message= "A data da avaliacao não pode ser vazia!")
    private Calendar data_avaliacao;

    @JsonProperty(value = "peso")
    @NotNull(message = "O peso é obrigatório!")
    @NotBlank(message= "O peso não pode ser vazio!")
    private float peso;
}
