package com.self.learning.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;



public class BinaryTreeVerticalOrder {

    public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null)
            return result;

        // level and list
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        LinkedList<Integer> level = new LinkedList<Integer>();

        queue.offer(root);
        level.offer(0);

        int minLevel=0;
        int maxLevel=0;

        while(!queue.isEmpty()){
            TreeNode p = queue.poll();
            int l = level.poll();

            //track min and max levels
            minLevel=Math.min(minLevel, l);
            maxLevel=Math.max(maxLevel, l);

            if(map.containsKey(l)){
                map.get(l).add(p.val);
            }else{
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(p.val);
                map.put(l, list);
            }

            if(p.left!=null){
                queue.offer(p.left);
                level.offer(l-1);
            }

            if(p.right!=null){
                queue.offer(p.right);
                level.offer(l+1);
            }
        }


        for(int i=minLevel; i<=maxLevel; i++){
            if(map.containsKey(i)){
                result.add(map.get(i));
            }
        }

        return result;
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
            this.left=null;
            this.right =null;
        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.right = new TreeNode(9);
        root.right.right.left= new TreeNode(10);
        root.right.right.left.right= new TreeNode(11);
        root.right.right.left.right.right= new TreeNode(12);
        verticalOrder(root);
    }
}
