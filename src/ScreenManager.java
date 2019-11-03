import javax.swing.*;
import java.awt.*;

public class ScreenManager {

   private GraphicsDevice device;

   public ScreenManager() {
      GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
      device = environment.getDefaultScreenDevice();
   }

   public JFrame getFullScreen() {
      return (JFrame)device.getFullScreenWindow();
   }

   public Graphics getGraphics() {
      Graphics g2 = device.getFullScreenWindow().getGraphics();
      return g2;
   }

   public void setFullScreen(DisplayMode displayMode) {
      JFrame window = new JFrame();
      window.setResizable(false);
      window.setUndecorated(true);

      device.setFullScreenWindow(window);

      if(displayMode != null && device.isDisplayChangeSupported()) {
         try {
            device.setDisplayMode(displayMode);
         } catch(IllegalArgumentException ex) { }
      }
   }

   public void setFullScreen() {
      JFrame window = new JFrame();
      window.setResizable(false);
      window.setUndecorated(true);
      DisplayMode displayMode = device.getDisplayMode();
      device.setFullScreenWindow(window);

      if(displayMode != null && device.isDisplayChangeSupported()) {
         try {
            device.setDisplayMode(displayMode);
         } catch(IllegalArgumentException ex) { }
      }
   }
}
