package bean;

import entity.Guran;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CsvRead {
    public List<Guran> read(String path){
        List<Guran> list = new ArrayList<Guran>();
        try{
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            
            String line;
            StringTokenizer token;
            while((line = br.readLine()) != null){
                token = new StringTokenizer(line,",");
                while(token.hasMoreTokens()){
                    Guran guran = new Guran();
                    guran.setId(Integer.parseInt(token.nextToken()));
                    guran.setName(token.nextToken());
                    System.out.println("id : "+guran.getId()+"name"+guran.getName());
                    list.add(guran);
                }
            }
            br.close();
            
        }catch(IOException e){
            e.printStackTrace();
        }
        return list;
    }
}
