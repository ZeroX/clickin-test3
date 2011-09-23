package clickintest3.appspot.com;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.jdo.PersistenceManager;
import javax.servlet.http.*;




@SuppressWarnings("serial")
public class ClickInTestServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		ArrayList<BankHistory> myArr = new ArrayList<BankHistory>();
		for (int i = 0; i < InputData.length(); i++){
	        BankHistory e = new BankHistory(InputData.bankName[i], InputData.rate[i], InputData.updateDate[i]);
	        myArr.add(e);
		}
		createData(myArr);

	}

	public void createData(ArrayList<BankHistory> myArr) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
        try {
        	  pm.makePersistentAll(myArr);

        } finally {
   		 	pm.close();
        }

	}
}
