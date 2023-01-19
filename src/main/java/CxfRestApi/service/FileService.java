package CxfRestApi.service;


import CxfRestApi.model.FileMoveRequest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("fileService")
public interface FileService {

    @POST
    @Path("/moveFile")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String moveFile(String fileName) throws Exception;

    @POST
    @Path("/insertListOfFile")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String insertListOfFile(String fileName) throws Exception;




}
