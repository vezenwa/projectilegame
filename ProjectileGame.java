/*
 * Name: Valentine Ugochukwu Ezenwa
 * Project #1
 * Lab: TR 12:30
 * TA: Patrick Conway
 * I did not collaborate with anyone on this Project 
 */
import java.util.*;
import static java.lang.Math.pow;
import static java.lang.Math.sin;
import static java.lang.Math.abs;
import static java.lang.Math.PI;

public class ProjectileGame {

	public static void main(String[] args) {
		System.out.println("Welcome to the Projectile Game!");
		int points = 0;
		String response1 = "";
		String response2 = "";
		
		while(response2.compareTo("Yes") != 0){
		Random rand = new Random();
		double r = rand.nextInt(100-1+1)+1; //rand.nextDouble(max-min+1)+min representing the range of distance in meters
		//double r = 18;
		
		System.out.println("Your target is "+r+"m away.");
		System.out.println("Try to guess what velocity in m/s and angle in degrees your projectile needs to hit the target.");

		while(response1.compareTo("No") != 0){
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter a value for velocity (without the unit): ");
		double v =  scan.nextDouble(); //assigns input to variable, v
		
		System.out.print("Please enter an angle (without the unit): ");
		double a = scan.nextDouble(); // assigns input to variable, v
		points =  points-1;
				
		double a1 = (a*PI)/180;  // converts angle from degrees to radians 
		double d = (pow(v,2.0)*sin(2*a1))/9.8;
		System.out.println("That gets you a distance of "+d+"m");
		
			if(abs(d-r) <= 3){
				System.out.println("Direct hit! :)");
				points = points+5;
				System.out.println("You have "+points+" points.");
				break;
						}
			else if(abs(d-r) <= 5){
				System.out.println("Near miss");
				points = points+1;
			}
			else if(d-r >= 5){
				System.out.println("You went long :(");
			}
			else if(d-r <= -5){
				System.out.println("You fell short :(");
			}
			System.out.println("You have "+points+" points.");
			System.out.print("Do you wish to guess again? (Yes or No): ");
			response1 = scan.next();
		}
		Scanner scan = new Scanner(System.in);
		System.out.print("Do you wish to quit game? (Yes or No): ");
		response2 = scan.next();
		}
		}	
}
