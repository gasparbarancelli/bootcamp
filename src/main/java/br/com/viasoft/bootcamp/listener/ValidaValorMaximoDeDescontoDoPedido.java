package br.com.viasoft.bootcamp.listener;

import br.com.viasoft.bootcamp.event.PedidoPreSave;
import br.com.viasoft.bootcamp.model.PedidoItem;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ValidaValorMaximoDeDescontoDoPedido implements ApplicationListener<PedidoPreSave> {

    private static final BigDecimal DESCONTO_TOTAL = BigDecimal.valueOf(299.90);

    @Override
    public void onApplicationEvent(PedidoPreSave pedidoPreSave) {
        var entity = pedidoPreSave.getPedido();
        var valorTotalDesconto = entity.getPedidoItemList()
                .stream()
                .map(PedidoItem::getValorDesconto)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        if (valorTotalDesconto.compareTo(DESCONTO_TOTAL) > 0) {
            throw new RuntimeException("Valor de desconto acima do permitido");
        }
    }
}
