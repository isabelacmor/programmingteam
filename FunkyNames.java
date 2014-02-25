import java.util.*;

public class FunkyNames{

    public static void main(String [] args)
    {
        String [] aFirst = {"Astronomical", "Angelic", "Azure", "Awesome", "Adamant", "Avuncular", "Acrimonious"};
        String [] bFirst = {"Boisterous", "Bodacious", "Blissful", "Burnt", "Brilliant", "Brackish", "Belligerent"};
        String [] cFirst = {"Courageous", "Creative", "Curvaceous", "Capricious", "Crisp", "Cryptic", "Captivating"};
        String [] dFirst = {"Decadent", "Delicious", "Distracting", "Dreadful", "Daring", "Demonic", "Discordant"};
        String [] eFirst = {"Edgy", "Eccentric", "Exhaustive", "Exotic", "Excellent", "Efficacious", "Effervescent"};
        String [] fFirst = {"Fickle", "Factious", "Flamboyant", "Fabulous", "Furious", "Furtive", "Flirtatious"};
        String [] gFirst = {"Gregarious", "Gallant", "Gentle", "Graceful", "Gifted", "Gorgeous", "Gory"};
        String [] hFirst = {"Courageous", "Creative", "Curvaceous", "Capricious", "Crisp", "Cryptic", "Captivating"};
        
        String [] aLast = {"Anchor", "Almond", "Alligator", "Asteroid", "Athlete", "Atom", "Artist"};
        String [] bLast = {"Baboon", "Brazilian", "Banana", "Biscuit", "Berry", "Boomerang", "Bullet"};
        String [] cLast = {"Cat", "Cow", "Candy", "Cereal", "Coffee", "Camel", "Canadian"};
        String [] dLast = {"Dracula", "Dancer", "Deoderant", "Devil", "Doggie", "Doctor", "Drums"};
        String [] eLast = {"Elephant", "Eagle", "Einstein", "Elf", "Elk", "Emu", "Executioner"};
        String [] fLast = {"Feather", "Farmer", "Fairy", "Flipper", "Fly", "Flamingo", "Fox"};
        String [] gLast = {"Gold", "Groom", "Grumbler", "Gorilla", "Grape", "Germ", "Gem"};
        String [] hLast = {"Hamburger", "Horse", "Hero", "Hacker", "Helper", "Hawk", "Hugger"};
        
        String name;
        String [] names = new String[2];
        Random rand = new Random();
        String firstNew = "";
        String lastNew = "";
        String arrayChoice;
                
        Scanner in = new Scanner(System.in);
        
        System.out.println("Please enter your first and last name to generate a new funky name! \n Name: ");
        name = in.nextLine();        
        names = name.split(" ");
        
        int randFirst = rand.nextInt(6);
       
        if(names[0].substring(0, 1).equalsIgnoreCase("a")){ firstNew += aFirst[randFirst]; }      
        else if(names[0].substring(0, 1).equalsIgnoreCase("b")){ firstNew += bFirst[randFirst]; }      
        else if(names[0].substring(0, 1).equalsIgnoreCase("c")){ firstNew += cFirst[randFirst]; }      
        else if(names[0].substring(0, 1).equalsIgnoreCase("d")){ firstNew += dFirst[randFirst]; }      
        else if(names[0].substring(0, 1).equalsIgnoreCase("e")){ firstNew += eFirst[randFirst]; }      
        else if(names[0].substring(0, 1).equalsIgnoreCase("f")){ firstNew += fFirst[randFirst]; }      
        else if(names[0].substring(0, 1).equalsIgnoreCase("g")){ firstNew += gFirst[randFirst]; }      
        else if(names[0].substring(0, 1).equalsIgnoreCase("h")){ firstNew += hFirst[randFirst]; }      
        else{firstNew = "" ;}
        
        int randLast = rand.nextInt(6);

        if(names[1].substring(0, 1).equalsIgnoreCase("a")){ lastNew += aLast[randLast]; }      
        else if(names[1].substring(0, 1).equalsIgnoreCase("b")){ lastNew += bLast[randLast]; }      
        else if(names[1].substring(0, 1).equalsIgnoreCase("c")){ lastNew += cLast[randLast]; }      
        else if(names[1].substring(0, 1).equalsIgnoreCase("d")){ lastNew += dLast[randLast]; }      
        else if(names[1].substring(0, 1).equalsIgnoreCase("e")){ lastNew += eLast[randLast]; }      
        else if(names[1].substring(0, 1).equalsIgnoreCase("f")){ lastNew += fLast[randLast]; }      
        else if(names[1].substring(0, 1).equalsIgnoreCase("g")){ lastNew += gLast[randLast]; }      
        else if(names[1].substring(0, 1).equalsIgnoreCase("h")){ lastNew += hLast[randLast]; }      
        else{lastNew = "";}
          
        System.out.println("Your new funky name is: " + firstNew + " " + lastNew);
    }

}