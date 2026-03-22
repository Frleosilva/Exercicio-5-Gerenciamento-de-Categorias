package com.atividade5.Categorias.Repositories;

import com.atividade5.Categorias.Models.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {
}
