package de.logicline.swapp.service;

import de.logicline.swapp.model.Article;

import java.util.List;

public interface ArticleService {
    public void addArticle(Article article);
    public List<Article> listArticle();
    public void removeArticle(Integer id);
}
