import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryTreeTest {
    
     //Test addNode 
     
    @Test
    public void testAddNode() {
        System.out.println("addNode");
        Object key = null;
        Object nombre = null;
        BinaryTree instance = new BinaryTree();
        instance.addNode(key, nombre);
    }

    
     //Test inOrderTraverseTree 
     
    @Test
    public void testInOrderTraverseTree() {
        System.out.println("inOrderTraverseTree");
        Node focusNode = null;
        BinaryTree instance = new BinaryTree();
        instance.inOrderTraverseTree(focusNode);
    }

    
     //Test findNode
     
    @Test
    public void testFindNode() {
        System.out.println("findNode");
        Object key = null;
        BinaryTree instance = new BinaryTree();
        Node param = null;
        Node result = instance.findNode(key);
        assertEquals(param, result);
    }

   
    //Test of findName     
   
    @Test
    public void testFindName() {
        System.out.println("findName");
        String key = "";
        BinaryTree instance = new BinaryTree();
        String param = "";
        String result = instance.findName(key);
        assertEquals(param, result);
    }
    
}
