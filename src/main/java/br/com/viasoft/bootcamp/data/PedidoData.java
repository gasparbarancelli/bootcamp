package br.com.viasoft.bootcamp.data;

import br.com.viasoft.bootcamp.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoData extends JpaRepository<Pedido, Long> {

    List<Pedido> findByClienteId(Long clienteId);

}
