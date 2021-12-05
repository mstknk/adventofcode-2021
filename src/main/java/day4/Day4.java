package day4;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day4 {
    private static List<Board> boardList = new ArrayList<>();
    private static List<Integer> numbers;

    public static void main(String[] args) throws IOException {
        Path path = FileSystems.getDefault().getPath("src/main/resources/day4_input.txt");
        List<String> lines = Files.readAllLines(path);
        createGame(lines);
        System.out.println(playGame());
    }

    public static int playGame() {
        Board bingoBoard = null;
        int called = 0;
        outside:
        for (Integer number : numbers) {

            for (Board board : boardList) {
                board.mark(number);
                if (board.checkBingo()) {
                    bingoBoard = board;
                    called = number;
                    break outside;
                }
            }
        }
        int count = bingoBoard.sumOfUnMarked();
        return count * called;
    }

    public static int createGame(List<String> lines) {
        String[] numberstr = lines.get(0).split(",");
        numbers = Arrays.asList(numberstr).stream().map(Integer::parseInt).collect(Collectors.toList());
        int count = 0;
        int boardMatrix[][] = new int[5][5];
        for (int i = 2; i < lines.size(); i++) {
            if (!lines.get(i).isEmpty()) {
                List<Integer> m = Arrays.asList(lines.get(i).trim().split(" ")).stream().filter(e -> !e.isEmpty()).map(Integer::parseInt).collect(Collectors.toList());
                for (int j = 0; j < m.size(); j++) {
                    boardMatrix[count][j] = m.get(j);
                }
                count++;
            } else {
                Board board = new Board(boardMatrix);
                count = 0;
                boardList.add(board);
            }

        }
        Board board = new Board(boardMatrix);
        boardList.add(board);
        return 0;
    }
}
