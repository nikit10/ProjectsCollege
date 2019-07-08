import java.util.Date;

public class LinkList {

	private Park head;
	private Date d;
	public  LinkList(){head=null;}

	public  void insert(String c,String cn,Date d)
        {      Park temp =new Park(c,cn,d);
		       temp.next=head;
		       head=temp;}
   

	public String search(int n) {
		Park temp = head;
		int p=0;
		while(temp!=null) {
			p = temp.p();
			if(n == p) {
				temp.print();
			String c = temp.details();
			return c;
			}
			temp=temp.next;
		}
			return null;
	}
	public String searchcn(int n) {
		Park temp = head;
		int p = 0;
		while(temp!=null) {
			p = temp.p();
			if(n==p) {
			String c = temp.carNumber();
			return c;
			}
			temp=temp.next;
		}
		
			System.out.println("No Car is parked in that area.");
			return null;
	}
	
	public String dat(int n) {
		Park temp = head;
		int p = 0;
		while(temp!=null) {
			p = temp.p();
			if(n==p) {
			String c = temp.d();
			return c;
			}
			temp=temp.next;
		}
		return null;
	}
	public void delete_all()
       {         head=null;
           }

	public String cost(int n) {
		Park temp = head;
		int p = 0;
		while(temp!=null) {
			p = temp.p();
			if(n==p) {
				Date d = new Date();
			String c = temp.cost(d,temp.pd);
			//delete(n);
			return c;
			}
			temp=temp.next;
		}
		return "No Car Found in this slot";
	}
     private void delete(int n) {
   

	}

	public void printlist()
                        {
	               Park temp=head;
	               System.out.println("\nList:");
	               System.out.print("HEAD->");
		           while(temp!=null) {
		               temp.print();
		               temp=temp.next;}
		               
		            System.out.print("NULL");   
		               
		            }
}
