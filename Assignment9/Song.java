//Assignment #: 9
//Name: Arnav Babel
//StudentID: 1225345329
//Lecture: MWF 12:20-1:10 
//Description: Represents a song and artist in a playlist

public class Song {
    String title; //name of the song
    String artist; //name of the artist who created the song
    Song next; //reference to the next song in the playlist
    public static final Song END = new Song();

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
        next = END; //end of the linked list
    }

    // This is used to construct the END Table.
    private Song() {
        title = "";
        artist = "";
        next = this;
    }

    public boolean equals(Song other) {
        if (this.title.equals(other.title) 
         && this.artist.equals(other.artist))
            return true;
        return false;
    }

    public String toString() {
        return "Title: " + title + "\tArtist: " + artist;
    }
}
