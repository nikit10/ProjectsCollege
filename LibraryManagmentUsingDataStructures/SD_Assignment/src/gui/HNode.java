package gui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Date;

class HNode {
	int key;
	String  bname;
        int id;
        Date d;
	  HNode next;

	HNode(int k, int i,String nm) throws ParseException
		{ key = k;
		  id =i;
		  bname = nm;
		  SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		  String p = sdf.format(new Date()); 
		  d = sdf.parse(p);
		  next = null;  
		  }
	public int readKey(){return key;}
	public String readBName(){return bname;}
	public int readId(){return id;}
	public Date readDate() {
		return d;
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