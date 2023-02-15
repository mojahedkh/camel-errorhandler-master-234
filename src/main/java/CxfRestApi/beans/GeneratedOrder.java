package CxfRestApi.beans;

import CxfRestApi.constant.Operation;
import CxfRestApi.model.File;
import CxfRestApi.model.FileMoveRequest;
import CxfRestApi.model.FileRenameRequest;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class GeneratedOrder {

    public Map<String, Object> generateOrder(Exchange exchange) {
        FileRenameRequest file_name = exchange.getIn().getBody(FileRenameRequest.class);
        Map<String, Object> file = new HashMap<>();
        file.put("file_name", file_name.getFileName());
        return file;
    }

    public void generateOrderToFileJopUpdated(List<File>  data, Exchange exchange) {
        ProducerTemplate template = exchange.getContext().createProducerTemplate();

        for (File records :data ){
            Operation.Loggers.log.info("file name "+records.getFileName());

            Map<String, Object> fileUpdated = new HashMap<>();

            fileUpdated.put("file_name", records.getFileName());

            fileUpdated.put("id", records.getId());

            template.sendBody("direct:printRequest" ,fileUpdated );
        }
    }
}
