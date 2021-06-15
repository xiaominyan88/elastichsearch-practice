package es.original;

import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.client.RequestOptions;

public class ESDocDelete extends AbstractESOperation {

    public ESDocDelete(String address,int port,String schema){
        super(address, port, schema);
    }

    @Override
    public Object doAction() throws Exception {

        DeleteRequest request = new DeleteRequest();

        request.index("userexample").id("10000");

        DeleteResponse response = esClient.delete(request, RequestOptions.DEFAULT);

        return response;
    }
}
