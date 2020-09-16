package data;

import exceptions.*;
import domain.Movie;
import java.util.List;

public interface DataAccess {
	
	boolean exists(String fileName) throws DataAccessEx;
	
	public List<Movie> list(String fileName) throws ReadDataAccessEx;
	
	void write(Movie movie, String fileName, boolean append) throws WriteDataAccessEx;
	
	public String find(String fileName, String find) throws ReadDataAccessEx;
	
	public void create(String fileName) throws DataAccessEx;
	
	public void delete(String fileName) throws DataAccessEx;
	
}
