package phase2_june_2022;  
  /*   
   Bluemoon
   06/06/22 8:22 AM  
   */

import java.util.LinkedList;

public class SnakeGame {
    int gs;
    LinkedList<Cell> snake;
    boolean[][] matrix;
    int foodIndex;
    int[][] food;

    public SnakeGame(int width, int height, int[][] food) {
        matrix = new boolean[height][width];
        snake = new LinkedList<>();
        gs = 0;
        snake.add(new Cell(0, 0));
        matrix[0][0] = true;
        foodIndex = 0;
        this.food = food;

    }

    public int move(String direction) {
        Cell current = snake.getLast();
        Cell newPosition = new Cell(current.r, current.c);
        switch (direction) {
            case "D":
                newPosition.r = newPosition.r + 1;
                break;
            case "U":
                newPosition.r = newPosition.r - 1;
                break;
            case "L":
                newPosition.c = newPosition.c - 1;
                break;
            case "R":
                newPosition.c = newPosition.c + 1;
                break;
        }
        if (foodIndex < food.length && food[foodIndex][0] == newPosition.r && food[foodIndex][1] == newPosition.c) {
            foodIndex++;
            gs++;
        } else {
            Cell last = snake.removeFirst();
            matrix[last.r][last.c] = false;
        }
        if (newPosition.r < 0 || newPosition.r >= matrix.length || newPosition.c < 0 || newPosition.c >= matrix[0].length || matrix[newPosition.r][newPosition.c]) {
            return -1;
        }
        matrix[newPosition.r][newPosition.c] = true;
        snake.addLast(newPosition);
        return gs;
    }


    private static class Cell {
        int r;
        int c;

        public Cell(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        SnakeGame snakeGame = new SnakeGame(3, 3, new int[][]{{2, 0}, {0, 0}, {0, 2}, {2, 2}});
        System.out.println(snakeGame.move("D"));
        System.out.println(snakeGame.move("D"));
        System.out.println(snakeGame.move("R"));
        System.out.println(snakeGame.move("U"));
        System.out.println(snakeGame.move("U"));
        System.out.println(snakeGame.move("L"));
        System.out.println(snakeGame.move("D"));
        System.out.println(snakeGame.move("R"));
        System.out.println(snakeGame.move("R"));
        System.out.println(snakeGame.move("U"));
        System.out.println(snakeGame.move("L"));
        System.out.println(snakeGame.move("D"));
    }
}
