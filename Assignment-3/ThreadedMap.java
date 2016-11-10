public class ThreadedMap
{
	private MapNode root;//first node used to find the rest in the tree

	public ThreadedMap()
	{
		this.root = null;
	}//constructor for ThreadedMap


	public String get(Integer key)
	{
		return get(key,this.root);
	}//get

	private String get(Integer key, MapNode node)
	{
		if(node.key == key)
		{
			return node.value;
		}
		else if(key < node.key && node.left!=null)
		{
			return get(key, node.left);
		}
		else if(key > node.key && node.right!=null)
		{
			return get(key, node.right);
		}
		return "Key wasn't found";
	}

	public String put(Integer key, String value)
	{
		if(this.root == null)
		{
			//System.out.println("Adding with null root");
			this.root = new MapNode(key,value);
			return null;
		}
		else
		{
			return put(key,value,this.root);
		}
	}

	private String put(Integer key, String value, MapNode root)
	{
		String oldValue;
		if(root == null)
		{
			//System.out.println("Adding with null root");
			//setting the node's right
			root = new MapNode(key,value);
			return null;
		}
		else if(key == root.key)
		{
			System.out.println("Replacing with new value");
			oldValue = root.value;
			root.value = value;
			return oldValue;
		}
		else if(key < root.key)
		{
			if(root.left == null)
			{
				//System.out.println("Adding child to left");
				root.left = new MapNode(key,value,root);
				return null;
			}//left child is null
			else
			{
				//System.out.println("Going left");
				return put(key,value,root.left);
			}
		}//going left
		else if(key > root.key)
		{

			if(root.right == null)
			{
				root.right = new MapNode(key,value);
				return null;
			}
			else if(root.flag == true)
			{
				root.flag = false;
				root.right = new MapNode(key,value,root.right);
			}
			else
			{
				return put(key,value,root.right);
			}
		}//going right
		return null;
	}//put




	public String inOrderTrav()
	{
		String result = "";
		MapNode currentNode = findLeftMostChild(this.root);
		while(currentNode != null)
		{
			System.out.println(currentNode.value);
			result = result +" "+currentNode.value;
			if(currentNode.flag == true)
			{
				currentNode = currentNode.right;
			}
			else if(currentNode.left == null && currentNode.right == null)
			{
				return result;
			}
			else
			{
				currentNode = findLeftMostChild(currentNode.right);
			}

		}
		return result;

	}//inOrderTrav


	private MapNode findLeftMostChild(MapNode node)
	{
		if(node.left != null)
		{
			return findLeftMostChild(node.left);
		}
		else
		{
			return node;
		}
	}//findLeftMostChild




	public String prettyStr()
	{
		if(this.root == null)
		{
			return "Map is empty";
		}
		else
		{
			return prettyStr(this.root);
		}
	}//prettyStr

	private String prettyStr(MapNode node)
	{
		String result = "\n";
		String left="";
		String right="";

		result = result + "\nKey is : "+node.key+"\nValue is : "+node.value+"\nFlag is : "+node.flag;

		if(node.left != null)
		{
			result = result + "\nLeft child's key is : "+node.left.key;
			left = prettyStr(node.left);
		}
		if(node.right != null && node.flag == false)
		{
			result = result + "\nRight child's key is : "+node.right.key;
			right  = prettyStr(node.right);
		}

		result = result + left + right;

		return result;

	}

//------MapNode class-----

	private static class MapNode
	{
		private MapNode right;//right child, can be normal child, or threaded child
		private MapNode left;//left child
		private Integer key;//value to find value with
		private String  value;//data to find
		private boolean flag;//tells whether or not right child is regular child

		private MapNode(Integer key, String value)
		{
			this.key   = key;
			this.value = value;

			this.right = null;
			this.left  = null;
			this.flag  = false;

		}//constructor for MapNode

		private MapNode(Integer key, String value, MapNode rightNode)
		{
			this.key   = key;
			this.value = value;

			this.right = rightNode;
			this.left  = null;
			this.flag  = true;

		}//used to create node with special right child

	}//class MapNode

}//class ThreadedMap