package br.com.viasoft.bootcamp.data;

import br.com.viasoft.bootcamp.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoData extends JpaRepository<Pedido, Long> {
}
