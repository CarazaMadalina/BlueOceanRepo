import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertTrue;

public class BlueOceanTest {

    @Test
    public void firstTest() {
        System.out.println("First test");
        long currentTime = System.currentTimeMillis();
        assertTrue("the time is not correct" , currentTime > 0);
    }

    @Test
    public void secondTest() {
        System.out.println("Second test");
        String title = "Jenkins workshop";
        assertTrue("The string does not contain 'Jenkins' word", title.contains("Jenkins"));
    }

    @Test
    public void thirdTest() {
        System.out.println("Third test");
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        assertTrue("The number is 52", randomNumber != 52);
    }
    
     @Test
    public void fourthTest() {
        System.out.println("Fourth test");
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        assertTrue("The number is 12", randomNumber != 12);
    }
}
