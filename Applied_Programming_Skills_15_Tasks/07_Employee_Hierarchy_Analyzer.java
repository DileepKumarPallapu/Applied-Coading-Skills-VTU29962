import java.util.*;
public class Employee_Hierarchy_Analyzer {
 static class Node{int data;Node left,right;Node(int d){data=d;}}
 static Node build(int[] a){if(a.length==0||a[0]==-1)return null;Node root=new Node(a[0]);Queue<Node> q=new LinkedList<>();q.offer(root);int i=1;while(i<a.length){Node c=q.poll();if(i<a.length&&a[i]!=-1){c.left=new Node(a[i]);q.offer(c.left);}i++;if(i<a.length&&a[i]!=-1){c.right=new Node(a[i]);q.offer(c.right);}i++;}return root;}
 static int height(Node r){return r==null?-1:1+Math.max(height(r.left),height(r.right));}
 static int levels(Node r){return r==null?0:1+Math.max(levels(r.left),levels(r.right));}
 public static void main(String[] args){Scanner sc=new Scanner(System.in);int n=sc.nextInt();int[] a=new int[n];for(int i=0;i<n;i++)a[i]=sc.nextInt();Node r=build(a);System.out.println("Height = "+height(r));System.out.println("Levels = "+levels(r));}
}