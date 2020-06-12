package br.com.danielhenriquelima.meufinanceiro.presenter.view;

import java.util.List;

import br.com.danielhenriquelima.domain.pojo.Category;

public interface CategoryView {
    void receiveCategories(List<Category> categories);
}
