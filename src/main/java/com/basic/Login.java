/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basic;

import com.database.MysqlDataBase;
import com.entities.user.User;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author AliekhandroDelRio
 */
@Path("/login")
public class Login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(User user) throws IOException {
        if (testCreadentials(user.getEmail(), user.getPassword())) {
            User _user = getUser(user.getEmail());
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File("c:\\user.json"), _user);
            
            String cookieString = new StringBuilder( "email:" )
                    .append( _user.getEmail() )
                        .append( "|password:" )
                            .append( Base64.encodeBase64String(StringUtils.getBytesUtf8(_user.getPassword())) )
                                .toString();
            NewCookie cookie = new NewCookie("pddukraine", cookieString);
            
            return Response.status(201).entity( mapper.writeValueAsString(_user) ).cookie( cookie ).build();
        } else {
            return Response.status(401).entity( "Not found" ).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserO(@CookieParam("pddukraine")String cookie) {
        String[] strings = cookie.split("\\|");
        String email = strings[ 0 ].substring(strings[ 0 ].indexOf(":") + 1, strings[ 0 ].length());
        String password = StringUtils.newStringUtf8(Base64.decodeBase64(strings[ 1 ].substring(strings[ 1 ].indexOf(":") + 1, strings[ 1 ].length())));
        
        User user = getUser(email);
        
        return  user.getPassword().equals(password) ? user : new User();
    }

    private User getUser(String email) {
        try {
            String query = new StringBuilder("SELECT * FROM users WHERE users.email=\"").append(email).append("\"").toString();

            ResultSet rs = MysqlDataBase.getInstance().select(query).afterExecution();
            User user = null;
            if (rs.next()) {
                user = new User(rs.getInt(1), rs.getString(2), rs.getString(5), rs.getString(3), rs.getString(4));
            }
            return user;
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    private boolean testCreadentials(String email, String password) {
        User user = getUser(email);
        return user != null ? user.getPassword().equals(password) : false;
    }
}
