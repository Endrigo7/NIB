package school.cesar.nib.exemplo;

public class MetodosEmPilha {

    public static void main(String[] args) throws Exception{
        MetodosEmPilha metodosEmPilha = new MetodosEmPilha();
        metodosEmPilha.a();
        System.out.println("fim tudo oq eu tinha que fazer");
    }

    public void a() throws Exception{
        System.out.println("iniciei a");
        b();
        System.out.println("finalizei a");
    }
    public void b() throws Exception {
        System.out.println("iniciei b");
        c();
        System.out.println("finalizei b");
    }
    public void c() throws Exception{
        System.out.println("iniciei c");

            d();

        System.out.println("finalizei c");
        throw new Exception("gerei um erro em c");
    }
    public void d(){
        System.out.println("iniciei d");
        System.out.println("finalizei d");
        throw new RuntimeException("gerei um erro em d");
    }
}
