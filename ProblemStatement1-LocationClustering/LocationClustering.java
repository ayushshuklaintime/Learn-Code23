import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LocationClustering {
    public static void main(String[] args) {
        List<clusterWithLatitude> locations = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("world_country_and_usa_states_latitude_and_longitude_values.csv"))) {
            String line;
            boolean skipFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (skipFirstLine) {
                    skipFirstLine = false;
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0].trim();
                    double latitude = Double.parseDouble(parts[1].trim());
                    double longitude = Double.parseDouble(parts[2].trim());
                    locations.add(new clusterWithLatitude(name, latitude, longitude));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        int clusterCount = 0;
        for (int i = 0; i < locations.size(); i++) {
            if (locations.get(i).cluster == -1) {
                locations.get(i).cluster = clusterCount++;
                for (int j = i + 1; j < locations.size(); j++) {
                    clusterWithLatitude location1 = locations.get(i);
                    clusterWithLatitude location2 = locations.get(j);
                    double distance = Math.abs(location1.latitude - location2.latitude);
                    if (distance <= 10.0) {
                        location2.cluster = location1.cluster;
                    }
                }
            }
        }
        
        List<List<String>> clusters = new ArrayList<>();
        for (int i = 0; i < clusterCount; i++) {
            clusters.add(new ArrayList<>());
        }

        for (int i = 0; i < locations.size(); i++) {
            clusterWithLatitude location = locations.get(i);
            int clusterNumber = location.cluster;
            String locationName = location.name;
        
            for (int j = 0; j < clusters.size(); j++) {
                if (j == clusterNumber) {
                    clusters.get(j).add(locationName);
                }
            }
        }

        for (int i = 0; i < clusterCount; i++) {
            System.out.println("Cluster " + (i + 1) + ": " + clusters.get(i));
        }
    }
}