package br.com.danielhenriquelima.repository;

import java.util.List;

import br.com.danielhenriquelima.domain.exception.AddNewCategoryException;
import br.com.danielhenriquelima.domain.model.Category;

public interface CategoryRepository {

    void createCategory(Category category) throws AddNewCategoryException;
    List<Category> getAllCategories();
    Category updateCategory(Category category);
    boolean deleteCategory(Category category);
}
