package formosexercise;

import java.util.ArrayList;
import java.util.Scanner;

public class FormosExercise {

        static Scanner scanner = new Scanner(System.in);       
        static Drink drink = new Drink();        
        static String answer, drinkNumber;
        static ArrayList<Ingredient> list = new ArrayList<>();                
        
        //Initial inventory
        static Ingredient strawberry = new Ingredient(1000, "Strawberry", "g");
        static Ingredient banana = new Ingredient(800, "banana", "g");
        static Ingredient mango = new Ingredient(900, "mango", "g");        
        static Ingredient ice = new Ingredient(450, "ice", "ml");
        static Ingredient milk = new Ingredient(200, "condensed milk", "ml");
        static Ingredient sugar = new Ingredient(50, "sugar", "g");
          
    public static void main(String[] args) {    
        
        list.add(strawberry);        
        list.add(banana);
        list.add(mango);
        list.add(ice);
        list.add(milk);
        list.add(sugar);
        
        do
        {
            System.out.print("\nSell drinks? (Y/N) : ");
            answer = scanner.nextLine();
            
            if (answer.equals("n") || answer.equals("N"))
                break;
            
            System.out.println("(0) Print inventory");
            System.out.println("(1) Sell Strawberry drink $3.55");
            System.out.println("(2) Sell Banana drink $3.75");
            System.out.println("(3) Sell Mango drink $4.00"); 
            System.out.println("(4) Buy more ingredients (FastBuy)");            
            System.out.print("Option #: ");
            drinkNumber = scanner.nextLine();
            
            switch(drinkNumber){                
                case "0":
                    printCurrentInventory();
                    break;
                    
                case "1": 
                    if(!warningInventory("1", strawberry) && list.get(list.indexOf(ice)).getQuantity() > 90 
                            && list.get(list.indexOf(milk)).getQuantity() > 60 
                            && list.get(list.indexOf(sugar)).getQuantity() > 24){
                        
                        double grams = getGrams("1");
                        ice.substractQuantity(90);
                        milk.substractQuantity(60);
                        sugar.substractQuantity(24);
                        strawberry.substractQuantity(grams);
                        
                        (drink.getDrink())[0] = new Ingredient(90, "ice", "ml");
                        (drink.getDrink())[1] = new Ingredient(60, "condensed milk", "ml");
                        (drink.getDrink())[2] = new Ingredient(24, "sugar", "ml");
                        (drink.getDrink())[3] = new Ingredient(grams, "strawberry", "ml"); 
                        
                        System.out.println("\nEnjoy your " + strawberry.getName() + " drink. Comeback soon!");
                    }
                    else{
                        System.out.println("There are not enough ingredients!");
                        break;
                    }                    
                    break;
                    
                case "2" :
                    if(!warningInventory("2", banana) && list.get(list.indexOf(ice)).getQuantity() > 90 
                            && list.get(list.indexOf(milk)).getQuantity() > 60 
                            && list.get(list.indexOf(sugar)).getQuantity() > 24){
                        
                        double grams = getGrams("2");
                        ice.substractQuantity(90);
                        milk.substractQuantity(60);
                        sugar.substractQuantity(24);
                        banana.substractQuantity(grams);
                        
                        (drink.getDrink())[0] = new Ingredient(90, "ice", "ml");
                        (drink.getDrink())[1] = new Ingredient(60, "condensed milk", "ml");
                        (drink.getDrink())[2] = new Ingredient(24, "sugar", "ml");
                        (drink.getDrink())[3] = new Ingredient(grams, "banana", "ml"); 
                        
                        System.out.println("\nEnjoy your " + banana.getName() + " drink. Comeback soon!");
                    }
                    else{
                        System.out.println("There are not enough ingredients!");
                        break;
                    } 

                    break;
                    
                case "3":
                    
                    if(!warningInventory("3", mango) && list.get(list.indexOf(ice)).getQuantity() > 90 
                            && list.get(list.indexOf(milk)).getQuantity() > 60 
                            && list.get(list.indexOf(sugar)).getQuantity() > 24){
                        
                        double grams = getGrams("3");
                        ice.substractQuantity(90);
                        milk.substractQuantity(60);
                        sugar.substractQuantity(24);
                        mango.substractQuantity(grams);

                        (drink.getDrink())[0] = new Ingredient(90, "ice", "ml");
                        (drink.getDrink())[1] = new Ingredient(60, "condensed milk", "ml");
                        (drink.getDrink())[2] = new Ingredient(24, "sugar", "ml");
                        (drink.getDrink())[3] = new Ingredient(grams, "banana", "ml");  
                        
                        System.out.println("\nEnjoy your " + mango.getName() + " drink. Comeback soon!");
                    }
                    else{
                        System.out.println("There are not enough ingredients!");
                        break;
                    } 
                                       
                    break;
                case "4":                    
                    getMoreResources();                                                            
                    break;
                default:
                    System.out.println("Option not found");
                    break;
            }        
        }
        while(answer.equals("Y") || answer.equals("y"));
    }
    
    public static void printCurrentInventory(){       
        list.forEach((item) -> {
                System.out.println(item.getName() + " " + item.getQuantity() + " [" + item.getUnit() + "]");
            });
    }
    
    public static void getMoreResources(){       
        String amount;
        
        System.out.println("=========================");
        System.out.println("\tFastBuy");
        System.out.println("=========================");
        System.out.println("1._ Strawberry");
        System.out.println("2._ Banana");
        System.out.println("3._ Mango");
        System.out.println("4._ Ice");
        System.out.println("5._ Sugar");
        System.out.println("6._ Condensed milk");
        System.out.print("What would it be? ");
        String pick = scanner.nextLine();
        
        switch(pick){
            case "1":
                System.out.print("How much you want to buy? ");
                amount = scanner.nextLine();
                strawberry.addQuantity(Double.parseDouble(amount));
                System.out.println("Transaction completed. Check your inventory!");
                break;
                
            case "2":
                System.out.print("How much you want to buy? ");
                amount = scanner.nextLine();
                banana.addQuantity(Double.parseDouble(amount));
                System.out.println("Transaction completed. Check your inventory!");
                break;
                
            case "3":
                System.out.print("How much you want to buy? ");
                amount = scanner.nextLine();
                mango.addQuantity(Double.parseDouble(amount));
                System.out.println("Transaction completed. Check your inventory!");
                break;
                
            case "4":
                System.out.print("How much you want to buy? ");
                amount = scanner.nextLine();
                ice.addQuantity(Double.parseDouble(amount));
                System.out.println("Transaction completed. Check your inventory!");
                break;
                
            case "5":
                System.out.print("How much you want to buy?");
                amount = scanner.nextLine();
                sugar.addQuantity(Double.parseDouble(amount));
                System.out.println("Transaction completed. Check your inventory!");
                break;
                
            case "6":
                System.out.print("How much you want to buy? ");
                amount = scanner.nextLine();
                milk.addQuantity(Double.parseDouble(amount));
                System.out.println("Transaction completed. Check your inventory!");
                break;
                
            default:
                System.out.println("Option not found!");                
        }        
    }
    
    public static double getGrams(String drink){        
        double value = 0.0;
        
        switch(drink){
            case "1":
                value = (150 * 100) / 100;
                break;
                
            case "2":
                value = (150 * 120) / 100;
                break;
                
            case "3":
                value = (150 * 140) / 100;
                break;
        }        
        
        return value;
    }
    
    public static boolean warningInventory(String drink, Ingredient ingredient){
        
        boolean flag = false;
       
        if (getGrams(drink) > ingredient.getQuantity()){
            flag = true;
        }
                  
        return flag;
    }
}
