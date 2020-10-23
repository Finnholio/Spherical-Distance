import java.lang.*;
import java.util.*;

class Main {
  public static final double EARTHRADIUS = 6372.795;
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    boolean keepGoing = true;
    while (keepGoing){
      System.out.print("Lat 1 : ");
      double lat1 = scan.nextDouble();
      System.out.print("Long 1 : ");
      double long1 = scan.nextDouble();

      System.out.print("Lat 2 : ");
      double lat2 = scan.nextDouble();
      System.out.print("Long 2 : ");
      double long2 = scan.nextDouble();

      shericalDistance(lat1, long1, lat2, long2);
      System.out.print("Do you want to keep going? : ");
      String keepGoingString = scan.next();
      if (keepGoingString.toCharArray()[0] != 'y'){
        keepGoing = false;
      }
    }
  }


  public static void shericalDistance(double lat1, double long1, double lat2, double long2){
    lat1 = Math.toRadians(lat1);
    long1 = Math.toRadians(long1);
    lat2 = Math.toRadians(lat2);
    long2 = Math.toRadians(long2);

    //sin(lat1) * sin(lat2) + cos(lat1) * cos(lat2) * cos(long1 - long1)
    double distance = Math.acos((Math.sin(lat1) * Math.sin(lat2)) + (Math.cos(lat1) * Math.cos(lat2) * Math.cos(long1-long2)));
    System.out.println("Not Spherical Distance : " + distance);
    System.out.println("Spherical Distance : " + distance * EARTHRADIUS);
  }
}