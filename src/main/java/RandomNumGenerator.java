import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class RandomNumGenerator {
    String fileName = "src/main/java/list.txt";

    public ArrayList<String> readList() throws IOException {
        String islandName;
        ArrayList<String> island = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            String[] arr = line.split("\\s");
            islandName = arr[0];
            if (!(island.contains(islandName)) && islandName != null) {
                island.add(islandName);
            }

        }
        return island;
    }

    public ArrayList<String> createCityList(ArrayList<String> arrList) throws IOException {
        ArrayList<String> cityList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String firstWord;
        String[] arr;
        int i = 0;
        while ((firstWord = br.readLine()) != null) {
            arr = firstWord.split("\\s");

            if (Objects.equals(arrList.get(i), arr[0])) {
                cityList.add(arr[1]);
            } else {
                cityList.add("--");
                cityList.add(arr[1]);
                i++;
            }
        }
        br.close();
        return cityList;
    }

    public ArrayList<String> createHouseList(ArrayList<String> arrList) throws IOException {
        ArrayList<String> cityList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String firstWord;
        String[] arr;
        int i = 0;
        while ((firstWord = br.readLine()) != null) {
            arr = firstWord.split("\\s");

            if (Objects.equals(arrList.get(i), arr[0])) {
                cityList.add(arr[2]);
            } else {
                cityList.add("--");
                cityList.add(arr[2]);
                i++;
            }
        }
        br.close();
        return cityList;
    }


    public void findRandomNum(int preSpecifiedNumber, ArrayList<String> readList, ArrayList<String> createCityList, ArrayList<String> createHouseList) {
        ArrayList<Integer> randomList = new ArrayList<>();
        int totalHouseInAnIsland = 0;

        // Calculate the total number of houses in an island
        for (int i = 0; i < createHouseList.size(); i++) {
            if (!createCityList.get(i).equals("--")) {
                totalHouseInAnIsland++;
            }
        }

       // int num = preSpecifiedNumber / readList.size();

        // Ensure there are enough cities for random selection
       // if (num <= totalHouseInAnIsland) {
            // Generate random numbers for the specified number of times
            for (int i = 0; i < preSpecifiedNumber; i++) {
                int maxNum = Integer.parseInt(createHouseList.get(i));
                int randomNum = (int) (Math.random() * (maxNum - 1)) + 1;
                randomList.add(randomNum);
          //  }
        }
        System.out.println("Random house numbers that can be surveyed across different islands are:");

        // Print the random numbers for each island
        for (int i = 0; i < readList.size(); i++) {
            System.out.println("For Island: " + readList.get(i));
            for (int j = 0; j < totalHouseInAnIsland && j < randomList.size(); j++) {
                System.out.println("For city " + createCityList.get(j) + " random house number is: " + randomList.get(j));
            }
        }
    }




    public static void main(String[] args) throws IOException {
        RandomNumGenerator rng = new RandomNumGenerator();
        System.out.println(rng.readList());
        System.out.println(rng.createCityList(rng.readList()));
        System.out.println(rng.createHouseList(rng.readList()));
        System.out.println(rng.readList().size());
        System.out.println("--------------------------");
        //here, pre-specified number refers to the number of cities that you need random house number from.
        rng.findRandomNum(9, rng.readList(), rng.createCityList(rng.readList()),rng.createHouseList(rng.readList()));
    }
}
