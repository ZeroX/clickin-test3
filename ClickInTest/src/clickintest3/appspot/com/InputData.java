package clickintest3.appspot.com;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InputData {
    private static final SimpleDateFormat dateFormat 
    = new SimpleDateFormat("dd/MM/yyyy");
    private static final Date invalidDate = new Date(0);

	public static String [] bankName = {"ANZ","ANZ","ANZ","ANZ","Bank SA","Bank SA","Bank SA","Bank SA","Commonwealth","Commonwealth","Commonwealth","Commonwealth"};
	public static Double [] rate = {5.2, 6.2, 4.3, 3.5, 4.1, 2.2, 7.7, 9.3, 3.8, 2.9, 1.7, 0.2 };
	public static Date [] updateDate = {
			    getDateFromString("02/06/2011"), 
			    getDateFromString("02/07/2011"),
			    getDateFromString("02/08/2011"),
			    getDateFromString("02/09/2011"),
			    getDateFromString("02/06/2011"),
			    getDateFromString("02/07/2011"),
			    getDateFromString("02/08/2011"),
			    getDateFromString("02/09/2011"),
			    getDateFromString("02/06/2011"),
			    getDateFromString("02/07/2011"),
			    getDateFromString("02/08/2011"),
			    getDateFromString("02/09/2011"),
			 };
	public static String[] getBankName() {
		return bankName;
	}
	public static Double[] getRate() {
		return rate;
	}
	public static Date[] getUpdateDate() {
		return updateDate;
	}
	public static int length(){
		return rate.length;
	}
	public static Date getDateFromString( String s ) {
		try {
			return dateFormat.parse( s );

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			return invalidDate;
		}
	    
	}

}
