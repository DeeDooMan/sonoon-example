package de.logicline.swapp.service;

import de.logicline.swapp.model.Category;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class CategoryServiceImpl {
    @PersistenceContext
    EntityManager em;

    @Transactional
    public void addCategory(Category category) {
        em.persist(category);
    }

    public List<Category> listCategory() {
        CriteriaQuery<Category> c = em.getCriteriaBuilder().createQuery(Category.class);
        c.from(Category.class);
        return em.createQuery(c).getResultList();
    }

    @Transactional
    public void removeCategory(Integer id) {
        Category category = em.find(Category.class, id);
        if (null != category) {
            em.remove(category);
        }
    }
}
