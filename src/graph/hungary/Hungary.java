package graph.hungary;

import java.util.Arrays;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2020-01-09 17:43
 */

public class Hungary {

    int[] persons;
    int[] places;

    public void match(int[][] matrix) {
        persons = new int[4];
        places = new int[3];
        Arrays.fill(persons, -1);
        Arrays.fill(places, -1);

        boolean[] visited;
        int res = 0;
        for (int i = 0; i < persons.length; i++) {
            visited = new boolean[places.length];
            if (hungary(matrix, i, visited)) res++;
        }
        System.out.println("res : " + res);
        System.out.println(Arrays.toString(persons));
        System.out.println(Arrays.toString(places));
    }

    public boolean hungary(int[][] matrix, int start, boolean[] visited) {
        for (int end = 0; end < places.length; end++) {
            if (matrix[start][end + persons.length] == 0 || visited[end]) continue;
            visited[end] = true;
            if (places[end] == -1 || hungary(matrix, places[end], visited)) {
                persons[start] = end;
                places[end] = start;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0}
        };

        Hungary hungary = new Hungary();
        hungary.match(matrix);
    }
}
