import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    private Database database;
    private static final double DELTA = 0.001;

    @Before
    public void setUp() {
        database = Mockito.mock(Database.class);
    }

    @Test
    public void testIngredientType() {
        List<Ingredient> mockIngredients = Arrays.asList(
                new Ingredient(IngredientType.SAUCE, "hot sauce", 100)
        );
        Mockito.when(database.availableIngredients()).thenReturn(mockIngredients);

        List<Ingredient> ingredients = database.availableIngredients();
        Ingredient ingredient = ingredients.get(0);

        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }

    @Test
    public void testIngredientName() {
        List<Ingredient> mockIngredients = Arrays.asList(
                new Ingredient(IngredientType.SAUCE, "hot sauce", 100)
        );
        Mockito.when(database.availableIngredients()).thenReturn(mockIngredients);

        List<Ingredient> ingredients = database.availableIngredients();
        Ingredient ingredient = ingredients.get(0);

        assertEquals("hot sauce", ingredient.getName());
    }

    @Test
    public void testIngredientPrice() {
        List<Ingredient> mockIngredients = Arrays.asList(
                new Ingredient(IngredientType.SAUCE, "hot sauce", 100)
        );
        Mockito.when(database.availableIngredients()).thenReturn(mockIngredients);

        List<Ingredient> ingredients = database.availableIngredients();
        Ingredient ingredient = ingredients.get(0);

        assertEquals(100, ingredient.getPrice(), DELTA);
    }

    @Test
    public void testGetPrice() {
        List<Ingredient> mockIngredients = Arrays.asList(
                new Ingredient(IngredientType.SAUCE, "hot sauce", 100),
                new Ingredient(IngredientType.FILLING, "cutlet", 100)
        );
        Mockito.when(database.availableIngredients()).thenReturn(mockIngredients);

        List<Ingredient> ingredients = database.availableIngredients();
        Ingredient ingredient = ingredients.get(1);

        assertEquals(100, ingredient.getPrice(), DELTA);
    }

    @Test
    public void testGetName() {
        List<Ingredient> mockIngredients = Arrays.asList(
                new Ingredient(IngredientType.SAUCE, "hot sauce", 100),
                new Ingredient(IngredientType.FILLING, "cutlet", 100),
                new Ingredient(IngredientType.SAUCE, "sour cream", 200)
        );
        Mockito.when(database.availableIngredients()).thenReturn(mockIngredients);

        List<Ingredient> ingredients = database.availableIngredients();
        Ingredient ingredient = ingredients.get(2);

        assertEquals("sour cream", ingredient.getName());
    }

    @Test
    public void testGetType() {
        List<Ingredient> mockIngredients = Arrays.asList(
                new Ingredient(IngredientType.SAUCE, "hot sauce", 100),
                new Ingredient(IngredientType.FILLING, "cutlet", 100),
                new Ingredient(IngredientType.SAUCE, "sour cream", 200),
                new Ingredient(IngredientType.FILLING, "dinosaur", 200),
                new Ingredient(IngredientType.FILLING, "sausage", 300)
        );
        Mockito.when(database.availableIngredients()).thenReturn(mockIngredients);

        List<Ingredient> ingredients = database.availableIngredients();
        Ingredient ingredient = ingredients.get(4);

        assertEquals(IngredientType.FILLING, ingredient.getType());
    }
}