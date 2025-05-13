import javax.imageio.IIOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Trip {
    private int price;
    private String country;
    private int numpeople;
    private String duration;

    public Trip(int price, String country, int numpeople, String duration) {
        this.price = price;
        this.country = country;
        this.numpeople = numpeople;
        this.duration = duration;
    }

    public static void writeFile(String content) {
        try {
            FileWriter fw = new FileWriter("output.txt");
            fw.write(content);
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readFile() {
        try (FileReader reader = new FileReader("output.txt")) {
            String result = "";
            int c;
            while ((c = reader.read()) != -1) {
                result += (char) c;
            }
            System.out.println(result);
            return result;
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public static void Start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println("   Welcome to Travel Explorer!");
        System.out.println("======================================");

        System.out.println("1. List");
        System.out.println("2. Log In");
        System.out.println("3. Register");
        System.out.println("4. Exit");
        System.out.print("Enter your choice (1-4): ");

        String choice = scanner.nextLine();

        switch (choice) {

            case "1":
                System.out.println("Redirecting to list...");
                list();
                Start();
            case "2":
                System.out.println("Redirecting to login...");
                login();
                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Start();
            case "3":
                System.out.println("Redirecting to registration...");
                register();
                Start();
            case "4":
                System.out.println("Thank you for using Travel Explorer. Safe travels!");
                break;
            default:
                System.out.println("Invalid choice. Please select a number between 1 and 4.");
        }


        scanner.close();
    }


        public static void register() {
            Scanner sc = new Scanner(System.in);

            System.out.println("=== User Registration ===");
            System.out.println("Enter your name:");
            String name = sc.nextLine();
            System.out.println("Enter your email:");
            String email = sc.nextLine();
            System.out.println("Create your password:");
            String password = sc.nextLine();
            System.out.println("Registration succesful!");
            System.out.println("Welcome, " + name + "!");
            String userdata = "name: " + name + "\nemail: " + email + "\npassword: " + password + "\n";
            writeFile(userdata);
        }

        public static void login() {
            Scanner sc = new Scanner(System.in);
            int i = 0;
            while (i != 1) {
                System.out.println("=== User Log In ===");
                System.out.println("Enter your name:");
                String name = sc.nextLine();
                System.out.println("Enter your email:");
                String email = sc.nextLine();
                System.out.println("Enter your password:");
                String password = sc.nextLine();
                String userdata = "name: " + name + "\nemail: " + email + "\npassword: " + password + "\n";
                if (Trip.readFile().equals(userdata)) {
                    System.out.println("Login succesful");
                    i++;
                } else {
                    System.out.println("Incorrect email or password");
                }
            }
        }

        public static void list(){
        Scanner sc = new Scanner(System.in);
            System.out.println("\nChoose the variant: city, sea, mountain, excursion  ");
            String direction = sc.nextLine();
            while(true) {

                if (direction.equals("sea")) {
                    System.out.println("Choose the variant: Spain, Turkey, Dubai, Sri-Lanka");
                    String choise = sc.nextLine();
                    Sea s1 = new Sea(4000, "Spain", 4, "2 weeks", 24, true);
                    Sea s2 = new Sea(2000, "Turkey", 4, "2 weeks", 28, true);
                    Sea s3 = new Sea(7000, "Dubai", 4, "2 weeks", 32, true);
                    Sea s4 = new Sea(5000, "Sri-Lanka", 4, "2 weeks", 18, true);
                }
                else if (direction.equals("city")) {
                    System.out.println("Choose the variant: Italy, France, Latvija, Greece");
                    String choise = sc.nextLine();
                    City c1 = new City(3000, "Italy", 4, "2 weeks", "hotel");
                    City c2 = new City(4000, "France", 4, "2 weeks", "flat");
                    City c3 = new City(1000, "Latvija", 4, "2 weeks", "hotel");
                    City c4 = new City(5000, "Greece", 4, "2 weeks", "flat");
                }
                else if (direction.equals("mountain")) {
                    System.out.println("Choose the varian: Norwey, Switzerland, Sweden, Finland");
                    String choise = sc.nextLine();
                    Mountain m1 = new Mountain(7000, "Norwey", 4, "2 weeks", "summer", true);
                    Mountain m2 = new Mountain(10000, "Switzerland", 4, "2 weeks", "winter", true);
                    Mountain m3 = new Mountain(6000, "Sweden", 4, "2 weeks", "spring", true);
                    Mountain m4 = new Mountain(8000, "Finland", 4, "2 weeks", "autumn", true);
                }
                else if (direction.equals("excursion")) {
                    System.out.println("Choose the varian: Denmark, Maldive, Ireland, Iceland");
                    String choise = sc.nextLine();
                    Excursion e1 = new Excursion(9000, "Denmark", 4, "2 weeks", "active");
                    Excursion e2 = new Excursion(14000, "Maldive", 4, "2 weeks", "active");
                    Excursion e3 = new Excursion(10000, "Ireland", 4, "2 weeks", "passive");
                    Excursion e4 = new Excursion(7000, "Iceland", 4, "2 weeks", "passive");
                }
                else {
                    System.out.println("Sorry, we don't have it in our list");
                    System.out.println("\nRepeat your choise: ");
                    String choise = sc.nextLine();
                }
            }


    }


            public int getPrice () {
                return price;
            }

            public void setPrice ( int price){
                this.price = price;
            }

            public String getCountry () {
                return country;
            }

            public void setCountry (String country){
                this.country = country;
            }

            public int getNumpeople () {
                return numpeople;
            }

            public void setNumpeople ( int numpeople){
                this.numpeople = numpeople;
            }

            public String getDuration () {
                return duration;
            }

            public void setDuration (String duration){
                this.duration = duration;
            }
        }

