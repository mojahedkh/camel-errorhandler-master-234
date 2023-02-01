package CxfRestApi.beans;

import CxfRestApi.constant.Operation;
import CxfRestApi.model.FileMoveRequest;
import CxfRestApi.model.FileMoveResponse;
import CxfRestApi.model.FileRenameRequest;
import CxfRestApi.model.ResponseException;
import org.apache.camel.Exchange;
import org.apache.cxf.message.MessageContentsList;

/**
 * @author Mosab.Shqair
 * @date 1/12/2023 9:01 AM
 */

public class FileRestServiceNormlizer {
    public ProcessFile processFile = new ProcessFile();

    public void normlizeFileMoveRequest(Exchange exchange) throws Exception {
        MessageContentsList msgList = (MessageContentsList) exchange.getIn().getBody();
        Operation.Loggers.log.info("MessageContentsList" + msgList);

        if (msgList != null) {
            exchange.getIn().setBody(msgList.get(0));
        }
    }

    public FileMoveResponse returnResponseInsertFilesName(Exchange exchange) throws Exception {

        //file move request
        FileMoveRequest fileMoveRequest = (FileMoveRequest) exchange.getIn().getBody();
        String allName = Operation.filesName(fileMoveRequest);

        //file response
        FileMoveResponse fileMoveResponse = new FileMoveResponse.Builder().
                withResponseCode("0").
                withResponseMessage("Success : files-name " + allName).
                build();

        exchange.getOut().setHeader(Exchange.HTTP_RESPONSE_CODE, 201);
        return fileMoveResponse;
    }

    public FileMoveResponse returnResponseFileName(Exchange exchange) throws Exception {
        String message = exchange.getIn().getHeader("message", String.class);

        FileMoveResponse fileMoveResponse = new FileMoveResponse.Builder().
                withResponseCode("0").
                withResponseMessage("Success : file-name " + message).
                build();

        exchange.getOut().setHeader(Exchange.HTTP_RESPONSE_CODE, 201);
        return fileMoveResponse;

    }

    public ResponseException responseException(Exchange exchange) {

        ResponseException responseException = new ResponseException.Builder().
                withResponseCode("1")
                .withResponseMessage("Failed")
                .build();

        exchange.getOut().setHeader(Exchange.HTTP_RESPONSE_CODE, 201);
        return responseException;
    }

    public void fileRenameRequest(Exchange exchange) {
        FileRenameRequest filename = exchange.getIn().getBody(FileRenameRequest.class);
        FileRenameRequest fileRenameRequest = new FileRenameRequest();
        fileRenameRequest.setFileName(filename.getFileName());
        Operation.File.setFileName(filename.getFileName());
        exchange.getOut().setBody(fileRenameRequest);
    }
    public String getFileName(){
        return Operation.File.getFileName();
    }

}
