package clickintest3.appspot.com;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.jdo.Query;


public class JSONservlet extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws IOException {
		int a = 0;
		List<BankHistory> results ; 
		PersistenceManager pm = PMF.get().getPersistenceManager();
		do{	
	    Query query = pm.newQuery(BankHistory.class);
	    results= (List<BankHistory>) query.execute();
	    a = results.size();
	    
		}
		while(a<InputData.length());
		pm.close();
		String subString="";
		for (int i = 0; i < InputData.length()-1;i++){
			subString=subString+ "{c:[{\"v\":" + "\""+results.get(i).getBankName() + "\"" + "},{\"v\":new Date(" + (results.get(i).getUpdateDate().getYear()+ 1900) + "," + (results.get(i).getUpdateDate().getMonth()+1) + "," + results.get(i).getUpdateDate().getDate()+",0,0,0)},{\"v\":" + results.get(i).getRate() + "}]},";
		}
		String finalJson = "google.visualization.Query.setResponse({version:'0.6', reqId:'0',status:'ok',sig:'4223609876665555431',"
							+"table: { cols:[{\"id\":\"Col2\",\"label\":\"Bank Name\",\"type\":\"string\"},{\"id\":\"Col1\",\"label\":\"Update Date\",\"type\":\"datetime\"},{\"id\":\"Col3\",\"label\":\"Rate\",\"type\":\"number\"}],"			
							+"rows:[" + subString
							+ "{c:[{\"v\":" + "\""+results.get(InputData.length()-1).getBankName() + "\"" + "},{\"v\":new Date(" + (results.get(InputData.length()-1).getUpdateDate().getYear()+ 1900) + "," + (results.get(InputData.length()-1).getUpdateDate().getMonth()+1) + "," + results.get(InputData.length()-1).getUpdateDate().getDate()+",0,0,0)},{\"v\":" + results.get(InputData.length()-1).getRate() + "}]}"							
							+"]}});";
		resp.setContentType("application/json");
		resp.getWriter().write(finalJson);
		
	}

	
}
