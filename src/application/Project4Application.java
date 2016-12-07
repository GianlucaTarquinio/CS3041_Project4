package application;

import java.awt.Rectangle;
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
import views.LoadingScreen;

@SuppressWarnings("serial")
public class Project4Application extends JFrame {
	JPanel currentView;

	public Project4Application() {
		super();
		Rectangle screenBounds = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
		this.setSize(screenBounds.width, screenBounds.height);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Project 4");
		setCurrentScreen(new LoadingScreen(this));
	}
	
	public void start() {
		ApplicationData appData = new ApplicationData();
		ArrayList<CD> cds = getCdData("project4.xml");
		appData.setCDs(cds);
		appData.printCDs();
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
	
}
