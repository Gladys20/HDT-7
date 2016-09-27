/**
 * @author Grupo 3  
 * @author Edgar Ramírez 15236
 * @author Gladis de la Roca
 * @author Robbin Woods
 * @version 26/09/2016
 * @Description: 
 */

//Codigo tomado del libro
public class Binarytree<E>
{
    protected E val; // value associated with node
    protected Binarytree<E> parent; // parent of node
    protected Binarytree<E> left, right; // children of node
    
    public Binarytree(E value, Binarytree<E> left, Binarytree<E> right, Binarytree<E> parent){
        val=value;
        this.left=left;
        this.right=right;
        this.parent=parent;
    }
    
    public Binarytree<E> left()
    // post: returns reference to (possibly empty) left subtree
    // post: returns reference to (possibly empty) left subtree
    {
            return left;
    }

    public Binarytree<E> right()
    // post: returns reference to (possibly empty) left subtree
    // post: returns reference to (possibly empty) left subtree
    {
            return right;
    }

    public Binarytree<E> parent()
    // post: returns reference to parent node, or null
    {
        return parent;
    }
    
    public void setLeft(Binarytree<E> newLeft){
        this.left=newLeft;
    }
    
    public void setRight(Binarytree<E> newRight){
        this.right=newRight;
    }
    
    public void setParent(Binarytree<E> newParent){
        this.left=newParent;
    }
    
    public E value()
	// post: returns value associated with this node
	{
		return val;
	}
	
	public void setValue(E value)
	// post: sets the value associated with this node
	{
		val = value;
	}
    
}


