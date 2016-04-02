package Practice3;
import processing.core.*;

public class MyPApplet extends PApplet {
	private String URL = "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b3/Haleiwa_beach_park_-_trees.jpg/800px-Haleiwa_beach_park_-_trees.jpg";
	private PImage backgroundImg;
	
	public void setup(){
		size(200,200); //size of our window/canvas
		background(255);//canvas color
		stroke(0); // canvas pen color
		backgroundImg = loadImage(URL,"jpg"); //loading the image via url
	}
	public void draw(){
		int[] color = sunColorSec(second());  //calculate the color code for sun every second
		 fill(color[1],color[2],color[3]); //set sun color
		backgroundImg.resize(0, height);// resizing the image to fit the canvas
		image(backgroundImg, 0,0); //setting the background from the top
	
		ellipse(width/4, height/5, width/5, height/5);//draw sun
		
	}
	 public int[] sunColorSec(float seconds){
		  int rgb [] = new int[3];
		   //Scale  the brightness of the sun using seconds. 0 second
		  // is back. 30 seconds is Yellow.
		  float diffFrom30 = Math.abs(30-seconds);
		  
		  float ratio = diffFrom30/30;
		  rgb[0] = (int) (255 * ratio);
		  rgb[1] = (int)(255*ratio);
		  rgb[2] = 0;
		   //System.out.println("R: " + rgb[0] + "B: "+ rgb[1] + "G: " + rgb[2] );
		  return rgb;
	 }

}
