package CxfRestApi.beans;

import CxfRestApi.constant.Operation;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ReadFromDirectory   {

    public void ReadFromFiles(Exchange exchange) throws  Exception {
        String fileName = exchange.getIn().getBody(String.class);
        Operation.Loggers.log.info("we inside ReadFromFiles");

        exchange.getOut().setHeader("fileName" , fileName);
        ConsumerTemplate template = exchange.getContext().createConsumerTemplate();
        Object body = template.receiveBody("file:{{file.uri}}/files?fileName=${header.fileName}.txt?noop=null");
        Operation.Loggers.log.info("there is a body request from file "+body);
    }

}
