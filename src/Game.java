import java.util.*;

public class Game {
    //BLACK DISCIPLE DUNGEON GAMES CHEATCODES
    static boolean isUntouchable = false;

    static  String Cheats;
    static int monster_health;
 static int Monster;

    static int Health = 100;
    static int Gold = 50;
    static ArrayList<String> inventory = new ArrayList<>();
    static ArrayList<String> active_effect = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static String Gametag;
    static int monsterDamage;

    public static void main(String[] args) {

        System.out.println("BLACK DISCIPLES DUNGEON GAME");
        System.out.println("Create Game Name\n");

        inventory.add("sword");

        Gametag = scanner.nextLine();
        displayStatus();


        int choice ;

        while (Health > 0) {
            System.out.println("\n......SELECT EVENT.......");
            System.out.println("1.[MONSTER]");
            System.out.println("2.[CHEST]");
            System.out.println("3.[NOTHING]");
            int selection = scanner.nextInt();
            scanner.nextLine();

            if (selection == 1) {
                battle_monster();
            } else if (selection == 2) {
                open_chest();
            } else {
                System.out.println("...ROOM IS EMPTY...");
                displayStatus();
                System.out.println("1.[CONTINUE]\n2.[USE ITEM]\n3.[QUIT]");
                choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 2) {
                    use_item();
                } else if (choice == 3) {
                    System.out.println("YOU LEAVE THE DUNGEON WITH YOUR LOOT");
                    break;
                }
            }
        }
    }

    static void battle_monster() {
        System.out.println("...CHOOSE MONSTER...");
        System.out.println("1.[ZUKI]\n2.[TUM]\n3.[ODEE]");
        Monster = scanner.nextInt();
        scanner.nextLine();

        Random rand = new Random();
        monster_health = rand.nextInt(21) + 20;

        while (monster_health > 0 && Health > 0) {
            String select = scanner.nextLine();
                Cheats = select.toLowerCase();
                CheatCodes();
                continue;
            }


            if (select.equals("1")) {
                int damage = rand.nextInt(11) + 5;
                if (active_effect.contains("amulet")) {
                    damage += 5;
                    active_effect.remove("amulet");
                }
                monster_health -= damage;



                if (monster_health > 0) {
                    monsterDamage = 5 + rand.nextInt(8);
                    if (isUntouchable) {
                        System.out.println("You are UNTOUCHABLE! " + MonsterName() + " cannot harm you.");
                    }else if (active_effect.contains("shield")) {
                        System.out.println("Your shield blocked the attack!");
                        active_effect.remove("shield");
                    } else {
                        Health -= monsterDamage;


                    }
                }
            } else if (select.equals("2") ) {
                System.out.println("...YOU RUN AWAY SAFELY...");
                return;
            }
        }

        if (Health <= 0) {
            System.out.println("GAME OVER!");
        } else {
            int reward = rand.nextInt(21) + 10;
            Gold += reward;
            System.out.println("You defeated " + MonsterName() + " and earned " + reward + " gold!");
        }
    }

    static void open_chest() {
        Random rand = new Random();
        String[] items = {"potion", "shield", "amulet"};
        String reward = items[rand.nextInt(items.length)];
        inventory.add(reward);
        System.out.println("You found a " + reward + " in the chest!");
    }

    static void use_item() {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty!");
            return;
        }

        System.out.println("Your inventory: " + inventory);
        System.out.print("Which item do you want to use? ");
        String item = scanner.nextLine();

        if (!inventory.contains(item)) {
            System.out.println("You don’t have that item!");
            return;
        }
        switch (item) {
            case "potion":
                Health += 20;
                inventory.remove("potion");
                break;
            case "shield":
                active_effect.add("shield");
                inventory.remove("shield");
                System.out.println("You have activated your shield. It will block the next attack.");
                break;
            case "amulet":
                active_effect.add("amulet");
                inventory.remove("amulet");
                System.out.println("The amulet glows... It will boost your next attack!");
                break;
            default:
                System.out.println("That item cannot be used.");
        }
    }
    static void CheatCodes(){
        if(Cheats.equals("nuski")) {
            Health = 100;
            System.out.println("Cheat Code Activated"+"\nRevival!"+"Your Health is restored to "+Health);
        }else if(Cheats.equals("rotwithmy9mm")){
            monster_health=0;
            System.out.println("Cheat Code Activated"+"\nDoom Spree!"+"\nYou killed the Monster Mercilessly");

        }else if (Cheats.equals("vonski")) {
            isUntouchable = true;
            System.out.println("Cheat Code Activated: Untouchable! No monster can harm you.");




    }

    static String MonsterName() {
        if (Monster == 1) {
            return "Zuki";
        }else if(Monster==2){
            return "Tum";
        }else if (Monster==3){
            return "Odee";
        }
        return "UNKNOWN MONSTER";
    }
    static void displayStatus() {
        System.out.println("\n== STATUS ==");
        System.out.println("Profile name:"+Gametag);
        System.out.println("Gold: " + Gold);
        System.out.println("Inventory: " + inventory);
        System.out.println("Active Effects: " + active_effect);

    }
}