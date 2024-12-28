import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class dayOne {

    public static void main(String[] args) {
        try (
            BufferedReader br = new BufferedReader(
                new FileReader("./dayone.txt")
            )
        ) {
            String row;
            ArrayList<Integer> cols1 = new ArrayList<>();
            ArrayList<Integer> cols2 = new ArrayList<>();
            while ((row = br.readLine()) != null) {
                String[] cols = row.split("\\s+");
                cols1.add(Integer.parseInt(cols[0]));
                cols2.add(Integer.parseInt(cols[1])); // add the second column to the list
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
