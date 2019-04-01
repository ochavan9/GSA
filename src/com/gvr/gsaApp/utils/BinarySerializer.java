package com.gvr.gsaApp.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BinarySerializer {
	private final String SERIALIZED_FILE_NAME = "D:\\GSA\\Assignment\\Serialized\\BinarySerialized.txt";

	public void writeObjectToBinaryFile(Object obj) {
		try {
			FileOutputStream file = new FileOutputStream(SERIALIZED_FILE_NAME);
			ObjectOutputStream out = new ObjectOutputStream(file);

			// Method for serialization of object
			out.writeObject(obj);
			out.close();
			file.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Object readObjectFromBinaryFile() {
		Object deserialisedObject = null;
		try {
			FileInputStream file = new FileInputStream(SERIALIZED_FILE_NAME);
			ObjectInputStream in = new ObjectInputStream(file);

			// Method for deserialization of object
			deserialisedObject = (Object) in.readObject();
			in.close();
			file.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return deserialisedObject;
	}
}
