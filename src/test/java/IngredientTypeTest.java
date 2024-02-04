import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void testIngredientTypeEnumLength() {
        assertEquals(2, IngredientType.values().length);
    }

    @Test
    public void testIngredientTypeEnumSauce() {
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void testIngredientTypeEnumFilling() {
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }
}
