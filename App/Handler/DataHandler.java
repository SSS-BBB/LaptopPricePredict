package Handler;

public class DataHandler {

    String[] dataList;

    public DataHandler(int size) {
        dataList = new String[size];
    }

    public void addData(int index, String data) {
        dataList[index] = data;
    }

    public void showData() {
        for (String data : dataList) {
            System.out.println(data);
        }
    }
    
}