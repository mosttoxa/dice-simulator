package com.mosttoxa;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Random;

public class Bones {
    public static int points;  // for storing points
    public static int ones, twos, threes, fours, fives, sixes = 0;  // for counting bones with side 1,2,3,4,5,6

    public static void throwBones(int number, ArrayList<Integer> bones) { // number = number of bones we want to throw
        for (int i = 0; i < number; i++) {
            int bone;
            Random random = new Random();
            bone = random.nextInt(6) + 1;
            bones.add(bone);  // making an arraylist of bones
        }
    }

    //storing numbers of specific bones in a separate arraylist. will use this to find combinations
    public static void getBonesBySides(ArrayList<Integer> bones, ArrayList<Integer> bonesBySides) {
        bones.forEach(bone -> {
            if (bone == 1)
                ones = ones + 1;  // counting number of ones
            if (bone == 2)
                twos = twos + 1;  // .. of twos
            if (bone == 3)
                threes = threes + 1;  // .. of threes
            if (bone == 4)
                fours = fours + 1;  // .. of fours
            if (bone == 5)
                fives = fives + 1;  // .. of fives
            if (bone == 6)
                sixes = sixes + 1;  // .. of sixes
        });
        bonesBySides.add(ones);
        bonesBySides.add(twos);
        bonesBySides.add(threes);
        bonesBySides.add(fours);
        bonesBySides.add(fives);
        bonesBySides.add(sixes);
    }

    public static int calculatePoints(@NotNull ArrayList<Integer> bones) {
        // first calculating points we've got on bones without combination bonus
        for (int i = 0; i < bones.size(); i++) {
            points += bones.get(i);
        }
        System.out.println("your clear points: " + points);
        return points;
    }

    // need this method to find double or triple pairs
    public static int howManyPairs(@NotNull ArrayList<Integer> bonesBySides) {
        int sum = 0;
        for (int i : bonesBySides) {
            if (i == 2) sum += 1;
        }
        return sum;
    }

    // finding combinations, adding points bonus. or finding out no combinations got
    public static String findCombinations(@NotNull ArrayList<Integer> bones, ArrayList<Integer> bonesBySides) {
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
}
