package Practice5;

import processing.core.*; //processing library

import com.sun.org.apache.xalan.internal.utils.FeatureManager.Feature;

import de.fhpotsdam.unfolding.UnfoldingMap; //importing unfolding map library 
import de.fhpotsdam.unfolding.data.GeoJSONReader;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.providers.Google; //Importing Google map provider
import de.fhpotsdam.unfolding.utils.MapUtils; //importing map utilities for users to interact.

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * visualize the countries based on their life expectancy 
 * 
 *
 */

public class LifeExpectancy extends PApplet {
   
	 
	UnfoldingMap map; //declaring the map using unfolding library
	Map <String, Float> lifeExpByCountry; //A Map shares a key -> Value pairs.
	HashMap<String, Float> lifeExpMap;//Hashmap
	 List<de.fhpotsdam.unfolding.data.Feature> countries; // ordered list of featured object for every  countries 
	 List<Marker> countryMarkers; // similarly we'll have different marker object for different country ordered in a way/
	 
	 public void setup(){
		 size(800,600,OPENGL); //Size of the canvas, using OpenGL 
		 map = new UnfoldingMap(this, 50,50,700,500, new Google.GoogleMapProvider());//Using constructor UnfoldingMap
		 //to create a map on canvas using Google Map provider.
		 MapUtils.createDefaultEventDispatcher(this,map); // build in method in unfolding libraries, that allow users to
		 //interact with the map. For eg- Double-clicking might lead to zooming in the map	 
		// Load lifeExpectancy data
			lifeExpMap = (HashMap<String, Float>) loadLifeExpectancyFromCSV("LifeExpectancyWorldBankModule3.csv");
			println("Loaded " + lifeExpMap.size() + " data entries");
			
		  countries = GeoJSONReader.loadData(this,"data/countries.geo.json");//fetching the JSON fo geo locations from data
		  countryMarkers = MapUtils.createSimpleMarkers(countries); //Create the simple marker for countries using MapUtils.
		  map.addMarkers(countryMarkers); //Display the marker.
		  shadeCountries();
	 }
	 
	 public void draw(){
	     map.draw(); //draw the map on canvas and can re fresh code based on setup method.
	 }

     private Map<String,Float> // Helper private method to call the external file to load life expectancy
                 loadLifeExpectancyFromCSV(String filename){
    	    Map <String, Float> lifeExpMap = new HashMap <String, Float>();// constructor operator to set key values for country and their respective life expectancy.
    	     String[] rows = loadStrings (filename); //Call a string with rows from the filename.
    	     for (String row:rows){ // for each row in the rows of the file, we want to chunk out data that is relevant to us.
    	    	  String [] columns = row.split(","); // So =, we will split columns by a seperater here.
    	    	  if(columns.length ==6 && !columns[5].equals("..")){ 
    	    		   float value = Float.parseFloat(columns[5]);// We will parse the values of 5th column in the column array stored it as a float. 
    	    		   lifeExpMap.put(columns[4], value); // this float is then along with the 4th column is then put into our method
    	    	  }  // Here we have converted a string into a float value to actually, find the columns that are relevant.
    	    	  
    	     }
    	    return lifeExpMap;
     }
     //Helper method to color countries based on life expectancy
     //Red -orange indicates low (near 40)
     //Blue indicates high (around 100)
     private void shadeCountries(){ //Method to shade countries based on Life expectancy 
    	 for (Marker marker:countryMarkers){
    		 String countryId = marker.getId();
    		 if(lifeExpByCountry.containsKey(countryId)){
    			 float lifeExp = lifeExpByCountry.get(countryId);
    			 //Encode value as brightness value(40-100)
    			 int colorLevel = (int) map(lifeExp,40,90,10,255);
    			 marker.setColor(color(255-colorLevel,255,colorLevel));
    			 
    		 }else{
    			 marker.setColor(color(150,150,150));
    		 }
    	 }
     }     
}


