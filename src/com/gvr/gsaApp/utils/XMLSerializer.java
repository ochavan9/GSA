package com.gvr.gsaApp.utils;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class XMLSerializer {
	private static final String XML_FILE_NAME = "D:\\GSA\\Assignment\\Serialized\\XMLSerialized.xml";

	public void writeObjectToXMLFile(Object obj) {
		try {
			FileOutputStream file = new FileOutputStream(XML_FILE_NAME);
			XMLEncoder encoder = new XMLEncoder(file);
			
			// Method for serialization of object
			encoder.writeObject(obj);
			encoder.close();
			file.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Object readObjectFromXMLFile() {

		Object deserialiseObject = null;
		try {
			FileInputStream file = new FileInputStream(XML_FILE_NAME);
			XMLDecoder decoder = new XMLDecoder(file);
			
			// Method for deserialization of object
			deserialiseObject = decoder.readObject();
			decoder.close();
			file.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return deserialiseObject;
	}
	
	
}
