
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author My session
 */
@ManagedBean(name="CompteBean")
@SessionScoped 
public class CompteBean {
    
    private final List <Student> listOfStudent;

    public CompteBean() {
        listOfStudent = new ArrayList<>();
        Student student=new Student();
        student.setName("Firas Jerbi");
        student.setRollNo("22154");
        student.setImagePath("images/firas.jpg");
        
        List <Paper> listOfSemesterPaper= new ArrayList<>();
        listOfSemesterPaper.add(new Paper("Sécurité",9.5));
        listOfSemesterPaper.add(new Paper("Architecture",12));
        listOfSemesterPaper.add(new Paper("IHM",11));
        listOfSemesterPaper.add(new Paper("ABDD",8.75));
        listOfSemesterPaper.add(new Paper("Optimisation",6));
        listOfSemesterPaper.add(new Paper("Anglais",19));
        
        student.setListOfSemesterPaper(listOfSemesterPaper);
        student.calculateMoy();
        listOfStudent.add(student);
        
        
        Student student2=new Student();
        student2.setName("Kyane Kassiri");
        student2.setRollNo("12345");
        student2.setImagePath("images/kyane.jpg");
        
        List <Paper> listOfSemesterPaper2= new ArrayList<>();
        listOfSemesterPaper2.add(new Paper("Sécurité",14));
        listOfSemesterPaper2.add(new Paper("Architecture",14.5));
        listOfSemesterPaper2.add(new Paper("IHM",5));
        listOfSemesterPaper2.add(new Paper("ABDD",13.5));
        listOfSemesterPaper2.add(new Paper("Optimisation",9.75));
        listOfSemesterPaper2.add(new Paper("Anglais",14));
        
        student2.setListOfSemesterPaper(listOfSemesterPaper2);
        student2.calculateMoy();
        listOfStudent.add(student2);
        
        
        Student student3=new Student();
        student3.setName("Skander Mn");
        student3.setRollNo("55421");
        student3.setImagePath("images/skan.jpg");
        
        List <Paper> listOfSemesterPaper3= new ArrayList<>();
        listOfSemesterPaper3.add(new Paper("Sécurité",8));
        listOfSemesterPaper3.add(new Paper("Architecture",7));
        listOfSemesterPaper3.add(new Paper("IHM",15.25));
        listOfSemesterPaper3.add(new Paper("ABDD",11.75));
        listOfSemesterPaper3.add(new Paper("Optimisation",6));
        listOfSemesterPaper3.add(new Paper("Anglais",18));
        
        student3.setListOfSemesterPaper(listOfSemesterPaper3);
        student3.calculateMoy();
        listOfStudent.add(student3);
        
        Student student4=new Student();
        student4.setName("Anas Amara");
        student4.setRollNo("94853");
        student4.setImagePath("images/anas.jpg");
        
        List <Paper> listOfSemesterPaper4= new ArrayList<>();
        listOfSemesterPaper4.add(new Paper("Sécurité",15.5));
        listOfSemesterPaper4.add(new Paper("Architecture",9.5));
        listOfSemesterPaper4.add(new Paper("IHM",12));
        listOfSemesterPaper4.add(new Paper("ABDD",10.5));
        listOfSemesterPaper4.add(new Paper("Optimisation",10));
        listOfSemesterPaper4.add(new Paper("Anglais",17));
        
        student4.setListOfSemesterPaper(listOfSemesterPaper4);
        student4.calculateMoy();
        listOfStudent.add(student4);
      
    }
    
    /*public static List<Student> findStudentByRollNo(String roll, List<Student> l){
            List<Student> list=new ArrayList<>();
            for (Student s: l){
                if (s.getRollNo().equals(roll))
                        list.add(s);
                        
            }
            return list;
            
        }*/
        
        public  List<Student> getStudentList(){
            return listOfStudent;
        }
   }

