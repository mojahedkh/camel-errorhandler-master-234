package CxfRestApi.beans;

import CxfRestApi.constant.Operation;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ReadFromDirectory implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        String fileName = exchange.getIn().getBody(String.class);
        ConsumerTemplate template = exchange.getContext().createConsumerTemplate();
        Object body = template.receiveBody("file:{{file.uri}}/files?fileName="+fileName+".txt?noop=true");
        Operation.Loggers.log.info("there is a body request from file "+body);
    }

    public void ReadFromFiles(Exchange exchange) throws  Exception {
        String fileName = exchange.getIn().getBody(String.class);
        ConsumerTemplate template = exchange.getContext().createConsumerTemplate();
        Object body = template.receiveBody("file:{{file.uri}}/files?fileName="+fileName+".txt?noop=true");
        Operation.Loggers.log.info("there is a body request from file "+body);
    }

}
