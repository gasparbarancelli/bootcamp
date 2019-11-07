package br.com.viasoft.bootcamp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PEDIDO")
@Data
@ToString(of = "id")
public class Pedido {

    @Id
    @Column(name = "ID_PEDIDO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente cliente;

    @Column(name = "DATA_EMISSAO", nullable = false)
    private LocalDate dataEmissao;

    @Column(name = "TOTAL", nullable = false)
    private BigDecimal total;

    @JsonManagedReference
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<PedidoItem> pedidoItemList = new ArrayList<>();

}
