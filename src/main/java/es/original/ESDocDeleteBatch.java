package es.original;

import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.client.RequestOptions;

public class ESDocDeleteBatch extends AbstractESOperation {

    public ESDocDeleteBatch(String address,int port,String schema){
        super(address, port, schema);
    }

    @Override
    public Object doAction() throws Exception {

        BulkRequest request = new BulkRequest();

        request.add(new DeleteRequest().index("userexample").id("10001"));
        request.add(new DeleteRequest().index("userexample").id("10002"));
        request.add(new DeleteRequest().index("userexample").id("10003"));
        BulkResponse responses = esClient.bulk(request, RequestOptions.DEFAULT);
        return responses;
    }
}
