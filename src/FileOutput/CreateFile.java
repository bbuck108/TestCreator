package FileOutput;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFile {
	public static void createFile(String p_1) throws IOException{
		File file = new File("test.json");
		file.createNewFile();
		
		FileWriter writer = new FileWriter(file);
		writer.write(p_1); 
	    writer.flush();
	    writer.close();
	}
}
