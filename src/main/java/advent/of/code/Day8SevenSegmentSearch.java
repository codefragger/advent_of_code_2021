package advent.of.code;

import advent.of.code.util.SevenSegmentSearch;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Day8SevenSegmentSearch {

    List<String> finalDigits = new ArrayList<>();
    List<SevenSegmentSearch> readings = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        Day8SevenSegmentSearch solution = new Day8SevenSegmentSearch();
        solution.readInput();

        //part1(solution);
        List<Integer> allReadings = new ArrayList<>();
        for (SevenSegmentSearch reading : solution.readings) {
            BiMap<String, Integer> map = HashBiMap.create();
            map.put(reading.alldigits.stream().filter(d -> d.length() == 2).findFirst().get(), 1);
            map.put(reading.alldigits.stream().filter(d -> d.length() == 3).findFirst().get(), 7);
            map.put(reading.alldigits.stream().filter(d -> d.length() == 4).findFirst().get(), 4);
            map.put(reading.alldigits.stream().filter(d -> d.length() == 7).findFirst().get(), 8);

            List<String> length5 = reading.alldigits.stream().filter(d -> d.length() == 5).collect(Collectors.toList());
            List<String> length6 = reading.alldigits.stream().filter(d -> d.length() == 6).collect(Collectors.toList());

            String three = length5.stream().filter(d -> d.chars().mapToObj(c-> (char)c).collect(Collectors.toSet()).containsAll(map.inverse().get(7).chars().mapToObj(c-> (char) c).collect(Collectors.toSet()))).findFirst().get();
            length5.remove(three);
            map.put(three, 3);

            String nine = length6.stream().filter(d -> d.chars().mapToObj(c-> (char)c).collect(Collectors.toSet()).containsAll(map.inverse().get(4).chars().mapToObj(c-> (char) c).collect(Collectors.toSet()))).findFirst().get();
            length6.remove(nine);
            map.put(nine, 9);

            Set<Character> eight = map.inverse().get(8).chars().mapToObj(c-> (char)c).collect(Collectors.toSet());
            eight.removeAll(nine.chars().mapToObj(c-> (char)c).collect(Collectors.toSet()));

            String charG = eight.stream().findFirst().get().toString();

            String two = length5.stream().filter(d -> d.contains(charG)).findFirst().get();
            length5.remove(two);
            map.put(two, 2);

            map.put(length5.get(0), 5);

            String six = length6.stream().filter(d -> d.chars().mapToObj(c -> (char) c).collect(Collectors.toSet()).containsAll(map.inverse().get(5).chars().mapToObj(c -> (char)c).collect(Collectors.toSet()))).findFirst().get();
            length6.remove(six);
            map.put(six, 6);

            map.put(length6.get(0), 0);

            StringBuilder builder = new StringBuilder();
            for (String digit : reading.fourDigits) {

                builder.append(map.get(digit));

            }

            allReadings.add(Integer.parseInt(builder.toString()));
            //System.out.println();
            //System.out.println("done");
        }

        long sum = 0;

        for (Integer reading : allReadings) {
            sum += reading;
        }
        System.out.println(sum);
    }

    private static void part1(Day8SevenSegmentSearch solution) {
        long count = 0;

        for (String digit : solution.finalDigits) {
            int len = digit.trim().length();
            if(len == 2 || len == 3 || len == 4 || len == 7) {
                count++;
            }
        }

        System.out.println(count);
    }

    public void readInput() throws FileNotFoundException {
        //Scanner scanner = new Scanner(new File("C:\\Users\\soura\\IdeaProjects\\AdventOfCode\\src\\main\\resources\\day8\\day8TestInput.txt"));
        Scanner scanner = new Scanner(new File("C:\\Users\\soura\\IdeaProjects\\AdventOfCode\\src\\main\\resources\\day8\\day8Input.txt"));
        while(scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            String[] split = nextLine.split("\\|");
            /*String[] allDigits = split[0].trim().split("");
            String[] digits = split[1].trim().split(" ");*/

            List<String> allDigits = new ArrayList<>();
            for (String s : split[0].trim().split(" ")) {
                char[] array = s.toCharArray();
                Arrays.sort(array);
                allDigits.add(new String(array));
            }
            List<String> digits = new ArrayList<>();
            for (String s : split[1].trim().split(" ")) {
                char[] array = s.toCharArray();
                Arrays.sort(array);
                digits.add(new String(array));
            }

            SevenSegmentSearch obj = new SevenSegmentSearch();
            obj.alldigits = allDigits;
            obj.fourDigits = digits;

            readings.add(obj);
        }
    }

}
