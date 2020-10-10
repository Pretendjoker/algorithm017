import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Zewei Ni
 * @version :PACKAGE_NAME on 2020-10-10 13:47 Zewei Ni
 * @name LowestCommonAncestor
 */
public class LowestCommonAncestor {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }


    TreeNode findNode = null;
    Map<TreeNode, TreeNode> map = new HashMap<>(64);
    List<TreeNode> visited = new ArrayList<>(64);

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //1. 从根节点遍历，判断是否左子树+右子树包含p和q，递归
        // dfs(root, p, q);
        // return findNode;
        //2. 遍历p的父节点，再遍历q的父节点，第一个重复的就是最近祖先
        dfs2(root);
        while(p != null) {
            visited.add(p);
            p = map.get(p);
        }
        while(q != null) {
            if (visited.contains(q)) {
                findNode = q;
                break;
            }
            q = map.get(q);
        }
        return findNode;
    }

    public boolean dfs(TreeNode currNode, TreeNode p, TreeNode q) {
        //terminate
        if (currNode == null) {
            return false;
        }
        //process+drill down
        boolean lson = dfs(currNode.left, p, q);
        boolean rson = dfs(currNode.right, p, q);
        if ((lson && rson) || ((currNode.val == p.val || currNode.val == q.val) && (lson || rson))) {
            findNode = currNode;
        }
        return lson || rson || (currNode.val == p.val || currNode.val == q.val);
    }

    //递归遍历当前节点的所有子节点，将子节点:父节点
    public void dfs2(TreeNode currNode) {
        //terminate
        //process
        if (currNode.left != null) {
            map.put(currNode.left, currNode);
            //drill down
            dfs2(currNode.left);
        }
        if (currNode.right != null) {
            map.put(currNode.right, currNode);
            dfs2(currNode.right);
        }


    }
}
