package dmk.jfxamd.utilities.common;

import com.github.javafaker.Faker;
import javafx.concurrent.Task;

public class Utils {

  private static final Faker FAKER = Faker.instance();

  public static Faker faker() {
    return FAKER;
  }

  public static void delay(long millis, Runnable continuation) {
    Task<Void> sleeper = new SleepTask(millis);
    sleeper.setOnSucceeded(event -> continuation.run());
    new Thread(sleeper).start();
  }

  private static final class SleepTask extends Task<Void> {
    private final long millis;

    private SleepTask(long millis) {
      this.millis = millis;
    }

    @Override
    protected Void call() throws Exception {
      try {
        Thread.sleep(millis);
        System.out.println("Ended sleep");
      } catch (InterruptedException e) {
      }
      return null;
    }
  }

}
