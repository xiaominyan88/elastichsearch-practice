package es.original;

import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;

public class ESIndexDelete extends AbstractESOperation {

    public ESIndexDelete(String address,int port,String schema){
        super(address,port,schema);
    }

    @Override
    public Object doAction() throws Exception {

        DeleteIndexRequest request = new DeleteIndexRequest("userexample");

        AcknowledgedResponse response = esClient.indices().delete(request, RequestOptions.DEFAULT);

        return response;
    }
}
