package de.logicline.swapp.service;

import de.logicline.swapp.model.Category;

import java.util.List;

public interface CategoryService {
    public void addCategory(Category category);
    public List<Category> listCategory();
    public void removeCategory(Integer id);
}
