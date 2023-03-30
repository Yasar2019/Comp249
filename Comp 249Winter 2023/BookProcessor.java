// -----------------------------------------------------
// Assignment (Assignment - Exception Handling and File I/O)
// Question: Part 1
// Written by: (Your Name and Student ID)
// -----------------------------------------------------

import java.io.*;
import java.io.BufferedWriter;
import java.io.FileWriter;

import java.util.Arrays;
import java.util.Scanner;

class TooManyFieldsException extends Exception {
    public TooManyFieldsException(String message) {
        super(message);
    }
}

class TooFewFieldsException extends Exception {
    public TooFewFieldsException(String message) {
        super(message);
    }
}

class MissingFieldException extends Exception {
    public MissingFieldException(String message) {
        super(message);
    }
}

class UnknownGenreException extends Exception {
    public UnknownGenreException(String message) {
        super(message);
    }
}

class BadIsbn10Exception extends Exception {
    public BadIsbn10Exception(String message) {
        super(message);
    }
}

class BadIsbn13Exception extends Exception {
    public BadIsbn13Exception(String message) {
        super(message);
    }
}

class BadPriceException extends Exception {
    public BadPriceException(String message) {
        super(message);
    }
}

class BadYearException extends Exception {
    public BadYearException(String message) {
        super(message);
    }
}

public class BookProcessor {

    private static int bookCount;

    public static void main(String[] args) {
        System.out.println("Welcome to the Book Processor!");
        do_part1();
        do_part2();
        do_part3();
        System.out.println("Thank you for using the Book Processor!");
    }
    
    /**
     * public static void do_part1() {
     * String[] genres = { "CCB", "HCB", "MTV", "MRB", "NEB", "OTR", "SSM", "TPA" };
     * String[] outputFiles = {
     * "Cartoons_Comics_Books.csv",
     * "Hobbies_Collectibles_Books.csv",
     * "Movies_TV.csv",
     * "Music_Radio_Books.csv",
     * "Nostalgia_Eclectic_Books.csv",
     * "Old_Time_Radio.csv",
     * "Sports_Sports_Memorabilia.csv",
     * "Trains_Planes_Automobiles.csv"
     * };
     * 
     * try (BufferedReader inputFileReader = new BufferedReader(new
     * FileReader("Part1_input_file_names.txt"));
     * BufferedWriter errorWriter = new BufferedWriter(new
     * FileWriter("syntax_error_file.txt"))) {
     * 
     * int numberOfFiles = Integer.parseInt(inputFileReader.readLine());
     * 
     * for (int i = 0; i < numberOfFiles; i++) {
     * String inputFileName = inputFileReader.readLine();
     * try (BufferedReader bookFileReader = new BufferedReader(new
     * FileReader(inputFileName))) {
     * String line;
     * while ((line = bookFileReader.readLine()) != null) {
     * try {
     * String[] fields = line.split(",", -1);
     * if (fields.length < 6) {
     * throw new TooFewFieldsException("Too few fields");
     * } else if (fields.length > 6) {
     * throw new TooManyFieldsException("Too many fields");
     * }
     * 
     * String genre = fields[4];
     * int genreIndex = Arrays.asList(genres).indexOf(genre);
     * if (genreIndex < 0) {
     * throw new UnknownGenreException("Unknown genre");
     * }
     * 
     * if (fields[0].isEmpty() || fields[1].isEmpty() || fields[2].isEmpty() ||
     * fields[3].isEmpty()
     * || fields[5].isEmpty()) {
     * throw new MissingFieldException("Missing field");
     * }
     * 
     * try (BufferedWriter outputFileWriter = new BufferedWriter(
     * new FileWriter(outputFiles[genreIndex], true))) {
     * outputFileWriter.write(line);
     * outputFileWriter.newLine();
     * }
     * } catch (TooManyFieldsException | TooFewFieldsException |
     * MissingFieldException
     * | UnknownGenreException e) {
     * errorWriter.write("syntax error in file: " + inputFileName);
     * errorWriter.newLine();
     * errorWriter.write("====================");
     * errorWriter.newLine();
     * errorWriter.write("Error: " + e.getMessage());
     * errorWriter.newLine();
     * errorWriter.write("Record: " + line);
     * errorWriter.newLine();
     * errorWriter.newLine();
     * }
     * }
     * } catch (FileNotFoundException e) {
     * System.out.println("File not found: " + inputFileName);
     * }
     * }
     * } catch (IOException e) {
     * System.out.println("Error while reading or writing files: " +
     * e.getMessage());
     * }
     * }
     */

    public static void do_part1() {
        String[] genres = {
                "CCB", "HCB", "MTV", "MRB", "NEB", "OTR", "SSM", "TPA"
        };
        String[] outputFiles = {
                "Cartoons_Comics_Books.csv",
                "Hobbies_Collectibles_Books.csv",
                "Movies_TV.csv",
                "Music_Radio_Books.csv",
                "Nostalgia_Eclectic_Books.csv",
                "Old_Time_Radio.csv",
                "Sports_Sports_Memorabilia.csv",
                "Trains_Planes_Automobiles.csv"
        };

        try (BufferedReader inputFileReader = new BufferedReader(new FileReader("Part1_input_file_names.txt"));
                BufferedWriter errorWriter = new BufferedWriter(new FileWriter("syntax_error_file.txt"))) {

            int numberOfFiles = Integer.parseInt(inputFileReader.readLine());

            for (int i = 0; i < numberOfFiles; i++) {
                String inputFileName = inputFileReader.readLine();
                try (BufferedReader bookFileReader = new BufferedReader(new FileReader(inputFileName))) {
                    String line;
                    while ((line = bookFileReader.readLine()) != null) {
                        try {
                            String[] fields = line.split(",", -1);
                            if (fields.length < 6) {
                                throw new TooFewFieldsException("Too few fields");
                            } else if (fields.length > 6) {
                                throw new TooManyFieldsException("Too many fields");
                            }

                            String genre = fields[4];
                            int genreIndex = Arrays.asList(genres).indexOf(genre);
                            if (genreIndex < 0) {
                                throw new UnknownGenreException("Unknown genre");
                            }

                            if (fields[0].isEmpty() || fields[1].isEmpty() || fields[2].isEmpty() || fields[3].isEmpty()
                                    || fields[5].isEmpty()) {
                                throw new MissingFieldException("Missing field");
                            }

                            try (BufferedWriter outputFileWriter = new BufferedWriter(
                                    new FileWriter(outputFiles[genreIndex], true))) {
                                outputFileWriter.write(line);
                                outputFileWriter.newLine();
                            }
                        } catch (TooManyFieldsException | TooFewFieldsException | MissingFieldException
                                | UnknownGenreException e) {
                            errorWriter.write("syntax error in file: " + inputFileName);
                            errorWriter.newLine();
                            errorWriter.write("====================");
                            errorWriter.newLine();
                            errorWriter.write("Error: " + e.getMessage());
                            errorWriter.newLine();
                            errorWriter.write("Record: " + line);
                            errorWriter.newLine();
                            errorWriter.newLine();
                        }
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File not found: " + inputFileName);
                }
            }
        } catch (IOException e) {
            System.out.println("Error while reading or writing files: " + e.getMessage());
        }
    }

    private static void do_part2() {

        String[] csvFiles = {
                "Cartoons_Comics_Books.csv",
                "Hobbies_Collectibles_Books.csv",
                "Movies_TV.csv",
                "Music_Radio_Books.csv",
                "Nostalgia_Eclectic_Books.csv",
                "Old_Time_Radio.csv",
                "Sports_Sports_Memorabilia.csv",
                "Trains_Planes_Automobiles.csv"
        };

        for (String csvFile : csvFiles) {
            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                String line;
                Book[] books = new Book[20000];
                int index = 0;

                while ((line = br.readLine()) != null) {
                    String[] fields = line.split(",");
                    String title = fields[0];
                    String authors = fields[1];
                    double price = Double.parseDouble(fields[2]);
                    String isbn = fields[3];
                    String genre = fields[4];
                    int year = Integer.parseInt(fields[5]);

                    try {
                        validatePrice(price);
                        validateYear(year);

                        try {
                            validateIsbn(isbn);
                        } catch (IllegalArgumentException e) {
                            logSemanticError(csvFile, e.getMessage(), line);
                            continue;
                        }
                        books = addBookToArray(books, new Book(title, authors, price, isbn, genre, year), bookCount);
                        bookCount++;

                    } catch (BadPriceException | BadYearException | BadIsbn10Exception | BadIsbn13Exception e) {
                        logSemanticError(csvFile, e.getMessage(), line);
                    }
                }

                books = Arrays.copyOf(books, bookCount);
                serializeBooks(books, csvFile + ".ser");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void logSemanticError(String fileName, String errorMessage, String record) {
        try (FileWriter fw = new FileWriter("semantic_error_file.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
            out.println("Semantic error in file: " + fileName);
            out.println("====================");
            out.println("Error: " + errorMessage);
            out.println("Record: " + record);
            out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void serializeBooks(Book[] books, String outputFile) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFile))) {
            oos.writeObject(books);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void validatePrice(double price) throws BadPriceException {
        if (price < 0) {
            throw new BadPriceException("Price cannot be negative");
        }
    }

    private static void validateYear(int year) throws BadYearException {
        if (year < 1995 || year > 2010) {
            throw new BadYearException("Invalid year: " + year);
        }
    }

    private static void validateIsbn(String isbn) throws BadIsbn10Exception, BadIsbn13Exception {
        if (isbn.length() == 10) {
            validateIsbn10(isbn);
        } else if (isbn.length() == 13) {
            validateIsbn13(isbn);
        } else {
            throw new IllegalArgumentException("Invalid ISBN length: " + isbn.length());
        }
    }

    private static void validateIsbn10(String isbn) throws BadIsbn10Exception {
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int digit = Character.getNumericValue(isbn.charAt(i));
            sum += (10 - i) * digit;
        }

        int lastDigit = isbn.charAt(9) == 'X' ? 10 : Character.getNumericValue(isbn.charAt(9));
        sum += lastDigit;

        if (sum % 11 != 0) {
            throw new BadIsbn10Exception("Invalid ISBN-10: " + isbn);
        }
    }

    private static void validateIsbn13(String isbn) throws BadIsbn13Exception {
        int sum = 0;
        for (int i = 0; i < 13; i++) {
            int digit = Character.getNumericValue(isbn.charAt(i));
            sum += (i % 2 == 0 ? 1 : 3) * digit;
        }

        if (sum % 10 != 0) {
            throw new BadIsbn13Exception("Invalid ISBN-13: " + isbn);
        }
    }

    private static Book[] addBookToArray(Book[] books, Book book, int bookCount) {
        if (bookCount == books.length) {
            Book[] resizedBooks = new Book[books.length * 2];
            System.arraycopy(books, 0, resizedBooks, 0, books.length);
            books = resizedBooks;
        }
        books[bookCount] = book;
        return books;
    }

    public static void do_part3() {
        String[] binaryFiles = {
            "Cartoons_Comics_Books.csv.ser",
            "Hobbies_Collectibles_Books.csv.ser",
            "Movies_TV.csv.ser",
            "Music_Radio_Books.csv.ser",
            "Nostalgia_Eclectic_Books.csv.ser",
            "Old_Time_Radio.csv.ser",
            "Sports_Sports_Memorabilia.csv.ser",
            "Trains_Planes_Automobiles.csv.ser"
        };

        Book[][] bookArrays = new Book[binaryFiles.length][];
        for (int i = 0; i < binaryFiles.length; i++) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(binaryFiles[i]))) {
                bookArrays[i] = (Book[]) ois.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Scanner scanner = new Scanner(System.in);
        int selectedFileIndex = 0;
        int currentBookIndex = 0;

        while (true) {
            System.out.println("----------------------------");
            System.out.println("Main Menu");
            System.out.println("----------------------------");
            System.out.println("v View the selected file: " + binaryFiles[selectedFileIndex] + " (" + bookArrays[selectedFileIndex].length + " records)");
            System.out.println("s Select a file to view");
            System.out.println("x Exit");
            System.out.println("----------------------------");
            System.out.print("Enter Your Choice: ");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("x")) {
                break;
            } else if (choice.equalsIgnoreCase("s")) {
                System.out.println("------------------------------");
                System.out.println("File Sub-Menu");
                System.out.println("------------------------------");
                for (int i = 0; i < binaryFiles.length; i++) {
                    System.out.println((i + 1) + " " + binaryFiles[i] + " (" + bookArrays[i].length + " records)");
                }
                System.out.println("9 Exit");
                System.out.println("------------------------------");
                System.out.print("Enter Your Choice: ");
                int fileChoice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (fileChoice == 9) {
                    continue;
                } else if (fileChoice >= 1 && fileChoice <= binaryFiles.length) {
                    selectedFileIndex = fileChoice - 1;
                    currentBookIndex = 0;
                }
            } else if (choice.equalsIgnoreCase("v")) {
                System.out.println("viewing: " + binaryFiles[selectedFileIndex] + " (" + bookArrays[selectedFileIndex].length + " records)");
                Book[] selectedBooks = bookArrays[selectedFileIndex];
                while (true) {
                    System.out.print("Enter viewing command (n): ");
                    int n = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    if (n == 0) {
                        break;
                    } else if (n > 0) {
                        int endIndex = Math.min(currentBookIndex + n, selectedBooks.length);
                        for (int i = currentBookIndex; i < endIndex; i++) {
                            System.out.println(selectedBooks[i]);
                        }
                        if (endIndex == selectedBooks.length){
                            System.out.println("End of file");
                        }
                        currentBookIndex = Math.min(endIndex, selectedBooks.length - 1);
                    } else if (n < 0) {
                        int startIndex = Math.max(currentBookIndex + n + 1, 0);
                        if (startIndex == 0) {
                        System.out.println("BOF has been reached");
                        }
                        for (int i = startIndex; i <= currentBookIndex; i++) {
                        System.out.println(selectedBooks[i]);
                        }
                        currentBookIndex = startIndex;
}
}
}
}
scanner.close();
System.out.println("Thank you for using the Book Processor!");
}
}
