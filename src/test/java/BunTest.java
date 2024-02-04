import praktikum.Bun;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(Parameterized.class)
public class BunTest {

    private final String bunName;
    private final float bunPrice;

    public BunTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Стандартная булочка", 1.5f},
                {"Булочка без цены", 0.0f},
                {"Булочка с отрицательной ценой", -1.0f}
        });
    }

    @Test
    public void testBunConstructor() {
        Bun bun = new Bun(bunName, bunPrice);

        assertEquals(bunName, bun.getName());
        assertEquals(bunPrice, bun.getPrice(), 0.001);
    }

    @Test
    public void testGetName() {
        Bun bun = new Bun(bunName, bunPrice);
        assertEquals(bunName, bun.getName());
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun(bunName, bunPrice);
        assertEquals(bunPrice, bun.getPrice(), 0.001);
    }

    @Test
    public void testBunWithZeroPrice() {
        Bun bun = new Bun(bunName, 0.0f);
        assertEquals(bunName, bun.getName());
        assertEquals(0.0f, bun.getPrice(), 0.001);
    }
}