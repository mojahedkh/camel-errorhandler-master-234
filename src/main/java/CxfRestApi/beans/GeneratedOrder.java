package CxfRestApi.beans;

import CxfRestApi.model.FileMoveRequest;
import CxfRestApi.model.FileRenameRequest;
import org.apache.camel.Exchange;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GeneratedOrder {

    public Map<String, Object> generateOrder(Exchange exchange) {
        FileRenameRequest file_name = exchange.getIn().getBody(FileRenameRequest.class);
        Map<String, Object> file = new HashMap<>();
        file.put("file_name", file_name.getFileName());
        return file;
    }
}
