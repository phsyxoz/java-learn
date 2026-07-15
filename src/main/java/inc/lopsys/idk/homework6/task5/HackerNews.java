package inc.lopsys.idk.homework6.task5;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HackerNews {

    private static final HttpClient httpClient = HttpClient.newHttpClient();
    private static final String TOP_STORIES_URL = "https://hacker-news.firebaseio.com/v0/topstories.json";
    private static final String ITEM_URL_TEMPLATE = "https://hacker-news.firebaseio.com/v0/item/%d.json";

    public long[] hackerNewsTopStories() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(TOP_STORIES_URL))
                .GET()
                .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                return new long[0];
            }

            String body = response.body().trim();
            if (!body.startsWith("[") || !body.endsWith("]")) {
                return new long[0];
            }
            body = body.substring(1, body.length() - 1).trim();

            if (body.isEmpty()) {
                return new long[0];
            }

            String[] parts = body.split(",");
            long[] result = new long[parts.length];

            for (int i = 0; i < parts.length; i++) {
                result[i] = Long.parseLong(parts[i].trim());
            }

            return result;

        } catch (Exception e) {
            return new long[0];
        }
    }

    public String news(long[] id) {
        try {
            String itemUrl = String.format(ITEM_URL_TEMPLATE, id);
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(itemUrl))
                .GET()
                .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                return "";
            }

            String body = response.body();
            Pattern pattern = Pattern.compile("\"title\"\\s*:\\s*\"([^\"]*)\"");
            Matcher matcher = pattern.matcher(body);

            if (matcher.find()) {
                return matcher.group(1);
            }

            return "";

        } catch (Exception e) {
            return "";
        }
    }
}
