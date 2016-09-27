/**
 * @author Grupo 3  
 * @author Edgar Ramírez 15236
 * @author Gladis de la Roca
 * @author Robbin Woods
 * @version 26/09/2016
 * @Description: 
 */

public class Node<K,V>
{
    /**
     * The immutable key.  An arbitrary object.
     */
    protected K theKey; // the key of the key-value pair
    /**
     * The mutable value.  An arbitrary object.
     */
    protected V theValue; // the value of the key-value pair


   
    public Node(K key, V value)
    {
        
        theKey = key;
        theValue = value;
    }

    
    public Node(K key)
    {
        this(key,null);
    }

    public boolean equals(Object other)
    {
        Node otherAssoc = (Node)other;
        return getKey().equals(otherAssoc.getKey());
    }

    public int hashCode()
    {
        return getKey().hashCode();
    }
    
    
    public V getValue()
    {
        return theValue;
    }

   
    public K getKey()
    {
        return theKey;
    }

 
    public V setValue(V value)
    {
        V oldValue = theValue;
        theValue = value;
        return oldValue;
    }

    
    public String toString()
    {
        StringBuffer s = new StringBuffer();
        s.append("<Association: "+getKey()+"="+getValue()+">");
        return s.toString();
    }

}
