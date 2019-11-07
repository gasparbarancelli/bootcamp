package br.com.viasoft.bootcamp.service;

import br.com.viasoft.bootcamp.framework.CrudService;
import br.com.viasoft.bootcamp.model.Cliente;

import java.util.List;

public interface ClienteService extends CrudService<Cliente, Long> {

    List<Cliente> complete(String nome);

    List<Cliente> clientesQueCompraramProduto(Long idProduto);
}
