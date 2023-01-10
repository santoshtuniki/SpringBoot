package com.greatlearning.library.service;

public interface LibraryExistService {

	boolean checkLibraryExistsById(Long id);

	boolean checkLibraryExistsByExample(String commaSeparatedBooks);

}