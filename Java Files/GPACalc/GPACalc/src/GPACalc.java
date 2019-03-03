import java.util.Scanner;
import java.util.stream.*;

public class GPACalc 
{
		static double honors = 1.05;
		static double AP = 1.10;
	
		public static void main(String[] args)
		{
			Scanner APUSH = new Scanner(System.in);
			
			System.out.println("GPA Calculator: ");
			
			APUSH.nextLine();
			System.out.println("This program will calculate your GPA for you.");
			System.out.println("Would you like a weighted or unweighted GPA?");
			
			boolean calcType = true; 
			do 
			{
				String answer = APUSH.nextLine();
				switch (answer.toLowerCase())
				{
					case "unweighted":
					Unweighted();
					calcType = false;
					break;
					
					case "weighted":
					Weighted();
					calcType = false;
					break;
					
					default:
					System.out.println("Please select a valid option!");
					break;
				}
			} while (calcType == true);
		}

		static void Unweighted()
		{
			Scanner APUSH = new Scanner(System.in);
			
			System.out.println("How many classes are you factoring into your GPA?");
			int n = Integer.parseInt(APUSH.nextLine());
			
			String[] classes = new String[n];
			double[] grades = new double[n];
			
			for (int i = 0; i < n; i++)
			{
				System.out.println("What is the name of this class?");
				classes[i] = APUSH.nextLine();
				System.out.println("What is your grade in this class?");
				grades[i] = Double.parseDouble(APUSH.nextLine());
			}
			
			System.out.println();
			
			for (int i = 0; i < n; i++)
			{
				System.out.println(classes[i] + ": " + grades[i]);
			}
			
			double sum =  DoubleStream.of(grades).sum();
			double average = sum / n;
			System.out.println("Your average is " + average);
		}
		
		static void Weighted()
		{
			Scanner APUSH = new Scanner(System.in);
			
			System.out.println("How many classes are you factoring into your gpa?");
			
			int n = Integer.parseInt(APUSH.nextLine());
			
			String[] classes = new String[n];
			double[] grades = new double[n];
			
			setCustomScales();
			
			for (int i = 0; i < n; i++)
			{
				System.out.println("What is the name of this class?");
				classes[i] = APUSH.nextLine();
				
				System.out.println("Is this class normal, honors, or AP?");
				boolean classType = true;
				do 
				{
					String answer = APUSH.nextLine();
					switch (answer.toLowerCase())
					{
						case "normal":
						classType = false;
						System.out.println("What is your grade in this class?");
						grades[i] = Double.parseDouble(APUSH.nextLine());
						break;
						
						case "honors":
						classType = false;
						System.out.println("What is your grade in this class?");
						grades[i] = (Double.parseDouble(APUSH.nextLine())) * honors;
						break;
						
						case "ap":
						classType = false;
						System.out.println("What is your grade in this class?");
						grades[i] = (Double.parseDouble(APUSH.nextLine())) * AP;
						break;
						
						default:
						System.out.println("Please select a valid answer.");
						break;
						
					}
				} while (classType == true);
			}
			
			for (int i = 0; i < n; i++)
			{
				System.out.println(classes[i] + ": " + grades[i]);
			}
			
			double sum =  DoubleStream.of(grades).sum();
			double average = sum / n;
			System.out.println("Your average is " + average);
		}
		
		static void setCustomScales()
		{
			Scanner APUSH = new Scanner(System.in);
			
			System.out.println("Do you want to use default or custom values for scaling your classes by type?");
			
			boolean custom = false;
			
			boolean askcustomLoop = true;
			do
			{
				String askcustom = APUSH.nextLine();
				switch (askcustom)
				{
					case "default":
					askcustomLoop = false;
					custom = false;
					break;
				
					case "custom":
					askcustomLoop = false;
					custom = true;
					break;
						
					default:
					System.out.println("Sorry, can you please answer with the words default or custom?");
					break;
				}
			} while (askcustomLoop == true);
			
			if (custom == true) 
			{
				System.out.println("What scale should be used for honors classes?");
				honors = Double.parseDouble(APUSH.nextLine());
				System.out.println("What scale should be used for AP classes?");
				AP = Double.parseDouble(APUSH.nextLine());
			}
		}		
}
