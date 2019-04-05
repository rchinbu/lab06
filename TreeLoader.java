/**
 * Load a tree from a text file.  Format is line based, with each line
 * consisting of a String for data, followed by two ints indicating if
 * the node has a left child or right child.  (1 is yes, 0 is no).
 * Ordering of nodes is postorder.
 *
 * @author John Donaldson
 * @author Benjamin Kuperman (Spring 2007)
 * @author Alexa Sharp (Fall 2012)
 */
import java.util.Stack;
import java.io.*;
import java.util.*;

public class TreeLoader {

    BinaryTree<String> loadTreeFromFile(String fname) throws IOException
    {
        // TODO: See Part 2
    	Stack<BinaryTree<Integer>> stringTrees = new Stack<BinaryTree<Integer>>();
    	Scanner s = new Scanner(new File(fname));
    	int data;
    	int leftYesNo;
    	int rightYesNo;
    	BinaryTree<Integer> left;
    	BinaryTree<Integer> right;
    	while(s.hasNextInt()) {
    		data = s.nextInt();
    		rightYesNo = s.nextInt();
    		if (rightYesNo == 1) {
    			right = stringTrees.pop();
    		} else {
    			right = new EmptyTree<Integer>();
    		}
    		leftYesNo = s.nextInt();
    		if (leftYesNo == 1) {
    			left = stringTrees.pop();
    		} else {
    			left = new EmptyTree<Integer>();
    		}
    		stringTrees.push(new ConsTree<Integer>(data, left, right));
    	}
        return new EmptyTree<String>();
    }

    // So you can test your tree loader
    
    public static void main(String[] args) throws IOException {
        if(args.length!=1){
            System.out.println("Usage:  java TreeLoader filename");
        }
        else {
            TreeLoader tl = new TreeLoader();
            BinaryTree<String> t = tl.loadTreeFromFile(args[0]);	
            System.out.println(t);
        }
    }
}
