/**
 * 
 */
package com.investec.expd.expd.processors;

import javax.persistence.EntityManager;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;

import com.investec.expd.expd.PersistenceManager;
import com.investec.expd.expd.model.Idea;

/**
 * @author gregf (stolen from Luigi, just converted for log4j)
 * 
 * TODO: Rather move this into a centralised utils project
 *
 */
public class SearchProcessor implements Processor  {
	
	final static Logger logger = Logger.getLogger(SearchProcessor.class);

	public void process(Exchange exchange) throws Exception {

		logger.info("Searching for idea");
		
		Idea idea = new Idea();
		idea.setIdeaId(1);
		idea.setIdeaName("Name");
		idea.setIdeaDescription("Description");
		idea.setIdeaBusinessUnit("Property");
		idea.setIdeaRoi("200000.00");
		idea.setIdeaDueDate("2017-11-23");
		
		/*String result = "";
		result += "{";
		result += "    \"idea_id\": \"4\" ";
		result += "    \"idea_name\": \"An Idea\" ";
		result += "    \"idea_description\": \"A big idea\" ";
		result += "    \"idea_bu\": \"Import Solutions\" ";
		result += "    \"idea_roi\": \"400 000.00\" ";
		result += "    \"idea_duedate\": \"2017-03-31\" ";
		result += "}";*/
		
		exchange.getIn().setBody(idea);
	
	}
}
