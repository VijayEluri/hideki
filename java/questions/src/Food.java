//Question: Order an array of Food objects by calories ascending, tie breaker is the name (alphabetical order).

import java.util.Arrays;

// Order an array of food object by calories ascending, tie breaker is the name (alphabetically)
public class Food implements Comparable<Food>{
    @SuppressWarnings("unused")
	private final int _foodID;
    private final String _name;
    private final Integer _calories;

    public Food(int foodID, String name, Integer calories) {
        _foodID = foodID;
        if (name == null)
            throw new IllegalArgumentException("name cannot be null");
        _name = name;
        _calories = calories;
    }
    
    // for Comparable
    public int compareTo(Food other){
        if(other == null){
            return -1;
        }
        if(other._calories == null && this._calories == null){
            return this._name.compareTo(other._name);
        }
        // other calories is null
        else if(other._calories == null){
            return -1;
        }
        // this calories is null
        else if(this._calories == null){
            return 1;
        }
        
        // from here both are not null
        if(this._calories.intValue() > other._calories.intValue()){
            return 1;
        }else if (this._calories.intValue() < other._calories.intValue()){
            return -1;
        }else{
            return this._name.compareTo(other._name);
        }
    }

    public String getName() {
        return _name;
    }

    public Integer getCalories() {
        return _calories;
    }

    public static void main(String[] args) {
        Food[] f = new Food[8];
        f[0] = new Food(1, "orange", 100);
        f[1] = new Food(2, "apple", 500);
        f[2] = new Food(3, "banana", 100);
        f[3] = new Food(4, "chocolate", null);
        Food food = new Food(5, "milkshake", 1000);
        f[4] = food;
        f[5] = new Food(5, "milkshake", 1000);
        f[6] = food;
        f[7] = null;

        // Question1: please write code that sorts f here...
        Arrays.sort(f);

        //Question 2: what does this print to the console ?
		/*
        banana
        orange
        apple
        milkshake
        milkshake
        milkshake
        chocolate
        null
		*/

        for (int i = 0; i < f.length; i++) {
            System.out.println(f[i] == null ? null : f[i].getName() + "\t" + f[i].getCalories());
        }
    }
}

