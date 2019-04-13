package nbcc.justin.asn3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import nbcc.justin.asn3.Model.Recipe;

import com.squareup.picasso.Picasso;

public class RecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        TextView name = findViewById(R.id.name);
        ImageView image = findViewById(R.id.recipe_image);
        TextView ingredients = findViewById(R.id.ingredients);
        TextView directions = findViewById(R.id.directions);

        Recipe recipe = (Recipe) intent.getSerializableExtra(MainActivity.EXTRA_MESSAGE);

        name.setText(recipe.name);
        ingredients.setText(recipe.ingredients);
        directions.setText(recipe.directions);
        Picasso.get().load(recipe.image).fit().placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background).into(image);
    }
}
