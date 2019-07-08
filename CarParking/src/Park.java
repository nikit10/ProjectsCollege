import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Park extends Numb{
	public Park next;
	public static int pn = 1;
	public String cn = null;
	public String c = null;
	public Date pd;
	public Park(String c, String cn, Date d) {
		// TODO Auto-generated constructor stub
		super(pn);
		pn++;
		this.c = c;
		this.cn = cn;
		this.pd = d;
	}
	public void print() {
		// TODO Auto-generated method stub
		System.out.print("[Parking no. :"+super.readnumber()+ "\n Car: "+ c +"\n Car Number: "+ cn +"]->");
		
	}
	public String details() {
		// TODO Auto-generated method stub
		return c;
	}
	public String carNumber() {
		// TODO Auto-generated method stub
		return cn;
	}
	public int p() {
		return Integer.parseInt(super.readnumber());
	}
	public String d() {	
		return pd.toString();	
	}
	public String cost(Date d1, Date d2) {
		// TODO Auto-generated method stub
		long diff = d1.getTime() - d2.getTime();  
		long mins = diff / (60 * 1000) % 60; 
		long hrs = diff / (60 * 60 * 1000);
		int cost = (int) (hrs * 3);
		if(mins>0) {
			cost = cost + 3;
		}
		return "€"+cost;
	}
}
