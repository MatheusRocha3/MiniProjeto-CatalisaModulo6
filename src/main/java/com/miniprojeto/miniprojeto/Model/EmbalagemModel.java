package com.miniprojeto.miniprojeto.Model;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "embalagens")
public class EmbalagemModel {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "local-para-cadastro", length = 20, nullable = false)
    private String localCadastro;

}
