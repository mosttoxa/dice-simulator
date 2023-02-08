package com.mosttoxa;
import java.util.*;

public class Main {
    static int points;  // for storing points
    static ArrayList<Integer> bones = new ArrayList<>();  // our bones we throwed
    static ArrayList<Integer> ones = new ArrayList<>();  // bones with side 1
    static ArrayList<Integer> twos = new ArrayList<>();  // bones with side 2
    static ArrayList<Integer> threes = new ArrayList<>();  // bones with side 3
    static ArrayList<Integer> fours = new ArrayList<>();  // bones with side 4
    static ArrayList<Integer> fives = new ArrayList<>();  // bones with side 5
    static ArrayList<Integer> sixes = new ArrayList<>();  // bones with side 6
    static ArrayList<Integer> bonesBySides = new ArrayList<>(); // number of bones with specific sides
                                                                // (how many ones, twos etc.)

    public static void throwBones(int number) { // number = number of bones we want to throw
        for (int i = 0; i < number; i++) {
            int b;
            Random random = new Random();
            b = random.nextInt(6) + 1;
            bones.add(b);  // making an arraylist of bones
            if (b == 1)
                ones.add(b);  // making an arraylist of ones
            if (b == 2)
                twos.add(b);  // .. of twos
            if (b == 3)
                threes.add(b);  // .. of threes
            if (b == 4)
                fours.add(b);  // .. of fours
            if (b == 5)
                fives.add(b);  // .. of fives
            if (b == 6)
                sixes.add(b);  // .. of sixes
        }
        //storing numbers of specific bones in a separate arraylist. will use this to find combinations
        bonesBySides.add(ones.size());
        bonesBySides.add(twos.size());
        bonesBySides.add(threes.size());
        bonesBySides.add(fours.size());
        bonesBySides.add(fives.size());
        bonesBySides.add(sixes.size());
    }

    public static int calculatePoints(ArrayList<Integer> bones) {
      // first calculating points we've got on bones without combination bonus
        for (int i = 0; i < bones.size(); i++) {
            points += bones.get(i);
        }
        System.out.println("your single points: " + points);
        return points;
    }

    // need this method to find double or triple pairs
    public static int howManyPairs(ArrayList<Integer> bonesBySides) {
        int sum = 0;
        for (int i : bonesBySides) {
            if (i == 2) sum += 1;
        }
        return sum;
    }

    public static String findCombinations(ArrayList<Integer> bones) {
        // finding combinations, adding points bonus. or finding out no combinations got
        if (bones.contains(1) && bones.contains(2) && bones.contains(3) && bones.contains(4)
                && bones.contains(5) && bones.contains(6))
            return "u have full street. +10 points. your total points: " + (points + 10);
        else if (bonesBySides.contains(6))
            return "u have all same. +10 points. your total points: " + (points + 10);
        else if (bones.contains(2) && bones.contains(3) && bones.contains(4) && bones.contains(5)
                && bones.contains(6))
            return "u have big street, 23456. +8 points. your total points: " + (points + 8);
        else if (bones.contains(1) && bones.contains(2) && bones.contains(3) && bones.contains(4)
                && bones.contains(5))
            return "u have big street, 12345. +8 points. your total points: " + (points + 8);
        else if (bonesBySides.contains(4) && bonesBySides.contains(2))
            return "u have pair on box. +8 points. your total points: " + (points + 8);
        else if (bonesBySides.contains(5))
            return "u have stack of same. +7 points. your total points: " + (points + 7);
        else if (howManyPairs(bonesBySides) == 3)
            return "u have triple pair. +5 points. your total points: " + (points + 5);
        else if (bonesBySides.contains(3) && bonesBySides.contains(2))
            return "u have full house. +5 points. your total points: " + (points + 5);
        else if (bones.contains(3) && bones.contains(4) && bones.contains(5) && bones.contains(6))
            return "u have little street, 3456. +4 points. your total points: " + (points + 4);
        else if (bones.contains(2) && bones.contains(3) && bones.contains(4) && bones.contains(5))
            return "u have little street, 2345. +4 points. your total points: " + (points + 4);
        else if (bones.contains(1) && bones.contains(2) && bones.contains(3) && bones.contains(4))
            return "u have little street, 1234. +4 points. your total points: " + (points + 4);
        else if (bonesBySides.contains(4))
            return "u have box of same. +4 points. your total points: " + (points + 4);
        else if (bonesBySides.contains(3))
            return "u have set of same. +3 points. your total points: " + (points + 3);
        else if (howManyPairs(bonesBySides) == 2)
            return "u have double pair. +2 points. your total points: " + (points + 2);
        else if (bonesBySides.contains(2))
            return "u have pair of same. +1 points. your total points: " + (points + 1);
        else
            return "u have no combinations";
    }
    public static void main(String[] args) {
        throwBones(6);
        System.out.println(bones);
//        Collections.sort(bones);
//        System.out.print(bones);
        calculatePoints(bones);
        System.out.println(ones.toString() + twos.toString() + threes.toString() + fours.toString()
                + fives.toString() + sixes.toString());
//        System.out.println(bonesBySides);
        System.out.println(findCombinations(bones));
    }
}