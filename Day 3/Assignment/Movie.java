package com.coforge.day3.assignment;

public class Movie {
	private String movieName;
	private String director;
	private int rating;
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Movie [movieName=" + movieName + ", director=" + director + ", rating=" + rating + "]";
	}
	
	
}
