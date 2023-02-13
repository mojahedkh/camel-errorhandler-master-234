package CxfRestApi.beans;

import CxfRestApi.Exception.FileNotFoundException;
import CxfRestApi.Exception.InvalidFileNameException;
import CxfRestApi.constant.Operation;

public class ProcessFile  {
    public static void process(String fileName) throws Exception {

        if (fileName.isEmpty()) {
            Operation.Loggers.log.error("File name is empty from request body");
            throw new InvalidFileNameException(" File name is empty" + Operation.Messages.FAILED);
        }

        else if (Operation.dataInsideList().contains(fileName) == false) {
            Operation.Loggers.log.error("File name does not contain in the directory ");
            throw new FileNotFoundException("File name does not contain in the directory ");
        }

    }
}
