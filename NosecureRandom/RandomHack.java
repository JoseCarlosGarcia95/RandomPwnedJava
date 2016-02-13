package NosecureRandom;

/**
 * Created by Jose on 05/06/2015.
 */
public class RandomHack {

    private long seed;
    public RandomHack(long seed) {
        this.seed = seed;
    }

    public int next() {
        this.seed = (this.seed * 0x5DEECE66DL + 0xBL) & ((1L << 48) - 1);

        return (int) (seed >>> 16);
    }

    public static RandomHack generate_seed_from_random(int x, int y) {
        long newSeed, magic, uninteger;

        magic = 1;
        for (int i = 1; i <= 32; i++) magic *= 2;

        /* Patch overflow */
        uninteger = (long) x;
        if( x < 0 ) uninteger += magic;

        newSeed = uninteger << 16;

        /* Check when our seed generate our second var */
        while((int)(((++newSeed * 0x5DEECE66DL + 0xBL) & ((1L << 48) - 1)) >>> 16) != y );

        /* Here we go! We've got a seed that complies the two conditions */
        newSeed = (newSeed * 0x5DEECE66DL + 0xBL) & ((1L << 48) - 1);

        return new RandomHack(newSeed);
    }
}
