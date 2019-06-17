package com.gpcoder.combine;

import java.util.ArrayList;
import java.util.List;

public class ObjectToXmlExample {
    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>();

        Book book1 = new Book();
        book1.setIsbn("978-0-13-708189-9");
        book1.setName("Java core 1");
        book1.setAuthor("Oracle");
        book1.setPublisher("O'reilly");
        bookList.add(book1);

        Book book2 = new Book();
        bookList.add(book2);
        Book book3 = new Book();
        bookList.add(book3);
        Book book4 = new Book();
        bookList.add(book4);

        BookStore bookStore = new BookStore();
        bookStore.setName("Fraport Bookstore");
        bookStore.setLocation("Frankfurt Airport");
        bookStore.setBookList(bookList);

        String xml = ObjectToXmlHelper.convertToXml(bookStore);
        System.out.println(xml);
    }
}
