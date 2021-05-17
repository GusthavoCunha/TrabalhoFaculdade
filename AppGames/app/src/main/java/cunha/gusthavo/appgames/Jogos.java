package cunha.gusthavo.appgames;

public class Jogos {

    public static final int ANO_MINIMO = 2000;

    public int id;
    public static String nome, criador;
    private static int ano;

    public Jogos() {

    }

    public Jogos(String nome, int ano, String criador) {
        this.setNome(nome);
        this.setAno(ano);
        this.setCriador(criador);

    }

    public Jogos(int id, String nome, int ano, String criador) {
        this.id = id;
        this.setNome(nome);
        this.setAno(ano);
        this.setCriador(criador);
    }

    @Override
    public  String toString(){
        return id + " - " + nome + " - " + criador + " | "+ ano;
    }



    public static String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public static int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        if( ano >= Jogos.ANO_MINIMO ){
            this.ano = ano;
        }
    }


    public static String getCriador() {
        return criador;
    }

    public void setCriador(String criador) {
        this.criador = criador;
    }


}






