package com.relesee.framework.sax.utils;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaxUtil {
    private static Map<String,Object> objectFields = new HashMap<String,Object>();

    /**
     * 读取xml中对象的所有属性
     * @return
     */
    public static Map<String, Object> getObjectFields(String XmlConfigFileUri){
        objectFields.clear();
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser parser = null;
        XMLReader reader = null;
        try {
            parser = saxParserFactory.newSAXParser();
            reader = parser.getXMLReader();
            reader.setContentHandler(new DefaultHandler(){

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

                    if (qName == "property") {
                        objectFields.put(attributes.getValue("name"),attributes.getValue("value"));
                    }

                }

            });
            reader.parse(XmlConfigFileUri);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return objectFields;

    }
}
