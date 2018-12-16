

public class LinkedList<T> {

  private LinkedListNode<T> first;
  private LinkedListNode<T> last;

  public LinkedList() {
    first = null;
    last = null;
  }

  //Adds element on to the back of the list
  public void add(T new_element) {
    LinkedListNode<T> new_node = new LinkedListNode<T>(new_element);

    // Check if list is empty
    if(last == null) {
      first = new_node;
      last = new_node;
    }
    // List is not empty
    else{
      last.setNeighbor(new_node);
      last = new_node;
    }
  }

  //Adds element to the front of the list
  public void addFirst(T firstElement){
	  LinkedListNode<T> newFirst = new LinkedListNode<T>(firstElement);

	  //Check if list is empty
	  if(first == null){
		  first = newFirst;
		  last = newFirst;
	  }
	  //If list is not empty
	  else{
		  newFirst.setNeighbor(first);
		  first = newFirst;
	  }
  }

  //Checks to see if list contains a specified element
  public boolean checkFor(T targetElement){
	  LinkedListNode<T> currentNode = first;
	  LinkedListNode<T> targetNode = new LinkedListNode<T>(targetElement);
	  int listLength = size();
	  boolean contains = false;
	  while(listLength>0){
		  if(currentNode.getElement() == targetNode.getElement()){
			  contains = true;
			  listLength = 0;
		  }
		  else{
			  currentNode = currentNode.getNeighbor();
			  listLength--;
		  }
	  }
	  return contains;
  }

  //Adds element after a certain element in the list
  public void addAfter(T leftElement, T newElement){
	  LinkedListNode<T> currentNode = first;
	  LinkedListNode<T> newNode = new LinkedListNode<T>(newElement);
	  int length = size();
	  while(length>0){
		  if(currentNode.getElement() == leftElement){
			  newNode.setNeighbor(currentNode.getNeighbor());
			  currentNode.setNeighbor(newNode);
			  length = 0;
		  }
		  else{
		  	currentNode = currentNode.getNeighbor();
		  	length--;
		  }
	  }
  }

  //Inserts a new element at a certain position
  public void insert(T newElement, int position){
	  LinkedListNode<T> node1 = first;
	  LinkedListNode<T> newNode = new LinkedListNode<T>(newElement);
	  int currentPosition = 1;
	  int length = size();
	  while(length>0){
		  if(currentPosition == position){
			  newNode.setNeighbor(node1.getNeighbor());
			  node1.setNeighbor(newNode);
			  length = 0;
		  }
		  else{
			  node1 = node1.getNeighbor();
			  currentPosition++;
			  length--;
		  }
	  }
  }

  //Removes first element
  public void removeFirst(){
	  if(first!=null){
		  first = first.getNeighbor();
	  }
  }

  //Removes last element
  public void removeLast(){
	  LinkedListNode<T> currentNode = first;
	  int length = size();
	  while(length>0){
		  if(currentNode.getNeighbor() == last){
			  last = currentNode;
			  currentNode.setNeighbor(null);
			  length = 0;
		  }
		  else{
			  currentNode = currentNode.getNeighbor();
			  length--;
		  }
	  }
  }

  //Removes a specified element
  public void remove(T element){
	  LinkedListNode<T> currentNode = first;
	  int length = size();
	  LinkedListNode<T> nextNeighbor;
	  while(length>0){
		  nextNeighbor = currentNode.getNeighbor().getNeighbor();
		  if(currentNode.getNeighbor().getElement()==element){
			  currentNode.setNeighbor(nextNeighbor);
			  length = 0;
		  }
		  else{
			  currentNode = currentNode.getNeighbor();
			  length--;
		  }
	  }
  }

  //Returns first element
  public LinkedListNode getFirst(){
	  return first;
  }

  //Returns last element
  public LinkedListNode getLast(){
	  return last;
  }

  //Outputs list
  public void printList() {
    LinkedListNode<T> current_node = first;
    while (current_node != null) {
      System.out.println(current_node);
      current_node = current_node.getNeighbor();
    }
  }

  //Returns list length
  public int size() {
    LinkedListNode<T> current_node = first;
    int count = 0;
    while (current_node != null) {
      count++;
      current_node = current_node.getNeighbor();
    }
    return count;
  }

  //Checks if list is empty
  public boolean isEmpty(){
	  if(first == null){
		  return true;
	  }
	  else{
		  return false;
	  }
  }


  public static void main(String[] args) {

    LinkedList<String> names = new LinkedList<String>();
    names.add("Matthew");
    names.add("Jon");
    names.add("Tracy");
    names.addFirst("Owen");
    names.addAfter("Owen", "Alden");
    names.insert("Bob", 1);
    names.printList();
    System.out.println("");
    if(names.isEmpty()){
    	System.out.println("Empty");
    }
    else{
    	System.out.println("Not empty");
    }

    System.out.println("Size is : " + names.size());
    System.out.println(names.getFirst());
    System.out.println(names.getLast());
    System.out.println("");
    names.remove("Alden");
    names.removeFirst();
    names.removeLast();
    names.printList();
    System.out.println("");
    if(names.checkFor("Matthew")){
    	System.out.println("The list contains Matthew");
    }
    if(names.checkFor("trump")){
    	System.out.println("The list contains Trump");
    }
    else{
    	System.out.println("The list does not contain trump");
    }

  }

}
