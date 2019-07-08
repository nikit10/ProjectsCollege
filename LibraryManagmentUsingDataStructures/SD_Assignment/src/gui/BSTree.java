package gui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Date;


public class BSTree
{   private      Node head;
    private      Node tail;
	private static BSTree single;
	private static boolean created = false;
	public BSTree() { try {
		tail = new Node(0, -1, null, null, null);
		head = new Node(-1,  -1, null, null,  tail);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			  }

	void  insert(int k, int i,String nm) throws ParseException
		{
		    Node  p, x;
		    p = head; x = head.right;
		    while (x!=tail)
			{ 	p = x;
		  		x = (k < x.key) ? x.left : x.right;}
				x = new Node (k,i, nm, tail, tail);
				if (k < p.key) {
					p.left = x;
					System.out.println("Inserted in BST");
				}
	          		else    {       p.right = x;
	          		System.out.println("Inserted in BST");
					}
		}

	public String cost(Node x) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String p = sdf.format(new Date()); 
		Date d2 = sdf.parse(p);
	     int t = (int) ChronoUnit.DAYS.between(d2.toInstant(), x.readDate().toInstant());
	      System.out.println(t);
		if(t>0) {
			t= t-7;
			return "€"+t;
		}
		else {
			return "No fine before Time";
		}
	}
        Node   search(int k)
		{
		    Node   x= head.right;
                    tail.key=k;
                    boolean found=false;
					while (x!=tail && found==false)
						{ 	if (k==x.key) found=true;
		  					else if (k < x.key)     x= x.left ;
                                 else               x= x.right;
                        }
					if (x==tail)       return null;
	          		else               return   x;
				}
        public static BSTree getInstance() {
        	if(!created) {
        		single = new BSTree();
        	}
			return single;
        	
        }
        
		}