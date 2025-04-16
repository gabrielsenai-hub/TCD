public class Loja {

    public static void main(String[] args) {

        
        Capa capa = new Capa("Verde", "Inox", 250);

        Celular celular = new Celular("Iphone", "Cinza", "S25", 1500, capa);
                
        celular.calcularTotal();

    }

}
