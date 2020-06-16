package br.com.danielhenriquelima.meufinanceiro.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


import br.com.danielhenriquelima.domain.entity.Category;
import br.com.danielhenriquelima.meufinanceiro.R;
import br.com.danielhenriquelima.device.executor.AppExecutors;
import br.com.danielhenriquelima.meufinanceiro.presenter.category.AddNewCategoryPresenter;
import br.com.danielhenriquelima.meufinanceiro.viewmodel.CategoryViewModel;

public class NewCategoryFragment extends BaseFragment{

    private ProgressBar progressBar;
    private EditText etNamenewCategory;
    private AddNewCategoryPresenter addNewCategoryPresenter;
    private CategoryViewModel categoryViewModel;

    public NewCategoryFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        categoryViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication())
                .create(CategoryViewModel.class);
        categoryViewModel.setBaseFragment(this);

        View view = inflater.inflate(R.layout.fragment_new_category, container, false);
        progressBar = (ProgressBar)view.findViewById(R.id.progressBar);
        etNamenewCategory = (EditText)view.findViewById(R.id.et_name_new_category);

        addNewCategoryPresenter = new AddNewCategoryPresenter(getContext(), categoryViewModel);

        ((Button)view.findViewById(R.id.bt_ok_new_category)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(etNamenewCategory.getText().toString())){
                    Toast.makeText(getContext(), "Nome da Categoria não pode estar em branco.", Toast.LENGTH_LONG).show();
                }else{
                    progressBar.setVisibility(View.VISIBLE);
                    createNewCategory(etNamenewCategory.getText().toString());
                }
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private void createNewCategory(final String name){
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                addNewCategoryPresenter.addNewCategory(new Category(name));
            }
        });
    }

    @Override
    public void onSuccess() {
        progressBar.setVisibility(View.GONE);
        etNamenewCategory.setText("");
        Toast.makeText(getContext(), "Categoria criada com sucesso.", Toast.LENGTH_LONG).show();
    }

    public void onError(Throwable throwable) {
        progressBar.setVisibility(View.GONE);
        etNamenewCategory.setText("");
        Toast.makeText(getContext(), throwable.getMessage(), Toast.LENGTH_LONG).show();
    }
}