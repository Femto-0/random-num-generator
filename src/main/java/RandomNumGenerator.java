// I decided to make this project when professor Hooks was teaching Complete Randomized Design. She said something along the lines of, " We must assign the test subjects randomly using some
//sort of random number generator not what we think is random" and when I had to collect data myself, the thought of using a random num generator 100 times wasn't very appealing.
//So, I decided to make an app who can give me random num for as many samples as I want in an instance.
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
        ArrayList<String> cityList = new  ArrayList<>();
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


    public void findRandomNum(ArrayList<String> readList, ArrayList<String> createCityList, ArrayList<String> createHouseList) {
        ArrayList<Integer> randomList = new ArrayList<>();
        int totalHouseInAnIsland = 0;

        // Calculate the total number of houses in an island
        for (int i = 0; i < createHouseList.size(); i++) {
            if (!createCityList.get(i).equals("--")) { //this statement is here because I was previously trying to work on multiple islands at the same time and -- separated two islands.
                totalHouseInAnIsland++;
            }
        }

       // int num = preSpecifiedNumber / readList.size();

        // Ensure there are enough cities for random selection
       // if (num <= totalHouseInAnIsland) {
            // Generate random numbers for the specified number of times
            for (int i = 0; i < totalHouseInAnIsland; i++) {
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
        rng.findRandomNum( rng.readList(), rng.createCityList(rng.readList()),rng.createHouseList(rng.readList()));
    }
}
