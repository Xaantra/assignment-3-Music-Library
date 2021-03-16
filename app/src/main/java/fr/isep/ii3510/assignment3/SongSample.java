package fr.isep.ii3510.assignment3;

public class SongSample {
    private String band;
    private String album;
    private String song;

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    @Override
    public String toString() {
        return "SongSample{" +
                "band='" + band + '\'' +
                ", album='" + album + '\'' +
                ", song='" + song + '\'' +
                '}';
    }
}
