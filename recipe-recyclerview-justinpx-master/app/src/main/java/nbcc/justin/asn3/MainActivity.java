package nbcc.justin.asn3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.LinkedList;

import nbcc.justin.asn3.Model.Recipe;

import static nbcc.justin.asn3.Model.DataProvider.getRecipes;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_MESSAGE = "nbcc.justin.asn3.extra.MESSAGE";
    private LinkedList<Recipe> mRecipeList;
    private RecyclerView mRecyclerView;
    private RecipeViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecipeList = getRecipes();
        mRecyclerView = findViewById(R.id.recycler_view);
        mAdapter = new RecipeViewAdapter(this, mRecipeList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onClick(View view) {
        int pos = mRecyclerView.getChildAdapterPosition(view);
        Recipe recipe = mRecipeList.get(pos);
        Intent intent = new Intent(this, RecipeActivity.class);
        intent.putExtra(EXTRA_MESSAGE, recipe);
        startActivity(intent);
    }
}
