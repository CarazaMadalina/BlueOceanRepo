import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertTrue;

public class BlueOceanTest {

    @Test
    public void firstTest() {
        long currentTime = System.currentTimeMillis();
        assertTrue("the time is not correct" , currentTime > 0);
    }

    @Test
    public void secondTest() {
        String title = "Jenkins workshop";
        assertTrue("The string does not contain 'Jenkins' word", title.contains("Jenkins"));
    }

    @Test
    public void thirdTest() {
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        assertTrue("The number is 5", randomNumber != 5);
    }
}
