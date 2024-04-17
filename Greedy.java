import java.util.*;
import java.util.Arrays;
public class Greedy {
        public static void printMatrix(int[][] a) {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[i].length; j++) {
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("-------------------");
        }
    
        public static void denominations(int[] a, int N) {
            ArrayList<Integer> ans = new ArrayList<>();
            for (int i = a.length - 1; i >= 0; i--) {
                if (a[i] <= N) {
                    while (a[i] <= N) {
                        ans.add(a[i]);
                        N -= a[i];
                    }
                }
            }
            System.out.print(ans);
        }
    
        public static void fractionalKnapsack(int[] w, int[] v, int c) {
            int[][] a = new int[w.length][3];
            for (int i = 0; i < a.length; i++) {
                a[i][0] = w[i];
                a[i][1] = v[i];
                a[i][2] = v[i] / w[i];
            }
            Arrays.sort(a, Comparator.comparingDouble(o -> o[2]));
            int profit = 0;
            for (int i = a.length - 1; i >= 0; i--) {
                if (c <= a[i][0]) {
                    profit += a[i][1];
                    c -= a[i][0];
                } else {
                    profit += (c * a[i][2]);
                    break;
                }
            }
            System.out.print(profit);
        }
    
        public static void jobSequencing(int[] schedules, int[] profits) {
            int[][] a = new int[schedules.length][2];
            int days = 0;
            for (int i = 0; i < a.length; i++) {
                a[i][0] = schedules[i];
                a[i][1] = profits[i];
                days = Math.max(days, schedules[i]);
    
            }
            int[] d = new int[days];
            Arrays.sort(a, Comparator.comparingDouble(o -> o[1]));
            int profit = 0;
            for (int i = a.length - 1; i >= 0; i--) {
                int ind = a[i][0] - 1;
                while (ind >= 0 && d[ind] == -1) {
                    ind--;
                }
                if (ind >= 0 && d[ind] == 0) {
                    d[ind] = -1;
                    profit += a[i][1];
                }
            }
            System.out.println(profit);
        }
        public static List<Integer> minPartition(int N) {
            int[] coins = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
            List<Integer> res = new ArrayList<>();
            int pointer = coins.length - 1;
            while (N > 0) {
                while (N >= coins[pointer]) {
                    res.add(coins[pointer]);
                    N -= coins[pointer];
                }
                pointer--;
    
            }
        }
        public static void main(String[] args) {
            
            //   int[][] a = { { 10, 35 }, { 7, 39 }, { 6, 60 }, { 1, 12 } };
            //   printMatrix(a);
            //   Arrays.sort(a, Comparator.comparingDouble(o -> o[0]));
            //   printMatrix(a);
              
            //   int[] a = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
            //   denominations(a, 43);
            //   int[] w = { 10, 20, 30 };
            //   int[] v = { 60, 100, 120 };
            //   fractionalKnapsack(w, v, 50);
             
            int[] schedules = { 2, 1, 2, 1, 1 };
            int[] profits = { 100, 25, 27, 19, 15 };
            jobSequencing(schedules, profits);
    
        }
    
    }
