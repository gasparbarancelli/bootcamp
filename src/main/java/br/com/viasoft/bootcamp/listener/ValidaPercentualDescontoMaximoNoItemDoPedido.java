package br.com.viasoft.bootcamp.listener;

import br.com.viasoft.bootcamp.event.PedidoPreSave;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ValidaPercentualDescontoMaximoNoItemDoPedido implements ApplicationListener<PedidoPreSave> {

    private static final BigDecimal DESCONTO_MAXIMO = BigDecimal.valueOf(30);

    @Override
    public void onApplicationEvent(PedidoPreSave pedidoPreSave) {
        var entity = pedidoPreSave.getPedido();
        var existeDescontoAcimoDoPermitido = entity.getPedidoItemList()
                .stream()
                .anyMatch(pedidoItem -> pedidoItem.getDesconto().compareTo(DESCONTO_MAXIMO) > 0);
        if (existeDescontoAcimoDoPermitido) {
            throw new RuntimeException("Desconto acima do permitido");
        }
    }

}
