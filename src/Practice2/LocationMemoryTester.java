package Practice2;

public class LocationMemoryTester {
	 public static void main (String[] args){
		 SimpleLocation uscd = new SimpleLocation(32.9, -117.2);
		 SimpleLocation kumamoto = new SimpleLocation(32.0, 130.0);
		 uscd = kumamoto;
		 kumamoto = uscd;
		 //System.out.println("USCD: "+ uscd.latitude + " ,longitude: " + uscd.longitude);
		//System.out.println("Kumamoto: "+ kumamoto.latitude + " ,longitude: " + kumamoto.longitude);
		 
		 double[] coords = {5.0, 0.0};
		 ArrayLocation accra = new ArrayLocation(coords);
		 
		 coords[0] = 32.9;
		 coords[1] = -117.2;
		 System.out.println(accra.coords[0]);
		 
		 
	 }

}
