package Practice5;
import de.fhpotsdam.unfolding.UnfoldingMap; //importing unfolding map library 
import de.fhpotsdam.unfolding.providers.Google; //Importing Google map provider
import de.fhpotsdam.unfolding.utils.MapUtils; //importing map utilities for users to interact.
import processing.core.*; //processing library


public class LifeExpectancy extends PApplet {
   
	 
	UnfoldingMap map; //declaring the map using unfolding library
	 public void setup(){
		 size(800,600,OPENGL); //Size of the canvas, using OpenGL 
		 map = new UnfoldingMap(this, 50,50,700,500, new Google.GoogleMapProvider());//Using constructor UnfoldingMap
		 //to create a map on canvas using Google Map provider.
		 MapUtils.createDefaultEventDispatcher(this,map); // build in method in unfolding libraries, that allow users to
		 //interact with the map. For eg- Double-clicking might lead to zooming in the map	 
	 }
	 
	 public void draw(){
	     map.draw(); //draw the map on canvas and can re fresh code based on setup method.
	 }

}
