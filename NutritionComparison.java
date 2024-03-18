/**
 * NutritionComparison.java
 * 
 * The purpose of this project is to compare the given nutritions from different companies.
 * The methods used will calculate, the averages and find the highest and lease values, Then finding companies with the highest and least values.
 * _________________________________________________________________________________________________________________________________________________
 * Anita Umana
 * 03/15/2024
 * Cmsc 255, Section 901
 * */
import java.util.Scanner;

public class NutritionComparison {
    /**
     * This double class will find the averages of the values in the array
     * @param values ,values of the array given.
     * @return the average
     * */
     public static double calcAvg(double[] values) {
      double sum =0;
      for (double value: values) {
        sum += value;
      }
      return sum / values.length;
     }

     /**
      * Next will be a double to find the highest values from given.
      * @param values
      * @return will be highest value
      * */
     public static double findHighValue(double[] values) {
      double highest =values[0];
      for (double value : values) {
        if (value > highest) {
          highest = value;}}
          return highest;
     }

     /**
      * 3rd line will be used to find the smallest value in array
      * @param values
      * @return will be smallest or least value
      * */
     public static double findLeastValue(double[] values) {
      double lowest = values[0];
      for (double value : values){
        if (value < lowest) {
          lowest = value;}}
        return lowest;
     }
     /**
      * This next part will be used to find the top 2 numbers of the arrays given
      * @param values
      * @param names this will be of the company names
      * @return the 2 highest values with company name.
      * */

      public static String[] findHighestTwo(String[] names, double[] values) {
        String[] topTwo = new String[2];
        double top1 = Double.MIN_VALUE;
        double top2 = Double.MIN_VALUE;

        String topName1 = "";
        String topName2 = "";

        for (int i = 0; i < values.length; i++) {
          if (values[i] > top1) {
            top2 = top1;
            topName2 = topName1;
            top1 = values[i];
            topName1 = names[i]; 
          }
          else if (values[i] > top2){
            top2 = values[i];
            topName2 = names[i]; }}

        topTwo[0] = topName1;
        topTwo[1] = topName2;

        return topTwo;
      }
      /**
       * Next String will be for the least 2 values
       * @param values 
       * @param names
       * @return the lowest 2 values and companies
       * */
  public static String[] findLeastTwo(String[] names, double[] values) {
        String[] lowestTwo = new String[2];
        double lowest1 = Double.MAX_VALUE;
        double lowest2 = Double.MAX_VALUE;

        String lowName1 = "";
        String lowName2 = "";

        for (int i = 0; i < values.length; i++) {
          if (values[i] < lowest1) {
            lowest2 = lowest1; 
            lowName2 = lowName1;
            lowest1 = values[i];
            lowName1 = names[i];}
            else if (values[i] < lowest2) {
              lowest2 = values[i];
              lowName2 = names[i];
            }}

        lowestTwo[0] = lowName1;
        lowestTwo[1] = lowName2;

        return lowestTwo;
      }
      /**
       * @param names Company names
       * @param company
       *@return true or false to see if the company is included
       * 
       * */
       public static boolean findCompany(String[] names, String company) {
        for (String name : names) {
          if (name.equals(company)) {
            return true;}}
          return false;
        
     }

     //Final line would be an array that shows the company names and data from it, along with creating the print statements
     public static void main(String[] args) {
      String[] diffCompanies = {"ReadyWise", "My Patriot Supply", "4Patriots", "TWC", "ERCC", "Survival Frog", "Be Prepared", "Smithfield" };
      double[] protein = {30.2,28.7,30.1,30.8,41.4,36.2,38.1,19.7};
      double[] carbs = { 151.3,167.8,187.6,178.5,206.9,185.2,183.1,161.3};
      double[] fat = {54.7,30.3,58.1,44.4,44.5,34.9,49.2,26.4};

      double proteinAvg = calcAvg(protein);
      double highestProtein = findHighValue(protein);
      double carbsAvg = calcAvg(carbs);
      double leastFat = findLeastValue(fat);

      String[] topTwoProteinCompanies = findHighestTwo(diffCompanies, protein);
      String[] lowestTwoCarbsCompanies = findLeastTwo(diffCompanies, carbs);

      System.out.printf("The average grams of protein per serving is: %.2fg\n", proteinAvg);
          System.out.printf("The average grams of carbohydrate per serving is: %.2fg\n", carbsAvg);
          System.out.printf("The highest grams of protein per serving is: %.2fg\n", highestProtein);
          System.out.printf("The least grams of fat per serving is: %.2fg\n", leastFat);
          System.out.println("The companies with the two highest grams of protein per serving are:");
          for (String company : topTwoProteinCompanies) {
            System.out.println(company);
          }
          System.out.println("The companies with the two lowest grams of carbohydrates per serving are:");
          for (String company : lowestTwoCarbsCompanies) {
              System.out.println(company);
          }

          System.out.println("Enter a company:");
          String inputName = new Scanner(System.in).nextLine().trim();
          boolean validName = findCompany(diffCompanies, inputName);
          if (validName) {
            System.out.println(inputName + " is a company in the array.");
          } else { System.out.println(inputName + " is not a company in the array.");}
     }
}