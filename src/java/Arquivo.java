import java.io.IOException;
import java.util.Scanner;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;


@Named
@RequestScoped
@ManagedBean(name="arquivoMB")
public class Arquivo {
    private UploadedFile arquivo;
    private String dados;

    public UploadedFile getArquivo() {
        return arquivo;
    }

    public void setArquivo(UploadedFile arquivo) {
        this.arquivo = arquivo;
    }

    public String getDados() {
        return dados;
    }

    public void setDados(String dados) {
        this.dados = dados;
    }
    
    public void upload(FileUploadEvent event) throws IOException {
        
        FacesMessage msg = new FacesMessage("Arquivo importado com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);

        arquivo = event.getFile();

        dados = new Scanner(arquivo.getInputstream(),"UTF-8").useDelimiter("\\A").next();
    }
}
