package me.commonsenze.Snake.Util.FileHandlers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;

public class FileConnection {

	private File file;

	public FileConnection(String name) {
		this.file = new File(name+".txt");
		if (!file.exists())
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void set(String key, String value) throws IOException {
		boolean empty = true;
		try {
			FileReader reader = new FileReader(file);
			BufferedReader br = new BufferedReader(reader);
			try {
				if (br.readLine() != null) {
					empty = false;
				}
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
		    Files.write(Paths.get(file.getAbsolutePath()), ((empty ? "" : "\n")+key + ": " +value).getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
		    //exception handling left as an exercise for the reader
		}
	}

	public Object getObject(String key) throws IllegalKeyException {
		try {
			FileReader reader = new FileReader(file);
			BufferedReader br = new BufferedReader(reader);
			try {
				String line;
				while ((line = br.readLine()) != null) {
					if (line.contains(key)) {
						br.close();
						return (Object) line.split(": ")[1];
					}
				}
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		throw new IllegalKeyException();
	}
	
	public int getInt(String key) throws NumberFormatException, IllegalKeyException {
		try {
			FileReader reader = new FileReader(file);
			BufferedReader br = new BufferedReader(reader);
			try {
				String line;
				while ((line = br.readLine()) != null) {
					if (line.contains(key)) {
						br.close();
						return Integer.parseInt(line.split(": ")[1]);
					}
				}
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		throw new IllegalKeyException();
	}
	
	public double getDouble(String key) throws NumberFormatException, IllegalKeyException {
		try {
			FileReader reader = new FileReader(file);
			BufferedReader br = new BufferedReader(reader);
			try {
				String line;
				while ((line = br.readLine()) != null) {
					if (line.contains(key)) {
						br.close();
						return Double.parseDouble(line.split(": ")[1]);
					}
				}
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		throw new IllegalKeyException();
	}
	
	public String getString(String key) throws IllegalKeyException {
		try {
			FileReader reader = new FileReader(file);
			BufferedReader br = new BufferedReader(reader);
			try {
				String line;
				while ((line = br.readLine()) != null) {
					if (line.contains(key)) {
						br.close();
						return line.split(": ")[1];
					}
				}
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		throw new IllegalKeyException();
	}

	public ArrayList<String> getEntries(){
		ArrayList<String> lines = new ArrayList<>();
		try {
			FileReader reader = new FileReader(file);
			BufferedReader br = new BufferedReader(reader);
			try {
				String line;
				while ((line = br.readLine()) != null) {
					lines.add(line);
				}
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return lines;
	}

	public HashMap<String, Integer> getScores() throws FileNotFoundException{
		FileReader reader = new FileReader(file);
		BufferedReader br = new BufferedReader(reader);
		HashMap<String, Integer> map = new HashMap<>();
		String line;
		try {
			while ((line = br.readLine()) != null) {
				try {
					map.put(line.split(": ")[0], Integer.parseInt(line.split(": ")[1].split(" - ")[0]));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
}
