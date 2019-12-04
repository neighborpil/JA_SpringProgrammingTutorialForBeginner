package main;

import config.DbConfig;
import dbquery.DbQuery;

public class MainForQueryTest {

	public static void main(String[] args) {
		
		DbConfig config = new DbConfig();
		DbQuery query = new DbQuery(config.dataSource());
		int count = query.count();
		System.out.println("Count: " + count);
	}
}
