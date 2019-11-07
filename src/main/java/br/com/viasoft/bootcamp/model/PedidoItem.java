package br.com.viasoft.bootcamp.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
@Table(name = "PEDIDO_ITEM")
@Data
@ToString(of = "id")
public class PedidoItem {

    @Id
    @Column(name = "ID_PEDIDO_ITEM")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_PEDIDO")
    private Pedido pedido;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_PRODUTO")
    private Produto produto;

    @Column(name = "VALOR_UNITARIO", nullable = false)
    private BigDecimal valorUnitario;

    @Column(name = "QUANTIDADE", nullable = false)
    private BigDecimal quantidade;

    @Column(name = "DESCONTO", nullable = false)
    private BigDecimal desconto;

    public BigDecimal getValorTotal() {
        var valorTotal = valorUnitario.multiply(quantidade);
        var valorDesconto = getValorDesconto();
        return valorTotal.subtract(valorDesconto);
    }

    public BigDecimal getValorDesconto() {
        var valorTotal = valorUnitario.multiply(quantidade);
        return valorTotal.multiply(desconto)
                .divide(BigDecimal.valueOf(100), 7, RoundingMode.UP);
    }

}
