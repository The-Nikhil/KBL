package com.nikhilkanyal.kbl;

/**
 * Created by Nikhil kanyal.
 */

public class questions {
    public String mQuestions[]={
            "which is the first planet in our solar system?",
            "which is the second planet in our solar system?",
            "which is the third planet in our solar system?",
            "which is the fourth planet in our solar system?",
            "which is the fifth planet in our solar system?"

    };

    private String mChoice[][]={
            {"mercury","venus","earth","mars"},
            {"venus","mercury","earth","Pluto"},
            {"mercury","venus","earth","mars"},
            {"mercury","venus","earth","mars"},
            {"mercury","venus","earth","jupyter"}


    };
    private String mCorrectAnswers[]={"mercury","venus","earth","mars","jupyter"};

    public String getQuestion(int a) {
        String question =mQuestions[a];
        return question;
    }
    public String getChoice1(int a){
        String choice=mChoice[a][0];
        return choice;
    }
    public String getChoice2(int a){
        String choice=mChoice[a][1];
        return choice;
    }
    public String getChoice3(int a){
        String choice=mChoice[a][2];
        return choice;
    }
    public String getChoice4(int a){
        String choice=mChoice[a][3];
        return choice;
    }

    public String getCorrectAnswer(int a){
        String answer=mCorrectAnswers[a];
        return answer;
    }
}
