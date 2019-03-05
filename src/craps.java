// An import declaration of class named Random.
// Used to produce sudo random numbers
import java.util.Random;

public class craps {
	
	// creates a private Random(object) with name 'randomGen' and initialises a new reference variable called Random();
	// used to generate random numbers 
	// this operation is performed when the default constructor is called 
	private Random randomNumbers = new Random();
	
	// a private enumerator with a new type called 'Status', with 3 defined constants that represent the game status
	// these 3 constants are the only values that can be assigned to variable type 'Status'
	private enum Status { Continue, Won, Lost };
	
	// constants that represent common dice rolls
	// list of named constants. Final means value isn't changing and static means only one copy exists
	private final static int snake_eyes = 2;
	private final static int trey = 3;
	private final static int seven = 7;
	private final static int yo_leven = 11;
	private final static int box_cars = 12;
	
	// following code will play 1 game of CRAPS
	// play method returns nothing
	public void play() 
	{
		// local variable called myPoint of type int which is initialised to 0
		int myPoint = 0;	// a point if there is no win or lose outcome on the first roll 
		// enumerated type 'Status' used to declare variable named 'gameStatus'
		Status gameStatus;	// This can be used to assign one of the constants (Continue, Won or Lost)  
		
		// invoke rollDice() method 
		int sumOfDice = rollDice(); // used to calculate first dice roll
		
		// used to determine the game status and point from the first roll
		switch (sumOfDice)
		{
			case seven: // 7 on first roll is a win 
			case yo_leven: // 11 on first roll is a win
				gameStatus = Status.Won; // if sum of dice is 7 or 11, set 'gameStatus' to the 'Status.Won' constant
				break;
			case snake_eyes: // 2 is a loss on the first roll
			case trey: // 3 is a loss on the first roll
			case box_cars: // 12 is a loss on the first roll
				gameStatus = Status.Lost; // if sum of dice is 2, 3 or 12, set 'gameStatus to the 'Status.Lost' constant
				break;
			// used for all other values 	
			default: // no win or lose, so remember point
				gameStatus = Status.Continue; // game not finished so assign constant 'Continue' to variable 'Status'
				myPoint = sumOfDice; // remember point
				System.out.printf("Point is %d/n", myPoint); // display the value of variable 'myPoint'
				break; // not needed, but good practice for symmetry 
		} // end of switch case statement
		
		
		// while the game is still ongoing
		// if 'gameStatus' is equal to the 'Status.Continue' constant 
		while (gameStatus == Status.Continue) // game has not won or lost
		{
			sumOfDice = rollDice(); // dice is rolled again
			
			// new value assigned to 'sumOfDice' is used to determine the game status
			if (sumOfDice == myPoint)
				gameStatus = Status.Won; // game won if initial point value is gained
			else 
				if (sumOfDice == seven) 
					gameStatus = Status.Lost; // game lost if 7 is rolled before initial point value
		} // end while statement
		
		
		// used to display a won or lost message
		if (gameStatus == Status.Won) 
			// if gameStatus is set to 'Status.Won' constant, display player has won
			System.out.println("Player Has Won");
		else 
			// else display player has lost
			System.out.println("Player Has Lost"); 
	}
	
	// rollDice() method used to generate random value for 2 dice and display the sum of the results 
	
	public int rollDice()
	{
		// calculate a random value from 1 - 6 for dice1 and dice2
		// the total number of values produced are 0  - 5, 1 is manually added to the value so that number from 1 - 6 are produced
		int dice1 = 1 + randomNumbers.nextInt(6); // first dice roll
		int dice2 = 1 + randomNumbers.nextInt(6); // second dice roll
		
		// values of both dice are assigned to variable 'sum' of type int
		int sum = dice1 + dice2;
		
		// displays the result of each dice and there sum 
		System.out.printf("The player rolled %d + %d = %d ", dice1, dice2, sum);
		
		// returns an integer representing sum of dice1 and dice2
		return sum;		
	} // end rollDice() method 
	
}
