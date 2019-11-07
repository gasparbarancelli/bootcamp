package br.com.viasoft.bootcamp.event;

import br.com.viasoft.bootcamp.model.Pedido;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

public class PedidoPreSave extends ApplicationEvent {

    @Getter
    private Pedido pedido;

    public PedidoPreSave(Object source, Pedido pedido) {
        super(source);
        this.pedido = pedido;
    }

}
