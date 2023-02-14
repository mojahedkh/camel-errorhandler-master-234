package CxfRestApi.beans;

import CxfRestApi.constant.Operation;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddToList implements Processor {
    public static List<String> fileName;
    public static Map<String , String > fileWithBody ;

    Logger log = LoggerFactory.getLogger(RenameFile.class);

    public AddToList() {
        fileName = new ArrayList<>();
    }

    @Override
    public void process(Exchange exchange) throws Exception {

        String fileNameFromHeader = exchange.getIn().getHeader("fileName", String.class);
        String fileContent = exchange.getIn().getBody(String.class);
        fileName.add(fileNameFromHeader);
        Operation.printAll(fileName);
        fileWithBody.put(fileNameFromHeader , fileContent) ;
    }


}
