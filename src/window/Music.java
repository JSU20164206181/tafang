package window;

import java.applet.AudioClip; 
import java.io.*; 
import java.applet.Applet;
import java.awt.Frame; 
import java.net.MalformedURLException; 
import java.net.URI;
import java.net.URL;
import javax.swing.JFrame;
public class Music extends JFrame{ 
File f;
 URI uri;
 AudioClip aau; 
	URL url; 
	 public void stop(){
		  aau.stop();
    }
    public void star(){
    	 aau.loop();  //Ñ­»·²¥·Å
    }
public  Music(){  
  try {      
     // f = new File("/scr/music/cave.wav"); 
	  f = new File("E:/Java/Java1/tafang/src/music/cave.wav"); 
      System.out.println("test"+f.exists());
      System.out.println("test"+f);
      uri = f.toURI();
      url = uri.toURL();      
      aau = Applet.newAudioClip(url);               	        
  } catch (Exception e) 
  { e.printStackTrace();
  } 
}
 
}