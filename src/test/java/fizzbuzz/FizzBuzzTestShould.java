package fizzbuzz;

import org.junit.Assert;
import org.junit.Test;

public class FizzBuzzTestShould {
    @Test
    public void createFizzBuzz() {
        Assert.assertNotNull(new FizzBuzzer());
    }

    @Test
    public void give_1_when_input_1() {
        assertFizzBuzzAs("1", 1);
    }

    @Test
    public void give_2_when_input_2() {
        assertFizzBuzzAs("2", 2);
    }

    @Test
    public void give_fizz_when_input_3() {
        assertFizzBuzzAs("fizz", 3);
    }

    @Test
    public void give_4_when_input_4() {
        assertFizzBuzzAs("4", 4);
    }

    @Test
    public void give_buzz_when_input_5() {
        assertFizzBuzzAs("buzz", 5);
    }

    @Test
    public void give_fizz_when_input_6() {
        assertFizzBuzzAs("fizz", 6);
    }

    @Test
    public void give_buzz_when_input_10() {
        assertFizzBuzzAs("buzz", 10);
    }

    @Test
    public void give_fizzbuzz_when_input_15() {
        assertFizzBuzzAs("fizzbuzz", 15);
    }

    private void assertFizzBuzzAs(String expected, int number) {
        FizzBuzzer fizzBuzzer = new FizzBuzzer();
        Assert.assertEquals(expected, fizzBuzzer.fizzBuzzer(number));
    }
}
