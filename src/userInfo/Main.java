/**
 * 
 */
package userInfo;

import java.util.Scanner;

/**
 * @author linelij
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		password();
		String rndm;
		rndm = input.nextLine();
		if(rndm.equals("")){
			count();
		}
		phone();
		idNumber();
		
	}
	
	public static final Scanner input = new Scanner(System.in);
	
	public static void password()
	{
		
		String password;
		String cont = "y";	
		System.out.println("Setting up a good password is easy. To view requirements please enter 'Help' below.");
		System.out.print("Enter password or Help: ");
		password = input.next();
		boolean hasUpper = !password.equals(password.toLowerCase());
		boolean hasLower = !password.equals(password.toUpperCase());
		boolean hasNumeric = password.matches(".*\\d.*");
		
		
		while(cont.equalsIgnoreCase("y"))
		{
			while(password.isEmpty())
			{
				System.out.print("Enter password: ");
				password = input.next();
			}
			
			
			if(password.equalsIgnoreCase("help"))
			{
				System.out.println("\nPassword must meet these requirements." + 
						"\nMust contain between 6 and 10 characters." + "\nMust contain 1 numeric value." + 
						"\nMust contain 1 letter value." + "\nMust contain 1 upper case letter.\n");
				password = "";
			}
			else if(!hasUpper)
			{
				System.out.println("\nInvalid password -- Must Contain an uppercase letter.\n");
				password = "";
			}
			else if(!hasLower)
			{
				System.out.println("\nInvalid password -- Must Contain a lowercase letter.\n");
				password = "";
			}
			else if (!hasNumeric)
			{
				System.out.println("\nInvalid password -- Must Contain a numeric value.\n");
				password = "";
			}
			else if(password.length() < 6)
			{
				System.out.println("\nInvalid password -- Must Contain at least 6 characters.\n");
				password = "";
			}
			else if(password.length() > 10)
			{
				System.out.println("\nInvalid password -- Cannot Exceed 10 characters.\n");
				password = "";
			}
			else
			{
				System.out.println("\nYour password is " + password);
				System.out.println("\nWould you like to change your password? (Y/N): ");
				cont = input.next();
				password = "";
			}
			
			while(cont.equalsIgnoreCase("y") && cont.equalsIgnoreCase("n"))
			{
				System.out.print("Invalid Answer. Please Enter Y or N: ");
				cont = input.next();
			}	
		}
				
	}
	
	public static void count()
	{
		String in;
		System.out.println("Please enter any number of words below: ");
		in = input.nextLine();
		int wordCnt = 0;
		int lnEnd = in.length() - 1;
		boolean word = false;
		
		for(int i = 0; i < in.length(); i++)
		{
			if(Character.isLetter(in.charAt(i)) && i != lnEnd)
			{
				word = true;
			}
			else if(!Character.isLetter(in.charAt(i)) && word)
			{
				wordCnt++;
				word = false;
			}
			else if(Character.isLetter(in.charAt(i)) && i == lnEnd)
			{
				wordCnt++;
			}
		}
		
		System.out.println(wordCnt);
		
	}
	
	public static void phone()
	{
		String phnNum;
		System.out.println("Please Enter a number to be converted into a phone number: ");
		phnNum = input.nextLine();		
		System.out.println("Conversion to phone number: (" + phnNum.subSequence(0,3) + ")" + phnNum.subSequence(3, 6) + "-" + phnNum.subSequence(6, 10));
	}

	public static void idNumber()
	{
		String fname, lname;
		int address;
		System.out.println("Please Enter your first name: ");
		fname = input.nextLine();
		System.out.println("Please Enter your last name: ");
		lname = input.nextLine();
		System.out.println("Please Enter your Street Address: ");
		address = input.nextInt();
		
		if(fname.isEmpty())
		{
			System.out.println("Please Enter your first name: ");
			fname = input.nextLine();
		}
		else if(lname.isEmpty())
		{
			System.out.println("Please Enter your last name: ");
			lname = input.nextLine();
		}
		else
		{
			System.out.println("ID Number: ");
			String initials = fname.substring(0,1) + lname.substring(0,1);
			System.out.println(initials + address);
		}
	}
	
}
