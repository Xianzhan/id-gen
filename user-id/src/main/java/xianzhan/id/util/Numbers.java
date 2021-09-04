package xianzhan.id.util;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xianzhan
 * @since 2020-07-16
 */
public class Numbers {

    /**
     * 列举 l 数字在二进制上值为 val 的索引
     *
     * @param l   数字
     * @param val 0 | 1
     * @return list
     */
    public static List<Integer> listIndexBin(long l, int val) {
        if (val != 0 && val != 1) {
            val = 1;
        }
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < Long.SIZE; i++) {
            long s = l >>> i;
            long and = s & 1;
            if (and == val) {
                ret.add(i);
            }
        }
        return ret;
    }

    public static long setIndexBin(long l, int index, int val) {
        if (index < 0) {
            throw new IllegalArgumentException("index: " + index);
        }
        long ret;
        if (val != 0) {
            long or = 1L << index;
            ret = l | or;
        } else {
            long and = ~(1L << index);
            ret = l & and;
        }
        return ret;
    }

    public static int random(int min, int range) {
        int bound = min + range;
        int i = RandomNumberGeneratorHolder.RANDOM_NUMBER_GENERATOR.nextInt(bound);
        if (i < min) {
            i += min;
        }
        return i;
    }

    private static final class RandomNumberGeneratorHolder {
        static final SecureRandom RANDOM_NUMBER_GENERATOR = new SecureRandom();
    }
}
