package com.example.RFForm;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;

@org.springframework.stereotype.Controller
public class Controller {

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String page(Model model) throws ParserConfigurationException, IOException, SAXException {
        String url = "https://www.nbkr.kg/XML/daily.xml";
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new URL(url).openStream());

        doc.getDocumentElement().normalize();
        NodeList nameNodes = doc.getElementsByTagName("Value");
        Node nameNode = nameNodes.item(0);
        Node nameNode1 = nameNodes.item(1);
        Node nameNode2 = nameNodes.item(2);
        Node nameNode3 = nameNodes.item(3);
        String currency = "USD: " + nameNode.getTextContent() + "↑ EUR: " + nameNode1.getTextContent() + "↑ KZT: " + nameNode2.getTextContent() + "↑ RUB: " + nameNode3.getTextContent()+" ↑";
        model.addAttribute("currencyValue", currency);
        return "index";
    }

    private String currencyRemoveLast(String s) {
        char[] c = new char[s.length()];
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            c[i] = s.charAt(i);
        }
        for (int i = 0; i < s.length() - 2; i++) {
            builder.append(c[i]);
        }
        return builder.toString();
    }
}

