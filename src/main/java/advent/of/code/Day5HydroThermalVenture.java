package advent.of.code;

import advent.of.code.util.Line;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day5HydroThermalVenture {

    List<Line> lines = new ArrayList<>();
    int maxCoordinate = 0;

    public static void main(String[] args) throws FileNotFoundException {
        Day5HydroThermalVenture solution = new Day5HydroThermalVenture();
        solution.readInput();

        int[][] array = new int[solution.maxCoordinate + 1][solution.maxCoordinate + 1];

        for (Line line : solution.lines) {
            if(line.x1 == line.x2) {
                int yMin = Math.min(line.y1, line.y2);
                int yMax = Math.max(line.y1, line.y2);

                for(int i = yMin ; i <= yMax; i++) {
                    array[i][line.x1]++;
                }
            } else if(line.y1 == line.y2) {
                int xMin = Math.min(line.x1, line.x2);
                int xMax = Math.max(line.x1, line.x2);
                for(int i = xMin ; i <= xMax; i++) {
                    array[line.y1][i]++;
                }
            } else if(line.x1 == line.y1 && line.x2 == line.y2) {
                int xMin = Math.min(line.x1, line.x2);
                int xMax = Math.max(line.x1, line.x2);
                for(int i = xMin ; i <= xMax; i++) {
                    array[i][i]++;
                }
            } else {
                int xMin = Math.min(line.x1, line.x2);
                int xMax = Math.max(line.x1, line.x2);

                int m = (line.y1 - line.y2) / (line.x1 - line.x2);

                int b = ((line.x1 * line.y2) - (line.x2 * line.y1)) / (line.x1 - line.x2);

                for(int i = xMin ; i <= xMax; i++) {
                    int y = (m * i) + b;
                    array[y][i]++;
                }
            }

        }
        int count = 0;
        for (int i = 0; i < solution.maxCoordinate + 1; i++) {
            for (int j = 0; j < solution.maxCoordinate + 1; j++) {
                if(array[i][j] > 1) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    private void readInput() throws FileNotFoundException {
        //Scanner scanner = new Scanner(new File("C:\\Users\\soura\\IdeaProjects\\AdventOfCode\\src\\main\\resources\\day5\\testInput.txt"));
        Scanner scanner = new Scanner(new File("C:\\Users\\soura\\IdeaProjects\\AdventOfCode\\src\\main\\resources\\day5\\day5Input.txt"));
        lines = new ArrayList<>();

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            //0,9 -> 5,9
            String[] points = line.split("->");

            String[] point1 = points[0].trim().split(",");
            String[] point2 = points[1].trim().split(",");

            Line pLine = new Line();
            pLine.x1 = Integer.parseInt(point1[0].trim());
            pLine.y1 = Integer.parseInt(point1[1].trim());
            pLine.x2 = Integer.parseInt(point2[0].trim());
            pLine.y2 = Integer.parseInt(point2[1].trim());

            if(pLine.x1 > maxCoordinate) {
                maxCoordinate = pLine.x1;
            }
            if(pLine.y1 > maxCoordinate) {
                maxCoordinate = pLine.y1;
            }
            if(pLine.x2 > maxCoordinate) {
                maxCoordinate = pLine.x2;
            }
            if(pLine.y2 > maxCoordinate) {
                maxCoordinate = pLine.y2;
            }

            lines.add(pLine);

        }
    }
}
