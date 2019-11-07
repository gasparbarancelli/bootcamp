package br.com.viasoft.bootcamp.listener;

import br.com.viasoft.bootcamp.event.PedidoPreSave;
import br.com.viasoft.bootcamp.model.PedidoItem;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DefineOValorTotalDoPedido implements ApplicationListener<PedidoPreSave> {

    @Override
    public void onApplicationEvent(PedidoPreSave pedidoPreSave) {
        var entity = pedidoPreSave.getPedido();
        var total = entity.getPedidoItemList()
                .stream()
                .map(PedidoItem::getValorTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        entity.setTotal(total);
    }
}
