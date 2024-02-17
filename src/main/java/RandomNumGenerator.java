import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

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
           }

        }
        return island;
    }
    public ArrayList<String> createCityAndHouseList(ArrayList<String> arrList) throws IOException {
        ArrayList<String> cityList= new ArrayList<>();
        BufferedReader br= new BufferedReader(new FileReader(fileName));
       String firstWord;
       String[] arr ;
        int i=0;
       while((firstWord=br.readLine())!=null) {
           arr = firstWord.split("\\s");

               if(Objects.equals(arrList.get(i), arr[0])) {
                   cityList.add(arr[1]);
                   cityList.add(arr[2]);
               }else{
                   cityList.add("--");
                   cityList.add(arr[1]);
                   cityList.add(arr[2]);
                   i++;
               }
       }
       br.close();
        return cityList;
    }


    public static void main(String[] args) throws IOException {
        RandomNumGenerator rng= new RandomNumGenerator();
        System.out.println(rng.readList());
        System.out.println(rng.createCityAndHouseList(rng.readList()));
        System.out.println(rng.readList().size());
    }
}
