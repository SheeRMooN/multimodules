package com.example;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,23,34,45,55,64,78,81,88,91};
        int[] array2 = new int[]{32,11,44,112,421,231,546,114};
//        System.out.println(biSearch(array, 23));
        System.out.println(maxVauleSecond(array2));
//        System.out.println(minVaule(array2));
    }
    public static int linerSearch(int[] i, int x){
        for (int j = 0; j < i.length; j++) {
            if (i[j] == x) {
                return j;
            }
        }
        return -1;
    }
    public static int biSearch(int[] array, int x){
        System.out.println("iteration !");
        int firstIndex = 0;
        int lastIndex = array.length-1;

        while (firstIndex<lastIndex){
            int middleIndex = (firstIndex + lastIndex)/2;
            if (array[middleIndex] == x){
                return middleIndex;
            }else if(array[middleIndex] < x){
                firstIndex = middleIndex+1;
            }else if (array[middleIndex] >x){
                lastIndex = middleIndex+1;
            }
        }
        return -1;
    }
    public static int maxVaule(int[] array){
        int max= Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i]>max){
                max=array[i];
            }
        }
        return max;
    }
    public static int minVaule(int[] array){
        int min= Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i]<min){
                min=array[i];
            }
        }
        return min;
    }
    public static int maxVauleSecond(int[] array){
        int max= Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i]>max){
                max2=max;
                max=array[i];
            }
        }
        return max2;
    }
}
