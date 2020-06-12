package br.com.danielhenriquelima.meufinanceiro.presenter.ui;

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
    private List<Category> categories = new ArrayList<Category>();
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

        return inflater.inflate(R.layout.fragment_category_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        mReciclerView = (RecyclerView) getView().findViewById(R.id.rv_category_list);
        mLayoutManager = new LinearLayoutManager(getContext());
        mReciclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RecycleCategoryAdapter(getContext(), categories, this);
        mReciclerView.setAdapter(mAdapter);

        categoryViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication())
                .create(CategoryViewModel.class);

        getAllCategoriesPresenter = new GetAllCategoriesPresenter(getActivity().getApplicationContext(),
                categoryViewModel);

        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                getAllCategoriesPresenter.getAllCategories();;
            }
        });

        categoryViewModel.getCategories().observe(getViewLifecycleOwner(), new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> list) {
                categories = list;
            }
        });
    }

    @Override
    public void onCustomClick(Object object) {
        Log.d("DABUEK", ((Category)object).getName());
    }
}