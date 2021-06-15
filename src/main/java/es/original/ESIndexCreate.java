package es.original;

import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;

public class ESIndexCreate extends AbstractESOperation {

    public ESIndexCreate(String address,int port,String schema){
        super(address,port,schema);
    }

    @Override
    public Object doAction() throws Exception{

        CreateIndexRequest userExample = new CreateIndexRequest("userexample");

        CreateIndexResponse response = esClient.indices().create(userExample, RequestOptions.DEFAULT);

        return response;
    }



}
