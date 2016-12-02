/**
 * 
 */
package com.investec.expd.ejb;

import java.util.ArrayList;

import javax.ejb.Local;

import com.investec.expd.model.Widget;

/**
 * @author gregf
 *
 *
 */
@Local
public interface WidgetService {
	public long getCount() throws Exception;
	public Widget createWidget(Widget widget) throws Exception;
	public ArrayList<Widget> getAllWidgets() throws Exception;
	public Widget getWidget(int widgetId) throws Exception;
	public Widget updateWidget (Widget widget) throws Exception;
	public void deleteWidget (Widget widget) throws Exception;
}
