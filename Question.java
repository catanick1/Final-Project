//Final Project - Java
// Calvin Catania, John Trygier, Kayla Nehus, Nigel Burris

class Question {
  
  //declare instance variables

  public String question;
  public String optionA;
  public String optionB;
  public String optionC;
  public String optionD;
  public int correctAnswer;
  public int score;

// constructor to set parameters

Question(String theQuestion, String aOptionA, String aOptionB, String aOptionC, String aOptionD, int theCorrectAnswer, int theScore) {
  question = theQuestion;
  optionA = aOptionA;
  optionB = aOptionB;
  optionC = aOptionC;
  optionD = aOptionD;
  correctAnswer = theCorrectAnswer;
  score = theScore;
}

//accessor method used to give the user the question and answer options as well as show the score

String getQuestion(){
  return question;
}

String getOptionA(){
  return optionA;
}
String getOptionB(){
  return optionA;
}
String getOptionC(){
  return optionA;
}
String getOptionD(){
  return optionA;
}

int getCorrectAnswer(){
  return correctAnswer;
}

int getScore(){
  return score;
}
}