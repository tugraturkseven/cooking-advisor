package cookingadvisor;

import java.util.ArrayList;


public class Tree {
	
private TreeNode root;

public Tree(TreeNode root) {
	this.root = root;
}

public boolean isEmpty() {
	return root==null;
}

public void addNode(TreeNode node) {
	
	if(!isEmpty()) { // if tree is not empty
		int key = node.getKey();
		int currentKey;
		
		TreeNode parent = null;
		TreeNode current = root;
		
		while(current!=null) {
			currentKey = current.getKey();
			if(key>currentKey) {
				parent = current;
				current = current.getRight();
			}
			if(key<currentKey) {
				parent = current;
				current = current.getLeft();
			}
			if(key==currentKey) {
				parent = current;
				current = current.getRight();
			}
		}
		
		currentKey = parent.getKey();
		if(key>currentKey)
			parent.setRight(node);
		if(key<currentKey)
			parent.setLeft(node);
		if(key==currentKey)
			parent.setRight(node);
		
	}else // if tree is empty
		root = node;
}

public void inOrder(TreeNode node) {
	ArrayList<Food> foodList = new ArrayList<Food>();
	if(isEmpty())
		System.out.println("Tree is empty.");
	else {
		if(node==null)
			return;
		
		inOrder(node.getLeft());
		
		System.out.println(node.getFood().getName() + " " + node.getKey());
		foodList.add(node.getFood());
		
		System.out.println("size of foodList:" + foodList.size());
		inOrder(node.getRight());
		
		
	}
	
}
public void giveAdvice(ArrayList<String> materials) {
	inOrder(root);
	ArrayList<Food> listOfFoods = new ArrayList<Food>(); //creating an ArrayList to keep matching foods.
	int key = materials.size(); // Since we are looking for material numbers, we should keep it.
	int currentKey;
	
	
	for (int i = 0; i < listOfFoods.size(); i++) {
		currentKey = listOfFoods.get(i).getNumOfMaterials();
		if(currentKey>key)
			listOfFoods.remove(i);
	}
	
	
	
	/*
	while(current!=null) {
		currentKey = current.getKey();
		if(currentKey==key) { // if the number of materials match, add that food the the collection.
			matches.add(current.getFood());
			current = current.getRight();
		}
			
		if(key>currentKey)
			current = current.getRight();
		if(key<currentKey)
			current = current.getLeft();
	}
	*/
	
	int count = 0;
	
	
	for (int i = 0; i < listOfFoods.size(); i++) {
		boolean doesContain = materials.containsAll(listOfFoods.get(i).getMaterials()); //checks given materials match with any recipe materials
		System.out.println("Materials:" + materials.toString());
		System.out.println("Current food's materials: "+ listOfFoods.get(i).getMaterials());
		System.out.println("Does contain:" + doesContain);
		/*
		if(doesContain) {
			System.out.println("Matching recipe:\n" + listOfFoods.get(i).getName()+"\n"+listOfFoods.get(i).getRecipe()); // if it matches, print the name of the food and recipe
			count++;
		}
			*/
	}
	/*
	if(count==0)
		System.out.println("No matching recipe, sorry. :(");
		*/
}
}
