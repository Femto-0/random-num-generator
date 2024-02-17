import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RandomNumGenerator {
    String fileName= "src/main/java/list.txt";

    public ArrayList<String> readList() throws IOException {
        String islandName;
        ArrayList<String> island= new ArrayList<>();
        BufferedReader br= new BufferedReader(new FileReader(fileName));
        String line;
        while ((line= br.readLine())!=null){
            String [] arr= line.split("\\s");
           islandName=arr[0];
           if(!(island.contains(islandName))&& islandName!=null) {
               island.add(islandName);
               island.remove(null);
           }

        }

        return island;
    }

    public static void main(String[] args) throws IOException {
        RandomNumGenerator rng= new RandomNumGenerator();
        System.out.println(rng.readList());
        System.out.println(rng.readList().size());
    }
}
