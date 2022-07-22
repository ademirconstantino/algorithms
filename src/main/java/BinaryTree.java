import java.util.Queue;
import java.util.LinkedList;

public class BinaryTree {

   private Node root;
   
   public void add(int value) {
      if(root == null) {
         root = new Node(value);
      } else {
         Node newNode = findApropriate(root, value);
         
         if(value > newNode.value) {
            newNode.right = new Node(value);
         } else {
            newNode.left = new Node(value);
         }
         
         System.out.println("Apropriate note to insert: " +
                            newNode.value);
      }
   }
   
   private Node findApropriate(Node node, int value) {

      if(value == node.value) {
         throw new RuntimeException("Value already exists!");
      }

      if(node.left == null && node.right == null) {
         return node;
      }

      if(value < node.value) {
         if(node.left != null) {
            return findApropriate(node.left, value);
         } else {
            return node;
         }
      }
      
      if(value > node.value) {
         if(node.right != null) {
            return findApropriate(node.right, value);
         } else {
            return node;
         }
      }
            
      return null;
   }

   public boolean contains(int value) {
      return contains(root, value);
   }
   
   private boolean contains(Node node, int value) {
   
      if(node == null) {
         return false;
      }
      
      if(value == node.value)
         return true;
      
      if (node.left != null && contains(node.left, value))
         return true;
      
      if(node.right != null && contains(node.right, value))
         return true;
      
      return false;
   }
   
   public void delete(int value) {
      this.root = delete(root, value);
   }
   
   public Node delete(Node node, int value) {
   
      if(node == null)
         return null;
            
      if(value == node.value) {
         // has no children
         if(node.left == null && node.right == null) {
            Node parent = findParent(root, value);
            if(parent.left.value == value)
               parent.left = null;
            if(parent.right.value == value)
               parent.right = null;
            return parent;
         }
         
         // one children
         if(node.left != null && node.right == null)
            return node.left;
         
         // one children
         if(node.right != null && node.left == null)
            return node.right;
         
         // node has two children
         if(node.right != null && node.left != null) {
            Node parent = findParent(root, value);
            if(parent == null) {
               return null;
            }
            
            if(node.left != null && parent.left != null &&
                  node.left.value < parent.left.value)
               parent.left = node.left;

            if(node.right != null && parent.right != null &&
                  node.right.value > parent.right.value)
               parent.right = node.right;
             
            System.out.println("Parent:" + parent.value);  
            System.out.println("Left:" + parent.left.value);  
            System.out.println("Right:" + parent.right.value);  
               
            return root;
         }
         
      } else {
      
         Node leftExtract = null;
         Node rightExtract = null;
      
         if(node.left != null)
            leftExtract = delete(node.left, value);
         
         if(node.right != null)
            rightExtract = delete(node.right, value);
         
         if (leftExtract != null)
            return leftExtract;
         
         if (rightExtract != null)
            return rightExtract;

      }
      
      return root;
   }
   
   public Node findParent(Node node, int value) {
   
      if(node == null) {
         return null;
      }
   
      if(node.left != null && node.left.value == value) {
         return node;
      }
      
      if(node.right != null && node.right.value == value) {
         return node;
      }
      
      if(value < node.value) {
         return findParent(node.left, value);
      } else {
         return findParent(node.right, value);
      }
      
   }
   
   public void breadthFirstSearch() {
      BreadthFirstSearch bfs = 
            new BreadthFirstSearch(root);
      System.out.println("BreadthFirstSearch.traverse()");
      bfs.traverse();
   }
   
   public void depthFirstSearch() {
      DepthFirstSearch dfs = new DepthFirstSearch(root);
      System.out.println("DepthFirstSearch.inOrder()");
      dfs.inOrder(root);
      System.out.println("DepthFirstSearch.preOrder()");
      dfs.preOrder(root);
      System.out.println("DepthFirstSearch.postOrder()");
      dfs.postOrder(root);
   }

}

class Node {

   int value;
   Node left;
   Node right;
   
   Node(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
   }

}

class BreadthFirstSearch {

   private Node root;

   public BreadthFirstSearch(Node root) {
      this.root = root;
   }
   
   public void traverse() {
      
      if(root == null) {
         return;
      }
      
      Queue<Node> nodes = new LinkedList();
      nodes.add(root);
      
      while(!nodes.isEmpty()) {
      
         Node node = nodes.remove();
         System.out.print(" " + node.value);
         
         if(node.left != null) {
            nodes.add(node.left);
         }
         
         if(node.right != null) {
            nodes.add(node.right);
         }
      
      }
      
   }

   
}

class DepthFirstSearch {

 private Node root;

   public DepthFirstSearch(Node root) {
      this.root = root;
   }
   
   public void inOrder(Node node) {
      if(node != null) {
         inOrder(node.left);
         System.out.print(" " + node.value);
         inOrder(node.right);
      }
   }
   
   public void preOrder(Node node) {
      if(node != null) {
         System.out.print(" " + node.value);
         preOrder(node.left);
         preOrder(node.right);
      }
   }
   
   public void postOrder(Node node) {
      if(node != null) {
         postOrder(node.left);
         postOrder(node.right);
         System.out.print(" " + node.value);
      }
   }

}