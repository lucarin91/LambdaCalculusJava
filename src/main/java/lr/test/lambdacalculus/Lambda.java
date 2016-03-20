package lr.test.lambdacalculus;

/**
 * Created by luca on 20/03/16.
 */
public class Lambda {
    public static void main(String[] args) {
        System.out.println("\nLAMBDA CALCULUS..");

        Fun<TwoPar, TwoPar> IF = con -> then -> els -> con.apply(then).apply(els);

        TwoPar TRUE = f1 -> f2 -> f1;
        TwoPar FALSE = f1 -> f2 -> f2;

        Fun<Integer, Integer> SUC = (n) -> n + 1;

        Integer ZERO = 0;

        System.out.println(
                IF.apply(TRUE).apply(_i -> ZERO).apply(_i -> SUC.apply(ZERO)).apply(null)
        );

        System.out.println(
                IF.apply(FALSE).apply(_i -> ZERO).apply(_i -> "test").apply(null)
        );
    }

    interface Fun<T1, T2> {
        T2 apply(T1 f);
    }

    interface TwoPar {
        OnePar apply(Fun<?, ?> f);
    }

    interface OnePar {
        Fun<?,?> apply (Fun<?,?> f);
    }

}
