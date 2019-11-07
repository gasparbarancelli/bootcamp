package br.com.viasoft.bootcamp.data;

import br.com.viasoft.bootcamp.model.Cliente;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteData extends JpaRepository<Cliente, Long> {

    List<Cliente> findByNomeContaining(String nome, Pageable pageable);

    List<Cliente> findByNomeStartingWith(String nome, Pageable pageable);


}
