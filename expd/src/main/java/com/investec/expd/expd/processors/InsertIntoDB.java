package com.investec.expd.expd.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class InsertIntoDB implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {

		
		String sqlInsert = "" + 
		"INSERT INTO TEMP "
		+ "(id, name, description)" 
		+ "VALUES(1, 'hello', 'luigi')";
		
		//System.out.println(" >>  train sql insert: " +  sqlInsert);
		exchange.getIn().setBody(sqlInsert);
		

	}

}
