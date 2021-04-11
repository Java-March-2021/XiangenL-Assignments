package com.xiangen.assignment.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xiangen.assignment.models.Song;
import com.xiangen.assignment.services.SongService;

@Controller
public class SongController {
	@Autowired
	private SongService sService;
	
	// index
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	// dashboard
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		model.addAttribute("songs", this.sService.getAllSong());
		return "dashboard.jsp";
	}
	
	// create new song
	@GetMapping("/songs/new")
	public String addSong(@ModelAttribute("song") Song song) {
		return "add.jsp";
	}
	
	@PostMapping("/songs/new")
	public String addSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if(result.hasErrors()) {
			return "add.jsp";
		}
		this.sService.createSong(song);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/songs/{id}")
	public String showSong(@PathVariable("id") Long id, Model model) {
		model.addAttribute("song", this.sService.getOneSong(id));
		return "show.jsp";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteSong(@PathVariable("id") Long id) {
		this.sService.deleteSong(id);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/songs/search")
	public String searchArtist(@RequestParam("artist") String artist, Model model) {
		model.addAttribute("songs", this.sService.songsContainingArtist(artist));
		model.addAttribute("artist", artist);
		return "search.jsp";
	}
	
	@GetMapping("/search/topTen")
	public String searchTopTen(Model model) {
		model.addAttribute("topTenSongs", this.sService.topTenByRating());
		return "topTen.jsp";
	}
}
