package com.custom.storage.engine;

import java.io.IOException;
import java.io.RandomAccessFile;

public class DataFile {

	private RandomAccessFile file;

	public DataFile(String filePath) throws IOException {
		file = new RandomAccessFile(filePath, "rw");
	}

	/* write operation */
	public void writeData(String key, String value) throws IOException {
		String data = key + ":" + value + "\n";
		file.writeBytes(data);
	}

	/* Read operation */
	public String readData(long position) throws IOException {
		file.seek(position);
		return file.readLine();
	}

	/* Closing the file */
	public void close() throws IOException {
		file.close();
	}
}
