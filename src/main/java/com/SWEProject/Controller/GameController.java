package com.SWEProject.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.SWEProject.Entities.Course;
import com.SWEProject.Entities.Game;
import com.SWEProject.Entities.Question;
import com.SWEProject.model.CourseDB;
import com.SWEProject.model.GameDB;

@Controller
public class GameController {
	GameDB gamedb = new GameDB();
	int score = 0, next = 0;
	List<Question> questions = new ArrayList<Question>();

	@RequestMapping("/chose")
	public String ayhaga(Model model) {

		CourseDB x = new CourseDB();
		List<Course> arr = new ArrayList<Course>();
		arr = x.ShowCoursesDB();
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i).getCourseID());
			System.out.println(arr.get(i).getCourseName());
			System.out.println(arr.get(i).getCourseDuration());
			System.out.println(arr.get(i).getCourseDescription());

		}
		model.addAttribute("courses", arr);

		return "chosecourse";
	}

	@RequestMapping("/chosegame")
	public String playgame(Model model, @RequestParam("coursename") String coursename) {
		try {

			model.addAttribute("games", gamedb.ShowGamesDB(coursename));

			return "chossegame";
		} catch (Exception e) {
			return "chosecourse";
		}

	}

	@RequestMapping("/game")
	public String play1(Model model, @RequestParam("gamename") String gamename) {
		questions = gamedb.ShowQuestions(gamename);
		model.addAttribute("Game", questions.get(0));

		return "playgame";

	}

	@RequestMapping("/question")
	public String play(Model model, @RequestParam("a") String selected) {
		if (selected.equals(questions.get(next).getResult())) {

			score++;
		}
		next++;
		if (next >= questions.size()) {
			System.out.println(score);
			model.addAttribute("score", score);
			score = 0;
			return "score";
		}
		System.out.println(questions.get(next).getQuestion());
		model.addAttribute("Game", questions.get(next));

		return "playgame";

	}

	@GetMapping("/GamePage")
	public String GamePage(Model model) {
		model.addAttribute("Game", new Game());
		// ModelAndView mv=new ModelAndView();
		// mv.setViewName("new");
		return "GamePage";
	}

	@PostMapping("/GamePage")
	public String CreateGame(Model model, @ModelAttribute Game Game) {

		GameDB x = new GameDB();
		boolean str = x.CreateGameDB(Game, Game.getCourseName());
		System.out.println(str);
		model.addAttribute("Game", new Game());
		return "GamePage";
	}

	@GetMapping("/ShowGame")
	public String ShowGamePage(Model model) {
		model.addAttribute("Game", new Game());
		// ModelAndView mv=new ModelAndView();
		// mv.setViewName("new");
		return "ShowGame";
	}

	@PostMapping("/ShowGame")
	public String ShowGame(Model model, @RequestParam("CourseName") String CourseName) {

		GameDB x = new GameDB();
		List<Game> arr = new ArrayList<Game>();
		model.addAttribute("games", gamedb.ShowGamesDB(CourseName));

		
//		for (int i = 0; i < arr.size(); i++) {
//			System.out.println(arr.get(i).getGameID());
//			System.out.println(arr.get(i).getGameName());
//			System.out.println(arr.get(i).getGameType());
//
//		}
		model.addAttribute("Game", arr);

		return null;
	}

	@GetMapping("/QuestionPage")
	public String QuestionPage(Model model) {
		model.addAttribute("Question", new Question());
		// ModelAndView mv=new ModelAndView();
		// mv.setViewName("new");
		return "QuestionPage";
	}

	@PostMapping("/QuestionPage")
	public String CreateQuestion(Model model, @ModelAttribute Question Question) {

		GameDB x = new GameDB();
		x.CreateQuestionDB(Question, Question.getGameName1());

		model.addAttribute("Question", new Question());
		return null;
	}

}
