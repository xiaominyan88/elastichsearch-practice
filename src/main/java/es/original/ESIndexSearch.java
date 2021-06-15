package es.original;

import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

public class ESIndexSearch extends AbstractESOperation {

    public ESIndexSearch(String address,int port,String shema){
        super(address,port,shema);
    }

    public Object doAction() throws Exception {

        GetIndexRequest request = new GetIndexRequest("userexample");

        GetIndexResponse getIndexResponse = esClient.indices().get(request, RequestOptions.DEFAULT);

        return getIndexResponse;
    }


}
