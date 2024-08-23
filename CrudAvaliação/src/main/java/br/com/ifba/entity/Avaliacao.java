package br.com.ifba.entity;


import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;
import java.util.Calendar;

@Entity
@Data
@Builder
@Table(name="Avaliacao")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Avaliacao extends PersistenceEntity implements Serializable {

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "descricao",nullable = false, unique = true)
    private String descricao;

    @Column(name = "data_avaliacao",nullable = false, unique = true)
    private Calendar data_avaliacao;

    @Column(name = "peso",nullable = false)
    private float peso;

}

