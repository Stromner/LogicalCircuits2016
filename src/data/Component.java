package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for loading and saving components created inside this program. 
 * 
 * @author David Strömner
 */

public class Component {
	/**
	 * Load an existing component from a file.
	 * @param path file path to the component including the name and extension of the file.
	 * @return the list of {@link TwoInputBlock}s that the component uses.
	 * @throws IOException if {@link ObjectInputStream} can't be created.
	 * @throws ClassNotFoundException if an unknown object exist in the file
	 * @throws FileNotFoundException if the file path doesn't exist.
	 */
	public static List<TwoInputBlock> loadComponent(String path) throws IOException, ClassNotFoundException, FileNotFoundException{
		List<TwoInputBlock> blocks = new ArrayList<TwoInputBlock>();
		FileInputStream fis = new FileInputStream(path);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		blocks = (List<TwoInputBlock>) ois.readObject();
		ois.close();
		fis.close();
		
		return blocks;
	}
	
	/**
	 * Save the current component into a file.
	 * @param path file path to the component including the name and extension of the file.
	 * @param blocks the list of {@link TwoInputBlock}s that the current component uses.
	 * @return one if an error occurred when writing the component to file. Zero otherwise.
	 */
	public static int saveComponent(String path, List<TwoInputBlock> blocks){
		try {
			File component = new File(path);
			component.createNewFile();
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(blocks);
			
			oos.close();
			fos.close();
		}
		catch (IOException e) {
			e.printStackTrace();
			return 1;
		}
		
		return 0;
	}
}
