package org.ssglobal.training.codes;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLParse {
	
	public void getAllFirstNames(String filename){
		
		try {
			// Step 1: API instance
			DocumentBuilderFactory docbuilderFactory = 
					 DocumentBuilderFactory.newInstance();
			
			// Step 2: Create the XML builder
			DocumentBuilder docbuilder = docbuilderFactory.newDocumentBuilder();
			
			// Step 3: Load the document
			Document doc = docbuilder.parse(filename);
			
			// Step 4: Extract the root
			Element root = doc.getDocumentElement();
			
			// Step 5: Walk the tree
			walkTheTree(root);
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void walkTheTree(Node node) {
		if (node.getNodeType() == Node.DOCUMENT_NODE) {
			System.out.println("Root document");
			NodeList nodes = node.getChildNodes();
			for(int i = 0; i < nodes.getLength(); i++) {
				Node temp = nodes.item(i);
				walkTheTree(temp);
			}
			
		}
		else if(node.getNodeType() == Node.ELEMENT_NODE) {
			NodeList nodes = node.getChildNodes();
			for(int i = 0; i < nodes.getLength(); i++) {
				Node temp = nodes.item(i);
				walkTheTree(temp);
			}
		} else if(node.getNodeType() == Node.TEXT_NODE) {
			if(node.getParentNode().getNodeName().equalsIgnoreCase("firstname")) {
				String text = node.getNodeValue();
				System.out.println(text);
			}
			
		}
		
	}

}
