package com.saandeep.contentcalendar.controller;

import com.saandeep.contentcalendar.model.Content;
import com.saandeep.contentcalendar.repository.ContentCollectionRepository;
import com.saandeep.contentcalendar.repository.ContentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/content")
@CrossOrigin
public class ContentController {
    private final ContentRepository repo;

    @Autowired
    public ContentController(ContentRepository repo) {
        this.repo = repo;
    }

    @GetMapping("")
    public List<Content> findAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Content> findById(@PathVariable Integer id) {
        return repo.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Content content) {
        repo.save(content);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/{id}")
    public void update(@RequestBody Content content, @PathVariable Integer id) {
        if(!repo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Content not found");
        }
        repo.save(content);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        if(!repo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Content not found");
        }
        repo.deleteById(id);
    }

    @GetMapping("/filter/{keyword}")
    public List<Content> filterByTitle(@PathVariable String keyword) {
        return repo.findAllByTitleContains(keyword);
    }
}
