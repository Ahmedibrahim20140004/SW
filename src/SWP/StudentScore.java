package SWP;

import java.util.ArrayList;

public class StudentScore {
    String StudentUsername;
    String gameName;
    int score;
     void checkStudentScore(StudentScore Sscore,ArrayList<StudentScore>Sscorelist)
    {
        boolean found = false;
        for(int i=0 ; i<Sscorelist.size() ; i++)
        {
            if(Sscorelist.get(i).StudentUsername.equals(Sscore.StudentUsername) && Sscorelist.get(i).gameName.equals(Sscore.gameName))
            {
                Sscorelist.get(i).score += Sscore.score;
                found = true;
                System.out.println(" Your Final Score is " + Sscorelist.get(i).score);
            }
        }
        if(found==false)
        {
            Sscorelist.add(Sscore);
            System.out.println(" Your Final Score is " + Sscore.score);
        }
        
    }
}

	
	


