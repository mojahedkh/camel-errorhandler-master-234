package CxfRestApi.beans;

import CxfRestApi.constant.Operation;
import org.apache.camel.Exchange;

public class RenameFile {

    public void RenameFileFromTo(Exchange exchange) throws Exception {

        String message = exchange.getIn().getBody(String.class);
        System.out.println(message);
        String fileName = exchange.getIn().getHeader("fileName" , String.class);
        String body = AddToList.fileWithBody.get(fileName);

        Operation.checkFileName(message) ; // check
        String oldName = message;
        message = message + "_Moved_" + Operation.systemDate() + "_Rest";
        Operation.Loggers.log.info("Rename File from {" + oldName + "} to {" + message + "}");
        exchange.getOut().setHeader(Exchange.HTTP_RESPONSE_CODE, 200);
        exchange.getOut().setHeader("updatedFileName" , message);
        exchange.getOut().setBody(body);

    }


}
