package com.atividade5.Categorias.Services;

import com.atividade5.Categorias.Models.CategoriaModel;
import com.atividade5.Categorias.Repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public List<CategoriaModel> findAll(){
        return categoriaRepository.findAll();
    }

    public Optional<CategoriaModel> findById(Long id){
        return categoriaRepository.findById(id);
    }

    public CategoriaModel create(CategoriaModel categoriaModel){
        return categoriaRepository.save(categoriaModel);
    }

    public void delete(Long id){
        categoriaRepository.deleteById(id);
    }

    public CategoriaModel update(CategoriaModel categoriaModel, Long id){
        CategoriaModel newCategoria = categoriaRepository.findById(id).get();
        newCategoria.setNome(categoriaModel.getNome());
        newCategoria.setDescricao(categoriaModel.getDescricao());
        return categoriaRepository.save(newCategoria);
    }
}
