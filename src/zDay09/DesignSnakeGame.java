package zDay09;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * @program: LeetForWork
 * @description: 353. Design Snake Game
 * @author: Zekun Zhang
 * @create: 2020-02-18 21:07
 */

public class DesignSnakeGame {

    private LinkedList<Integer> list;
    private HashSet<Integer> set;
    private int indexFood;
    private int[][] food;
    private int width, height, len;
    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public DesignSnakeGame(int width, int height, int[][] food) {
        this.list = new LinkedList<>();
        list.add(0);
        this.set = new HashSet<>();
        set.add(0);
        this.indexFood = 0;
        this.food = food;
        this.width = width;
        this.height = height;
        this.len = 0;
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int first = list.get(0);
        int first_i = first / width;
        int first_j = first % width;
        int i = -1, j = -1;
        if (direction.equals("U")) {
            i = first_i - 1;
            j = first_j;
        } else if (direction.equals("D")) {
            i = first_i + 1;
            j = first_j;
        } else if (direction.equals("L")) {
            i = first_i;
            j = first_j - 1;
        } else if (direction.equals("R")) {
            i = first_i;
            j = first_j + 1;
        }
        int newPos = i * width + j;
        if (i >= height || i < 0 || j >= width || j < 0) return -1;
        if (indexFood < food.length && i == food[indexFood][0] && j == food[indexFood][1]) {
            indexFood++;
            len++;
        } else {
            int last = list.removeLast();
            set.remove(last);
        }
        if (set.contains(newPos)) return -1;
        list.addFirst(newPos);
        set.add(newPos);
        return len;
    }
}
