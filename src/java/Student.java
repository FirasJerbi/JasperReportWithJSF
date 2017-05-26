

import com.itextpdf.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author My session
 */
public class Student {
    private String name;
    private String rollNo;
    private String imagePath;
    private List <Paper> listOfSemesterPaper;
    private float moyenne;

    public float getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(float moyenne) {
        this.moyenne = moyenne;
    }
    
    public void calculateMoy(){
        this.moyenne=0;
        listOfSemesterPaper.forEach((p) -> {
            this.moyenne+=p.getMark()/listOfSemesterPaper.size();
        });
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public List<Paper> getListOfSemesterPaper() {
        return listOfSemesterPaper;
    }

    public void setListOfSemesterPaper(List<Paper> listOfSemesterPaper) {
        this.listOfSemesterPaper = listOfSemesterPaper;
    }
    
    public  List<Student> getStudent(){
        List<Student> l=new ArrayList<>();
        l.add(this);
            return l;
        }
    
    public void pdf() throws JRException, IOException {
    //ServletOutputStream servletOutputStream = null;
    FacesContext fc = FacesContext.getCurrentInstance();
    ExternalContext ec = fc.getExternalContext();
    ec.responseReset();
    ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + "report.pdf" + "\"");
    OutputStream output=null;   
        try {
            output = ec.getResponseOutputStream();
        } catch (java.io.IOException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
            JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(getStudent());
            String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reports/ChartReport.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, new HashMap(), beanCollectionDataSource);
            /*HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            //httpServletResponse.addHeader("Content-disposition", "attachment; filename=report.pdf");
        try {
            servletOutputStream = httpServletResponse.getOutputStream();
        } catch (java.io.IOException ex) {
            Logger.getLogger(CompteBean.class.getName()).log(Level.SEVERE, null, ex);
        }*/
            JasperExportManager.exportReportToPdfStream(jasperPrint,output );
            FacesContext.getCurrentInstance().responseComplete();
                       
        }
    
}
