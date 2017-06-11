/**
 * Created by NGO QUOC TRUNG-MSSV:51503026
 */
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileNotFoundException;
import  java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
public class Main {
    public static void main(String[] args) {
        // Fill in the code for the main() method
        try {
            String remember="";
            String sNewLine;
            String file = "dsa_input_assign1.txt";
            FileInputStream fi=new FileInputStream(file);
            InputStreamReader reader =new InputStreamReader(fi,"UTF-8");
            BufferedReader breader=new BufferedReader(reader);
            FileOutputStream fo=new FileOutputStream("dsa_input_assign1.out");
            OutputStreamWriter OutWriter =new OutputStreamWriter(fo,"UTF-8");

            while((sNewLine=breader.readLine())!=null)
            {
                remember=remember+sNewLine+"\r\n";
            }fi.close();
            String number="([0-9]+([0-9]+)*((\\.*[0-9]*)+)*)";
            String date="([0-9]+[/][0-9]+)";
            String url="(http[s]*://)(([a-zA-Z_0-9]*[.%-]*[a-zA-Z_0-9]*)+([.%-/]+)*([a-zA-Z_0-9]*[.%-]*[a-zA-Z_0-9]*)*)*";
            String phone="[0][0-9]{5,11}";
            Object output=null;
            String temp;
            int p;
            int i=0;
            String line;
            line=remember;
            Pattern num=Pattern.compile(number);
            Pattern ur=Pattern.compile(url);
            Pattern da=Pattern.compile(date);
            Pattern pho=Pattern.compile(phone);
            String result[] = line.split("[ ]");
            //Matcher d=da.matcher(result);
            for (String item:result)
            {i=i+1;
                Matcher m = num.matcher(item);
                Matcher d=da.matcher(item);
                Matcher u=ur.matcher(item);
                Matcher ph=pho.matcher(item);
                if (i==1) {

                }

                if (u.find())
                {
                    temp=u.replaceAll(u.group()+ "[URL]");
                    if ((result.length)==i)
                    {
                        output=output+temp;
                    }
                    else
                    {
                        output=output+temp+" ";
                    }
                }
                else if (ph.find())
                {
                    temp=ph.replaceAll(ph.group()+"[PHONE]");

                    if ((result.length)==i)
                    {
                        output=output+temp;
                    }
                    else
                    {
                        output=output+temp+" ";
                    }
                }
                else if(d.find())
                {
                    temp=d.replaceAll("$1[DATE]");
                    if ((result.length)==i)
                    {
                        output=output+temp;
                    }
                    else
                    {
                        output=output+temp+" ";
                    }
                }
                else if (m.find())
                {
                    temp=m.replaceAll("$1[NUMBER]");
                    if ((result.length)==i)
                    {
                        output=output+temp;
                    }
                    else
                    {
                        output=output+temp+" ";
                    }
                }
                else
                {
                    if ((result.length)==i)
                    {
                        output=output+item;
                    }
                    else if (i==1)
                    {
                        output=item;
                    }
                    else
                    {
                        output=output+item+" ";
                    }

                }
            }
            OutWriter.write(output.toString());
            OutWriter.flush();
            fo.close();
        }
        catch(Exception e) {

            //e.printStackTrace();
        }
    }
}
