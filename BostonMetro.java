import java.util.*;

public class BostonMetro {


    private MultiGraph multigraph;


    public void run() {

        String userInput = "";
        Scanner scanner = new Scanner(System.in);
        Node departureStation;
        Node destinationStation;
        List<Node> route;


        try {
            MetroMapParser parser = new MetroMapParser("src/bostonmetro.txt");
            multigraph = parser.generateGraphFromFile();


            while (true) {
                System.out.println("Please enter the departure station");
                userInput = scanner.nextLine();

                if(((departureStation=getInput(userInput))== null)){
                    System.out.println("Error : No station found");
                    continue;
                }

                System.out.println("Please enter your destination station");
                userInput = scanner.nextLine();

                if(((destinationStation=getInput(userInput))== null)){
                    System.out.println("Error : No station found");
                    continue;
                }

                if (departureStation.equals(destinationStation)) {
                    System.out.println("Departure and destination station are the same");
                    continue;
                }
                route = multigraph.getroute(departureStation, destinationStation);
                if (route == null) {
                    System.out.println("Error :No route found");
                    continue;
                } else {




                    System.out.println("Route starting from: ");

                   List<String> routeLineName = new ArrayList<>();
                   for (int i =0; i< route.size()-1;i++){
                       routeLineName.add(multigraph.getEdge(route.get(i),route.get(i+1)).getLabel());
                   }
                    System.out.println(route.get(route.size()-1).getLabel());
                    for (int i = route.size()-2; i >=1; i--) {
                            System.out.println(" to ");
                            System.out.println(route.get(i).getLabel());
                        if (!routeLineName.get(i).equals(routeLineName.get(i-1))){
                         System.out.print("*CHANGE TO LINE " + routeLineName.get(i-1)+ " * ");
                        }


                    }
                    System.out.println("Reaching your destination at " + route.get(0).getLabel() + " on line " + routeLineName.get(0));

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Node getInput(String input){
        Node station;
        if (input.equalsIgnoreCase("quit")){
            System.out.println("Now exiting the Route Finder");
            System.exit(0);

        }
        if (input.equalsIgnoreCase("st.paulstreet")) {
            station=stPauls();

        }
        else {
            station = multigraph.getNodeFromName(input);


        }
        return station;
    }

    public Node stPauls() {
        Node station = null;
        String userInput;
        Scanner scanner = new Scanner(System.in);
        char userInputChar;
        System.out.println("There are two St.PaulStreet Stations");
        System.out.println("Please select the option of the station you are looking for");
        System.out.println("Type b for St.PaulStreet on Line GreenB");
        System.out.println("or c for St.PaulStreet on Line GreenC");
        userInput = scanner.nextLine();
        userInputChar = userInput.charAt(0);
        System.out.println(userInputChar);
        while (userInputChar !='b' && userInputChar !='c'){
            System.out.println("Invalid option. Please choose b or c");
            userInput = scanner.nextLine();
            userInputChar = userInput.charAt(0);


        }
        userInputChar=userInput.charAt(0);
        if (userInputChar ==('b')){
            station = multigraph.getNode(38);
        }
        else if (userInputChar == ('c')){
            station = multigraph.getNode(61);
        }


        return station;
    }

}