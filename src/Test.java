import java.util.ArrayList;

class Test extends Question{
    private int numOfOptions = 4;
    private String options[] = new String[numOfOptions];
    private ArrayList<Character> labels = new ArrayList<>();
    private int correctIndex;

      Test(){
          labels.add('A');
          labels.add('B');
          labels.add('C');
          labels.add('D');
      }

        public void setOptions(String[] options){
          this.options = options;
        }
        public String getOptionAt(int index){
          return options[index];
        }

   public boolean getCorrectIndex(Character ch){
            if (labels.indexOf(ch) == correctIndex){
          return true;}
            return false;
   }

    public String toString() {
        String result = "";
          for (int i = 0; i < labels.size(); i++){
            result += labels.get(i)+ " ";
            result += getOptionAt(i)+ "\n";
            if (getOptionAt(i) == getAnswer()){
                correctIndex = i;
            }
         }
          return result;
    }
}
