using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace School_Application
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("GPA Calculator:");
            Console.ReadKey();
            Console.WriteLine("This program will calculate your GPA for you.");
            Console.ReadKey();
            Console.WriteLine("Would you like a weighted or unweighted GPA?");

            bool loop1 = true;
            do
            {
                string answer = Console.ReadLine();
                switch (answer.ToLower())
                {
                    case "unweighted":
                        Unweighted();
                        loop1 = false;
                        break;

                    case "weighted":
                        Weighted();
                        loop1 = false;
                        break;

                    default:
                        Console.WriteLine("Please select a valid option.");
                        break;
                }
            } while (loop1 == true);
           
        }

        static void Unweighted()
        {
            Console.WriteLine("How many classes are you factoring into your GPA?");
            int n = int.Parse(Console.ReadLine());

            string[] classes = new string[n];
            int[] grades = new int[n];

            for (int i = 0; i < n; i++)
            {
                Console.WriteLine("What is the name of this class?");
                classes[i] = Console.ReadLine();
                Console.WriteLine("What is your grade in this class?");
                grades[i] = int.Parse(Console.ReadLine());
            }

            float sum = grades.Sum();
            float average = sum / n;
            Console.WriteLine("Your average is " + average + "!");
            Console.ReadKey();

        }

        static void Weighted()
        {
            Console.WriteLine("How many classes are you factoring into your GPA?");
            int n = int.Parse(Console.ReadLine());

            string[] classes = new string[n];
            double[] grades = new double[n];

            for (int i = 0; i < n; i++)
            {
                Console.WriteLine("What is the name of this class?");
                classes[i] = Console.ReadLine();

                Console.WriteLine("Is this class normal, honors, or AP?");
                bool loop2 = true;
                do
                {
                    string classType = Console.ReadLine();
                    switch (classType.ToLower())
                    {
                        case "normal":
                            loop2 = false;
                            Console.WriteLine("What is your grade in this class?");
                            grades[i] = int.Parse(Console.ReadLine());
                            break;

                        case "honors":
                            loop2 = false;
                            Console.WriteLine("What is your grade in this class?");
                            grades[i] = (double.Parse(Console.ReadLine())) * 1.05;
                            break;

                        case "ap":
                            loop2 = false;
                            Console.WriteLine("What is your grade in this class?");
                            grades[i] = (double.Parse(Console.ReadLine())) * 1.10;
                            break;

                        default:
                            Console.WriteLine("Please select a valid answer.");
                            break;
                    }
                } while (loop2 == true);
                
            }

            double sum = grades.Sum();
            double average = sum / n;
            Console.WriteLine("Your average is " + average + "!");
            Console.ReadKey();
        }
    }
}
