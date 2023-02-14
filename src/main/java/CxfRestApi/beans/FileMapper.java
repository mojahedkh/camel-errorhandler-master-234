package CxfRestApi.beans;

import CxfRestApi.constant.Operation;
import CxfRestApi.model.File;
import org.apache.camel.Exchange;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FileMapper {


    public List<File> fileMapperService(List<Map<String, Object>> fileMapper, Exchange exchange) {

        List<File> jopList = new ArrayList<File>();
        int index = 0;
        for (Map<String, Object> listOfFile : fileMapper) {

            File file = new File();
            file.setFileName((String) listOfFile.get("file_name"));
            file.setId((Integer) listOfFile.get("id"));
            file.setStuts((String) listOfFile.get("stuts"));
            jopList.add(file);
            Operation.Loggers.log.info("record [" + index + "]" + "{file id} :- " + file.getId() + "{file name} :- " + file.getFileName() + " {stuts}" + file.getStuts());
            index++;
        }

        return jopList;
    }

    public Map<String, Object> getFileName(List<Map<String, Object>> listOfFileName) {
        return listOfFileName.get(0);
    }
    public void  getFileBody(Exchange exchange){

    }

}