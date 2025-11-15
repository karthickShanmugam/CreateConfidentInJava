package com.cmj.yaduInterviewQ.java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Movie {
    private String title;
    private String director;
    private String genre;
    private double rating;
    private int year;

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                ", year=" + year +
                '}';
    }

    public Movie(String title, String director, String genre, double rating, int year) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.rating = rating;
        this.year = year;
    }
    // Getters
    public String getTitle() { return title; }
    public String getDirector() { return director; }
    public String getGenre() { return genre; }
    public double getRating() { return rating; }
    public int getYear() { return year; }
    // Setters
    public void setTitle(String title) { this.title = title; }
    public void setDirector(String director) { this.director = director; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setRating(double rating) { this.rating = rating; }
    public void setYear(int year) { this.year = year; }

    public static void main(String[] a){


        List<Integer> obj3 = Arrays.asList(1,4,6,7,8);

        int result = obj3.stream().reduce(0,(aa,bb)->aa+bb);
        System.out.println(result);

        double data111 = obj3.stream().mapToInt(Integer::intValue).average().orElse(0.0);
       List<Integer> obj4 =  obj3.stream().filter(nn->nn>data111).collect(Collectors.toList());
        obj4.forEach(System.out::println);

        String name = "Karthick Shanmugam";


        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Inception", "Christopher Nolan", "Sci-Fi", 8.8, 2010));
        movies.add(new Movie("Interstellar", "Christopher Nolan", "Sci-Fi", 8.6, 2014));
        movies.add(new Movie("The Dark Knight", "Christopher Nolan", "Action", 9.0, 2008));
        movies.add(new Movie("Pulp Fiction", "Quentin Tarantino", "Crime", 8.9, 1994));
        movies.add(new Movie("Django Unchained", "Quentin Tarantino", "Western", 8.4, 2012));
        movies.add(new Movie("Parasite", "Bong Joon-ho", "Thriller", 8.6, 2019));
        movies.add(new Movie("The Matrix", "Lana Wachowski", "Sci-Fi", 8.7, 1999));
        movies.add(new Movie("The Grand Budapest Hotel", "Wes Anderson", "Comedy", 8.1, 2014));
        movies.add(new Movie("Whiplash", "Damien Chazelle", "Drama", 8.5, 2014));
        movies.add(new Movie("Everything Everywhere All at Once", "Daniel Kwan", "Sci-Fi", 8.1, 2022));

        Map<String, List<Movie>> obj =  movies.stream().collect(Collectors.groupingBy(Movie::getGenre));
        for(String key : obj.keySet()){
            System.out.println("##########Genre#########"+key);
            List<Movie> data = obj.get(key);
            for(Movie d : data){
                System.out.println(d.toString());
            }
        }

        Date date = new Date();
        System.out.println(date.getYear());
        List<Movie> obj1 = movies.stream().filter(m->m.getYear()>date.getYear()-5 && m.getRating()>8).collect(Collectors.toList());
        System.out.println("Movie after 2020");
        for(Movie d : obj1){
            System.out.println(d.toString());
        }
    }

}


