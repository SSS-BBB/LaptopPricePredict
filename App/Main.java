import javax.swing.*;

import Frames.DropdownInputWindow;
import Frames.TextfieldInputWindow;
import Frames.UserInputWindow;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Dropdown Window Test
        // dropDownWindowTest();

        // TextField Window Test
        // textFieldWindowTest();
        
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