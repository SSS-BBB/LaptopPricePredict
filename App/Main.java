import javax.swing.*;

import Frames.DropdownInputWindow;
import Frames.TextfieldInputWindow;
import Frames.UserInputWindow;
import Handler.DataHandler;
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
        // multipleWindowTest();

        // Server Test
        serverTest();

        // Start
        // startProgram();
        
    }

    public static void serverTest() {
        DataHandler dataHandler = new DataHandler(10);
        dataHandler.makeDummy();
        dataHandler.sendDataForPrediction();
        // dataHandler.showData();
    }

    public static void startProgram() {
        windowHandler = new WindowHandler(10);

        windowHandler.addSelectedPage(0, "Brand", "Selct Brand", "Next", new String[]{ "Apple", "HP", "MSI", "MICROSOFT", "Dell" });
        windowHandler.addSelectedPage(1, "CPU", "Selct CPU", "Next", new String[]{ "Intel i3", "Intel i7", "AMD Ryzen 3", "AMD Ryzen 9", "Intel i9" });
        windowHandler.addSelectedPage(2, "RAM", "Enter RAM", "Next", "");
        windowHandler.addSelectedPage(3, "Storage", "Selct Storage", "Next", new String[]{ "512GB SSD", "2TB SSD", "256GB SSD", "1TB SSD", "1TB HDD" });
        windowHandler.addSelectedPage(4, "GPU", "Selct GPU", "Next", new String[]{ "Nvidia RTX 2060", "Nvidia GTX 1650", "Nvidia RTX 3060", "AMD Radeon RX 6600", "AMD Radeon RX 6800" });
        windowHandler.addSelectedPage(5, "Screen Size", "Enter Screen Size", "Next", "");
        windowHandler.addSelectedPage(6, "Resolution", "Selct Resolution", "Next", new String[]{ "3840x2160", "1366x768", "1920x1080", "2560x1440" });
        windowHandler.addSelectedPage(7, "Battery Life", "Enter Battery Life", "Next", "");
        windowHandler.addSelectedPage(8, "Weight", "Enter Weight", "Next", "");
        windowHandler.addSelectedPage(9, "Operating System", "Selct System", "Next", new String[]{ "Windows", "FreeDOS", "Linux", "macOS" });
        
        // Start
        windowHandler.start();
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