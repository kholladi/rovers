import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Reader{


    public Reader() {
    }

    /*
    Read file, and add evry rover on list
     */
    public void runRovers() throws Exception {

        String position [];
        List <Rover> rovers = new ArrayList<Rover>();

        URL res = getClass().getClassLoader().getResource("input.txt");
        File file = Paths.get(res.toURI()).toFile();
        String absolutePath = file.getAbsolutePath();
        java.io.Reader reader = new FileReader(absolutePath);
        BufferedReader bufferedReader = new BufferedReader(reader);


        String line = bufferedReader.readLine();

        String [] max = line.split(" ");
        String xMax = max[0];
        String yMax = max[1];
        line = bufferedReader.readLine();

        while(line != null) {
            Rover r = new Rover();
            position = line.split(" ");
            r.setX(Integer.parseInt(position[0]));
            r.setY(Integer.parseInt(position[1]));
            r.setDirection(position[2]);
            r.setInstructions(bufferedReader.readLine());
            // add rover on list
            rovers.add(r);

            line = bufferedReader.readLine();
        }

        //close buffer
        bufferedReader.close();

        treatment(xMax,yMax,rovers);
    }

    /*
    When L OR R get new direction otherwise get new position
     */
    public void treatment (String xMax, String yMax, List <Rover> rovers) throws Exception{
        for (Rover rover: rovers) {
            for (int i = 0; i < rover.getInstructions().length(); i++) {
                char charInstruction = rover.getInstructions().charAt(i);
                String instruction = new StringBuilder().append("").append(charInstruction).toString();
                if (!Action.M.toString().equalsIgnoreCase(instruction)){
                    rover.getDirection(rover.getDirection(), instruction);
                }else{
                    rover.getPosition(rover.getDirection(), Integer.parseInt(xMax), Integer.parseInt(yMax));
                }
            }

            System.out.println(rover.getX()+" "+rover.getY()+" "+rover.getDirection());
        }
    }

}
