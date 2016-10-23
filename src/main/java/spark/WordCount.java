package spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

import java.util.Arrays;

public class WordCount {

    public static void wordCountJava7( String filename ) {
        SparkConf conf = new SparkConf().setMaster("local").setAppName("Work Count App");

        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> input = sc.textFile( filename );

        JavaRDD<String> words = input.flatMap(
                new FlatMapFunction<String, String>() {
                    public Iterable<String> call(String s) {
                        return Arrays.asList(s.split(" "));
                    }
                } );

        JavaPairRDD<String, Integer> counts = words.mapToPair(
            new PairFunction<String, String, Integer>(){
                public Tuple2<String, Integer> call(String s){
                        return new Tuple2(s, 1);
                    }
            } );

        JavaPairRDD<String, Integer> reducedCounts = counts.reduceByKey(
            new Function2<Integer, Integer, Integer>(){
                public Integer call(Integer x, Integer y){ return x + y; }
            } );
        
        JavaPairRDD<String, Integer> finalcount = reducedCounts.
        reducedCounts.saveAsTextFile( "output" );
    }

    public static void main( String[] args ) {
        if( args.length == 0 ) {
            System.out.println( "Usage: WordCount <file>" );
            System.exit( 0 );
        }

        wordCountJava7( args[ 0 ] );
    }
}