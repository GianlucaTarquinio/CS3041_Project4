package application;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import model.ApplicationData;
import model.CD;
import model.User;
import views.LoadingScreen;
import views.StartScreen;

@SuppressWarnings("serial")
public class Project4Application extends JFrame {
	ApplicationData appData;
	JPanel currentView;
	User activeUser;

	public Project4Application() {
		super();
		//Rectangle screenBounds = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
		//this.setSize(screenBounds.width, screenBounds.height);
		this.setSize(1000, 700);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Project 4");
		activeUser = null;
		setCurrentScreen(new LoadingScreen(this));
	}
	
	public void start() {
		appData = new ApplicationData();
		ArrayList<CD> cds = getCdData("project4.xml");
		appData.setCDs(cds);
		setCurrentScreen(new StartScreen(this));
	}
	
	public ArrayList<CD> getCdData(String path) {
		ArrayList<CD> cds = new ArrayList<CD>();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		Document dom;		
		try{	
			DocumentBuilder db = factory.newDocumentBuilder();
			dom = db.parse(path);
		} catch(ParserConfigurationException pce) {
			pce.printStackTrace();
			return cds;
		} catch(SAXException se) {
			se.printStackTrace();
			return cds;
		} catch(IOException ioe) {
			ioe.printStackTrace();
			return cds;
		}
		
		Element root = dom.getDocumentElement();
		NodeList nl = root.getElementsByTagName("cd");
		if(nl != null) {
			for(int i = 0; i < nl.getLength(); i++) {
				Element e = (Element) nl.item(i);
				CD cd = parseCD(e);
				cds.add(cd);
			}
		}
		
		return cds;
	}
	
	private CD parseCD(Element e) {
		String title = getTextValue(e, "title");
		String artist = getTextValue(e, "artist");
		String genre = getTextValue(e, "genre");
		int cost = getIntValue(e, "cost");
		
		return new CD(title, artist, genre, cost);
	}
	
	private String getTextValue(Element e, String tagName) {
		String text = "";
		NodeList nl = e.getElementsByTagName(tagName);
		if(nl != null && nl.getLength() > 0) {
			Element el = (Element) nl.item(0);
			text = el.getFirstChild().getNodeValue();
		}
		return text.trim();
	}
	
	private int getIntValue(Element e, String tagName) {
		return Integer.parseInt(getTextValue(e, tagName));
	}
	
	public ApplicationData getAppData() {
		return appData;
	}
	
	public void quit() {
		this.dispose();
	}
	
	public void setCurrentScreen(JPanel view) {
		if(currentView != null) {
			this.remove(currentView);
		}
		currentView = view;
		this.setContentPane(currentView);
		currentView.setVisible(true);
		this.setVisible(true);
	}
	
	public User getActiveUser() {
		return activeUser;
	}
	
	public void setActiveUser(User u) {
		activeUser = u;
	}
}
