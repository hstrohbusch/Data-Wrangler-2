// Name: Michael Kukovec
// Email: kukovec@wisc.edu
// Team: AD
// TA: Sophie Stephenson
// Lecturer: Gary Dahl
// Notes to Grader: getCitation() handles all edge cases for separating last and first name

public class Book {
	
	private String title;
	private String author;
	private String publisher;
	private int publication_year;
	private String isbn;
	
	//No-argument constructor
	public Book() {
		title = "";
		author = "";
		publisher = "";
		publication_year = 0;
		isbn = "";
	}
	//Parameterized constructor
	public Book(String title, String author, String publisher, int publication_year, String isbn) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.publication_year = publication_year;
		this.isbn = isbn;
	}
	//Copy constructor
	public Book(Book c) {
		this.title = c.title;
		this.author = c.author;
		this.publisher = c.publisher;
		this.publication_year = c.publication_year;
		this.isbn = c.isbn;
	}
	
	//Getter methods
	public String getTitle() { return title; }
	public String getAuthor() { return author; }
	public String getPublisher() { return publisher; }
	public int getPublicationYear() { return publication_year; }
	public String getISBN() { return isbn; }
	
	//Setter methods
	public void setTitle(String title) { this.title = title; }
	public void setAuthor(String author) { this.author = author; }
	public void setPublisher(String publisher) { this.publisher = publisher; }
	public void setPublicationYear(int publication_year) { this.publication_year = publication_year; }
	public void setISBN(String isbn) { this.isbn = isbn; }
	
	public String getCitation() {
		//MLA format- Last Name, First Name. Title of Book. Publisher, Publication Date.
		String first = "";
		String last = "";
		String citation = "";
		
		if(!author.isEmpty()) {
			//Last name
			int i = author.length() - 1;
			while(author.charAt(i) != ' ') {
				last = author.charAt(i) + last;
				i--;
				//Handles single word names
				if(i < 0) {
					break;
				}
			}
			//First Name
			if(i >= 0) {
				i = 0;
				while(author.charAt(i) != ' ') {
					first += author.charAt(i);
					i++;
					//Handles initials with spaces
						if(author.charAt(i) == ' ' && i + 2 < author.length() - 1 && author.charAt(i + 2) == '.') {
							first += ' ';
							i++;
						}
				}

				//Handles initials
				if(first.charAt(first.length() - 1) == '.') {
					first = first.substring(0, first.length() - 1);
				}
			}
			last = last.substring(0, 1).toUpperCase() + last.substring(1);
			citation += last;
			//Handles comma for single word names
			if(first != "") {
				first = first.substring(0, 1).toUpperCase() + first.substring(1);
				if(last.charAt(last.length() - 1) != '.') {
					citation += ",";
				}
				citation += " " + first;
			}
			citation += ". ";
		}
		//Handles missing info
		if(title != "") {
			citation += title + ". ";
		}
		if(publisher != "") {
			citation += publisher;
		}
		if(publication_year > 0) {
			if(publisher != "") {
				citation += ", ";
			}
			citation += publication_year;
		}
		citation += '.';
		return citation;
	}
}
