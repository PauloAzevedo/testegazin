package com.pauloazevedo.developers.controller;

import com.pauloazevedo.developers.dto.DeveloperDto;
import com.pauloazevedo.developers.form.DeveloperForm;
import com.pauloazevedo.developers.models.Developer;
import com.pauloazevedo.developers.repository.DeveloperRepository;
import java.net.URI;
import java.util.Optional;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author paulo
 */
@RestController
@RequestMapping("/developers")
public class DeveloperController {

    @Autowired
    private DeveloperRepository developerRepository;

    @GetMapping
    public Page<DeveloperDto> lista(@RequestParam(required = false) String descricao,
            @PageableDefault(sort = "id", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable paginacao, @AuthenticationPrincipal Authentication usuarioLogado) {
        if (descricao == null || descricao.equals("")) {
            Page<Developer> devs = developerRepository.findAll(paginacao);
            return DeveloperDto.converter(devs);
        } else {
            Page<Developer> devs = developerRepository.findByNomeContaining(descricao, paginacao);
            return DeveloperDto.converter(devs);
        }        
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detalhar(@PathVariable Integer id, @AuthenticationPrincipal Authentication usuarioLogado) {
        Optional<Developer> dev = developerRepository.findById(id);
        if (dev.isPresent()) {
            return ResponseEntity.ok(new DeveloperDto(dev.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid DeveloperForm clienteF, UriComponentsBuilder uriBuilder) {
        Developer dev = clienteF.converter(developerRepository);
        developerRepository.save(dev);
        URI uri = uriBuilder.path("/developers/{id}").buildAndExpand(dev.getId()).toUri();
        return ResponseEntity.created(uri).body(new DeveloperDto(dev));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> atualizar(@PathVariable Integer id, @RequestBody @Valid DeveloperForm devForm, @AuthenticationPrincipal Authentication usuarioLogado) {
        Optional<Developer> opt = developerRepository.findById(id);
        if (opt.isPresent()) {
            Developer devEditavel = devForm.atualizar(id, developerRepository);
            return ResponseEntity.ok(new DeveloperDto(devEditavel));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Integer id, @AuthenticationPrincipal Authentication usuarioLogado) {
        Optional<Developer> opt = developerRepository.findById(id);
        if (!opt.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        developerRepository.delete(opt.get());
        return ResponseEntity.ok().build();
    }

}
