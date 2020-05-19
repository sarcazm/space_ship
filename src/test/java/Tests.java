import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Test;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;


public class Tests {
    @Test
    public void testimDate() throws MalformedURLException {
        String countBy = "{\"name\":\"Petya\"}";
        URL url = new URL("http://localhost:8080/ships/count?name=tra3000");
        String param = url.getQuery().substring(0, url.getQuery().indexOf('='));
        System.out.println("param = " + param);
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = (JsonObject) parser.parse(countBy);
        System.out.println(jsonObject);
        System.out.println(jsonObject.get("name"));
        String data = String.valueOf(jsonObject.get("name"));
        System.out.println("data = " + data);

    }

    @Test
    public void testDate(){
        GregorianCalendar calendar1 = new GregorianCalendar();
        GregorianCalendar calendar2 = new GregorianCalendar();
        calendar1.set(2800,1,1);
        System.out.println(calendar1.getTimeInMillis());
        calendar2.set(3019,1,1);
        System.out.println(calendar2.getTimeInMillis());

    }

    @Test
    public void containsSimbolsInString(){
        String str = "Левиафан";
        System.out.println(str.contains("иа"));
    }


    @Test
    public void test1(){
        Map<String, String> allParam = new LinkedHashMap<>();
        allParam.put("name", "tratata");
        allParam.put("speed", "0.5");
        Set<String> set = allParam.keySet();
        Collection<String> list =  allParam.values();
        List<String> list1 = new ArrayList<String>(list);
        System.out.println(set);
        System.out.println(list1);
    }


    @Test
    public void identityHashMap(){
        // Creating HashMap and IdentityHashMap objects
        Map hm = new HashMap();
        Map ihm = new IdentityHashMap();

        hm.put("hmkey","hmvalue");
        hm.put(new String("hmkey"),"hmvalue1");

        System.out.println("hmkey = " + "hmkey".hashCode());
        System.out.println("new String hmkey = " + new String("hmkey").hashCode());

        ihm.put("ihmkey","ihmvalue");
        ihm.put(new String("ihmkey"),"ihmvalue1");

        System.out.println("ihmkey" == new String("ihmkey"));

        System.out.println("Size of HashMap--"+hm.size());
        System.out.println("Size of IdentityHashMap--"+ihm.size());

        System.out.println("ihm.get(\"ihmkey\") = " + ihm.get("ihmkey"));

    }
}
