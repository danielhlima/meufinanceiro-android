package br.com.danielhenriquelima.meufinanceiro.presenter.view;

import java.util.List;

import br.com.danielhenriquelima.domain.model.Category;

public interface CategoryView {
    void showCategories(List<Category> categories);
}
