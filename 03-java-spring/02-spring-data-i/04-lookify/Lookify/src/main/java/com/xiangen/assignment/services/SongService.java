package com.xiangen.assignment.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiangen.assignment.models.Song;
import com.xiangen.assignment.repositories.SongRepository;

@Service
public class SongService {
	@Autowired
	private SongRepository sRepo;
	
	// get all songs
	public List<Song> getAllSong() {
		return this.sRepo.findAll();
	}
	
	// get one song
	public Song getOneSong(Long id) {
		return this.sRepo.findById(id).orElse(null);
	}
	
	// find top 10
	public List<Song> topTenByRating(){
		return this.sRepo.findTop10ByOrderByRatingDesc();
	}
	
	// find artists
	public List<Song> songsContainingArtist(String artist){
		return this.sRepo.findByArtistContaining(artist);
	}
	
	// create song
	public Song createSong(Song newSong) {
		return this.sRepo.save(newSong);
	}
	
	// delete song
	public void deleteSong(Long id) {
		this.sRepo.deleteById(id);
	}
}
