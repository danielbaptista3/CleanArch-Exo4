package services;

import constants.TodoConstants;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;

public class TodoService {

    private static TodoService todoService = null;
    private DocumentBuilderFactory factory = null;
    private File todos = null;

    public static final String FILE_PATH = "D:\\ESGI\\5AL2\\Clean Archi\\e99694abaca6f8cfe47cb3ef3c3d955f\\Exo 4\\src\\resources\\todos.xml";

    public static TodoService getInstance() {
        if (todoService == null) {
            todoService = new TodoService();
        }
        return todoService;
    }

    private TodoService() {
        init();
    }

    private void init() {
        todos = new File(FILE_PATH);
        factory = DocumentBuilderFactory.newInstance();
    }

    public void displayNotes() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(todos);
        Element root = doc.getDocumentElement();
        NodeList notes = root.getElementsByTagName(TodoConstants.ELEMENT_NOTE);
        displayNote(notes);
    }

    private void displayNote(NodeList notes) {
        for (int noteIndex = 0; noteIndex < notes.getLength(); noteIndex++) {
            Element note = (Element) notes.item(noteIndex);
            String creationString = note.getElementsByTagName(TodoConstants.ELEMENT_CREATION).item(0).getTextContent();
            String description = note.getElementsByTagName(TodoConstants.ELEMENT_DESCRIPTION).item(0).getTextContent();
            boolean isDone = Boolean.parseBoolean(note.getElementsByTagName(TodoConstants.ELEMENT_IS_DONE).item(0).getTextContent());

            System.out.println(creationString + "  " + description + "  " + isDone);
            //Todo todo = new Todo(description, creationDate, isDone);
        }
    }

    public void manageAction(String action) {
        switch (action) {
            case "add":
                addAction();
                break;
            case "remove":
                break;
        }
    }

    private void addAction() {

    }
}
