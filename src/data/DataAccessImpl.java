package data;

import exceptions.*;
import domain.Movie;
import java.io.*;
import java.util.*;

public class DataAccessImpl implements DataAccess{
	
	public boolean exists(String fileName) throws DataAccessEx {
		File file = new File(fileName);
		return file.exists();
	}
	
	public List<Movie> list(String fileName) throws ReadDataAccessEx {
		File file = new File(fileName);
		List<Movie> movies = new ArrayList();
		try {
			try(BufferedReader input = new BufferedReader(new FileReader(file))){
				String line;
				line = input.readLine();
				while(line != null) {
					Movie movie = new Movie(line);
					movies.add(movie);
					line = input.readLine();
				}
			}
		}catch(IOException ex){
			ex.printStackTrace(System.out);
		}
		return movies;
	}
	
	public void write(Movie movie, String fileName, boolean append) throws WriteDataAccessEx {
		File file = new File(fileName);
		try {
			try(PrintWriter output = new PrintWriter(new FileWriter(file,append))){
				output.println(movie.toString());
			}
			System.out.println("the file has been written");
		}catch(IOException ex) {
			ex.printStackTrace(System.out);
		}
	}
	
	public String find(String find, String fileName) {
		File file = new File(fileName);
		String result = null;
		try {
			try(BufferedReader input = new BufferedReader(new FileReader(file))){
				String line;
				int i = 0;
				line = input.readLine();
				while(line != null) {
					if(find != null && find.equalsIgnoreCase(line)) {
						result = "Movie " + line + "in line " + i;
						break;
					}
					line = input.readLine();
					i++;
				}
			}
			
		}catch(IOException ex) {
			ex.printStackTrace(System.out);
		}
		return result;
	}
	
	public void create(String fileName) {
		File file = new File(fileName);
		try {
			PrintWriter output = new PrintWriter(new FileWriter(file));
			output.close();
			System.out.println("File created");
		}catch(IOException ex) {
			ex.printStackTrace(System.out);
		}
	}
	
	public void delete(String fileName) {
		File file = new File(fileName);
		file.delete();
		System.out.println("File deleted");
	}	
}
