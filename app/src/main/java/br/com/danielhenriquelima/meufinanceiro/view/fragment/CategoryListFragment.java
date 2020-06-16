package br.com.danielhenriquelima.meufinanceiro.view.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.List;

import br.com.danielhenriquelima.domain.entity.Category;
import br.com.danielhenriquelima.meufinanceiro.NavGraphDirections;
import br.com.danielhenriquelima.meufinanceiro.R;
import br.com.danielhenriquelima.meufinanceiro.view.helper.ClickRecyclerViewHelper;
import br.com.danielhenriquelima.meufinanceiro.view.helper.RecycleCategoryAdapter;
import br.com.danielhenriquelima.meufinanceiro.viewmodel.CategoryViewModel;


public class CategoryListFragment extends Fragment implements ClickRecyclerViewHelper {

    private RecyclerView mReciclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecycleCategoryAdapter mAdapter;
    private CategoryViewModel categoryViewModel;
    private LinearLayout rvLinearLayout;
    private LinearLayout noListLinearLayout;

    public CategoryListFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_category_list, container, false);
        Context context = view.getContext();
        mReciclerView = (RecyclerView) view.findViewById(R.id.rv_category_list);
        mLayoutManager = new LinearLayoutManager(context);
        mReciclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RecycleCategoryAdapter(this);
        mReciclerView.setAdapter(mAdapter);
        categoryViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication())
                .create(CategoryViewModel.class);

        rvLinearLayout = (LinearLayout)view.findViewById(R.id.ll_rcv_category_list);
        noListLinearLayout = (LinearLayout)view.findViewById(R.id.ll_rcv_no_category_list);

        ((Button)view.findViewById(R.id.bt_ok_new_category_from_list)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(getActivity(), R.id.nav_host).navigate(NavGraphDirections.actionGlobalDestNewCategory());
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        categoryViewModel.getCategories().observe(getViewLifecycleOwner(), new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> list) {

                if(list.isEmpty()){
                    noListLinearLayout.setVisibility(View.VISIBLE);
                    rvLinearLayout.setVisibility(View.INVISIBLE);
                }else{
                    noListLinearLayout.setVisibility(View.INVISIBLE);
                    rvLinearLayout.setVisibility(View.VISIBLE);
                    mAdapter.setCategories(list);
                    mAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    public void onCustomClick(Object object) {
        Navigation.findNavController(getActivity(), R.id.nav_host).navigate(NavGraphDirections.actionGlobalDestNewEntry());
    }
}