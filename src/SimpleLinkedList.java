import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node
{
Node next;
int data;
}
//this is change test
class Operations
{
static int count=0;	
public Node insertBack(Node head, int num) 
	{
		if(head == null)
		{
		Node newnode=new Node();
		newnode.data=num;
		newnode.next=null;
		head=newnode;
		Operations.count= Operations.count+ 1;
		System.out.println("Number of node in the List are :"+Operations.count);
		System.out.println("List is Empty. New List created");
		System.out.println("Element "+num+" Added to the list");
		}
		else
		{
			Node current=head;
			while(current.next!=null)
			{
				current=current.next;
			}
			Node newnode=new Node();
			newnode.data=num;
			newnode.next=null;
			current.next=newnode;
			System.out.println("Element "+num+" Added to the list");
			Operations.count= Operations.count+ 1;
			System.out.println("Number of node in the List are :"+Operations.count);
		}
		
		Display(head);
		
		return head;
	}

	public Node insertFront(Node head, int num) 
	{
		Node newnode=new Node();
		newnode.data=num;
		newnode.next=head;
		head=newnode;
		Operations.count= Operations.count+ 1;
		System.out.println("Number of node in the List are :"+Operations.count);
		System.out.println("List is :");
		Display(head);
		return head;
	}
	
	public void Display(Node head) 
	{
		Node current=head;
		System.out.print("List is :");
		while(current!=null)
		{
			System.out.print(current.data+"->");
			current=current.next;
		}
		System.out.print("null\n");
		
	}

	public Node removeElement(Node head, int num) 
	{
	boolean flag=false;
	Node current=head;
	Node prev=head;
	if(head==null)
	{
	flag=false;	
	}
	else if(current.data==num)
	{
		head=current.next;
		prev=head;
		current=head;
		flag=true;
	}
	else
		{
		current=current.next;
		while(current!=null)
		{
			if(current.data==num)
			{
				prev.next=current.next;
				flag=true;
			}
			prev=prev.next;
			current=current.next;
			
		} // end of while
		
	}
	
	if(!flag)
	System.out.println("No Such Element in the list");
	Operations.count= Operations.count+ 1;
	System.out.println("Number of node in the List are :"+Operations.count);Display(head);
	return head;
	} // end of function

	public Node removeHead(Node head) 
	{
		if(head==null)
		{
		System.out.println("Empty List");	
		}
		else
		{
		head=head.next;
		Operations.count= Operations.count+ 1;
		System.out.println("Number of node in the List are :"+Operations.count);}
		Display(head);
		return head;
	}

	public Node removeTail(Node head) 
	{
		Node current,prev;
		current=head;
		prev=head;
		if(current.next==null)
		{
			head=current.next;
			Operations.count= Operations.count+ 1;
			System.out.println("Number of node in the List are :"+Operations.count);
		}
		else
		{
		while(current.next!=null)
		{
			prev=current;
			current=current.next;
		}
		prev.next=null;
		Operations.count= Operations.count+ 1;
		System.out.println("Number of node in the List are :"+Operations.count);
		}
		return head;
	}

	
	public int findNth(Node head, int num) {
		int n=1,element = 0;
		if((Operations.count < num) || (num<0))
		{
			System.out.println("No such Position exists!!! ");
		}
		else
		{
			Node current=head;
			while(current!=null)
			{
				if(num==n)
				{	element=current.data;
					break;
				}
				n++;
				current=current.next;
			}
			
		}
		return element;
	}

	public List<Integer> displayNthToEnd(Node head, int num) 
	{
		int n=1;
		List<Integer> list=new ArrayList<Integer>();
		//list=null;
		if(Operations.count < num || (num<0))
 		{
			System.out.println("No such position exists!!"); 
		}
		else
		{
			Node current=head;
			while(current!=null)
			{
				System.out.println("Current element is  "+current.data+" positiion is "+n);
				if(num<=n)
				{
					list.add(current.data);
				}
				n++;
				current=current.next;
			}
			
		}
		return list;
	}

	public List<Integer> displayMthToNth(Node head, int num1, int num2) {
		int n=1;
		List<Integer> list=new ArrayList<Integer>();
		//list=null;
		if(Operations.count < num1 || Operations.count < num2)
		{
			System.out.println("No such position exists!!"); 
		}
		else if(num2<num1 || (num1<0) || (num2<0))
		{
		System.out.print("Invalid Range");	
		}
		else
		{
			Node current=head;
			while(current!=null)
			{
				System.out.println("Current element is  "+current.data+" positiion is "+n);
				if(n>=num1 && n<=num2)
				{
					list.add(current.data);
				}
				if(n>num2)
					break;
				n++;
				current=current.next;
			}
			
		}
		return list;

	}

	
}


public class SimpleLinkedList 
{
public static void main(String args[])
{
	Node head = null;
	int n,num;
	Scanner sc=new Scanner(System.in);
	List<Integer> elements= new ArrayList<Integer>();
	Operations op= new Operations();
String s;
do
{
	System.out.println("1.Add elements \n2.Remove elements\n3.Find elements");
	n=sc.nextInt();
	switch(n)
	{
	case 1:
		System.out.println("1.Insert at the back\n2.Insert in the front");
		n=sc.nextInt();
		System.out.println("Enter element to Enter");
		num=sc.nextInt();
		switch(n)
		{
		case 1:
		head=op.insertBack(head,num);
		break;
		case 2:
			head=op.insertFront(head,num);
			break;
		default: System.out.println("Wrong choice");
		}
		break;
	case 2:
		op.Display(head);
		System.out.println("1.Remove Head\n2.Remove Tail\n3.Remove a element");
		n=sc.nextInt();
		switch(n)
		{
		case 1:
		head=op.removeHead(head);
		break;
		case 2:
		head=op.removeTail(head);
		break;
		case 3:
		System.out.println("Enter element to Enter");
		num=sc.nextInt();
		head=op.removeElement(head,num);
		break;
		default: System.out.println("Wrong choice");
		}
		break;
		case 3:
			System.out.println("1.Find Nth Element\n2.Display all from Nth position\n3.Elements between Mth and Nth position");
			n=sc.nextInt();
			switch(n)
			{
			case 1:
			System.out.println("Enter Position");
			num=sc.nextInt();
			int element=op.findNth(head,num);
			if(element!=0)
			System.out.println("Element is "+element);
			break;
			case 2:
			System.out.println("Enter Position");
			num=sc.nextInt();
			elements=op.displayNthToEnd(head,num);
			DisplayList(elements);
			break;
			case 3:
			System.out.println("Enter Range");
			int num1=sc.nextInt();
			int num2=sc.nextInt();
			elements=op.displayMthToNth(head,num1,num2);
			DisplayList(elements);
			break;
			default: System.out.println("Wrong choice");
			}	
			break;
		default:
			System.out.println("WRONG INPUT \n");
	
	}
	
	System.out.println("Do you want to Continue Y/N ?");
	s=sc.next();
	
}
while(!s.equalsIgnoreCase("N"));
sc.close();
}

private static void DisplayList(List<Integer> elements) 
{
	if(elements==null)
	{
		System.out.println("List is Empty");
	}
	else
	{
		for(int i=0;i<elements.size();i++)
			System.out.print(elements.get(i)+",");
		System.out.println("");
	}
	
}
}
