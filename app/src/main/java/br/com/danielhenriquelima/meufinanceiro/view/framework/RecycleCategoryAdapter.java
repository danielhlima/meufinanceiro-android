package br.com.danielhenriquelima.meufinanceiro.view.framework;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.danielhenriquelima.domain.entity.Category;
import br.com.danielhenriquelima.meufinanceiro.R;

public class RecycleCategoryAdapter extends RecyclerView.Adapter<RecycleCategoryAdapter.RecycleCategoryViewHolder> {

    public ClickRecyclerViewHelper clickRecyclerViewHelper;
    private List<Category> categories = new ArrayList<Category>();

    public RecycleCategoryAdapter(ClickRecyclerViewHelper clickRecyclerViewHelper){
        this.clickRecyclerViewHelper = clickRecyclerViewHelper;
    }

    @NonNull
    @Override
    public RecycleCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_layout, parent, false);
        return new RecycleCategoryViewHolder((itemView));
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleCategoryViewHolder holder, int position) {
        Category category = categories.get(position);
        holder.tvCategoryName.setText(category.getName());
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    protected class RecycleCategoryViewHolder extends RecyclerView.ViewHolder{

        private TextView tvCategoryName;


        public RecycleCategoryViewHolder(final View itemView){
            super(itemView);

            tvCategoryName = (TextView) itemView.findViewById(R.id.tv_cv_category_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickRecyclerViewHelper.onCustomClick(categories.get(getLayoutPosition()));
                }
            });
        }
    }
}
