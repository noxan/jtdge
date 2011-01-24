package com.github.noxan.jtdge.ewt.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.github.noxan.jtdge.ewt.comp.EComponent;
import com.github.noxan.jtdge.ewt.comp.EPanel;

/**
 * 
 * @author richard
 * @version 0.7b1(r17)
 * @since 0.7b0(r14)
 */
public class EWTMLParser {
	private EWTMLParser() {
	}
	
	public static final String EWTPackage = "com.beanstalkapp.noxan.jtdge.ewt.";
	private static SAXParser parser;
	
	private static EPanel lastPanel;
	private static EPanel rootPanel;
	
	/**
	 * Loads a eml-file from the given location.
	 * @param location
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 */
	public static EComponent load(String location) throws ParserConfigurationException, SAXException, IOException {
		File f = new File(location);
		if(f.exists()) {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			parser = factory.newSAXParser();
			parser.parse(f, new DefaultHandler() {
				@Override
				public void startDocument() throws SAXException {
					System.out.println("document start");
				}
				@Override
				public void endDocument() throws SAXException {
					System.out.println("document end");
				}
				@Override
				public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
					ClassLoader cl = ClassLoader.getSystemClassLoader();
					try {
						Class<?> cla = cl.loadClass(EWTPackage+qName);
						if(cla.getClass().getName().equals("EPanel")) {
							if(rootPanel==null) {
								rootPanel = null;
								lastPanel = rootPanel;
							} else {
								lastPanel.add(null);
								lastPanel = null;
							}
						} else if(rootPanel==null) {
							rootPanel = new EPanel(0, 0);
							lastPanel = rootPanel;
						}
						lastPanel.add(null);
					} catch(ClassNotFoundException e) {
						e.printStackTrace();
					}
					
					System.out.print(uri+";"+localName+";"+qName+";");
					for(int index=0;index<attributes.getLength();index++) {
						System.out.print(attributes.getLocalName(index)+"="+attributes.getValue(index)+",");
					}
					System.out.println();
				}
			});
		} else {
			System.err.println("file "+f.getAbsolutePath()+" not found");
		}
		return rootPanel;
	}
}
