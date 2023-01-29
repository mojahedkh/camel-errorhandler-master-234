package CxfRestApi.beans;

import CxfRestApi.Exception.FileNotFoundException;
import CxfRestApi.Exception.InvalidFileNameException;
import CxfRestApi.constant.Constants;
import CxfRestApi.model.FileMoveRequest;
import CxfRestApi.model.FileMoveResponse;
import CxfRestApi.model.FileRenameRequest;
import CxfRestApi.model.ResponseException;
import org.apache.camel.Body;
import org.apache.camel.Exchange;
import org.apache.camel.language.Constant;
import org.apache.cxf.headers.Header;
import org.apache.cxf.message.MessageContentsList;

import javax.xml.soap.SAAJResult;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author Mosab.Shqair
 * @date 1/12/2023 9:01 AM
 */

public class FileRestServiceNormlizer {
    public ProcessFile processFile = new ProcessFile();

    public void normlizeFileMoveRequest(Exchange exchange) throws Exception {
        MessageContentsList msgList = (MessageContentsList) exchange.getIn().getBody();
        Constants.Loggers.log.info("MessageContentsList" + msgList);

        if (msgList != null) {
            exchange.getIn().setBody(msgList.get(0));
        }
    }

    public FileMoveResponse returnResponseInsertFilesName(Exchange exchange) throws Exception {

        //file move request
        FileMoveRequest fileMoveRequest = (FileMoveRequest) exchange.getIn().getBody();
        String allName = Constants.filesName(fileMoveRequest);

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
}
