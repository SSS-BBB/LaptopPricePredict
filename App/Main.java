import javax.swing.*;

import Frames.UserInputWindow;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Dropdown Window Test
        UserInputWindow testWindow = new UserInputWindow("Brand", 
                                "Select Brand", 
                                new String[]{ "Apple", "HP", "MSI", "MICROSOFT", "Dell" }, 
                                "Next"
        );

        // TextField Window Test
        // UserInputWindow testWindow = new UserInputWindow("Weight", 
        //                         "Enter Weight", 
        //                         "", 
        //                         "Next"
        // );
    }
}