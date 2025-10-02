package filemanipulation;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.net.URLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;


public class Week4 {

    public static void main(String[] args) {
        try {
            getAlbumDetails();
            //createPlaylist();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void createPlaylist(){

        Song s1 = new Song(
                new Album("Path of Pain", "test1"),
                "Happy Birthday Song",
                "Cool Guy",
                "Pop"
        );

        Song s2 = new Song(
                new Album("Kids Songs ", "test2"),
                "Mary Had A Little Lamb",
                "Cool Girl",
                "Children Songs"
        );

        ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(s1);
        songs.add(s2);

        TreeMap<String,Song> playlist = new TreeMap<>();
        TreeSet<Song> playlist2 = new TreeSet<>();

        TreeMap<String, TreeSet<Song>> playlist3 = new TreeMap<>();



        for(Song song : songs){
            playlist.put(song.getGenre(), song);
            playlist2.add(song);
        }

        for(String genre : playlist.keySet()){
            playlist3.put(genre, new TreeSet<>(playlist.values()));
        }


        //create 4 other songs
        //create a TreeSet object named playlist

        // add 5 songs to playlist
        //generate toString() and hashCode() to Song class






    }

    public static void getAlbumDetails()throws Exception {

        Console console = System.console();
        System.out.println("Enter the name of the album: ");
        String albumName = console.readLine();
        System.out.println("Enter the URL of the album cover: ");
        String albumCover = console.readLine();

        Path rootPath = Path.of("src", "filemanipulation");
        rootPath = rootPath.resolve(albumName);
        System.out.println(rootPath.toFile().exists());

        if(Files.notExists(rootPath)){
            Files.createDirectory(rootPath);
        }

        System.out.println("The url image inputted was: " + albumCover);

        Path albumCoverPath = rootPath.resolve( "album_cover.jpg");
        saveUrlAsImage(albumCover, albumCoverPath);


    }

    public static void saveUrlAsImage(String url, Path saveLocation) throws Exception {


        URL target = URI.create(url).toURL();



        InputStream in = target.openConnection().getInputStream();
        OutputStream out = Files.newOutputStream(saveLocation);

        byte[] buffer = new byte[1024];
        int iteration = 0;
        int bytesRead;

        while ((bytesRead = in.read(buffer)) != -1) {
            System.out.println("Iteration: " + (++iteration));
            out.write(buffer, 0, bytesRead);
        }
        out.flush();
        out.close();
        in.close();

    }
}
