import java.awt.*;

public class Collatz {
   public static void main(String[] args) {
      Collatz collatz = new Collatz();
      collatz.run();
   }

   private void run() {
      ScreenManager screen = new ScreenManager();
      screen.setFullScreen();
      screen.getFullScreen().getContentPane().setBackground(Color.BLACK);

      try {
         Thread.sleep(1000);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }

      int width = screen.getFullScreen().getWidth();
      int height = screen.getFullScreen().getHeight();

      int x = width / 2;
      int y = height / 2;
      double angel = Math.PI / 12;
      int length = 10;

      for(int i = 1; i < 50; i++) {
         Graphics2D g2 = (Graphics2D) screen.getGraphics();
         g2.setColor(Color.WHITE);
         g2.translate(x, y);

         long number = i;
         do {
            if(number % 2 == 0) {
               g2.rotate(angel);
            } else {
               g2.rotate(-angel);
            }
            number = collatz(number);
            g2.drawLine(0,0,length, 0);
            g2.translate(length, 0);
         } while(number != 1);
         g2.dispose();
      }

   }

   private long collatz(long number) {
      if(number % 2 == 0) {
         return number / 2;
      } else {
         return number * 3 + 1;
      }
   }
}
