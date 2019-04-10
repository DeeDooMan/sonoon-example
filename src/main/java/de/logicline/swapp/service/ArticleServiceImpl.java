package de.logicline.swapp.service;

import de.logicline.swapp.model.Article;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class ArticleServiceImpl {
    @PersistenceContext
    EntityManager em;

    @Transactional
    public void addArticle(Article article) {
        em.persist(article);
    }

    public List<Article> listArticle() {
        CriteriaQuery<Article> c = em.getCriteriaBuilder().createQuery(Article.class);
        c.from(Article.class);
        return em.createQuery(c).getResultList();
    }

    @Transactional
    public void removeArticle(Integer id) {
        Article article = em.find(Article.class, id);
        if (null != article) {
            em.remove(article);
        }
    }
}
