package edu.iut.gui.widget.agenda;
import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * La classe EventPanel.
 */
public class EventPanel extends JPanel {
	
	/** The active view. */
	protected AgendaPanelFactory.ActiveView activeView;
	
	/**
	 * Crée un nouvelle eventpanel.
	 *
	 * @param activeView une vue active
	 */
	public EventPanel(AgendaPanelFactory.ActiveView activeView) {
		this.activeView = activeView;
	}

}
