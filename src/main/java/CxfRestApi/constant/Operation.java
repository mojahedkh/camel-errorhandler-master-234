package CxfRestApi.constant;

import CxfRestApi.beans.AddToList;
import CxfRestApi.model.FileMoveRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Operation {

    public static class Messages {
        public static final String SUCCESS = "SUCCESS";
        public static final String FAILED = "FAILED";
        public static final String InvlidFileNameError = "InvlidFileNameError";
        public static final String FileNotFoundError = "FileNotFoundError";

    }

    public static class File{
        public static String FileName = "";

        public static void setFileName(String fileName) {
            FileName = fileName;
        }

        public static String getFileName() {
            return FileName;
        }
    }
    public static class Loggers {
        public String LoggerClassName ;

        public Loggers(String loggerClassName) {
            LoggerClassName = loggerClassName;
        }

        public static final Logger log = LoggerFactory.getLogger(Operation.class.getName());
    }

    public static String systemDate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy");
        String sysDate = formatter.format(date);
        return sysDate;
    }

    public static List<String> dataInsideList() {
        return AddToList.fileName;
    }

    public static String filesName(FileMoveRequest fileMoveRequest) {
        List<String> fileNames = new ArrayList<String>();
        String allName = new String();
        for (String name : fileMoveRequest.getFileName()) {
            fileNames.add(name);
            allName = allName + " , " + name;
        }
        return allName;
    }

    public static void printAll(List<String> fileName) throws Exception {
        int index = 0;
        for (String filesName : fileName) {
            Operation.Loggers.log.info(" Inside file name " + "[" + index + "]" + filesName);
            index++;
        }
    }
}