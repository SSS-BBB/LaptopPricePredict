package Handler;

public class WindowParameter {
    
    String programTitle;
    String textTitle;
    String buttonText;

    String fieldText; // For Textfield Window

    String[] dropDownList; // For Dropdown Window

    int windowType;

    public String getProgramTitle() {
        return programTitle;
    }

    public String getTextTitle() {
        return textTitle;
    }

    public String getButtonText() {
        return buttonText;
    }

    public String getFieldText() {
        return fieldText;
    }

    public String[] getDropDownList() {
        return dropDownList;
    }

    public int getWindowType() {
        return windowType;
    }

    public WindowParameter(String programTitle, String textTitle, String buttonText, String fieldText) {
        // Textfield
        this.programTitle = programTitle;
        this.textTitle = textTitle;
        this.buttonText = buttonText;
        this.fieldText = fieldText;

        windowType = WindowType.TEXT_FIELD;
    }

    public WindowParameter(String programTitle, String textTitle, String buttonText, String[] dropDownList) {
        // Dropdown
        this.programTitle = programTitle;
        this.textTitle = textTitle;
        this.buttonText = buttonText;
        this.dropDownList = dropDownList;

        windowType = WindowType.DROP_DOWN;
    }

}
