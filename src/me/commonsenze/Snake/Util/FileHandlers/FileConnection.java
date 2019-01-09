package me.commonsenze.Snake.Util.FileHandlers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FileConnection {

	private File file;
	private Map<String, Object> data;

	public FileConnection(String name) {
		this.file = new File(name+".txt");
		if (!file.exists())
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		this.data = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		initiate();
	}

	private void initiate() {
		try {
			FileReader reader = new FileReader(file);
			BufferedReader br = new BufferedReader(reader);
			try {
				String line, key = "";
				while ((line = br.readLine()) != null) {
					if (!line.contains(": ")) {
						int indents = getInstancesOf(key, '.'), tabs = getInstancesOf(line, '\t');
						if (indents != tabs) {
							key = key.substring(0,key.length()-2);
							int index = key.lastIndexOf('.')+1;
							if (index == -1) index = 0;
							key = key.substring(0,index);
							System.out.println(key);
						}
						key += line.trim().replace(":", "") + ".";
						continue;
					}
//					System.out.println(key+line.trim().split(": ")[0]);
					set(key+line.trim().split(": ")[0], (Object)line.trim().split(": ")[1]);
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
	}

	public static void main(String[] args) {
//		System.out.println("Creating Test file...");
		FileConnection connection = new FileConnection("Test");
//		System.out.println("Setting data values...");

		connection.set("Arena.Max.X", 20);
		connection.set("Arena.Max.Y", 20);
		connection.set("Arena.Max.Z", 20);
		connection.set("Aidan.Testing.Amari.Priyam", 5000);

//		System.out.println("Saving data...");
		connection.save();

//		System.out.println("Showing data...");
//		try {
//			System.out.println(connection.getInt("Aidan.Testing.Amari.Priyam"));
//		} catch (IllegalKeyException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	public void save() {
		clear();
		String folder = "";
		for (String key : data.keySet()) {
//			System.out.println(key);
			while (!key.startsWith(folder)&&!folder.isEmpty()) {
				folder = folder.substring(0, folder.length()-1);
				int index = folder.lastIndexOf('.')+1;
				if (index == -1) index = 0;
				folder = folder.substring(0,index);
			}
			int indents = getInstancesOf(folder, '.'), inputs = key.split("\\.").length;
			for (String subKey : key.split("\\.")) {
				if (folder.contains(subKey))continue;
				try {
					String tab = "";
					FileReader reader = new FileReader(file);
					BufferedReader br = new BufferedReader(reader);

					if (br.readLine() != null) {
						tab = "\n";
					}

					br.close();

					for (int i = 0; i < indents; i++) {
						tab += "\t";
					}

					if (inputs -1 == indents) {
						Files.write(Paths.get(file.getAbsolutePath()), (tab+subKey + ": " + data.get(key)).getBytes(), StandardOpenOption.APPEND);
					} else {
						Files.write(Paths.get(file.getAbsolutePath()), (tab+subKey + ":").getBytes(), StandardOpenOption.APPEND);
						folder+=subKey + ".";
					}

					indents++;
				} catch (IOException e) {
					//exception handling left as an exercise for the reader
					e.printStackTrace();
				}
			}
		}
	}

	public int getInstancesOf(String str, char c) {
		int count = 0;

		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == c)
				count++;
		}

		return count;
	}
	
	private void clear() {
		try {
			FileOutputStream out = new FileOutputStream(file);
			out.write("".getBytes());
			out.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean contains(String key) {
		try {
			FileReader reader = new FileReader(file);
			BufferedReader br = new BufferedReader(reader);
			try {
				String line, dataKey = "";
				while ((line = br.readLine()) != null) {
					if (line.contains(": ")) {
						dataKey += line.trim().split(":")[0];
						if (dataKey.equalsIgnoreCase(key)) {
							br.close();
							return true;
						}
						dataKey = "";
						continue;
					}
					dataKey += line.trim().replace(":", "") + ".";
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
		return false;
	}

	public void set(String key, Object value) {
//		ArrayList<String> removeKeys = new ArrayList<>(data.keySet());
//		for (String otherKey : removeKeys) {
//			if (otherKey.contains(key)&&otherKey.length() > key.length()) {
//				data.remove(otherKey);
//			}
//		}
		data.put(key, value);
	}

	public Object getObject(String key) throws IllegalKeyException {
		if (data.containsKey(key))return data.get(key);
		throw new IllegalKeyException();
	}

	public int getInt(String key) throws NumberFormatException, IllegalKeyException {
		if (data.containsKey(key)) {
			int num = 0;
			try {
				num = Integer.parseInt(data.get(key).toString());
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			return num;
		}
		throw new IllegalKeyException();
	}

	public double getDouble(String key) throws NumberFormatException, IllegalKeyException {
		if (data.containsKey(key)) {
			double num = 0;
			try {
				num = Double.parseDouble(data.get(key).toString());
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			return num;
		}
		throw new IllegalKeyException();
	}

	public String getString(String key) throws IllegalKeyException {
		if (data.containsKey(key))return data.get(key).toString();
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
