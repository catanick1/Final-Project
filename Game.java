//Final Project - Java
// Calvin Catania, John Trygier, Kayla Nehus, Nigel Burris

//imports
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

//declare instance variable
public class Game implements ActionListener 
{
  JButton enterName;
  JButton nextButton;
  JButton exitButton;
  JButton submitButton;
  JRadioButton optionChoiceA;
  JRadioButton optionChoiceB;
  JRadioButton optionChoiceC;
  JRadioButton optionChoiceD;
  JLabel name, welcome, ask, answer, correctAnswer, totalScore;
  JTextField nameField;
  ButtonGroup group; 

  int score = 0;

  ArrayList <Question> triviaQuestions = new ArrayList<Question>(); 


//Game constructor 
Game(){
String filename;
FileReader myFile;

filename = "trivia.txt";
String question = "", optionA = "", optionB = "", optionC = "", optionD = "", correctAnswer = "", userScore = "";
 
try
{
myFile = new FileReader(filename);
BufferedReader reader = new BufferedReader(myFile);

while (reader.ready())
{
question = reader.readLine();
optionA = reader.readLine();
optionB = reader.readLine();
optionC = reader.readLine();
optionD = reader.readLine();
correctAnswer = reader.readLine();
userScore = reader.readLine();

Question theQuestion = new Question(question, optionA, optionB, optionC, optionD, Integer.parseInt(correctAnswer), Integer.parseInt(userScore));

triviaQuestions.add(theQuestion);
}
reader.close();
}

catch (IOException exception) {
System.out.println("An error occurred: " + exception);}

FileWriter toWriteFile;
try
{
toWriteFile = new FileWriter("score.txt");
BufferedWriter output = new BufferedWriter(toWriteFile);

output.flush();
output.close();
}
catch (IOException excpt)
{
excpt.printStackTrace();
}

try
{
toWriteFile = new FileWriter("score.txt");
BufferedWriter output = new BufferedWriter(toWriteFile);
output.write("player Score =" + userScore);
output.newLine();

output.flush();
output.close();
}
catch (IOException excpt)
{
excpt.printStackTrace();
}

JFrame frame = new JFrame("Bearcat Trivia");
frame.setLayout(new FlowLayout());
frame.setSize(750, 350);


optionChoiceA = new JRadioButton(triviaQuestions.get(0).getOptionA());
optionChoiceB = new JRadioButton(triviaQuestions.get(0).getOptionB());
optionChoiceC = new JRadioButton(triviaQuestions.get(0).getOptionC());
optionChoiceD = new JRadioButton(triviaQuestions.get(0).getOptionD());


group = new ButtonGroup();
group.add(optionChoiceA);
group.add(optionChoiceB);
group.add(optionChoiceC);
group.add(optionChoiceD);

enterName = new JButton("Enter Name");
submitButton = new JButton("Submit Answer");
nextButton = new JButton("Next Question");
exitButton = new JButton("Quit");

enterName.addActionListener(this);
submitButton.addActionListener(this);
nextButton.addActionListener(this);
exitButton.addActionListener(this);

nameField = new JTextField(10);
nameField.setActionCommand("myTF");
nameField.addActionListener(this);

name = new JLabel("Enter your name here: ");

welcome = new JLabel("Welcome to Bearcat Trivia");

totalScore = new JLabel("Total Points: " + score);

ask = new JLabel(triviaQuestions.get(0).getQuestion() + " This question is worth " + userScore + " points.");

answer = new JLabel("");

frame.add(name);
frame.add(nameField);
frame.add(enterName);
frame.add(welcome);
frame.add(totalScore);
frame.add(ask);
frame.add(optionChoiceA);
frame.add(optionChoiceB);
frame.add(optionChoiceC);
frame.add(optionChoiceD);
frame.add(answer);
frame.add(submitButton);
frame.add(nextButton);
frame.add(exitButton);


frame.setVisible(true);
ask.setVisible(false);
welcome.setVisible(false);
totalScore.setVisible(false);
optionChoiceA.setVisible(false);
optionChoiceB.setVisible(false);
optionChoiceC.setVisible(false);
optionChoiceD.setVisible(false);
answer.setVisible(false);
submitButton.setVisible(false);
nextButton.setVisible(false);
}

int i = 0;

/*

@Uses to arraylist to transition to one question to another
@ sets RadioButtons for next question

*/

void NextQuestion(){
if (i < triviaQuestions.size()) {
ask.setText("");
optionChoiceA.setText("");
optionChoiceB.setText("");
optionChoiceC.setText("");
optionChoiceD.setText("");
answer.setText("");
i++;

ask.setText(triviaQuestions.get(i).getQuestion());
optionChoiceA.setText(triviaQuestions.get(i).getOptionA());
optionChoiceB.setText(triviaQuestions.get(i).getOptionB());
optionChoiceC.setText(triviaQuestions.get(i).getOptionC());
optionChoiceD.setText(triviaQuestions.get(i).getOptionD());

System.out.println(triviaQuestions.get(i).getQuestion());
System.out.println(triviaQuestions.get(i).getOptionA());
System.out.println(triviaQuestions.get(i).getOptionB());
System.out.println(triviaQuestions.get(i).getOptionC());
System.out.println(triviaQuestions.get(i).getOptionD());

submitButton.setVisible(true);
}

else {
welcome.setText("GAME OVER");
ask.setVisible(false);
optionChoiceA.setVisible(false);
optionChoiceB.setVisible(false);
optionChoiceC.setVisible(false);
optionChoiceD.setVisible(false);
answer.setVisible(false);
submitButton.setVisible(false);
nextButton.setVisible(false);
exitButton.setVisible(false);

 }

}

/*@ask
Allows functionality to RadioButtons,Labels,textfields and buttons.

*/

public void actionPerformed(ActionEvent ae)
{
int optionA = 1;
int optionB = 2;
int optionC = 3;
int optionD = 4;

 if(ae.getActionCommand().equals("Submit Answer"))
{

 if (optionChoiceA.isSelected() && triviaQuestions.get(i).getCorrectAnswer() == 1)
{
answer.setText("Correct! You earned 5 points");
score += triviaQuestions.get(i).getUserScore();
submitButton.setVisible(false);
nextButton.setVisible(true);
}
else if (optionChoiceB.isSelected() && triviaQuestions.get(i).getCorrectAnswer() == 2)
{
answer.setText("Correct! You earned 5 points");
score += triviaQuestions.get(i).getUserScore();
submitButton.setVisible(false);
nextButton.setVisible(true);
}

 else if(optionChoiceC.isSelected()&& triviaQuestions.get(i).getCorrectAnswer() == 3 )
{
answer.setText("Correct! You earned 5 points");
score += triviaQuestions.get(i).getUserScore();
submitButton.setVisible(false);
nextButton.setVisible(true);
}

 else if (optionChoiceD.isSelected() && triviaQuestions.get(i).getCorrectAnswer() == 4)
{
answer.setText("Correct! You earned 5 points.");
score += triviaQuestions.get(i).getUserScore();
submitButton.setVisible(false);
nextButton.setVisible(true);
}

 else
{
answer.setText("Incorrect! you have earned 0 points.");
submitButton.setVisible(false);
nextButton.setVisible(true);
}

 totalScore.setText("Total Points: " + score);
 
}

else if (ae.getActionCommand().equals("Next Question"))
{

group.clearSelection();

NextQuestion();
triviaQuestions.get(i).getCorrectAnswer();
triviaQuestions.get(i).getUserScore();
name.setVisible(false);
nameField.setVisible(false);
enterName.setVisible(false);
welcome.setVisible(false);
nextButton.setVisible(false);


 }

else if (ae.getActionCommand().equals("Enter Name"))
{

String userName = nameField.getText();
welcome.setText("Welcome to Bearcat Trivia, " + userName + "!" );

name.setVisible(false);
nameField.setVisible(false);
enterName.setVisible(false);
ask.setVisible(true);
welcome.setVisible(true);
totalScore.setVisible(true);
optionChoiceA.setVisible(true);
optionChoiceB.setVisible(true);
optionChoiceC.setVisible(true);
optionChoiceD.setVisible(true);
answer.setVisible(true);
submitButton.setVisible(true);
exitButton.setVisible(true);

}

else if (ae.getActionCommand().equals("Leave Game"))
{
System.exit(0);
}

else
{
answer.setText("Please click submit or continue");
}

}

}