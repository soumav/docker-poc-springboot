package com.test.sbd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.sbd.model.Book;
import com.test.sbd.repository.BookRepository;

import io.micrometer.common.util.StringUtils;

@Service
public class BookService {

	@Autowired
	BookRepository repo;

	@Autowired
	SequenceGeneratorService seqGenSvc;

	public List<Book> getBooks() {
		return repo.findAll();
	}

	public List<Book> insertBooks(List<Book> bookList) {
		bookList.parallelStream().filter(b -> !StringUtils.isBlank(b.getName())).forEach(b -> {
			if (b.getId() == null)
				b.setId(seqGenSvc.getNextSequence(Book.SEQUENCE_NAME));
		});
		return repo.saveAll(bookList);

	}

}
