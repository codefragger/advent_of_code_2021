package advent.of.code;

import org.apache.commons.collections4.ListUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day4GiantSquid {

    List<List<String>> colBoards = new ArrayList<>();

    List<List<String>> rowBoards = new ArrayList<>();

    List<String> finalNumbers = null;


    public static void main(String[] args) throws FileNotFoundException {
        Day4GiantSquid solution = new Day4GiantSquid();
        solution.readInput();
        boolean[] boardComplete = new boolean[(solution.rowBoards.size()) / 5];
        for (String n : solution.finalNumbers) {
            boolean bingo = false;
            int boardNo = -1;
            String solvedNo = "";
            for (int i= 0 ; i < solution.rowBoards.size() ; i++) {

                List<String> row = solution.rowBoards.get(i);
                if(row.isEmpty()) {
                    continue;
                }
                row.remove(n);
                if(row.isEmpty()) {
                    boardNo = (i / 5);

                    bingo = true;
                    solvedNo = n;

                    long sum = solution.getSumOfUncalledNoforBoard(boardNo, solution.rowBoards);
                    if(!boardComplete[boardNo]) {
                        System.out.println("boardNo = " + boardNo + " Sum = " + sum * Integer.parseInt(solvedNo));
                    }
                    boardComplete[boardNo] = true;
                    //return;
                }
            }
            for (int i= 0 ; i < solution.colBoards.size() ; i++) {
                List<String> col = solution.colBoards.get(i);
                if(col.isEmpty()) {
                    continue;
                }
                col.remove(n);
                if(col.isEmpty()) {
                    boardNo = (i / 5);
                    bingo = true;
                    solvedNo = n;

                    long sum = solution.getSumOfUncalledNoforBoard(boardNo, solution.colBoards);
                    if(!boardComplete[boardNo]) {
                        System.out.println("boardNo = " + boardNo + " Sum = " + sum * Integer.parseInt(solvedNo));
                    }
                    boardComplete[boardNo] = true;
                   // return;
                }
            }

        }
        System.out.println("");
    }

    private long getSumOfUncalledNoforBoard(int boardNo, List<List<String>> rowBoards) {
        long sum = 0;
        for(int i = boardNo * 5 ; i < (boardNo * 5) + 5 ; i++) {
            for (Integer integer : rowBoards.get(i).stream().map(Integer::parseInt).collect(Collectors.toList())) {
                sum += integer;
            }
        }
        return sum;
    }

    private void readInput() throws FileNotFoundException {
        //Scanner scanner = new Scanner(new File("C:\\Users\\soura\\IdeaProjects\\AdventOfCode\\src\\main\\resources\\Day4InputTest.txt"));
        Scanner scanner = new Scanner(new File("C:\\Users\\soura\\IdeaProjects\\AdventOfCode\\src\\main\\resources\\Day4Input.txt"));
        String numbers = scanner.nextLine();
        finalNumbers = Arrays.asList(numbers.split(","));

        scanner.nextLine(); //empty line
        
        //List<List<String>> rowBoards = new ArrayList<>();
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if(line.isEmpty()) {
                continue;
            }
            
            rowBoards.add(Arrays.asList(line.split(" ")).stream().filter(entry -> !entry.isEmpty()).collect(Collectors.toList()));
            
        }

        //List<List<String>> colBoards = new ArrayList<>();
        List<List<List<String>>> boards = ListUtils.partition(rowBoards, 5);

        for (int i = 0; i < boards.size(); i++) {
            List<List<String>> ithBoard = boards.get(i);

            for (int j = 0; j < 5; j++) {
                List<String> cols = new ArrayList<>();
                for (List<String> row : ithBoard) {
                    cols.add(row.get(j));
                }
                colBoards.add(cols);
            }
        }

    }
}
