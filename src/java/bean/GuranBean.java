package bean;

import ejb.GuranFacade;
import entity.Guran;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.Part;

@Named(value = "guranBean")
@RequestScoped
public class GuranBean {
    private int id;
    private String name;
    private Part file;
    private List<Guran> guranList;
    
    
    @EJB
    GuranFacade gf;
    
    @Inject
    ListManage lm;
     
    public String commit(){
        guranList = lm.getList();
        for(int i = 0; i < guranList.size();i++){
            gf.create(guranList.get(i));
        }
        System.out.println("Commit Successful");
        return "confirmation.xhtml";
    }
    
    public String uploadButton(){
        upload();
        csvRead();
        guranList = lm.getList();
        return "useradd.xhtml";
    }
    
    public String findAllButton(){
        guranList = gf.findAll();
        return "findall.xhtml";
    }
    
    public String remove(Guran guran){
        gf.delete(guran);
        return null;
    }
    
    public void upload(){
        Path path;
        path = Paths.get(System.getProperty("user.home"), "sotsuken", "files", file.getSubmittedFileName());
        lm.setPath(path);
        FileUpload fu = new FileUpload(file,path);
        fu.submit();
    }
    
    public void csvRead(){
        CsvRead cr = new CsvRead();
        lm.setList(cr.read(lm.getPath().toString()));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public List<Guran> getGuranList() {
        return guranList;
    }

    public void setGuranList(List<Guran> guranList) {
        this.guranList = guranList;
    }

    public List<Guran> getAllList() {
        return gf.findAll();
    }
    
    public List<Guran> getAddList(){
        return lm.getList();
    }
    
}
