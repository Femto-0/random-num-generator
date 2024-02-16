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
            islandName=line;
        }

        return island;
    }
}
