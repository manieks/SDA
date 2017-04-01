package hello;

import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;


@RestController
public class FileController {


    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

   /* @RequestMapping("/gre")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/gr/{name}")
    public Greeting greeting2(@PathVariable String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }*/

    private String content;
    @RequestMapping(path = "/files", method = {RequestMethod.POST})
  // to wysyła parametr a nie body  public String zapis(@RequestParam(value = "lineToSave") String lineToSave) throws IOException{
        public String zapis(@RequestBody String lineToSave) throws IOException{
        content = lineToSave;
        File file = new File("test.txt");
        Writer writer = new FileWriter(file, true);  // mozna tu wyzerowac plik false
        writer.write(lineToSave+ System.lineSeparator());
        writer.flush();
        return "zapisano";
    }


    @RequestMapping(path = "/files", method = {RequestMethod.GET})
    public ArrayList<String> odczyt () throws IOException {
        File file = new File("test.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line ;
        ArrayList<String> list = new ArrayList<String >();
        while ((line = reader.readLine())!=null){
            list.add(line);
        }
        return list;
    }

    public static void main(String[] args) throws IOException {
        File file = new File("test.txt");


        try (Writer writer = new FileWriter(file);

             BufferedReader reader = new BufferedReader(new FileReader(file))) {
            writer.write(System.lineSeparator() + "Stringi22");
            writer.flush();
            System.out.println(reader.readLine());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }


}