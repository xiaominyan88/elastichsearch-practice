package es.main;

import es.original.AbstractESOperation;
import es.original.Constant;
import es.original.ESDocQueryAggregationPeak;

public class ESMainFunction {

    public static void main(String[] args) {


        try(AbstractESOperation es = new ESDocQueryAggregationPeak(Constant.address,Constant.port,Constant.schema)){

            Object object = es.doAction();

            es.doResponse(object);

            //es.doClose();

        }catch(Exception e){

            e.printStackTrace();

        }


    }
}

