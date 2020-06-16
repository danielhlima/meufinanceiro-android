package br.com.danielhenriquelima.meufinanceiro.view;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import br.com.danielhenriquelima.domain.entity.Category;

public interface CategoryView {
    public MutableLiveData<List<Category>> getCategories();
    void receiveCategories(List<Category> categories);
    void onSuccess();
    void onError(Throwable throwable);
}
