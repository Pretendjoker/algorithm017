import java.util.HashMap;

/**
 * @author Zewei Ni
 * @version :PACKAGE_NAME on 2020-10-10 16:07 Zewei Ni
 * @name BuildTree
 */
public class BuildTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 前序遍历的第一个节点，是root节点，结合中序遍历，可以将左右子树确定
        int plen = preorder.length;
        int ilen = inorder.length;
        if(plen != ilen) {
            throw new IllegalArgumentException("input data error");
        }
        //将中序遍历的每个节点，和对应的下标存储到map中，空间换时间
        HashMap<Integer, Integer> map = new HashMap<>(16);
        for (int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }
        //递归建树
        return dfs(preorder, 0, plen-1, map, 0, ilen-1);
    }

    public TreeNode dfs(int[] preorder, int pleft, int pright, HashMap<Integer, Integer> map, int ileft, int iright){
        //terminal
        if (pleft > pright || ileft > iright) {
            return null;
        }
        //process
        TreeNode root = new TreeNode(preorder[pleft]);
        int pIndex = map.get(root.val);
        //dirll down
        root.left = dfs(preorder, pleft+1, pIndex-ileft+pleft, map, ileft, pIndex-1);
        root.right= dfs(preorder, pIndex-ileft+pleft+1, pright, map, pIndex+1, iright);
        return root;
    }
}
