package filemanipulation;

public class Song {

    private Album album;
    private String title, artist, genre;

    public Song(Album album, String title, String artist, String genre) {
        setAlbum(album);
        setTitle(title);
        setArtist(artist);
        setGenre(genre);
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
