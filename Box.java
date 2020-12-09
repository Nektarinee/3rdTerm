package ru.GeekBrains;


import java.util.ArrayList;
import java.util.Arrays;

public class Box<T>
{
    private static ArrayList<T> aBox;

    public Box(ArrayList<T> aBox)
    {
        this.aBox = new ArrayList<>();
    }

    public Box(T fruits)
    {
        this.aBox =new ArrayList<>(Arrays.asList(fruits));
    }

    public Box()
    {
        this.aBox = new ArrayList<>();
    }

    public void getWeight()
    {
        float boxWeight = 0.0f;
        for(T fruits: aBox)
        {
            boxWeight += Fruit.getWeight();
        }
    }



    public boolean compare(Box anotherBox)
    {
        if (Box.getWeight() != anotherBox.getWeight()) {
        return false;
        } else {
            return true;
        }
    }

    public void pourTo(Box <T>anotherBox){
        anotherBox.aBox.addAll(aBox);
        aBox.clear();
    }

    public void addFruit(T fruit, int amount)
    {
        for(int i=0;i<amount;i++)
        {
            aBox.add(fruit);
        }
    }
}


