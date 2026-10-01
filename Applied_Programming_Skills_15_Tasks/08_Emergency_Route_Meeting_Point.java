import java.util.*;
public class Emergency_Route_Meeting_Point {
 static class Node{int data;Node left,right;Node(int d){data=d;}}
 static Node build(int[] a){if(a.length==0||a[0]==-1)return null;Node root=new Node(a[0]);Queue<Node> q=new LinkedList<>();q.offer(root);int i=1;while(i<a.length){Node c=q.poll();if(i<a.length&&a[i]!=-1){c.left=new Node(a[i]);q.offer(c.left);}i++;if(i<a.length&&a[i]!=-1){c.right=new Node(a[i]);q.offer(c.right);}i++;}return root;}
 static Node lca(Node r,int a,int b){if(r==null||r.data==a||r.data==b)return r;Node l=lca(r.left,a,b),x=lca(r.right,a,b);if(l!=null&&x!=null)return r;return l!=null?l:x;}
 public static void main(String[] args){Scanner sc=new Scanner(System.in);int n=sc.nextInt();int[] a=new int[n];for(int i=0;i<n;i++)a[i]=sc.nextInt();int x=sc.nextInt(),y=sc.nextInt();System.out.println("LCA = "+lca(build(a),x,y).data);}
}