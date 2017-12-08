package lib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.imageio.IIOException;

public class ConsoleIO
{

	// PRO TIP: Make sure to create a new BufferedReader in each method
	// where a BufferedReader is required. Do NOT close the reader as that will
	// cause
	// other issues. Also, catch ALL IOExceptions and NumberFormatExceptions.
	// Do not simply mark the method with a "throws" statement

	/**
	 * Generates a console-based menu using the Strings in options as the menu
	 * items. Reserves the number 0 for the "quit" option when withQuit is true.
	 * 
	 * @param options
	 *            - Strings representing the menu options
	 * @param withQuit
	 *            - adds option 0 for "quit" when true
	 * @return the int of the selection made by the user
	 */
	public static int promptForMenuSelection(String[] options, boolean withQuit)
	{
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please select the following by inputing the number associated with the option - \n");
		String prompt = "";
		int userSelection = 0;
		boolean isNotNum = true;

		for (int index = 0; index < options.length; index++)
		{
			int optionNumber = index + 1;
			prompt += optionNumber + ") " + options[index] + "\n";
		}

		if (withQuit)
		{
			prompt += "0) " + "Quit" + "\n";
		}
		
		do
		{
			try
			{
				boolean optionDoesntExist = true;
				do
				{
					System.out.println(prompt);
					System.out.println("Enter your option number: ");
					String userInput = inputReader.readLine();
					userSelection = Integer.parseInt(userInput);
					boolean isInBoundries = userSelection >= 0 && userSelection < (options.length + 1);
					if(isInBoundries)
					{
						optionDoesntExist = false;
					}
					else 
					{
						System.out.println("That option does not exist, try again.");
						optionDoesntExist = true;
					}
				} while(optionDoesntExist);
				isNotNum = false;

			} catch (IOException | NumberFormatException e)
			{
				System.out.println("That was not a valid input. Enter a valid input.");
				isNotNum = true;
			}
		} while (isNotNum);
		return userSelection;
	}

	/**
	 * Generates a prompt that expects the user to enter one of two responses that
	 * will equate to a boolean value. The trueString represents the case
	 * insensitive response that will equate to true. The falseString acts
	 * similarly, but for a false boolean value. Example: Assume this method is
	 * called with a trueString argument of "yes" and a falseString argument of
	 * "no". If the enters "YES", the method returns true. If the user enters "no",
	 * the method returns false. All other inputs are considered invalid, the user
	 * will be informed, and the prompt will repeat.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param trueString
	 *            - the case insensitive value that will evaluate to true
	 * @param falseString
	 *            - the case insensitive value that will evaluate to false
	 * @return the boolean value
	 */
	public static boolean promptForBool(String prompt, String trueString, String falseString)
	{
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		boolean isNotValid = true;
		boolean isRightChoice = false;
		while(isNotValid)
		try
		{
			
			System.out.println(prompt);
			String userInput = inputReader.readLine();
			if(userInput.equalsIgnoreCase(trueString))
			{
				isRightChoice = true;
				isNotValid = false;
			}
			else if(userInput.equalsIgnoreCase(falseString))
			{
				isRightChoice = false;
				isNotValid = false;
			}
			else
			{
				System.out.println("That was not a valid input, try again.\n");
				isNotValid = true;
			}
			
		} catch (IOException e)
		{
			System.out.println("That was not a valid input, try again.\n");
			isNotValid = true;
		}
		
		return isRightChoice;
	}

	/**
	 * Generates a prompt that expects a numeric input representing a byte value.
	 * This method loops until valid input is given.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param min
	 *            - the inclusive minimum boundary
	 * @param max
	 *            - the inclusive maximum boundary
	 * @return the byte value
	 */
	public static byte promptForByte(String prompt, byte min, byte max)
	{
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		boolean isNotValid = true;
		byte userByte = 0;
		while(isNotValid)
		{
			try
			{
				boolean isNotInRange = true;
				while(isNotInRange)
				{
					System.out.println(prompt);
					String userInput = inputReader.readLine();
					userByte = Byte.parseByte(userInput);
					boolean isInRange = userByte >= min && userByte <= max;
					if(isInRange)
					{
						System.out.println("Your byte is within range.");
						isNotInRange = false;
					}
					else
					{
						System.out.println("Your byte is out of range. Try again");
						isNotInRange = true;
					}	
				}
				isNotValid = false;
			} catch(IOException | NumberFormatException e)
			{
				System.out.println("Sorry that was not a valid input, try again.");
				isNotValid = true;
			}
		}
		return userByte;
	}

	/**
	 * Generates a prompt that expects a numeric input representing a short value.
	 * This method loops until valid input is given.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param min
	 *            - the inclusive minimum boundary
	 * @param max
	 *            - the inclusive maximum boundary
	 * @return the short value
	 */
	public static short promptForShort(String prompt, short min, short max)
	{
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		boolean isNotValid = true;
		short userShort = 0;
		while(isNotValid)
		{
			try
			{
				boolean isNotInRange = true;
				while(isNotInRange)
				{
					System.out.println(prompt);
					String userInput = inputReader.readLine();
					userShort = Short.parseShort(userInput);
					boolean shortRange = userShort >= min && userShort <= max;
					if(shortRange)
					{
						System.out.println("Your short is within range.");
						isNotInRange = false;
					}
					else
					{
						System.out.println("Your short is out of bound. Try again.");
						isNotInRange = true;
					}
				}
				isNotValid = false;	
			} catch(IOException | NumberFormatException e)
			{
				System.out.println("Invalid input. Try Again.");
				isNotValid = true;
			}
		}
		
		return userShort;
	}

	/**
	 * Generates a prompt that expects a numeric input representing an int value.
	 * This method loops until valid input is given.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param min
	 *            - the inclusive minimum boundary
	 * @param max
	 *            - the inclusive maximum boundary
	 * @return the int value
	 */
	public static int promptForInt(String prompt, int min, int max)
	{
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		int userInt = 0;
		boolean isNotInt = true;
		while(isNotInt)
		{
			try
			{
				boolean isNotInRange = true;
				while(isNotInRange)
				{
					System.out.println(prompt);
					String userInput = inputReader.readLine();
					userInt = Integer.parseInt(userInput);
					boolean intIsInBoundry = userInt >= min && userInt <= max;
					if(intIsInBoundry)
					{
						System.out.println("Your Integer is in the boundry.");
						isNotInRange = false;
					}
					else
					{
						System.out.println("That Integer is out of boundries, try again.");
						isNotInRange = true;
					}
				}
				isNotInt = false;
			} catch (IOException | NumberFormatException e)
			{
				System.out.println("That was not a valid Integer, try again.");
				isNotInt = true;
			}
		}
		
		
		return userInt;
	}

	/**
	 * Generates a prompt that expects a numeric input representing a long value.
	 * This method loops until valid input is given.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param min
	 *            - the inclusive minimum boundary
	 * @param max
	 *            - the inclusive maximum boundary
	 * @return the long value
	 */
	public static long promptForLong(String prompt, long min, long max)
	{
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		long userLong = 0;
		boolean isNotValid = true;
		while(isNotValid)
		{
			
			try
			{
				boolean isNotInRange = true;
				while(isNotInRange)
				{
					System.out.println(prompt);
					String userInput = inputReader.readLine();
					userLong = Long.parseLong(userInput);
					boolean isLongBoundry = userLong >= min && userLong <= max;
					if(isLongBoundry)
					{
						System.out.println("The long input is in boundry.");
						isNotInRange = false;
					}
					else
					{
						System.out.println("That long input is out of boundries, Try again.");
						isNotInRange = true;
					}
					
				}
				
				
				isNotValid = false;
			} catch (IOException | NumberFormatException e)
			{
				System.out.println("That was not a valid Input, Try again.");
				isNotValid = true;
			}
			
		}
		
		return userLong;
	}

	/**
	 * Generates a prompt that expects a numeric input representing a float value.
	 * This method loops until valid input is given.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param min
	 *            - the inclusive minimum boundary
	 * @param max
	 *            - the inclusive maximum boundary
	 * @return the float value
	 */
	public static float promptForFloat(String prompt, float min, float max)
	{
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		float userFloat = 0;
		boolean isNotValid = true;
		while(isNotValid)
		{
			try
			{
				boolean isNotInRange = true;
				while(isNotInRange)
				{
					System.out.println(prompt);
					String userInput = inputReader.readLine();
					userFloat = Float.parseFloat(userInput);
					boolean isInFloatRange = userFloat >= min && userFloat <= max;
					if(isInFloatRange)
					{
						isNotInRange = false;
					}
					else
					{
						System.out.println("Your float is out of boundries, try again.");
						isNotInRange = true;
					}
				}
				
				isNotValid = false;
			} catch (IOException | NumberFormatException e)
			{
				System.out.println("That was an invalid input. Try again.");
				isNotValid = true;
			}
		}
		
		return userFloat;
	}

	/**
	 * Generates a prompt that expects a numeric input representing a double value.
	 * This method loops until valid input is given.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param min
	 *            - the inclusive minimum boundary
	 * @param max
	 *            - the inclusive maximum boundary
	 * @return the double value
	 */
	public static double promptForDouble(String prompt, double min, double max)
	{
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		double userDouble = 0.0;
		boolean isNotValid = true;
		while(isNotValid)
		{
			try
			{
				boolean isNotInRange = true;
				while(isNotInRange)
				{
					System.out.println(prompt);
					String userInput = inputReader.readLine();
					userDouble = Double.parseDouble(userInput);
					boolean isInDoubleRange = userDouble >= min && userDouble <= max;
					if(isInDoubleRange)
					{
						isNotInRange = false;
					}
					else
					{
						System.out.println("Your double is out of bounds, try again.");
						isNotInRange = true;
					}
				}
				isNotValid = false;
			} catch (IOException | NumberFormatException e)
			{

				System.out.println("That was not a valid input, try again.");
				isNotValid = true;
			}
			
		}
		
		return userDouble;
	}

	/**
	 * Generates a prompt that allows the user to enter any response and returns the
	 * String. When allowEmpty is true, empty responses are valid. When false,
	 * responses must contain at least one character (including whitespace).
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user.
	 * @param allowEmpty
	 *            - when true, makes empty responses valid
	 * @return the input from the user as a String
	 */
	public static String promptForInput(String prompt, boolean allowEmpty)
	{
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		String userInput = "";
		boolean isNotValid = true;
		do
		{
			try
			{
				boolean isNotGoodInput = true;
				do
				{
					
					System.out.println(prompt);
					userInput = inputReader.readLine();
					
					if(allowEmpty == true && userInput.equals(""));
					{
						
						isNotGoodInput = false;
					}
					if(allowEmpty == false && userInput.equals(""))
					{
						System.out.println("Cannot accept empty inputs as the method is set to not allow it.\n "
								+ "Try at least enter one character in the input.");
						isNotGoodInput = true;
					}
				} while(isNotGoodInput);
					
				isNotValid = false;
			} catch (IOException e)
			{
				System.out.println("Somethin is wrong with the input");
				isNotValid = true;
			}
		} while(isNotValid);
		
		
		return userInput;
	}

	/**
	 * Generates a prompt that expects a single character input representing a char
	 * value. This method loops until valid input is given.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param min
	 *            - the inclusive minimum boundary
	 * @param max
	 *            - the inclusive maximum boundary
	 * @return the char value
	 */
	public static char promptForChar(String prompt, char min, char max)
	{
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		String userInput;
		boolean isNotValid = true;
		char userChar = 0;
		while (isNotValid)
		{
			try
			{
				boolean isNotInBoundries = true;
				while(isNotInBoundries)
				{
					System.out.println(prompt);
					userInput = inputReader.readLine();
					userChar = userInput.charAt(0);
					if(userInput.length() == 1)
					{
						boolean charRange = userChar >= min && userChar <= max;
						if(charRange)
						{
							System.out.println("Your char is in boundry");
							isNotInBoundries = false;
						} 
						else
						{
							System.out.println("Sorry, your char is out of boundries. Try again.");
							isNotInBoundries = true;
						} 
					}
					else
					{
						System.out.println("Cannot accept more than 1 character size input, try again.");
						isNotInBoundries = true;
					}
				}
				
				
				isNotValid = false;
			} catch (IOException | StringIndexOutOfBoundsException e)
			{
				System.out.println("That was not a valid input. Try entering a valid input.");
				isNotValid = true;
			}
		}
		
	return userChar;
}

}
