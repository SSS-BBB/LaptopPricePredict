package Handler;

import Frames.DropdownInputWindow;
import Frames.TextfieldInputWindow;

public class WindowHandler {

    WindowParameter[] windowParameterList;

    public WindowHandler(int windowNumber) {
        windowParameterList = new WindowParameter[windowNumber];
    }

    public void addSelectedPage(int pageNumber, String programTitle, String textTitle, String buttonText, String fieldText) {
        windowParameterList[pageNumber] = new WindowParameter(programTitle, textTitle, buttonText, fieldText);
    }

    public void addSelectedPage(int pageNumber, String programTitle, String textTitle, String buttonText, String[] dropDownList) {
        windowParameterList[pageNumber] = new WindowParameter(programTitle, textTitle, buttonText, dropDownList);
    }

    public void createSelectedWindow(int pageNumber) {

        WindowParameter windowParameter = windowParameterList[pageNumber];

        if (windowParameter != null) {
            if (windowParameter.getWindowType() == WindowType.TEXT_FIELD) {
                new TextfieldInputWindow(windowParameter.programTitle, windowParameter.textTitle, windowParameter.fieldText, windowParameter.buttonText);
            }

            else if (windowParameter.getWindowType() == WindowType.DROP_DOWN) {
                new DropdownInputWindow(windowParameter.programTitle, windowParameter.textTitle, windowParameter.dropDownList, windowParameter.buttonText);
            }
        }
        else {
            System.out.println("Page number " + pageNumber + " wasn't defiend!");
        }
    }

    public int getSize() {
        return windowParameterList.length;
    }
    
}