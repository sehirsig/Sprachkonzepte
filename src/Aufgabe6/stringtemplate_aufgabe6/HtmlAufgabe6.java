package Aufgabe6.stringtemplate_aufgabe6;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupFile;

import java.lang.reflect.Method;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class HtmlAufgabe6 {
    private HtmlAufgabe6() { }

    public static void main(String[] args) throws Exception {

        String[] classes = new String[] {"java.lang.String", "java.util.Iterator", "java.time.Month"};
        LinkedList<JavaApi> javaApis = new LinkedList<>();
        for (String e : classes) {
            javaApis.add(new JavaApi(e));
        }

        ST templ = new STGroupFile("Aufgabe6/stringtemplate_aufgabe6/aufgabe6.stg").getInstanceOf("aufgabe6");

        templ.add("n", javaApis);

        String result = templ.render();
        System.out.println(result);
    }
}

final class interfaces {
    public String interfaceName;
    public ArrayList<String> imethods;

    public interfaces(String interfaceName, ArrayList<String> imethods) {
        this.interfaceName = interfaceName;
        this.imethods = imethods;
    }
}


final class JavaApi {
    public boolean isClass;
    public Class<?> ourClass;

    public String className;

    public ArrayList<interfaces> interfaces;


    public JavaApi(String apiName) {
        try {
            this.ourClass = Class.forName(apiName);
            this.className = this.ourClass.toString();
            this.isClass = !this.ourClass.toString().contains("interface");
            this.interfaces = new ArrayList<>();

            if (isClass) {
                for (var i : this.ourClass.getInterfaces()) {
                    ArrayList<String> methods = new ArrayList<>();
                    for (var m : i.getMethods()) {
                        String buildParameter = "";
                        for (var t :  m.getParameterTypes()) {
                            buildParameter = buildParameter + ", " + t.getName();
                        }
                        methods.add(m.getReturnType().getName() + " " + m.getName() + "(" + buildParameter.replaceFirst(", ", "") + ")");
                    }
                    interfaces.add(new interfaces(i.getName(), methods));
                }

            } else {
                ArrayList<String> methods = new ArrayList<>();
                for (var m : ourClass.getMethods()) {
                    String buildParameter = "";
                    for (var t :  m.getParameterTypes()) {
                        buildParameter = buildParameter + ", " + t.getName();
                    }
                    methods.add(m.getReturnType().getName() + " " + m.getName() + "(" + buildParameter.replaceFirst(", ", "") + ")");
                }
                interfaces.add(new interfaces(ourClass.getName(), methods));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}



