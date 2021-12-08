package advent.of.code;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day2Dive {
    public static void main(String[] args) {
        List<String> input = readInput();
        long forward = 0;
        long depth = 0;

        //part1(input, forward, depth);
        part2(input);
    }

    private static void part2(List<String> input) {
        long aim = 0;
        long forward = 0;
        long depth = 0;

        for (int i = 0; i < input.size(); i++) {
            if(input.get(i).contains("forward")) {
                long value = replaceFoward(input.get(i));
                forward += value;
                depth += (aim * value);
            } else {
                long value = replaceDepth(input.get(i));
                aim += value;
            }
        }

        System.out.println(forward);
        System.out.println(depth);
        System.out.println(forward * depth);
    }

    private static void part1(List<String> input, long forward, long depth) {
        List<Long> forwardInputs = input.stream().filter(navi -> navi.startsWith("forward")).map(Day2Dive::replaceFoward).collect(Collectors.toList());

        for (int i = 0; i < forwardInputs.size(); i++) {
            forward += forwardInputs.get(i);
        }

        List<Long> depthInputs = input.stream().filter(navi -> navi.startsWith("up") || navi.startsWith("down")).map(Day2Dive::replaceDepth).collect(Collectors.toList());

        for (int i = 0; i < depthInputs.size(); i++) {
            depth += depthInputs.get(i);
        }

        System.out.println(forward);
        System.out.println(depth);
        System.out.println(forward * depth);
    }

    private static long replaceDepth(String navi) {
        if(navi.contains("up")) {
            return -1 * Long.parseLong(navi.replace("up","").trim());
        } else {
            return Long.parseLong(navi.replace("down","").trim());
        }
    }

    private static List<String> readInput() {
        /*List<String> navigations=Arrays.asList(new String[] {"forward 5",
                "down 5",
                "forward 8",
                "up 3",
                "down 8",
                "forward 2"});*/
        List<String> navigations=Arrays.asList(new String[] {"forward 4", "forward 6", "down 8", "forward 3", "forward 9", "down 7", "down 7", "down 1", "forward 1", "forward 5", "up 4", "forward 3", "forward 9", "forward 5", "down 8", "forward 6", "forward 8", "up 4", "forward 1", "forward 4", "up 3", "down 2", "down 2", "up 8", "forward 9", "down 5", "down 6", "down 4", "forward 1", "forward 7", "down 1", "forward 2", "down 7", "down 6", "forward 3", "forward 1", "down 7", "forward 3", "up 7", "up 1", "forward 6", "down 8", "down 4", "down 1", "down 7", "forward 9", "down 2", "forward 9", "up 4", "down 7", "forward 9", "forward 9", "up 4", "up 7", "up 2", "forward 1", "down 9", "forward 2", "forward 8", "forward 5", "down 9", "forward 5", "up 1", "forward 8", "down 6", "down 1", "down 1", "down 8", "down 6", "down 4", "down 6", "forward 7", "forward 5", "forward 4", "up 8", "up 4", "forward 6", "forward 9", "forward 6", "down 2", "up 8", "forward 3", "forward 8", "down 5", "forward 1", "down 6", "down 7", "up 4", "down 8", "forward 6", "up 4", "forward 7", "down 8", "down 8", "down 2", "down 8", "up 7", "forward 7", "forward 6", "down 2", "forward 9", "down 7", "down 4", "forward 1", "up 9", "down 6", "up 7", "down 6", "down 2", "down 2", "forward 3", "down 8", "forward 4", "down 7", "down 2", "up 8", "down 6", "forward 2", "forward 2", "down 6", "up 6", "down 7", "up 5", "up 4", "up 9", "forward 9", "forward 7", "down 4", "down 4", "up 5", "down 2", "forward 3", "down 9", "down 5", "forward 8", "up 3", "forward 7", "forward 9", "down 3", "forward 1", "up 1", "forward 5", "down 8", "down 2", "forward 3", "down 6", "down 8", "up 9", "down 9", "forward 4", "up 5", "forward 8", "forward 7", "forward 7", "down 3", "down 5", "forward 8", "down 1", "down 2", "forward 2", "up 9", "down 3", "down 9", "forward 2", "down 4", "up 9", "up 3", "down 1", "down 1", "forward 6", "down 5", "down 9", "forward 2", "up 5", "forward 3", "down 1", "down 7", "forward 1", "forward 1", "down 7", "up 3", "up 1", "up 6", "forward 9", "up 1", "down 8", "down 5", "up 6", "up 2", "down 8", "forward 3", "forward 1", "down 7", "up 1", "down 9", "down 9", "up 8", "forward 4", "up 8", "forward 8", "down 5", "forward 5", "forward 2", "forward 1", "forward 5", "down 8", "forward 6", "forward 8", "down 5", "forward 8", "up 1", "up 9", "up 7", "down 5", "down 9", "up 4", "down 7", "up 8", "up 3", "forward 6", "down 9", "forward 4", "down 4", "forward 2", "forward 3", "down 4", "down 5", "down 3", "forward 9", "forward 5", "forward 9", "forward 4", "down 5", "down 7", "down 5", "forward 8", "up 5", "down 2", "forward 3", "forward 4", "down 5", "up 8", "forward 5", "down 2", "up 4", "down 5", "down 2", "forward 1", "up 3", "down 6", "down 8", "down 3", "forward 1", "up 5", "forward 1", "down 3", "forward 4", "down 6", "forward 8", "forward 4", "forward 1", "down 8", "down 2", "forward 8", "down 5", "forward 2", "forward 2", "down 9", "forward 1", "forward 8", "up 1", "forward 1", "down 1", "down 7", "down 4", "up 4", "down 3", "forward 1", "forward 9", "down 9", "up 6", "up 8", "down 2", "down 2", "down 3", "forward 2", "forward 9", "down 1", "up 9", "down 3", "down 9", "down 1", "down 7", "forward 9", "forward 7", "down 5", "down 2", "down 9", "down 2", "down 7", "up 7", "down 2", "up 3", "up 5", "forward 8", "up 7", "forward 1", "down 9", "down 9", "down 1", "forward 6", "down 7", "up 4", "up 4", "down 9", "up 5", "up 8", "down 3", "down 5", "forward 6", "up 3", "down 8", "down 5", "forward 9", "up 6", "forward 9", "forward 5", "up 6", "up 9", "down 2", "up 5", "forward 9", "down 1", "up 1", "down 9", "forward 4", "forward 4", "forward 8", "down 5", "down 3", "down 7", "forward 5", "down 6", "forward 3", "down 5", "down 5", "up 5", "forward 8", "forward 1", "forward 2", "forward 6", "up 1", "down 5", "down 4", "up 5", "forward 3", "forward 2", "forward 2", "forward 2", "forward 7", "forward 8", "down 2", "up 8", "forward 4", "down 4", "forward 7", "down 6", "down 7", "forward 5", "down 5", "forward 1", "down 8", "forward 6", "down 1", "forward 3", "up 3", "down 7", "down 2", "up 4", "down 3", "up 2", "up 8", "down 2", "forward 5", "forward 3", "down 9", "down 9", "up 2", "forward 6", "forward 9", "down 1", "forward 6", "down 4", "up 2", "down 7", "down 3", "down 3", "forward 2", "down 5", "down 9", "down 7", "forward 7", "forward 9", "up 8", "down 8", "down 3", "up 5", "down 9", "forward 8", "forward 8", "down 1", "forward 5", "forward 2", "forward 7", "down 9", "down 7", "forward 6", "up 9", "forward 3", "forward 5", "up 7", "down 9", "forward 9", "forward 4", "forward 5", "forward 9", "forward 8", "forward 1", "forward 2", "forward 8", "down 7", "forward 3", "up 2", "up 7", "forward 1", "forward 3", "forward 9", "up 3", "down 2", "forward 3", "forward 6", "forward 3", "forward 3", "forward 3", "forward 1", "forward 1", "up 5", "down 5", "up 5", "down 5", "down 5", "forward 8", "forward 1", "down 4", "forward 7", "down 6", "down 1", "down 2", "down 2", "down 6", "up 8", "forward 3", "forward 2", "up 8", "up 2", "forward 1", "forward 6", "forward 5", "forward 6", "forward 7", "down 8", "forward 1", "down 4", "forward 2", "up 4", "forward 4", "down 1", "forward 5", "down 7", "forward 7", "up 7", "forward 1", "down 2", "forward 8", "forward 5", "up 8", "up 8", "up 2", "down 9", "forward 2", "down 4", "down 3", "down 5", "down 5", "down 2", "up 5", "forward 6", "up 7", "forward 8", "up 7", "down 4", "forward 1", "down 3", "forward 2", "forward 1", "down 2", "up 7", "forward 5", "up 8", "up 1", "down 4", "forward 6", "down 4", "up 9", "forward 5", "down 2", "down 7", "down 7", "forward 4", "forward 4", "forward 9", "down 1", "forward 6", "forward 1", "up 9", "forward 4", "forward 4", "forward 8", "forward 3", "forward 4", "down 3", "up 5", "up 1", "forward 3", "down 6", "down 4", "down 2", "forward 3", "forward 8", "up 6", "up 3", "forward 8", "down 3", "down 6", "forward 1", "up 7", "down 4", "down 5", "up 7", "forward 3", "up 4", "forward 9", "forward 6", "down 3", "forward 4", "down 6", "forward 1", "forward 6", "forward 4", "forward 2", "forward 1", "forward 3", "forward 1", "down 1", "down 9", "down 5", "down 7", "down 4", "down 8", "up 1", "down 6", "down 1", "forward 4", "down 9", "up 9", "down 6", "forward 6", "forward 8", "up 7", "forward 4", "down 3", "forward 9", "forward 6", "forward 8", "down 1", "up 2", "down 2", "down 8", "forward 4", "down 9", "down 3", "forward 5", "down 9", "down 4", "up 5", "down 8", "down 4", "down 9", "up 4", "down 5", "down 7", "down 3", "up 1", "up 1", "down 4", "down 6", "forward 8", "down 8", "down 6", "forward 6", "forward 9", "forward 3", "forward 3", "down 2", "down 4", "forward 3", "up 5", "up 3", "down 5", "down 1", "forward 5", "forward 7", "forward 1", "forward 4", "forward 5", "forward 1", "down 7", "down 8", "up 9", "down 8", "down 5", "up 3", "down 5", "down 5", "forward 8", "down 2", "forward 7", "forward 7", "down 1", "forward 2", "forward 7", "forward 5", "down 6", "forward 5", "down 5", "forward 4", "down 8", "forward 7", "up 5", "forward 5", "down 7", "down 7", "up 4", "forward 8", "up 1", "forward 3", "forward 7", "down 2", "forward 1", "down 4", "up 8", "forward 3", "forward 1", "forward 6", "forward 3", "up 4", "forward 3", "down 3", "forward 7", "forward 9", "forward 8", "down 6", "down 8", "up 6", "down 9", "forward 7", "forward 1", "up 4", "forward 5", "forward 8", "down 7", "down 9", "up 6", "up 6", "forward 9", "down 1", "forward 8", "down 9", "down 5", "forward 6", "forward 1", "down 4", "forward 8", "down 9", "down 4", "forward 5", "forward 7", "forward 3", "down 2", "forward 6", "forward 3", "forward 8", "down 1", "down 5", "up 6", "down 2", "down 1", "up 3", "down 7", "up 1", "forward 8", "down 6", "down 6", "forward 8", "up 3", "forward 8", "up 3", "forward 3", "forward 7", "forward 1", "down 1", "up 5", "forward 5", "forward 9", "forward 5", "forward 1", "forward 4", "down 8", "forward 2", "up 3", "forward 3", "down 9", "forward 2", "forward 6", "forward 3", "up 8", "up 1", "down 6", "forward 3", "down 4", "down 5", "forward 6", "forward 9", "down 4", "down 9", "down 7", "down 1", "up 3", "up 6", "forward 4", "forward 5", "down 1", "forward 3", "up 5", "forward 7", "down 9", "forward 5", "down 5", "down 1", "down 1", "down 1", "up 8", "down 4", "down 9", "forward 5", "down 5", "up 5", "up 3", "forward 1", "forward 7", "down 2", "forward 6", "forward 5", "up 4", "up 4", "forward 1", "down 7", "down 8", "up 3", "down 3", "up 4", "forward 2", "up 4", "up 4", "forward 8", "forward 1", "forward 2", "forward 7", "down 6", "forward 8", "forward 9", "forward 6", "forward 9", "down 3", "up 3", "forward 5", "down 1", "forward 1", "forward 4", "forward 2", "down 6", "up 7", "forward 9", "down 2", "up 5", "forward 6", "down 9", "down 6", "down 8", "forward 2", "down 7", "forward 6", "down 8", "forward 3", "forward 7", "forward 6", "down 7", "down 6", "forward 5", "up 8", "forward 6", "down 1", "up 9", "forward 6", "down 6", "down 5", "down 6", "up 2", "down 3", "down 7", "down 3", "forward 4", "up 9", "up 2", "forward 1", "forward 7", "forward 7", "forward 9", "forward 8", "forward 7", "down 3", "forward 4", "forward 8", "down 9", "forward 2", "forward 2", "up 9", "up 7", "forward 2", "down 8", "down 3", "down 1", "forward 1", "forward 3", "down 2", "forward 7", "up 4", "down 7", "down 1", "forward 8", "forward 2", "up 1", "down 5", "forward 8", "up 5", "up 7", "forward 4", "forward 7", "up 4", "up 3", "forward 5", "forward 9", "forward 1", "forward 3", "down 9", "up 2", "forward 8", "down 3", "forward 3", "forward 2", "down 8", "down 2", "down 3", "forward 1", "up 7", "down 1", "forward 3", "forward 8", "down 3", "down 9", "up 1", "down 9", "up 7", "up 7", "forward 7", "forward 7", "up 8", "down 2", "down 7", "down 1", "forward 5", "forward 5", "forward 7", "down 8", "forward 5", "down 9", "down 8", "forward 3", "up 9", "forward 3", "up 6", "forward 7", "up 7", "forward 3", "forward 2", "down 1", "down 4", "forward 1", "forward 8", "up 5", "down 5", "up 1", "down 5", "up 1", "up 6", "forward 5", "forward 5", "down 3", "down 3", "forward 2", "up 3", "up 2", "down 6", "down 5", "down 1", "down 1", "up 6", "forward 2", "forward 2", "up 4", "up 6", "up 6", "down 8", "up 2", "forward 4", "down 3", "forward 3", "up 4", "down 5", "forward 6", "forward 7", "up 6", "down 3", "down 7", "up 4", "down 2", "up 2", "forward 1", "down 8", "down 1", "down 1", "up 9", "down 1", "down 1", "up 1", "forward 8", "forward 4", "down 4", "forward 1", "down 4", "up 7", "forward 7", "forward 3", "down 4", "forward 9", "forward 1", "down 3", "down 2", "forward 7", "up 1", "forward 3", "up 3", "down 3", "down 7", "up 3", "up 4", "forward 7", "down 2", "up 2", "down 9", "up 1", "forward 3", "up 8", "up 8", "down 8", "down 1", "up 8", "up 4", "down 6", "forward 8"});
        return navigations;
    }

    public static long replaceFoward(String navi) {
        return Long.parseLong(navi.replace("forward","").trim());
    }
}
