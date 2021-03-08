package lesson1.hw1;

import lesson1.hw1.fruits.Fruits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoxWithFruits <T extends Fruits> {
    private List<T> container;
    public BoxWithFruits(){this.container = ArrayList<>();
    }
    public BoxWithFruits(T... fruits){this.container = new ArrayList(Arrays.asList(fruits));}
    public float getWeight(){

        float w = 0.0f;
        for (T fruit : container){
            w += fruit.getWeight();
        }
        return w;
    }
    public boolean sameAvg(BoxWithFruits<?> another){
        return Main.abs(this.getWeight() - another.getWeight()) < 0.0001;
    }
    public void transfer(BoxWithFruits<? super T> another){
        if (another == this){
            return;
        }
        another.container.addAll(this.container);
        this.container.clear();
    }
    public void add(T fruit){container.add(fruit);}

}
