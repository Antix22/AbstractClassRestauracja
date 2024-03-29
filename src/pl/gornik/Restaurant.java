package pl.gornik;

import org.w3c.dom.ls.LSOutput;
import pl.gornik.dish.Dish;
import pl.gornik.dish.MeatDish;
import pl.gornik.dish.VegetarianDish;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Restaurant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Dish> dishList = new ArrayList<>();
        List<Dish> koszyk = new ArrayList<>();
        Dish meatDish1 = new MeatDish("Tpo", 30, "schabowy, ziemniaki, buraki", "schab");
        Dish meatDish2 = new MeatDish("kebab1", 14, "kurczak, pita, surówki", "kurczak");
        Dish meatDish3 = new MeatDish("kebab2", 16, "wołowina, pita, surówki", "wołowina");
        Dish vegetarianDish = new VegetarianDish("sałatka", 3, "kora, liście, pokrzywy, orzechy");
        dishList.add(meatDish1);
        dishList.add(meatDish2);
        dishList.add(meatDish3);
        dishList.add(vegetarianDish);

        System.out.println("Menu");
        for (Dish dish : dishList) {
            dish.displayInformation();
        }

        String choice;
        boolean isFind = false;





        do{
            System.out.println("podaj nazwę dania");
            String name = scanner.next();
            for (Dish dish : dishList) {
                if (dish.getName().equalsIgnoreCase(name.toLowerCase())) {
                    koszyk.add(dish);
                }
            }


            System.out.println("podaj składniki");
            String components = scanner.next();
            for(Dish zmien : koszyk){
                zmien.changeComponents(components);
            }
            System.out.println("zmieniono składniki na: " + components);
            isFind = true;
            if(isFind)
                System.out.println("czy chcesz dodać kolejny produkt");
            choice = scanner.next();

        }while(choice.equalsIgnoreCase("t"));


        for (Dish wypiszKoszyk : koszyk) {
            wypiszKoszyk.displayInformation();
        }
    }







    }

