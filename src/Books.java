public class Books {


        String isbn, title, author, genre;
        Boolean isAvailable;

    public Books(String isbn, String title, String author, String genre, Boolean isAvailable){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
    }


        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public String getIsbn() {
            return isbn;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public String getGenre() {
            return genre;
        }




}
