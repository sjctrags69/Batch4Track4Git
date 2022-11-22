package org.ssglobal.training.codes;

import java.util.List;

public class CurrencyDb {
	public List<Money> getMoney() {
		@SuppressWarnings("unused")
		String sql = "SELECT * FROM money";
		//Statement stmt = conn.createStatement();
		//ResultSet result = stmt.executeQuery(sql);
		//while(result.next()){
		// Money m = new Money();
		// m.add(result.getString("curr"));
		// m.add(result.getDouble("val"));
		// moneys.add(m);
		//}
		return null;
	}
}
