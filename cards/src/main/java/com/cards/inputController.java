/**
 * 
 */
package com.cards;




import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Grahut
 *
 */
@Controller
public class inputController {

		private Simulate sim;
		@RequestMapping("/")
		public String index() {
			return "home";
		}
		
		
		@RequestMapping("/displayInfo")
		
		public ModelAndView Home(String name) 
		{
			ModelAndView mv = new ModelAndView();
			int numberOfPlayers = Integer.parseInt(name);
			sim = new Simulate(numberOfPlayers);
			
		
			mv.addObject("hands", sim.getHands());
			mv.addObject("numberOfPlayers", Simulate.getPlayerPosition().length);
			mv.addObject("name", name);
			mv.setViewName("display");
			
			return mv;
		}
		
		@RequestMapping("/analyze")
		public ModelAndView report() {
			ModelAndView mv = new ModelAndView();
			Hands hands = sim.getHands();
			
			int[][] ranks = Simulate.getPlayerPosition();
			
//			for(int i = 0; i < ranks.length;i++) {
//				System.out.println("The Rank of player position " + ranks[i][1] + " is = " +  ranks[i][0]);
//			}
			mv.addObject("numberOfPlayers", ranks.length);
			mv.addObject("ranks", ranks);
			mv.addObject("winner", ranks[0][1]);
			mv.addObject("hands", hands);
			mv.setViewName("handReports");
			
			return mv;
			
		}
		
		@RequestMapping("/playAgain")
		public String playAgain() {
			return "home";
		}
		
}
