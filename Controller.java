import java.util.ArrayList;

public class Controller {

    View view = new View();
    DAO dao = new DAO();

    private static final String ADD_BOOK = "1";
    private static final String EDIT_BOOK = "2";
    private static final String DELETE_BOOK = "3";
    private static final String SEARCH = "4";
    private static final String SEE_BOOKS = "5";
    private static final String SEE_BOOKS_BY_AUTHOR = "6";
    private static final String EXIT = "0";

    public void start() {

        boolean terminateProgram = false;
        while (!terminateProgram) {
            view.showMainMenu();
            String input = view.getUserInput();
            switch (input) {
                case ADD_BOOK:
                    addBook();
                    break;
                case EDIT_BOOK:
                    editBook();
                    break;
                case DELETE_BOOK:
                    deleteBook();
                    break;
                case SEARCH:
                    search();
                    break;
                case SEE_BOOKS:
                    seeBooks();
                    break;
                case SEE_BOOKS_BY_AUTHOR:
                    seeBooksByAuthor();
                    break;
                case EXIT:
                    terminateProgram = true;
                    break;
                default:
            }
        }
    }

    private void addBook() {

    }

    private void editBook() {

    }

    private void deleteBook() {

    }

    private void search() {

    }

    private void seeBooks() {
        view.seeBooks(dao.getAllBooks());
    }

    private void seeBooksByAuthor() {

    }
}