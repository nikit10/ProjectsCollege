package gui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Date;

interface HtabIterator{
	boolean hasNext();
	Object next();
}
interface Container{
	HtabIterator interator();
}
class HashTable implements Container, HtabIterator{
	
		public static HashTable single;
		public static boolean created = false;
		private int index;
		
	    public int hash(int id){ return id%20;}
	
        private HNode[] head=new HNode[20];
        
	    public  HashTable(){for(int i=0;i<20;i++)head[i]=null;}

		public  void insert(int k,int i, String nm) throws ParseException
	        {      HNode temp =new HNode(k,i,nm);
	               int index=hash(k);
	               temp.next=head[index];
			       head[index]=temp;
	          		System.out.println("Inserted in Hash Table");

	        }

		public String cost(HNode x) throws ParseException {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
			String p = sdf.format(new Date()); 
			Date d2 = sdf.parse(p);
		     int t = (int) ChronoUnit.DAYS.between(d2.toInstant(), x.d.toInstant());
		      System.out.println(t);
			if(t>0) {
				t= t-7;
				return "€"+t;
			}
			else {
				return "No fine before Time";
			}
		}
		public  HNode search(int k)
	        {     
			int index=hash(k);
			HNode temp=head[index];	 
			boolean found=false;
			while(temp!=null&&found==false) {
				   if (temp.key==k){found=true; break;}
	               temp=temp.next;
	        }
            return temp;}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return index<head.length;
		}

		@Override
		public Object next() {
			// TODO Auto-generated method stub
			HNode res = head[index++];
			return res;
		}

		@Override
		public HtabIterator interator() {
			// TODO Auto-generated method stub
			return new HashTable();
		}
		
		public static HashTable getInstance() {
			if(!created) {
				single = new HashTable();
			}
			return single;
		}

   }


   