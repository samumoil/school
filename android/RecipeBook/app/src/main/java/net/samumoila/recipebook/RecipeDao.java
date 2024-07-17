package net.samumoila.recipebook;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface RecipeDao {

    @Query("SELECT * FROM Recipe WHERE name LIKE :name LIMIT 1")
    Recipe findByName(String name);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Recipe... recipes);
}
