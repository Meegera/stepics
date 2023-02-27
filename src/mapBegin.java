import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class mapBegin {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        String searchKey = "xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxx";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название здания:");
        String name = scanner.nextLine().replace(" ", "+");

        HttpRequest request = HttpRequest.newBuilder().uri(new URI("https://search-maps.yandex.ru/v1/?type=biz&lang=ru_RU&apikey=" + searchKey + "&text=" + name)).GET().build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject jo = new JSONObject(response.body());
        JSONArray ja = (JSONArray) jo.get("features");

        System.out.println("Резултаты поиска:");

        if (ja.length() == 0) {
            System.out.println("404 not found");
        }
        else {
            int counter = 1;
            for (Object o : ja) {
                JSONObject properties = ((JSONObject) o).getJSONObject("properties").getJSONObject("CompanyMetaData");
                System.out.println(counter++ + ": " + properties.get("address"));
            }
        }
    }
}
