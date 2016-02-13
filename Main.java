import NosecureRandom.RandomHack;

import java.util.Random;

public class Main {

    public static void main(String[] args) {


        Random rnd = new Random();

        int x = rnd.nextInt();
        int y = rnd.nextInt();


        System.out.println(x);
        System.out.println(y);

        RandomHack h = RandomHack.generate_seed_from_random(x, y);

        System.out.println(rnd.nextInt());
        System.out.println(h.next());

    }
}
