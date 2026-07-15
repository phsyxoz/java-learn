package inc.lopsys.idk.homework6.task5;

public class Main {
    public static void main(String[] args) {
        HackerNews hn = new HackerNews();
        long[] topStories = hn.hackerNewsTopStories();
        System.out.println(java.util.Arrays.toString(topStories));

        if (topStories.length > 0) {
            String newsTitle = hn.news(topStories);
            System.out.println(newsTitle);
        }
    }
}
