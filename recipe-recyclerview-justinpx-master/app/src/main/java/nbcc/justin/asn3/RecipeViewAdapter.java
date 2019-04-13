package nbcc.justin.asn3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import nbcc.justin.asn3.Model.Recipe;

public class RecipeViewAdapter extends RecyclerView.Adapter<RecipeViewAdapter.RecipeViewHolder> {

    private final List<Recipe> mRecipeList;
    private LayoutInflater mInflater;
    private Context mContext;

    public RecipeViewAdapter(Context context, List<Recipe> recipeList){
        mInflater = LayoutInflater.from(context);
        mRecipeList = recipeList;
        mContext = context;
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = mInflater.inflate(R.layout.card_item, viewGroup, false);
        return new RecipeViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder recipeViewHolder, int i) {
        Recipe current = mRecipeList.get(i);
        recipeViewHolder.mRecipeTitleView.setText(current.name);
        recipeViewHolder.mRecipeDescView.setText(current.description);
    }

    @Override
    public int getItemCount() {
        return mRecipeList.size();
    }


    class RecipeViewHolder extends RecyclerView.ViewHolder {
        public final TextView mRecipeTitleView;
        public final TextView mRecipeDescView;
        protected final RecipeViewAdapter mRecipeAdapter;

        public RecipeViewHolder(@NonNull View itemView, RecipeViewAdapter adapter) {
            super(itemView);

            mRecipeTitleView = itemView.findViewById(R.id.name);
            mRecipeDescView = itemView.findViewById(R.id.description);
            mRecipeAdapter = adapter;

            itemView.setOnClickListener((MainActivity)adapter.mContext);
        }
    }
}
