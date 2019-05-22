package json;//package json;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.lz.data.config.DhbProperties;
//import com.lz.data.dto.crif.CrifApplicationVariables;
//import ProductCodeEnum;
//import com.lz.data.service.FraudDataService;
//import com.lz.data.utils.ObjectToMapUtils;
//import com.singularsys.jep.Jep;
//import com.singularsys.jep.JepException;
//import com.singularsys.jep.functions.strings.Length;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.lang.reflect.InvocationTargetException;
//import java.util.*;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//import java.util.stream.Collectors;
//
////@ContextConfiguration(value = "classpath:config/application.yml")
////@RunWith(SpringJUnit4ClassRunner.class)
////@SpringBootTest(classes = Application.class) // 指定spring-boot的启动类
//public class JsonDiff {
//
//    @Autowired
//    private FraudDataService fraudDataService;
//
//    @Autowired
//    private DhbProperties dhbProperties;
//
////    @Before
////    public void init() {
////        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath*:/config/application.yml");
////        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) classPathXmlApplicationContext.getBean("sqlSessionFactory");
////        SqlSession sqlSession = sqlSessionFactory.openSession();
//////        userDao = sqlSession.getMapper(UserDAO.class);
////        classPathXmlApplicationContext.close();
////    }
//
//
//    @Test
//    public void testt() {
//        JSONArray array = JSON.parseObject(ss, JSONArray.class);
//
//        int temp = -1;
//        for (int i=0; i<array.size(); i++) {
//            JSONObject o = array.getJSONObject(i);
//            if (o.containsKey("shujubao")) {
//                System.out.println(JSON.toJSONString(o));
//                JSONObject oo = new JSONObject();
//                oo.put("yyy", "99999");
//                o.put("shujubao", oo);
////                o.getJSONObject("shujubao").
////                o.getJSONObject("shujubao").put("shujubao", "00000");
//                temp = i;
//            }
//        }
//        //,{"shujubao":{"zd":{"2":"2","5":"2"}
//        System.out.println(array);
//
//        System.out.println("=======");
//        array.remove(temp);
//        JSONObject oo = new JSONObject();
//        oo.put("shujubao", "delete add");
//        array.add(oo);
//        System.out.println(array);
//
//    }
//
//    @Test
//    public void test1() {
////        List<FieldConfig> configList = new ArrayList<>();
////        FieldConfig fieldConfig = new FieldConfig();
////        fieldConfig.setFieldName("aCarloanAmount");
////        fieldConfig.setType("2");
////        configList.add(fieldConfig);
////
////        fieldConfig = new FieldConfig();
////        fieldConfig.setFieldName("aYanbaoTcName");
////        fieldConfig.setType("1");
////        configList.add(fieldConfig);
//
//        Map<String, Object> map = fraudDataService.doJsonDiff("L1903012120001165001");
//        System.out.println(map);
//
//        CrifApplicationVariables crifApplicationVariables = new CrifApplicationVariables();
//
//        try {
//            org.apache.commons.beanutils.BeanUtils.populate(crifApplicationVariables, map);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
////        BeanUtils.copyProperties(map, crifApplicationVariables);
//        System.out.println(crifApplicationVariables);
//    }
//
//    public static void main(String args[]) {
//        try {
//            Jep jep = new Jep();
////            jep.addVariable("a", 1.0);
////            jep.addVariable("m", 2);
////            jep.addVariable("x", 30);
//            jep.addVariable("ss", "000我爱中国!000");
////            jep.parse("sin(x)");
////            double len1 = (double)jep.evaluate();
////            System.out.println(len1);
//
//            //            jep.parse("a*m*((1+m)^n)/((1+m)^n-1)");
////            double mFee = (double) jep.evaluate();
////            System.out.println(mFee);
//
//
////            String expr = "1 + half(2)";
////            Object value;
////
////            System.out.println("Starting CustFunc...");
////            // Add the custom function
////            parser.getFunctionTable().addFunction("half", new Half());
////            Length length = new Length();
////
//            jep.addFunction("len", new Length());
//            jep.parse("len(" + "ss" + ")");
//            Object evaluate = jep.evaluate();
//            if (evaluate.getClass().toString().equals("class java.lang.Integer")) {
//                Integer len1 = (Integer)jep.evaluate();
//                System.out.println(len1);
//            }
//
//            System.out.println(JSON.toJSONString(ObjectToMapUtils.getMap(json)));
//
////            jep.setComponent(new StringFunctionSet());
////            Object helll = new Length().eval("helll");
////            field.getGenericType().toString().equals(
////
////                    "class java.lang.Integer")
////            Class<?> clz = null;
////            try {
////                clz = Class.forName("java.lang.Integer");
////                Object o = clz.newInstance();
////
////                clz len1 = (clz)jep.evaluate();
////                System.out.println(len1);
////            } catch (Exception e) {
////                e.printStackTrace();
////            }
//
//
//
//
//        } catch (JepException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
////            return 0d;
//        }
//
////        Set<Character> characters = sameChar("张杨路10浦号", "浦东南路1号");
////        System.out.println(characters.size());
////        System.out.println(characters.toString());
//    }
//
//    public static Set<Character> sameChar(String before, String after) {
//        int m = before.length();
//        int n = after.length();
//        Set<Character> st = new LinkedHashSet<Character>();
//        for (int i = 0; i < m; i++) {
//            char c1 = before.charAt(i);
//            for (int j = 0; j < n; j++) {
//                char c2 = after.charAt(j);
//                if (c2 == c1) {
//                    st.add(c1);
//                    break;
//                }
//            }
//        }
//        return st;
//    }
//
//    @Test
//    public void testP() {
//        String expression = "-30a+(-6g-4)+-2-91+len(bbb)";
//        //断言数字左边为符号，符号-会出现0次或1次，再出现数字至少一次的数字
//        //或者以符号-开头，后面是数字
//        String reg = "((?<=\\(|-|\\+|/|\\*)-?\\*+)|(^-[0-9]+)";
//        Pattern p = Pattern.compile(reg);
//        Matcher m = p.matcher(expression);
//
//        while (m.find()) {
//            System.out.println(m.group());
//        }
//    }
//
//
//    @Test
//    public void testD() {
//        String[] filterTypes = {ProductCodeEnum.MOBILE_THREE.getCode(), ProductCodeEnum.NET_TIME.getCode(), ProductCodeEnum.NET_STATUS.getCode()};
//        List<String> filterList = Arrays.asList(filterTypes);
//        String[] array = {"201", "202", "203", "205", "288", "259"};
//        List<String> types = Arrays.asList(array);
//
//        if ("00".equals("01")) {
//            types = types.stream().filter(e -> filterList.contains(e)).collect(Collectors.toList());
//        }
//
//
////        Iterator<String> it = types.iterator();
////        while(it.hasNext()){
////            String type = it.next();
////            if(type.equals(ProductCodeEnum.COLLECTION_TIME.getCode())){
////                it.remove();
////                break;
////            }
////        }
//
//        System.out.println(types);
//
//    }
//}
