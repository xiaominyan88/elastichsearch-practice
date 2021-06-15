package es.original;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.search.SearchHits;

public abstract class AbstractESOperation implements ESClientStateFunction,AutoCloseable {

    public RestHighLevelClient esClient;

    public AbstractESOperation(String address,int port,String schema){
        esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost(address,port,schema))
        );
    }

    @Override
    public void doClose() throws Exception{
        if(esClient!= null)
            esClient.close();
    }

    @Override
    public void close() throws Exception{

        if(esClient!= null)
            esClient.close();

    }

    public abstract Object doAction() throws Exception;

    @Override
    public void doResponse(Object object) {

        if(object instanceof CreateIndexResponse){

            CreateIndexResponse response = CreateIndexResponse.class.cast(object);

            boolean acknowledged = response.isAcknowledged();

            System.out.println("es index create index is success?" + acknowledged);

        }else if(object instanceof GetIndexResponse){

            GetIndexResponse response = GetIndexResponse.class.cast(object);

            System.out.println("aliases is " + response.getAliases());

            System.out.println("index mapping starts : ");

            response.getMappings().entrySet().forEach(
                    m->{
                        System.out.println("key is : " + m.getKey() + "| value is : " + m.getValue().toString());
                    }
            );

            System.out.println("index setting starts : ");

            response.getSettings().entrySet().forEach(
                    m->{
                        System.out.println("key is : " + m.getKey() + "| value is : " + m.getValue().toString() );
                    }
            );

        }else if(object instanceof AcknowledgedResponse){

            AcknowledgedResponse response = AcknowledgedResponse.class.cast(object);

            System.out.println("es index delete index is success?" + response.isAcknowledged());

        }else if(object instanceof IndexResponse){

            IndexResponse response = IndexResponse.class.cast(object);

            System.out.println("doc info : "
                    + "docId = " + response.getId()
                    + ",index = " + response.getIndex()
                    + ",resultName = " + response.getResult().name()
                    + ",statusName = " + response.status().name());

        }else if(object instanceof UpdateResponse){

            UpdateResponse response = UpdateResponse.class.cast(object);

            System.out.println("doc update info : " + "resultName = " + response.getResult().name());

        }else if(object instanceof GetResponse){

            GetResponse response = GetResponse.class.cast(object);

            System.out.println("doc info : " + response.getSourceAsString());

        }else if(object instanceof DeleteResponse){

            DeleteResponse response = DeleteResponse.class.cast(object);

            System.out.println("delete doc resultName : " + response.getResult().name());

        }else if(object instanceof BulkResponse){

            BulkResponse responses = BulkResponse.class.cast(object);

            responses.iterator().forEachRemaining(
                    m ->{
                        System.out.println("doc id : " + m.getId() + " has been accomplished : " + m.status().name());
                    }
            );

        }else if(object instanceof SearchResponse){

            SearchResponse response = SearchResponse.class.cast(object);

            SearchHits hits = response.getHits();

            hits.forEach(
                    m->{
                        System.out.println("hit info : " + m.getSourceAsString());
                    }
            );

        }

    }
}
