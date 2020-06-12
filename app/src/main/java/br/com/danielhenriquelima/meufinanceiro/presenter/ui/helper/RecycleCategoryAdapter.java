package br.com.danielhenriquelima.meufinanceiro.presenter.ui.helper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.danielhenriquelima.domain.pojo.Category;
import br.com.danielhenriquelima.meufinanceiro.R;

public class RecycleCategoryAdapter extends RecyclerView.Adapter<RecycleCategoryAdapter.RecycleCategoryViewHolder> {

    public ClickRecyclerViewHelper clickRecyclerViewHelper;
    protected Context mContext;
    private List<Category> categories;

    public RecycleCategoryAdapter(Context ctx, List<Category> list, ClickRecyclerViewHelper clickRecyclerViewHelper){
        this.mContext = ctx;
        this.categories = list;
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
