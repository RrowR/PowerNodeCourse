package day22.afternoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) throws IOException {
        Book b1 = new Book("000000001", "java", 99.9);
        Book b2 = new Book("000000002", "C++", 88.8);
        Book b3 = new Book("000000003", "C#", 77.7);
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Book> books2 = new ArrayList<>();
        books.add(b1);
        books.add(b2);
        books.add(b3);
//        writeBook("JavaSE/src/c.txt",books);
        books2 = readBook("JavaSE/src/c.txt", books2);
        for (Book book : books2) {
            System.out.println(book);
        }
    }

    private static ArrayList<Book> readBook(String path,ArrayList<Book> books) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String len;
        while ((len = br.readLine()) != null){
            String[] split = len.split("\t");
            books.add(new Book(split[0],split[1],Double.parseDouble(split[2])));
        }
        br.close();
        return books;

    }

    private static void writeBook(String path,ArrayList<Book> books) throws IOException {
        File file = new File(path);
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        for (Book book : books) {
            bw.write(book.getIsbn()+"\t");
            bw.write(book.getName()+"\t");
            bw.write(book.getPrice()+"");
            bw.newLine();
        }
        bw.close();
    }
}
