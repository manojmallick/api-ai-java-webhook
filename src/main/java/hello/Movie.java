package hello;

import java.util.List;

public class Movie {
  private String name;
  private String rank;
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
  private boolean isSeriesOver;
  
  public boolean isSeriesOver() {
    return isSeriesOver;
  }
  public void setSeriesOver(boolean isSeriesOver) {
    this.isSeriesOver = isSeriesOver;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public String getRank() {
    return rank;
  }
  public void setRank(String rank) {
    this.rank = rank;
  }
  public String getReleaseDate() {
    return releaseDate;
  }
  public void setReleaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
  }
  public String getCertificate() {
    return certificate;
  }
  public void setCertificate(String certificate) {
    this.certificate = certificate;
  }
  public String getRuntime() {
    return runtime;
  }
  public void setRuntime(String runtime) {
    this.runtime = runtime;
  }
  public List<String> getGenres() {
    return genres;
  }
  public void setGenres(List<String> genres) {
    this.genres = genres;
  }
  public String getRating() {
    return rating;
  }
  public void setRating(String rating) {
    this.rating = rating;
  }
  public String getMetaScrore() {
    return metaScrore;
  }
  public void setMetaScrore(String metaScrore) {
    this.metaScrore = metaScrore;
  }
  public String getDetail() {
    return detail;
  }
  public void setDetail(String detail) {
    this.detail = detail;
  }
  public String getDirector() {
    return director;
  }
  public void setDirector(String director) {
    this.director = director;
  }
  public List<String> getStars() {
    return stars;
  }
  public void setStars(List<String> stars) {
    this.stars = stars;
  }
  public String getVotes() {
    return votes;
  }
  public void setVotes(String votes) {
    this.votes = votes;
  }
  public String getGross() {
    return gross;
  }
  public void setGross(String gross) {
    this.gross = gross;
  }
  public String getImageUrl() {
    return imageUrl;
  }
  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }
  public String getImdbUrl() {
    return imdbUrl;
  }
  public void setImdbUrl(String imdbUrl) {
    this.imdbUrl = imdbUrl;
  }
  
  
  

}
