package basico;
import java.util.ArrayList;
      //banco
public class PavaoPrime implements VideoInterface{

    private ArrayList<Video> midias;
	private int contadorDeVideos;

    public PavaoPrime() {
        midias = new ArrayList<Video>();
		contadorDeVideos = 0;
    }
    
    public boolean criarFilme(String name, double temp, String genre,int year, String nameCast){
        if(name != "" && temp != 0 && year != 0 && nameCast != "" && genre != ""){
            Movie filme = new Movie(name, temp, genre, year, nameCast);
            this.midias.add(filme);
            this.contadorDeVideos++;
            return true;
        }else{
            return false;
        }
    }
    public void informacao(String name){
        if (name != ""){
            for(Video midia: this.midias){
                if(midia.getName() == name){
                   System.out.println(midia.toString());
                }
            }
        }else{
            System.out.println("Mídia não encontrada.");
        }
    }

    public boolean criarSerie(String name, double temp, String genre,int year, String nameCast) {
        if(name != "" && temp != 0 && year != 0 && nameCast != "" && genre != ""){
            Serie serie = new Serie(name, temp, genre, year, nameCast);
            this.midias.add(serie);
            this.contadorDeVideos++;
            return true;
        }else{
            return false;
        }

    }

    

    @Override
    public int getVideos() {
        return this.midias.size();
    }


}