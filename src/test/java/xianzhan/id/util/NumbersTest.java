package xianzhan.id.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author xianzhan
 * @since 2020-07-16
 */
public class NumbersTest {

    @Test
    public void random() {
        for (int i = 1000000; i > 0; i--) {
            int random = Numbers.random(10, 10);
            Assert.assertTrue(random >= 10 && random < 20);
        }
    }

    @Test
    public void setIndexBin() {
        long l = 0;
        for (int i = 0; i < 64; i++) {
            l = Numbers.setIndexBin(l, i, 1);
        }
        Assert.assertEquals(-1L, l);
        l = Numbers.setIndexBin(l, 63, 0);
        Assert.assertEquals(Long.MAX_VALUE, l);
    }

    @Test
    public void listIndexBin() {
        long l = 1;
        List<Integer> integers = Numbers.listIndexBin(l, 1);
        Assert.assertEquals(1, integers.size());
        Integer index = integers.get(0);
        Assert.assertEquals(0, index.intValue());

        l = -1L;
        integers = Numbers.listIndexBin(l, 1);
        Assert.assertEquals(Long.SIZE, integers.size());
    }
}
