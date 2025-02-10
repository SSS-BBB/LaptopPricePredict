package Handler;

import Frames.DropdownInputWindow;
import Frames.ResultWindow;
import Frames.TextfieldInputWindow;

public class WindowHandler {

    WindowParameter[] windowParameterList;

    public int currentPage;

    DataHandler dataHandler;

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
                TextfieldInputWindow inputWindow = new TextfieldInputWindow(windowParameter.programTitle, windowParameter.textTitle, windowParameter.fieldText, windowParameter.buttonText);
                inputWindow.setHandler(this, dataHandler);
            }

            else if (windowParameter.getWindowType() == WindowType.DROP_DOWN) {
                DropdownInputWindow inputWindow = new DropdownInputWindow(windowParameter.programTitle, windowParameter.textTitle, windowParameter.dropDownList, windowParameter.buttonText);
                inputWindow.setHandler(this, dataHandler);
            }
        }
        else {
            System.out.println("Page number " + pageNumber + " wasn't defiend!");
        }
    }

    public void start() {
        // page starts at 0
        currentPage = 0;

        // reset all data
        dataHandler = new DataHandler(getSize());

        // create the first window in the list
        createSelectedWindow(0);
    }

    public void nextPage() {
        currentPage++;
        if (currentPage >= getSize()) {
            // Result Windpw
            dataHandler.sendDataForPrediction();
            new ResultWindow(this, dataHandler);
        }
        else {
            createSelectedWindow(currentPage);
        }
    }

    public int getSize() {
        return windowParameterList.length;
    }
    
}