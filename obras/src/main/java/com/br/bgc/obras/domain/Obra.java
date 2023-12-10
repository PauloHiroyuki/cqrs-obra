package com.br.bgc.obras.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(schema = "OBRA", name = "OBRA")
public class Obra {
    @Id
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(name = "ID")
    private String id;

    @Setter
    @Column(name = "NOME")
    private String nome;

    @Setter
    @Column(name = "ENDERECO")
    private String endereco;


}
