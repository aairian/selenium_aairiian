package lesson_2;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by selenium on 13.07.2015.
 */
public class PrimeTest {

    @Test
    public void isPrimeNumberTesst (){

        Assert.assertTrue(isPrime(8));
    }

    boolean isPrime(int N) {
        if (N < 2) return false;
        for (int i = 2; i*i <= N; i++)
            if (N % i == 0) return false;
        return true;
    }


}
