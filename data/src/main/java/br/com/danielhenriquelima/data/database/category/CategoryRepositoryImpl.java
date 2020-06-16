package br.com.danielhenriquelima.data.database.category;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import br.com.danielhenriquelima.data.database.AppDatabase;
import br.com.danielhenriquelima.data.model.CategoryModel;
import br.com.danielhenriquelima.domain.exception.AddNewCategoryException;
import br.com.danielhenriquelima.domain.entity.Category;
import br.com.danielhenriquelima.repository.CategoryRepository;

public class CategoryRepositoryImpl implements CategoryRepository {

    private AppDatabase mDb;

    public CategoryRepositoryImpl(Context context){
        mDb = AppDatabase.getInstance(context);
    }


    @Override
    public List<Category> getAllCategories() {
        List<CategoryModel> categoriModels = mDb.categoryDao().getAllCategories();
        return categoryModelListToCategoryList(categoriModels);
    }

    @Override
    public Category updateCategory(Category category) {
        return null;
    }

    @Override
    public boolean deleteCategory(Category category) {
        return false;
    }

    @Override
    public void createCategory(final Category tCategory) throws AddNewCategoryException{
        try{
            mDb.categoryDao().insertCategory(new CategoryModel(tCategory));
        }catch (Exception e){
            throw new AddNewCategoryException(e.getMessage());
        }
    }

    private List<Category> categoryModelListToCategoryList(List<CategoryModel> categoryModels){
        List<Category> categories = new ArrayList<Category>();
        if(categoryModels != null){
            for(CategoryModel categoryModel : categoryModels) {
                categories.add(new Category(categoryModel.getIdCat(), categoryModel.getName()));
            }
            return categories;
        }
        return null;
    }
}
