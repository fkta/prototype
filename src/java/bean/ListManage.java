package bean;

import entity.Guran;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.nio.file.Path;
import java.util.List;
import javax.servlet.http.Part;

@Named(value = "listManage")
@SessionScoped
public class ListManage implements Serializable {

    private Part file;
    private Path path;
    private List<Guran> list;

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public List<Guran> getList() {
        return list;
    }

    public void setList(List<Guran> list) {
        this.list = list;
    }
    
    
    
}
