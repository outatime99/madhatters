/**
 * 
 */
package com.investec.expd.ejb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.investec.expd.model.Widget;

/**
 * @author gregf
 *
 */
@Stateless
@Local(WidgetService.class)
public class WidgetServiceEJB implements WidgetService {

	@PersistenceContext
	private EntityManager em;
	
	final static Logger logger = Logger.getLogger(WidgetServiceEJB.class);
	
	/**
	 * To simulate DB interaction, I'm simply using a static ArrayList
	 */
	private static ArrayList<Widget> widgetList = new ArrayList<Widget>();

	/* (non-Javadoc)
	 * @see com.investec.expd.ejb.WidgetService#getCount()
	 */
	@Override
	public long getCount() throws Exception {
		logger.debug("EJB Invoked :: Method : getCount");
		
		Query query = em.createQuery("SELECT count(w) from Widget w");	
		long count = (long)query.getSingleResult();
		logger.debug("Counted: " + count);
		
		return count;
	}

	/* (non-Javadoc)
	 * @see com.investec.expd.ejb.WidgetService#getAllWidgets()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Widget> getAllWidgets() throws Exception {
		logger.debug("EJB Invoked :: Method : getAllWidgets");
		
		Query query = em.createQuery("SELECT w from Widget w");	
		ArrayList<Widget> widgetList = new ArrayList<Widget>(query.getResultList());
		logger.debug("ArrayList of widgets created. " + widgetList.toString());

		return widgetList;
	}

	/* (non-Javadoc)
	 * @see com.investec.expd.ejb.WidgetService#getWidget(java.lang.String)
	 */
	@Override
	public Widget getWidget(int widgetId) throws Exception {
		logger.debug("EJB Invoked :: Method : getWidget");

		Widget existing = em.find(Widget.class, widgetId);
		
		return existing;
	}

	@Override
	public Widget createWidget(Widget widget) throws Exception {
		logger.debug("EJB Invoked :: Method : createWidget");	
		boolean alreadyInDb = false;
		
		// First check if widget already exists. If it does throw an exception
		// without event trying to persist the entity.
		// TODO: I'm not sure if this is the most efficient way to handle 
		// Uniqueness
		Widget existing = em.find(Widget.class, widget.getWidgetId());
		if (existing != null) {
			alreadyInDb = true;
			logger.debug("Existing widget found in DB for id: <" + widget.getWidgetId() + ">");		
		} else	{
			// Also try finding on the name
			Query query = em.createQuery("SELECT w from Widget w WHERE w.widgetName = '"+ widget.getWidgetName() +"'");
			if (query.getResultList().size() > 0) {
				alreadyInDb = true;
				logger.debug("Existing widget found in DB for name: <" + widget.getWidgetName() + ">");			
			}
		}			
		
		if (alreadyInDb) {
			logger.debug("Uniqueness Constraint Violation. Cannot create widget. It already exists");
			throw new Exception("Uniqueness Constraint Violation");
		} else {
			logger.debug("No existing widget found in DB. Creating");
			Widget newWidget = new Widget();
			newWidget.setWidgetName(widget.getWidgetName());
			newWidget.setIsActive(widget.getIsActive());
			
	        // Setting the changed time to now
	        Date now = new Date();
	        newWidget.setChangedTime(now);
			
			em.persist(newWidget);
			
			logger.debug("Widget Sucessfully created: " + newWidget.toString());		
			return newWidget;		
		}
	}
	
	/* (non-Javadoc)
	 * @see com.investec.expd.ejb.WidgetService#updateWidget(com.investec.expd.model.Widget)
	 */
	@Override
	public Widget updateWidget(Widget widget) throws Exception {
		logger.debug("EJB Invoked :: Method : updateWidget");
		boolean alreadyInDb = false;
		
		// First check if widget already exists. 
		Widget existing = em.find(Widget.class, widget.getWidgetId());
		if (existing != null) {
			alreadyInDb = true;
			logger.debug("Existing widget found in DB for id: <" + widget.getWidgetId() + ">");		
		} 		
		
		if (!alreadyInDb) {
			logger.debug("Cannot update widget, it doesn't exist yet.");
			throw new Exception("Cannot update non-existent widget");
		} else {
	        // Setting the changed time to now
	        Date now = new Date();

			existing.setIsActive(widget.getIsActive());
			existing.setWidgetName(widget.getWidgetName());
			existing.setChangedTime(now);
			
			em.persist(existing);
		}
		
		return existing;
	}
	
	/* (non-Javadoc)
	 * @see com.investec.expd.ejb.WidgetService#deleteWidget(com.investec.expd.model.Widget)
	 */
	@Override
	public void deleteWidget(Widget widget) throws Exception {
		logger.debug("EJB Invoked :: Method : deleteWidget");
		boolean alreadyInDb = false;
		
		// First check if widget already exists. 
		Widget existing = em.find(Widget.class, widget.getWidgetId());
		if (existing != null) {
			alreadyInDb = true;
			logger.debug("Existing widget found in DB for id: <" + widget.getWidgetId() + ">");		
		} 		
		
		if (!alreadyInDb) {
			logger.debug("Cannot delete widget, it doesn't exist yet.");
			throw new Exception("Cannot delete non-existent widget");
		} else {
			em.remove(existing);
		}
	}	
}
