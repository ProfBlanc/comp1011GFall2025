package filemanipulation;

public class Album {

    private String name;
    private String albumCover;

    public Album(String name, String albumCover) {
        setName(name);
        setAlbumCover(albumCover);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlbumCover() {
        return albumCover;
    }
    /** store the location of the album cover as an image */
    public void setAlbumCover(String albumCover) {
        this.albumCover = albumCover;
    }
}
