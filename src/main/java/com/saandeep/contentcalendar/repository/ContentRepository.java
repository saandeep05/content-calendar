package com.saandeep.contentcalendar.repository;

import com.saandeep.contentcalendar.model.Content;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {
    public List<Content> findAllByTitleContains(String keyword);
}
