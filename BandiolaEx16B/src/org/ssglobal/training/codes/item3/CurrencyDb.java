package org.ssglobal.training.codes.item3;

import java.util.List;

public class CurrencyDb {
	public List<Money> getMoney() {
		String sql = "SELECT * FROM money";
		// Statement stmt = conn.createStatement();
		// ResultSet result = stmt.executeQuery(sql);
		// while(result.next()){
		// Money m = new Money();
		// m.add(result.getString("curr"));
		// m.add(result.getDouble("val"));
		// moneys.add(m);
		// }
		return null;
	}
}
