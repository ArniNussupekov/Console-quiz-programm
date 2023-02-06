import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;


public class Quiz {
    private String name;
    private ArrayList<Question> questions;

        Quiz(){
              questions = new ArrayList<>();
        }
           public void setName(String name){
            this.name = name;
           }
           public String getName(){
            return name;
           }
           public void addQuestion(Question question){
            questions.add(question);
           }



           public static Quiz loadFromFile(String fileName) throws InvalidQuizFormatException{
              Quiz tQuiz = new Quiz();
              Scanner input = null;
              ArrayList<ArrayList<String>> questionz = new ArrayList<>();

               try{
                   File file = new File(fileName);
                   if (file.exists()) {
                       input = new Scanner(file);
                       String namef = "";
                     for (int i = 0; i < fileName.length()-4; i++){
                         namef += fileName.charAt(i);
                     }
                       tQuiz.setName(namef);
                   }
                   else
                       throw new InvalidQuizFormatException();
               }
               catch (InvalidQuizFormatException ex){
                  ex.printException();
               } catch (FileNotFoundException e) {
                   e.printStackTrace();
               }

           while (input.hasNext()){
               ArrayList<String> questiont = new ArrayList<>();
               boolean newQ = false;
                while (!newQ && input.hasNext()){
                    String c = input.nextLine();
                    if (!c.equals("")){
                        questiont.add(c);
                    }
                    else
                        newQ = true;
                }
               questionz.add(questiont);
           }

               for (int i = 0; i < questionz.size(); i++){
                   if (questionz.get(i).size() == 2){
                       FillIn fillin = new FillIn();
                       fillin.setDescription(questionz.get(i).get(0));
                       fillin.setAnswer(questionz.get(i).get(1));
                       tQuiz.addQuestion(fillin);
                   }
                   else {
                       Test test = new Test();
                       test.setDescription(questionz.get(i).get(0));
                       test.setAnswer(questionz.get(i).get(1));
                       questionz.get(i).remove(0);
                       Collections.shuffle(questionz.get(i));
                         String[] options = new String[questionz.get(i).size()];
                         test.setOptions(questionz.get(i).toArray(options));
                         tQuiz.addQuestion(test);
                   }
               }

               System.out.println(tQuiz);
               return tQuiz;
           }



           public String toString(){
               return "Welcome! " + name;
           }

               public void start(){
                   Scanner in = new Scanner(System.in);
                   int correctAnswer = 0;

                    for (int i = 0; i < questions.size(); i++){
                        System.out.println(questions.get(i).getDescription());
                         if (questions.get(i) instanceof Test){
                             System.out.println(questions.get(i));
                             System.out.print("Type your answer here: ");
                             String urAns = in.nextLine();

                           while (true){
                               if ((urAns.charAt(0) == 'A' || urAns.charAt(0) == 'B' || urAns.charAt(0) == 'C' || urAns.charAt(0) == 'D') || urAns.length()>1) {break;}
                               else {
                                   System.out.print("Invalid choice! Try again (Ex: A, B, ...) ");
                                   urAns = in.nextLine();
                               }
                           }


                                 if (((Test) questions.get(i)).getCorrectIndex(urAns.charAt(0))) {
                                     System.out.println("Correct!");
                                     correctAnswer++;
                                 } else {
                                     System.out.println("Incorrect!");
                                 }
                         }
                         else{
                             System.out.print("Write your answer here: ");
                             String urAns = in.nextLine();
                             if (questions.get(i).getAnswer().equals(urAns)){
                                 System.out.println("Correct!");
                                 correctAnswer++;
                             }
                             else {
                                 System.out.println("Incorrect!");
                             }
                         }
                    }

                   System.out.println("Correct answers: " + correctAnswer + "/"+ questions.size() + "("+(int)((correctAnswer*100.0f)/questions.size())+"%)");
               }
}
