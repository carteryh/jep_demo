package json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lz.utils.math.DoubleMathUtils;
import com.singularsys.jep.Jep;
import com.singularsys.jep.JepException;
import com.singularsys.jep.PostfixMathCommandI;
import com.singularsys.jep.functions.Power;
import com.singularsys.jep.misc.functions.Case;
import main.java.com.extension.jep.AnnualInterestRate;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import com.lz.data.utils.RateToolUtils;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = Application.class) // 指定spring-boot的启动类
public class ServiceTest {


    public static void main(String[] args) {
//        double carLoanAmount = 40000.00d;
//        double gpsFee = 430d;
//        double secureFee = 3500.00d;
//        double newPrice = carLoanAmount + gpsFee + secureFee;
//        System.out.println(newPrice);
//        double loanAamount = 59000d;
//        int periods = 36;
//        double yearRate = 9d;

        double carLoanAmount = 67900.00d;
        double gpsFee = 3800d;
        double secureFee = 4100.00d;
        double newPrice = carLoanAmount + gpsFee + secureFee;
        System.out.println(newPrice);
        double loanAamount = 86900d;
        int periods = 36;
        double yearRate = 7.125d;


        double yuegong = getMonth(loanAamount, periods, yearRate);
        System.out.println("yuegong : " + yuegong);

        double all = DoubleMathUtils.mul(yuegong, periods);

        int n = periods;

        double yg = 1d;

        double yh = 1d;
        while ((yg - yuegong) <= 0) {
            System.out.println("差额：" + (yuegong - yg));
            double i = yh / 1200;
            yg = (newPrice * i * Math.pow((1 + i), n)) / (Math.pow((1 + i), n) - 1);// 月供
            yg = getMonth(newPrice, periods, yh);// 月供
            yh = yh + 0.01d;
            System.out.println("yg : " + yg);
        }
        System.out.println(yh);

    }

    public static Double getMonth(Double amount, Integer periods, Double yearRate) {
        double a = 0, i = 0;
        int n = 0;
        double c1;
        double c2;

        a = amount;// 总贷款
        n = periods;

        i = DoubleMathUtils.div(yearRate - 0.001d, 1200, 4);
        c2 = (a * i * Math.pow((1 + i), n)) / (Math.pow((1 + i), n) - 1);

        double all = DoubleMathUtils.mul(c2, n);
        return c2; // 161102 向下取整到小数点后两位
    }

    @Test
    public void test2() {
        Jep jep = new Jep();
        try {
//            Jep jep = new Jep();
//            try {
//                if (e.getExpress().contains("len(")) {
//                    String key = e.getExpress().substring(4, e.getExpress().length() - 1);
//                    jep.addVariable(key, maps.get(key));
//                    jep.addFunction("len", new Length());
//
//                    jep.parse(e.getExpress());
//                    Object evaluate = jep.evaluate();
//                    Integer length = (Integer) jep.evaluate();
//                    result.put(e.getFieldCode(), length);
//                }
//            } catch (JepException ex) {
//                ex.printStackTrace();
//                logger.info("表达式计算失败,业务号:{}", appCode);
//            }

//            String key = e.getExpress().substring(4, e.getExpress().length() - 1);
//            jep.addVariable("pow", "pow(2, 2)");

//            jep.addFunction("pow", new Power());
//
//            jep.parse("pow(2, 2)");

//            jep.addFunction("pow", new Power());

            jep.addVariable("yearRate", 0.07);
            jep.addVariable("zero", 0.01);
            jep.addVariable("total", 1200);

            jep.addVariable("amount", 400);
            jep.addVariable("peridos", 3);
            jep.addFunction("pow", new Power());


//            jep.addFunction("switch", new Switch());
//            jep.parse("switch(1, 6)");

            jep.addFunction("case", new Case());
            jep.parse("case(total - amount > 0, true, 4, 2, 7.8)");


//            jep.parse("(amount * ((yearRate - zero) / total) * pow(1 + (yearRate - zero) / total, peridos)) / (pow(1 + (yearRate - zero) / total, peridos) - 1)");
            Object evaluate = jep.evaluate();
            Double length = (Double) jep.evaluate();
            System.out.println(length);
        } catch (JepException ex) {
            ex.printStackTrace();
        }

    }


    @Test
    public void test5() {
//        String score="数学=100,语文=69;英语=70,计算机=90:地理=85,体育=50";
//        String[] scores=score.split("[,;:]");
//        for(String str:scores)
//        {
//            System.out.println(str);
//        }

//        String[] items = e.getExpress().split("[-+*/(),]");


        String regEx = "-";
//        String s = "c:\test.txt";
        String s = "caAppInfo.getaLoanAmount - caAppInfo.getaCarloanAmount - caAppInfo.getaSecureFee";

        Pattern pat = Pattern.compile(regEx);
        Matcher mat = pat.matcher(s);
        boolean rs = mat.find();
        for(int i=1;i<=mat.groupCount();i++){
        System.out.println(mat.group(i));
        }
    }

    @Test
    public void test6() {
        String score = "len(caAppInfo.getaLoanAmount-caAppInfo.getaCarloanAmount-caAppInfo.getaSecureFee)*(caAppInfo.getaCarloanAmount-caAppInfo.getaSecureFee)*0.1";

//        score = "len(caProppserInfo.proppserName)";
//        String score = "caAppInfo.getaLoanAmount - caAppInfo.getaCarloanAmount - caAppInfo.getaSecureFee";
//        String[] scores = score.split("[-+*/()]");
        String[] scores = score.split("[-+*/()]");

        Set<String> variables = new HashSet<String>();
        for (String str : scores) {
            if (StringUtils.isNotBlank(str) && !NumberUtils.isNumber(str)) {
                variables.add(str);
            }
        }

        for (String str : variables) {
//            boolean number = NumberUtils.isNumber(str);
            System.out.println(str);
        }



    }

    @Test
    public void test7() {
//        Map<String, String> objects = JSON.parseObject("[{\"len\": \"com.singularsys.jep.functions.strings.Length\"}]", Map.class);
//        JSONObject jsonObject = JSON.parseObject("{\"len\": \"com.singularsys.jep.functions.strings.Length\"}");
//
//        jsonObject.keySet();


        String[] items = "len(caProppserInfo.proppserName)".split("[-+*/]()");
        Set<String> variables = new HashSet<>();

        JSONObject functionObj = null;
        Set<String> functions = null;
        String type= "{\"len\": \"com.singularsys.jep.functions.strings.Length\"}";
        if (StringUtils.isNotBlank(type)) {
            functionObj = JSON.parseObject(type);
            functions = functionObj.keySet();
        }

        for (String item : items) {
            if (StringUtils.isNotBlank(item) && !NumberUtils.isNumber(item) && !functions.contains(item)) {
                if (StringUtils.isNotBlank(type)) {
                    variables.add(item);
                }
            }
        }

        Jep jep = new Jep();
        try {
//            for (String variable : variables) {
//                jep.addVariable(variable, maps.get(variable));
//            }

            for (String functionName : functions) {
                Class clazz = Class.forName(functionObj.getString(functionName));
                Object o = clazz.newInstance();
                jep.addFunction(functionName, (PostfixMathCommandI)o);
            }

            jep.parse("len(caProppserInfo.proppserName)");
//            Object evaluate = jep.evaluate();
//            Integer length = (Integer) jep.evaluate();
//            result.put(e.getFieldCode(), length);

        } catch (JepException ex) {
            ex.printStackTrace();
//            logger.info("表达式计算失败,业务号:{}", appCode);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
//            logger.info("表达式计算失败,类名查找失败,业务号:{},表达式:{}", appCode, e.getExpress());
        } catch (InstantiationException ex) {

        } catch (IllegalAccessException ex) {

        }


    }

    //自定义函数
    @Test
    public void test8() {
        Jep jep = new Jep();
        try {
//            Jep jep = new Jep();
//            try {
//                if (e.getExpress().contains("len(")) {
//                    String key = e.getExpress().substring(4, e.getExpress().length() - 1);
//                    jep.addVariable(key, maps.get(key));
//                    jep.addFunction("len", new Length());
//
//                    jep.parse(e.getExpress());
//                    Object evaluate = jep.evaluate();
//                    Integer length = (Integer) jep.evaluate();
//                    result.put(e.getFieldCode(), length);
//                }
//            } catch (JepException ex) {
//                ex.printStackTrace();
//                logger.info("表达式计算失败,业务号:{}", appCode);
//            }

//            String key = e.getExpress().substring(4, e.getExpress().length() - 1);
//            jep.addVariable("pow", "pow(2, 2)");

//            jep.addFunction("pow", new Power());
//
//            jep.parse("pow(2, 2)");

//            jep.addFunction("pow", new Power());
//            Object[] args = {86900, 75800, 36, 0.07125};
//            Object[] args = new Object[{"q": 86900, "w": 75800, "e":36, "R":0.07125}];

//            List<Object> args = new ArrayList<>();
//            Map<String, Object> map = new HashMap();
//            map.put("q", 86900);
//            map.put("w", 75800);
//            map.put("e", 36);
//            map.put("r", 0.07125);
//            args.add(map);
//            jep.addVariable("yearRate", 0.07);
//            jep.addVariable("args", map);
//            jep.addVariable("amount", 86900);

//            jep.addVariable("total", 1200);
//
            jep.addVariable("amount", 86900);
//            jep.addVariable("newPrice", 67900 + 4100 + 3800);
            jep.addVariable("q", 67900 );
            jep.addVariable("w", 4100);
            jep.addVariable("r", 3800);

            jep.addVariable("peridos", 36);
            jep.addVariable("yearRate", 0.07125);
//
//
            jep.addFunction("annualInterestRate", new AnnualInterestRate());
            jep.parse("annualInterestRate(amount, q+w+r, peridos, yearRate)");
//            jep.parse("yearRate(amount, newPrice, peridos, yearRate)");


//            jep.addVariable("l", 10);
//            jep.addFunction("square",new Square());
//            jep.parse("square(l)");



//            jep.addFunction("case", new Case());
//            jep.parse("case(total - amount > 0, true, 4, 2, 7.8)");


//            jep.parse("(amount * ((yearRate - zero) / total) * pow(1 + (yearRate - zero) / total, peridos)) / (pow(1 + (yearRate - zero) / total, peridos) - 1)");
//            Object evaluate = jep.evaluate();
            Double length = (Double) jep.evaluate();
            System.out.println(length);
        } catch (JepException ex) {
            ex.printStackTrace();
        }
    }


}
