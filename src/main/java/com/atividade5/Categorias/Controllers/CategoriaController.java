package com.atividade5.Categorias.Controllers;

import com.atividade5.Categorias.Models.CategoriaModel;
import com.atividade5.Categorias.Services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaModel>> findAll(){
        List<CategoriaModel> lista = categoriaService.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaModel> findById(@PathVariable Long id){
        CategoriaModel categoria = categoriaService.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        return ResponseEntity.ok().body(categoria);
    }

    @PostMapping
    public ResponseEntity<CategoriaModel> create(@RequestBody CategoriaModel categoriaModel){
        CategoriaModel request = categoriaService.create(categoriaModel);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(request.getId())
                .toUri();

        return ResponseEntity.created(uri).body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public CategoriaModel atualizar(@PathVariable Long id, @RequestBody CategoriaModel categoriaModel){
        return categoriaService.update(categoriaModel, id);
    }
}