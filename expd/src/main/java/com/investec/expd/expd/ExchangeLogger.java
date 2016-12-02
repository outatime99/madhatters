/**
 * 
 */
package com.investec.expd.expd;

import java.util.Collection;
import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;

/**
 * @author gregf (stolen from Luigi, just converted for log4j)
 * 
 * TODO: Rather move this into a centralised utils project
 *
 */
public class ExchangeLogger implements Processor  {
	
	final static Logger logger = Logger.getLogger(ExchangeLogger.class);

	public void process(Exchange exchange) throws Exception {

		// if (debug == true) then do all this below
		logExchange(exchange);

		Exception exception = (Exception) exchange.getProperty(Exchange.EXCEPTION_CAUGHT);
		if (exception != null)
			exception.printStackTrace(); // print to server log file
	}
	
	private void basicLog(Exchange exchange) throws Exception {
		Map<String, ?> headers = exchange.getIn().getHeaders();
		Object body = exchange.getIn().getBody(Object.class);
		Map<String, ?> props = exchange.getProperties();
		CamelContext camelContext = exchange.getContext();
		Collection<String> att = exchange.getIn().getAttachmentNames();
		
		String logMsg = "" + "\n";
		logMsg += "=============H=E=A=D=E=R=S ======================" + "\n";
		logMsg += mapStringBuilder(headers, "header");
		logMsg += "=============P=R=O=P=S==========================" + "\n";
		logMsg += mapStringBuilder(props, "prop");
		logMsg += "=============B=O=D=Y============================" + "\n";
		logMsg += body.toString() + "\n";
		logMsg += "=============C=O=N=T=E=X=T======================" + "\n";
		logMsg += camelContext.toString() + "\n";
		logMsg += "=============A=T=T=A=C=H=M=E=N=T=S==============" + "\n";
		logMsg += collectionStringBuilder(att, "attachments");
		logMsg += "================================================" + "\n";
		logger.info(logMsg);
	}
	
	private void logExchange(Exchange exchange) throws Exception {
		Map<String, ?> headers = exchange.getIn().getHeaders();
		Object body = exchange.getIn().getBody(Object.class);
		Map<String, ?> props = exchange.getProperties();
		CamelContext camelContext = exchange.getContext();
		Collection<String> att = exchange.getIn().getAttachmentNames();
		
		String logMsg = "" + "\n";
		logMsg += "=============H=E=A=D=E=R=S ======================" + "\n";
		logMsg += mapStringBuilder(headers, "header");
		logMsg += "=============P=R=O=P=S==========================" + "\n";
		logMsg += mapStringBuilder(props, "prop");
		logMsg += "=============B=O=D=Y============================" + "\n";
		logMsg += body.toString() + "\n";
		logMsg += "=============C=O=N=T=E=X=T======================" + "\n";
		logMsg += camelContext.toString() + "\n";
		logMsg += "=============A=T=T=A=C=H=M=E=N=T=S==============" + "\n";
		logMsg += collectionStringBuilder(att, "attachments");
		logMsg += "================================================" + "\n";
		logger.info(logMsg);
	}
	
	private String mapStringBuilder(Map<String, ?> m, String mapName) throws Exception {
		String logMsg = "";
		Collection<String> vals = m.keySet();
		for (String val : vals) {
			logMsg += mapName + " value: " + val + " :: " + m.get(val) + "\n";
		}
		return logMsg;
	}
	
	private String collectionStringBuilder(Collection<String> vals, String name) throws Exception {
		String logMsg = "";
		for (String val : vals) {
			logMsg += name + " values: " + val + "\n";
		}
		return logMsg;
	}	
}
