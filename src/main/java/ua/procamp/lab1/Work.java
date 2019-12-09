package ua.procamp.lab1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Work {
    public static void main(String[] args){
        final List<Integer> firstQuestions = new ArrayList<>();
        final List<Integer> secondQuestions = new ArrayList<>();
        final List<Integer> thirdQuestions = new ArrayList<>();
        final Random random = new Random();
        for (int i = 0; i < 15; i++) {
            firstQuestions.add(1 + random.nextInt(15));
            secondQuestions.add(16 + random.nextInt(15));
            thirdQuestions.add(32 + random.nextInt(15));
        }
        System.out.println("First questions: " + firstQuestions);
        System.out.println("Second questions: " + secondQuestions);
        System.out.println("Third questions: " + thirdQuestions);
        List<List<Integer>> examineQuestions = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            examineQuestions.add(new ArrayList<Integer>() {{
                add(firstQuestions.get(random.nextInt(15)));
                add(secondQuestions.get(random.nextInt(15)));
                add(thirdQuestions.get(random.nextInt(15)));
            }});
        }
        System.out.println("Examine questions: " + examineQuestions);
    }
}
