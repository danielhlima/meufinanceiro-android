package br.com.danielhenriquelima.data.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import br.com.danielhenriquelima.domain.model.Category;

@Entity(tableName = "category")
public class CategoryModel {

    @PrimaryKey(autoGenerate = true)
    private int idCat;
    private String name;

    public CategoryModel(){}

    public CategoryModel(int id, String name) {
        this.idCat = id;
        this.name = name;
    }

    @Ignore
    public CategoryModel(String name) {
        this.name = name;
    }

    @Ignore
    public CategoryModel(Category category){
        this.idCat = category.getId();
        this.name = category.getName();
    }

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int id) {
        this.idCat = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}