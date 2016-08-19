/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abds040.fcitc_spark;

import com.abds040.fcitc_spark.coord.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.Request;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.before;
import static spark.Spark.port;
import spark.template.velocity.VelocityTemplateEngine;

/**
 *
 * @author Daniel
 */
public class FCITC_SPARK {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        port (9001);
        // TODO code application logic here
        
        /*before("/login", (request, response) -> {
            System.out.println("Before doLogin");
            return;
        });*/
        
        before("/*", (request, response) -> {
            System.out.println("CheckToken:"+request.splat()[0]);
            if ("login".equalsIgnoreCase(request.splat()[0])) {
                System.out.println("CheckToken skipped for Login");
            } else {
                System.out.println("CheckToken checking the Token in Header");
                boolean authenticated = false;
                // ... check if authenticated
                if (!authenticated) {
                    //halt(401, "You are not welcome here");
                    
                }
            }
        });
        
        
        
        
        post("/login", (req, res) -> {
            try {
                Gson gson = new Gson();
                Map<String,Object> map = gson.fromJson(req.body(), new TypeToken<Map<String,Object>>(){}.getType());
                
                String token = User.logon(map.get("username").toString(), map.get("password").toString());
                if (token == null) {
                    return helperJSONObject(1, ReturnCodes.TC111z_LoginError);
                }
                return helperJSONString(0, "OK", "token", token);
            } catch (FCSException e) {
                return helperJSONObject(2, e.getMessage());
            }
        });
        
        
        get("/posts2", (request, response) -> {
            response.status(200);
            response.type("application/json");
            return new JsonMsg1(1, "0001M");
        },new JsonTransformer());
        get("/posts3/:data", (request, response) -> {
            response.status(200);
            response.type("application/json");
            System.out.println("DEBUG0001:"+request.params("data"));
            System.out.println("DEBUG0002:"+request.params("dat3"));
            System.out.println("DEBUG0003:"+request.headers());  
            return new JsonMsg1(1, "0001M");
        },new JsonTransformer());
        
        get("/posts4/:data", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("hello", req.params("data"));
            ObjectUser user = new ObjectUser();
            user.setName(req.params("data"));
            user.setEmail("ddd");
            user.setId(124124l);
            model.put("user",user);
            System.out.println("DEBUGXXXX:Headers:"+req.headers().toString());
            return new ModelAndView(model, "index.html");
        }, new VelocityTemplateEngine());;
        
        
        get("/posts5/:data", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("hello", request.params("data"));
            ObjectUser user = new ObjectUser();
            user.setName(request.params("data"));
            user.setEmail("ddd");
            user.setId(124124l);
            model.put("user",user);
            
            
            if (!shouldReturnHtml(request)) {
                response.status(200);
                response.type("text/html");
                Map<String, Object> attributes = new HashMap<>();
                //attributes.put("posts", model.getAllPosts());
                VelocityTemplateEngine engine = new VelocityTemplateEngine();
                return engine.render(new ModelAndView(model, "index.html"));
            } else {
                response.status(200);
                response.type("application/json");
                JsonTransformer json = new JsonTransformer();
                return json.render(model);
            }
        });
        
        
        
        get("/*", (req, res) -> {
            return "Wo wollet se no!";
        });
        post("/*", (req, res) -> {
            return "Wo wollet se no!";
        });
    }
    
     private static boolean shouldReturnHtml(Request request) {
        String accept = request.headers("Accept");
        return accept != null && accept.contains("text/html");
    }
    
    private static Map<String,Object> helperJSONObject(int rc, String msg) {
        try {
            Map<String,Object> obj = new HashMap<String,Object>();
            obj.put("rc", rc);
            obj.put("msg", msg);
            return obj;
        } catch (Exception e) {
            return null;
        }
    }
    private static Map<String,Object> helperJSONString(int rc, String msg, String key1, String value1) {
        try {
            Map<String,Object> obj = new HashMap<String,Object>();
            obj.put("rc", rc);
            obj.put("msg", msg);
            obj.put(key1, value1);
            return obj;
        } catch (Exception e) {
            return null;//"{\"rc\":2,\"msg\",\""+msg+"\"}";
        }
    }
     
}
