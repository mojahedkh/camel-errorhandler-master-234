package CxfRestApi.beans;

import CxfRestApi.Exception.FileNotFoundException;
import CxfRestApi.Exception.InvalidFileNameException;
import CxfRestApi.constant.Constants;
import CxfRestApi.model.FileMoveRequest;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.dataformat.JaxbDataFormat;
import org.apache.cxf.transport.http.Address;

public class ProcessFile  {
    public static void process(String fileName) throws Exception {

        if (fileName.isEmpty()) {
            Constants.Loggers.log.error("File name is empty from request body");
            throw new InvalidFileNameException(" File name is empty" + Constants.Messages.FAILED);
        }

        else if (Constants.dataInsideList().contains(fileName) == false) {
            Constants.Loggers.log.error("File name does not contain in the directory ");
            throw new FileNotFoundException("File name does not contain in the directory"+Constants.Messages.FAILED);
        }

    }
}
