package hello;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class BasicWebCrawler {

    private HashSet<String> links;

    public BasicWebCrawler() {
        links = new HashSet<String>();
    }

    public List<Movie> getPageLinks(String URL) {
        //4. Check if you have already crawled the URLs 
        //(we are intentionally not checking for duplicate content in this example)
        List<Movie> movies=new ArrayList<Movie>();
        if (!links.contains(URL)) {
            try {
                //4. (i) If not add it to the index
                if (links.add(URL)) {
                    System.out.println(URL);
                }

                //2. Fetch the HTML code
                /*
                 *
                 * private String name;
  private int rank;
  private String releaseDate;
  private String certificate;
  private String runtime;
  private List<String> genres;//list of string
  private String rating;
  private String metaScrore;
  private String detail;
  private String director;
  private List<String> stars;//list of string
  private String votes;
  private String gross;
  private String imageUrl;
  private String imdbUrl;
                 */
                Document document = Jsoup.connect(URL).get();

                Elements element=document.getElementsByClass("lister-list").get(0).select("div.lister-item.mode-advanced");
                for (Element element2 : element) {
                    Movie movie = new Movie();

                    String name = element2.select("h3.lister-item-header > a").get(0).text();
                    String rank = element2.select("h3.lister-item-header > span.lister-item-index").get(0).text();
                    System.out.println("movie" + rank);
                    String releaseDate = element2.select("h3.lister-item-header > span.lister-item-year").get(0).text();
                    String certificate = element2.select("p.text-muted  > span.certificate").get(0).text();
                    String runTime = element2.select("p.text-muted  > span.runtime").get(0).text();
                    String[] genre = element2.select("p.text-muted  >  span.genre").get(0).text().split(",");
                    List<String> genres = Arrays.asList(genre);
                    String rating = element2.select("div.ratings-bar  >  div.inline-block.ratings-imdb-rating>strong").get(0).text();//ratings-bar
                    String metaScrore="NA";
                    System.out.println("ele"+element2.select("div.ratings-bar  >  div.inline-block.ratings-metascore >span"));
                    if (element2.select("div.ratings-bar  >  div.inline-block.ratings-metascore >span") != null&&!element2.select("div.ratings-bar  >  div.inline-block.ratings-metascore >span").isEmpty()){
                         metaScrore = element2.select("div.ratings-bar  >  div.inline-block.ratings-metascore >span").get(0).text();//ratings-bar
                        }
                    String detail=element2.select("p.text-muted").get(1).text();
                    String directorString=element2.select("p.text-muted").get(1).nextElementSibling().text();
                    String director="";
                    String[] actor={};
                    try {
                         director = directorString.split("Director:")[1].trim().split("\\| Stars:")[0].trim();
                         actor = directorString.split("Stars:")[1].trim().split(",");
                    }catch (Exception e){
                        System.out.println("excpetion"+e);
                        director = directorString.split("Directors:")[1].trim().split("\\| Stars:")[0].trim();
                        actor = directorString.split("Stars:")[1].trim().split(",");
                    }
                    List<String> actors = Arrays.asList(actor);
                    String votes=element2.select("p.sort-num_votes-visible  > span").get(1).text();
                    String gross="NA";
                    if(element2.select("p.sort-num_votes-visible  > span").size()>4) {
                         gross = element2.select("p.sort-num_votes-visible  > span").get(4).text();
                    }
                    movie.setName(name);
                    movie.setRank(rank);
                    movie.setReleaseDate(releaseDate);
                    movie.setCertificate(certificate);
                    movie.setRuntime(runTime);
                    movie.setGenres(genres);
                    movie.setRating(rating);
                    movie.setMetaScrore(metaScrore);
                    movie.setDetail(detail);
                    movie.setDirector(director);
                    movie.setStars(actors);
                    movie.setVotes(votes);
                    movie.setGross(gross);
                    movies.add(movie);
                  
                  
                }


                //5. For each extracted URL... go back to Step 4.
//                for (Element page : linksOnPage) {
//                    getPageLinks(page.attr("abs:href"));
//                }
            } catch (IOException e) {
                System.err.println("For '" + URL + "': " + e.getMessage());
            }
        }
        return movies;
    }

//    public static void main(String[] args) {
//        //1. Pick a URL from the frontier
//        new BasicWebCrawler().getPageLinks("https://www.imdb.com/search/title?genres=action&title_type=tv_series,mini_series&num_votes=5000,&pf_rd_m=A2FGELUUNOQJNL&pf_rd_p=f85d9bf4-1542-48d1-a7f9-48ac82dd85e7&pf_rd_r=A0JPBTT80DWQCR5V72K3&pf_rd_s=right-6&pf_rd_t=15506&pf_rd_i=toptv&sort=user_rating,desc&ref_=chttvtp_gnr_1");
//    }

}