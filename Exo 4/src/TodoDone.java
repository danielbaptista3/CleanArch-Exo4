import org.xml.sax.SAXException;
import services.TodoService;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Scanner;

public class TodoDone {

    public static void main(String[] args) {

        TodoService todoService = TodoService.getInstance();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                todoService.displayNotes();
            } catch (ParserConfigurationException | IOException | SAXException e) {
                e.printStackTrace();
            }

            String action = scanner.nextLine();
            todoService.manageAction(action);
        }
    }
}

