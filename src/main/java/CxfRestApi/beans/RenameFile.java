package CxfRestApi.beans;

import CxfRestApi.Exception.InvalidFileNameException;
import CxfRestApi.constant.Operation;
import CxfRestApi.model.FileRenameRequest;
import org.apache.camel.Exchange;

public class RenameFile {

    public void RenameFileFromTo(Exchange exchange) throws Exception {

        FileRenameRequest fileRenameRequest = (FileRenameRequest) exchange.getIn().getBody();
        String message = fileRenameRequest.getFileName();
        ProcessFile.process(message);
        exchange.getOut().setHeader("previousName" , message);
        String oldName = message;
        message = message + "_Moved_" + Operation.systemDate() + "_Rest";
        Operation.Loggers.log.info("Rename File from {" + oldName + "} to {" + message + "}");
        exchange.getOut().setHeader(Exchange.HTTP_RESPONSE_CODE, 200);
        exchange.getOut().setBody(message);

    }

}
