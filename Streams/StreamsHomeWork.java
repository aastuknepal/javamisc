import java.util.Collection;
import java.util.stream.Stream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Set;
import java.util.Map;
import java.util.Comparator;



public class StreamsHomeWork {
   
   
    public static <T> Stream<T> getStream(Collection<T> collection) {
        return collection.stream();
    }


    public static <T> Stream<T> getParallelStream(Collection<T> collection) {
        return collection.parallelStream();
    }


    public static List<String> convertStreamToStrings(Stream<? extends Object> stream) {
        return stream.map(Object::toString)
                     .collect(Collectors.toList());
    }


    public static Set<Integer> powerDivisibleNumbers(int power, int divisor, Stream<Integer> stream) {
        // Filter numbers divisible by the divisor, raise them to the power, and collect into a set
        return stream.filter(n -> n % divisor == 0)
                     .map(n -> (int) Math.pow(n, power))
                     .collect(Collectors.toSet());
    }

        public static Set<Integer> flatFilteredMap(List<Integer> filterList, Stream<List<Integer>> stream) {
            // Flatten the stream, filter the numbers, and collect into a set
            return stream.flatMap(List::stream)
                         .filter(filterList::contains)
                         .collect(Collectors.toSet());
        }

        public static Map<String, String> toMap(Stream<String> stream) {
            
            return stream.collect(Collectors.toMap(
                str -> str,              
                str -> new StringBuilder(str).reverse().toString() 
            ));
        }


        public static List<String> findWinners(String pattern, int minLength, boolean even, Stream<String> stream) {
            return stream.filter(str -> str.contains(pattern))
                         .filter(str -> str.length() >= minLength)
                         .filter(str -> (str.length() % 2 == 0) == even)
                         .sorted(Comparator.comparingInt(String::length))
                         .collect(Collectors.toList());
        }
        

}
