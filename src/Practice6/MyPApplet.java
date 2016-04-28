package Practice6;
import processing.core.*;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;

public class MyPApplet extends PApplet{ //extends to PApplet 

	 private UnfoldingMap map; //declare a private UnfoldingMap named map
      
      public void setup() {
    	  size(800,600,OPENGL); //setup the canvas for map using open canvas
    	  map = new UnfoldingMap(this,50,50,750,550,new Google.GoogleMapProvider()); //declare a new map and using GOogle Map provider provide size, width, latitud & longigtude for the map
          MapUtils.createDefaultEventDispatcher(this, map); //default mapUtils library to take care of some default events
         
      }
	
      public void draw(){
    	  map.draw();  //continuous loop method to draw the canvas
    	  /* Setting a 2 buttons black & white
    	   * so, that they gives us clickable events.
    	   * Setting up in draw method will help us to put them on top of map
    	   * Calling the method drawButtons to store the button values
    	   *
    	   */
    	  drawButtons();
    	
      }
      
      public void keyPressed(){ //call a key press, method by pressing a key on keyboard the color on the canvas will change
    	  if(key == 'w'){
    		  background(255,255,255); //from processing library
    		  
    	  }
      }
      
      public void drawButtons(){
    	  fill(255,255,255); //methods to add 2 buttons on the top of the map
          rect(100,100,25,25);
          fill(100,100,100);
          rect(100,150,25,25);  
      }
      
      public void mouseReleased(){
    	  if (mouseX > 100 && mouseX < 125 && mouseY>100 && mouseY<125){
    		background(255,255,255);
    	  }else if(mouseX>100 && mouseX<125 && mouseY>150 && mouseY<175){
    		  background(100,100,100);
    		  
    	  } 
      }
}
