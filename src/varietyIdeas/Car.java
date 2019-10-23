package varietyIdeas;

import java.util.Scanner;

public class Car {
		private int topSpeed; // this the top speed of a car in MPH
		public String color;
		private int milesPerGallon; // how many miles car travels with one gallon
		private int gasTank; // how much gas can be held in gallons
		private int seatCount;
		private Seat [] seats;
		
		private final static int DEFAULT_SPEED = 130;
		private final static int DEFAULT_MILES_PER_GALLON = 40;
		private final static int DEFAULT_GASTANK = 15;
		private final static int DEFAULT_SEATS = 10;
		
		public Car(int topSpeed, int milesPerGallon, int gasTank, int seatCount) {
			if(topSpeed > 350) {
				System.out.println("Your selected speed is too high.");
				this.topSpeed = DEFAULT_SPEED;
			}
			else
				this.topSpeed = topSpeed;
			System.out.println("What color would you want your car?");
			System.out.println("The options are");
			System.out.println("1. Black");
			System.out.println("2. White");
			System.out.println("3. Red");
			System.out.println("4. Yellow");
			System.out.println("5. Green");
			System.out.println("6. Purple");
			System.out.println("7. Orange");
			System.out.println("8. Gray");
			System.out.println("9. Periwinkle");
			System.out.println("Enter number to corresponding number.");
			Scanner s = new Scanner(System.in);
			int reply = s.nextInt();
			
			while(reply >= 10 && reply < 0) {
				System.out.println("Invalid answer. Pick again");
				reply = s.nextInt();
			}
			if(reply == 1) 
				this.color = "Black";
			else if (reply == 2)
				this.color = "White";
			else if (reply == 3) 
				this.color = "Red";
			else if (reply == 4)
				this.color = "Yellow";
			else if (reply == 5)
				this.color = "Green";
			else if (reply == 6)
				this.color = "Purple";
			else if (reply == 7)
				this.color = "Orange";
			else if (reply == 8) 
				this.color = "Gray";
			else if (reply == 9) 
				this.color = "Periwinkle";
			if(milesPerGallon > 60) {
				System.out.println("Your selected mile per gallon is too high. Setting to default. ");
				this.milesPerGallon = DEFAULT_MILES_PER_GALLON;
			}
			else 
				this.milesPerGallon = milesPerGallon;
		
			if(gasTank > 20) {
				System.out.println("Your selected gas capacity is too high. Setting to default.");
				this.gasTank = DEFAULT_GASTANK;
			}
			else
				this.gasTank = gasTank;
			if(seatCount > 10) {
				System.out.println("This selected seat count is too high. Setting to default.");
				this.seatCount = DEFAULT_SEATS;
			}
			else
				this.seatCount = seatCount;
			
			seats = new Seat[seatCount];
}

		public int getTopSpeed() {
			return topSpeed;
		}

		public String getColor() {
			return color;
		}

		public int getMilesPerGallon() {
			return milesPerGallon;
		}

		public int getGasTank() {
			return gasTank;
		}

		public int getSeatCount() {
			return seatCount;
		}

		public void printInfo() {
			getTopSpeed();
			getColor();
			getMilesPerGallon();
			getGasTank();
			getSeatCount();
			
		}
	public void main(String[] args) {
		Car ford = new Car(95, 40, 12, 5);
		ford.printInfo();
		
	}
}
