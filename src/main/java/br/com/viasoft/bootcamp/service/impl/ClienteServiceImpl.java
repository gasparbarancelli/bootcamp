package br.com.viasoft.bootcamp.service.impl;

import br.com.viasoft.bootcamp.data.ClienteData;
import br.com.viasoft.bootcamp.framework.CrudServiceImpl;
import br.com.viasoft.bootcamp.model.Cliente;
import br.com.viasoft.bootcamp.service.ClienteService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteServiceImpl extends CrudServiceImpl<Cliente, Long> implements ClienteService {

    private final ClienteData clienteData;

    public ClienteServiceImpl(ClienteData clienteData) {
        this.clienteData = clienteData;
    }

    @Override
    public JpaRepository<Cliente, Long> getRepository() {
        return clienteData;
    }

    @Override
    @HystrixCommand(fallbackMethod = "listaVazia")
    public List<Cliente> findAll() {
        return super.findAll();
    }

    public List<Cliente> listaVazia() {
        return new ArrayList<>();
    }

    @Override
    @HystrixCommand(fallbackMethod = "startingWith")
    @Cacheable("cliente-complete")
    public List<Cliente> complete(String nome) {
        return clienteData.findByNomeContaining(nome, PageRequest.of(0, 20));
    }

    @Override
    public List<Cliente> clientesQueCompraramProduto(Long idProduto) {
        return clienteData.clientesQueCompraramProduto(idProduto);
    }

    public List<Cliente> startingWith(String nome) {
        return clienteData.findByNomeStartingWith(nome, PageRequest.of(0, 20));
    }

}
