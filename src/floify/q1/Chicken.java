package floify.q1;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class Chicken implements Bird {
    public Chicken() {
    }

    @Override
    public Egg lay() {
        return new Egg(new Callable<Bird>() {
            @Override
            public Bird call() throws Exception {
                return new Chicken();
            }
        });
    }

    public static void main(String[] args) throws Exception {
        Chicken chicken = new Chicken();
        System.out.println(chicken instanceof Bird);
    }
}
