import java.io.File;
import java.util.*;

public class Twelve {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
//        Scanner in = new Scanner(new File("out.txt"));
        int caseLength = in.nextInt();

        for (int caseNumber = 1; caseNumber < caseLength + 1; caseNumber++) {
            System.out.printf("Case #%d\n", caseNumber);

            int n = in.nextInt();
            int m = in.nextInt();

            ArrayList<Pair>[] costs = (ArrayList<Pair>[]) new ArrayList[n];
            boolean[] answer = new boolean[n];
            int answerCount = 0;

            for (int i = 0; i < n; i++) {
                costs[i] = new ArrayList<Pair>();
            }

            for (int i = 0; i < m; i++) {
                int from = in.nextInt() - 1;
                int to = in.nextInt() - 1;
                int cost = in.nextInt();

                costs[from].add(new Pair(to, cost));
                costs[to].add(new Pair(from, cost));
            }

            for (int l = 0; l < n; l++) {
                int[] dists = new int[n];
                Arrays.fill(dists, Integer.MAX_VALUE);
                dists[l] = 0;
                boolean[] visits = new boolean[n];
                ArrayList<Integer>[] parents = (ArrayList<Integer>[]) new ArrayList[n];

                for (int i = 0; i < n; i++) {
                    parents[i] = new ArrayList<Integer>();
                }

                for (int i = 0; i < n; i++) {
                    int start = -1;
                    int best = Integer.MAX_VALUE;

                    for (int j = 0; j < n; j++) {
                        if (!visits[j] && dists[j] < best) {
                            start = j;
                            best = dists[j];
                        }
                    }

                    visits[start] = true;



                    for (Pair pair : costs[start]) {
                        int j = pair.to;

                        int temp = dists[start] + pair.cost;

                        if (temp < dists[j]) {
                            dists[j] = temp;
                            parents[j].clear();
                            parents[j].add(start);
                        } else if (temp == dists[j]) {
                            parents[j].add(start);
                        }


                    }


                }

                for (ArrayList<Integer> parent : parents) {
                    if (parent.size() == 1) {
                        int p = parent.get(0);
                        if (p != l && !answer[p]) {
                            answer[p] = true;
                            answerCount++;
                        }
                    }
                }
            }

            System.out.printf("%d", answerCount);
            for (int i = 0; i < n; i++) {
                if (answer[i]) {
                    System.out.printf(" %d", i + 1);
                }
            }
            System.out.println();
        }
    }

    public static class Pair {
        public int to, cost;

        public Pair(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}