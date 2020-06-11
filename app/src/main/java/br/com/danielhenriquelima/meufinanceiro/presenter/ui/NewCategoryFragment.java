package br.com.danielhenriquelima.meufinanceiro.presenter.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import br.com.danielhenriquelima.domain.pojo.Category;
import br.com.danielhenriquelima.meufinanceiro.R;
import br.com.danielhenriquelima.meufinanceiro.executor.AppExecutors;
import br.com.danielhenriquelima.meufinanceiro.presenter.usecaseimpl.category.AddNewCategoryPresenter;
import br.com.danielhenriquelima.meufinanceiro.presenter.view.CreateCategoryView;

public class NewCategoryFragment extends Fragment implements CreateCategoryView {

    private ProgressBar progressBar;
    private EditText etNamenewCategory;
    private AddNewCategoryPresenter addNewCategoryPresenter;

    public NewCategoryFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_new_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressBar = (ProgressBar)view.findViewById(R.id.progressBar);
        etNamenewCategory = (EditText)view.findViewById(R.id.et_name_new_category);

        addNewCategoryPresenter = new AddNewCategoryPresenter(getContext(), this);

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

    @Override
    public void onError(Throwable throwable) {
        progressBar.setVisibility(View.GONE);
        etNamenewCategory.setText("");
        Toast.makeText(getContext(), throwable.getMessage(), Toast.LENGTH_LONG).show();
    }
}