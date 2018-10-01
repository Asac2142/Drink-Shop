package formosexercise;

public class Ingredient {
    
    private double quantiy;
    private String name;
    private String unit;
        
    public Ingredient(double quantiy, String name, String unit){
        this.quantiy = quantiy;
        this.name = name;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }
    
    public void substractQuantity(double amount){
        quantiy -= amount;
        
        if (quantiy < 0){
            quantiy = 0;
        }
    }
    
    public void addQuantity(double amount){
        quantiy += amount;
    }
    
    public double getQuantity(){
        return quantiy;
    }
    
    public void printCurrentInventory(){
        System.out.println( name + " " + quantiy + " [" + unit + "] ");
    }
}
