package CxfRestApi.beans;

import CxfRestApi.Exception.InvalidFileNameException;
import CxfRestApi.constant.Constants;
import CxfRestApi.model.FileMoveResponse;
import CxfRestApi.model.FileRenameRequest;
import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RenameFile {
    public void RenameFileFromTo(Exchange exchange) throws InvalidFileNameException {
        FileRenameRequest fileRenameRequest = (FileRenameRequest) exchange.getIn().getBody();

        String message =  fileRenameRequest.getFileName();
        String oldName = message;

        message = message +"_Moved_" + Constants.systemDate() + "_Rest";
        Constants.Loggers.log.info("Rename File from {" + oldName + "} to {" + message + "}");
        exchange.getOut().setHeader("message",message);
    }

}
