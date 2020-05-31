package br.com.danielhenriquelima.data.database;

import android.content.Context;
import android.util.Log;

import java.util.List;

import br.com.danielhenriquelima.data.executor.AppExecutors;
import br.com.danielhenriquelima.data.model.CategoryModel;
import br.com.danielhenriquelima.domain.exception.AddNewCategoryException;
import br.com.danielhenriquelima.domain.model.Category;
import br.com.danielhenriquelima.repository.CategoryRepository;

public class CategoryRepositoryImpl implements CategoryRepository {

    private AppDatabase mDb;

    public CategoryRepositoryImpl(Context context){
        mDb = AppDatabase.getInstance(context);
    }

    @Override
    public void createCategory(final Category tCategory) throws AddNewCategoryException{

        try{
            AppExecutors.getInstance().diskIO().execute(new Runnable() {
                @Override
                public void run() {
                    mDb.categoryDao().insertCategory(new CategoryModel(tCategory));
                }
            });
        }catch (Exception e){
            throw new AddNewCategoryException(e.getMessage());
        }
    }

    @Override
    public List<Category> getAllCategories() {

        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                List<CategoryModel> categoryModelList = mDb.categoryDao().getAllCategories();
                int a = 0;
            }
        });
        return null;
    }

    @Override
    public Category updateCategory(Category category) {
        return null;
    }

    @Override
    public boolean deleteCategory(Category category) {
        return false;
    }
}
