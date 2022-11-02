package 面试题.leetcode;

import 面试题.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class LC105 {

    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len1 = preorder.length;
        int len2 = inorder.length;
        if (len1 != len2) {
            throw new RuntimeException("Incorrect input data");
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len2; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = buildTree(preorder, 0, len1 - 1, map, inorder, 0, len2 - 1);
        return root;
    }

    private TreeNode buildTree(int[] preorder, int preL, int preR,
                               Map<Integer, Integer> map, int[] inorder, int inL, int inR) {

        if (preL > preR || inL > inR) {
            return null;
        }

        int rootVal = preorder[preL];
        TreeNode root = new TreeNode(rootVal);
        int pIdx = map.get(rootVal);
        root.left = buildTree(preorder, preL+1, preL+pIdx-inL, map, inorder, inL, pIdx - 1);
        root.right = buildTree(preorder, preL+pIdx-inL+1, preR, map, inorder, pIdx + 1, inR);
        return root;
    }
}
