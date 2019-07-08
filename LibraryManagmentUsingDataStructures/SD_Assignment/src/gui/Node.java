package gui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Node {
	int key;
	int id;
	String bname;
	Date d;
	Node left,right;
	Node(int k, int i, String book, Node l, Node r) throws ParseException{
		key = k;
		id = i;
		bname = book;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String p = sdf.format(new Date()); 
		d = sdf.parse(p);
		
		left = l;
		right = r;
	}
	public int readKey() {
		return key;
	}
	public int readId() {
		return id;
	}
	public String readBName() {
		return bname;		
	}
	public Date readDate() {
		return d;
	}
	public void print() {
		System.out.println("ID:"+id+"\nkey:"+key+"\nBname and date" + bname + d.toString());
	}
	public String cost() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String p = sdf.format(new Date()); 
		Date d2 = sdf.parse(p);
	     int t = (int) ChronoUnit.DAYS.between(d2.toInstant(), d.toInstant());
	      System.out.println(t);
		if(t>7) {
			t= t-7;
			return "€"+t;
		}
		else {
			return "No fine before Time";
		}
	}
	
}
