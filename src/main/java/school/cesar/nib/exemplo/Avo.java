package school.cesar.nib.exemplo;

public class Avo extends Object{

    protected void digaOla(){
        System.out.println("Hi");
    }

}

class Pai extends Avo{
}

class Filho extends Pai {

    protected void digaOla(){
        System.out.println("Ola");
    }

    protected void digaOla(String palavra){
        System.out.println("Ola " + palavra);
    }

    protected void digaOla(String nome, String sobrenome){
        System.out.println("Ola, " + nome  +  " " + sobrenome);
    }
}

class Teste{
    public static void main(String[] args) {
        Avo filho = new Filho();
        filho.digaOla();
    }
}