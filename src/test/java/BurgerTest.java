import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class BurgerTest {

    private Burger burger;
    private Bun bunMock;
    private Ingredient ingredientMock;

    @Parameterized.Parameter
    public String ingredientName;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"cutlet"},
                {"dinosaur"},
                {"sausage"}
        });
    }

    @Before
    public void setUp() {
        bunMock = mock(Bun.class);
        when(bunMock.getName()).thenReturn("Bun");
        when(bunMock.getPrice()).thenReturn(1.5f);

        ingredientMock = mock(Ingredient.class);
        when(ingredientMock.getType()).thenReturn(IngredientType.FILLING);
        when(ingredientMock.getName()).thenReturn("chili sauce");
        when(ingredientMock.getPrice()).thenReturn(2.0f);

        burger = new Burger();
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);
    }

    @Test
    public void testAddIngredient() {
        Ingredient newIngredientMock = mock(Ingredient.class);
        when(newIngredientMock.getType()).thenReturn(IngredientType.FILLING);
        when(newIngredientMock.getName()).thenReturn(ingredientName);
        when(newIngredientMock.getPrice()).thenReturn(1.0f);

        burger.addIngredient(newIngredientMock);

        assertTrue(burger.ingredients.contains(newIngredientMock));
    }

    @Test
    public void testRemoveIngredient() {
        int initialSize = burger.ingredients.size();
        burger.removeIngredient(0);
        assertEquals(initialSize - 1, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        Ingredient initialIngredient = new Ingredient(IngredientType.FILLING, "sausage", 1.0f);
        burger.addIngredient(initialIngredient);

        int initialIndex = 0;
        int newIndex = 1;
        Ingredient movedIngredient = burger.ingredients.get(initialIndex);
        burger.moveIngredient(initialIndex, newIndex);
        assertEquals(movedIngredient, burger.ingredients.get(newIndex));
    }

    @Test
    public void testGetPrice() {
        float bunPrice = 1.5f;
        float sausagePrice = 2.0f;
        float expectedPrice = bunPrice * 2 + sausagePrice;
        assertEquals(expectedPrice, burger.getPrice(), 0.01);
    }

    @Test
    public void testGetReceiptWithNoIngredients() {
        Bun bun = mock(Bun.class);
        when(bun.getName()).thenReturn("white bun");
        when(bun.getPrice()).thenReturn(200.0f);

        Burger burger = new Burger();
        burger.setBuns(bun);

        String receipt = burger.getReceipt();

        Locale.setDefault(Locale.US);
        String expectedReceipt = "(==== white bun ====)\n" +
                "(==== white bun ====)\n" +
                "\n" +
                "Price: 400.0\n";
    }
}