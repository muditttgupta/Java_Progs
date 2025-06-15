import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.DecimalFormat;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

//Maham
interface Teacher {
    void quizMaking();

    void timer() throws IOException;

    void date();
    public  void edit() throws IOException;
}

interface student extends Teacher{

    void attempt();//with the help of AnsKey[] file name: answerKeyName string of teacher hint use nested for loop

    void dueDateChecker();// compare current date with due date of teacher date function

    // Quiz name, student name, roll no, score section, department
    void StudentInputData();//(Write all data in file) new file for each student(if file exist then only write quiz name and score otherwise take detail also.)

    void viewScore(int score);//view by J option pane 10 points for each

}

class login {
    public login() {
        try {
            File myObj = new File("pass.txt");
            if (myObj.createNewFile()) {
                System.out.println("file created: " + myObj.getName());
                writePassword();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void writePassword() {
        try {
            FileWriter myWriter = new FileWriter("pass.txt");
            Scanner obj = new Scanner(System.in);
            System.out.println("Enter password:");
            String pass = obj.next();
            myWriter.write(pass);
            myWriter.close();
            System.out.println("Successfully password built.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void passwordCheck(String password) {
        try {
            File myObj = new File("pass.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.equals(password)) {
                    System.out.println("Successfully login");
                } else {
                    System.out.println("Incorrect password");
                    System.exit(1);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}

class QuizMaking implements Teacher {
    int h, m, s,StoreScore=0;
    String name;
    String[] q;
    int n;
    String[][] option;
    String[][] option1;
    String AnsKey,d,Id;
    String InputAnsKey;
    String answerKeyName;
    boolean check = true;
    String InputAnsKeyName;

    Scanner obj = new Scanner(System.in);
    String InputStudentData;

    public QuizMaking(String name, int n) {
        this.name = name;
        this.n = n;
        option = new String[n][4];
        q = new String[n];

    }

    public QuizMaking() {
        ListView();
    }//student and teacher
    //for student data view
    public QuizMaking(String Id){
        this.Id=Id;
    }

    public void ListView() {
        try {
            File myObj = new File("List");
            Scanner myReader = new Scanner(myObj);
            System.out.println("Select your quiz from the given category :");
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("Enter Quiz name :");
        String s = obj.next();//working remaining
        File myFile = new File(s);
        if (myFile.exists()) {
            System.out.println("Quiz found...");
            name = s;
            answerKeyName = name + "AnswerKey";
            InputAnsKeyName = "Input" + name + "AnswerKey";
        } else {
            System.out.println("Not Found");
        }
    }
    public void show() throws IOException
    {
        System.out.println("----------Student feedback---------");
        File f = new File(name+"Feedback");
        Scanner myReader = new Scanner(f);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            System.out.println(data);
        }}
    public void fileMaking() {
        try {
            File myObj = new File(name);
            answerKeyName = name + "AnswerKey";
            InputAnsKeyName = "InputAnsKey"+name;
            File MyAnswerKey = new File(answerKeyName);
            File UserAnsKey = new File(InputAnsKeyName);
            File feedback = new File(name+"Feedback");
            File individualQuizAttemptList = new File(name+"Attempt");
            File List = new File("List");
            if (myObj.createNewFile() && MyAnswerKey.createNewFile() && UserAnsKey.createNewFile() && individualQuizAttemptList.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                System.out.println("Answer Key created: " + MyAnswerKey.getName());
                System.out.println("File attempt list created: "+individualQuizAttemptList.getName());
                System.out.println("File feed back created:"+feedback.getName());
                FileWriter fw = new FileWriter(List.getName(), true);
                fw.write(name + "\n");
                fw.close();
            } else {
                System.out.println("Quiz name already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public void QuizWriter(  ) {

        char opt = 'A';
        int i ;
        try {
            FileWriter myWriter = new FileWriter(name);
            FileWriter myAnswerWriter = new FileWriter(answerKeyName);
            for (i=0; i < n; i++) {

                System.out.println("Enter question no:" + (i + 1));

                q[i] = obj.nextLine();
                myWriter.write("Q" + (i + 1) +"\n");
                myWriter.write(q[i]+"\n");
                for (int j = 0; j < 4; j++) {
                    System.out.println("Enter option no:" + (j + 1));
                    option[i][j] = obj.nextLine();
                    myWriter.write(  opt + ": " + option[i][j]+"\n");
                    opt++;
                }

                opt = 'A';
                do {
                    System.out.println("Enter correct option(A-D) :");
                    AnsKey = obj.nextLine();
                    check = AnsKey.equals("A") || AnsKey.equals("B") || AnsKey.equals("C") || AnsKey.equals("D");
                } while (!check);
                myAnswerWriter.write(AnsKey + "\n");
            }
            myWriter.close();
            myAnswerWriter.close();
            System.out.println("Successfully written.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void timer() throws IOException {
        class Time {
            public void setTimer() throws IOException {
                System.out.println("Enter hours :");
                h = obj.nextInt();
                do {
                    System.out.println("Enter minutes :");
                    m = obj.nextInt();
                } while (m >= 60);
                do {
                    System.out.println("Enter seconds :");
                    s = obj.nextInt();
                } while (s >= 60);
                File Time = new File("Timer");
                FileWriter time = new FileWriter(Time.getName(), true);
                time.write("" + name + " " + h + " " + m + " " + s + "\n");
                time.close();
                String TimeFormat = String.format("%02d : %02d : %02d", h, m, s);
                System.out.println("Timer set." + "\r\n---------------  " + TimeFormat + "  -----------------");
            }
        }
        Time t = new Time();
        t.setTimer();
    }

    public void date() {
        class Date {
            int dueMonth, dueDayOfMonth, dueYear;

            public void setDate() {
                try {
                    LocalDateTime current = LocalDateTime.now();

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    String formatted = current.format(formatter);

                    System.out.println("Current Date and Time is: " + formatted);
                    System.out.println("Enter year : ");
                    dueYear = obj.nextInt();
                    System.out.println("Enter month :");
                    dueMonth = obj.nextInt();
                    System.out.println("Enter day of month :");
                    dueDayOfMonth = obj.nextInt();

                    LocalDateTime due = LocalDateTime.of(dueYear, dueMonth, dueDayOfMonth, 23, 59, 59);
                    int check = compareDate(current, due);
                    if (check != 1) {
                        System.out.println("due date < current date" + "\r\nRe-enter date.... ");
                        setDate();
                    } else {
                        File date = new File("DueDate");
                        FileWriter mw = new FileWriter(date.getName(), true);
                        mw.write("" + name + " " + dueYear + " " + dueMonth + " " + dueDayOfMonth + "\n");
                        mw.close();
                    }
                    String format = due.format(formatter);

                    System.out.print("Due date : " + format);

                } catch (DateTimeException | IOException e) {
                    System.out.println(" There are 12 months and 28-30-31 days in a month");
                }
            }
            public int compareDate(LocalDateTime current, LocalDateTime due) {
                return ((due.getYear() == current.getYear()) && (due.getMonthValue() < current.getMonthValue())) ? -1 : (due == current ? 0 : 1);
            }
        }
        Date d = new Date();
        d.setDate();
    }
    @Override
    public void edit() throws IOException {
        int g, k = 0, i ,u;
        String data,q;
        char opt = 'A';
        BufferedReader fr =new BufferedReader(new FileReader(name));
        while((data= fr.readLine())!=null){

            if(data.length()==2 ){
                char store=data.charAt(0);
                if(store=='Q'){
                k=Integer.parseInt(String.valueOf(data.charAt(1)));
                }
            }
        }
        fr.close();
        System.out.println(k+" Questions already exists");
        System.out.println("\nHow many question do you want to add?");
        g = obj.nextInt();
        obj.nextLine();
        option1 = new String[g][4];
        try {
            FileWriter myWriter = new FileWriter(name,true);
            FileWriter myAnswerWriter = new FileWriter(answerKeyName,true);
            for (i=k+1,u=0; i < (k+1+g);u++, i++) {

                System.out.println("Enter question no:" + (i ));
                q = obj.nextLine();
                myWriter.write("Q" + (i) +"\n");
                myWriter.write(q+"\n");
                for (int j = 0; j < 4; j++) {
                    System.out.println("Enter option no:" + (j + 1));
                    option1[u][j] = obj.nextLine();
                    myWriter.write(  opt + ": " + option1[u][j]+"\n");
                    opt++;
                }

                opt = 'A';
                do {
                    System.out.println("Enter correct option(A-D) :");
                    AnsKey = obj.nextLine();
                    check = AnsKey.equals("A") || AnsKey.equals("B") || AnsKey.equals("C") || AnsKey.equals("D");
                } while (!check);
                myAnswerWriter.write(AnsKey + "\n");
            }
            myWriter.close();
            myAnswerWriter.close();
            System.out.println("Successfully written.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void quizMaking() {
        fileMaking();
        QuizWriter();
    }
}

class Student extends QuizMaking {
    String[] store;
    String complete=null;
    int hour, minute, second,i=0;
    public Student(String Id){
        super(Id);
    }
    public Student() throws FileNotFoundException {
        super();
        FileReader fr = new FileReader("Timer");
        Scanner myReader = new Scanner(fr);
        store = new String[5];

        while (myReader.hasNextLine()) {
            String s = myReader.nextLine();
            String[] arrOfStr = s.split(" ");
            int i = 0;
            for (String a : arrOfStr) {
                store[i] = a;
                i++;

            }
            if (store[0].equals(name)) {
                hour = Integer.parseInt(store[1]);
                minute = Integer.parseInt(store[2]);
                second = Integer.parseInt(store[3]);
                System.out.println("hour: " + hour + " minute : " + minute + " second : " + second);
            }

        }
        myReader.close();
    }

    public void InputFunction() {

        try (FileWriter InputAnswerWriter = new FileWriter(InputAnsKeyName,true)) {
            do {
                System.out.println("Enter correct option(A-D) :");
                InputAnsKey = obj.next();
                check = InputAnsKey.equals("A") || InputAnsKey.equals("B") || InputAnsKey.equals("C")
                        || InputAnsKey.equals("D");
            } while (!check);
            InputAnswerWriter.write(InputAnsKey + "\n");
        } catch (IOException ex) {
            System.out.println("Error occur");
        }
    }
    public void attempt() {
        File myObj = new File(name);
        File user = new File(InputAnsKeyName);
        if(!InputAnsKeyName.isEmpty())
        {
            user.delete();//delete file if already contain answers
            try {
                user.createNewFile();
            } catch (IOException e) {
                System.out.println("Error occur");
            }
        }
        int no = 0;// increment Question
        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.equals("Q" + (no + 2))) {
                    InputFunction();
                    no++;
                }
                System.out.println(data);

            }
            myReader.close();
            InputFunction();
            Compare();
        } catch (FileNotFoundException ex) {
            System.out.println("Error occur");
        }
    }

    public void Compare() {

        try (BufferedReader reader1 = new BufferedReader(new FileReader(answerKeyName))) {
            try (BufferedReader reader2 = new BufferedReader(new FileReader(InputAnsKeyName))) {
                String line1 = reader1.readLine();
                String line2 = reader2.readLine();

                while (line1 != null || line2 != null) {
                    if (line1.equalsIgnoreCase(line2)) {
                        i++;
                    }
                    line1 = reader1.readLine();
                    line2 = reader2.readLine();

                }
                System.out.println("Total correct answer :"+i);
                reader1.close();
                viewScore(i);//if student completed before time then display from here
                StudentInputData();
                complete="Done";
            }

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
    public void feedback(){
           try{
        FileWriter o=new FileWriter(name+"Feedback",true);

               FileReader fr = new FileReader(name+"Attempt");
               Scanner myReader = new Scanner(fr);
               store = new String[6];
               while (myReader.hasNextLine()) {
                   String s = myReader.nextLine();
                   String[] arrOfStr = s.split(" ");
                   int i = 0;
                   for (String a : arrOfStr) {
                       store[i] = a;
                       i++;
                   }
               }
               myReader.close();
                   if (store[0].equals(Id)) {
                       obj.nextLine();
                       System.out.println("Enter Feedback");
                       String j=obj.nextLine();
                       o.write("ROLL NO:"+Id+"  FEEDBACK:"+j+"\n");
                       o.close();
                       System.out.println("Thanks for submitting feedback");
                   }
                   else{
                       System.out.println("You have not attempted that quiz");
                   }

           }
           catch (IOException e){
               System.out.println("Error occur");
           }
    }
    public void StudentInputData()
    {
        String department;
        String Name;
        String Section;
        String splitter;
        String[] word ;
        boolean condition = false;
        boolean find = false;
        char var;
        do {
            System.out.println("Enter your ID sample(K216578):");
            Id = obj.next();
            var = Id.charAt(0);
            System.out.println("Enter your Name :");
            Name = obj.next();
            System.out.println("Enter your department :");
            department = obj.next();
            System.out.println("Enter your section :");
            Section = obj.next();
            if (Id.length() == 7 && var == 'K') {
                try {
                    condition = true;
                    InputStudentData = "StudentData" + "_" + Id;// take id from user in view class
                    File f = new File(InputStudentData);
                    if (!f.exists()) {// check if student is new user
                        f.createNewFile();
                        System.out.println("File is created: " + f.getName());
                        FileWriter StudentDataWriter = new FileWriter(InputStudentData);
                        StudentDataWriter.write(Id + " " + Name + " " + department + " " + Section);
                        StudentDataWriter.write("\n" + name + "    " + StoreScore);
                        StudentDataWriter.close();
                        FileWriter individualQuizAttemptListWriter = new FileWriter(name + "Attempt",true);
                        individualQuizAttemptListWriter.write("" + Id + " " + Name + " " + Section + " " + department + " " + StoreScore + "\n");
                        individualQuizAttemptListWriter.close();
                        System.out.println("Successfully wrote to the file.");
                    } else {
                        System.out.println("File already exists.");
                        BufferedReader reader = new BufferedReader(new FileReader(name + "Attempt"));
                        while ((splitter = reader.readLine()) != null) {
                            word = splitter.split(" ");// to check if student has already attempted
                            for (String input : word) {
                                if (input.equals(Id)) {
                                    find = true;
                                }
                            }

                        }
                        if (!find) {
                            FileWriter StudentDataWriter = new FileWriter(InputStudentData, true);
                            StudentDataWriter.write("\n" + name + "    " + StoreScore);
                            FileWriter individualQuizAttemptListWriter = new FileWriter(name + "Attempt",true);
                            individualQuizAttemptListWriter.write("" + Id + " " + name + " " + Section + " " + department + " " + StoreScore + "\n");
                            individualQuizAttemptListWriter.close();
                            StudentDataWriter.close();
                            System.out.println("Successfully wrote to the file.");

                        } else {
                            System.out.println("Access denied you have already attempted");
                        }
                    }
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }

            } else {
                condition = false;
                System.out.println("Wrong input, Re-enter information.... ");
            }
        }while(!condition);

    }

    public void timerDisplay() throws IOException {
        class displayTimer {
            JFrame display;
            JLabel counterLabel;
            Timer timer;
            final DecimalFormat df = new DecimalFormat("00");

            public void GUI() throws IOException {

                display = new JFrame("Timer");//Window
                display.setSize(400, 200);
                display.setLayout(null);
                counterLabel = new JLabel();
                counterLabel.setForeground(Color.green);
                counterLabel.setFont(new Font("Serif", Font.BOLD, 28));
                counterLabel.setBounds(100, 100, 200, 50);
                counterLabel.setHorizontalAlignment(JLabel.CENTER);//Alignment of text on window
                display.add(counterLabel);
                display.setVisible(true);
                TimerFunction();
                timer.start();

            }

            public void TimerFunction() {
                //delay = 1000 because one 1 second=1000 milliseconds
                //delay and task,where task=new ActionListener() {};
                timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        second--;
                        counterLabel.setText(" " + df.format(hour) + " : " + df.format(minute) + " : " + df.format(second));
                        if (hour == 0 && minute == 0 && second == 0) {
                            timer.stop();
                            if(complete == null)
                            {
                                viewScore(i);
                                StudentInputData();
                            }
                            display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        }
                        if (second == -1) {
                            second = 59;
                            minute--;
                            counterLabel.setText(" " + df.format(hour) + " : " + df.format(minute) + " : " + df.format(second));
                        }
                        if (minute == -1) {
                            minute = 59;
                            hour--;
                            counterLabel.setText(" " + df.format(hour) + " : " + df.format(minute) + " : " + df.format(second));
                        }

                    }
                });

            }
        }
        displayTimer dt = new displayTimer();
        dt.GUI();
    }

    public boolean dueDateChecker() throws IOException {
        String[] store1;
        int Year1=0,Month1 = 0,DayOfMonth1 = 0;
        try {
            FileReader FReader = new FileReader("DueDate");
            Scanner myReader = new Scanner(FReader);
            store1 = new String[5];

            while (myReader.hasNextLine()) {
                String s1 = myReader.nextLine();
                String[] arrOfStr1 = s1.split(" ");
                int j = 0;
                for (String a1 : arrOfStr1) {
                    store1[j] = a1;
                    j++;
                }
                if (store1[0].equals(name)) {
                    Year1 = Integer.parseInt(store1[1]);
                    Month1 = Integer.parseInt(store1[2]);
                    DayOfMonth1 = Integer.parseInt(store1[3]);
                }
            }
            FReader.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        LocalDateTime current = LocalDateTime.now();

        if ((DayOfMonth1 == current.getDayOfMonth()) && (Month1 == current.getMonthValue()) && (Year1 == current.getYear())&&current.getHour()==23 && current.getMinute()==59) {
            System.out.println("You can't attempt the quiz");
            return false;
        } else {
            System.out.println("You can attempt the quiz");
            return true;
        }
    }


    public void viewScore(int score) {
        StoreScore=score*10;
        System.out.println("Your score :"+StoreScore);
    }
}
class View extends Student{

    public View(){
        super("------ view detail ------");
    }
    public View(String Id){
        super(Id);
    }
    public void teacher_view(){
        try {
            String Teacherfilename = name + "attempt";
            BufferedReader br = new BufferedReader(new FileReader(Teacherfilename));
            System.out.println("Id  department  Name  Section");
            while ((d = br.readLine()) != null)
            {
                System.out.println(d);
            }
        }
        catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void Student_view() {
        try
        {
            String getInputStudentData = "StudentData" + "_" + Id;
            File file = new File(getInputStudentData);
            BufferedReader myfile = new BufferedReader(new FileReader(getInputStudentData));
            if (file.exists())
            {
                System.out.println("Id  department  Name  Section");
                String d;
                while ((d = myfile.readLine()) != null)
                {
                    System.out.println(d);
                }
            }
            else
            {
                System.out.println("Not found ! Try another keyword.");
            }
        }
        catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
public class Quiz {
    public static void main(String[] args) throws IOException {
        Scanner obj = new Scanner(System.in);
        login l = new login();
        System.out.println("Enter username :");
        String userName = obj.next();
        System.out.println("Enter password :");
        String password = obj.next();
        l.passwordCheck(password);
        boolean cont ;
        if (userName.equals("Teacher")) {
            do {
            System.out.println("What do you want to do?\n1.Create quiz\n2.Edit quiz\n3.view students who have attempted\n4.View Feedback\n3.Exit");
            int j=obj.nextInt();
            String name;
            int n;


                switch (j) {
                    case 1:
                        System.out.println("ENTER NAME OF QUIZ");
                        name = obj.next();
                        System.out.println("Enter total no questions :");
                        n = obj.nextInt();
                        QuizMaking q = new QuizMaking(name, n);
                        q.quizMaking();
                        q.timer();
                        q.date();
                        break;

                    case 2:

                        QuizMaking q1 = new QuizMaking();
                        q1.edit();
                        break;
                    case 3:
                        View v = new View();
                        v.teacher_view();
                        break;
                    case 4:
                        QuizMaking q2 = new QuizMaking();
                        q2.show();
                    case 5:
                        System.exit(1);
                    default:
                        System.out.println("Please select from given option");
                }
                System.out.println("Do you wan to continue(true,false)?");
                cont = obj.nextBoolean();
            }while(cont);
        } else if (userName.equals("Student")) {
            do {
                System.out.println("What do you want to do?\n1.Attempt quiz\n2.View attempt history\n3.view feedback\n4.Send feedback\n5.Exit");
                int j = obj.nextInt();
                switch (j) {
                    case 1:

                        Student s = new Student();
                        boolean result=s.dueDateChecker();
                        if(result)
                        {
                            s.timerDisplay();
                            s.attempt();
                        }
                        break;

                    case 2:
                        System.out.println("Enter your Id(Sample: K213839) :");
                        String id = obj.next();
                        View v = new View(id);
                        v.Student_view();
                        break;

                    case 3:
                        QuizMaking q3 = new QuizMaking();
                        q3.show();
                        break;
                    case 4:
                        System.out.println("Enter your Id(Sample: K213839) :");
                        id = obj.next();
                        Student s1 = new Student(id);
                        s1.ListView();
                        s1.feedback();
                        break;
                    case 5:
                        System.exit(1);

                    default:
                        System.out.println("Please select from given option");
                }
                System.out.println("\n");
                System.out.println("Do you wan to continue(true,false)?");
                cont = obj.nextBoolean();
            } while (cont);
        }
        else {
            System.out.println("Only Teacher and student available");
        }
    }
    }


