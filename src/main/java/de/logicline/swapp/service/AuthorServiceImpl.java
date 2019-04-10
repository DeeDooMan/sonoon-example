package de.logicline.swapp.service;

import de.logicline.swapp.model.Author;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class AuthorServiceImpl {
    @PersistenceContext
    EntityManager em;

    @Transactional
    public void addAuthor(Author author) {
        em.persist(author);
    }

    public List<Author> listAuthor() {
        CriteriaQuery<Author> c = em.getCriteriaBuilder().createQuery(Author.class);
        c.from(Author.class);
        return em.createQuery(c).getResultList();
    }

    @Transactional
    public void removeAuthor(Integer id) {
        Author author = em.find(Author.class, id);
        if (null != author) {
            em.remove(author);
        }
    }
}
