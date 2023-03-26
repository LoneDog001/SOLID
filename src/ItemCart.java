import java.util.ArrayList;

public abstract class ItemCart { //Single-responsibility principle
    public static void itemCart (ArrayList <Products> list){
        System.out.println("Вы поместили в корзину" + list);
    }
    abstract void print(ArrayList<Products> list);
}
