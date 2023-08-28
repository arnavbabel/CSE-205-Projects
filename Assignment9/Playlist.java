//Assignment #: 9
//Name: Arnav Babel
//StudentID: 1225345329
//Lecture: MWF 12:20-1:10 
//Description: Does different tasks involving a song

public class Playlist {
    String name; //name of the song
    Song first; //head of the list
    public Playlist() {
        name = "library";
        first = Song.END;
    }

    public Playlist(String name) {
        this.name = name;
        first = Song.END;
    }

    public String getName() { //gets the name of the song
        return name; //returns the name of the song
    }

    public void add(Song song) { //adds a song to the end of the playlist
        Song tail = first;
        if (first.equals(Song.END)) { //check to see if there are no songs in the playlist
            first = song;
        } 
        else if (first.next.equals(Song.END)) { //checks to see if the second song in the playlist is the end
            first.next = song;
        } else {
            while (!tail.next.next.equals(Song.END)) { //keeps going through the playlist until the end is found
                tail = tail.next;
            }
            tail.next.next = song; //adds the song to the end of the playlist
        }
    }

    public int size() { //calculates the number of songs in a playlist
        Song tail = first;
        int count = 0;
        if (first.equals(Song.END)) { //checks to see if there are no songs in the playlist 
            return count;
        }
        count++; //increments count by 1
        while(!tail.next.equals(Song.END)) { //keeps going through the playlist until the end is found
            tail = tail.next;
            count++; //increments count by 1
        }
        return count; //returns the number of songs in the playlist
    }

    public Song removeFirst() { //removes the first song in the playlist
        Song temp = first;
        if (first.equals(Song.END)) { //checks to see if there are no songs in the playlist
            return Song.END;
        } else { //sets the next song in the playlist to be the first song
            first = first.next; 
        }
        return temp; //returns the removed song
    }
 
    public int remove(Song song) { //removes a song from a playlist
        Song tail = first;
        int index = 1;
        if (first.equals(Song.END)) { //checks to see if there are no songs in the playlist
            return index;
        } else {
            while (!tail.next.equals(Song.END)) { //keeps going through the playlist until the end is found
                if (tail.next.equals(song)) { //checks to see if the next song is the song that is to be removed
                    tail.next = tail.next.next; //moves to the next song
                    return index; //returns the index of the song
                }
                tail = tail.next; //moves to the next song
                index++; //increments index by 1
            }
        }
        return 0; //returns 0 if no song is removed
    }

    public Song head() { //gets the first index of the node
        return first; //returns the first index of the node
    }

    public int getPosition(Song song) { //gets the position of a song in a playlist
        Song tail = first;
        int index = 0;
        if (first.equals(song)) { //checks to see if there are no songs in the playlist
            return index;
        } else {
            while (!tail.next.equals(Song.END)) { //keeps going through the playlist until the song is found
                tail = tail.next; //moves to the next song in the playlist 
                index++; //increments the index by 1
                if (tail.equals(song)) { //if the song is found, return the index of the song
                    return index;
                }
            }
            if (!tail.next.equals(song)) { //if the song is not found, return -1
                return -1;
            }
        }
        return index; //returns the index of the song in the playlist
    }

    public String listSongs() { //lists all songs in a playlist
        Song tail = first;
        String songs = "";

        if (size() == 0) { //checks to see if there are no songs in the playlist
            return "No songs in playlist.";
        }
        else {
            while (!tail.next.equals(Song.END)) { //keeps going through the playlist until the end is found
                songs = songs + tail.toString() + "\n"; //prints the songs in the playlist
                tail = tail.next;
            }
        }

        songs = songs + tail.toString(); //prints the songs
        songs = songs + "\nTotal songs: " + size() + "."; //prints the total number of songs in the playlist
        return songs; //returns the songs in the playlist and the size of the playlist
    }
}
