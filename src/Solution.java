import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader buff = new BufferedReader(new FileReader(fileName));

        ArrayList<String> allWords = new ArrayList<>();
        while (buff.ready()) {
            String line = buff.readLine();
            String [] words = line.split(" ");
            allWords.addAll(Arrays.asList(words));
        }

        reader.close();
        buff.close();

        Map <String,String> uniqPair = new HashMap<>();
        for (int i = 0;i < allWords.size();i++) {
            String reverseWord = new StringBuilder(allWords.get(i)).reverse().toString();
            if (allWords.contains(reverseWord) && allWords.lastIndexOf(reverseWord) != i) {
                uniqPair.put(allWords.get(i),reverseWord);
            }
        }

        for (Map.Entry<String,String> pair:uniqPair.entrySet()) {
            result.add(new Pair(pair.getKey(),pair.getValue()));
        }

        System.out.println(allWords.toString());
        System.out.println(uniqPair.toString());
        System.out.println(result.toString());
        
        //решение, принятое валидатором

//        List<String> words = new ArrayList<>();
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader fileReader = new BufferedReader(new FileReader(bufferedReader.readLine()));
//        bufferedReader.close();
//        while (fileReader.ready()) {
//            words.addAll(Arrays.asList(fileReader.readLine().split(" ")));
//        }
//        fileReader.close();
//
//        for (int i = 0; i < words.size(); i++) {
//            for (int j = 0; j < words.size(); ) {
//                if (i >= words.size()) {
//                    break;
//                }
//                if (words.get(j).equals(new StringBuilder(words.get(i)).reverse().toString()) && j != i) {
//                    Pair pair = new Pair();
//                    pair.first = words.get(j);
//                    pair.second = words.get(i);
//                    result.add(pair);
//                    words.remove(j);
//                    words.remove(i);
//                    j = 0;
//                } else
//                    j++;
//            }
//        }


    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        public Pair(String one, String two) {
            this.first = one;
            this.second = two;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}