package CxfRestApi.beans;

import CxfRestApi.Exception.FileNotFoundException;
import CxfRestApi.model.FileMoveRequest;
import CxfRestApi.model.FileMoveResponse;
import org.apache.camel.Exchange;
import org.apache.cxf.message.MessageContentsList;

import javax.ws.rs.core.HttpHeaders;

/**
 * @author Mosab.Shqair
 * @date 1/12/2023 9:01 AM
 */
public class FileRestServiceNormlizer {

    public void normlizeFileMoveRequest(Exchange exchange) throws Exception {
        MessageContentsList msgList = (MessageContentsList) exchange.getIn().getBody();

        if (msgList != null) {
            exchange.getIn().setBody(msgList.get(0));
        }
    }


    public FileMoveResponse returnResponse(Exchange exchange) throws FileNotFoundException {
        //file move request
        FileMoveRequest fileMoveRequest = (FileMoveRequest) exchange.getIn().getBody();


        //file response
        FileMoveResponse fileMoveResponse = new FileMoveResponse.Builder().
                withResponseCode("0").
                withResponseMessage("Success : Hello" + fileMoveRequest.getFileName()).
                build();
        exchange.getOut().setHeader(Exchange.HTTP_RESPONSE_CODE, 201);
        return fileMoveResponse;
    }
}
