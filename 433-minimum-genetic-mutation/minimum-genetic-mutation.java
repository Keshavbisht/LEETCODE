import java.util.*;

class Solution {

    ArrayList<String> vis;
    Queue<String> q;
    ArrayList<Character> arr;

    public int minMutation(String startGene, String endGene, String[] bank) {

        int n = startGene.length();

        arr = new ArrayList<>();

        arr.add('A');
        arr.add('C');
        arr.add('G');
        arr.add('T');

        ArrayList<String> bank_2 = new ArrayList<>();

        for (int i = 0; i < bank.length; i++) {
            bank_2.add(bank[i]);
        }

        vis = new ArrayList<>();
        q = new LinkedList<>();

        q.add(startGene);
        q.add("#");

        return bfs(n, endGene, bank_2);
    }

    public int bfs(int n, String end, ArrayList<String> bank) {

        int ans = 0;

        while (!q.isEmpty()) {

            String currStr = q.remove();

            if (currStr.equals("#")) {

                ans++;

                if (!q.isEmpty()) {
                    q.add("#");
                }

                continue;
            }

            if (currStr.equals(end)) {
                return ans;
            }

            if (vis.contains(currStr)) {
                continue;
            }

            vis.add(currStr);

            StringBuilder curr = new StringBuilder(currStr);

            for (int j = 0; j < n; j++) {

                char old = curr.charAt(j);

                for (int i = 0; i < 4; i++) {

                    char ch = arr.get(i);

                    if (ch == old) continue;

                    curr.setCharAt(j, ch);

                    String temp = curr.toString();

                    if (!vis.contains(temp) &&
                        bank.contains(temp)) {

                        q.add(temp);
                    }
                }

                curr.setCharAt(j, old);
            }
        }

        return -1;
    }
}