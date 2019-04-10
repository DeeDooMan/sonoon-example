package de.logicline.swapp.service;

import de.logicline.swapp.model.Author;

import java.util.List;

public interface AuthorService {
    public void addAuthor(Author author);
    public List<Author> listAuthor();
    public void removeAuthor(Integer id);
}
