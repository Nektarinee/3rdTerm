package ru.GeekBrains;

import java.util.Arrays;

public class Main {

    public static void main(String[] args)
    {
        int[] arr1 = {1,2,3};
        String [] arr2 ={"A","B","C"};
        swapArraysElements(arr1,arr1[0],arr1[1]);
        Box<Apple> appleBox = new Box<Apple>();
        Apple apple1 = new Apple(1.0f);
        appleBox.addFruit(apple1,5);
    }




    //Метод позволяющий поменять два элемента в массиве метами(но к сожалению не поличилось сделаеть его более обобщённым)
    public static void swapArraysElements(Object[] arr,int index1,int index2)
    {
        Object saveElement = arr[index1];
        arr[index1]= arr[index2];
        arr[index2] = saveElement;
        System.out.println(Arrays.toString(arr));
    }

    //Метод, позволяющий преобразовать массив в список
    public static void arrToArrayList(Integer[] myArr)
    {
        Arrays.asList(myArr);

    }
}
