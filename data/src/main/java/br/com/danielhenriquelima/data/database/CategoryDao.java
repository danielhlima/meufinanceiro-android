package br.com.danielhenriquelima.data.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import br.com.danielhenriquelima.data.model.CategoryModel;

@Dao
public interface CategoryDao {

    @Insert
    void insertCategory(CategoryModel entryModel);

    //TODO: LiveData?
    @Query("SELECT * FROM category")
    List<CategoryModel> getAllCategories();
}
