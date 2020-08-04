package com.pauloazevedo.developers.repository;

import com.pauloazevedo.developers.models.Developer;
import javafx.scene.control.Pagination;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author paulo
 */
public interface DeveloperRepository extends JpaRepository<Developer, Integer>{
    Page<Developer> findByNomeContaining(String nome, Pageable paginacao);
}
