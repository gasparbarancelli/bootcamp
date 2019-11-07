package br.com.viasoft.bootcamp.controller;

import br.com.viasoft.bootcamp.framework.CrudRestController;
import br.com.viasoft.bootcamp.framework.CrudService;
import br.com.viasoft.bootcamp.model.Cliente;
import br.com.viasoft.bootcamp.service.ClienteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cliente")
public class ClienteController extends CrudRestController<Cliente, Long> {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Override
    public CrudService<Cliente, Long> getService() {
        return clienteService;
    }

    @GetMapping("complete")
    public List<Cliente> complete(@RequestParam("nome") String nome) {
        return clienteService.complete(nome);
    }

}
