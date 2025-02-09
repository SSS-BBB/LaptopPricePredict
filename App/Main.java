import javax.swing.*;

import Frames.DropdownInputWindow;
import Frames.TextfieldInputWindow;
import Frames.UserInputWindow;
import Handler.WindowHandler;

import java.awt.*;

public class Main {

    public static WindowHandler windowHandler;

    public static void main(String[] args) {
        // Dropdown Window Test
        // dropDownWindowTest();

        // TextField Window Test
        // textFieldWindowTest();

        // Multiple Window Test
        multipleWindowTest();
        
    }

    public static void multipleWindowTest() {
        windowHandler = new WindowHandler(2);

        windowHandler.addSelectedPage(0, "Brand", "Selct Brand", "Next", new String[]{ "Apple", "HP", "MSI", "MICROSOFT", "Dell" });
        windowHandler.addSelectedPage(1, "Weight", "Enter Weight", "Next", "");

        windowHandler.createSelectedWindow(1);
    }

    public static void dropDownWindowTest() {
        UserInputWindow testWindow = new DropdownInputWindow("Brand", 
                                "Select Brand", 
                                new String[]{ "Apple", "HP", "MSI", "MICROSOFT", "Dell" }, 
                                "Next"
        );
    }

    public static void textFieldWindowTest() {
        UserInputWindow testWindow = new TextfieldInputWindow("Weight", 
                                "Enter Weight", 
                                "", 
                                "Next"
        );
    }
}