package br.com.viasoft.bootcamp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "CLIENTE")
@Data
@NoArgsConstructor
@ToString(of = "id")
public class Cliente {

    @Id
    @Column(name = "ID_CLIENTE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME", length = 100, nullable = false)
    private String nome;

    @Column(name = "CPF", length = 11, nullable = false)
    private String cpf;

    @Column(name = "TELEFONE", length = 20, nullable = false)
    private String telefone;

    public Cliente(Long id) {
        this.id = id;
    }

}
