package net.samumoila.recipebook;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

public class MainActivity extends AppCompatActivity {

    public static RecipeDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Database creation.
        database = Room.databaseBuilder(
                getApplicationContext(),
                RecipeDatabase.class,
                "database-name").allowMainThreadQueries().build();

        RecipeDao recipeDao = database.recipeDao();

        // Add stuff to database.
        Recipe resepti1 = new Recipe();
        resepti1.name = "Veden keitto";
        resepti1.timeRequirement = 6;
        resepti1.mainText = "Laita vettä kattillaan ja laita kattila liedelle. Lorem ipsum.";
        resepti1.imageId = R.drawable.bun;
        recipeDao.insertAll(resepti1);

        // Search in database.
        Recipe resepti2 = recipeDao.findByName("Lihapullat");




    }

    private void InitiateRecipes(RecipeDao recipeDao) {
        Recipe r1 = new Recipe();

        r1.name = "Pizza";
        r1.timeRequirement = 60;
        r1.mainText = "Tämä on pitsareseptin pääteksti ja ohje.\n" +
                "1. Valmistele pohja.\n" +
                "2. Pilko täytteet.\n" +
                "3. Laita täytteet levitetyn pohjan päälle.\n" +
                "4. Paista uunissa.";
        r1.imageId = getResources().
                getIdentifier("pizza", "drawable", getPackageName());

        Recipe r2 = new Recipe();

        r2.name = "Buns";
        r2.timeRequirement = 90;
        r2.mainText = "Tämä on pullan pääteksti ja ohje.\n" +
                "1. Valmistele taikina.\n" +
                "2. Anna kohota.\n" +
                "3. Pyörittele sopivan kokoisia pullia pellille.\n" +
                "4. Paista uunissa.";
        r2.imageId = getResources().
                getIdentifier("bun", "drawable", getPackageName());

        recipeDao.insertAll(r1, r2);
    }
}