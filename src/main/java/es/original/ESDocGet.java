package es.original;

import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;

public class ESDocGet extends AbstractESOperation {

    public ESDocGet(String address, int port, String schema){
        super(address, port, schema);
    }

    @Override
    public Object doAction() throws Exception {

        GetRequest request = new GetRequest();

        request.index("userexample").id("10001");

        GetResponse response = esClient.get(request, RequestOptions.DEFAULT);

        return response;
    }
}
