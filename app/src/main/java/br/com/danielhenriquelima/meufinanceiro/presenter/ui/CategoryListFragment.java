package br.com.danielhenriquelima.meufinanceiro.presenter.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.danielhenriquelima.domain.pojo.Category;
import br.com.danielhenriquelima.meufinanceiro.R;
import br.com.danielhenriquelima.meufinanceiro.executor.AppExecutors;
import br.com.danielhenriquelima.meufinanceiro.presenter.ui.helper.ClickRecyclerViewHelper;
import br.com.danielhenriquelima.meufinanceiro.presenter.ui.helper.RecycleCategoryAdapter;
import br.com.danielhenriquelima.meufinanceiro.presenter.usecaseimpl.category.GetAllCategoriesPresenter;
import br.com.danielhenriquelima.meufinanceiro.presenter.viewmodel.CategoryViewModel;


public class CategoryListFragment extends Fragment implements ClickRecyclerViewHelper {

    private RecyclerView mReciclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecycleCategoryAdapter mAdapter;
    private CategoryViewModel categoryViewModel;

    private GetAllCategoriesPresenter getAllCategoriesPresenter;


    public CategoryListFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_category_list, container, false);
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            mReciclerView = (RecyclerView) view;
            mLayoutManager = new LinearLayoutManager(context);
            mReciclerView.setLayoutManager(mLayoutManager);
            mAdapter = new RecycleCategoryAdapter(this);
            mReciclerView.setAdapter(mAdapter);

            categoryViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication())
                    .create(CategoryViewModel.class);

            getAllCategoriesPresenter = new GetAllCategoriesPresenter(getActivity().getApplicationContext(),
                    categoryViewModel);
        }

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                getAllCategoriesPresenter.getAllCategories();;
            }
        });

        categoryViewModel.getCategories().observe(getViewLifecycleOwner(), new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> list) {
                mAdapter.setCategories(list);
                mAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onCustomClick(Object object) {
        Log.d("DABUEK", ((Category)object).getName());
    }
}