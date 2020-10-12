import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Zewei Ni
 * @version :PACKAGE_NAME on 2020-10-12 17:43 Zewei Ni
 * @name Combine
 */
public class Combine {

    public List<List<Integer>> combine(int n, int k) {
        //转换成二叉树的遍历
        List<List<Integer>> res = new ArrayList<>();
        if (k<=0 || n<k) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, 1, path, res);
        return res;
    }


    public void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        //terminal
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        //process
        for (int i=begin; i<=n - (k - path.size()) + 1; i++) {
            path.addLast(i);
            //drill down
            dfs(n, k, i+1, path, res);
            //revert
            path.removeLast();
        }



    }
}
