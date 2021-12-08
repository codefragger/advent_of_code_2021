package advent.of.code;

import org.apache.commons.collections4.ListUtils;

import java.util.*;

public class Day6Lanternfish {


    public static final int EIGHT = Integer.parseInt("8");

    public static void main(String[] args) {
        long sum = 0;
        Day6Lanternfish solution = new Day6Lanternfish();
        List<Integer> fishes = readInput();
        List<List<Integer>> partition = ListUtils.partition(fishes, 1);
        //solution.processBatch(fishes);

        for (List<Integer> part : partition) {
            sum += solution.processBatch(part);
            break;
        }

        System.out.println(sum);

    }

    public void solvePart2(List<Integer> fishes) {
        int noOfDays = 256;
        Map<Integer, Integer> map = new HashMap<>();

        fishes.stream().forEach(fish -> {
            //map.computeIfAbsent()
        });
    }

    private long processBatch(List<Integer> fishes) {

        long size = 0;

        int noOfDays = 256;

        for(int i = 0 ; i < noOfDays ; i++) {
            //for (List<Integer> fish : ListUtils.partition(fishes, 1)) {
                size += (processDay(fishes, i));
            //}

            //print(fishes);
            //System.out.println(fishes.size());
        }
        return fishes.size();
    }

    private static void print(List<Integer> fishes) {
        fishes.forEach(System.out::print);
        System.out.println("");
    }

    private static long processDay(List<Integer> fishes, int day) {
       // long resets = fishes.stream().filter( fish -> fish.equals(0)).count();
        long resets = 0;
        for (int i = 0; i < fishes.size(); i++) {
            if(fishes.get(i) == 0) {
                fishes.set(i, 6);
                resets++;
            } else {
                fishes.set(i, fishes.get(i) - 1);
            }
        }
        //adding new fishes
        for (int i = 0; i < resets; i++) {
            fishes.add(EIGHT);
        }
        System.out.println("Day " + day + " newly added = " + resets);
        return fishes.size();
    }

    private static List<Integer> readInput() {
        List<Integer> fishes = new ArrayList<>(Arrays.asList(new Integer[] {1,1,5,2,1,1,5,5,3,1,1,1,1,1,1,3,4,5,2,1,2,1,1,1,1,1,1,1,1,3,1,1,5,4,5,1,5,3,1,3,2,1,1,1,1,2,4,1,5,1,1,1,4,4,1,1,1,1,1,1,3,4,5,1,1,2,1,1,5,1,1,4,1,4,4,2,4,4,2,2,1,2,3,1,1,2,5,3,1,1,1,4,1,2,2,1,4,1,1,2,5,1,3,2,5,2,5,1,1,1,5,3,1,3,1,5,3,3,4,1,1,4,4,1,3,3,2,5,5,1,1,1,1,3,1,5,2,1,3,5,1,4,3,1,3,1,1,3,1,1,1,1,1,1,5,1,1,5,5,2,1,5,1,4,1,1,5,1,1,1,5,5,5,1,4,5,1,3,1,2,5,1,1,1,5,1,1,4,1,1,2,3,1,3,4,1,2,1,4,3,1,2,4,1,5,1,1,1,1,1,3,4,1,1,5,1,1,3,1,1,2,1,3,1,2,1,1,3,3,4,5,3,5,1,1,1,1,1,1,1,1,1,5,4,1,5,1,3,1,1,2,5,1,1,4,1,1,4,4,3,1,2,1,2,4,4,4,1,2,1,3,2,4,4,1,1,1,1,4,1,1,1,1,1,4,1,5,4,1,5,4,1,1,2,5,5,1,1,1,5}));

        return fishes;
    }
}
