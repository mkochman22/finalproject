//Mary Kochmanski, CIS219, Tuesdays and Thursdays at 3:30PM
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;

class Main {
  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);
    //declaring and initializing variables
    int month = 0;
    int year = 0;
    int day = 0;
    boolean error = false;
    LocalDate today = LocalDate.now();
    int thisyear = today.getYear();
    
    // Enter the year you were born, if response is invalid, reprompts user
    System.out.println("Enter the year you were born (YYYY):"); 
    try{
      year = myObj.nextInt();
    }catch(InputMismatchException e){
      error = true;
    }
    while(check(year, thisyear)==0 || error == true){
      System.out.println("You have entered an invalid response, please try again");
      if(error == true){
        myObj.next();
      }
      try{
        year = myObj.nextInt();
        error = false;
      }catch(InputMismatchException e){
        error = true;
      }
    }
    System.out.println("The year you were born is: " + year);   
    
    // Enter the month you were born, if response is invalid, reprompts user
    System.out.println("Enter the month you were born (MM):"); 
    try{
      month = myObj.nextInt(); 
    }catch(InputMismatchException e){
      error = true;
    }
    while(check(month, 12)==0){
      System.out.println("You have entered an invalid response, please try again");
      if(error == true){
        myObj.next();
      }
      try{
        month = myObj.nextInt();
        error = false;
      }catch (InputMismatchException e){
        error = true;
      }
    }
    System.out.println("The month you were born is: " + month);
    
    // Enter the day you were born, if response is invalid, reprompts user
    System.out.println("Enter the day you were born (DD):"); 
    try{
      day = myObj.nextInt();
    }catch (InputMismatchException e){
      error = true;
    }
    while(check(day, 31)==0){
      System.out.println("You have entered an invalid response, please try again");
      if(error == true){
        myObj.next();
      }
      try{
        day = myObj.nextInt();
        error = false;
      }catch (InputMismatchException e){
        error = true;
      }
      
    }
    System.out.println("The day you were born is: " + day);
    
    //calls age function
    age(year, month, day);
    //calls message function
    message(month, day);
  
  }
  
  //checks to make sure the input falls within the correct range and is valid
  public static int check(int input, int y){
    if(input<1){
      return 0;
    }else if (input>y){
      return 0;
    }else{
      return 1;
    }
  }
  
  //takes in the birthdate and calculates the age of the user. if it is the user's birthday, prints a message
  public static void age(int year, int month, int day){
    LocalDate today = LocalDate.now();
    LocalDate birthday = LocalDate.of(year, month, day);
    int age = Period.between(birthday, today).getYears();
    System.out.println("You're " + age + " years old");
    if(today.getDayOfYear() == birthday.getDayOfYear()){
      System.out.println("Happy Birthday!");
    }
  }
  
  //prints a message based on the users birth month and day
  public static void message(int month, int day){
    switch(month){
      case 1:
        System.out.println("Your birthstone is Garnet and your flower is Carnation");
        if(day<20){
          System.out.println("Your zodiac sign is Capricorn");
        }else{
          System.out.println("Your zodiac sign is Aquarius");
        }
        break;
      case 2:
        System.out.println("Your birthstone is Amethyst and your flower is Violet");
        if(day<19){
          System.out.println("Your zodiac sign is Aquarius");
        }else{
          System.out.println("Your zodiac sign is Pisces");
        }
        break;
      case 3:
        System.out.println("Your birthstone is Aquamarine and your flower is Daffodil");
        if(day<21){
          System.out.println("Your zodiac sign is Pisces");
        }else{
          System.out.println("Your zodiac sign is Aries");
        }
        break;
      case 4:
        System.out.println("Your birthstone is Diamond and your flower is Daisy");
        if(day<20){
          System.out.println("Your zodiac sign is Aries");
        }else{
          System.out.println("Your zodiac sign is Taurus");
        }
        break;
      case 5:
        System.out.println("Your birthstone is Emerald and your flower is Lily of the Valley");
        if(day<21){
          System.out.println("Your zodiac sign is Taurus");
        }else{
          System.out.println("Your zodiac sign is Gemini");
        }
        break;
      case 6:
        System.out.println("Your birthstone is Pearl and your flower is Rose");
        if(day<21){
          System.out.println("Your zodiac sign is Gemini");
        }else{
          System.out.println("Your zodiac sign is Cancer");
        }
        break;
      case 7:
        System.out.println("Your birthstone is Ruby and your flower is Larkspur");
        if(day<23){
          System.out.println("Your zodiac sign is Cancer");
        }else{
          System.out.println("Your zodiac sign is Leo");
        }
        break;
      case 8:
        System.out.println("Your birthstone is Peridot and your flower is Gladiolus");
        if(day<23){
          System.out.println("Your zodiac sign is Leo");
        }else{
          System.out.println("Your zodiac sign is Virgo");
        }
        break;
      case 9:
        System.out.println("Your birthstone is Sapphire and your flower is Aster");
        if(day<23){
          System.out.println("Your zodiac sign is Virgo");
        }else{
          System.out.println("Your zodiac sign is Libra");
        }
        break;
      case 10:
        System.out.println("Your birthstone is Tourmaline and your flower is Marigold");
        if(day<23){
          System.out.println("Your zodiac sign is Libra");
        }else{
          System.out.println("Your zodiac sign is Scorpio");
        }
        break;
      case 11:
        System.out.println("Your birthstone is Topaz and your flower is Chrysanthemum");
        if(day<22){
          System.out.println("Your zodiac sign is Scorpio");
        }else{
          System.out.println("Your zodiac sign is Sagittarius");
        }
        break;
      case 12:
        System.out.println("Your birthstone is Tanzanite and your flower is Narcissus");
        if(day<22){
          System.out.println("Your zodiac sign is Sagittarius");
        }else{
          System.out.println("Your zodiac sign is Capricorn");
        }
        break;
      default:
        System.out.println("You have entered an invalid month");
    }
  }
}
