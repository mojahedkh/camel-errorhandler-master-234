package CxfRestApi.beans;

import org.apache.camel.ConsumerTemplate;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ReadFromDirectory implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {

        ConsumerTemplate template = exchange.getContext().createConsumerTemplate();
        Object body = template.receiveBody("file:{{CXF_TEST}}/files?fileName=");

    }

}
