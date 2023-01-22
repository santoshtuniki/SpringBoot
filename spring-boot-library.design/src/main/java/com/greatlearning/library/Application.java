package com.greatlearning.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.greatlearning.library.entity.Library;
import com.greatlearning.library.service.LibraryCountService;
import com.greatlearning.library.service.LibraryCreateService;
import com.greatlearning.library.service.LibraryDeleteService;
import com.greatlearning.library.service.LibraryExistService;
import com.greatlearning.library.service.LibraryReadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort.Direction;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class Application implements CommandLineRunner {

	@Autowired
	LibraryReadService libraryReadServiceImpl;

	@Autowired
	LibraryCreateService libraryCreateServiceImpl;

	@Autowired
	LibraryCountService libraryCountServiceImpl;

	@Autowired
	LibraryExistService libraryExistServiceImpl;

	@Autowired
	LibraryDeleteService libraryDeleteServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("Hello Spring Boot");
		System.out.println("Hello Dev-Tools");
	}

	@Override
	public void run(String... args) throws Exception {

//		readServiceImplMethodsExecution();
//	
//		createServiceImplMethodsExecution();
//
//		countServiceImplMethodsExecution();
//
//		existServiceImplMethodsExecution();
//
//		deleteServiceImplMethodsExecution();
	}

	private void deleteServiceImplMethodsExecution() {
//		log.info("Delete Single Library -> {}", libraryDeleteServiceImpl.deleteOneLibrary(
//				Library.builder().id(10l).name("C library").commaSeparatedBookNames("xyz, abc, efg").build()));
//
//		log.info("Prune Library Table -> {}", libraryDeleteServiceImpl.pruneTable());
//
//		List<Library> libraries = new ArrayList<>();
//		libraries.add(Library.builder().id(3l).name("Animal library").commaSeparatedBookNames("").build());
//		libraries.add(Library.builder().id(4l).name("Cloud library").commaSeparatedBookNames("").build());
//		log.info("Delete All These Libraries -> {}", libraryDeleteServiceImpl.deleteAllThese(libraries));
//
//		log.info("Delete All in Batch -> {}", libraryDeleteServiceImpl.deleteAllInBatch());
//
//		log.info("Delete Library By Id -> {}", libraryDeleteServiceImpl.deleteLibraryById(3l));
//
//		List<Library> librariesBatch = new ArrayList<>();
//		librariesBatch.add(Library.builder().id(3l).name("Animal library").commaSeparatedBookNames("").build());
//		librariesBatch.add(Library.builder().id(4l).name("Cloud library").commaSeparatedBookNames("").build());
//		log.info("Delete All These Libraries -> {}", libraryDeleteServiceImpl.deleteAllTheseInBatch(librariesBatch));
	}

	private void existServiceImplMethodsExecution() {
		log.info("Check if Library Exists By Id -> {}", libraryExistServiceImpl.checkLibraryExistsById(1l));

		log.info("Check if Library Exists By Example -> {}",
				libraryExistServiceImpl.checkLibraryExistsByExample("learn java, learn scala, learn AWS"));
	}

	private void countServiceImplMethodsExecution() {
		log.info("Count the Number of Libraries -> {}", libraryCountServiceImpl.countLibraries());

		log.info("Count the Number of Libraries With Zero Books -> {}",
				libraryCountServiceImpl.countLibrariesWithZeroBooks());
	}

	private void createServiceImplMethodsExecution() {
		log.info("Persist a Single Library -> {}", libraryCreateServiceImpl.addSingleLibrary(
				Library.builder().id(11l).name("E Library").commaSeparatedBookNames("xyz,abc").build()));

		List<Library> libraries = new ArrayList<Library>();
		libraries.add(Library.builder().id(12l).name("F Library").commaSeparatedBookNames("abc,efg").build());
		libraries.add(Library.builder().id(13l).name("G Library").commaSeparatedBookNames("efg").build());
		log.info("Persist All Libraries -> {}", libraryCreateServiceImpl.addAllLibraries(libraries));

		log.info("Persist a Library With Save And Flush Combined -> {}",
				libraryCreateServiceImpl.addLibrararywithSaveAndFlush(Library.builder().id(14l)
						.name("E-commerce Library").commaSeparatedBookNames("Amazon,Flipkart").build()));
	}

	private void readServiceImplMethodsExecution() {
		log.info("Fetch All libraries -> {}", libraryReadServiceImpl.getAllLibrary());

		log.info("Fetch All libraries with NoBooks -> {}", libraryReadServiceImpl.getAllLibrariesWithNoBooks());

//		Page<Library> page = libraryReadServiceImpl.getLibrariesPaged();
//		List<Library> libraries = page.get().collect(Collectors.toList());
		log.info("Fetch All in Page Format -> {}",
				libraryReadServiceImpl.getLibrariesPaged().get().collect(Collectors.toList()));

		log.info("Fetch Libraries in Custom Paged Format -> {}",
				libraryReadServiceImpl.getLibrariesCustomPaged(2, 2).get().collect(Collectors.toList()));

		log.info("Fetch Libraries in Latest Added Order -> {}",
				libraryReadServiceImpl.getLibrariesWithLatestAddedOrder());

		log.info("Fetch Libraries Custom Sorted By Id -> {}",
				libraryReadServiceImpl.getLibrariesCustomSortedByID(Direction.ASC));

		log.info("Fetch Libraries Custom Sorted By Name -> {}",
				libraryReadServiceImpl.getLibrariesCustomSortedByName(Direction.ASC));

		log.info("Fetch Libraries Paged And Sorted By Name -> {}",
				libraryReadServiceImpl.getLibrariesPagedAndSortedByName().get().collect(Collectors.toList()));

		log.info("Fetch Libraries Paged And Sorted By Name And With These Books -> {}", libraryReadServiceImpl
				.getLibrariesPagedAndSortedByNameAndWithTheseBooks("xyz, abc, efg").get().collect(Collectors.toList()));

		log.info("Fetch Libraries Custom Paged And Sorted By Name And With These Books -> {}",
				libraryReadServiceImpl
						.getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks("xyz, abc, efg", 0, 4)
						.get().collect(Collectors.toList()));

		log.info("Fetch Libraries Sorted By Name And With These Books -> {}",
				libraryReadServiceImpl.getSortedByNameAndWithTheseBooks("xyz, abc, efg"));

		List<Long> ids = new ArrayList<Long>();
		ids.add(1l);
		ids.add(2l);
		log.info("Fetch Libraries By ids -> {}", libraryReadServiceImpl.getLibrariesByIds(ids));

		long id = 1l;
		Optional<Library> optionalLibrary = libraryReadServiceImpl.getALibraryById(id);
		if (optionalLibrary.isPresent()) {
			log.info("Fetch A Library By id -> {}", optionalLibrary.get());
		} else {
			log.info("No matching Library with this " + id + " is found in the DB");
		}

		Optional<Library> optionalSingleLibrary = libraryReadServiceImpl
				.getALibraryWithTheseBooks("Life of Tommy, Life of Brownie");
		if (optionalSingleLibrary.isPresent()) {
			log.info("Fetch A Library With These Books -> {}", optionalSingleLibrary.get());
		} else {
			log.info("No matching Library with these Books found in the DB");
		}
	}

}
