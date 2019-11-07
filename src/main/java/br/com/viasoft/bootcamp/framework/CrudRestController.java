package br.com.viasoft.bootcamp.framework;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public abstract class CrudRestController<T, ID> {

    public abstract CrudService<T, ID> getService();

    @GetMapping
    public List<T> findAll() {
        return getService().findAll();
    }

    @GetMapping("{id}")
    public Optional<T> findOne(@PathVariable("id") ID id) {
        return getService().findOne(id);
    }

    @PostMapping
    public T save(@RequestBody T entity) {
        return getService().save(entity);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") ID id) {
        getService().delete(id);
    }

}
